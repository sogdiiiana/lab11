package org.example.lastlab11;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    // Home page route
    @GetMapping("/home")
    public String home() {
        return "Welcome to Home Page!";
    }

    // Services page route
    @GetMapping("/services")
    public String services() {
        return "<h2>Our Services </h2>"
                + "<ul>"
                + "<li>Web Development </li>"
                + "<li>Mobile App Development </li>"
                + "<li>SEO Optimization </li>"
                + "</ul>";
    }

    // About page route
    @GetMapping("/about")
    public String about() {
        return "<h2>About Our Application</h2>"
                + "<p>This application is a demo Spring Boot application that showcases URL mappings.</p>";
    }

    // FAQ page route
    @GetMapping("/faq")
    public String faq() {
        return "<h2>Frequently Asked Questions</h2>"
                + "<ul>"
                + "<li>What is Spring Boot?</li>"
                + "<li>How do I get started with Spring Boot?</li>"
                + "<li>What are the advantages of using Spring Boot?</li>"
                + "</ul>";
    }

    // Contact Us page route
    @GetMapping("/contact-us")
    public String contactUs() {
        return "<h2>Contact Information</h2>"
                + "<p>Email: contact@example.com</p>"
                + "<p>Phone: +123-456-7890</p>";
    }

    // Team page route
    @GetMapping("/team")
    public String team() {
        return "<h2>Our Team</h2>"
                + "<ul>"
                + "<li>John Doe - CEO</li>"
                + "<li>Jane Smith - CTO</li>"
                + "<li>Bob Johnson - Developer</li>"
                + "</ul>";
    }

    // Greet with query parameter
    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }

    // Mathematical operations
    @GetMapping("/calculate")
    public String calculate(@RequestParam int x, @RequestParam int y, @RequestParam String operation) {
        switch (operation.toLowerCase()) {
            case "add":
                return "Result: " + (x + y);
            case "subtract":
                return "Result: " + (x - y);
            case "multiply":
                return "Result: " + (x * y);
            case "divide":
                return y != 0 ? "Result: " + (x / y) : "Cannot divide by zero";
            default:
                return "Invalid operation";
        }
    }

    @GetMapping("/convert")
    public String convertTemperature(@RequestParam double temperature) {
        double fahrenheit = (temperature * 9/5) + 32;
        return "Temperature in Fahrenheit: " + fahrenheit;
    }

    @GetMapping("/discount")
    public String calculateDiscount(@RequestParam double originalPrice, @RequestParam double discountRate) {
        double discountedPrice = originalPrice - (originalPrice * discountRate / 100);
        return "Discounted Price: " + discountedPrice;
    }
}

@RestController
class StudentController {
    private String name = "Ali";
    private int age = 21;

    @GetMapping("/student")
    public String getStudent() {
        return "Student: " + name + ", Age: " + age;
    }

    @GetMapping("/is-adult/{age}")
    public String isAdult(@PathVariable int age) {
        return age >= 18 ? "Age " + age + ": You are an adult." : "Age " + age + ": You are not an adult.";
    }

    @GetMapping("/update-student/{newAge}")
    public String updateStudent(@PathVariable int newAge) {
        this.age = newAge;
        return "Updated student age: " + this.age;
    }
}

@RestController
class TeacherController {
    @GetMapping("/teacher")
    public String getTeacher() {
        return "Teacher: John, Subject: Mathematics";
    }
}

@RestController
class CourseController {
    @GetMapping("/course")
    public String getCourse() {
        return "Course: Java Programming, Duration: 3 months";
    }
}

@RestController
class BookController {
    @GetMapping("/book")
    public String getBook() {
        return "Book: Effective Java, Author: Joshua Bloch, Price: $45";
    }
}

