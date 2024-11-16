public class kolokwium {
    public static void main(String[] args) {
        System.out.println("zad 1");
        // dokladnosc(20,30,5);

        System.out.println("zad 2");
        System.out.println(najblizszySasiad(20));

        System.out.println("zad 3");

        System.out.println("zad 4");
        int[]tab={1,2,5,1,2,6,4};
        // podciag(tab);

        System.out.println("zad 6");
        //System.out.println(czyPalindrom(12321));

        System.out.println("zad 7");
        //palindromLiczbowy(2);

    }
//        static public double pierwiastek(double S,double n,double k){
//        double x=S-1;
//        for(int i=0;;i++) {
//            if(dokladnosc()!=true){
//            double srednia = Math.pow(((x * (n - 1)) + (S / (Math.pow(x, n - 1)))), n);}
//            else {break;}
//        }
//
//        }

    //zakladam ze 1 cyfrowa liczba nie jest palindromem
    public static void palindromLiczbowy(int m){
        int poczatek=(int)((Math.pow(10,m-1))-1);
        int koniec=(int)((Math.pow(10,m))-1);
        for(int i=poczatek;i<=koniec;i++){
            for(int j=poczatek;j<=koniec;j++){
                int wynik=i*j;
                if(czyPalindrom(wynik)){
                    System.out.println(i+" x "+j+" = "+wynik);
                }
            }
        }

    }

    public static boolean dokladnosc(double x,double y,double k){
        double wBezwzdledna=(Math.abs(x-y));
        double potega=Math.pow(10,-k);
        if(wBezwzdledna<=potega){
            return true;
        }else {
            return false;
        }

    }

    public static int najblizszySasiad(double s) {
        double potega = 1.0 / 2.0;
        int mniejszySasiad;
        int wiekszySasiad;
        int ileiteracjiM=0;
        int ileiteracjiW=0;
        for (double i = s; ; i--) {
            double zmiP = Math.pow(i, potega);
            double wint = Math.pow((int) i, potega);
            ileiteracjiM++;
            if (zmiP == (int) wint) {
                mniejszySasiad = (int)i;
                break;

            }
        }

        for (double j = s; ; j++) {
            double zmiP = Math.pow(j, potega);
            double wint = Math.pow((int) j, potega);
            ileiteracjiW++;
            if (zmiP == (int) wint) {
                wiekszySasiad = (int)j;
                break;
            }
        }
        System.out.println(ileiteracjiW);

        if(wiekszySasiad-s>mniejszySasiad){return wiekszySasiad;}
        else {return mniejszySasiad;}

    }

    public static void podciag(int[]tab) {
        int najdluszyszCiag = 0;
        int ciagSprawdzany = 0;
        int indexkoncowy=0;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i-1] > tab[i]) {
                for (int j = i-1;j<tab.length ; j++) {
                    if (tab[j] > tab[j+1]) {
                        ciagSprawdzany++;
                    } else {
                        // Gdy napotkamy liczbę niedodatnią, przerywamy wewnętrzną pętlę
                        break;
                    }
                }
                // Przesuwamy indeks `i` o długość `ciagSprawdzany`, aby pominąć sprawdzony ciąg dodatni
                i=i+ciagSprawdzany;
                // Jeśli aktualny ciąg jest dłuższy niż poprzednio znaleziony najdłuższy ciąg
                if (ciagSprawdzany >= najdluszyszCiag) {
                    // Aktualizujemy długość najdłuższego ciągu dodatnich
                    najdluszyszCiag = ciagSprawdzany;
                    // Zapisujemy indeks końcowy aktualnie najdłuższego ciągu
                    indexkoncowy=i-1;
                }
                // Resetujemy `ciagSprawdzany` do 0 przed sprawdzeniem kolejnego ciągu
                ciagSprawdzany = 0;
            }
        }
        System.out.println("Długość najdłuższego ciągu dodatniego to: "+najdluszyszCiag);
        // Obliczenie indeksu początkowego najdłuższego ciągu dodatnich
        int indexpoczatkowy=indexkoncowy-najdluszyszCiag+1;
        System.out.print("Najdluzszy ciag dodatnich to: ");
        // Wyświetlenie elementów najdłuższego ciągu dodatnich liczb
        for (int k = indexpoczatkowy-1; k < tab.length; k++) {

            // Przerywamy pętlę, jeśli napotkamy liczbę niedodatnią
            System.out.print(tab[k]+" ");
            if(tab[k]<tab[k+1]) break;
        }
    }

    public static boolean czyPalindrom(int n) {
        // Zmienna `suma` będzie przechowywać liczbę budowaną od końca, aby porównać z oryginalną liczbą
        int suma = 0;//cyfra od tylu
// Zmienna `ucinana` przechowuje kopię liczby `n`, która będzie stopniowo "obcinana" (dzielona przez 10)
        int ucinana = n;
        // `wszystkie_cyfry` przechowuje liczbę cyfr w liczbie `n`, obliczoną przez funkcję `ileCyfr`
        int wszystkie_cyfry = ileCyfr(n);
        // Pętla przechodzi przez każdą cyfrę liczby `n` od końca, aby złożyć ją w odwrotnej kolejności w zmiennej `suma`
        //-1 bo tak to jest o 1 zero za duzo w potegowaniu
        if(n>=0 && n<=9) return false;

        for (int i = 0, j = wszystkie_cyfry - 1; j >= 0; i++, j--) {
            //System.out.println(ucinana);
            // Pobieramy ostatnią cyfrę `ucinana`
            int ostatnia_cyfra = ucinana % 10;
            // Dodajemy cyfrę do `suma` na odpowiedniej pozycji (w miejscu potęgi dziesiątki `j`)
            suma = suma + ostatnia_cyfra * (int) (Math.pow(10, j));
            //System.out.println(suma);
            // Usuwamy ostatnią cyfrę z `ucinana` przez dzielenie przez 10
            ucinana = ucinana / 10;
        }
        // Porównujemy złożoną liczbę `suma` z oryginalną liczbą `n`
        // Jeśli są równe, liczba jest palindromem i zwracamy `true`, w przeciwnym razie `false`
        if (suma == n) return true;
        else return false;
    }

    public static int ileCyfr(int n) {
        int ile = 0;
        int i = 0;
        while (n != 0) {
            n = n / 10;
            i++;
            ile++;
        }
        return ile;
    }
}
