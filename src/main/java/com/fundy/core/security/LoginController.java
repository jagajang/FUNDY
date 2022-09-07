package com.fundy.core.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    //GetMapping  -> 서버한테 요청
    //PostMapping -> 요청 외 모든 기능 담당

    @GetMapping("/login")
    public String GetLoginPage(){
        return "login";
    }

    //login POST 내에서 필요한 Param 지정한 인수로 받아옴

    @PostMapping("/loginPost")
    public String GetLoginRequest(
            @RequestParam("user_id") String user_id,
            @RequestParam("user_pwd") String user_pwd
    ){
        System.out.println(user_id);
        System.out.println(user_pwd);
        return "index";
    }
}
