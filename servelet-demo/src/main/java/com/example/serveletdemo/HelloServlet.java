package com.example.serveletdemo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


// http://localhost:8080/servelet_demo_war/hello-servlet


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        int bufferSize = response.getBufferSize();

        System.out.println("buffer size: " + bufferSize);
    }

    public void destroy() {
    }
}