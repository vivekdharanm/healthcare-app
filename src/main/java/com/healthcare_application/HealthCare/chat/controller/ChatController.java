package com.healthcare_application.HealthCare.chat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare_application.HealthCare.chat.entity.ChatMessage;
import com.healthcare_application.HealthCare.chat.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController 
{


	private final ChatService chatService;


	public ChatController(ChatService chatService) 
	{
		this.chatService = chatService;
	}


	@PostMapping("/send")
	public ChatMessage sendMessage(@RequestParam String sender, @RequestParam String receiver, @RequestParam String message) 
	{
		return chatService.sendMessage(sender, receiver, message);
	}


	@GetMapping("/history")
	public List<ChatMessage> getChatHistory(@RequestParam String user1, @RequestParam String user2) 
	{
		return chatService.getChatHistory(user1, user2);
	}
}
