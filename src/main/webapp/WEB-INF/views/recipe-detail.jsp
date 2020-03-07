<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css"/>
</head>
<body>

<main class="container">
<%@ include file="partials/header.jsp" %>

		<section class="jumbotron">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Ingredients</th>
						

					</tr>
				</thead>
				<tbody>
					<c:forEach var="res" items="${ones}">
						<tr>
							<th scope="row">${ res }</th>
						
						</tr>



					</c:forEach>
				</tbody>
			</table>
			<button type="submit">Go Back</button>
		</section>

	</main>

</body>
</html>