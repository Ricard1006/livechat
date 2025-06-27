package ricardoproducts.livechat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import ricardoproducts.livechat.damain.ChatInPut;
import ricardoproducts.livechat.damain.ChatOutPut;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutPut newMessage(ChatInPut inPut) {
        return new ChatOutPut(HtmlUtils.htmlEscape(inPut.user() + ": " + inPut.message()));
    }
}
