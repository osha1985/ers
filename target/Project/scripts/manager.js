$(document).ready(function () {
    var formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
        minimumFractionDigits: 2
    });
    $(".reimbursementAmount").each(function () {
        $(this).html(formatter.format($(this).html()));
    });
    $("#filterMenu").change(function () {
        let that = this;
        $("tbody tr").each(function () {
            if(that.val() == "All") {
                $(this).show();
            } else if ($(this).hasClass(that.val())) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    });
});