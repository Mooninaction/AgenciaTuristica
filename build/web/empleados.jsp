<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>ViajAndo Admin Empleados</title>

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

        <h1 class="centered fade-down">Alta Empleados</h1>
        <hr class="fade-down">
        <div  class="container">
            <h3>Ingrese los datos de su empleado</h3>

            <form action="SvEmpleado" method="POST">

                <p> <label> Nombre: </label> &nbsp; <input  type="text" name="nombre" class="form-control" id="text1" placeholder="nombre"></p>
                <p> <label> Apellido: </label> &nbsp; <input  type="text" name="apellido" class="form-control" id="text1" placeholder="apellido"></p>
                <p> <label> Dirección: </label> &nbsp; <input  type="text" name="direccion" class="form-control" id="text1" placeholder="Calle Falsa 123" ></p>
                <p> <label> DNI: </label> &nbsp; <input  type="text" name="dni" class="form-control" id="text1" placeholder="12345678"></p>
                
                <p> <label> Fecha de nacimiento: </label> &nbsp; <input  type="date" name="fechaNacimiento" class="form-control" id="text1" placeholder="fecha"></p>
                <p> <label> Nacionalidad: </label> &nbsp; <input  type="text" name="nacionalidad" class="form-control" id="text1" placeholder="nacionalidad"></p>
                <p> <label> Celular: </label> &nbsp; <input  type="text" name="celular" class="form-control" id="text1" placeholder="+12 123 1234567"></p>
                <p> <label> Email: </label> &nbsp; <input  type="text" name="email" class="form-control" id="text1" placeholder="email"></p>

                <p> <label> Cargo: </label> &nbsp; <input  type="text" name="cargo" class="form-control" id="text1" placeholder="administrativo"></p>
                <p> <label> Tareas: </label> &nbsp; <input  type="text" name="tarea" class="form-control" id="text1" placeholder="atención al cliente" ></p>
                <p> <label> Sueldo: </label> &nbsp; <input  type="text" name="sueldo" class="form-control" id="text1" placeholder="tu sueldo"></p>

                <p> <label> Nombre de usuario: </label> &nbsp; <input  type="text" name="nombreUsuario" class="form-control" id="text1" placeholder="usuario"></p>
                <p> <label> Contraseña: </label> &nbsp; <input type="password" name="contrasenia"class="form-control" id="text1" placeholder="contraseña"></p>

                <div class="form-group">
                    <div class="col-md-10">
                        <button type="submit" class="btn btn-success" value="Enviar">Enviar</button>
                        <hr class="fade-down">
                    </div>
                </div>
            </form>
        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/plugins.js"></script>
        <script type="text/javascript" src="js/init.js"></script>
    </body>
</html>
