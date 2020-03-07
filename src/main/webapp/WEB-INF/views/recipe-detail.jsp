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
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-Ya0fS7U2c07GI3XufLEwSQlqhpN0ri7w/ujyveyqoxTJ2rFHJcT6SUhwhL7GM4h9" crossorigin="anonymous">

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
			<form action="/search">
			<input type="hidden" name="theUrl" value="${theUrl}" />
			<button type="submit">Go Back</button>
			</form>
		</section>

	</main>

</body>
</html>