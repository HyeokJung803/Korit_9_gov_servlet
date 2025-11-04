package com.korit.servlet_study.ch05;

public class ServletB extends Servlet {
    @Override
    public void doGet(Request req, Response resp) {
        System.out.println("서블릿 B에서 GET 호출");
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.setCharactorEncoding("UTF-8");
        resp.setData("응답데이터");
    }

    @Override
    public void doPost(Request req, Response resp) {
        System.out.println("서블릿 B에서 POST 호출");
    }
}
