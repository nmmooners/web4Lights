<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>web4Lights</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


    <script>
        $(document).ready(function(){
            $('#button01').click(function(){
                $.get(":2020/light13");
             });
        });
    </script>



</head>
<body>

<?php

echo "hello world This is Nate's PI <br>";
echo date('Y-m-d H:i:s');
echo "<br>";
echo "This is nate's pi <br>";
echo "We cant wait to get this thing running!";

?>


<!--
02 = number 4
03 = number 3
07 = number 7
08 = number 8
09 = number 6
12 = number 2
13 = number 1
22 = number 5

-->

<br>
<button type = "button" id = "button01">On</button>
<br>
<br>

</body>
</html>