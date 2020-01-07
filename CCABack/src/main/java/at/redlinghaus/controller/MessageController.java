package at.redlinghaus.controller;

import at.redlinghaus.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;


}
