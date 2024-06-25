package br.com.patrickriibeiro.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.services.MathService;

@RestController
@RequestMapping("/v1/restservice")
public class MathController {
	
	private MathService mathService;
	
	public MathController(MathService mathService) {
		this.mathService = mathService;
	}
	
	@GetMapping("/sum/{firstNumber}/{secondNumber}")
	public Double sum(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		return mathService.sum(firstNumber, secondNumber);
	}
	
	@GetMapping("/sub/{firstNumber}/{secondNumber}")
	public Double sub(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		return mathService.sub(firstNumber, secondNumber);	
	}
	
	@GetMapping("/porc/{firstNumber}/{secondNumber}")
	public Double porc(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		return mathService.porc(firstNumber, secondNumber);		
	}
	
	@GetMapping("/mult/{firstNumber}/{secondNumber}")
	public Double mult(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		return mathService.mult(firstNumber, secondNumber);		
	}
	
	
	@GetMapping("/div/{firstNumber}/{secondNumber}")
	public Double div(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		return mathService.div(firstNumber, secondNumber);	
	}
	
}
