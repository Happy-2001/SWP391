var checkboxes = document.getElementsByName('item'),
    qtyValue = document.getElementById('qtyV');
var button = document.getElementById('toggle');

getQtyValue()

function getQtyValue(){
    if (qtyValue.value > 1){
        document.getElementById("frmid").setAttribute("method", "GET");
    }
};

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