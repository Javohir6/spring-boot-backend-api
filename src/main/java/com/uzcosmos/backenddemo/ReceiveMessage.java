package com.uzcosmos.backenddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.uzcosmos.backenddemo.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uzcosmos.backenddemo.model.Message;


@RestController
public class ReceiveMessage {

    private List<Message> messages = new ArrayList<>();

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/message")
    public String receiveMessage(@RequestBody Message message){
        messageRepository.save(message);
        return "Message saved!";
    }
    
    @GetMapping("/message/{id}")
    public Message getMessageByIdMessage(@PathVariable int id) {
        Optional<Message> messageToFind = messageRepository.findById(id);
        if (messageToFind.isPresent()){
            Message msg = messageToFind.get();
            return msg;
        }
        return null;
    }
    @GetMapping("/all")
    public List<Message> getAll(){
        messages = messageRepository.findAll();
        return messages;
    }
    @DeleteMapping("/message/{id}")
    public String deleteById(@PathVariable int id){
        if (messageRepository.existsById(id)){
            messageRepository.deleteById(id);
            return "Message deleted.";
        }
        else{
            return "Message not found.";
        }
    }
    @PutMapping("/message/{id}")
    public String updateMessage(@PathVariable int id, @RequestBody Message newData){
        Optional<Message> optional = messageRepository.findById(id);
        if (optional.isPresent()){
            Message msg = optional.get();
            msg.setText(newData.getText());
            messageRepository.save(msg);
            return "Message updated.";
        }
        else{
            return "Message not found.";
        }
    }
    
}