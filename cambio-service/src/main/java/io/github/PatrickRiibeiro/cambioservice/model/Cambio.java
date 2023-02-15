package io.github.PatrickRiibeiro.cambioservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cambio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cambio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "from_currency", nullable = false, length = 3)
    private String from;
	
	@Column(name = "to_currency", nullable = false, length = 3)
    private String to;
	
	@Column(nullable = false)
    private BigDecimal conversionFactor;
	
	@Transient
    private BigDecimal conversionValue;
	
	@Transient
    private String environment;
	
}
