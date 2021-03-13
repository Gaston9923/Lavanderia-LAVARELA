<%-- 
    Document   : listadoDetallesRegistros
    Created on : 05/07/2020, 05:23:43
    Author     : gasto
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
        <title>Registro LAVARELA</title>
    </head>
    <body class="fondo" style="position: relative">
        <!--Comienza el NAV-->
        <nav class="navbar navbar-light p-1 celeste"  >
            <a class="navbar-brand" href="#">
              <img src="img/LavarelaLogo10.png" width="75" height="70" class="d-inline-block align-middle" alt="">
              <span class="sombra mifuente">LAVANDERIA LAVARELA</span>
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
        
            <div style="height:20px"></div>               
            <div class="container-fluid col-sm-10" style="background-color: white">
                <h1 class="text-center"><span class="badge badge-primary sombra">DETALLES DEL REGISTRO</span></h1>
                <div class="row">
                    <div class="col-lg-12">   
                        <div style="height:4px"></div>
                        <table id="tablaCli" class="table table-striped table-hover table-bordered">
                            <thead class="theadR">
                              <th scope="col" class="text-center border-dark sombra">Registro N°</th>
                              <th scope="col" class="text-center border-dark sombra">Usuario</th>
                              <th scope="col" class="text-center border-dark sombra">Cliente</th>
                              <th scope="col" class="text-center border-dark sombra">Estado Pago</th>
                              <th scope="col" class="text-center border-dark sombra">Estado Servicio</th>
                              <th scope="col" class="text-center border-dark sombra">Fecha</th>
                            </thead>
                            <tbody>
                              <c:forEach items="${listadoRegistro}" var="i">
                                <tr class="text-center">
                                    <th scope="row">${i.idRegistro}</th>
                                    <th scope="row">${i.nombreUsuario}</th>
                                    <th scope="row">${i.idCliente} - ${i.cliente}</th>
                                    <th scope="row">${i.estadoPago}</th>
                                    <th scope="row">${i.estadoServ}</th>
                                    <th scope="row">${i.fecha}</th>
                                </tr>
                              <thead class="theadD table-sm">
                                    <th scope="col" class="text-center border-dark sombra">Servicio N°</th>
                                    <th scope="col" class="text-center border-dark sombra">Servicio</th>
                                    <th scope="col" class="text-center border-dark sombra">Precio</th>
                                    <th scope="col" class="text-center border-dark sombra">Cantidad</th>
                                    <th scope="col" class="text-center border-dark sombra">Monto</th>
                                    <th scope="col" class="text-center border-dark sombra"></th>
                              </thead>
                              <tbody>
                                  <c:forEach items="${listadoDetalles}" var="i">
                                      <tr class="text-center table-sm">
                                            <th scope="row">${i.idDetalleRegistro}</th>
                                            <th scope="row">${i.servicio}</th>
                                            <th class="aladerecha" scope="row">$${i.precio}</th>
                                            <th scope="row">${i.cantidad}</th>
                                            <th class="table-info aladerecha" scope="row">$${i.monto}</th>
                                      </tr>
                                  </c:forEach>
                                          <c:forEach items="${listadoSeña}" var="i">
                                          <tr class="text-center">
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" class="aladerecha" >Seña:</th>
                                          <th scope="row" style="color: red" class="aladerecha" >-$${i.seña}</th>
                                          </tr>
                                          </c:forEach>
                                          <c:forEach items="${listadoDescuentoMes}" var="i">
                                          <tr class="text-center">
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" style="color: red" class="aladerecha" >Se aplicó el descuento de fin de mes!</th>
                                          <th scope="row" style="color: red" class="aladerecha" >-$${i.resto}</th>
                                          </tr>
                                          </c:forEach>
                                          <c:forEach items="${listadoDescuento10}" var="i">
                                          <tr class="text-center">
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" style="color: red" class="aladerecha" >Se aplicó el descuento del Cliente!</th>
                                          <th scope="row" style="color: red" class="aladerecha" >-$${i.resto}</th>
                                          </tr>
                                          </c:forEach>
                                  <c:forEach items="${listadoImporte}" var="i">
                                      <tr class="text-center">
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" ></th>
                                          <th scope="row" class="aladerecha" >Importe Total:</th>
                                          
                                          <th scope="row" class="aladerecha" >$${i.importeTotal}</th>
                                      </tr>
                                   </c:forEach>
                              </tbody>
                              
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>       
                </div>
            </div>
            
            <div style="height:20px"></div>
            <center>
            <!-- Footer -->
            <footer class="page-footer font-small cyan darken-3 celeste MiFooter" style="position: relative" >
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
        
            </center>
    </body>
    
    <!--Jquery, Popper, Bootstrap-->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js.js"></script>
        <script src="js/bootstrap.min.js"></script>
    <!--Datatables JS--> 
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
