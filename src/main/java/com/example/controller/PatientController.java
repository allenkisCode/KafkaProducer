package com.example.controller;


import javax.xml.ws.Response;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.GenericException.MessageException;
import com.example.kafkaConfig.MessageProducerFactory;
import com.example.kafkaConfig.ProducerResponse;

@Controller
public class PatientController {

	@RequestMapping(method = RequestMethod.POST , value = "/save/data")
	@ResponseBody
	public ProducerResponse getPatientInfo(@RequestBody String ptntInfo){
		
		ProducerResponse response = null;
		try{	
			if(MessageProducerFactory.getProducer("Patient") == null){
				MessageProducerFactory.getMessageProducerFactory().init("Patient");
			}
			response = MessageProducerFactory.getProducer("Patient").send("Patient", ptntInfo);
		}catch(MessageException e){
			//TODO
		}
		return response;
	}
}
