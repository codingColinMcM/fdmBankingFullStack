package com.fdmgroup.webClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.model.Geocoder;

@Service
public class CustomerClientWebClient implements CustomerClientInterface {

	private WebClient webClient;
	
	@Autowired
	public CustomerClientWebClient(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public Geocoder getGeocoder(String postalCode) {
		
		return webClient.get().uri(uriBuilder -> uriBuilder
				.queryParam("locate", postalCode).queryParam("json", 1).build())
				.retrieve().bodyToMono(Geocoder.class).block();
		
	}

}
