package com.sundar.kafkaconsumer.ConsumerController;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sundar.kafkaconsumer.userdetails.Userdetails;

import java.util.*;

@RestController
@RequestMapping("/topic")
public class ConsumerController {
	
	
	List<String> messages=new ArrayList<>();
	//Userdetails userFromTopic=null;
	
	
	@GetMapping("/consumemessage")
	public List<String> consumeMsg(){
		
		return messages;
	}
	
	
	
//	@KafkaListener(groupId ="groupid",topics="kafka_example",containerFactory = "kafkaListenerContainerFactory")
//	public List<String> getMsgFromTopic(String data)
//	{
//		messages.add(data);
//		return messages;
//		
//	}
	
	@KafkaListener(groupId ="groupid",topics="kafkajsonn",containerFactory = "userKafkaListenerContainerFactory")
	public  void getJsonMsgFromTopic(Userdetails userdetails)
	{
		//userFromTopic=userdetails;
		
	//	return userFromTopic;
		System.out.println("Consumed "+userdetails.getName());
	}
	
	
	
	
   // @GetMapping("/consumejson")
    
	//public Userdetails consumeJsonMessage(Userdetails userdetails)
	//{
    	//return userFromTopic;
	//}
	
	
}
