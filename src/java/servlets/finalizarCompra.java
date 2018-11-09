/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Carrinho;
import classes.Produto;
import classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author eduardo.podgornik
 */
public class finalizarCompra extends HttpServlet {

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
 
            /* TODO output your page here. You may use following sample code. */
           
            HttpSession session = request.getSession();
            
            
            
            try{
            String host ="smtp.gmail.com" ;
            String user = "email.faculdade1332@gmail.com";
            String pass = "123qweasddsaewq321";
           
            String from = "email.faculdade1332@gmail.com";
            String subject = "Confirmação de Compra";
            String messageText = "Recentemente você finalizou uma compra no nosso site. Os itens comprados foram:\n";
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            
            if (usuario == null)
            {
                 response.getWriter().write("Faça login para finalizar a compra!");
            }
            else { 
            String to = usuario.getEmail();
             Carrinho carro = (Carrinho) session.getAttribute("carrinho");
             LinkedList<Produto> lista = carro.getLista();
             DecimalFormat df = new DecimalFormat("#.##");
             
             for(Produto obj: lista)
             {
                 messageText += obj.getNome() + "  R$"+df.format(obj.getPreco()) +"\n";
                
             }
             messageText += "Total: R$" + df.format(carro.getTotal())+"\n";
             messageText += "Agradecemos pela compra. Volte sempre!!!";
             carro.setLista(lista);
             session.setAttribute("carrinho", carro);
             
             
             
             
             
//            boolean sessionDebug = false;
//
//            Properties props = System.getProperties();
//
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", host);
//            props.put("mail.smtp.port", "587");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.required", "true");
//
//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//            Session mailSession = Session.getDefaultInstance(props, null);
//            mailSession.setDebug(sessionDebug);
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(from));
//            InternetAddress[] address = {new InternetAddress(to)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject); msg.setSentDate(new Date());
//            msg.setText(messageText);
//
//           Transport transport=mailSession.getTransport("smtp");
//           transport.connect(host, user, pass);
//           transport.sendMessage(msg, msg.getAllRecipients());
//           transport.close();
           
           
           LinkedList<Produto> lista2 = new LinkedList<Produto>();
           carro.setLista(lista2);
           carro.setTotal(0.0);
           session.setAttribute("carrinho", carro);
           
           response.getWriter().write(messageText);
           
           
            }
             
           
        }catch(Exception ex)
        {
          response.getWriter().write(ex.toString());
           
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
