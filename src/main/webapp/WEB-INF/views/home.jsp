<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />

</head>
<body>
	<main class="container">
		<form action="/search" >
			<section class="jumbotron">
			<h2>Food Search</h2>
			</section>
			<fieldset>
			<label>Food Name<input type="text" name="food" required></label>
			<section class="container">
			<label><input type="checkbox" name="diet" value="balanced">Balanced</label>
			<label><input type="checkbox" name="diet" value="high-fiber">High-Fiber</label>
			<label><input type="checkbox" name="diet" value="high-protein">High-Protein</label>
			<label><input type="checkbox" name="diet" value="low-carb">Low-Carb</label>
			<label><input type="checkbox" name="diet" value="low-fat">Low-fat</label>
			<label><input type="checkbox" name="diet" value="low-sodium">Low-Sodium</label>
			</section>
				<section>
				<span>Calories</span><br>
				<input type="number" name="mincal" placeholder="Min"/>
				<br>
				<input type="number" name="maxcal" placeholder="Max"/>
				</section>		
			
			</fieldset>
			<button type="submit" class="btn btn-secondary">Submit</button>
			
		</form>
	</main>
</body>
</html>