<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Cadastro de Pais</title>
    </head>
    <body>
 <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Olimpiadas</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="PaisCadastro.jsp">Pais</a>
                    </li>
                    <li><a href="modalidade.jsp">Modalidade</a>
                    </li>                                   
                </ul>
            </div>
        </div>
    </nav>
    <br>
   	<div class="container">
            <h1 class="page-header">Cadastro de Pais</h1>
            <form action="ManterOlimpiada.do" method="post">
                <div class="row">
                    <div class="form-group col-md-12">
                            <label><strong>Pais</strong></label>
                            <input type="text" class="form-control" name="pais" placeholder="Digite o nome do Pais">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                            <label><strong>Populacao</strong></label>
                            <input type="text" class="form-control" name="populacao" placeholder="Digite a Popula��o">
                    </div>
                    <div class="form-group col-md-6">
                            <label><strong>Area</strong></label>
                            <input type="text" class="form-control" name="area" placeholder="Digite a Area do Pa�s">
                    </div>
                </div>
                <hr />
                <div class="row text-right">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-primary" name="acao" value="criarPais">Criar</button>
                                <a href="index.html" class="btn btn-default">Cancelar</a>
                           </div>
                   </div>
                   </form>
        </div>
        
     
    </body>
</html>
