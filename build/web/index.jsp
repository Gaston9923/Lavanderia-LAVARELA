
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lavanderia LAVARELA!</title>
        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="img/LavarelaLogo100.ico" sizes="16x16">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/estilo.css"
        
    </head>
      
    <div class="container-xl col-sm-4">
        <body class="" style="background-color:#D6EAF8;">
        
        <!-- Default form login -->
        <form method="POST" class="p-5 formLogin" action="/LAVARELA.110534/LoginServlet">
            <h2 class=""><span class="welcome">BIENVENIDO A LAVARELA</span></h2>
            <p class=" h3 mb-4">INICIO SESIÓN</p>
            <img class="imagen" src="img/LogoLavarela.png" >
            <p class="h5 mb-4">Ingresa tu Usuario y Contraseña!</p>
            
            
            <!-- Email -->
            <input type="email" 
                       id="email" 
                       class="form-control col-md-12 inputLav "  
                       name="txtUsuario" 
                       aria-describedby="emailHelp" 
                       placeholder="Usuario"
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]){8,20}"
                       title="Debe contener al entre 8 y 20 caracteres, sólo números o letras"
                       required="Debe ingresar su usuario!"
                       />
            <!-- Password -->
            <div class="form-group ">
                <input type="password" 
                       id="psw" 
                       class="form-control col-md-12 inputLav" 
                       name="txtPass"
                       placeholder="Contraseña"
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]){8,20}"
                       title="Debe contener al menos un número, una letra mayúscula, una letra minúscula y más de 8 caracteres"
                       required=""
                       />              
            </div>

            <button type="submit" class="btn button1">Ingresar</button>

        </form>
<!-- Default form login -->
    </div>   
                
    <center>
        
    </center>    

        <script src="js/jquery-3.4.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
