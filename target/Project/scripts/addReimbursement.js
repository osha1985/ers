/**
 * Created by yehur on 12/21/2016.
 */
$(document).ready(function () {
    $('#receipt').change(function () {
        var store = document.getElementById('receiptStore');
        var file = this.files[0];
        var reader = new FileReader();
        reader.addEventListener("load", function () {
            store.value = reader.result.substr(reader.result.indexOf(',') + 1);
        }, false);
        if (file) {
            reader.readAsDataURL(file);
        }
    });
    $("#reimbursementForm").validate();
});