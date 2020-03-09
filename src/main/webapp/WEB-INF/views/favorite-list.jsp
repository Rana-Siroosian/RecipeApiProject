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
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/solar/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Ya0fS7U2c07GI3XufLEwSQlqhpN0ri7w/ujyveyqoxTJ2rFHJcT6SUhwhL7GM4h9"
	crossorigin="anonymous">

</head>
<body>
	<main class="container">

		<section class="jumbotron">

			<table class="table table-striped">

				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Link</th>
						<th scope="col">Action</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="favorite" items="${ favorites}">
						<tr>
							<th scope="row">${favorite.label }</th>
							<th scope="row"><a href="${favorite.url }" target="_blank">${favorite.url }</a></th>
							
							<th scope="row">
								<form action="/favorite-list">
									<input type="hidden" name="id" value="${favorite.id}" /> <input
										type="hidden" name="theUrl" value="${theUrl}" />
									<button type="submit" class="btn btn-success">Remove</button>
								</form>
							</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="/search">
				<input type="hidden" name="theUrl" value="${theUrl}" />
				<button type=submit>Go Back</button>
			</form>
		</section>

	</main>
</body>
</html>