package discord;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;

public class Bot extends ListenerAdapter
{
    private boolean isDelete = false;
    public static void main (String[] args)
    {
        String token = System.getenv("TOKEN_KEY");
        if (token == null) {
            System.out.println("토큰 정보가 없습니다.");
            return;
        }
        try {
            JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                    .addEventListeners(new Bot())
                    .setActivity(Activity.playing("번역"))
                    .build();
        } catch (LoginException e) {
            System.out.println("wrong token");
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        User author = event.getAuthor();
        if (msg.getContentRaw().startsWith("!"))
        {
            MessageChannel channel = event.getChannel();
            if (msg.getContentRaw().substring(1).equals("모드 바꾸기")) {
                isDelete = !isDelete;
                if (isDelete) channel.sendMessage("보낸 메시지를 지웁니다.").queue();
                else channel.sendMessage("보낸 메시지를 지우지 않습니다.").queue();
            } else {
                String responseMsg = author.getName() + ": " + new TypoCorrectionEngToKor(msg.getContentRaw().substring(1)).translate();
                channel.sendMessage(responseMsg).queue();
                if (isDelete) msg.delete().queue();
            }
        }
    }
}

