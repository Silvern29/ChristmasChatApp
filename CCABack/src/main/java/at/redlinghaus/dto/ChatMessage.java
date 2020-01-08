package at.redlinghaus.dto;

import lombok.Data;

@Data
public class ChatMessage {

    private MessageType type;
    private String sender;
    private String content;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}