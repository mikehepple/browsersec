$('#cors-lesson-2-asterisk-cors-btn').click(function () {
    $.get("{{secondaryFullHost}}/cors/the_date_cors_asterisk",
        function (data) {
            $("#lesson2_asterisk_result").text("😃: "+ data);
        }).fail(function(xhr, textStatus) {
        $("#lesson2_asterisk_result").text("😫: "+ textStatus);
    })
});