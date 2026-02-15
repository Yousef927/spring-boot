<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My JSP Page</title>
</head>
<body>
	
	<form action="addAlien" method="post">
	    Enter your id: <input type="text" name="aid" /><br>
	    Enter your name: <input type="text" name="aname" /><br>
	    <input type="submit" value="Add Alien">
	</form>

	<hr>

	<form action="getAlien">
	    Enter your id: <input type="text" name="aid" /><br>
	    <input type="submit" value="Get Alien">
	</form>

	<hr>

	<form action="deleteAlien" method="post">
	    Enter your id: <input type="text" name="aid" /><br>
	    <input type="submit" value="Delete Alien"/>
	</form>
	
	<hr>

	<form action="getAlienByName">
	    Enter your name: <input type="text" name="aname" /><br>
		<input type="submit" value="Find Name"/>
	</form>
	
	<hr>
	
	<form action="getAliens">
        <input type="submit" value="Show All Aliens"/>
	</form>

</body>
</html>
