package com.sundar.kafkaconsumer.listener;

//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sundar.kafkaconsumer.userdetails.Userdetails;

@Service
public class KafkaConsumerListener {

	//@KafkaListener(topics="kafka_example",groupId ="groupid",containerFactory = "kafkaListenerContainerFactory")
//	public String consume(String message) {
//		
//		
//		return ("Consumed message"+message);
//	}
	
	//@KafkaListener(topics="kafkajsonn",groupId ="groupjson",containerFactory = "userKafkaListenerContainerFactory")
	public String consumeJson(Userdetails userdetails) {
		return ("ConsumedJson"+userdetails);
		}
}
