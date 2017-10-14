package is.ru.hjorturd15.stringcalculator;

public class Calculator {
    
    public static int add(String text) {
        if (text.isEmpty())
          return 0;
        
        String numbers[] = text.split("[\n,]");
        checkNegativeNumbers(numbers);

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

    public static void checkNegativeNumbers(String numbers[]) {
        String negativeNumbers = "";

        for (String number : numbers) {
            if (toInt(number) < 0)
                negativeNumbers += number + ",";
        }

        if (!negativeNumbers.isEmpty()) {
            negativeNumbers = negativeNumbers.substring(0, negativeNumbers.length() - 1);
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

    }
}
