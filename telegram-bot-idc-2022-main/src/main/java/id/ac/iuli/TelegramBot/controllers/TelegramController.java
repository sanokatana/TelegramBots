package id.ac.iuli.TelegramBot.controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import id.ac.iuli.TelegramBot.utils.telegram.RespondMessageTelegram;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Controller
public class TelegramController {

    private final RestTemplate restTemplate;

    public TelegramController(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(){
        //Send a message to telegram chat
        String token = "5325356172:AAF_h8DkAXw1T0bqjLH6PMnW9orAuFzjxDM";
        String chatId = "1664374622";
        String url ="https://api.telegram.org/bot"+token+"/sendMessage?chat_id="+chatId+"&text={text}";

        RespondMessageTelegram RespondMessageTelegram =
                this.restTemplate.getForObject(url, RespondMessageTelegram.class, "Hello there Zahran");

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/getJoke")
    public ResponseEntity<String> getJoke(){
        String url = "https://api.chucknorris.io/jokes/random";
        try {
            URL jurl = new URL(url);
            URLConnection request = jurl.openConnection();
            request.connect();

            InputStreamReader isReader = new InputStreamReader((InputStream) request.getContent());
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
                sb.append(str);
            }
            System.out.println(sb.toString());

            JsonObject jo = JsonParser.parseString(sb.toString()).getAsJsonObject();


            String JokeValue = jo.get("value").getAsString();


            System.out.println(JokeValue);


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/sendJoke")

    public ResponseEntity<String> sendJoke(){

        String urlJoke = "https://api.chucknorris.io/jokes/random";
        try {
            URL jurl = new URL(urlJoke);
            URLConnection request = jurl.openConnection();
            request.connect();

            InputStreamReader isReader = new InputStreamReader((InputStream) request.getContent());
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
                sb.append(str);
            }
            System.out.println(sb.toString());

            JsonObject jo = JsonParser.parseString(sb.toString()).getAsJsonObject();


            String JokeValue = jo.get("value").getAsString();

            String token = "5325356172:AAF_h8DkAXw1T0bqjLH6PMnW9orAuFzjxDM";
            String chatId = "1664374622";
            String url ="https://api.telegram.org/bot"+token+"/sendMessage?chat_id="+chatId+"&text={text}";

            RespondMessageTelegram RespondMessageTelegram =
                    this.restTemplate.getForObject(url, RespondMessageTelegram.class, JokeValue);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("OK");

    }

}