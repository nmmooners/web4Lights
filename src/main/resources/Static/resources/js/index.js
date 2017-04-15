$(document).ready(function()
{


    $('#get').click(function()
    {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function(){
            if (this.readyState == 4 && this.status == 200) {
            document.getElementById("servedRes").innerHTML += this.responseText + "<br>";
            }
        };
        xhttp.open("GET", "/light13", true);
        xhttp.send();
    });

    $('.lightSelect').click(function()
    {
        //document.getElementById("servedRes").innerHTML += this.value + "<br>";
        var xhttp = new XMLHttpRequest();
        var pinClicked = this.value;
        xhttp.onreadystatechange = function()
        {
                if (this.readyState == 4 && this.status == 200)
                {
                    var retObj = JSON.parse(this.responseText);
                    var retPhrase = retObj.retStringObj;
                    var retPin = retObj.pinStateObj;
                    //document.getElementById("servedRes").innerHTML += retPhrase + "<br>";
                    var pinStateString = "#" + pinClicked + "Response";
                    var buttonState = "#" + pinClicked + "Button";

                    if(retPin == "ON")
                    {
                        $(pinStateString).removeClass("powerOff").addClass("powerOn");
                        $(buttonState).removeClass("powerButtOff").addClass("powerButtOn");
                    }
                    else
                    {
                        $(pinStateString).removeClass("powerOn").addClass("powerOff");
                        $(buttonState).removeClass("powerOn").addClass("powerButtOff");
                    }
                    $(pinStateString).html("Current State = " + retPin);
                }
        };
        xhttp.open("POST", "/light13", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        var obj = { "lightNum":pinClicked };
        var JsonObj = JSON.stringify(obj);
        xhttp.send(JsonObj);
    });

    $('#clear').click(function()
    {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function()
        {
            if(this.readyState == 4 && this.status == 200)
            {
                document.getElementById("servedRes").innerHTML = "";
            }
        };
        xhttp.open("POST", "/clearIt", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        var obj = { "clearMe":this.value };
        var JsonObj = JSON.stringify(obj);
        xhttp.send(JsonObj);
     });


     $('#allOn').click(function()
     {
        var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function()
                {
                    if(this.readyState == 4 && this.status == 200)
                    {
                        document.getElementById("servedRes").innerHTML += this.responseText + "<br>";
                        changeAll("ON");
                    }
                };
                xhttp.open("POST", "/onAll", true);
                xhttp.setRequestHeader("Content-type", "application/json");
                var obj = { "allOn":this.value };
                var JsonObj = JSON.stringify(obj);
                xhttp.send(JsonObj);

     });

     $('#allOff').click(function()
          {
             var xhttp = new XMLHttpRequest();
                     xhttp.onreadystatechange = function()
                     {
                         if(this.readyState == 4 && this.status == 200)
                         {
                             document.getElementById("servedRes").innerHTML += this.responseText + "<br>";
                             changeAll("OFF");
                         }
                     };
                     xhttp.open("POST", "/offAll", true);
                     xhttp.setRequestHeader("Content-type", "application/json");
                     var obj = { "allOff":this.value };
                     var JsonObj = JSON.stringify(obj);
                     xhttp.send(JsonObj);

          });


     $('#getSocial').click(function()
          {
             var xhttp = new XMLHttpRequest();
                     xhttp.onreadystatechange = function()
                     {
                         if(this.readyState == 4 && this.status == 200)
                         {
                             document.getElementById("tweetShow").innerHTML = this.responseText;
                            twttr.widgets.load(
                                      document.getElementById("tweetShow")
                                    );
                         }
                     };
                     xhttp.open("POST", "/socialDisplay", true);
                     xhttp.setRequestHeader("Content-type", "application/json");
                     var obj = { "social":this.value };
                     var JsonObj = JSON.stringify(obj);
                     xhttp.send(JsonObj);
        });

    });



function changeAll(onOff)
{
    if(onOff == "OFF")
    {
        $(".stateShow").removeClass("powerOn").addClass("powerOff").html("Current State = OFF");
        $(".lightSelect").removeClass("powerButtOn").addClass("powerButtOff");


        /*

        var x = document.getElementsByClassName("stateShow");
        var y = document.getElementsByClassName("lightSelect");
        for(var i =0; i < x.length; i++)
        {
            x[i].innerHTML = "Current State = OFF";
            x[i].className = "powerOff";
            y[i].className = "powerButtOff"
        }
        */
    }

    else
    {
        $(".stateShow").removeClass("powerOff").addClass("powerOn").html("Current State = ON");
        $(".lightSelect").removeClass("powerButtOff").addClass("powerButtOn");
        /*
        var x = document.getElementsByClassName("stateShow");
        var y = document.getElementsByClassName("lightSelect");
        for(var i =0; i < x.length; i++)
        {
            x[i].innerHTML = "Current State = ON";
            x[i].className = "powerOn";
            y[i].className = "powerButtOn"
        }
        */
    }
};

function startState()
{
//    status("3");
//    status("7");
//    status("8");
//    status("9");
//    status("12");
//    status("13");
    status("14");
    //status("22");

};


function status(whichToCheck)
{
    //changeAll("ON")
    //document.getElementById("servedRes").innerHTML += this.value + "<br>";
    var xhttp = new XMLHttpRequest();
    var pinClicked = whichToCheck;
    xhttp.onreadystatechange = function()
    {
            if (this.readyState == 4 && this.status == 200)
            {
                var retObj = JSON.parse(this.responseText);
                var retPhrase = retObj.retStringObj;
                var retPin = retObj.pinStateObj;
//                document.getElementById("servedRes").innerHTML += retPhrase + "<br>";
                var pinStateString = "#" + pinClicked + "Response";
                var buttonState = "#" + pinClicked + "Button";

                if(retPin == "ON")
                {
                    $(pinStateString).removeClass("powerOff").addClass("powerOn");
                    $(buttonState).removeClass("powerButtOff").addClass("powerButtOn");
                }
                else
                {
                    $(pinStateString).removeClass("powerOn").addClass("powerOff");
                    $(buttonState).removeClass("powerOn").addClass("powerButtOff");
                }
                $(pinStateString).html("Current State = " + retPin);
            }
    };
    xhttp.open("POST", "/status", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    var obj = { "lightNum":pinClicked };
    var JsonObj = JSON.stringify(obj);
    xhttp.send(JsonObj);
};

function getNewSocial()
{
     var xhttp = new XMLHttpRequest();
             xhttp.onreadystatechange = function()
             {
                 if(this.readyState == 4 && this.status == 200)
                 {
                     $("#tweetShow").removeClass("show").addClass("hide");
                     document.getElementById("tweetShow").innerHTML = this.responseText;
                     twttr.widgets.load(
                              document.getElementById("tweetShow")
                     );
                     setTimeout(function()
                     {
                     $("#tweetShow").removeClass("hide").addClass("show");
                     }, 200);

                 }
             };
             xhttp.open("POST", "/socialDisplay", true);
             xhttp.setRequestHeader("Content-type", "application/json");
             var obj = { "social":"socialPlease" };
             var JsonObj = JSON.stringify(obj);
             xhttp.send(JsonObj);
};



function getTime()
{
    var d = new Date();
    var day = d.getDay() + 1;
    var month = d.getMonth() + 1;
    var year = d.getFullYear();
    document.getElementById("timeShow").innerHTML = d;
    connect();
    startState();

    getNewSocial();
    window.setInterval(function(){
      //call your function here
      getNewSocial();
    }, 10000);


};