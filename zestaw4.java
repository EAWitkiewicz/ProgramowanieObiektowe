import java.util.Arrays;
import java.util.Random;

public class zestaw4 {
    public static void main(String[] args) {
        int[] tab = {1, 2, 3};
        wypiszTablice(tab, 2, 3);
    }

    static void wypiszTablice(int[] tab, int n, int m) {
        int[][] macierz = new int[n][m];
        int i = 0, j = 0, k = 0;
        while (i < n) {
            while (j < m) {
                if (k < tab.length) {
                    macierz[i][j] = tab[k];
                    j++;
                    k++;
                } else {
                    macierz[i][j] = 0;
                    j++;
                }
            }
            j = 0;
            i++;
        }
        for(int[]row: macierz){
            System.out.println(Arrays.toString(row));
        }
        //Arrays.deepToString(macierz)-wypisze wielowymiaraw tablice ciagiem
        //Arrays.toString wypisuje jednowymiareowe tablice
    }

    static void generujTablice(int n, int minWartosc, int maxWartosc) {
        int[] tablica = new int[n];
        //inicjalizacja liczb lososwych
        Random random = new Random();

        for (int i = 0; i < tablica.length; i++) {
            /**generowanie liczby z zakresu
             //random generuej liczby od 0 do podanej wyłacznie daltego najpier okreslamy:
             //max-min jako liczba elementow w przedziale
             //+1 aby przedział byl <= a nie <
             //+min wartosc aby przedzial sie przesunąl*/
            int kolejneLiczbyLosowe = random.nextInt(maxWartosc - minWartosc + 1) + minWartosc;
            tablica[i] = kolejneLiczbyLosowe;
        }
        System.out.println(Arrays.toString(tablica));
    }
}
