<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/boo
tstrap.min.css" >
<script type="text/javascript"
src="https://code.jquery.com/jquery-3.2.1.js" ></script>
<script
src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/boots
trap.min.js" ></script>
<title>Filmoteca MVC</title>
</head>
<body>
 <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="/">Lista de Filmes</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
              aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/lista-usuarios">Cadastro de Filmes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/dados-acesso">Usuários</a>
                    </li>
                </ul>
                <form action="/logout" method="post" class="navbar-form navbar-right">
                    <button type="submit" class="btn btn-default">
                        Sair
                    </button>
                </form>
            </div>
        </nav>
        <hr/>
        <hr/>
        <hr/>
<h3 class="text-center">${msgInit}</h3>
<hr/>

<div class="card card-body col-md-6 offset-md-3 shadow">
<form method="post" action="/filmesweb/salvar">
<br/>Titulo<br/>
<input type="text" name="titulo" id="titulo" value="" />
<br/>Categoria<br/>
<input type="text" name="categoria" id="categoria" value="" />
<br/>Diretor<br/>
<input type="text" name="diretor" id="diretor" value="" />
<br/>Imagem<br/>
<input type="text" name="imagem" id="imagem" value="" />
<br/>Trailer<br/>
<input type="text" name="trailer" id="trailer" value="" />
<br/>
<button class="btn btn-success" type="submit">Gravar</button>
</form>
<br/>
${msg}

<table border="1">
<thead>
<tr>
   <th>Id</th>
   <th>Titulo</th>
   <th>Categoria</th>
   <th>Diretor</th>
   <th>Imagem</th>
   <th>Trailer</th>
   <th>Ações</th>
</tr>
</thead>
<tbody>
<c:forEach items="${lista}" var="filme">
<tr>
   <td>${filme.idFilme}</td>
   <td>${filme.titulo}</td>
   <td>${filme.categoria}</td>
   <td>${filme.diretor}</td>
   <td>${filme.imagem}</td>
   <td>${filme.trailer}</td>
   <td>
   <a href="/filmeseditar/${filme.idFilme}">Editar</a>
   <a href="/filmesexcluir/${filme.idFilme}">Excluir</a>
   </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
 <footer class="footer">
            <div class="container text-center">
                <hr/>
                <span class="text-muted">&copy; 2020 Raphael Benevides</span>
            </div>
        </footer>

</body>
</html>