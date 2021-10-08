package com.auth.bcrypt;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BcryptController
{
    @Autowired
    InputUserRepository inputUserRepository;
    @GetMapping("/longin")
    public String goToLogin()
    {
        return "login";
    }
    @GetMapping("/signup")
    public String goToSignUp()
    {
        return "signup";
    }
    @PostMapping("/login")
    public RedirectView logInUser(Model m, String username, String password)
    {
        InputUser userFromDb = inputUserRepository.findByUserName(username);
        if(userFromDb == null || !BCrypt.checkpw(password, userFromDb.password))
        {
            return new RedirectView("/login");
        }
        return new RedirectView("/");
    }
    @PostMapping("/signup")
    public RedirectView signUpUser(Model m, String username, String password)
    {

        String hashedPW = BCrypt.hashpw(password, BCrypt.gensalt(12));
        InputUser inputUser= new InputUser(username, hashedPW);

        inputUserRepository.save(inputUser);
        return new RedirectView("/login");
    }
}
