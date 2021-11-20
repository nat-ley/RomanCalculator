public class Calculator {
    public String calculate(String firstValue, String secondValue, String operation) {
        Converter converter = new Converter();
        Integer[] convertedValues = converter.stringToInteger(firstValue, secondValue);
        Integer first = convertedValues[0];
        Integer second = convertedValues[1];
        if (first > 10 || second > 10) {
            throw new RuntimeException("Нельзя производить операции с цифрами больше 10");
        }
        try {
            switch (operation) {
                case "+":
                    return converter.integerToString(first + second);
                case "-":
                    return converter.integerToString(first - second);
                case "*":
                    return converter.integerToString(first * second);
                case "/":
                    return converter.integerToString(first / second);
                default:
                    throw new RuntimeException("Неподдерживаемая операция");
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Нельзя делить на ноль");
        }

    }

}
