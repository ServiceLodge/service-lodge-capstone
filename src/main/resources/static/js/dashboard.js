window.onload = function () {

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
                { x: new Date(2023, 2, 0), y: 0 },
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
                    { x: new Date(2023, 1, 0), y: 5 },
                    { x: new Date(2023, 2, 0), y: 4 },
                    { x: new Date(2023, 3, 0), y: 2 },
                    { x: new Date(2023, 4, 0), y: 1 },
                    { x: new Date(2023, 5, 0), },
                    { x: new Date(2023, 6, 0), },
                    { x: new Date(2023, 7, 0), },
                    { x: new Date(2023, 8, 0), },
                    { x: new Date(2023, 9, 0), },
                    { x: new Date(2023, 10, 0), },
                    { x: new Date(2023, 11, 0), },
                    { x: new Date(2023, 12, 0), },
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