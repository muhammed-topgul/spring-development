package com.muhammedtopgul.petclinic.web;

/*
 * created by Muhammed Topgul
 * on 06/04/2021
 * at 23:12
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.getWriter().append("Servlet get at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Servlet post at: ").append(request.getContextPath());
    }
}
