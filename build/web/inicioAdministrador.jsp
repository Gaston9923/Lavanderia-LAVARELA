<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lavanderia LAVARELA!</title>
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
        <link rel="stylesheet" type="text/css" href="alertifyjs/css/themes/bootstrap.min.css">
        <link rel="icon" href="img/LavarelaLogo100.ico" sizes="16x16">
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>
    </head>
    <body class="">
        <!--Comienza el NAV-->
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
        <!--Fin de NAV-->
            <main class="fondo">           
                <div class="container">
                <center>
                <div>
                    
                </div>
                </center>
                <div id="carouselExampleIndicators" class="carousel slide opacidadMedia " data-ride="carousel" > 
                    <ol class="carousel-indicators">
                      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>               
                    </ol>
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img src="img/lavarela10.jpg" class="d-block w-100" alt="..."
                        width="200px" height="500px" >
                      </div>
                      <div class="carousel-item">
                        <img src="img/lavarela4.jpg" class="d-block w-100" alt="..."
                        width="200px" height="500px">
                      </div>
                      <div class="carousel-item">
                        <img src="img/lavarela5.jpeg" class="d-block w-100" alt="..."
                        width="200px" height="500px">
                      </div>
                      <div class="carousel-item">
                        <img src="img/lavarela2.jpg" class="d-block w-100" alt="..."
                        width="200px" height="500px">
                      </div>
                      <div class="carousel-item">
                        <img src="img/lavarela3.jpg" class="d-block w-100" alt="..."
                        width="200px" height="500px">
                      </div>
                      <div class="carousel-item">
                        <img src="img/lavarela.gif" class="d-block w-100" alt="..."
                        width="300px" height="500px">
                      </div>   
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="sr-only">Anterior</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="sr-only">Siguiente</span>
                    </a>
                  </div>
              </div>
                
                <center>
                    <h5 class="titleLav">LAVANDERIA</h5> 
                    <img src="img/LavarelaLogo10.png" class="imgTitle" alt="">
                    <h5 class="titleLav">LAVARELA</h5>
                    
                    <div style="background-color: #04BCA4; opacity: 0.8; padding: 20px;">
                    
                    <a href="AgregarRegistroServlet" type="button" class="btn btn-info btnRegistrar ">REGISTRAR</a>
                    </div>
                </center>
        </main>
            
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
           
<!--Jquery, Popper, Bootstrap-->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js.js"></script>
        <script src="js/bootstrap.min.js"></script>
    <!--Datatables JS--> 
        <script type="text/javascript" src="alertifyjs/alertify.min.js"></script>
        <script type="text/javascript" src="DataTables/DataTables-1.10.21/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js"></script>
    <!-- Para usar botones en DATATABLES JS -->  
        <script src="DataTables/Buttons-1.6.2/js/dataTables.buttons.min.js"></script>  
        <script src="DataTables/JSZip-2.5.0/jszip.min.js"></script>   
        <script src="DataTables/pdfmake-0.1.36/pdfmake.min.js"></script>    
        <script src="DataTables/pdfmake-0.1.36/vfs_fonts.js"></script>
        <script src="DataTables/Buttons-1.6.2/js/buttons.html5.min.js"></script>
        <script src="DataTables/Buttons-1.6.2/js/buttons.print.min.js"></script>
        <script src="DataTables/Buttons-1.6.2/js/buttons.colVis.min.js"></script>
    <!--Codigo JS Propio-->   
        <script type="text/javascript" src="js/main.js"></script> 
  
    </body>
</html>
