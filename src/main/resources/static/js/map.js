mapboxgl.accessToken = MAPBOX_KEY;
const address = document.querySelector('#adr').textContent.split(' ').join('%20');

const getGeoCode = async (pin) => {
    try {
        const res = await fetch(`https://api.mapbox.com/geocoding/v5/mapbox.places/${address}.json?limit=1&proximity=ip&types=place%2Cpostcode%2Caddress&access_token=${mapboxgl.accessToken}`);
        const data = await res.json();
        return data['features'][0].center;
    } catch (e) {
        console.log('ERROR:', e);
    }
}

const map = async () => {
    const lngLat = await getGeoCode(address);

    const map = new mapboxgl.Map({
        container: 'map', // container ID
        style: 'mapbox://styles/mapbox/navigation-day-v1', // style URL
        center: lngLat, // starting position [lng, lat]
        zoom: 10, // starting zoom
        projection: 'globe' // display the map as a 3D globe
    });

    map.addControl(
        new MapboxGeocoder({
            accessToken: mapboxgl.accessToken,
            mapboxgl: mapboxgl
        })
    );

    // Set marker options.
    const marker = new mapboxgl.Marker({
        color: "#5DD7AD",
    }).setLngLat(lngLat)
        .addTo(map);
}
map();