package io.kevinyang0127.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint(value = "/webSocket/{nickName}")
public class WebSocketController {

    @OnOpen
    public void onOpen(@PathParam(value = "nickName") String nickName, Session session){
        if(WebSocketUtil.addSession(nickName,session)){
            String msg = "[" + nickName + "] 加入pollex匿名聊天室囉~~";
            System.out.println(msg);
            WebSocketUtil.sendMessageForAll(msg);
        }else{
            String msg = "[" + nickName + "] 名稱已被使用囉~ \n換個名子重新登入吧!!";
            System.out.println(msg);
            WebSocketUtil.sendMessage(session,msg);
        }
    }

    @OnClose
    public void onClose(@PathParam(value = "nickName") String nickName, Session session){
        String msg = "[" + nickName + "] 退出pollex匿名聊天室囉 QAQ";
        System.out.println(msg);
        WebSocketUtil.removeSession(nickName);
        WebSocketUtil.sendMessageForAll(msg);
    }

    @OnMessage
    public void onMessage(String msgDataJsonStr) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MsgData msgData = objectMapper.readValue(msgDataJsonStr, MsgData.class);

            if (msgData.getTargetName().equals("public")) {
                String systemInfo = "[" + msgData.getNickName() + "] : " + msgData.getChatMsg();
                System.out.println(systemInfo);
                WebSocketUtil.sendMessageForAll(systemInfo);
            } else {
                String systemInfo = "[" + msgData.getNickName() + " ---> " + msgData.getTargetName() + "] : " + msgData.getChatMsg();
                System.out.println(systemInfo);
                WebSocketUtil.sendMessageTo(msgData.getNickName(), systemInfo);
                WebSocketUtil.sendMessageTo(msgData.getTargetName(), systemInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("Error:" + throwable);
        try {
            session.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }

}
