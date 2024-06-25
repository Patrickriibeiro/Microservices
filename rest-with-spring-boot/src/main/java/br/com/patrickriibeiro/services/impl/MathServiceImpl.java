package br.com.patrickriibeiro.services.impl;

import org.springframework.stereotype.Service;

import br.com.patrickriibeiro.exceptions.UnsuportedMathOperationException;
import br.com.patrickriibeiro.services.MathService;
import br.com.patrickriibeiro.utils.MathUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MathServiceImpl implements MathService {

	@Override
	public Double sum(String firstNumber, String secondNumber) {
		Double firstNumberConvert = MathUtils.convertValue(firstNumber);
		Double secondNumberConvert = MathUtils.convertValue(secondNumber);

		if (!MathUtils.isNumeric(firstNumber) || !MathUtils.isNumeric(secondNumber)) {
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

	@Override
	public Double sub(String firstNumber, String secondNumber) {
		Double firstNumberConvert = MathUtils.convertValue(firstNumber);
		Double secondNumberConvert = MathUtils.convertValue(secondNumber);

		if (!MathUtils.isNumeric(firstNumber) || !MathUtils.isNumeric(secondNumber)) {
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

	@Override
	public Double mult(String firstNumber, String secondNumber) {
		Double firstNumberConvert = MathUtils.convertValue(firstNumber);
		Double secondNumberConvert = MathUtils.convertValue(secondNumber);

		if (!MathUtils.isNumeric(firstNumber) || !MathUtils.isNumeric(secondNumber)) {
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

	@Override
	public Double div(String firstNumber, String secondNumber) {
		Double firstNumberConvert = MathUtils.convertValue(firstNumber);
		Double secondNumberConvert = MathUtils.convertValue(secondNumber);

		if (!MathUtils.isNumeric(firstNumber) || !MathUtils.isNumeric(secondNumber)) {
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

	@Override
	public Double porc(String firstNumber, String secondNumber) {
		Double firstNumberConvert = MathUtils.convertValue(firstNumber);
		Double secondNumberConvert = MathUtils.convertValue(secondNumber);

		if (!MathUtils.isNumeric(firstNumber) || !MathUtils.isNumeric(secondNumber)) {
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

		return (firstNumberConvert * secondNumberConvert) / 100.0;

	}

}
