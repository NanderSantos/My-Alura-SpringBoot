package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.interceptor.AccessInterceptor;
import br.com.alura.mvc.mudi.interceptor.AccessInterceptor.Access;

@RestController
@RequestMapping("access")
public class AccessRest {
	
	@GetMapping
	public List<Access> getAccesses() {

		return AccessInterceptor.getAccesses();
	}
}
