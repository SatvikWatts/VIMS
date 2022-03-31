function check(){
    var data;
    var v=document.getElementById("email");
    const em=new RegExp('[a-zA-z1-9]+@gmail.com');
    if(v.value==="" || !em.test(v.value))
    {
        document.getElementById("e_error").textContent="please enter a valid email";
        document.getElementById("e_error").style.visibility="visible";
        return;
    }
    else
    {
        data=v.value;
        document.getElementById("e_error").style.visibility="hidden";
    }
    
    v=document.getElementById("pass");
    if(v.value==="")
    {
        document.getElementById("p_error").textContent="please enter a valid password";
        document.getElementById("p_error").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("p_error").style.visibility="hidden";
    }
    
    var httpx = new XMLHttpRequest();
    httpx.onreadystatechange = function(){
        if(httpx.status==200 && httpx.readyState==4){
            alert(httpx.responseText);
            if(httpx.responseText.trim()=="0")
            {
                document.getElementById("t_error").textContent="invalid email id or password";
                document.getElementById("t_error").style.visibility="visible";
            }
        }
    };

    httpx.open("POST","Login?data=" + data,true);
    httpx.send();
    
}


