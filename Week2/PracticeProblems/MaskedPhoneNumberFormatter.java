import java.util.Scanner;
public class MaskedPhoneNumberFormatter{

    static String maskPhoneNumber(String phone) {

        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        String lastFourDigits = phone.substring(6);
        StringBuilder result = new StringBuilder("XXXXXX");

        result.insert(6, "-");
        result.append(lastFourDigits);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        String result = maskPhoneNumber(phone);

        System.out.println(result);

        scanner.close();
    }
}