/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MA_Laptop
 */
@WebServlet(name = "BookSearchServlet", urlPatterns = {"/BookSearchServlet"})
public class BookSearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        PrintWriter out = response.getWriter();
        out.println(title);
        Books b = new Books();
        List blist = b.retreiveBookTitles(title);
        request.setAttribute("results", blist);
        //response.sendRedirect("titleResults.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("titleResults.jsp");
        rd.forward(request, response);
        /*
        String query = "SELECT Title FROM Books WHERE Title LIKE '%"+title+"%'";
        Connection con;
        Statement st;
        ResultSet rs;
        out.println(query);
        try{
            out.println("heree");
            Class.forName("com.mysql.jdbc.Driver");
            out.println("adhash");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryprac","root","");
            out.println("heree11");
            st = con.createStatement();
            out.println("heree22");
            rs = st.executeQuery(query);
            out.println("heree33");
            out.println(rs.next());
            
            while(rs.next()){
                out.println(rs.getString("Title"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BookSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List blist = b.retreiveBookTitles(title);
        request.setAttribute("results", blist);
        System.out.println(blist.get(0));
        response.sendRedirect("titleResults.jsp");*/
        
        
        
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
