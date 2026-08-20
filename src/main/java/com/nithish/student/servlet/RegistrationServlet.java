package com.nithish.student.servlet;

import com.nithish.student.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\p{L}][\\p{L} .'-]{2,49}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final List<String> COURSES = List.of(
            "B.Tech Computer Science", "B.Tech Artificial Intelligence",
            "BCA", "MCA", "B.Sc Data Science", "M.Tech Computer Science"
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("courses", COURSES);
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = clean(request.getParameter("name"));
        String email = clean(request.getParameter("email")).toLowerCase();
        String course = clean(request.getParameter("course"));

        Map<String, String> errors = new LinkedHashMap<>();
        if (name.isEmpty()) errors.put("name", "Name is required.");
        else if (!NAME_PATTERN.matcher(name).matches()) errors.put("name", "Enter a valid name (3–50 characters).");
        if (email.isEmpty()) errors.put("email", "Email ID is required.");
        else if (!EMAIL_PATTERN.matcher(email).matches()) errors.put("email", "Enter a valid email address.");
        if (course.isEmpty()) errors.put("course", "Please select a course.");
        else if (!COURSES.contains(course)) errors.put("course", "Please select a valid course.");

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("selectedCourse", course);
            doGet(request, response);
            return;
        }

        Student student = new Student(name, email, course);
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Student> students = (List<Student>) session.getAttribute("students");
        if (students == null) {
            students = new ArrayList<>();
            session.setAttribute("students", students);
        }
        students.add(student);
        session.setAttribute("registeredStudent", student);
        response.sendRedirect(request.getContextPath() + "/success");
    }

    private String clean(String value) {
        return value == null ? "" : value.trim().replaceAll("\\s+", " ");
    }
}
