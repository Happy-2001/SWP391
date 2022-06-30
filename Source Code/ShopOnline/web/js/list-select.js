var checkB = document.querySelectorAll(".form-check-input");
var box = document.querySelectorAll(".customers");
var Btn = document.querySelector(".select-all");

Btn.onclick = () => {
    if (Btn.value === 'deselect') {
        for (var i in checkB) {
            checkB[i].checked = true;
            box[i].classList.add("tr-selected");
        }
        Btn.value = 'select';
    } else {
        for (var i in checkB) {
            checkB[i].checked = false;
            // box[i].classList.remove("tr-selected");
        }
        Btn.value = 'deselect';
    }
};

for (let j=0; j<checkB.length; j++){
    checkB[j].onclick = function() {
        if (checkB[j].checked == true){
            box[j].classList.add("tr-selected");
        }else{
            box[j].classList.remove("tr-selected");
        }
    }
}
for (let j=0; j<checkB.length; j++){
    box[j].onclick = function() {
        window.location.href = checkB[j].value;
    }
}