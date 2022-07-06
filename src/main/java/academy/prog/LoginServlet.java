package academy.prog;

import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "admin";
    // password "Welcome22!"

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String ageS = request.getParameter("age");
        int age = Integer.parseInt(ageS);
        PrintWriter out = response.getWriter();

        if (LOGIN.equals(login) && valPassword(password)&& age>18) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
            session.setAttribute("user_age", age);
            session.setAttribute("user_pass", password);
            response.sendRedirect("index.jsp");
        } else {
            out.println("Wrong login or password, please try again");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");
            session.removeAttribute("user_pass");
        response.sendRedirect("index.jsp");
    }
        public static boolean valPassword(String pass){
            boolean n;
            String row = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{10,}";
            if (pass.matches(row)) {
                return n = true;
            } else {
                return n = false;
            }
        }
    }


