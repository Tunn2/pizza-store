/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tungnk.category.CategoriesDAO;
import tungnk.pizza.PizzaDAO;
import tungnk.pizza.PizzaDTO;
import tungnk.supplier.SupplierDAO;

/**
 *
 * @author ktung
 */
public class EditServlet extends HttpServlet {

    private final String EDIT_PAGE = "ViewDetail.jsp";

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
            int supplierID = Integer.parseInt(request.getParameter("supplierID"));
            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            String name = request.getParameter("name");
            int id = Integer.parseInt(request.getParameter("id"));
            PizzaDAO pDao = new PizzaDAO();
            CategoriesDAO cDao = new CategoriesDAO();
            SupplierDAO sDao = new SupplierDAO();
            PizzaDTO pizza = pDao.getPizzaByID(id);
            
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String image = request.getParameter("image");
            String description = request.getParameter("description");
            String msg = "";
            if (cDao.checkExistedCategory(categoryID) && sDao.checkExistedSupplier(supplierID)) {
                msg = "Update Successfully";
                pDao.update(id, name, supplierID, categoryID, quantity, price, image, description);
            } else if (cDao.checkExistedCategory(categoryID)) {
                msg = "SupplierID is not existed";
            } else {
                msg = "CategoryID is not existed";
            }
//            PizzaDTO pizza = pDao.update(quantity, name, supplierID, categoryID, quantity, price, image, description);

            request.setAttribute("MESSAGE", msg);
            request.setAttribute("PIZZA", pizza);
            request.getRequestDispatcher(EDIT_PAGE).forward(request, response);
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
