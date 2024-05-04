package in.amit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		return "Welcome to Patna";
	}
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		return "Good Morning..!!";
	}
}
