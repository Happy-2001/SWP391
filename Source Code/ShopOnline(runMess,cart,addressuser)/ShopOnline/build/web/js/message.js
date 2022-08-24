/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function replyMessageS(content, id) {
    document.getElementById('replyMessR').style.height = '0';
    document.getElementById('replyMessR').style.width = '0';
    document.getElementById('replyMessS').style.height = '100%';
    document.getElementById('replyMessS').style.width = '100%';
    document.getElementById('contentParentS').innerHTML = content;
    document.getElementById('parentMessageID').value = id;
}
function removeReplyS() {
    document.getElementById('replyMessS').style.height = '0';
    document.getElementById('replyMessS').style.width = '0';
}
function replyMessageR(content, id) {
    document.getElementById('replyMessS').style.height = '0';
    document.getElementById('replyMessS').style.width = '0';
    document.getElementById('replyMessR').style.height = '100%';
    document.getElementById('replyMessR').style.width = '100%';
    document.getElementById('contentParentR').innerHTML = content;
    document.getElementById('parentMessageID').value = id;
}
function removeReplyR() {
    document.getElementById('replyMessR').style.height = '0';
    document.getElementById('replyMessR').style.width = '0';
}


function hindMessage() {
    document.getElementById('message2').style.display = 'block';
    document.getElementById('mess1').style.width = '0';
    document.getElementById('mess1').style.height = '0';
}
function showMessage() {
    document.getElementById('message2').style.display = 'none';
    document.getElementById('mess1').style.width = '340px';
    document.getElementById('mess1').style.height = '460px';
}

