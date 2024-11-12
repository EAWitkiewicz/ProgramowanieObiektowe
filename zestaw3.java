import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class zestaw3 {

    public static void main(String[] args) {
        //trojkiPitagorejskie(20);
        //funKwaRozwiazania(3);
        //funKwaDelta(5);
        //liczbyPierwsze(17);
        //liczbyPodzielne(2,20);
        //piramida(3,1);
        //silnia(5);
        //silniaPodwojona(5);
        //silnia(3,9);
        //dwumianNewtona(7,4);
        //ciagFibonaccieg(10);
        //sumaNaturalnych(5);
        //sumaParzystych(5);
        //sumaNieparzystych(5);
        //sumaKwaNaturalnych(5);
        //sumaSzeNaturlanych(3);
        //sumaOdwNaturalnych(3);
        //System.out.println(czyPalindorm("pkaki"));

        //trojkatPascala(5);
        System.out.println(czyPalindrom(5135));

        //System.out.print(czyPalindrom(12321));
        //System.out.println(czyDoskonala(496));
        //System.out.println(czyPierwsza(5));

        //NWD(1122,867);
        //wczytajTablice();
    }

    //todo podzbiory tabicy mgr Zalewski mowi ze podobne do marge sort wiec wroc tu jak toograniesz (albo te dwa algorytmy z forum nagle zaskoczą)

    static void podzbiory(int[] tablica) {
        int elementyWNowejTablicy = 0;
        for (int element : tablica) {
            elementyWNowejTablicy++;
        }
        elementyWNowejTablicy = (int) (Math.pow(2, (double) elementyWNowejTablicy));
        String[] nowaTablica = new String[elementyWNowejTablicy];
        //String nowaTablica=String []
    }

    static void wczytajTablice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile elementow w tablicy?");
        int iloscElementowTablicy = scanner.nextInt();
        String[] tablica = new String[iloscElementowTablicy];
        System.out.println("Podawaj kolejne elementy majace byc dodane do tablicy");
        for (int i = 0; i < iloscElementowTablicy; i++) {
            String element = scanner.next();
            tablica[i] = element;
        }
        System.out.print("Tablica = [");
        for (String element : tablica) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }

    static void NWD(int a, int b) {
        int swap = 0;
        for (int i = 0; a != b; i++) {
            if (a > b) {
                swap = a;
                a = swap - b;
                //System.out.println("1 swap : "+swap+" ;a :"+a+" ;b :"+b);
                swap = 0;
            }
            if (a < b) {
                swap = b;
                b = swap - a;
                swap = 0;
                //System.out.println("2 swap : "+swap+" ;a :"+a+" ;b :"+b);
            }
        }
        System.out.println("najwiekszy wspolny dzielnik to :" + a);
    }

    static boolean czyPierwsza(int n) {
        int dzielniki = 0;
        boolean wynik = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) dzielniki++;
            }
            if (dzielniki == 2 && i == n) wynik = true;
            else if (dzielniki > 2 && i == n) wynik = false;
            dzielniki = 0;
        }
        return wynik;
    }

    static boolean czyDoskonala(int n) {
        int suma = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) suma = suma + i;
        }
        if (suma == n) return true;
        else return false;
    }

    static void trojkatPascala(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                //System.out.print(" x    ");
                System.out.print(+dwumianNewtonaDoPiramidy(i, k) + " ");
            }
            System.out.println();
        }
    }

    static boolean czyPalindorm(String wyraz) {
        // Zmienna licznika, która przechowuje liczbę par znaków, które są takie same pod względem indeksów od początku i końca
        int teSameZnakiPOdIndexem = 0;

        // Sprawdzamy, czy długość słowa jest nieparzysta
        if (wyraz.length() % 2 == 1) {
            // Pętla przechodzi przez połowę długości słowa plus jeden znak (dla nieparzystych długości)
            for (int i = 0; i < (wyraz.length() / 2) + 1; i++) {
                // Sprawdzamy, czy znak na pozycji `i` jest taki sam jak znak na pozycji z końca słowa
                // Jeżeli znaki są takie same, zwiększamy licznik `teSameZnakiPOdIndexem`
                if (wyraz.charAt(i) == wyraz.charAt((wyraz.length() - 1) - i)) teSameZnakiPOdIndexem++;
                    // Jeżeli natrafimy na parę znaków, które nie są takie same, zwracamy `false` (nie jest palindromem)
                else return false;
            }
            // Po zakończeniu pętli sprawdzamy, czy licznik ma wartość równą połowie długości słowa + 1 (dla nieparzystych długości)
            if (teSameZnakiPOdIndexem == wyraz.length() / 2 + 1) return true;
            else return false;
        } else {
            // Gdy długość słowa jest parzysta
            // Pętla przechodzi przez dokładnie połowę długości słowa
            for (int i = 0; i < wyraz.length() / 2; i++) {
                // Sprawdzamy, czy znak na pozycji `i` jest taki sam jak znak na pozycji z końca słowa
                if (wyraz.charAt(i) == wyraz.charAt((wyraz.length() - 1) - i)) teSameZnakiPOdIndexem++;
                    // Jeżeli napotkamy różne znaki, zwracamy `false` (nie jest palindromem)
                else return false;
            }
            // Po zakończeniu pętli sprawdzamy, czy licznik ma wartość równą połowie długości słowa (dla parzystych długości)
            if (teSameZnakiPOdIndexem == wyraz.length() / 2) return true;
            else return false;
        }

    }

    static boolean czyPalindrom(int n) {
        // Zmienna `suma` będzie przechowywać liczbę budowaną od końca, aby porównać z oryginalną liczbą
        int suma=0;//cyfra od tylu
// Zmienna `ucinana` przechowuje kopię liczby `n`, która będzie stopniowo "obcinana" (dzielona przez 10)
        int ucinana=n;
        // `wszystkie_cyfry` przechowuje liczbę cyfr w liczbie `n`, obliczoną przez funkcję `ileCyfr`
        int wszystkie_cyfry=ileCyfr(n);
        // Pętla przechodzi przez każdą cyfrę liczby `n` od końca, aby złożyć ją w odwrotnej kolejności w zmiennej `suma`
        //-1 bo tak to jest o 1 zero za duzo w potegowaniu
        for(int i=0,j=wszystkie_cyfry-1;j>=0;i++,j--){
            System.out.println(ucinana);
            // Pobieramy ostatnią cyfrę `ucinana`
            int ostatnia_cyfra=ucinana%10;
            // Dodajemy cyfrę do `suma` na odpowiedniej pozycji (w miejscu potęgi dziesiątki `j`)
            suma=suma+ostatnia_cyfra*(int)(Math.pow(10,j));
            System.out.println(suma);
            // Usuwamy ostatnią cyfrę z `ucinana` przez dzielenie przez 10
            ucinana=ucinana/10;
        }
        // Porównujemy złożoną liczbę `suma` z oryginalną liczbą `n`
        // Jeśli są równe, liczba jest palindromem i zwracamy `true`, w przeciwnym razie `false`
        if(suma==n) return true;
        else return false;
    }
    //nigdzie w poleceniu nie ma ze ma wszytko siedziec w jednej funcji i nie moge sobie tego rozbić
    //wiec rozbije
    static int ileCyfr(int n){
        int ile=0;
        int i = 0;
        while (n!=0) {
            n=n/10;
            i++;
            ile++;
        }
        return ile;
    }

    static void sumaNaturalnych(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        System.out.println(suma);
    }

    static void sumaParzystych(int n) {
        int suma = 0;
        for (int i = 0; i <= n; i += 2) {
            suma += i;
        }
        System.out.println(suma);
    }

    static void sumaNieparzystych(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i += 2) {
            suma += i;
        }
        System.out.println(suma);
    }

    static void sumaKwaNaturalnych(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            int kwadrat = i * i;
            suma += kwadrat;
        }
        System.out.println(suma);
    }

    static void sumaSzeNaturlanych(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            int szczescian = i * i * i;
            suma += szczescian;
        }
        System.out.println(suma);
    }

    static void sumaOdwNaturalnych(int n) {
        double suma = 0;
        for (double i = 1; i <= n; i++) {
            double odwrotna = 1 / i;
            suma += odwrotna;
        }
        System.out.println(suma);
    }

    static void ciagFibonaccieg(int n) {
        int an0 = 1;
        int an1 = 1;
        int an = 0;
        if (n == 0) System.out.println("0");
        if (n == 1) System.out.println("1");
        if (n > 1) {
            System.out.println(an);
            System.out.println(an0);
            System.out.println(an1);
            for (int i = 3; i <= n; i++) {
                an = an0 + an1;
                System.out.println(an);
                an0 = an1;
                an1 = an;
            }
        }
    }

    static void dwumianNewtona(int n, int k) {
        if (n < k) System.out.println("To nie pyknie");
        else {
            int silniaK = 1;
            int silniaN = 1;
            int silniaNK = 1;
            for (int i = 1, j = 1, l = 1; i <= n; i++, j++, l++) {
                silniaN *= i;
                if (j <= k) silniaK *= j;
                if (l <= (n - k)) silniaNK *= l;
            }
            int wynik = silniaN / (silniaK * (silniaNK));
            System.out.println(wynik);
        }
    }

    static int dwumianNewtonaDoPiramidy(int n, int k) {
        int wynik = 0;
        // if(n<k) System.out.println("To nie pyknie");
        //else {
        int silniaK = 1;
        int silniaN = 1;
        int silniaNK = 1;
        for (int i = 1, j = 1, l = 1; i <= n; i++, j++, l++) {
            silniaN *= i;
            if (j <= k) silniaK *= j;
            if (l <= (n - k)) silniaNK *= l;
        }
        wynik = silniaN / (silniaK * (silniaNK));
        //}
        return wynik;
    }

    static void silnia(int m, int n) {
        int suma = 1;
        for (int i = m; i <= n; i += m) {
            suma *= i;
            System.out.println(i);
            System.out.println(suma);
        }
    }

    //nie bylo napisane ktora wiec jest dla nieparzystych
    static void silniaPodwojona(int n) {
        int suma = 1;
        for (int i = 1; i <= n; i += 2) {
            suma *= i;
            System.out.println(i);
            System.out.println(suma);
        }
    }

    static void silnia(int n) {
        int suma = 1;
        for (int i = 1; i <= n; i++) {
            suma *= i;
            System.out.println(i);
            System.out.println(suma);
        }
    }

    static void piramida(int n, int variant) {
        if (variant == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print("_");
                }
                for (int k = 0; k <= i * 2; k++) {
                    System.out.print("X");
                }
                System.out.println();
            }
        } else if (variant == 2) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k <= i; k++) {
                    System.out.print("X");
                }
                System.out.println();
            }
        }
    }

    static void liczbyPodzielne(int m, int n) {
//wypisywanie liczb 10-99
        //sprzawszadnie podzielnosci
        int ograniczenieDolne = (int) (Math.pow(10, m - 1));
        int ograniczenieGorne = (int) (Math.pow(10, m));
        for (int i = ograniczenieDolne; i < ograniczenieGorne; i++) {
            if (i % n == 0) System.out.println(i);
        }
    }

    static void liczbyPierwsze(int n) {
        int dzielniki = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) dzielniki++;
            }
            if (dzielniki == 2) {
                System.out.println(i);
            }
            dzielniki = 0;
        }
    }

    static void funKwaDelta(int n) {
        for (int a = 1; a < n; a++) {//jesli a rowne zero to ronanie bylby liniowe
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    int delta = b * b - (4 * a * c);
                    if (delta >= 0 && Math.sqrt(delta) % 1 == 0) {
                        System.out.println(Math.sqrt(delta));
                        System.out.println(a + "," + b + "," + c);
                    }
                }

            }
        }
    }

    static void funKwaRozwiazania(int n) {
        for (int a = 1; a < n; a++) {//jesli a rowne zero to ronanie bylby liniowe
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    if (b * b - (4 * a * c) >= 0) {
                        System.out.println(a + "," + b + "," + c);
                    }
                }
            }
        }

    }

    static void trojkiPitagorejskie(int n) {
        if (n < 5) {
            System.out.println("brak trojek pitagorejskich");
        }
        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                //if (a < b) {//zamiast tego ifa po porostu zamiast b=1 bedzie b+1 wiec nie ptrzeba bedzie sprawdzac
                for (int c = 1; c < n; c++) {
                    {
                        if (a * a + b * b == c * c) {
                            System.out.println(a + "," + b + "," + c);
                        }
                    }
                }
                //}
            }
        }
    }
}
