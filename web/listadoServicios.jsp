<%-- 
    Document   : listadoServicios
    Created on : 04/06/2020, 00:15:23
    Author     : gasto
--%>

<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Listado de Servicios</title>
    </head>
    <body class="fondo">
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
        <div class="divServicios">
                <h1 class="text-center"><span class="badge badge-info sombra">TABLA DE SERVICIOS</span></h1>
                    <div class="row">
                        <div class="col-lg-12">
                        <table id="tablaServicios" class="table table-striped table-hover table-bordered">
                            <a class="btn btnAgregarServicio" href="/LAVARELA.110534/AgregarServicioServlet">Nuevo Servicio</a>
                            <thead class="theadS">
                                <th  class="cabecera">Servicio</th>
                                <th  class="cabecera">Precio</th>
                                <th  class="cabecera">Acciones</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${listadoServicios}" var="i">
                                    <tr class="text-center">
                                        <td scope="row">${i.servicio}</td>
                                        <td scope="row" class="aladerecha">$${i.precio}</td>
                                        <td scope="row"> 
                                            <a id="btnAccion" class="btn btn-primary azul btn-sm" href="/LAVARELA.110534/AgregarServicioServlet?idServicio=${i.idServicio}"><i class='fas fa-pencil-alt' aria-hidden='true'></i> Editar</a>
                                            <a id="btnAccion" class="btn btn-danger btn-sm" onclick="eliminar(${i.idServicio})" href="#"><i class='fa fa-trash' aria-hidden='true'></i> Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                    </div>
            </div>     
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
    </body>
    
        <script> 
        function eliminar(idServicio){
        
        if (confirm("Esta seguro que desea eliminar el Servicio:"+idServicio+"?")) {
            window.location="/LAVARELA.110534/EliminarServicioServlet?idServicio="+idServicio;
            }
        }    
        </script>
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
