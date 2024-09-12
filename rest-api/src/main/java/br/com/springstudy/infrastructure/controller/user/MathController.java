package br.com.springstudy.infrastructure.controller.user;

import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import br.com.springstudy.infrastructure.util.NumberConverter;
import br.com.springstudy.infrastructure.util.SimpleMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    //@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    @GetMapping(value = "/soma/{numberOne}/{numberTwo}")
    public Double soma(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.soma(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/subtracao/{numberOne}/{numberTwo}")
    public Double subtracao(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.subtracao(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/multiplicacao/{numberOne}/{numberTwo}")
    public Double multiplicacao(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.multiplicacao(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/divisao/{numberOne}/{numberTwo}")
    public Double divisao(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.divisao(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/raizquadrada/{number}")
    public Double raizQuadrada(@PathVariable(value = "number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.raizQuadrada(NumberConverter.convertToDouble(number));
    }

}
