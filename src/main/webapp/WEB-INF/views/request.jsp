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
<form action="/one-recipe">
		<section class="jumbotron">
			<table class="table table-striped">
				<thead>
					<tr>
											<th scope="col">Image</th>
					
						<th scope="col">Name</th>
						<!-- <th scope="col">Ingredients</th> -->
						<th scope="col">Calories</th>
						<th scope="col">Total Time</th>
												<th scope="col">Vist Website</th>
						
						<th scope="col">See Ingredients</th>
						<th scope="col">Mark as favorite</th>
						
						
						

					</tr>
				</thead>
				<tbody>
					<c:forEach var="res" items="${recipes}">
						<tr>
													<th scope="row"><img src="${ res.recipe.image }"></th>
						
							<th scope="row">${ res.recipe.label }</th>
							<!-- <th scope="row">${ res.recipe.ingredientLines }</th> -->
							<th scope="row">${ res.recipe.calories }</th>
							<th scope="row">${ res.recipe.totalTime }</th>
							<th scope="row"><a href="${ res.recipe.url }">Link</a></th>
							
							<th><button name="one" value="${res.recipe.label}${ res.recipe.ingredientLines } ">Check Me</button></th>
							<th><input type="radio" name="fav" value="true">favorite</th>
						</tr>



					</c:forEach>
				</tbody>
			</table>
		</section>
</form>
	</main>
</body>
</html>