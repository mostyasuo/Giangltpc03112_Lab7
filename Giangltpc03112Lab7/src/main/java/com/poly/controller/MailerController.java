package com.poly.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.MessagingException;

@Controller
public class MailerController {
	@Autowired
	MailerServiceImpl impl;
	
	
	@GetMapping("send-mail")
	String sendMail() {
		return "Mail/SendMail";
	}
	
	
	@PostMapping("send-mail")
	public String demo(@RequestParam("recipient")String recipient,
						@RequestParam("subject")String subject,
						@RequestParam("message")String message,
						Model model) {
		
		System.out.println(recipient);
		MailInfo mail = new MailInfo(recipient,subject,message);
		impl.queue(mail);
		impl.queue(mail);
		impl.queue(mail);
		model.addAttribute("contend","Gửi email thành công");
		return "redirect:/send-mail";
	}
}
