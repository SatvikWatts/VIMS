function check(){
    var data;
    //validating visitor name
    var v=document.getElementById("vname");
    const nm=new RegExp('[a-zA-z]+');
    if(v.value==="" || !nm.test(v.value))
    {
        document.getElementById("n_error1").textContent="please enter a valid name";
        document.getElementById("n_error1").style.visibility="visible";
        return;
    }
    else
    {
        data=v.value;
        document.getElementById("n_error1").style.visibility="hidden";
    }
    
    //validating visitor email
    v=document.getElementById("em1");
    const em=new RegExp('[a-zA-z1-9]+@gmail.com');
    if(v.value==="" || !em.test(v.value))
    {
        document.getElementById("e_error1").textContent="please enter a valid email";
        document.getElementById("e_error1").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("e_error1").style.visibility="hidden";
    }
    
    //validating visitor pass
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
    
    v=document.getElementById("idt");
    data=data+" "+v.value;
        
    //validating id
    v=document.getElementById("idd");
    if(v.value==="")
    {
        document.getElementById("i_error").textContent="please enter a valid id";
        document.getElementById("i_error").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("i_error").style.visibility="hidden";
    }
    
    //validating visitor contact no.
    v=document.getElementById("cno");
    const em1=new RegExp('[0-9]{10}');
    if(v.value==="" || !em1.test(v.value))
    {
        document.getElementById("c_error").textContent="please enter a valid contact number";
        document.getElementById("c_error").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("c_error").style.visibility="hidden";
    }
    
    //validating host name
    v=document.getElementById("hname");
    if(v.value==="" || !nm.test(v.value))
    {
        document.getElementById("n_error2").textContent="please enter a valid name";
        document.getElementById("n_error2").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("n_error2").style.visibility="hidden";
    }
    
    
    //validating host email
    v=document.getElementById("em2");
    if(v.value==="" || !em.test(v.value))
    {
        document.getElementById("e_error2").textContent="please enter a valid email";
        document.getElementById("e_error2").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("e_error2").style.visibility="hidden";
    }
    
    v=document.getElementById("buil");
    data=data+" "+v.value;
    
    
    //validating days
    v=document.getElementById("days");
    const em2=new RegExp('[0-9]+');
    if(v.value==="" || !em2.test(v.value))
    {
        document.getElementById("d_error").textContent="please enter a valid value";
        document.getElementById("d_error").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("d_error").style.visibility="hidden";
    }
    

//    //validating host pic
//    v=document.getElementById("pic");
//    const pic=new RegExp('[a-zA-z0-9]+.jpg');
//    if(v.value==="" || !pic.test(v.value))
//    {
//        document.getElementById("p_error1").textContent="please enter a valid photograph";
//        document.getElementById("p_error1").style.visibility="visible";
//        return;
//    }
//    else
//    {
//        document.getElementById("p_error1").style.visibility="hidden";
//    }
    
    
    
    var httpx = new XMLHttpRequest();
    httpx.onreadystatechange = function(){
        if(httpx.status==200 && httpx.readyState==4){
            alert(httpx.responseText);
            if(httpx.responseText.trim()=="0")
            {
                document.getElementById("e_error1").textContent="email already exists";
                document.getElementById("e_error1").style.visibility="visible";
            }
            if(httpx.responseText.trim()=="1")
            {
                document.getElementById("e_error2").textContent="no such host email exisits";
                document.getElementById("e_error2").style.visibility="visible";
            }
            else
            {
                var vid=httpx.responseText.trim();
            }
        }
    };

    httpx.open("POST","Sign_up?data=" + data,true);
    httpx.send();
    
}




