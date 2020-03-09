<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %> --%>

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
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/solar/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Ya0fS7U2c07GI3XufLEwSQlqhpN0ri7w/ujyveyqoxTJ2rFHJcT6SUhwhL7GM4h9"
	crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<%@ include file="partials/header.jsp"%>

		<section class="jumbotron">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Image</th>

						<th scope="col">Name</th>
						<!-- <th scope="col">Ingredients</th> -->
						<th scope="col">Qty</th>

						<th scope="col">Cal per serving</th>
						<th scope="col">Total Time</th>
						<th scope="col">Vist Website</th>

						<th scope="col">See Ingredients</th>
						<th scope="col">Mark as favorite</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="res" items="${recipes}" varStatus="status">
						<tr>
							<th scope="row"><img src="${ res.recipe.image }"></th>

							<th scope="row">${ res.recipe.label }</th>
							<!-- <th scope="row">${ res.recipe.ingredientLines }</th> -->
							<th scope="row">${res.recipe.yield} servings</th>
							<th scope="row">${ res.recipe.calories /res.recipe.yield}</th>
							<th scope="row">${ res.recipe.totalTime }</th>
							<th scope="row"><a href="${ res.recipe.url }">Link</a></th>

							<th>
								<form action="/one-recipe">
									<input type="hidden" name="ingre"
										value="${res.recipe.ingredientLines}" /> <input type="hidden"
										name="theUrl" value="${theUrl}" />

									<button type="submit">Check</button>
								</form>

							</th>

							<th>
								<%-- 							
     						<c:forEach var="fav" items="${favorites}">
     						<c:choose>
    						<c:when test="${fn:contains(favorites.label, res.recipe.label)}">
        					<p>pizza. </p>
    						</c:when>    
    						<c:otherwise>
    						<p> not pizzas.  </p>
        					<br />
    						</c:otherwise>
							</c:choose>
     						 --%>


								<form action="/search">

									<input type="hidden" name="label" value="${res.recipe.label}" />
									<input type="hidden" name="url" value="${res.recipe.url}" /> <input
										type="hidden" name="theUrl" value="${theUrl}" />

									<c:choose>
										<c:when test="${empty favorited[status.index]}">
											<p>
												<button type="submit">Favorite</button>
											</p>
										</c:when>
										<c:otherwise>
											<p>Favorited</p>
											<br />
										</c:otherwise>
									</c:choose>


								</form>
							</th>

						</tr>

					</c:forEach>
				</tbody>
			</table>
		</section>
	</main>
</body>
</html>