package id.ac.iuli.TelegramBot.utils.telegram;

public class RespondMessageTelegram {
    private String ok;
    private Result result;

    static public class Result{
        Long message_id;
        Long date; //unixtime
        String text;
        UpdateTelegram.From from;
        UpdateTelegram.Chat chat;
    }
}
