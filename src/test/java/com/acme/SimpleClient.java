package com.acme;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.acme.entity.ServiceInfo;

public class SimpleClient {
	
	public static final String ALL_SERVICES_URL = "http://localhost:8080/acme/services";
	public static final String MSG_TEMPLATE = "Id: %s, Description: %s"; 
	
	public void getAllServices() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<ServiceInfo[]> responseEntity = restTemplate.exchange(
        		ALL_SERVICES_URL, HttpMethod.GET, requestEntity, ServiceInfo[].class);
        ServiceInfo[] serviceInfos = responseEntity.getBody();
        for(ServiceInfo serviceInfo : serviceInfos) {
              System.out.println(String.format(MSG_TEMPLATE, 
            		  serviceInfo.getServiceId(), serviceInfo.getDescription()));
        }
    }
    
    public static void main(String args[]) {
    	SimpleClient util = new SimpleClient();
    	util.getAllServices();
    }    
}
