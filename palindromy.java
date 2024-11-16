
public class palindromy {
    public static void main(String[] args) {

        // Test dla ciągu znaków
        String text = "radar";
        System.out.println("Czy \"" + text + "\" jest palindromem? " + isStringPalindrome(text));

        // Test dla tablicy
        int[] array = {1, 2, 3, 2, 1};
        System.out.println("Czy tablica " + java.util.Arrays.toString(array) + " jest palindromem? " + isArrayPalindrome(array));

        // Test dla liczby
        int number = 12321;
        System.out.println("Czy liczba " + number + " jest palindromem? " + isNumberPalindrome(number));
    }
            // Sprawdza, czy dany ciąg znaków jest palindromem
            public static boolean isStringPalindrome(String str) {
                if (str == null) return false; // Obsługa przypadku null
                int left = 0;
                int right = str.length() - 1;

                while (left < right) {
                    if (str.charAt(left) != str.charAt(right)) {
                        return false; // Znaleziono różnicę, nie jest palindromem
                    }
                    left++;
                    right--;
                }
                return true; // Wszystkie znaki się zgadzają
            }

            // Sprawdza, czy dana tablica jest palindromem
            public static boolean isArrayPalindrome(int[] array) {
                if (array == null) return false; // Obsługa przypadku null
                int left = 0;
                int right = array.length - 1;

                while (left < right) {
                    if (array[left] != array[right]) {
                        return false; // Znaleziono różnicę, nie jest palindromem
                    }
                    left++;
                    right--;
                }
                return true; // Wszystkie elementy się zgadzają
            }

            // Sprawdza, czy dana liczba jest palindromem
            public static boolean isNumberPalindrome(int number) {
                if (number < 0) return false; // Liczby ujemne nie są palindromami

                int originalNumber = number;
                int reversedNumber = 0;

                while (number > 0) {
                    int digit = number % 10; // Pobierz ostatnią cyfrę
                    reversedNumber = reversedNumber * 10 + digit; // Zbuduj odwróconą liczbę
                    number /= 10; // Usuń ostatnią cyfrę
                }

                return originalNumber == reversedNumber; // Porównaj oryginalną i odwróconą liczbę
            }
            }
