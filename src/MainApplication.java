import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter count of operation:");
        int countOfOperation = scanner.nextInt();
        System.out.print("please enter your message:");
        scanner.nextLine();
        String message = scanner.nextLine();
        String encryptedMessage = encrypt(message, countOfOperation);
        String decryptedMessage = decrypt(encryptedMessage, countOfOperation);
        System.out.println("encrypted message:" + encryptedMessage);
        System.out.println("--------------------------------------");
        System.out.println("decrypted message:" + decryptedMessage);
    }

    private static String encrypt(String message, int count) {
        String encMessage = "";
        while (count > 0) {
            char[] charMessage = message.toCharArray();
            Character lastChar = message.charAt(message.length() - 1);
            Character firstChar = message.charAt(0);
            charMessage[0] = lastChar;
            charMessage[message.length() - 1] = firstChar;
            for (int i = 0; i < message.length(); i++) {
                char nextChar = ' ';
                if (message.charAt(i) == 'Z')
                    nextChar = 65;
                else if (message.charAt(i) == 'z')
                    nextChar = 97;
                else {
                    nextChar = message.charAt(i);
                    nextChar++;
                }
                encMessage = encMessage + nextChar;
            }
            count--;
            message = encMessage;
            System.out.println("encMessage: " + encMessage);
            encMessage = "";
        }
        return message;
    }

    private static String decrypt(String message, int count) {
        String decMessage = "";
        while (count > 0) {
            char[] charMessage = message.toCharArray();
            Character lastChar = message.charAt(message.length() - 1);
            Character firstChar = message.charAt(0);
            charMessage[0] = lastChar;
            charMessage[message.length() - 1] = firstChar;
            for (int i = 0; i < message.length(); i++) {
                char nextChar = ' ';
                if (message.charAt(i) == 'A')
                    nextChar = 90;
                else if (message.charAt(i) == 'a')
                    nextChar = 122;
                else {
                    nextChar = message.charAt(i);
                    nextChar--;
                }
                decMessage = decMessage + nextChar;
            }
            count--;
            message = decMessage;
            System.out.println("decMessage: " + decMessage);
            decMessage = "";
        }
        return message;
    }
}
