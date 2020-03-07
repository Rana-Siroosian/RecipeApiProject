<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <meta charset="UTF-8"> -->
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="build.css">
</head>
<body>
	<main class="container">
	
		<form action="/search" >
			<section class="jumbotron">
			<h2>Food Search</h2>
			</section>
			<label>Food Name:<input type="text" name="food" required></label>
			<label><input type="hidden" name="theUrl"></label>
			<section class="container">
			<div class="checkbox checkbox-success"><input type="checkbox" name="diet" value="balanced">Balanced</div>
			<div class="checkbox checkbox-success"><input type="checkbox" name="diet" value="high-fiber">High-Fiber</div>
			<div class="checkbox checkbox-primary"><input type="checkbox" name="diet" value="high-protein">High-Protein</div>
			<div class="checkbox checkbox-primary"><input type="checkbox" name="diet" value="low-carb">Low-Carb</div>
			<div class="checkbox checkbox-primary"><input type="checkbox" name="diet" value="low-fat">Low-fat</div>
			<div class="checkbox checkbox-primary"><input type="checkbox" name="diet" value="low-sodium">Low-Sodium</div>
			</section>
				<section>
				<span><label>Calories:</label><br>
				<input type="number" name="mincal" placeholder="Min"/>
				<br>
				<input type="number" name="maxcal" placeholder="Max"/><br>
				<button type="submit" class="btn btn-secondary">Submit</button><br></span>
				</section>		
		</form>
	</main>
</body>
</html>