//package com.chat.app.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/chat")
//                .setAllowedOrigins("http://localhost:8080")
//                .withSockJS();
//    }
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//// set message broker
//        // expect message with /app/sendmessage
//
//        registry.enableSimpleBroker("/topic");  // /topic/chatroom1
//        registry.setApplicationDestinationPrefixes("/app");
//
//    }
//}
package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOriginPatterns("*") // allows frontend to connect
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");  // messages broadcasted here
        registry.setApplicationDestinationPrefixes("/app"); // messages sent here
    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        // Ensure JSON serialization
        messageConverters.add(new MappingJackson2MessageConverter());
        return false; // keep default converters too
    }
}
