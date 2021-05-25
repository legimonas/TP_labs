package com.program.tech.task2.source;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LoginDao {
    @Resource
    LoginRepository loginRepository;

    public boolean existUser(User user) {
        return loginRepository.findByPasswordAndLogin(user.getPassword(), user.getLogin()).isPresent();
    }

    public void getRole(User user) {
        User defaultUser = new User();
        defaultUser.setRole("ANONYMOUS");
        user.setRole(loginRepository.findByPasswordAndLogin(user.getPassword(), user.getLogin()).orElse(defaultUser).getRole());
    }
}
