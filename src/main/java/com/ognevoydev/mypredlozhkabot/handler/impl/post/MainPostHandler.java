package com.ognevoydev.mypredlozhkabot.handler.impl.post;

import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.ognevoydev.mypredlozhkabot.utils.Utils.isMessageContainsPhoto;

@Component("mainPostHandler")
public class MainPostHandler implements PostHandler {

    @Autowired
    @Qualifier("photoPostHandler")
    private PostHandler photoPostHandler;
    @Autowired
    @Qualifier("videoPostHandler")
    private PostHandler videoPostHandler;

    @Override
    public Reply<?> handle(Message message) {
        long chatId = message.getChatId();
//        if(cache.mediagroupIds.contains(message.getMediaGroupId())) {
//            return handleGroupSuggesiton();
//        }
//        else {
            if(isMessageContainsPhoto(message)) {
                return photoPostHandler.handle(message);
            }
            else {
                return videoPostHandler.handle(message);
            }
//        }

    }
}
