//package org.example.mpp_backend.controller;
//
//import org.example.mpp_backend.service.UserService;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import jakarta.validation.Valid;
//
//import org.example.mpp_backend.dto.UserDto;
//import org.example.mpp_backend.entities.User;
//
//@CrossOrigin("*")
//@RequestMapping("/api/authentication")
//@RestController
//public class AuthController {
//
//    private final UserService userService;
//
//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }
//
//    //handler method to handle home page request
//    @GetMapping("/index")
//    public String home()
//    {
//        return "index";
//    }
//
//    //handler method to handle login request
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    //handler method to handle user registration from request
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        //create model object to store form data
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "register";
//    }
//
//    //handler method to handle user registration from submit request
//    @PostMapping("/register/save")
//    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, Model model) {
//        User existingUser = userService.findUserByEmail(userDto.email);
//
//        if (existingUser != null && existingUser.getUserEmail() != null && !existingUser.getUserEmail().isEmpty()) {
//            bindingResult.rejectValue("userEmail", null, "There is already a user registered with that email");
//        }
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("user", userDto);
//            return "/register";
//        }
//
//        userService.saveUser(userDto);
//        return "redirect:/register?success";
//    }
//
//    //handler method to handle list of users
//    @GetMapping("/users")
//    public String showUsers(Model model) {
//        model.addAttribute("users", userService.findAllUsers());
//        return "users";
//    }
//}
