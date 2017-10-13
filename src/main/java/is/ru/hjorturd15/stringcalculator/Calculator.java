package is.ru.hjorturd15.stringcalculator;

public class Calculator {
    
    public static int add(String text) {
        if (text.isEmpty())
          return 0;
        
        String numbers[] = text.split("[\n,]");

        return sum(numbers);
    }

    public static int toInt(String number) {
        int parsedInt = Integer.parseInt(number);

        if (parsedInt < 0)
            throw new IllegalArgumentException("Negatives not allowed: " + parsedInt);

        return parsedInt;
    }

    public static int sum(String numbers[]) {
        int sum = 0;

        for (String number : numbers) {
            sum += toInt(number);
        }

        return sum;
    }
}
