window.onload = function () {
    let monthlyData = [
        parseInt(document.querySelector("#data").getAttribute("data-jan")),
        parseInt(document.querySelector("#data").getAttribute("data-feb")),
        parseInt(document.querySelector("#data").getAttribute("data-mar")),
        parseInt(document.querySelector("#data").getAttribute("data-apr")),
        parseInt(document.querySelector("#data").getAttribute("data-may")),
        parseInt(document.querySelector("#data").getAttribute("data-jun")),
        parseInt(document.querySelector("#data").getAttribute("data-jul")),
        parseInt(document.querySelector("#data").getAttribute("data-aug")),
        parseInt(document.querySelector("#data").getAttribute("data-sep")),
        parseInt(document.querySelector("#data").getAttribute("data-oct")),
        parseInt(document.querySelector("#data").getAttribute("data-nov")),
        parseInt(document.querySelector("#data").getAttribute("data-dec"))
    ]


    var chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title:{
            text: "Hotel Usage"
        },
        axisX:{
            valueFormatString: "MMM YYYY",
            crosshair: {
                enabled: true,
                snapToDataPoint: true
            }
        },
        axisY: {
            title: "Member Activity",
            includeZero: true,
            crosshair: {
                enabled: true
            }
        },
        toolTip:{
            shared:true
        },
        legend:{
            cursor:"pointer",
            verticalAlign: "bottom",
            horizontalAlign: "left",
            dockInsidePlotArea: true,
            itemclick: toogleDataSeries
        },
        data: [{
            type: "line",
            showInLegend: true,
            name: "Cancellations",
            markerType: "square",
            lineDashType: "dash",
            xValueFormatString: "DD MMM, YYYY",
            color: "#F08080",
            dataPoints: [
                { x: new Date(2023, 1, 0), y: 1 },
                { x: new Date(2023, 2, 0), y: 1 },
                { x: new Date(2023, 3, 0), y: 1 },
                { x: new Date(2023, 4, 0), y: 0 },
                { x: new Date(2023, 5, 0), },
                { x: new Date(2023, 6, 0), },
                { x: new Date(2023, 7, 0), },
                { x: new Date(2023, 8, 0), },
                { x: new Date(2023, 9, 0), },
                { x: new Date(2023, 10, 0), },
                { x: new Date(2023, 11, 0), },
                { x: new Date(2023, 12, 0), },
            ]
        },
            {
                type: "line",
                showInLegend: true,
                name: "Reservations",
                dataPoints: [
                    { x: new Date(2023, 1, 0), y: monthlyData[0] },
                    { x: new Date(2023, 2, 0), y: monthlyData[1] },
                    { x: new Date(2023, 3, 0), y: monthlyData[2] },
                    { x: new Date(2023, 4, 0), y: monthlyData[3] },
                    { x: new Date(2023, 5, 0), y: monthlyData[4] },
                    { x: new Date(2023, 6, 0), y: monthlyData[5] },
                    { x: new Date(2023, 7, 0), y: monthlyData[6] },
                    { x: new Date(2023, 8, 0), y: monthlyData[7] },
                    { x: new Date(2023, 9, 0), y: monthlyData[8] },
                    { x: new Date(2023, 10, 0), y: monthlyData[9] },
                    { x: new Date(2023, 11, 0), y: monthlyData[10] },
                    { x: new Date(2023, 12, 0), y: monthlyData[11] },
                ]
            }]
    });
    chart.render();

    function toogleDataSeries(e){
        if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
            e.dataSeries.visible = false;
        } else{
            e.dataSeries.visible = true;
        }
        chart.render();
    }

}