package guru.springframework.controllers;

import guru.springframework.commands.CheckOutCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CheckOutController {

    @RequestMapping("/checkout")
    public String checkOutForm(Model model) {

        model.addAttribute("checkoutCommand", new CheckOutCommand());

        return "checkoutform";
    }

    @RequestMapping(value = "/doCheckout", method = RequestMethod.POST)
    public String doCheckout(@Valid @ModelAttribute("checkoutCommand") CheckOutCommand checkoutCommand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "checkoutform";
        }

        return "checkoutcomplete";
    }
}
