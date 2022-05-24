package com.example.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clanId = request.getParameter("clanId");
        long l = Long.parseLong(clanId);
        String gold = request.getParameter("gold");
        int i = Integer.parseInt(gold);
        ClanController controller = new ClanController();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                controller.incGold(l, i);
            }
        });
        t1.start();

    }

    public void destroy() {
    }
}