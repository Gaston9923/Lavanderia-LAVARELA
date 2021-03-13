

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta charset=UTF-8">
        <!--BOOTSTRAP CSS-->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!--Codigo CSS Propio-->
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <!--DATATABLE CSS-->
        <link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
        <link rel="stylesheet" type="text/css" href="DataTables/DataTables-1.10.21/css/dataTables.bootstrap4.css">  
        <link rel="stylesheet" type="text/css" href="DataTables/Buttons-1.6.2/css/buttons.jqueryui.min.css">  
        <link rel="stylesheet" type="text/css" href="DataTables/Buttons-1.6.2/css/buttons.jqueryui.min.css">
        <link rel="icon" href="img/LavarelaLogo100.ico" sizes="16x16">
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>
        <title>Agregar nuevo servicio LAVARELA</title>
    </head>
    <body class="fondo">
        <nav class="navbar navbar-light p-1 celeste" style="">
            <div class="navbar-brand" href="#" style="padding-left: 20px; padding-right: 0px; padding-bottom: 10px; padding-top: 10px; display: block;">
              <img src="img/LavarelaLogo10.png" class="logoNav" alt="">
              <span class="mifuente">LAVANDERIA LAVARELA</span>
            </div>
            <div style="" class="btnUser">
                <div class="dropdown dropleft" >
                <button class=" btn btn-outline-light dropdown-toggle "  style="border: none" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <img src="img/user1.png" alt="80" width="70">
                </button>
                    <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        Usuario Administrador
                    </a>
                    <a class="dropdown-item" href="#">
                        ${usuario.getNombreUsuario()}
                    </a>
                    <small id="emailHelp" class="form-text text-muted">
                    <a href="register.jsp">Registrar un nuevo Empleado!</a> <br>
                </small>
                  <div class=""></div>
                  <a class="btn button1" style="width: 120px; margin:5px;" href="/LAVARELA.110534/index.jsp">Cerrar Sesión</a>
                    </div>
             </div>
            </div>
        </nav>
        <!--Comienza el NAV-->
        <nav class="navbar navbar-expand-lg navbar-light bg-dark verdeAqua sombra navLav">
            <a class="btn btn-outline-light btnNavLav" style="border: none" href="inicio.jsp">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="btn btn-outline-light btnNavLav" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarRegistrosServlet">Registros <span class="sr-only"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light btnNavLav" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarServiciosServlet">Servicios</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light btnNavLav" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarGastosServlet">Gastos</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light btnNavLav" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarClientesServlet">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light btnNavLav" style="margin-left: 1px; border: none" href="/LAVARELA.110534/Reportes.jsp">Reportes</a>
                    </li>
                </ul>
            </div>
        </nav>
        
    
        <div style="height:40px"></div>
        <div class="container col-sm-4 p-5" style="border:double; background-color: #17A2B8; border-radius: 10px; border-color:#17A2B8; opacity: 0.9">
        <h1 class="text-center"><span class="badge badge-info sombra align-text-top">NUEVO SERVICIO</span></h1>
        <div style="height:16px"></div>

        <form class="form-horizontal col-sm-14" method="POST" action="/LAVARELA.110534/AgregarServicioServlet">
            <input type="text" name="txtIdServicio" hidden="" value="${idServicio}" class="" />
            <span class="sombra" style="color: white">Nombre del Servicio</span>
            <input type="text" name="txtServicio" value="${servicio}" required="" maxlength="30" placeholder="Servicio" class="form-control col-md-14"/>
            <br>
            <span class="sombra" style="color: white">Indique el precio del Servicio</span>
            <input type="number" name="txtPrecio" value="${precio}" placeholder="Precio" required="" min="0" step="any" class="form-control col-md-14"/>
            <br>
            <center><button type="submit" class="btn btn-light sombra" >Agregar</button></center>
        </form>
        </div>
    
    </body>
        <footer class="footerLav" style="">
            <div>   
                <a href="https://www.facebook.com/lavanderialavarela/" title="Ir a Facebook de LAVARELA" class="">
                    <i id="iconFace" class="fab fa-facebook-f" style=""> </i>
                </a>           
                <a href="https://www.instagram.com/lavanderia_lavarela_malagueno/" title="Ir a Instagram de LAVARELA" class="">
                    <i id="iconInsta" class="fab fa-instagram "> </i>
                </a>           
                <a href="https://api.whatsapp.com/send?phone=+54 351 6378321&text=" title="Ir a WhatsApp de LAVARELA" class="">
                    <i id="iconWhats" class="fab fa-whatsapp "> </i>
                </a>
            </div>
            <div class="footer-copyright letraVerdeAqua text-center mr-md-5 py-2">© 2020 Copyright:
                <a class="" > ZAPATA GASTÓN-110534</a>
            </div>
        </footer>
</center>
    
        <script src="js/jquery-3.4.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</html>
