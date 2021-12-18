<%-- 
    Document   : Ventas
    Created on : 16 dic. 2021, 18:27:46
    Author     : Luna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>ViajAndo Ventas</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/elusive-webfont.css">
        <link href="css/animate.css" rel="stylesheet">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>

        <script src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/modernizr.custom.js"></script>
    </head>

    <body data-spy="scroll" data-offset="0" data-target="#navbar-main">
        <h1 class="centered fade-down">Crear Venta</h1>
        <hr class="fade-down">
        <div  class="container">
            <h3>Ingrese los datos de su venta</h3>
            <form action="SvVenta" method="POST">

                <p> <label> Fecha: </label> &nbsp; <input  type="date" class="form-control" id="text1" placeholder="fechaVenta"></p>
                <p> <label> Medio de pago: </label> &nbsp; <input  type="text" class="form-control" id="text1" placeholder="medioPago"></p>
                <p> <label> Paquete Turístico: </label> &nbsp; <input  type="text" class="form-control" id="text1" placeholder="paqueteTuristico"></p>
                <p> <label> Servicio: </label> &nbsp; <input  type="text" class="form-control" id="text1" placeholder="servicio"></p>
                <p> <label> Nombre de usuario: </label> &nbsp; <input  type="text" class="form-control" id="text1" placeholder="nombreUsuario"></p>
                <p> <label> Contraseña: </label> &nbsp; <input type="password"class="form-control" id="text1" placeholder="contrasenia"></p>

                <div class="form-group">
                    <div class="col-md-10">
                        <button type="submit" class="btn btn-success" value="Enviar">Enviar</button>
                    </div>
                </div>

            </form>

            <!-- Bootstrap core JavaScript
            ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script type="text/javascript" src="js/bootstrap.js"></script>
            <script type="text/javascript" src="js/plugins.js"></script>
            <script type="text/javascript" src="js/init.js"></script>
    </body>
</html>
