package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.CalculatorUseCase;
import calculator.domain.Parser;
import calculator.domain.Preprocessor;
import calculator.domain.model.PreprocessedInput;

import java.util.List;

public class MultipleService implements CalculatorUseCase {
    @Override
    public int calculate(String args) {
        // 전처리
        Preprocessor preprocessor = new Preprocessor(args);
        PreprocessedInput preprocessedInput = preprocessor.preprocess();

        // 파싱
        Parser parser = new Parser(preprocessedInput);
        List<Integer> numbers = parser.parse();

        // 계산
        Calculator calculator = new Calculator(numbers);
        int result = calculator.sum();

        return result;
    }
}
