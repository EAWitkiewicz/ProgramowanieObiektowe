import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zestaw6 {
    static class KoszykZakupowy {
        HashMap<Produkt, Integer> produkty;

        public KoszykZakupowy() {
            this.produkty = new HashMap<Produkt, Integer>();

        }

        public void dodajProdukty(int ilosc, Produkt produkt) {
            if (produkt.getIloscNaMagazynie() < ilosc) {
                throw new ArithmeticException("maksymalnie mozna dodać " + produkt.getIloscNaMagazynie() + " sztuk");
            } else {
                produkt.usunZMagazynu(ilosc);
                produkty.put(produkt, produkty.getOrDefault(produkt, 0) + ilosc);
            }
        }

        public void wyswietlZawartoscKoszyka() {
            if (produkty.isEmpty()) {
                System.out.println("koszyk jest pusty");
            } else {
                for (Produkt produkt : produkty.keySet()) {
                    System.out.println(produkt.nazwa + "\nsztuk: " + produkty.get(produkt) + "\ncena 1 sztuki: " + produkt.cena + "\n");
                }
            }
        }

        public double obliczCalkowitaWartosc() {
            double wartoscCalkowita = 0; //ilosc produktow+cena prodowktow
            for (Produkt produkt : produkty.keySet()) {
                wartoscCalkowita = wartoscCalkowita + (produkt.getCena() * produkty.get(produkt));
            }
            return wartoscCalkowita;
        }

    }

    static class Magazyn {
        Map<String, Integer> produktyIichIlosc = new HashMap<String, Integer>();
    }

    static class Produkt {
        String nazwa;
        double cena;
        int iloscNaMagazynie;

        public Produkt(String nazwa, double cena, int iloscNaMagazynie) {
            this.nazwa = nazwa;
            this.cena = cena;
            this.iloscNaMagazynie = iloscNaMagazynie;
        }

        public void wyswietlInformacje() {
            System.out.println(toString());
        }

        public int dodajDoMagazynu(int ileDodac) {
            this.iloscNaMagazynie = this.iloscNaMagazynie + ileDodac;
            return this.iloscNaMagazynie;
        }

        public void usunZMagazynu(int ileZabrac) {
            if (this.iloscNaMagazynie < ileZabrac) {
                System.out.println("Nie ma wystarczajcej ilosci");
            } else {
                this.iloscNaMagazynie = this.iloscNaMagazynie - ileZabrac;
            }
        }

        public int getIloscNaMagazynie() {
            return iloscNaMagazynie;
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
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Produkt produkt = (Produkt) obj;
            return this.nazwa.equals(produkt.nazwa);
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

        void zwrocProdukt(Produkt produkt, int ilosc, double pieniadze, KoszykZakupowy koszyk) {
            produkt.dodajDoMagazynu(ilosc);
            koszyk.produkty.remove(produkt);
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

        public void zakupy(String nazwaProduktu, int ilosc, KoszykZakupowy koszykKlienta) {
            Produkt produktZakupiany = wyszukajProdukt(nazwaProduktu);
            if (produktZakupiany == null) {
                System.out.println("Produkt o nazwie \"" + nazwaProduktu + "\" nie jest dostępny w sklepie.");
                return;
            }
            if (produktZakupiany.getIloscNaMagazynie() < ilosc) {
                System.out.println("Brak wystarczającej ilości produktu \"" + nazwaProduktu + "\" w sklepie.");
                return;
            }

            produktZakupiany.usunZMagazynu(ilosc);
            koszykKlienta.dodajProdukty(ilosc, produktZakupiany);
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
        Produkt produkt = new Produkt("ksiazka", 22, 5);

        produkt.wyswietlInformacje();
        produkt.usunZMagazynu(3);
        produkt.wyswietlInformacje();
        produkt.usunZMagazynu(3);
        produkt.wyswietlInformacje();
        System.out.println(produkt.dodajDoMagazynu(10));
        produkt.wyswietlInformacje();

        System.out.println("ZADANIE 2");
        Produkt notes = new Produkt("notes", 10, 5);
        Produkt dlugopis = new Produkt("dlugopis", 5, 5);
        Produkt olowek = new Produkt("olowek", 1, 5);
        KoszykZakupowy koszykZakupowy = new KoszykZakupowy();

        koszykZakupowy.wyswietlZawartoscKoszyka();

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
        papierniczy.zakupy("notes", 1, koszykZakupowy1);
        koszykZakupowy1.wyswietlZawartoscKoszyka();


    }
}