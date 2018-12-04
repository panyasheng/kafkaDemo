package com.pan.system.kafka.consumer;


import com.google.gson.Gson;
import com.pan.system.common.MessageEntity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private final Gson gson = new Gson();

   
	@SuppressWarnings("unchecked")
	@KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity message) {
    	String strBody=message.getBody();
    	String strTitle=message.getTitle();
    	Map<String,Object> mapResult=gson.fromJson(strBody, Map.class);
    	
        log.info(gson.toJson(message));
    }
    
    
    public static void main(String[] args) {  

    	         Gson gson = new Gson();  

    	         Map<String,Object> map = new HashMap<String,Object>();  

    	         map.put("colour", "red");  

    	        map.put("weight", "10kg");  

    	         String mapJson =  gson.toJson(map);  
    	         System.out.println(mapJson);
    	         Map<String,Object> mapstr = new HashMap<String,Object>();  
    	         mapstr = gson.fromJson(mapJson,Map.class); 
    	         System.out.println(mapstr);

    	    } 
}