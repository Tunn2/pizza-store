/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tungnk.category.CategoriesDAO;
import tungnk.category.CategoriesDTO;
import tungnk.pizza.PizzaDAO;
import tungnk.pizza.PizzaDTO;

/**
 *
 * @author ktung
 */
public class HomeServlet extends HttpServlet {

    private final String HOME_PAGE = "Home.jsp";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String LOGOUT_SERVLET = "LogoutServlet";
    private final String SIGNUP_SERVLET = "SignupServlet";
    private final String INSERT_PAGE = "Insert.jsp";
    private final String SEARCH_SERVLET = "SearchServlet";
    private final String DETAIL_SERVLET = "DetailServlet";
    private final String EDIT_SERVLET = "EditServlet";
    private final String INSERT_SERVLET = "InsertServlet";
    private final String REMOVE_SERVLET = "RemoveServlet";
    private final String ADD_TO_CART_SERVLET = "AddToCartServlet";
    private final String VIEW_CART_SERVLET = "ViewCartServlet";
    private final String UPDATE_CART_SERVLET = "UpdateCartServlet";
    private final String DELETE_CART_SERVLET = "DeleteCartServlet";
    private final String ORDER_INFORMATION_PAGE = "OrderInformation.jsp";
    private final String PURCHASE_SERVLET = "PurchaseServlet";
    private final String CLEAR_CART_SERVLET = "ClearCartServlet";
    private final String HISTORY_ORDER_SERVLET = "HistoryOrderServlet";
    private final String ORDER_DETAIL_SERVLET = "OrderDetailServlet";
    private final String VIEW_ALL_ORDERS_SERVLET  = "ViewAllOrdersServlet";
    private final String REPORT_PAGE = "Report.jsp";
    private final String REPORT_SERVLET = "ReportServlet";
    private final String BEST_SELLER_SERVLET = "BestSellerServlet";
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
        PrintWriter out = response.getWriter();
        String url = HOME_PAGE;
        PizzaDAO pDao = new PizzaDAO();
        CategoriesDAO cDao = new CategoriesDAO();
        try {
            List<PizzaDTO> pList = pDao.getData();
            request.setAttribute("LIST_PIZZA", pList);
            List<CategoriesDTO> cList = cDao.getData();
            request.setAttribute("LIST_CATEGORY", cList);
            String action = request.getParameter("action");
            if (action == null) {

            } else if (action.equals("Login")) {
                url = LOGIN_SERVLET;
            } else if (action.equals("Signup")) {
                url = SIGNUP_SERVLET;
            } else if (action.equals("Logout")) {
                url = LOGOUT_SERVLET;
            } else if (action.equals("Insert")) {
                url = INSERT_PAGE;
            } else if (action.equals("Search")) {
                url = SEARCH_SERVLET;
            } else if (action.equals("Detail")) {
                url = DETAIL_SERVLET;
            } else if (action.equals("Edit")) {
                url = DETAIL_SERVLET;
            } else if (action.equals("Update")) {
                url = EDIT_SERVLET;
            } else if (action.equals("Add")) {
                url = INSERT_SERVLET;
            } else if (action.equals("Remove")) {
                url = REMOVE_SERVLET;
            } else if (action.equals("Add To Cart")) {
                url = ADD_TO_CART_SERVLET;
            } else if (action.equals("ViewCart")) {
                url = VIEW_CART_SERVLET;
            } else if (action.equals("Update Cart")) {
                url = UPDATE_CART_SERVLET;
            } else if (action.equals("Delete")) {
                url = DELETE_CART_SERVLET;
            } else if (action.equals("Order")) {
                url = ORDER_INFORMATION_PAGE;
            } else if (action.equals("Purchase")) {
                url = PURCHASE_SERVLET;
            } else if (action.equals("Clear")) {
                url = CLEAR_CART_SERVLET;
            } else if (action.equals("View History Orders")) {
                url = HISTORY_ORDER_SERVLET;
            } else if (action.equals("View Order Detail")) {
                url = ORDER_DETAIL_SERVLET;
            } else if(action.equals("View All Orders")) {
                url = VIEW_ALL_ORDERS_SERVLET;
            } else if(action.equals("Report Page")) {
                url = REPORT_PAGE;
            } else if(action.equals("Report")) {
                url = REPORT_SERVLET;
            } else if (action.equals("Best-Seller")) {
                url = BEST_SELLER_SERVLET;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
