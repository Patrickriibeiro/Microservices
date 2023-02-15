package io.github.PatrickRiibeiro.bookservice.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String author;
	private String title;
	private Date launchDate;
	private Double price;	
	private String currency;
	private String environment;

}
