package com.healthcare_application.HealthCare.chat.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcare_application.HealthCare.chat.entity.ChatMessage;

@Service
public class ChatService 
{


	private final List<ChatMessage> messages = new ArrayList<>();


	public ChatMessage sendMessage(String sender, String receiver, String message) 
	{
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setSender(sender);
		chatMessage.setReceiver(receiver);
		chatMessage.setMessage(message);
		chatMessage.setTimestamp(LocalDateTime.now());
		messages.add(chatMessage);
		return chatMessage;
	}


	public List<ChatMessage> getChatHistory(String user1, String user2) 
	{
		List<ChatMessage> history = new ArrayList<>();
		for (ChatMessage msg : messages) {
			if ((msg.getSender().equals(user1) && msg.getReceiver().equals(user2)) ||
					(msg.getSender().equals(user2) && msg.getReceiver().equals(user1))) 
			{
				history.add(msg);
			}
		}
		return history;
	}
}
