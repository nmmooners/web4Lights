<!DOCTYPE html>

<html lang="en">
<head>
    <meta charsset="UTF-8">
    <title>nodeLightes</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <script src = "js/index.js"></script>
    <script src = "js/widgetTweet.js"></script>
    <script id="twitter-wjs" type="text/javascript" async defer src="//platform.twitter.com/widgets.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <link rel = "stylesheet" type = "text/css" href = "css/index.css">
</head>

<body onload = "getTime()" onload = "startState()">
<audio controls autoplay loop>
    <source src = "/media/jingle-bells-country.mp3" type = "audio/mp3"/>
</audio>

<h4 id = "timeShow">The date didnt work:(</h4>

<h5>This was done with jsp script: <%= (new java.util.Date()).toLocaleString()%></h5>

<br>

    <div class = "row">

        <div class = "col-lg-7 col-sm-12">
            <div id = "showTemp">

                <h2>Come see the real thing</h2>
                <br>
                <img src = "/images/lightShowGifFast.gif" alt = "Preview Show"/>
            </div>
        </div>

        <div class = "col-lg-4 col-sm-12">
            <div id = "respInfo">
                <h3>What people are saying about Moore Lights</h3>
                <div id = "keepDisplay">
                    <div id = "tweetShow" class = "animate-flicker"></div>
                </div>
                <br>
                <div id = "servedRes">
                </div>
            </div>
        </div>
        <div class = "col-lg-2">
        </div>

    </div>






<!--
<button type = "button" id = "button02" class = "lightSelect" value = "2">Post 2</button>
<br>
-->
<button type = "button" id = "3Button" class = "lightSelect" value = "3">Post 3</button>
<div id = "3Response" class = "stateShow">Current State = HIGH</div>
<br>
<!--
<button type = "button" id = "button04" class = "lightSelect" value = "4">Post 4</button>
<br>
<button type = "button" id = "button05" class = "lightSelect" value = "5">Post 5</button>
<br>
<button type = "button" id = "button06" class = "lightSelect" value = "6">Post 6</button>
<br>
-->
<button type = "button" id = "7Button" class = "lightSelect" value = "7">Post 7</button>
<div id = "7Response" class = "stateShow">Current State = HIGH</div>
<br>
<button type = "button" id = "8Button" class = "lightSelect" value = "8">Post 8</button>
<div id = "8Response" class = "stateShow">Current State = HIGH</div>
<br>
<button type = "button" id = "9Button" class = "lightSelect" value = "9">Post 9</button>
<div id = "9Response" class = "stateShow">Current State = HIGH</div>
<br>
<!--
<button type = "button" id = "button10" class = "lightSelect" value = "10">Post 10</button>
<br>
<button type = "button" id = "button11" class = "lightSelect" value = "11">Post 11</button>
<br>
-->
<button type = "button" id = "12Button" class = "lightSelect" value = "12">Post 12</button>
<div id = "12Response" class = "stateShow">Current State = HIGH</div>
<br>
<button type = "button" id = "13Button" class = "lightSelect" value = "13">Post 13</button>
<div id = "13Response" class = "stateShow">Current State = HIGH</div>
<br>
<button type = "button" id = "14Button" class = "lightSelect" value = "14">Post 14</button>
<div id = "14Response" class = "stateShow">Current State = HIGH</div>
<br>
<!--
<button type = "button" id = "button15" class = "lightSelect" value = "15">Post 15</button>
<br>
<button type = "button" id = "button16" class = "lightSelect" value = "16">Post 16</button>
<br>
<button type = "button" id = "button17" class = "lightSelect" value = "17">Post 17</button>
<br>
<button type = "button" id = "button18" class = "lightSelect" value = "18">Post 18</button>
<br>
<button type = "button" id = "button19" class = "lightSelect" value = "19">Post 19</button>
<br>
<button type = "button" id = "button20" class = "lightSelect" value = "20">Post 20</button>
<br>
<button type = "button" id = "button21" class = "lightSelect" value = "21">Post 21</button>
<br>
-->
<button type = "button" id = "22Button" class = "lightSelect" value = "22">Post 22</button>
<div id = "22Response" class = "stateShow">Current State = HIGH</div>
<br>
<!--
<button type = "button" id = "button23" class = "lightSelect" value = "23">Post 23</button>
<br>
<button type = "button" id = "button24" class = "lightSelect" value = "24">Post 24</button>
<br>
<button type = "button" id = "button25" class = "lightSelect" value = "25">Post 25</button>
<br>
<button type = "button" id = "button26" class = "lightSelect" value = "26">Post 26</button>
<br>
-->

<button type = "button" id = "allOn" value = "turnAllOn">All <span class = "powerOn">ON</span></button>
<br>
<button type = "button" id = "allOff" value = "turnAllOff">All <span class = "powerOff">OFF</span></button>
<br>
<button type = "button" id = "clear" value = "ClearPlease">Clear Console</button>
<br>
<button type = "button" id = "getSocial" value = "socialPlease">Get Twit Stuff</button>
<br>

<!--
    <div id = "respInfo">
        <h3>Response from server</h3>
        <div id = "keepDisplay">
            <div id = "tweetShow" class = "animate-flicker"></div>
        </div>
        <br>
        <div id = "servedRes">
        </div>
    </div>
-->

</body>
</html>
