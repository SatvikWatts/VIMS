window.onload = function(){
    var x=localStorage.getItem("visid");
    var y=localStorage.getItem("isad");
    if(y.trim()==="true")
    {
        document.getElementById("allpass").style.display="inline";
        document.getElementById("empass").style.display="none";
    }
};


function email(){
    var data=localStorage.getItem("visid");
    var httpx = new XMLHttpRequest();
    httpx.onreadystatechange = function(){
        if(httpx.status===200 && httpx.readyState===4){
            alert("Email Sent Successfully!");
        }
    };

    httpx.open("POST","SendEmail?data="+data,true);
    httpx.send();
}
function del(){
    localStorage.clear();
     window.location.href="Main_Screen.html";
}



