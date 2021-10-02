package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping ("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        // System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {
        double c = 0;
        switch(action){
            case "multiplication" :
                c = a * b;
                break;
            case "addition" :
                c = a + b;
                break;
            case "substraction" :
                c = a - b;
                break;
            case "division" :
                c = a / (double)b;
                break;
            default:
                System.out.println("Название операции введено неверно");
                break;
        }
        /*if (action.equals("multiplication")) c = a * b;
        else if (action.equals("addition")) c = a + b;
        else if (action.equals("substraction")) c = a - b;
        else if (action.equals("division")) c = a / b;
        else System.out.println("Название операции введено неверно");*/


        model.addAttribute("message", "Result of " + action + "is " + c);
        return "first/calculator";
    }

// один из способов передачи значений параметров
//@Controller
//@RequestMapping ("/first")
//public class FirstController {
//
//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        System.out.println("Hello, " + name + " " + surname);
//
//        return "first/hello";
//    }
    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

}
