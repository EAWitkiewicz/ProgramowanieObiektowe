import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class tablicenotatki {
    public static void main(String[] args) {
        //inicjalizacja
        int[] arr = new int[5]; // Tablica 5-elementowa
        int[] arr1 = {1, 2, 3, 4, 5}; // Tablica inicjalizowana wartościami

        //printuje tablice
        System.out.println(Arrays.toString(arr)); // [1, 2, 3]
        //sortuje
        Arrays.sort(arr);
        //wypelnia wartosciami odpowiednimi
        Arrays.fill(arr, 10); // [10, 10, 10, 10, 10]
        //iteruje po tablicy
        for (int num : arr) {
            System.out.println(num); // 1, 2, 3
        }
        //tworzy kopie o zadanej dl
        int[] original = {1, 2, 3};
        int[] copy = Arrays.copyOf(original, 5); // [1, 2, 3, 0, 0]

        //Kopiuje zakres elementów z tablicy
        int[] arr2 = {1, 2, 3, 4};
        int[] subArray = Arrays.copyOfRange(arr2, 1, 3); // [2, 3]

        //Porównuje dwie tablice pod względem ich zawartości.
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 2, 3};
        boolean isEqual = Arrays.equals(arr3, arr4); // true

        //Sortuje tablicę w porządku malejącym (tylko dla tablic obiektów, np. Integer[]).
        Integer[] arr5 = {1, 3, 2};
        Arrays.sort(arr5, Collections.reverseOrder()); // [3, 2, 1]

        //Konwertuje tablicę na listę.
        String[] arr6 = {"A", "B", "C"};
        List<String> list = Arrays.asList(arr6); // [A, B, C]
        //Zamienia tablicę wielowymiarową na tekst.
        int[][] arr7 = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(arr7)); // [[1, 2], [3, 4]]



    }
}
