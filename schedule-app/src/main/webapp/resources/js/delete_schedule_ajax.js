jQuery(document).ready(function($) {
    $("#schedule_to_delete").click(function(event) {

        // Prevent the form from submitting via the browser.
        event.preventDefault();
        deleteViaAjax();
    });
});

function deleteViaAjax() {
    var id = $(".schedule_to_delete").id;

    $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/admin/delete?id=7",
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            window.location("/deleteSchedule");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}