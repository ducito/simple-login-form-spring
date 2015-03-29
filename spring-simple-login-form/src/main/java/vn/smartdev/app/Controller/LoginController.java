package vn.smartdev.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.smartdev.app.Models.UserModel;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLogin(Model model, UserModel userModel) {
        model.addAttribute("user", userModel);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("user") UserModel userModel, Model model, HttpSession session) {
        System.out.println(userModel.getUsername() + "|" + userModel.getPassword());
        if (userModel.getUsername().equals("admin"))
            if (userModel.getPassword().equals("123456")) {
                model.addAttribute("message", "Login successful!");
                session.setAttribute("username", userModel.getUsername());
                return "welcome";
            }
        model.addAttribute("message", "Login fail!");
        return "login";

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String doLogout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:login";
    }
}