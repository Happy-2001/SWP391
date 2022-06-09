const qtyValue = document.querySelectorAll('#qtyV'),
    subBtn = document.querySelectorAll('#subs');

getQtyValue();

function getQtyValue(){
    for (let i = 0; i < subBtn.length; i++){
        if (qtyValue[i].value > 1){
            subBtn[i].classList.add("close-search");
        }else{
            subBtn[i].setAttribute("disabled", true);
        }
    }
};

var checkboxes = document.getElementsByName('item');
var button = document.getElementById('toggle');

button.onclick = () => {
    if (button.value === 'select') {
        for (var i in checkboxes) {
            checkboxes[i].checked = 'FALSE';
        }
        button.value = 'deselect';
    } else {
        for (var i in checkboxes) {
            checkboxes[i].checked = '';
        }
        button.value = 'select';
    }
};