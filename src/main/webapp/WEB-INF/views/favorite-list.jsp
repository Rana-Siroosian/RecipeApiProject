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
							<th scope="row"><a href="${favorite.url }">${favorite.url }</a></th>
							<th scope="row"><a
								href="/favorite/remove/?id=${favorite.id }"
								class="btn btn-warning">Remove</a></th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="/search">

				<input type="hidden" name="label" value="${favorite.label}" /> <input
					type="hidden" name="url" value="${favorite.url}" /> <input
					type="hidden" name="theUrl" value="${theUrl}" />
				<button type=submit>Go Back</button>

			</form>
		</section>

	</main>
</body>
</html>