<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/boo
tstrap.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/boots
trap.min.js"></script>
<title>Filmoteca MVC</title>
</head>
<body>
	<div class="jumbotron text-center bg-dark text-white my-3 pb-2">
		<h2 class="p-1 fm-merienda-one">Ediçao de Filmes</h2>
	</div>
	<h3 class="text-center">${msgInit}</h3>
<hr/>

<div class="card card-body col-md-6 offset-md-3 shadow">
<form method="post" action="/filmesweb/alterar">
<br/>Id<br/>
<input type="number" name="idFilme" id="idFilme" value="${filme.idFilme}" readonly="readonly" />
<br/>Titulo<br/>
<input type="text" name="titulo" id="titulo" value="${filme.titulo}" />
<br/>Categoria<br/>
<input type="text" name="categoria" id="categoria" value="${filme.categoria}" />
<br/>Diretor<br/>
<input type="text" name="diretor" id="diretor" value="${filme.diretor}" />
<br/>Imagem<br/>
<input type="text" name="imagem" id="imagem" value="${filme.imagem}" />
<br/>Trailer<br/>
<input type="text" name="trailer" id="trailer" value="${filme.trailer}" />
<br/>
<button class="btn btn-success" type="submit">Gravar</button>
</form>
<br/>
${msg}	
</div>

<footer class="footer">
            <div class="container text-center">
                <hr/>
                <span class="text-muted">&copy; 2020 Raphael Benevides</span>
            </div>
        </footer>

</body>
</html>