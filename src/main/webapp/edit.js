window.onload = function(){
    var data=localStorage.getItem("visid");
    var isad=localStorage.getItem("isad");
    var httpx = new XMLHttpRequest();
    if(isad.trim()==="true")
    {
        document.getElementById("fff").style.display="none";
    }
    httpx.onreadystatechange = function(){
        if(httpx.status===200 && httpx.readyState===4){
            var sss=httpx.responseText.trim();
            var ss=sss.split(" ");
            document.getElementById("vname").innerHTML=ss[0];
            document.getElementById("em1").innerHTML=ss[1];
            document.getElementById("pass1").value=ss[2];
            document.getElementById("idt").value=ss[3];
            document.getElementById("idd").value=ss[4];
            document.getElementById("cno").value=ss[5];
            document.getElementById("hname").value=ss[6];
            document.getElementById("em2").value=ss[7];
            document.getElementById("buil").value=ss[8]+" "+ss[9];
            document.getElementById("days").value=ss[10];
        }
    };

    httpx.open("POST","get_det?data=" + data,true);
    httpx.send();
};


function check(){
    
    var data=localStorage.getItem("visid");
    var isad=localStorage.getItem("isad");

    //validating visitor pass
    var v=document.getElementById("pass1");
    if(v.value==="")
    {
        document.getElementById("p_error1").textContent="please enter a valid password";
        document.getElementById("p_error1").style.visibility="visible";
        return;
    }
    else
    {
        data=data + " " + v.value;
        document.getElementById("p_error1").style.visibility="hidden";
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

    if(isad.trim()==="false")
    {
        //validating host name
        v=document.getElementById("hname");
        const nm=new RegExp('[a-zA-z]+');
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
        const em=new RegExp('[a-zA-z1-9]+@gmail.com');
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
//    
//    
//    
    var httpx = new XMLHttpRequest();
    httpx.onreadystatechange = function(){
        if(httpx.status===200 && httpx.readyState===4){
            if(httpx.responseText.trim()==="1")
            {
                document.getElementById("e_error2").textContent="no such host email exisits";
                document.getElementById("e_error2").style.visibility="visible";
            }
            else
            {
                alert("Updated Successfully!");
                window.location.href="Front_Screen.html";
            }
        }
    };

    httpx.open("POST","up_det?data=" + data,true);
    httpx.send();
    
}


