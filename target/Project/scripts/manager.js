$(document).ready(function () {
    let formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
        minimumFractionDigits: 2
    });
    $(".reimbursementAmount").each(function () {
        $(this).html(formatter.format($(this).html()));
    });
    $(".filter").click(function () {
        $(".filter").removeClass("active btn-success");
        $(this).addClass("active btn-success");
        let that = this;
        $("tbody tr").each(function () {
            if ($(that).val() == "All") {
                $(this).show();
            } else if ($(this).hasClass($(that).val())) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    });
    //$('.table').DataTable();
    $(".radioButton").prop("checked", true);
});