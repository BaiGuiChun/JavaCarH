package com.controller.root;

import com.entity.Page;
import com.service.carService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "R_addController",urlPatterns = {"/controller/root/R_addController"})
public class R_addController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url ="add.html?";
        String nowPageNum = req.getParameter("page");
        Page page =null;
        if (Tools.empty(nowPageNum)){
            nowPageNum ="1";
        }
        page=new carService().getSearchCar(Integer.parseInt(nowPageNum),url);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/WEB-INF/jsp/web/openIframe/add.jsp").forward(req,resp);
    }
}
