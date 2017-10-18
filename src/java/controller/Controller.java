/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOPart;
import DAO.DAOUser;
import Model.Part;
import Model.User;
import com.sun.org.apache.bcel.internal.generic.D2F;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utility.DBUtil;

/**
 *
 * @author Carlos Correa
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

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
        Connection conexion = DBUtil.getConexion();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        String opcion = (String) request.getParameter("opcion");
        String mail = (String) request.getParameter("mail");
        String password = (String) request.getParameter("password");

        if (opcion != null) {
            System.out.println("El valor de la opcion es " + opcion);
            if (opcion.equals("login")) {
                try {
                    login(request, response, mail, password);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);

                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("register")) {
                try {
                    register(request, response, mail, password);
                } catch (Exception ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);

                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (opcion.equals("partCreated")) {
                 String namePart = (String) request.getParameter("name");
                int weightsupported = Integer.parseInt((String) request.getParameter("weightsupported"));
                int batteryCells = Integer.parseInt((String) request.getParameter("batteryCells"));
                String esc = (String) request.getParameter("esc");
                String propeller = (String) request.getParameter("propeller");
                DAOPart daoPart = new DAOPart();

                try {
                    daoPart.save(namePart, weightsupported, batteryCells, esc, propeller);
                    List<Part> partList = daoPart.getAllParts();
                    // Coloca la listaUsuario en variables de sesión para que ésta pueda ser
                    // accedida en la página listarUsuarios.jsp
                    request.setAttribute("partList", partList);
                    // Invoca la página de listar usuario
                    RequestDispatcher vista = request.getRequestDispatcher("listPart.jsp");
                    vista.forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);

                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (opcion.equals("listUsers")) {
               
                try {
                    listUsers(request, response);
                } catch (Exception ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);

                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (opcion.equals("listParts")) {
                try {
                    listParts(request, response);
                } catch (Exception ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);

                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (opcion.equals("deletePart")) {
                int partId = Integer.parseInt((String) request.getParameter("partId"));

                DAOPart daoPart = new DAOPart();
                try {
                    daoPart.delete(partId);
                    List<Part> partList = daoPart.getAllParts();
                    // Coloca la listaUsuario en variables de sesión para que ésta pueda ser
                    // accedida en la página listarUsuarios.jsp
                    request.setAttribute("partList", partList);
                    // Invoca la página de listar usuario
                    RequestDispatcher vista = request.getRequestDispatcher("listPart.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (opcion.equals("deleteUser")) {
                int userId = Integer.parseInt((String) request.getParameter("userId"));

                DAOUser daoUser = new DAOUser();
                try {
                    daoUser.delete(userId);
                    List<User> userList = daoUser.getAllUsers();
                    // Coloca la listaUsuario en variables de sesión para que ésta pueda ser
                    // accedida en la página listarUsuarios.jsp
                    request.setAttribute("userList", userList);
                    // Invoca la página de listar usuario
                    RequestDispatcher vista = request.getRequestDispatcher("listUsers.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (opcion.equals("createUser")) {
                try {
                    DAOUser daoUser = new DAOUser();
                    List<User> userList = daoUser.getAllUsers();
                    // Coloca la listaPais en variables de sesión para que ésta pueda ser
                    // accedida en la página registrese.jsp
                    request.setAttribute("userList", userList);

                    RequestDispatcher vista = request.getRequestDispatcher("createUser.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);

                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (opcion.equals("createPart")) {
                try {
                    DAOPart daoPart = new DAOPart();
                    List<Part> partList = daoPart.getAllParts();
                    // Coloca la listaPais en variables de sesión para que ésta pueda ser
                    // accedida en la página registrese.jsp
                    request.setAttribute("partList", partList);

                    RequestDispatcher vista = request.getRequestDispatcher("createPart.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());

                    request.getRequestDispatcher("/error.jsp").forward(request, response);

                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

//            if (opcion.equals("createdUser")) {
//                try {
//                    register(request, response, mail, password);
//                    listUsers(request, response);
//
//                } catch (SQLException ex) {
//                    System.out.println("Excepción: " + ex.getMessage());
//
//                    request.getRequestDispatcher("/error.jsp").forward(request, response);
//
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response, String mail, String password) throws ServletException, SQLException, IOException {
        DAOUser daoUser = new DAOUser();
        RequestDispatcher vista = null;

        try {
            daoUser.save(mail, password);
            vista = request.getRequestDispatcher("/home.jsp");
            List<User> userList = daoUser.getAllUsers();
            // Coloca la listaUsuario en variables de sesión para que ésta pueda ser
            // accedida en la página listarUsuarios.jsp
            request.setAttribute("userList", userList);

        } catch (Exception e) {
            vista = request.getRequestDispatcher("/error.jsp");

        }
        vista.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response, String mail, String password) throws ServletException, SQLException, IOException {
        DAOUser daoUser = new DAOUser();
        RequestDispatcher vista = null;

        List<User> userList = daoUser.getAllUsers();
        // Coloca la listaUsuario en variables de sesión para que ésta pueda ser
        // accedida en la página listarUsuarios.jsp
        request.setAttribute("userList", userList);
        for (User user : userList) {
            String umail = user.getMail();
            String upass = user.getPassword();
            if (umail.equals(mail) && upass.equals(password)) {
                vista = request.getRequestDispatcher("/home.jsp");
            }
        }
        if (vista == null) {
            vista = request.getRequestDispatcher("/error.jsp");
        }
        vista.forward(request, response);
    }

    public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        DAOUser daoUser = new DAOUser();
        RequestDispatcher vista = null;

        List<User> userList = daoUser.getAllUsers();
        // Coloca la listaUsuario en variables de sesión para que ésta pueda ser
        // accedida en la página listarUsuarios.jsp
        request.setAttribute("userList", userList);
        vista = request.getRequestDispatcher("listUsers.jsp");
        vista.forward(request, response);
    }

    private void listParts(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        DAOPart daoPart = new DAOPart();
        RequestDispatcher vista = null;

        List<Part> partList = daoPart.getAllParts();
        // Coloca la listaUsuario en variables de sesión para que ésta pueda ser
        // accedida en la página listarUsuarios.jsp
        request.setAttribute("partList", partList);
        vista = request.getRequestDispatcher("/listPart.jsp");
        vista.forward(request, response);
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

        try {
            String mail = request.getParameter("mail");
            String password = request.getParameter("password");

            DAOUser daoUser = new DAOUser();
            daoUser.save(mail, password);

            listUsers(request, response);
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            out.println(u.toString());
        } catch (SQLException ex) {
            System.out.println("Excepción: " + ex.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);

            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
