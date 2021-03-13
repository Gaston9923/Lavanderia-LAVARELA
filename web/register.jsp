<%-- 
    Document   : register
    Created on : 04/06/2020, 04:48:45
    Author     : gasto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lavanderia LAVARELA!</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="img/LavarelaLogo100.ico" sizes="16x16">
        <title>Registrar nuevo Usuario LAVARELA</title>
    </head>
    <div class="container-xl col-sm-4">
        <body style="background-color:#D6EAF8;">
        <div style="height:115px"></div>
        <form method="POST" class="text-center p-5" style="border:double ; border-radius: 10px; border-color:black; background-color:white;" action="/LAVARELA.110534/RegisterServlet">
            <h2 class="text-center"><span class="badge badge-primary">BIENVENIDO A LAVARELA</span></h2>
            <p class=" h3 mb-4">REGISTRARSE</p>
            <img src="img/LogoLavarela.png" width="140" >
            <div class="form-group">
                Complete los siguientes datos:
                
                <input type="email" 
                       id="email" 
                       class="form-control col-md-12" 
                       name="txtUsuario"
                       aria-describedby="emailHelp" 
                       title="Ingrese el Usuario"
                       placeholder="Usuario"
                       required>
            </div>

            <div class="form-group">
                <input type="password" 
                       id="psw" 
                       class="form-control col-md-12" 
                       name="txtPass" 
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                       title="Debe contener al menos un número, una letra mayúscula, una letra minúscula y debe contener entre 8 a 20 caracteres" required 
                       placeholder="Contraseña">
            </div>


            <button type="submit" class="btn btn-primary">Registrarse</button>
        </form>
        </div>
    </center>

    <script>
        
            var txtUsuario = document.getElementById('txtUsuario');
            if (txtUsuario.value === '') {
                alert('El Nombre de Usuario no debe estar vacio');
                return false;
            }

            var txtPass = document.getElementById('txtPass');
            if (txtPass.value === '') {
                alert('La Contraseña no debe estar vacia');
                return false;
            }
        }
    </body>
</html>
