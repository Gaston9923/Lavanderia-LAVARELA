<%-- 
    Document   : altaRegistro
    Created on : 05/06/2020, 19:47:07
    Author     : gasto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        
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
           
            <div class="divAltaRegistro" style="">
                <center><h2><span class="badge badge-primary" style="background-color: white; color: #1085FF; text-shadow: 2px 2px 5px grey;">NUEVO REGISTRO</span></h2></center>
                    <form id="formAgregarRegistro" method="POST" action="AgregarRegistroServlet" accept-charset="UTF-8">
                        <div class="">
                        <input type="text" name="txtIdRegistro" value="${idRegistro}" hidden=""  placeholder="idRegistro"/>
                        <label><span style="color: white">Seleccione un Cliente</span></label><br>
                        <input type="text" name="txtIdUsuario" placeholder="Usuario Registrado" hidden="" value="${usuario.getIdUsuario()}">                                                            
                        <select class="form-control boxClientes" name ="txtIdCliente" placeholder="Cliente"/>
                            <c:forEach items="${ListadoClientes}" var="x">
                                <option value="${x.idCliente}" ${idCliente eq x.idCliente?'selected':''}>${x.apellido} ${x.nombre},DNI-${x.notas}</option>
                            </c:forEach>
                        </select>
                        <label><a style="" class="btn btnClienteNuevo" href="AgregarClienteServlet">Cliente nuevo --></a></label>
                    <input type="number" name="txtCantidadServ" value="${cantidadServ}" hidden=""  min="0" placeholder="CantidadServ" class="form-control mb-4"/> 
                    <label><span style="color: white">Qué desea hacer con el importe?</span></label>
                        <select class="form-control boxImporte" name="cboEstadoPago" placeholder=""/>
                            <c:forEach items="${ListadoEstadosPagos}" var="x">
                                <option value="${x.idEstadoPago}" ${idEstadoPago eq x.idEstadoPago?'selected':''}>${x.estadoPago}</option>
                            </c:forEach>
                        </select>
                    <input type="text" name="txtEstadoServ" value="Incompleto" hidden="" placeholder="Estado" required="" maxlength="14" class="form-control mb-4"/>
                    <br> 
                    <button type="submit" class="btn btnRegistro">Agregar</button>
                </div>
            </form>
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
