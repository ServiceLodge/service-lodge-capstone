const trigger = document.getElementById('scheduler');
trigger.addEventListener('click', (e) => {
    atcb_action({
        name: trigger.dataset.hotel,
        startDate: trigger.dataset.start,
        endDate: trigger.dataset.end,
        startTime: "16:00",
        endTime:"11:00",
        location: trigger.dataset.address,
        options: ["Apple", "Google", "iCal", "Microsoft365", "Outlook.com", "MicrosoftTeams"],
        timeZone: "America/Chicago",
        listStyle: "modal",
        iCalFileName: "Reservation",
    }, trigger);
});