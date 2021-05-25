package com.program.tech.task2.source;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateOrderPageController {

    @GetMapping("order/create")
    public String showForm(Model model) {
        return "createOrder";
    }

    @PostMapping("order/create")
    public String successCreated(Model model) {
        model.addAttribute("success", "Success");
        return "createOrder";
    }
}
