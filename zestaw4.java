import java.io.Console;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class zestaw4 {
    public static void main(String[] args) {
        int[] tab = {1, 2, 3};
        //wypiszTablice(tab, 2, 3);
        int[] tablica = generujTablice(8, 1, 9);
        System.out.println(Arrays.toString(tablica));
//        ileNieparzystych(tablica);
//        ileParzystych(tablica);
//        ileDodatnich(tablica);
//        ileUjemnych(tablica);
//        ileZerowych(tablica);
        // ileMaxymalnych(tablica);
        //ileMinimalnych(tablica);
        //ileUnikalnych(tablica);

        //sumaDodatnich(tablica);
        //sumaUjemnych(tablica);
        //sumaOdwrotnosci(tablica);
        //sredniaArytmetyczna(tablica);
        //sredniaGeometryczna(tablica);
        //sredniaHarmoniczna(tablica);

//        System.out.println(Arrays.toString(funkcjaLiniowa(tablica, 2, 3)));
//        System.out.println(Arrays.toString(funkcjaKwadratowa(tablica, 2, 3,4)));
//        System.out.println(Arrays.toString(funkcjaWykladnicza(tablica, 2)));
//        System.out.println(Arrays.toString(funkcjaSignum(tablica)));

//        najdluzszyCiagDodatnich(tablica);
//        najdluzszyCiagUjemnych(tablica);
 //       odwrocTablice(tablica);
 //       odwrocTablice(tablica, 2, 7);
    }

    public static void odwrocTablice(int[]tab,int indexStart,int indexStop){
        /** tak mozna bylo zrobic i bylby opytmalniej
        int[] tablicaOdwrocona = Arrays.copyOf(tab, tab.length); // Kopia oryginalnej tablicy
        int j = indexStop;  // Używamy `j` do iteracji od końca podtablicy
        // Pętla od `indexStart` do `indexStop` włącza odwrócenie wybranego zakresu
        for (int i = indexStart; i <= indexStop; i++) {
            tablicaOdwrocona[i] = tab[j];
            j--;
        }*/

        int[]tablicaOdwrocona=new int[tab.length];
        int j=indexStop;
        for(int i=0;i<tab.length;i++){
            //tablicaOdwrocona[i]=tab[i];
            if(i==indexStart){
                while(j>=indexStart){
                    tablicaOdwrocona[i]=tab[j];
                    i++;
                    j--;
                }
                i--;
            }
            else tablicaOdwrocona[i]=tab[i];
        }
        System.out.println(Arrays.toString(tablicaOdwrocona));
        }




    public static void odwrocTablice(int[]tab){
        int[]tablicaOdwrocona=new int[tab.length];
        for(int i= tab.length-1, j=0;i>=0 && j<=tab.length;i--,j++){
            tablicaOdwrocona[j]=tab[i];
        }
        System.out.println(Arrays.toString(tablicaOdwrocona));
    }

    public static void najdluzszyCiagUjemnych(int[]tab){
        int najdluzszyCiag = 0;
        int ciagSprawdzany = 0;
        int poczatekCiagu = 0;
        int koniecCiagu = 0;
        int aktualnyPoczatek = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < 0) {
                ciagSprawdzany++;
                if (ciagSprawdzany == 1) aktualnyPoczatek = i;  // Zapisz początek nowego dodatniego ciągu
                if (ciagSprawdzany > najdluzszyCiag) {
                    najdluzszyCiag = ciagSprawdzany;
                    poczatekCiagu = aktualnyPoczatek;
                    koniecCiagu = i;
                }
            } else {
                ciagSprawdzany = 0;
            }
        }

        System.out.println("Długość najdłuższego ciągu liczb ujemnych to: " + najdluzszyCiag);
        System.out.print("Najdłuższy ciąg ujemnych to: ");
        for (int i = poczatekCiagu; i <= koniecCiagu; i++) {
            System.out.print(tab[i] + " ");
        }
    }

    //tu jest po mojemu czyli słabo i niepotymalnie. Wrzucilam to w chat do sprawdzenia
    //i wyrzcuił optymalniej i ładniej wiec na wzór  tego z chatu zrobie dla ujemnych
    public static void najdluzszyCiagDodatnich(int[] tab) {
        int najdluszyszCiag = 0;
        int ciagSprawdzany = 0;
        int indexkoncowy=0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > 0) {
                for (int j = i;j<tab.length ; j++) {
                    if (tab[j] > 0) {
                        ciagSprawdzany++;
                    } else {
                        break;
                    }
                }
                i=i+ciagSprawdzany;
                if (ciagSprawdzany > najdluszyszCiag) {
                    najdluszyszCiag = ciagSprawdzany;
                    indexkoncowy=i-1;
                }
                ciagSprawdzany = 0;
            }
        }
        System.out.println("Długość najdłuższego ciągu dodatniego to: "+najdluszyszCiag);
        int indexpoczatkowy=indexkoncowy-najdluszyszCiag+1;
        System.out.print("Najdluzszy ciag dodatnich to: ");
        for (int i = indexpoczatkowy; i < tab.length; i++) {
            if(tab[i]<=0) break;
            System.out.print(tab[i]+" ");
        }
    }

    public static int[] funkcjaSignum(int[] tab) {
        int[] tablica = tab.clone();
        for (int i = 0; i < tab.length; i++) {
            ;
            if (tablica[i] > 0) tablica[i] = 1;
            if (tablica[i] == 0) tablica[i] = 0;
            if (tablica[i] < 0) tablica[i] = -1;
        }
        return tablica;
    }

    public static double[] funkcjaWykladnicza(int[] tab, double a) {
        double[] tablica = new double[tab.length];
        for (int i = 0; i < tab.length; i++) {
            tablica[i] = Math.pow(a, tab[i]);
        }
        return tablica;
    }

    public static double[] funkcjaKwadratowa(int[] tab, double a, double b, double c) {
        double[] tablica = new double[tab.length];
        for (int i = 0; i < tab.length; i++) {
            tablica[i] = Math.pow(a * tab[i], 2) + b * tab[i] + c;
        }
        return tablica;
    }

    public static double[] funkcjaLiniowa(int[] tab, double a, double b) {
        double[] tablica = new double[tab.length];
        for (int i = 0; i < tab.length; i++) {
            tablica[i] = a * tab[i] + b;
        }
        return tablica;
    }

    public static void sredniaHarmoniczna(int[] tab) {
        double sumaOdwrotnosci = sumaOdwrotnosci(tab);
        double ile = ileDodatnich(tab);
        double sredniaHarmoniczna = ile / sumaOdwrotnosci;
        System.out.println("Srednia harmniczna liczb w tablicy to: " + sredniaHarmoniczna + "\n");
    }

    //bedzie dla dodatnich ok?
    public static void sredniaGeometryczna(int[] tab) {
        System.out.println(Arrays.toString(tab));
        //troche chyba slabo bedzie jak tablica bedzie 1 elementowa
        double iloczyn = 1;
        double ktoraPotega = 0;
        for (int el : tab) {
            if (el > 0) {
                iloczyn = iloczyn * el;
                ktoraPotega++;
            }
        }
        double srednia = Math.pow(iloczyn, 1 / ktoraPotega);
        System.out.println("Srednia geomatryczna liczb w tablicy to: " + srednia + "\n");
    }

    public static void sredniaArytmetyczna(int[] tab) {
        System.out.println(Arrays.toString(tab));
        double suma = 0;
        for (int el : tab) {
            suma += el;
        }
        double srednia = suma / tab.length;
        System.out.println("Srednia liczb w tablicy to: " + srednia + "\n");
    }

    public static double sumaOdwrotnosci(int[] tab) {
        System.out.println(Arrays.toString(tab));
        double suma = 0;
        for (double el : tab) {
            if (el == 0) {
                double odwrotnosc = 0;
                suma += odwrotnosc;
            } else {
                double odwrotnosc = 1 / el;
                suma += odwrotnosc;
            }
        }
        return suma;
    }

    public static void sumaUjemnych(int[] tab) {
        System.out.println(Arrays.toString(tab));
        int suma = 0;
        for (int el : tab) {
            if (el < 0) suma = suma + el;
        }
        System.out.println("Suma liczb ujemnych: " + suma + "\n");
    }

    public static void sumaDodatnich(int[] tab) {
        System.out.println(Arrays.toString(tab));
        int suma = 0;
        for (int el : tab) {
            if (el > 0) suma = suma + el;
        }
        System.out.println("Suma liczb dodatnich: " + suma + "\n");
    }

    public static void ileUnikalnych(int[] tab) {
        System.out.println(Arrays.toString(tab));
        //zanjdowanie max i min aby wiedziec jaki zakres bedzie miec tablica
        int min = znajdzMinimum(tab);
        int max = znajdzMaximum(tab);
        //zaminna na wielkosc tej tablicy
        int ileMiejscaNaTablice = 0;
        //znajodwanie wielkosci/zakresu indexow w tablicy
        for (int i = min; i <= max; i++) {
            ileMiejscaNaTablice++;
        }
        int[] tablicaLicznikow = new int[ileMiejscaNaTablice];

        for (int i = 0; i < tablicaLicznikow.length; i++) {
            tablicaLicznikow[i] = 0;
            for (int j = 0; j < tab.length; j++) {
                if (tab[j] == i - Math.abs(min)) {
                    tablicaLicznikow[i]++;
                    System.out.println(Arrays.toString(tablicaLicznikow));
                    System.out.println("\n");
                }
            }
        }
        System.out.println(Arrays.toString(tablicaLicznikow));
        System.out.println(Arrays.toString(tab));
        int ileUnikalnych = 0;
        for (int i = 0; i < tablicaLicznikow.length; i++) {
            if (tablicaLicznikow[i] == 1) {
                ileUnikalnych++;
            }
        }
        System.out.println("W tablicy:\n" + Arrays.toString(tab) + "\nLiczba liczb unikalnych to:  " + ileUnikalnych + "\n");
    }

    public static int znajdzMinimum(int[] tab) {
        int min = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] < min) {
                min = tab[i];
            }
        }
        return min;
    }

    public static int znajdzMaximum(int[] tab) {
        int max = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] > max) {
                max = tab[i];
            }
        }
        return max;
    }

    public static void ileMinimalnych(int[] tab) {
        int ileMin = 0;
        int min = tab[0];
        for (int el : tab) {
            if (el < min) {
                min = el;
            }
        }
        for (int el : tab) {
            if (el == min) ileMin++;
        }
        System.out.println("W tablicy:\n" + Arrays.toString(tab) + "\nLiczba liczb minimalnych to:  " + ileMin + "\n");
    }

    public static void ileMaxymalnych(int[] tab) {
        int ileMax = 0;
        int max = tab[0];
        for (int el : tab) {
            if (el > max) {
                max = el;
            }
        }
        for (int el : tab) {
            if (el == max) ileMax++;
        }
        System.out.println("W tablicy:\n" + Arrays.toString(tab) + "\nLiczba liczb maxymalnych to:  " + ileMax + "\n");
    }

    public static void ileZerowych(int[] tab) {
        int ileZer = 0;
        for (int el : tab) {
            if (el == 0) ileZer++;
        }
        System.out.println("W tablicy:\n" + Arrays.toString(tab) + "\nLiczba zer to:  " + ileZer + "\n");
    }

    public static void ileUjemnych(int[] tab) {
        int ileUjemnych = 0;
        for (int el : tab) {
            if (el < 0) ileUjemnych++;
        }
        System.out.println("W tablicy:\n" + Arrays.toString(tab) + "\nLiczba ujemnych liczb to:  " + ileUjemnych + "\n");
    }

    public static int ileDodatnich(int[] tab) {
        int ileDodatnich = 0;
        for (int el : tab) {
            if (el > 0) ileDodatnich++;
        }
        return ileDodatnich;
    }

    public static void ileParzystych(int[] tab) {
        int ileParzystych = 0;
        for (int el : tab) {
            if (el % 2 == 0) ileParzystych++;
        }
        System.out.println("W tablicy:\n" + Arrays.toString(tab) + "\nLiczba parzystych liczb to:  " + ileParzystych + "\n");
    }

    public static void ileNieparzystych(int[] tab) {
        int ileNieparzystych = 0;
        for (int el : tab) {
            if (el % 2 != 0) ileNieparzystych++;
        }
        System.out.println("W tablicy:\n" + Arrays.toString(tab) + "\nLiczba nieparzystych liczb to:  " + ileNieparzystych + "\n");

    }

    public static void wypiszTablice(int[] tab, int n, int m) {
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
        for (int[] row : macierz) {
            for (int el : row) {
                System.out.print(String.format("%4d", el));
            }
        }
        //Arrays.deepToString(macierz)-wypisze wielowymiaraw tablice ciagiem
        //Arrays.toString wypisuje jednowymiareowe tablice
    }

    public static int[] generujTablice(int n, int minWartosc, int maxWartosc) {
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
        return tablica;
    }
}
