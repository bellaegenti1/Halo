package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("username");
        
        if (request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        else {
            if (user == null || user.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            else {
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        ArrayList<String> shoppingList = (ArrayList<String>)session.getAttribute("items");
        
        // Respond according to reaction parameter
        switch (action) {
            case "register": 
                String username = request.getParameter("username");
                session.setAttribute("username", username);               
                shoppingList = new ArrayList<>();
                session.setAttribute("items", shoppingList);
                break;
            
            case "add":
                String item = (String)request.getParameter("itemToAdd");
                shoppingList.add(item);
                session.setAttribute("itemNumber", shoppingList.size());
                break;
            
            case "delete":
                // get the index of item to be removed
                int itemToRemove = Integer.parseInt((String)request.getParameter("addedItem"));               
                shoppingList.remove(itemToRemove);
                session.setAttribute("itemNumber", shoppingList.size());
                break;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
    }
}
