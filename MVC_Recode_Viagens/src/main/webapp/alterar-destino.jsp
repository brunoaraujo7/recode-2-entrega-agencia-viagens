<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração de Destino ${destino.cidade}</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container px-5 py-3">
		<h3>Alteração de Destino ${destino.cidade}</h3>
		<form action="./destino-edit" method="post" class="form-control">
			<input type="hidden" name="id" value="${destino.id}">
			<p>
				<label for="cidade">Cidade:</label> 
				<input value="${destino.cidade}" type="text" id="cidade"
					name="cidade" size="15" class="form-control" required>
			</p>

			<p>
				<label for="pais">País:</label> 
				<input value="${destino.pais}"type="text" id="pais"
					name="pais" size="15" class="form-control" required>
			</p>

			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
	</div>
</body>
</html>