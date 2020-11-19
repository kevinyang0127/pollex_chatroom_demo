package io.kevinyang0127.demo;

import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class WebSocketUtil {
    private static final Map<String , Session> ONLINE_SESSION = new ConcurrentHashMap<>();

    public static boolean addSession(String nickName, Session session){
        if(!ONLINE_SESSION.containsKey(nickName)){
            ONLINE_SESSION.put(nickName,session);
            return true;
        }
        return false;
    }

    public static void removeSession(String nickName){
        ONLINE_SESSION.remove(nickName);
    }

    public static void sendMessage(Session session, String msg){
        if(session == null){
            return;
        }

        Async async = session.getAsyncRemote();
        async.sendText(msg);
    }

    public static void sendMessageForAll(String msg){
        ONLINE_SESSION.forEach((nickName,session) -> {
            sendMessage(session,msg);
        });
    }

    public static void sendMessageTo(String nickName, String msg){
        sendMessage(ONLINE_SESSION.get(nickName), msg);
    }

    public static List<String> getLoginList(){
        List<String> loginList = new ArrayList<>();
        ONLINE_SESSION.forEach((s, session) -> {
            loginList.add(s);
        });
        return loginList;
    }
}
