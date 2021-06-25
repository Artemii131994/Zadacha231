package mvc.controller;

import mvc.model.User;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUser(Model model) {

        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);

        return "userList";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){

        User user = new User();
        model.addAttribute("user",user);
        return "createUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/update")
    public String edit(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
