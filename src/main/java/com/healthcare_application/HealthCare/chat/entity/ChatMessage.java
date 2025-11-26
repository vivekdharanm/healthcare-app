

@Entity
@Table(name = "chat_messages")
@Getter
@Setter
public class ChatMessage 
{


	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String sender;
	private String receiver;
	private String message;
	private LocalDateTime timestamp;
}
