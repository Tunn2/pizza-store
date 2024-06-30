/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tungnk.pizza.PizzaDAO;
import tungnk.pizza.PizzaDTO;
import tungnk.account.AccountDAO;
import tungnk.account.AccountDTO;

/**
 *
 * @author ktung
 */
public class SearchServlet extends HttpServlet {

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

        try {
            PizzaDAO dao = new PizzaDAO();
            List<PizzaDTO> list = null;
            if (request.getParameter("numSearch1") != null && request.getParameter("numSearch2") != null) {
                int min = Integer.parseInt(request.getParameter("numSearch1"));
                int max = Integer.parseInt(request.getParameter("numSearch2"));
                list = dao.getPizzaByPrice(min, max);
            }else if(request.getParameter("txtCategoryID") != null) {
                int categoryID = Integer.parseInt(request.getParameter("txtCategoryID"));
                list = dao.getPizzaByCategory(categoryID);
            }
            else {
                String search = request.getParameter("txtSearch");
                list = dao.getPizzaByName(search);
            }
            request.setAttribute("LIST_PIZZA", list);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
