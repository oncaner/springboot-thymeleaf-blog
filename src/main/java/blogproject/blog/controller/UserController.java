package blogproject.blog.controller;

import blogproject.blog.dto.request.CreateUserRequest;
import blogproject.blog.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", this.userService.getAllUsers());

        return "users";
    }

    @GetMapping("/register")
    public String showUserForm(Model model) {
        model.addAttribute("user", new CreateUserRequest());

        return "register";
    }

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute("user") CreateUserRequest createUserRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        this.userService.createUser(createUserRequest);

        return "redirect:/users";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        this.userService.deleteUserById(id);

        return "redirect:/users";
    }

}
