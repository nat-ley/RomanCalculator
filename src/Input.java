import java.util.Locale;
import java.util.Scanner;

public class Input {
    private String firstValue;
    private String secondValue;
    private String operation;

    public void scanner(){
        Scanner scanner=new Scanner(System.in);
        String[] args=scanner.nextLine()
                .toUpperCase()
                .split(" ");
        firstValue=args[0];
        secondValue=args[2];
        operation=args[1];

    }

    public String getFirstValue() {
        return firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public String getOperation() {
        return operation;
    }
}
