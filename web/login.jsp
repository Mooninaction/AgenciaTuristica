<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Login</title>

        <link href="css/login.css" rel="stylesheet">
      
        <script src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/modernizr.custom.js"></script>

    </head>

    <body data-spy="scroll" data-offset="0" data-target="#navbar-main">


        <div class="login">
            <div class="login-triangle"></div>

            <h2 class="login-header">Log in</h2>

            <form  action="SvUsuario" method="POST" class="login-container">
                
                <p><input type="usuario" placeholder="User"></p>
                <p><input type="password" placeholder="Password"></p>
                <p><input type="submit" value="Log in"></p>
                
            </form>
        </div>
    </body>
</html>
