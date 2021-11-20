public class Main {
    public static void main(String[] args) {
        Input input=new Input();
        input.scanner();
        Calculator calculator=new Calculator();
        System.out.println(calculator.calculate(input.getFirstValue(),input.getSecondValue(),input.getOperation()));
    }
}
