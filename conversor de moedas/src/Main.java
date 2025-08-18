import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice = "yes";

        System.out.println("Welcome to the Currency Converter!");

        do {
            System.out.print("Enter the base currency (BRL, USD, EUR, etc.): ");
            String base = scanner.nextLine().toUpperCase();

            Map<String, Double> rates = CurrencyAPI.getRates(base);
            if (rates == null) {
                System.out.println("Failed to fetch rates from API. Try again.");
                continue;
            }

            System.out.println("Available currencies: " + rates.keySet());

            System.out.print("Enter the currency to convert to: ");
            String toCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter the amount: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
                continue;
            }

            if (rates.containsKey(toCurrency)) {
                double rate = rates.get(toCurrency);
                double convertedAmount = amount * rate;
                System.out.printf("%.2f %s = %.2f %s%n", amount, base, convertedAmount, toCurrency);
            } else {
                System.out.println("Invalid currency. Please choose from the available list.");
            }

            System.out.print("Do you want to make another conversion? (yes/no): ");
            continueChoice = scanner.nextLine().toLowerCase();

        } while (continueChoice.equals("yes"));

        System.out.println("Thank you for using the currency converter!");
        scanner.close();
    }
}
