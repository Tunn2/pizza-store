/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tungnk.cart.CartItemDTO;
import tungnk.pizza.PizzaDAO;
import tungnk.pizza.PizzaDTO;

/**
 *
 * @author ktung
 */
public class AddToCartServlet extends HttpServlet {

    private final String HOME_PAGE = "Home.jsp";
    private final String LOGIN_PAGE = "Login.jsp";

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
        String url = HOME_PAGE;
        try {
            
            HttpSession session = request.getSession();
            if (session.getAttribute("USER") == null) {
                url = LOGIN_PAGE;
                response.sendRedirect(url);
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                PizzaDAO dao = new PizzaDAO();
                PizzaDTO pizza = dao.getPizzaByID(id);
                HashMap<Integer, CartItemDTO> cart = (HashMap<Integer, CartItemDTO>) session.getAttribute("CART");

                if (cart == null) {
                    cart = new HashMap<>();
                    session.setAttribute("CART", cart);
                }
                String msg = "";
                CartItemDTO cartItem = cart.get(pizza.getId());
                if (cartItem == null) {
                    int itemID = pizza.getId();
                    String item = pizza.getName();
                    int quantity = 1;
                    double unitPrice = pizza.getPrice();
                    cartItem = new CartItemDTO(itemID, item, quantity, unitPrice);
                    cart.put(itemID, cartItem);
                    msg = "Add to cart successfully";
                } else {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    msg = "This pizza is updated into cart";
                }
                request.setAttribute("MESSAGE", msg);
                request.getRequestDispatcher(url).forward(request, response);
            }

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
