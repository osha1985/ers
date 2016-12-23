$(document).ready(function () {
    var formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
        minimumFractionDigits: 2
    });
    $(".reimbursementAmount").each(function () {
        $(this).html(formatter.format($(this).html()));
    });
    $('#filterMenu').change(function () {
        $("tbody tr").each(function () {
            if ($(this).hasClass($('#filterMenu').val())) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    });
});