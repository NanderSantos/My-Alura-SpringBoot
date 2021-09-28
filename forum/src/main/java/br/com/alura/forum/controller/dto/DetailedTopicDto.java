package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.StatusTopic;
import br.com.alura.forum.model.Topic;

public class DetailedTopicDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
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

	public StatusTopic getStatus() {
		return status;
	}

	public List<ResponseDto> getResponses() {
		return responses;
	}

	private String authorName;
	private StatusTopic status;
	private List<ResponseDto> responses;

	public DetailedTopicDto(Topic topic) {

		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
		this.authorName = topic.getAuthor().getName();
		this.status = topic.getStatus();
		this.responses = new ArrayList<>();

		this.responses.addAll(topic.getResponses().stream().map(ResponseDto::new).collect(Collectors.toList()));
	}

}
