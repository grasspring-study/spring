package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // http 요청이 오면 servlet container가 request, response 객체를 만들어서 이 servlet에 던져준다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); // 단축키 soutm
        System.out.println("request = " + request); // soutv
        System.out.println("response = " + response);

        String username = request.getParameter("username"); // 쿼리파라미터를 쉽게 받아올 수 있다. http://localhost:8080/hello?username=kim
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}