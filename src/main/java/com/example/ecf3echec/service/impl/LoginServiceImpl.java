package com.example.ecf3echec.service.impl;

import com.example.ecf3echec.entity.Player;
import com.example.ecf3echec.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(Player player) {
        String email = player.getEmail();
        String password = player.getPassword();

        if (email.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

}
