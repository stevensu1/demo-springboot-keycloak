package com.example.demospringbootkeycloak.demos.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/web")
public class WebController {

    // http://127.0.0.1:8080/web/index
    @ResponseBody
    @GetMapping(path = "/index")
    @PreAuthorize("hasRole('user-role11')")
    public String index() {
        return "index";
    }

    // http://127.0.0.1:8080/web/logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    // http://127.0.0.1:8080/web/customers
    @GetMapping(path = "/customers")
    @ResponseBody
    public String customers(Principal principal, Model model) {
        return "customers";
    }
}
