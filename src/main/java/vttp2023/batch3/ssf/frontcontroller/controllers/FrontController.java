package vttp2023.batch3.ssf.frontcontroller.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp2023.batch3.ssf.frontcontroller.Model.User;


@Controller
@RequestMapping
public class FrontController {

	// TODO: Task 2, Task 3, Task 4, Task 6
	@GetMapping(path = "/")
	public String showLoginPage(User user, Model m){

		m.addAttribute("user", user);

		return "view0";
	}


	@PostMapping(path="/login", consumes = "application/x-www-form-urlencoded", produces = "text/html")
	public String loginUser(@Valid User user, BindingResult br, Model m ){

		if (br.hasErrors()){

			return "view0";
			
		}else {

			
			return "test";

		}

		

		
	}




}
