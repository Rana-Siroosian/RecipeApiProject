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
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="build.css">
<style>
body {
	background-image:
		url('https://d2v9y0dukr6mq2.cloudfront.net/video/thumbnail/rEKBgql9irxhix6p/overhead-view-of-ingredients-for-an-italian-pasta-recipe-on-rustic-wood-background_sqxcd7bvfx_thumbnail-full01.png');
	background-repeat: no-repeat;
	background-size: cover;
}

h1 {
	color: white;
	text-shadow: 8px 8px 10px #000000;
	font-size: 4vw
}

div {
	color: white;
}

input[type=text] {
	border: 2px solid brown;
	border-radius: 4px;
	left: 230px;
	bottom: 330px;
	color: black;
}

input[type=number] {
	border: 2px solid brown;
	border-radius: 4px;
	left: 230px;
	bottom: 330px;
	color: black;
}

button[type=submit] {
	position: absolute;
	left: 230px;
	bottom: 180px;
}
</style>
</head>
<body>

	<main class="container">

		<form action="/search">
			<h1>AMRA Food Search</h1>
			<section class="container">
				<div>
					<h3>
						<label>Food Name:</label>
					</h3>
				</div>
				<div>
					<input type="text" name="food" required>
				</div>
				<label><input type="hidden" name="theUrl"></label>
				<section class="container">
					<h4>
						<div class="checkbox checkbox-primary">
							<input type="checkbox" name="diet" value="balanced">Balanced
						</div>
					</h4>
					<h4>
						<div class="checkbox checkbox-primary">
							<input type="checkbox" name="diet" value="high-fiber">High-Fiber
						</div>
					</h4>
					<h4>
						<div class="checkbox checkbox-primary">
							<input type="checkbox" name="diet" value="high-protein">High-Protein
						</div>
					</h4>
					<h4>
						<div class="checkbox checkbox-primary">
							<input type="checkbox" name="diet" value="low-carb">Low-Carb
						</div>
					</h4>
					<h4>
						<div class="checkbox checkbox-primary">
							<input type="checkbox" name="diet" value="low-fat">Low-fat
						</div>
					</h4>
					<h4>
						<div class="checkbox checkbox-primary">
							<input type="checkbox" name="diet" value="low-sodium">Low-Sodium
						</div>
					</h4>
				</section>
				<section>
					<div>
						<h3>
							<label>Calories:</label>
						</h3>
					</div>
					<div>
						<input type="number" name="mincal" placeholder="Min" />
					</div>

					<div>
						<input type="number" name="maxcal" placeholder="Max" />
					</div>
				</section>

			</section>
			<div>
				<button type="submit" class="btn btn-warning">Submit</button>
			</div>

		</form>
	</main>
</body>
</html>