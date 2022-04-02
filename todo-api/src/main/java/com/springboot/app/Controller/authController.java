package com.springboot.app.Controller;

import com.springboot.app.Entity.AppUser;
import com.springboot.app.Entity.Auth;
import com.springboot.app.Service.userService;
import com.springboot.app.security.tokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/todo/auth")
public class authController {
        @Autowired
        private tokenUtil tokenUtil;

        @Autowired
        private userService userService;

        @Autowired
        private AuthenticationManager authenticationManager;

        @PostMapping(value = "")
        public  String signin(@RequestBody Auth auth){
            System.out.println(auth);
            final Authentication authentication=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(auth.getUserName(),auth.getPassword()) );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails user=userService.loadUserByUsername(auth.getUserName());
                String token=tokenUtil.generateToken(user);
                return token;
            }

}

