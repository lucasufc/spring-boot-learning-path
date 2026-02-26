package br.com.eurudio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.eurudio.domain.Operation;
import br.com.eurudio.exception.UnsupportedMathOperationException;
import br.com.eurudio.model.MathResponse;

@RestController
@RequestMapping("/math")
public class MathController {
    private static final String NUMBER_REGEX = "[-+]?(\\d+\\.\\d+|\\d+)";

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public MathResponse sum(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ){
        Double doubleOne = verifyAndConvertToDouble(numberOne); 
        Double doubleTwo = verifyAndConvertToDouble(numberTwo);
        Double result = doubleOne + doubleTwo;

        return new MathResponse(doubleOne, doubleTwo, Operation.SUM, result);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public MathResponse subtraction(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ){
        Double doubleOne = verifyAndConvertToDouble(numberOne); 
        Double doubleTwo = verifyAndConvertToDouble(numberTwo);
        Double result = doubleOne - doubleTwo;

        return new MathResponse(doubleOne, doubleTwo, Operation.SUB, result);
    }
    
    
    @GetMapping("/mul/{numberOne}/{numberTwo}")
    public MathResponse multiplication(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ){
        Double doubleOne = verifyAndConvertToDouble(numberOne); 
        Double doubleTwo = verifyAndConvertToDouble(numberTwo);
        Double result = doubleOne * doubleTwo;

        return new MathResponse(doubleOne, doubleTwo, Operation.MUL, result);
    }
        @GetMapping("/div/{numberOne}/{numberTwo}")
    public MathResponse division(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ){
        Double doubleOne = verifyAndConvertToDouble(numberOne); 
        Double doubleTwo = verifyAndConvertToDouble(numberTwo);
        Double result = doubleOne + doubleTwo;

        return new MathResponse(doubleOne, doubleTwo, Operation.DIV, result);
    }
    @GetMapping("/avg/{numberOne}/{numberTwo}")
    public MathResponse average(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ){
        Double doubleOne = verifyAndConvertToDouble(numberOne); 
        Double doubleTwo = verifyAndConvertToDouble(numberTwo);
        Double result = (doubleOne + doubleTwo)/2;

        return new MathResponse(doubleOne, doubleTwo, Operation.AVG, result);
    }
    
    @GetMapping("/sqrt/{numberOne}")
    public MathResponse calculate(
        @PathVariable("numberOne") String numberOne
    ){
        Double doubleOne = verifyAndConvertToDouble(numberOne); 
        Double result = Math.sqrt(doubleOne);

        return new MathResponse(doubleOne, 0D, Operation.SQRT, result);
    }

    private Double verifyAndConvertToDouble(String value) {
        if (value == null || value.isBlank()) {
            throw new UnsupportedMathOperationException("Value is null or empty");
        }

        String normalized = value.replace(",", ".");

        if (!isValidNumber(normalized)) {
            throw new UnsupportedMathOperationException("Invalid number: " + value);
        }

        return Double.parseDouble(normalized);
    }

    private boolean isValidNumber(String value) {
        return value.matches(NUMBER_REGEX);
    }
}
