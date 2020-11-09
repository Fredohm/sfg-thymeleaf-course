package guru.springframework.controllers;

import guru.springframework.commands.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String getLoginForm(Model model) {

        model.addAttribute("loginCommand", new LoginCommand());

        return "loginform";
    }

    @RequestMapping("/logout-success")
    public String doLogout() {

        return "logout-success";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("loginCommand") LoginCommand loginCommand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "loginform";
        }

        return "redirect:/index";
    }
}
