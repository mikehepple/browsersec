$('#cors-lesson-1-btn').click(function () {
    $.get("{{secondaryFullHost}}/cors/the_date",
        function (data) {
        $("#lesson1_result").text("😃: "+ data);
    }).fail(function(xhr, textStatus) {
        $("#lesson1_result").text("😫: "+ textStatus);
    })
});