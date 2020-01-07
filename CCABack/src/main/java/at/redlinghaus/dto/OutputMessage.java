package at.redlinghaus.dto;

import lombok.Data;

@Data
public class OutputMessage extends ChatMessage {
    private String time;

    public OutputMessage(String from, String text, String time) {
        setSender(from);
        setContent(text);
        this.time = time;
    }
}
