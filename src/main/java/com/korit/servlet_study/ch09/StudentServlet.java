package com.korit.servlet_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet("/study/students")
public class StudentServlet extends HttpServlet {
    private List<Student> students = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();
    private int autoId = 20250001;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        String searchNameValue = req.getParameter("searchName");
        if (Objects.isNull(searchNameValue)) {
            objectMapper.writeValue(resp.getWriter(), students);
        }
        List<Student> foundStudents = students.stream()
                .filter(student -> student.getName().contains(searchNameValue))
                .toList();

        objectMapper.writeValue(resp.getWriter(), foundStudents);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setContentType("application/json");

        Student student = objectMapper.readValue(req.getReader(), Student.class);
        student.setId(autoId++);
        students.add(student);

        objectMapper.writeValue(resp.getWriter(), Map.of("message", "학생 추가 완료"));

    }
}
