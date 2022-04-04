window.onload = function(){
    var x=localStorage.getItem("visid");
    var y=localStorage.getItem("isad");
    if(y.trim()==="true")
    {
        document.getElementById("allpass").style.display="inline";
    }
};

function del(){
    localStorage.clear();
     window.location.href="Main_Screen.html";
}



