/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function hideMessage(){
    document.getElementById('mess').style.height = 0;
    document.getElementById('menumess').style.display = 'none';
    document.getElementById('mess2').style.height = '35px';
    document.getElementById('iofmess2').style.fontSize = '45px';

}
function showMessage(){
    document.getElementById('menumess').style.display = 'block';
    document.getElementById('mess').style.height = '500px';
    document.getElementById('mess2').style.height = 0;
//    document.getElementById('mess2').style.display = 'none';
document.getElementById('iofmess2').style.fontSize = '0';
}



