$(document).ready(function()
{


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
    getNewSocial();
    window.setInterval(function(){
      //call your function here
      getNewSocial();
    }, 10000);


};