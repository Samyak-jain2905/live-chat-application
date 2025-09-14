//package com.chat.app.controller;
//
//import com.chat.app.model.ChatMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class ChatController {
//
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/messages")
//   public ChatMessage sendMesssage(ChatMessage message){
//       return message;
//   }
//   @GetMapping("chat")
//    public String chat(){
//        return "chat";
//   }
//
//}
package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("Received message: " + message);
        return new ChatMessage(message.getId(), message.getSender(), message.getContent());
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat"; // maps to src/main/resources/templates/chat.html
    }
}
