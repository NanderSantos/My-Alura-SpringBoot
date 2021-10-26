package br.com.alura.client;

import org.apache.http.client.fluent.Request;

public class ClientWebService {

	public static void main(String[] args) throws Exception {
		
		String content = Request.Post("http://localhost:8080/gerenciador/companies")
			.addHeader("Accept", "application/json")
			.execute()
			.returnContent()
			.asString();
		
		System.out.println(content);
	}
}
