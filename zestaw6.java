import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zestaw6 {
    static class KoszykZakupowy {
        //k:produkt v:cena
        HashMap<Produkt, Integer> koszyk;

        public KoszykZakupowy() {
            this.koszyk = new HashMap<Produkt, Integer>();

        }

        public void dodajProdukty(int ilosc, Produkt produkt,zestaw7.Magazyn magazyn) {
            if (magazyn.getIloscDanegoProduktuNaMagzaynie(produkt) < ilosc) {
                throw new ArithmeticException("maksymalnie mozna dodać " + magazyn.getIloscDanegoProduktuNaMagzaynie(produkt) + " sztuk");
            } else {
                magazyn.usunZMagazynu(produkt,ilosc);
                koszyk.put(produkt, koszyk.getOrDefault(produkt, 0) + ilosc);
            }
        }

        public void wyswietlZawartoscKoszyka() {
            if (koszyk.isEmpty()) {
                System.out.println("koszyk jest pusty");
            } else {
                for (Produkt produkt : koszyk.keySet()) {
                    System.out.println(produkt.nazwa + "\nsztuk: " + koszyk.get(produkt) + "\ncena 1 sztuki: " + produkt.cena + "\n");
                }
            }
        }

        public double obliczCalkowitaWartosc() {
            double wartoscCalkowita = 0; //ilosc produktow+cena prodowktow
            for (Produkt produkt : koszyk.keySet()) {
                wartoscCalkowita = wartoscCalkowita + (produkt.getCena() * koszyk.get(produkt));
            }
            return wartoscCalkowita;
        }

    }

    static class Produkt {
        String nazwa;
        double cena;
        int iloscNaMagazynie;
        public Produkt(String nazwa, double cena){//,zestaw7.Magazyn magazyn) {
            this.nazwa = nazwa;
            this.cena = cena;
            //this.iloscNaMagazynie = magazyn.IloscDanegoProduktuNaMagazynie();

        }

        public void wyswietlInformacje() {
            System.out.println(toString());
        }

        public double getCena() {
            return cena;
        }

        @Override
        public String toString() {
            return "Nazwa: " + this.nazwa + "\n"
                    + "Cena: " + this.cena + "\n" +
                    "Ilość na magazynie: " + this.iloscNaMagazynie + "\n";
        }

        @Override
        public boolean equals(Object obj) {
            //sprawdzanie czy oba obiekty sa tym samym bojektem w pamieci
            if (this == obj) return true;
            //jesli tak ,ale obiekt jest nuelem lub klasa jest inna false
            if (obj == null || getClass() != obj.getClass()) return false;
            Produkt produkt = (Produkt) obj; //rzutowanie obiektow ktore sie powiedzie bo wczesniej sprawdzilismy
            return this.nazwa.equals(produkt.nazwa);//sprawdzanie czy nazwa jest taka sama
        }

        @Override
        public int hashCode() {
            return this.nazwa.hashCode();
        }
    }

    static class Zamowienie {
        KoszykZakupowy koszyk;
        Platnosc platnosc;

        enum Status {
            przekazane_do_realizacji,
            w_realizacji,
            gotowe_do_wysylki,
            wyslane,
            wydane_do_doreczenia,
            doreczone,
            odebrane

        }

        Status statusZamowienia;

        Zamowienie(KoszykZakupowy koszyk, Status status) {
            this.koszyk = koszyk;
            this.statusZamowienia = status;
        }

        public Status ustawStatusZamowienia(Status status) {
            if (status == null) {
                throw new IllegalArgumentException("zly status zamowienia");
            }
            this.statusZamowienia = status;
            return this.statusZamowienia;
        }

        public void wyswietlZamowienie() {
            koszyk.wyswietlZawartoscKoszyka();
            System.out.println(statusZamowienia);
        }

        public void finalizujZamowienie(Platnosc platnosc) {
            if (platnosc.statusPlatnosci == Platnosc.Status.oplacane) {
                this.statusZamowienia = Status.gotowe_do_wysylki;
                System.out.println("zamowienie gotowe do wysylki");
            } else {
                System.out.println("zamowienie nei zsoatlo oplacone!");
            }
        }

        void zwrocProdukt(Produkt produkt, int ilosc, double pieniadze, KoszykZakupowy koszyk,zestaw7.Magazyn magazyn) {
            magazyn.dodajDoMagazynu(produkt,ilosc);
            koszyk.koszyk.remove(produkt);
            //todo pieniadze wracją do kl
        }
    }

    static class Klient {
        String imie;
        String nazwisko;
        ArrayList<Zamowienie> listaZamowien;

        public Klient(String imie, String nazwisko) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.listaZamowien = new ArrayList<Zamowienie>();
        }

        public List<Zamowienie> dodajZmowienie(Zamowienie zamowienie) {
            this.listaZamowien.add(zamowienie);
            return this.listaZamowien;
        }

        public void wyswietlHistorieZamowien() {
            if (listaZamowien.isEmpty()) {
                System.out.println("Brak zamowien do wyswitlenia");
            } else {
                System.out.println("Lista Zamowien");
                for (Zamowienie i : listaZamowien) {
                    i.wyswietlZamowienie();
                }
            }
        }

        public double obliczLacznyKosztZamowien() {
            double lacznyKosztZamowien = 0;

            for (Zamowienie i : listaZamowien) {
                lacznyKosztZamowien += i.koszyk.obliczCalkowitaWartosc();
            }
            return lacznyKosztZamowien;
        }
    }

    static class Sklep {
        Map<String, Produkt> produkty;

        Sklep() {
            this.produkty = new HashMap<>();
        }

        public void dodajProdukt(Produkt produkt) {
            if (produkty.containsKey(produkt.nazwa)) {
                throw new IllegalArgumentException("Produkt o tej nazwie już istnieje w sklepie.");
            }
            produkty.put(produkt.nazwa, produkt);
        }

        public void wyswietlOferty() {
            for (Produkt produkt : produkty.values()) {
                produkt.wyswietlInformacje();
            }

        }

        public Produkt wyszukajProdukt(String nazwaSzukanegoProduktu) {
            return produkty.get(nazwaSzukanegoProduktu);
        }

        public void zakupy(String nazwaProduktu, int ilosc, KoszykZakupowy koszykKlienta, zestaw7.Magazyn magazyn) {
            Produkt produktZakupiany = wyszukajProdukt(nazwaProduktu);
            if (produktZakupiany == null) {
                System.out.println("Produkt o nazwie \"" + nazwaProduktu + "\" nie jest dostępny w sklepie.");
                return;
            }
            if (magazyn.getIloscDanegoProduktuNaMagzaynie(produktZakupiany) < ilosc) {
                System.out.println("Brak wystarczającej ilości produktu \"" + nazwaProduktu + "\" w sklepie.");
                return;
            }
            magazyn.usunZMagazynu(produktZakupiany,ilosc);
            koszykKlienta.dodajProdukty(ilosc, produktZakupiany,magazyn);
        }
    }

    static class Platnosc {
        double kwota;

        enum Status {
            do_zaplaty,
            przetwarzanie_platnosci,
            oplacane
        }

        Status statusPlatnosci;

        Platnosc(double kwota) {
            this.kwota = kwota;
            this.statusPlatnosci = Status.do_zaplaty;
        }

        public void zaplac() {
            if (this.kwota > 0) {
                this.statusPlatnosci = Status.oplacane;
                this.kwota = 0;
            } else {
                System.out.println("Brak zamowiene w sklepie.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("ZADANIE 1");
        Produkt ksiazki = new Produkt("ksiazka", 22);
        zestaw7.Magazyn magazyn = new zestaw7.Magazyn();
        magazyn.dodajDoMagazynu(ksiazki,22);

        //wyrzucic w toString w klasie produkt informacje o jego ilosci na magazynie i przeniesc to do klasy magazynu
        produkt.wyswietlInformacje();
        //zamiast produkt _> magazyn.
        produkt.usunZMagazynu(3);
        produkt.wyswietlInformacje();
        produkt.usunZMagazynu(3);
        produkt.wyswietlInformacje();
        System.out.println(produkt.dodajDoMagazynu(10));
        produkt.wyswietlInformacje();

        System.out.println("ZADANIE 2");
        //bez ilosci
        Produkt notes = new Produkt("notes", 10, 5);
        Produkt dlugopis = new Produkt("dlugopis", 5, 5);
        Produkt olowek = new Produkt("olowek", 1, 5);
        KoszykZakupowy koszykZakupowy = new KoszykZakupowy();

        koszykZakupowy.wyswietlZawartoscKoszyka();

        //dodac w nawiasie z ktorego magazynu zdjemujemy
        koszykZakupowy.dodajProdukty(2, notes);
        koszykZakupowy.dodajProdukty(2, dlugopis);
        koszykZakupowy.dodajProdukty(2, olowek);

        koszykZakupowy.wyswietlZawartoscKoszyka();

        System.out.println("koszt całkowity:" + koszykZakupowy.obliczCalkowitaWartosc());
        System.out.println("ZADANIE 3");

        Zamowienie zamowienie1 = new Zamowienie(koszykZakupowy, Zamowienie.Status.w_realizacji);
        Zamowienie zamowienie2 = new Zamowienie(koszykZakupowy, Zamowienie.Status.w_realizacji);
        zamowienie1.ustawStatusZamowienia(Zamowienie.Status.doreczone);
        zamowienie1.wyswietlZamowienie();

        System.out.println("ZADANIE 4");
        Klient jest_taki_klient = new Klient("Żbik", "Sewerynowski");
        jest_taki_klient.wyswietlHistorieZamowien();
        jest_taki_klient.dodajZmowienie(zamowienie1);
        jest_taki_klient.dodajZmowienie(zamowienie2);

        jest_taki_klient.wyswietlHistorieZamowien();

        System.out.println(jest_taki_klient.obliczLacznyKosztZamowien());

        System.out.println("ZADANIE 5");
        Sklep papierniczy = new Sklep();

        papierniczy.wyswietlOferty();

        papierniczy.dodajProdukt(notes);
        papierniczy.dodajProdukt(dlugopis);
        papierniczy.dodajProdukt(olowek);

        papierniczy.wyswietlOferty();

        System.out.println(papierniczy.wyszukajProdukt("dlugopis"));

        KoszykZakupowy koszykZakupowy1 = new KoszykZakupowy();
        koszykZakupowy1.wyswietlZawartoscKoszyka();
        //dodac pramaetr magazynu
        papierniczy.zakupy("notes", 1, koszykZakupowy1);
        koszykZakupowy1.wyswietlZawartoscKoszyka();


    }
}
