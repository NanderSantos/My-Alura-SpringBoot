package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.alura.forum.model.Response;

public class ResponseDto {
	
	private Long id;
	private String message;
	private LocalDateTime creationDate;
	private String authorName;
	
	public ResponseDto(Response response) {
		
		 this.id = response.getId();
		 this.message = response.getMessage();
		 this.creationDate = response.getCreationDate();
		 this.authorName = response.getAuthor().getName();
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getAuthorName() {
		return authorName;
	}
}
