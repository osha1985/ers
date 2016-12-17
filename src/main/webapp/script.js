/**
 * Created by yehur on 12/15/2016.
 */
$(document).ready(function () {
    $("#filterMenu").change(function () {
        switch ($(this).val()) {
            case "All": {
                $("tr").show();
                break;
            }
            case "Pending": {
                $(".Approved").hide();
                $(".Pending").show();
                $(".Denied").hide();
                break;
            }
            case "Approved": {
                $(".Approved").show();
                $(".Pending").hide();
                $(".Denied").hide();
                break;
            }
            case "Denied": {
                $(".Approved").hide();
                $(".Pending").hide();
                $(".Denied").show();
                break;
            }
        }
    });
    $("input").attr('size', $(this).val().length);
});