package is.ru.hjorturd15.stringcalculator;

public class Calculator {
    
    public static int add(String text) {
        if (text.isEmpty())
          return 0;
        
        String numbers[] = text.split(",");

        return sum(numbers);
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }

    public static int sum(String numbers[]) {
        int sum = 0;

        for (String number : numbers) {
            sum += toInt(number);
        }

        return sum;
    }
}
