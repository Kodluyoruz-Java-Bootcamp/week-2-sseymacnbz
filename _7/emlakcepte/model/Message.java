package emlakcepte.model;

import emlakcepte.model.messageType.MessageType;

public class Message {
	
	private MessageType type;
	private String content;
	private User from;
	private User to;
	

	public Message(MessageType type, String content, User from, User to) {
		super();
		this.type = type;
		this.content = content;
		this.from = from;
		this.to = to;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	
	
	

}
