package org.aman.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.aman.messenger.model.Message;
import org.messenger.database.DatabaseClass;

import com.aman.messenger.Exception.DataNotFoundException;
import com.aman.messenger.Exception.DataNotFoundExceptionMapper;

public class MessageService {

private Map<Long, Message> messages = DatabaseClass.getMessages();
	

	//Create constructor to see few hard coded messages when we hit first time GET request.
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Aman"));
		messages.put(2L, new Message(2, "Hello Jersey", "Bansal"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	
	public Message getMessage(long id) {
		Message message =  messages.get(id);
		if(message == null){
			new DataNotFoundExceptionMapper().toResponse(new DataNotFoundException("Message with ID:" + id + "- Not found"));
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
		
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
}
