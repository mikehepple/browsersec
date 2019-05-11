$('#cors-lesson-2-btn').click(function () {
    $.get("{{secondaryFullHost}}/cors/the_date",
        function (data) {
            $("#lesson2_result").text("😃: "+ data);
        }).fail(function(xhr, textStatus) {
            $("#lesson2_result").text("😫: "+ textStatus);
    })
});
$('#cors-lesson-2-btn-with-cors').click(function () {
    $.get("{{secondaryFullHost}}/cors/the_date_cors",
        function (data) {
            $("#lesson2_result").text("😃: "+ data);
        }).fail(function(xhr, textStatus) {
        $("#lesson2_result").text("😫: "+ textStatus);
    })
});