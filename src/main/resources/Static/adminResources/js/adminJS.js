/*$(document).ready(function()
{
    $('.getSpecTweets').click(function(which)
        {
*/
    function getNextTweets(which)
    {
         //var which = document.getElementById("getAllTweetBtn").value;
         var xhttp = new XMLHttpRequest();
                 xhttp.onreadystatechange = function()
                 {
                     if(this.readyState == 4 && this.status == 200)
                     {

                        var returnJson = JSON.parse(this.responseText);
                        var returnedHTML = returnJson.returnTweetHTML;
                        var returnedWhichNum = returnJson.thisTweetCount;
                        var returnedTotal = returnJson.howManyTweets;

                        document.getElementById("totalTweets").innerHTML = "Total tweets: " + returnedTotal;
                        document.getElementById("whichIsThis").innerHTML = "This is tweet number: " + returnedWhichNum;
                        document.getElementById("allTweetShow").innerHTML = returnedHTML;
                        if(which <= 0)
                        {
                            document.getElementById("previous").value = 0;
                            document.getElementById("next").value = 1;
                        }
                        else if(which > 0 && which < returnedTotal)
                        {
                            document.getElementById("previous").value = parseInt(which, 10) - 1;
                            document.getElementById("next").value = parseInt(which, 10) + 1;
                        }
                        else if(which >= returnedTotal)
                        {
                            document.getElementById("previous").value = parseInt(returnedTotal, 10) -1;
                            document.getElementById("next").value = parseInt(returnedTotal, 10);
                        }

                        twttr.widgets.load(
                            document.getElementById("allTweetShow")
                        );


                     }
                 };
                 xhttp.open("POST", "/adminTweetList", true);
                 xhttp.setRequestHeader("Content-type", "application/json");

                 var obj = { "social": which};
                 var JsonObj = JSON.stringify(obj);
                 xhttp.send(JsonObj);
    };



