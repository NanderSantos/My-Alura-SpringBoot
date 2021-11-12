package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {
	
	public String getOfferForm() {

		return "offer/home";
	}
}
