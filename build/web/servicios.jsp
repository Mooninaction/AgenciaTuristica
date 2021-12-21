<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>ViajAndo Admin Paquetess</title>

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
        <h1 class="centered fade-down">Cargar Servicio</h1>
        <hr class="fade-down">
        <div  class="container">
            <h3>Ingrese los datos del servicio</h3>
            <form action="SvServicio" method="POST">

                <p> <label> Nombre: </label> &nbsp; <input  type="text" name="nombre" class="form-control" id="text1" placeholder="nombre"></p>
                <p> <label> Descripción: </label> &nbsp; <input  type="text" name="descripcionBreve" class="form-control" id="text1" placeholder="descripcionBreve"></p>
                <p> <label> Destino: </label> &nbsp; <input  type="text" name="destinoServicio" class="form-control" id="text1" placeholder="destinoServicio"></p>
                <p> <label> Fecha: </label> &nbsp; <input  type="Date" name="fechaServicio" class="form-control" id="text1" placeholder="fechaServicio"></p>
                <p> <label> Costo: </label> &nbsp; <input  type="text" name="costoServicio" class="form-control" id="text1" placeholder="costo"></p>

                <p> <label> Seleccione el tipo de servicio: </label> </p>

                <select name="tipoServicio"  class="btn btn-success">
                    <option> Noche de hotel </option> 
                    <option> Alquiler de auto </option>
                    <option> Pasaje de colectivo</option>
                    <option> Pasaje de avión</option>
                    <option> Pasaje en tren</option>
                    <option> Excursion</option>
                    <option> Evento</option>
                </select>
                <hr>

                <div class="form-group">
                    <div class="col-md-10">
                        <button type="submit" class="btn btn-success" value="Crear">Crear</button>
                        <hr>
                    </div>
                </div>

            </form>

    </body>
</html>
