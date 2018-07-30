
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple, Yet Exciting, Form Example</title>

</head>
<body>

<h2>
    Please introduce yourself: <br>
</h2>

<P></P>

<form name="myform" action="echo" method="post">
    Symbol : <input type="text" name="symbol"><br>
    Start Date : <input type="text" name="startdate"><br>
    End Date : <input type="text" name="enddate"><br>
    Interval : <select name="intervalEnum">
                  <option value="TwelveHours">Twelve Hours</option>
                  <option value="Daily">Daily</option>
                  <option value="Weekly">Weekly</option>
               </select>
    <input type="SUBMIT" value="Search">
    <input type="HIDDEN" name="submit" value="true">
</form>

</body>
</html>