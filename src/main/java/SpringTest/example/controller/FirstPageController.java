package SpringTest.example.controller;

import SpringTest.example.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import SpringTest.example.repository.MessageRepo;

import java.util.Map;



@Controller
public class FirstPageController {
    @Autowired
    MessageRepo messageRepo;

    @GetMapping("/")
    public String firstPage(){
        return "first_Page";
    }

    @GetMapping
    public String myMessages(Map<String, Object> model){
       Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "first_page";
    }

    @PostMapping
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "first_page";

    }
}
