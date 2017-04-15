var stompClient = null;
var myShow;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/lightsStatus/statusInfo', function (greeting) {
            var recieved = JSON.parse(greeting.body);
            console.log(recieved.num);
            console.log(recieved.state)
            showColors(recieved.num, recieved.state);

            //showGreeting(recieved.num + ": " + recieved.state);
        });
    });
}

function showAllLights()
{
    $("#pin12").css("visibility", "visible");
    $("#pin3").css("visibility", "visible");
    $("#pin22").css("visibility", "visible");
    $("#pin13").css("visibility", "visible");
    $("#pin7").css("visibility", "visible");
    $("#pin9").css("visibility", "visible");
    $("#pin8").css("visibility", "visible");

}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {

    stompClient.send("/app/lightsSocket", {}, JSON.stringify({'status': $("#name").val()}));
    $("#name").val("");
}

function showColors(lightNum,lightState)
{
    if(lightState == "HIGH")
    {
        //$("#"+lightNum).removeClass("powerOff").addClass("powerOn");
        $("#"+lightNum).css("visibility", "visible");
    }
    else
    {
        //$("#"+lightNum).removeClass("powerOff").addClass("powerOn");
        $("#"+lightNum).css("visibility", "hidden");
    }

    clearInterval(myShow);
    myShow = setTimeout(showAllLights, 15000);

}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    //$( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});