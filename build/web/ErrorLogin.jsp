<%-- 
    Document   : ErrorLogin
    Created on : 05/06/2020, 19:34:38
    Author     : gasto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="img/LavarelaLogo100.ico" sizes="16x16">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <div class="container-xl col-sm-4">
            <body class="" style="background-color:#D6EAF8;">
        <div style="height:115px"></div>
        <!-- Default form login -->
        <form method="POST" class="text-center p-5" style="border:double ; border-radius: 10px; border-color:black; background-color:white;" action="/LAVARELA.110534/LoginServlet">
            <h2 class="text-center"><span class="badge badge-primary">BIENVENIDO A LAVARELA</span></h2>
            <p class=" h3 mb-4">INICIO SESIÓN</p>
            <img src="img/LOGO.png" width="100" >
            
            <p class="h5 mb-4">Ingresa tu Usuario y Contraseña!</p>
            
            
            <!-- Email -->
            <input type="email" 
                       id="email" 
                       class="form-control col-md-12"  
                       name="txtUsuario" 
                       aria-describedby="emailHelp" 
                       placeholder="Usuario"
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]){8,20}"
                       title="Debe contener al entre 8 y 20 caracteres, sólo números o letras"
                       required="Debe ingresar su usuario!"
                       />
            <br>
            <!-- Password -->
            <div class="form-group ">
                <input type="password" 
                       id="psw" 
                       class="form-control col-md-12" 
                       name="txtPass"
                       placeholder="Contraseña"
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]){8,20}"
                       title="Debe contener al menos un número, una letra mayúscula, una letra minúscula y más de 8 caracteres"
                       required=""
                       />
                <small id="emailHelp" class="form-text text-muted">
                    
                </small>
            </div>

            <div class="d-flex justify-content-around">
                <div>
                    <!-- Recordarme -->

                </div>
            </div>
            <div class="alert alert-danger col-md-12" role="alert" >
                    Datos incorrectos, Intente nuevamente!!
            </div>
            <!-- Sign in button -->
            <button type="submit" class="btn btn-primary">Ingresar</button>

            <!-- Register -->

            <!-- Social login -->

        </form>
<!-- Default form login -->
    </div>
        </center>
        
    <script>
        
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });

        function validar() {
            var txtUsuario = document.getElementById('txtUsuario');
            if (txtUsuario.value === '') {
                alert('Debe ingresar el Usuario');
                return false;
            }

            var txtPass = document.getElementById('txtPass');
            if (txtPass.value === '') {
                alert('Debe ingresar la contraseña');
                return false;
            }
        }
    </script>
        <script src="js/jquery-3.4.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>    
    </script>
    </body>
</html>
