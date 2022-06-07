var mybutton = document.getElementById("back-to-top");
var prevScrollpos = window.pageYOffset;

window.onscroll = function () {
    var currentScrollPos = window.pageYOffset;
    if (currentScrollPos === 0) {
        document.getElementById("header").style.top = "37px";
    } else if (prevScrollpos > currentScrollPos) {
        document.getElementById("header").style.top = "0px";
    } else {
        document.getElementById("header").style.top = "-60px";
    }
    prevScrollpos = currentScrollPos;

    // When the user scrolls down 50px from the top of the document, show the button
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
};


// When the user clicks on the button, scroll to the top of the document
mybutton.onclick = function () {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
};