<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Destinos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous">
	
</script>
</head>
<body>
	<div class="container px-5 py-3">
		<h3>Cadastro Destinos</h3>
		<form action="./destino-insert" method="post" class="form-control">
			<fieldset>
				<legend>Dados do Destino</legend>
				<p>
					<label for="cidade">Cidade:</label> <input type="text" id="cidade"
						name="cidade" size="15" class="form-control" required>
				</p>

				<p>
					<label for="pais">País:</label> <input type="text" id="pais"
						name="pais" size="15" class="form-control" required>
				</p>
				<p>
					<input type="submit" value="Cadastrar" class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Cidade</th>
					<th>País</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${destinos}" var="destino">
					<tr>
						<td>${destino.id}</td>
						<td>${destino.cidade}</td>
						<td>${destino.pais}</td>
						<td><a href="./destino-edit?id=${destino.id}"
							class="btn btn-success">Editar</a> <a
							href="./destino-delete?id=${destino.id}"
							onclick="return confirm('Deseja Excluir?')"
							class="btn btn-danger">Excluir</a></td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>