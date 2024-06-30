/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tungnk.account.AccountDAO;
import tungnk.cart.CartItemDTO;
import tungnk.order.OrderDAO;
import tungnk.order.OrderDTO;
import tungnk.orderdetail.OrderDetailDAO;
import tungnk.pizza.PizzaDAO;

/**
 *
 * @author ktung
 */
public class PurchaseServlet extends HttpServlet {

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
        String url = "OrderInformation.jsp";
        try {
            HttpSession session = request.getSession();
            HashMap<Integer, CartItemDTO> cart = (HashMap<Integer, CartItemDTO>) session.getAttribute("CART");
            Set<Integer> keySet = cart.keySet();
            AccountDAO aDao = new AccountDAO();
            int id = Integer.parseInt(request.getParameter("txtKey"));
            int quantity = Integer.parseInt(request.getParameter("numQuantity"));
            String userName = request.getParameter("txtUserName");
            String address = request.getParameter("txtAddress");
            String phone = request.getParameter("txtPhone");
            int accountID = aDao.getIDByUserName(userName);
            Date currentDate = new Date(new java.util.Date().getYear(), new java.util.Date().getMonth(), new java.util.Date().getDate());
            OrderDAO oDao = new OrderDAO();
            OrderDTO order = oDao.insertOrder(accountID, currentDate, address, phone);
            int orderID = oDao.getLastOrderByAccountID(accountID);
            OrderDetailDAO odDao = new OrderDetailDAO();
            PizzaDAO pDao = new PizzaDAO();
            pDao.updateCart(id, quantity);
            for (Integer key : keySet) {
                odDao.insertOrderDetail(orderID, cart.get(key).getItemID(), cart.get(key).getUnitPrice(), cart.get(key).getQuantity());
            }
            String success = "Order sucessfully";
            request.setAttribute("SUCCESS", success);
            request.getRequestDispatcher(url).forward(request, response);

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
