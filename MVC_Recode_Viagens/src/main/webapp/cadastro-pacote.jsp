<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Pacote</title>
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
		<h3>Cadastro Pacote</h3>
		<form action="./pacote-insert" method="post" class="form-control">
			<fieldset>
				<legend>Dados do Pacote</legend>

				<p>
					<label for="modal">Modal:</label> <input type="text" id="modal"
						name="modal" size="15" class="form-control" required>
				</p>
				<p>
					<label for="diaria">Diária:</label> <input type="text" id="diaria"
						name="diaria" size="15" class="form-control" required>
				</p>
				<p>
					<label for="valor">Valor:</label> <input type="text" id="valor"
						name="valor" size="15" class="form-control" required>
				</p>

				<p>
					<label for="id_destino">id_destino:</label> <input type="number"
						id="pais" name="id_destino" size="15" class="form-control"
						required>
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
					<th>Modal</th>
					<th>Diária</th>
					<th>Valor</th>
					<th>Id_Destino</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${pacotes}" var="pacote">
					<tr>
						<td>${pacote.id}</td>
						<td>${pacote.modal}</td>
						<td>${pacote.diaria}</td>
						<td>${pacote.valor}</td>
						<td>${pacote.id_destino}</td>
						<td><a href="./pacote-edit?id=${pacote.id}"
							class="btn btn-success">Editar</a> <a
							href="./pacote-delete?id=${pacote.id}"
							onclick="return confirm('Deseja Excluir?')"
							class="btn btn-danger">Excluir</a></td> 
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>