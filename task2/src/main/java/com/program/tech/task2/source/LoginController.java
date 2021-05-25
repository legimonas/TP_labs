package com.program.tech.task2.source;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@SessionAttributes("loginForm")
public class LoginController {
    @Resource
    LoginDao loginDao;

    @GetMapping("/login")
    public String getForm(Model model) {
        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new LoginForm());
        }
        return "login-page";
    }

    @PostMapping("/login")
    public String authorization(LoginForm loginForm, RedirectAttributes attributes, Model model) {
        User user = new User();
        user.setPassword(loginForm.getPassword());
        user.setLogin(loginForm.getLogin());
        if (loginDao.existUser(user)) {
            loginDao.getRole(user);
            String view = checkRole(user.getRole());
            return view;
        }
        attributes.addFlashAttribute("error", "Неправильный номер или пароль");
        return "redirect:login";
    }

    private String checkRole(String role) {
        String view = "redirect:login";
        switch (role) {
            case "PRODUCT_MANAGER":
                view = "productManagerMain";
                break;
            case "CATALOG_MANAGER":
                view = "catalogManagerMain";
                break;
            case "TRANSPORT_MANAGER":
                view = "transportManagerMain";
                break;
            case "SALESMAN":
                view = "salesmanMain";
                break;
        }
        return view;
    }
}
