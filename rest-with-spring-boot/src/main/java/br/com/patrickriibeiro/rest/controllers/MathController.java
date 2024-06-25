package br.com.patrickriibeiro.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.exceptions.UnsuportedMathOperationException;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/restservice")
@Slf4j
public class MathController {
	
	@GetMapping("/sum/{firstNumber}/{secondNumber}")
	public Double sum(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		
		Double firstNumberConvert = this.convertValue(firstNumber);
		Double secondNumberConvert = this.convertValue(secondNumber);
		
		
		if(!this.isNumeric(firstNumber) || !this.isNumeric(secondNumber)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		if (firstNumberConvert < Double.MIN_VALUE || firstNumberConvert > Double.MAX_VALUE) {
            throw new UnsuportedMathOperationException("FirstNumber eis out of range permited.");
        }
        
        if (secondNumberConvert < Double.MIN_VALUE || secondNumberConvert > Double.MAX_VALUE) {
            throw new UnsuportedMathOperationException("SecondNumber is out of range permited.");
        }
        
        // Validação de infinito
        if (Double.isInfinite(firstNumberConvert) || Double.isInfinite(secondNumberConvert)) {
            throw new UnsuportedMathOperationException("One of this values is infinity.");
        }

        // Aviso para zero
        if (firstNumberConvert == 0.0 || secondNumberConvert == 0.0) {
             log.info("WARNING: one of this value is zero");   
        } 
        
		return Math.round((firstNumberConvert + secondNumberConvert) * 100.0) / 100.0;
	}
	
	@GetMapping("/sub/{firstNumber}/{secondNumber}")
	public Double sub(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		
		Double firstNumberConvert = this.convertValue(firstNumber);
		Double secondNumberConvert = this.convertValue(secondNumber);
		
		if(!this.isNumeric(firstNumber) || !this.isNumeric(secondNumber)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		    if (firstNumberConvert < Double.MIN_VALUE || firstNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("FirstNumber eis out of range permited.");
	        }
	        
	        if (secondNumberConvert < Double.MIN_VALUE || secondNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("SecondNumber is out of range permited.");
	        }

	        // Validação de infinito
	        if (Double.isInfinite(firstNumberConvert) || Double.isInfinite(secondNumberConvert)) {
	            throw new UnsuportedMathOperationException("One of this values is infinity.");
	        }

	        // Aviso para zero
	        if (firstNumberConvert == 0.0 || secondNumberConvert == 0.0) {
	             log.info("WARNING: one of this value is zero");   
	        } 
		
		return Math.round((firstNumberConvert - secondNumberConvert) * 100.0) / 100.0;
	}
	
	@GetMapping("/porc/{firstNumber}/{secondNumber}")
	public Double porc(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		
		Double firstNumberConvert = this.convertValue(firstNumber);
		Double secondNumberConvert = this.convertValue(secondNumber);
		
		if(!this.isNumeric(firstNumber) || !this.isNumeric(secondNumber)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		    if (firstNumberConvert < Double.MIN_VALUE || firstNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("FirstNumber eis out of range permited.");
	        }
	        
	        if (secondNumberConvert < Double.MIN_VALUE || secondNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("SecondNumber is out of range permited.");
	        }

	        // Validação de infinito
	        if (Double.isInfinite(firstNumberConvert) || Double.isInfinite(secondNumberConvert)) {
	            throw new UnsuportedMathOperationException("One of this values is infinity.");
	        }

	        // Aviso para zero
	        if (firstNumberConvert == 0.0 || secondNumberConvert == 0.0) {
	             log.info("WARNING: one of this value is zero");   
	        } 
		
		return (firstNumberConvert * secondNumberConvert) / 100;
	}
	
	@GetMapping("/mult/{firstNumber}/{secondNumber}")
	public Double mult(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		
		Double firstNumberConvert = this.convertValue(firstNumber);
		Double secondNumberConvert = this.convertValue(secondNumber);
		
		if(!this.isNumeric(firstNumber) || !this.isNumeric(secondNumber)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		    if (firstNumberConvert < Double.MIN_VALUE || firstNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("FirstNumber eis out of range permited.");
	        }
	        
	        if (secondNumberConvert < Double.MIN_VALUE || secondNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("SecondNumber is out of range permited.");
	        }

	        // Validação de infinito
	        if (Double.isInfinite(firstNumberConvert) || Double.isInfinite(secondNumberConvert)) {
	            throw new UnsuportedMathOperationException("One of this values is infinity.");
	        }

	        // Aviso para zero
	        if (firstNumberConvert == 0.0 || secondNumberConvert == 0.0) {
	             log.info("WARNING: one of this value is zero");   
	        } 
		
		return Math.round((firstNumberConvert * secondNumberConvert) * 100.0) / 100.0;
	}
	
	
	@GetMapping("/div/{firstNumber}/{secondNumber}")
	public Double div(@PathVariable(name = "firstNumber") String firstNumber, @PathVariable(name = "secondNumber") String secondNumber) {
		
		Double firstNumberConvert = this.convertValue(firstNumber);
		Double secondNumberConvert = this.convertValue(secondNumber);
		
		if(!this.isNumeric(firstNumber) || !this.isNumeric(secondNumber)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		    if (firstNumberConvert < Double.MIN_VALUE || firstNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("FirstNumber eis out of range permited.");
	        }
	        
	        if (secondNumberConvert < Double.MIN_VALUE || secondNumberConvert > Double.MAX_VALUE) {
	            throw new UnsuportedMathOperationException("SecondNumber is out of range permited.");
	        }

	        // Validação de infinito
	        if (Double.isInfinite(firstNumberConvert) || Double.isInfinite(secondNumberConvert)) {
	            throw new UnsuportedMathOperationException("One of this values is infinity.");
	        }

	        // Aviso para zero
	        if (firstNumberConvert == 0.0 || secondNumberConvert == 0.0) {
	             log.info("WARNING: one of this value is zero");   
	        } 
		
		return Math.round((firstNumberConvert / secondNumberConvert) * 100.0) / 100.0;
	}
	
	
	
	private boolean isNumeric(String number) {
		if(number == null || number.isEmpty()) return false;
		return number.matches("-?\\d+(\\.\\d+)?");
	}
	
	private Double convertValue(String number) {
		return Double.parseDouble(number.replaceAll(",","."));
	}

}
