// Get the modal
var modal = document.querySelectorAll("#myModal");

// Get the button that opens the modal
var btn = document.querySelectorAll("#myBtn");

// Get the <span> element that closes the modal
var span = document.querySelectorAll(".close");

for (let i = 0; i < modal.length; i++){
    btn[i].onclick = function() {
        modal[i].style.display = "block";
    };

    // When the user clicks on <span> (x), close the modal
    span[i].onclick = function() {
        modal[i].style.display = "none";
    };
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target === modal[1]) {
    modal[1].style.display = "none";
  }
};


// Get the modal
var modal2 = document.querySelectorAll("#myModal2");

// Get the button that opens the modal
var btn2 = document.querySelectorAll("#myBtn2");

// Get the <span> element that closes the modal
var span2 = document.querySelectorAll(".close2");

for (let i = 0; i < modal2.length; i++){
    btn2[i].onclick = function() {
        modal2[i].style.display = "block";
    };

    // When the user clicks on <span> (x), close the modal
    span2[i].onclick = function() {
        modal2[i].style.display = "none";
    };
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target === modal2[1]) {
    modal2[1].style.display = "none";
  }
};