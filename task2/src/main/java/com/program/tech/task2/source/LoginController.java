package com.program.tech.task2.source;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Optional;

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
        Optional<User> userOptional = loginDao.findByPasswordAndLogin(loginForm.getPassword(), loginForm.getLogin());
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return userOptional.get().getRole() + "Main";
        }
        attributes.addFlashAttribute("error", "Неправильный номер или пароль");
        return "redirect:login";
    }
}
