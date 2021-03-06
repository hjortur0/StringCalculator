package is.ru.hjorturd15.stringcalculator;

public class Calculator {
    
    public static int add(String text) {
        if (text.isEmpty())
          return 0;
        
        String delimiter = getDelimiter(text);
        text = removeDelimiter(text);

        String numbers[] = text.split(delimiter);
        checkNegativeNumbers(numbers);

        return sum(numbers);
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }

    public static int sum(String numbers[]) {
        int sum = 0;

        for (String number : numbers) {
            int integer = toInt(number);
            if (integer <= 1000)
                sum += integer;
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

    public static String getDelimiter(String text) {
        if (text.startsWith("//"))
            return text.substring(2, text.indexOf("\n"));

        return "[\n,]";
    }

    public static String removeDelimiter(String text) {
        if (text.startsWith("//"))
            return text.substring(text.indexOf("\n") + 1);

        return text;
    }
}
