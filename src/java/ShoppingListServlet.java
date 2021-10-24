
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bellaegenti1
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        
        
        
        if(action!=null){
            
            if(action.equals("logout")){
            
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
            return;
            }  
        }
        
        if(session.getAttribute("userName") == null){
            //response.sendRedirect("register");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
            return;
        }
     
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request,response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String userName = request.getParameter("username");
        
        if(action!=null && action.equals("register")){
            //response.sendRedirect("register");
            
            if( userName == null || userName.equals("")){
                request.setAttribute("nameIsNull", true);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
                return;
            }
            session.setAttribute("userName", userName);
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request,response);
            return;
        }
        
        ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
        
        if (items == null)
            items = new ArrayList<>();
        
        if (request.getParameter("action") != null && request.getParameter("action").equals("add")) {
            
            items.add(request.getParameter("item"));

            session.setAttribute("items", items);
            response.sendRedirect("ShoppingList");
            return;
        }
 
        
        if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
            
            String selected = request.getParameter("itemList");
            items.remove(selected);
            response.sendRedirect("ShoppingList");
            return;
        }
        
    }

}
