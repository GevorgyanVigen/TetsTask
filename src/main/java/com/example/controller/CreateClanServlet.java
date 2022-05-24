package com.example.controller;

import com.example.repository.ClanManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateClanServlet", value = "/CreateClanServlet")
public class CreateClanServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clanId = request.getParameter("clanId");
        long clan_id = Long.parseLong(clanId);
        ClanManager.saveClan(clan_id);


    }
}
