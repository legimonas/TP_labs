package com.program.tech.task2.source;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class AssignOrderToCompanyPageController {
    @Resource
    private OrderRepository repository;
    @Resource
    private DeliveryCompanyRepository deliveryCompanyRepository;

    @GetMapping("order/assign")
    public String showAssignCompanyList(Model model) {
        model.addAttribute("orders", repository.findAll());
        return "orderList";
    }

    @GetMapping("order/assign/{id}")
    public String showAssignCompanyToOrder(Model model, @PathVariable("id") Long id) {
        model.addAttribute("order", repository.findById(id).get());
        model.addAttribute("companies", deliveryCompanyRepository.findAll());
        return "assignCompanyToOrder";
    }

    @PostMapping("order/assign/{id}")
    public String assignCompanyToOrder(Model model, @PathVariable("id") Long id, @RequestParam("companyId") Long companyId) {
        Ordered order = repository.findById(id).get();
        order.setDelivery(deliveryCompanyRepository.findById(companyId).get().getName());
        repository.save(order);
        return "redirect:/order/assign";
    }
}
