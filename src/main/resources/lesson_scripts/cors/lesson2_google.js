$('#cors-lesson-2-google-cors-btn').click(function () {
    $.get("{{secondaryFullHost}}/cors/the_date_cors_google",
        function (data) {
            $("#lesson2_google_result").text("😃: "+ data);
        }).fail(function(xhr, textStatus) {
        $("#lesson2_google_result").text("😫: "+ textStatus);
    })
});