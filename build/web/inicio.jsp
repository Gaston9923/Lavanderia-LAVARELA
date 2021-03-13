<%-- 
    Document   : inicio
    Created on : 04/06/2020, 04:47:02
    Author     : gasto
--%>

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
    <body class="fondo">
        <!--Comienza el NAV-->
        <nav class="navbar navbar-light p-1 celeste"  >
            <a class="navbar-brand" href="#">
              <img src="img/LavarelaLogo10.png" width="75" height="70" class="d-inline-block align-middle" alt="">
              <span class="sombra mifuente" >LAVANDERIA LAVARELA</span>
            </a>
            <ul>
                <div class="dropdown align-middle dropleft" style="" >
                <button class=" btn btn-outline-light dropdown-toggle " style=" border: none" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <img src="img/user1.png" alt="80" width="80">
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        Usuario Empleado
                    </a>
                    <a class="dropdown-item" href="#">
                        ${usuario.getNombreUsuario()}
                    </a>
                    <small id="emailHelp" class="form-text text-muted">  
                </small>
                  <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="/LAVARELA.110534/index.jsp">Cerrar Sesión</a>
                </div>
             </div>
            </ul>
        </nav>
        <!--Comienza el NAV-->
        <nav class="navbar navbar-expand-lg navbar-light bg-dark verdeAqua sombra">
            <a class="btn btn-outline-light" style="border: none" href="inicio.jsp">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="btn btn-outline-light" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarRegistrosServlet">Registros <span class="sr-only"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarServiciosServlet">Servicios</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarGastosServlet">Gastos</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 1px; border: none" href="/LAVARELA.110534/ListarClientesServlet">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 1px; border: none" href="/LAVARELA.110534/Reportes.jsp">Reportes</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!--Fin de NAV-->
            <main class="">           
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
                        <img src="img/lavarela.mp4" class="d-block w-100" alt="..."
                        width="200px" height="500px">
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
                    <h5  class="align-middle sombraBlanca " style="font-size: 120px; font-family: fantasy; color: #205965; -webkit-text-stroke: 0.2px black; display: inline">LAVANDERIA</h5> 
                    <img src="img/LavarelaLogo10.png" width="125" height="115" class="d-inline-block align-middle" alt="">
                    <h5  class="align-middle sombraBlanca " style="font-size: 120px; font-family: fantasy; color: #205965; -webkit-text-stroke: 0.2px black; display: inline">LAVARELA</h5>
                    
                    <div style="font-size: 120px; font-family: fantasy; background-color: #04BCA4; opacity: 0.8">
                    
                    <a href="AgregarRegistroServlet" style="border-width: 4px; width: 400px; height: 120px; border-radius: 70px; font-size: 50px" type="button" class="btn btn-info botoncolor ">REGISTRAR</a>
                </div>
                
                </center>
        </main>
        
            <center>
            <!-- Footer -->
        <footer class="page-footer font-small cyan darken-3 celeste">
             <div style="height:18px"></div>
              <div class="col-md-12 py-1">
                  <!-- Facebook -->
                  <a href="https://www.facebook.com/lavanderialavarela/" class="fb-ic">
                    <i  class="fab fa-facebook-f white-text mr-md-5 mr-3 fa-2x"> </i>
                  </a>
                  <!--Instagram-->
                  <a href="https://www.instagram.com/lavanderia_lavarela_malagueno/" class="ins-ic">
                    <i class="fab fa-instagram white-text mr-md-5 mr-3 fa-2x"> </i>
                  </a>
                  <!--Instagram-->
                  <a href="https://api.whatsapp.com/send?phone=+54 351 6378321&text=" class="ins-ic">
                    <i class="fab fa-whatsapp white-text mr-md-5 mr-3 fa-2x"> </i>
                  </a>
              </div>
          <!-- Copyright -->
          <div class="footer-copyright letraVerdeAqua text-center mr-md-5 py-2">© 2020 Copyright:
              <a class="" > ZAPATA GASTÓN-110534</a>
          </div>
          <!-- Copyright -->
        </footer>
        <!-- Footer -->
        </body>
</center>    
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
  
    
</html>

