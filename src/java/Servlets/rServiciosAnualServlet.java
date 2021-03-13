
package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;



@WebServlet(name = "rServiciosAnualServlet", urlPatterns = {"/rServiciosAnualServlet"})
public class rServiciosAnualServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        try {
            response.setContentType("application/pdf");
            
            ServletOutputStream out = response.getOutputStream();
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("\\WEB-INF\\rServicioAnual.jasper"));
            Map parametrosMap = new HashMap<>();
            System.out.println("1");
            int anio = Integer.parseInt(request.getParameter("txtAnio"));
            parametrosMap.put("pAnio", anio);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-UDRJE1U\\SQLEXPRESS:1433;databaseName=LAVARELA1", "sa", "sa");
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametrosMap, conexion);
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
            exporter.exportReport();
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
