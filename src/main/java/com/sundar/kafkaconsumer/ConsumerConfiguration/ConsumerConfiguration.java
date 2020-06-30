package com.sundar.kafkaconsumer.ConsumerConfiguration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.sundar.kafkaconsumer.userdetails.Userdetails;

import org.apache.kafka.common.serialization.StringDeserializer;
import java.util.*;
@EnableKafka
@Configuration
public class ConsumerConfiguration {
	
	@Bean
	public ConsumerFactory<String,String> consumerFactory(){
		
		Map<String,Object> config=new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG,"groupid");
		return new DefaultKafkaConsumerFactory<>(config);
	}
 @Bean
 public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(){
	 
	 ConcurrentKafkaListenerContainerFactory<String,String> factory=new ConcurrentKafkaListenerContainerFactory<String,String>();
	 
	 factory.setConsumerFactory(consumerFactory());
	 factory.setErrorHandler(new SeekToCurrentErrorHandler());
	 return factory;
 }
 @Bean
	public ConsumerFactory<String,Userdetails> userConsumerFactory(){
		
		Map<String,Object> config=new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG,"groupjson");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(Userdetails.class));
	}
@Bean
public ConcurrentKafkaListenerContainerFactory<String,Userdetails> userKafkaListenerContainerFactory(){
	 
	 ConcurrentKafkaListenerContainerFactory<String,Userdetails> factory=new ConcurrentKafkaListenerContainerFactory<String,Userdetails>();
	 
	 factory.setConsumerFactory(userConsumerFactory());
	 factory.setErrorHandler(new SeekToCurrentErrorHandler());
	 return factory;
}
}
