var fileInput = document.getElementById("submit-file"),
    button = document.querySelector(".trigger"),
    showDemo = document.querySelector(".file-upload-image"),
    deleBtn = document.querySelector(".submit-file-box"),
    def = document.getElementById("imgDefault");

button.addEventListener("click", function(vent) {
    fileInput.focus();
    return false;
});
fileInput.addEventListener("change", function(event) {
    showDemo.style.display = "block";

    if (this.files && this.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            showDemo.src =  e.target.result;
        };
        deleBtn.style.display = "none";
        reader.readAsDataURL(this.files[0]);
    } else {
        removeUpload();
    }
});
  
function removeUpload() {
    showDemo.style.display = "none";
    deleBtn.style.display = "block";
    showDemo.src = def.src;
}