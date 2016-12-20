function saveFile() {
    var store = document.querySelector('input[type=hidden]');
    var file = document.querySelector('input[type=file]').files[0];
    var preview = document.querySelector('img');
    var reader = new FileReader();
    reader.addEventListener("load", function () {
       store.value = reader.result.substr(reader.result.indexOf(',') + 1);
       preview.src = reader.result;
    }, false);
    if (file) {
        reader.readAsDataURL(file);
    }
}