package id.ac.iuli.TelegramBot.utils.telegram;

import java.util.List;

public class UpdateTelegram {
    private Long update_id;
    private Message message;

    static public class Message{
        Long message_id;
        Long date; //unixtime
        String text;
        From from;
        Chat chat;
        List<Entity> entities;
    }

    static public class From{
        Long id;
        boolean is_bot;
        String first_name;
        String last_name;
        String language_code;

    }

    static public class Chat{
        Long id;
        boolean is_bot;
        String first_name;
        String last_name;
        String type;
    }

    static public class Entity {
        int offset;
        int length;
        String type; //bot_command, mention
    }
}
