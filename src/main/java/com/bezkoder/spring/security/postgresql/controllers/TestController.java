package com.bezkoder.spring.security.postgresql.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/codetest")
	public String codetest() {
		Integer a=new Integer(3);    
		int i=a.intValue();//converting Integer to int explicitly  
		int j=a;//unboxing, now compiler will write a.intValue() internally    
		    
		System.out.println(a+" "+i+" "+j); 
		String result=a+" "+i+" "+j;
		return result;
	}
	@GetMapping("/primenumbers")
	public String primeNumbers() {
		int num = 20, count;
		String result = "primenumbers";
		  for (int i = 1; i <= num; i++) {
		   count = 0;
		   for (int j = 2; j <= i / 2; j++) {
		    if (i % j == 0) {
		     count++;
		     break;
		    }
		   }

		   if (count == 0) {
		    System.out.println(i);
		     result += "--"+i;
		    
		   }

		  }
		  return result;
	}
}
