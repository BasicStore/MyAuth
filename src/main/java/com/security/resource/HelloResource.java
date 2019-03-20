package com.security.resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {
	
	@GetMapping("/all")
	public String hello() {
		return "hello all";
	}

	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/all")
	public String adminHello() {
		return "admin all";
	}

	
}
