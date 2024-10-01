package dev.igor.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import dev.igor.chat.domain.ChatInput;
import dev.igor.chat.domain.ChatOutput;

@Controller
public class LiveChatController {
    @MessageMapping("/new-message")
    @SendTo("/topics/chat")
    public ChatOutput newMessage(ChatInput input) {
        return new ChatOutput(HtmlUtils.htmlEscape(input.user() + ": " + input.message()));
    }
}
