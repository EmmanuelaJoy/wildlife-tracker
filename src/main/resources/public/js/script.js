function ranger(x){
    if (x == 0){
        document.getElementById("rangerDetails").style.display="block";
        document.getElementById("notRanger").style.display="none";
    } else{
        document.getElementById("rangerDetails").style.display="none";
        document.getElementById("notRanger").style.display="block";
    }
}

function contact(){
    document.getElementById("contactDetails").style.display="block";
}