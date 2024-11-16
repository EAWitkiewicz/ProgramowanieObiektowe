import java.util.Arrays;

public class ciagi_i_palindrom {

    // Metoda do znalezienia najdłuższego ciągu liczb ujemnych w tablicy
    public static void najdluzszyCiagUjemnych(int[] tab) {
        int najdluzszyCiag = 0; // Przechowuje długość najdłuższego ciągu
        int ciagSprawdzany = 0; // Przechowuje długość aktualnie sprawdzanego ciągu
        int poczatekCiagu = -1; // Początkowy indeks najdłuższego ciągu
        int koniecCiagu = -1;   // Końcowy indeks najdłuższego ciągu

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < 0) { // Jeśli liczba jest ujemna
                ciagSprawdzany++;
                if (ciagSprawdzany > najdluzszyCiag) {
                    najdluzszyCiag = ciagSprawdzany;
                    koniecCiagu = i;
                    poczatekCiagu = i - najdluzszyCiag + 1;
                }
            } else { // Resetujemy licznik, gdy napotkamy liczbę nieujemną
                ciagSprawdzany = 0;
            }
        }

        System.out.println("Długość najdłuższego ciągu liczb ujemnych to: " + najdluzszyCiag);
        System.out.print("Najdłuższy ciąg ujemnych to: ");
        for (int i = poczatekCiagu; i <= koniecCiagu && poczatekCiagu != -1; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    // Metoda do znalezienia najdłuższego ciągu liczb dodatnich w tablicy
    public static void najdluzszyCiagDodatnich(int[] tab) {
        int najdluzszyCiag = 0;
        int ciagSprawdzany = 0;
        int poczatekCiagu = -1;
        int koniecCiagu = -1;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > 0) { // Jeśli liczba jest dodatnia
                ciagSprawdzany++;
                if (ciagSprawdzany > najdluzszyCiag) {
                    najdluzszyCiag = ciagSprawdzany;
                    koniecCiagu = i;
                    poczatekCiagu = i - najdluzszyCiag + 1;
                }
            } else { // Resetujemy licznik, gdy napotkamy liczbę niedodatnią
                ciagSprawdzany = 0;
            }
        }

        System.out.println("Długość najdłuższego ciągu liczb dodatnich to: " + najdluzszyCiag);
        System.out.print("Najdłuższy ciąg dodatnich to: ");
        for (int i = poczatekCiagu; i <= koniecCiagu && poczatekCiagu != -1; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    // Metoda do znalezienia najdłuższego ciągu liczb parzystych w tablicy
    public static void najdluzszyCiagParzystych(int[] tab) {
        int najdluzszyCiag = 0;
        int ciagSprawdzany = 0;
        int poczatekCiagu = -1;
        int koniecCiagu = -1;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) { // Jeśli liczba jest parzysta
                ciagSprawdzany++;
                if (ciagSprawdzany > najdluzszyCiag) {
                    najdluzszyCiag = ciagSprawdzany;
                    koniecCiagu = i;
                    poczatekCiagu = i - najdluzszyCiag + 1;
                }
            } else { // Resetujemy licznik, gdy napotkamy liczbę nieparzystą
                ciagSprawdzany = 0;
            }
        }

        System.out.println("Długość najdłuższego ciągu liczb parzystych to: " + najdluzszyCiag);
        System.out.print("Najdłuższy ciąg parzystych to: ");
        for (int i = poczatekCiagu; i <= koniecCiagu && poczatekCiagu != -1; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    // Metoda do znalezienia najdłuższego ciągu liczb nieparzystych w tablicy
    public static void najdluzszyCiagNieparzystych(int[] tab) {
        int najdluzszyCiag = 0;
        int ciagSprawdzany = 0;
        int poczatekCiagu = -1;
        int koniecCiagu = -1;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 != 0) { // Jeśli liczba jest nieparzysta
                ciagSprawdzany++;
                if (ciagSprawdzany > najdluzszyCiag) {
                    najdluzszyCiag = ciagSprawdzany;
                    koniecCiagu = i;
                    poczatekCiagu = i - najdluzszyCiag + 1;
                }
            } else { // Resetujemy licznik, gdy napotkamy liczbę parzystą
                ciagSprawdzany = 0;
            }
        }

        System.out.println("Długość najdłuższego ciągu liczb nieparzystych to: " + najdluzszyCiag);
        System.out.print("Najdłuższy ciąg nieparzystych to: ");
        for (int i = poczatekCiagu; i <= koniecCiagu && poczatekCiagu != -1; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Przykładowa tablica do testów
        int[] tablica = {1, -2, -3, 4, 6, -5, -6, -7, 0, 8, 10, -1, -2, -3, 5, 7, 9};

        // Wywołanie metod i wyświetlenie wyników
        najdluzszyCiagUjemnych(tablica);
        najdluzszyCiagDodatnich(tablica);
        najdluzszyCiagParzystych(tablica);
        najdluzszyCiagNieparzystych(tablica);
    }
}
