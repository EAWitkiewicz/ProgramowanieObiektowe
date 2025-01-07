import java.time.LocalDate;
import java.util.*;

public class zestaw6 {
    static class KoszykZakupowy implements zestaw8.KoszykZakupowy {
        //k:produkt v:cena
        private HashMap<Produkt, Integer> koszyk;

        public HashMap<Produkt, Integer> getKoszyk() {
            return koszyk;
        }

        public void setKoszyk(HashMap<Produkt, Integer> koszyk) {
            this.koszyk = koszyk;
        }

        public KoszykZakupowy() {
            this.koszyk = new HashMap<Produkt, Integer>();

        }

        public void dodajProdukty(int ilosc, Produkt produkt, zestaw7.Magazyn magazyn) {
            if (magazyn.getIloscDanegoProduktuNaMagzaynie(produkt) < ilosc) {
                throw new ArithmeticException("maksymalnie mozna dodać " + magazyn.getIloscDanegoProduktuNaMagzaynie(produkt) + " sztuk");
            } else {
                magazyn.usunZMagazynu(produkt, ilosc);
                koszyk.put(produkt, koszyk.getOrDefault(produkt, 0) + ilosc);
            }
        }

        @Override
        public String toString() {
            String s = "";
            if (koszyk.isEmpty()) {
                return "koszyk jest pusty";
            } else {
                for (Produkt produkt : koszyk.keySet()) {
                    s += produkt.nazwa + "; sztuk: " + koszyk.get(produkt) + "; cena 1 sztuki: " + produkt.cena + "\n";
                }
            }
            return s;
        }

        public double obliczCalkowitaWartosc() {
            double wartoscCalkowita = 0; //ilosc produktow+cena prodowktow
            for (Produkt produkt : koszyk.keySet()) {
                wartoscCalkowita = wartoscCalkowita + (produkt.getCena() * koszyk.get(produkt));
            }
            return wartoscCalkowita;
        }

    }

    static class Produkt implements zestaw8.Produkt {
        private String nazwa;

        public String getNazwa() {
            return nazwa;
        }

        public void setNazwa(String nazwa) {
            if (nazwa == null || nazwa.trim().isEmpty()) {
                throw new IllegalArgumentException("Nazwa produktu nie może być pusta ani byc nullem");
            }
            this.nazwa = nazwa;
        }

        private double cena;

        public double getCena() {
            return cena;
        }

        public void setCena(double cena) {
            if (cena < 0) {
                throw new IllegalArgumentException("Cena musi być wieksza od zera");
            }
            this.cena = cena;
        }

        public Produkt(String nazwa, double cena) {//,zestaw7.Magazyn magazyn) {
            this.nazwa = nazwa;
            this.cena = cena;
        }

        public void wyswietlInformacje() {
            System.out.println(toString());
        }

        @Override
        public String toString() {
            return "Nazwa: " + this.nazwa + "\n"
                    + "Cena: " + this.cena + "\n"
                    ;
        }

        @Override
        public boolean equals(Object obj) {
            //sprawdzanie czy oba obiekty sa tym samym bojektem w pamieci
            if (this == obj) return true;
            //jesli tak ,ale obiekt jest nuelem lub klasa jest inna false
            if (obj == null || getClass() != obj.getClass()) return false;
            Produkt produkt = (Produkt) obj; //rzutowanie obiektow ktore sie powiedzie bo wczesniej sprawdzilismy

            return this.nazwa.equals(produkt.nazwa) && Double.compare(cena, produkt.cena) == 0;//sprawdzanie czy nazwa i cena jest taka sama
        }

        @Override
        public int hashCode() {
            return Objects.hash(nazwa, cena);
        }
    }

    static class Zamowienie implements zestaw8.Zamowienie {
        private KoszykZakupowy koszyk;

        public KoszykZakupowy getKoszyk() {
            return koszyk;
        }

        public void setKoszyk(KoszykZakupowy koszyk) {
            this.koszyk = koszyk;
        }

        private Platnosc platnosc;

        public Platnosc getPlatnosc() {
            return platnosc;
        }

        public void setPlatnosc(Platnosc platnosc) {
            this.platnosc = platnosc;
        }

        public enum Status {
            przekazane_do_realizacji,
            w_realizacji,
            gotowe_do_wysylki,
            wyslane,
            wydane_do_doreczenia,
            doreczone,
            odebrane

        }

        public Status getStatusZamowienia() {
            return statusZamowienia;
        }

        public void setStatusZamowienia(Status status) {
            if (status == null) {
                throw new IllegalArgumentException("zly status zamowienia");
            }
            this.statusZamowienia = status;
        }

        private Status statusZamowienia;

        Zamowienie(KoszykZakupowy koszyk, Status status) {
            this.koszyk = koszyk;
            this.statusZamowienia = status;
        }

        @Override
        public String toString() {
            return koszyk.toString() + "\nstatus zamówienia: " + statusZamowienia + "\n ";
        }

        public void finalizujZamowienie(Platnosc platnosc) {
            if (platnosc.statusPlatnosci == Platnosc.Status.oplacane) {
                this.statusZamowienia = Status.gotowe_do_wysylki;
                System.out.println("zamowienie gotowe do wysylki");
            } else {
                System.out.println("zamowienie nei zsoatlo oplacone!");
            }
        }

        public void zwrocProdukt(Produkt produkt, int ilosc, double pieniadze, KoszykZakupowy koszyk, zestaw7.Magazyn magazyn) {
            magazyn.dodajDoMagazynu(produkt, ilosc);
            koszyk.koszyk.remove(produkt);
            //todo pieniadze wracją do kl
        }
    }

    static class Klient extends zestaw8.Osoba implements zestaw8.Klient{

        public String getImie() {
            return super.imie;
        }

        public void setImie(String imie) {
            if (imie == null || imie.trim().isEmpty()) {
                throw new IllegalArgumentException("Imię nie może być puste ani null.");
            }
            super.imie = imie;
        }

        public String getNazwisko() {
            return super.nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            if (nazwisko == null || nazwisko.trim().isEmpty()) {
                throw new IllegalArgumentException("Nazwisko nie może być puste ani null.");
            }
            super.nazwisko = nazwisko;
        }

        private ArrayList<Zamowienie> listaZamowien;

        public ArrayList<Zamowienie> getListaZamowien() {
            return listaZamowien;
        }

        public void setListaZamowien(ArrayList<Zamowienie> listaZamowien) {
            if (listaZamowien == null) {
                throw new IllegalArgumentException("Lista zamówień nie może być null.");
            }
            this.listaZamowien = listaZamowien;
        }

        private zestaw7.Adres adres;

        public zestaw7.Adres getAdres() {
            return adres;
        }

        public void setAdres(zestaw7.Adres adres) {
            if (adres == null) {
                throw new IllegalArgumentException("Adres nie może być null.");
            }
            this.adres = adres;
        }

        public Klient(String imie, String nazwisko) {
            super(imie,nazwisko);
            this.listaZamowien = new ArrayList<Zamowienie>();
        }

        public List<Zamowienie> dodajZmowienie(Zamowienie zamowienie) {
            this.listaZamowien.add(zamowienie);
            return this.listaZamowien;
        }

        @Override
        public String toString() {
            if (listaZamowien.isEmpty()) {
                return "Brak zamowien do wyswitlenia";
            } else {
                String s = "Lista Zamowien\n";
                for (Zamowienie i : listaZamowien) {
                    s += i.toString();
                }
                return s;
            }
        }

        @Override
        public boolean equals(Object obj) {
            // Sprawdzanie, czy oba obiekty to ten sam obiekt w pamięci
            if (this == obj) return true;
            // Sprawdzanie, czy obiekt jest nullem lub czy są różnych klas
            if (obj == null || getClass() != obj.getClass()) return false;

            // Rzutowanie obiektu na klasę Klient
            Klient klient = (Klient) obj;

            // Porównanie imienia, nazwiska i adresu
            return imie.equals(klient.imie) &&
                    nazwisko.equals(klient.nazwisko) &&
                    adres.equals(klient.adres);
        }

        @Override
        public int hashCode() {
            return Objects.hash(imie, nazwisko, adres);
        }

        public double obliczLacznyKosztZamowien() {
            double lacznyKosztZamowien = 0;

            for (Zamowienie i : listaZamowien) {
                lacznyKosztZamowien += i.koszyk.obliczCalkowitaWartosc();
            }
            return lacznyKosztZamowien;
        }
    }

    static class Sklep implements zestaw8.Sklep{
        private String nazwaSklepu;

        public String getNazwaSklepu() {
            return nazwaSklepu;
        }

        public void setNazwaSklepu(String nazwaSklepu) {
            if (nazwaSklepu == null || nazwaSklepu.trim().isEmpty()) {
                throw new IllegalArgumentException("Nazwa sklepu nie może być pusta ani null.");
            }
            this.nazwaSklepu = nazwaSklepu;
        }

        private LocalDate dataPowstania;

        public LocalDate getDataPowstania() {
            return dataPowstania;
        }

        public void setDataPowstania(LocalDate dataPowstania) {
            if (dataPowstania == null || dataPowstania.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Data powstania nie może być z przyszłości ani null.");
            }
            this.dataPowstania = dataPowstania;
        }

        private zestaw7.Magazyn magazynSklepu;

        public zestaw7.Magazyn getMagazynSklepu() {
            return magazynSklepu;
        }

        public void setMagazynSklepu(zestaw7.Magazyn magazynSklepu) {
            if (magazynSklepu == null) {
                throw new IllegalArgumentException("Magazyn sklepu nie może być null.");
            }
            this.magazynSklepu = magazynSklepu;
        }

        Sklep(String nazwaSklepu, LocalDate dataPowstania) {
            LocalDate obecnaData = LocalDate.now();

            if (dataPowstania.isAfter(obecnaData)) {
                throw new IllegalArgumentException("Data nie moze byc z przyszłosci");
            }
            this.nazwaSklepu = nazwaSklepu;
            this.dataPowstania = dataPowstania;
            this.magazynSklepu = new zestaw7.Magazyn();
        }

        public void dodajProdukt(Produkt produkt, int ilosc) {
            if (magazynSklepu.produkty.containsKey(produkt)) {
                throw new IllegalArgumentException("Produkt o tej nazwie już istnieje w sklepie.");
            }
            magazynSklepu.dodajDoMagazynu(produkt, ilosc);
        }

        @Override
        public String toString() {
            return magazynSklepu.toString();
        }

        public Produkt wyszukajProdukt(String nazwaSzukanegoProduktu) {
            //analizuje wszytkie produkty w mapie i sprawdza nazwy
            for (Produkt produktIterowany : magazynSklepu.produkty.keySet()) {
                if (produktIterowany.nazwa.equals(nazwaSzukanegoProduktu)) {
                    return produktIterowany;
                }
            }
            return null;
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
            magazyn.usunZMagazynu(produktZakupiany, ilosc);
            koszykKlienta.dodajProdukty(ilosc, produktZakupiany, magazyn);
        }
    }

    static class Platnosc implements zestaw8.Platnosc {
        private double kwota;

        public double getKwota() {
            return kwota;
        }

        public void setKwota(double kwota) {
            if (kwota <= 0) {
                throw new IllegalArgumentException("Kwota musi być większa od zera.");
            }
            this.kwota = kwota;
        }

        public enum Status {
            do_zaplaty,
            przetwarzanie_platnosci,
            oplacane
        }

        private Status statusPlatnosci;

        public Status getStatusPlatnosci() {
            return statusPlatnosci;
        }

        public void setStatusPlatnosci(Status statusPlatnosci) {
            if (statusPlatnosci == null) {
                throw new IllegalArgumentException("Status płatności nie może być null.");
            }
            this.statusPlatnosci = statusPlatnosci;
        }

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

        @Override
        public int hashCode() {
            return Objects.hash(statusPlatnosci, kwota);
        }

        @Override
        public boolean equals(Object obj) {
            // Sprawdzanie, czy oba obiekty to ten sam obiekt w pamięci
            if (this == obj) return true;
            // Sprawdzanie, czy obiekt jest nullem lub czy są różnych klas
            if (obj == null || getClass() != obj.getClass()) return false;

            // Rzutowanie obiektu na klasę Platnosc
            Platnosc platnosc = (Platnosc) obj;

            // Porównanie kwoty i statusu płatności
            return Double.compare(kwota, platnosc.kwota) == 0 &&
                    statusPlatnosci == platnosc.statusPlatnosci;
        }
    }

    public static void main(String[] args) {
        System.out.println("ZADANIE 1");
        Produkt ksiazki = new Produkt("ksiazka", 22);
        zestaw7.Magazyn magazyn = new zestaw7.Magazyn();
        magazyn.dodajDoMagazynu(ksiazki, 22);


        ksiazki.wyswietlInformacje();
        //zamiast produkt _> magazyn.
        magazyn.usunZMagazynu(ksiazki, 3);
        ksiazki.wyswietlInformacje();
        System.out.println(magazyn.getIloscDanegoProduktuNaMagzaynie(ksiazki));

        magazyn.dodajDoMagazynu(ksiazki, 2);
        ksiazki.wyswietlInformacje();
        System.out.println(magazyn.getIloscDanegoProduktuNaMagzaynie(ksiazki));

        System.out.println("ZADANIE 2");
        //bez ilosci
        Produkt notes = new Produkt("notes", 10);
        Produkt dlugopis = new Produkt("dlugopis", 5);
        Produkt olowek = new Produkt("olowek", 1);
        KoszykZakupowy koszykZakupowy = new KoszykZakupowy();
        zestaw7.Magazyn magazyn2 = new zestaw7.Magazyn();

        magazyn2.dodajDoMagazynu(notes, 10);
        magazyn2.dodajDoMagazynu(dlugopis, 5);
        magazyn2.dodajDoMagazynu(olowek, 1);

        koszykZakupowy.toString();

        koszykZakupowy.dodajProdukty(5, notes, magazyn2);
        koszykZakupowy.dodajProdukty(1, olowek, magazyn2);

        koszykZakupowy.toString();

        System.out.println("koszt całkowity:" + koszykZakupowy.obliczCalkowitaWartosc());
        System.out.println("ZADANIE 3");

        Zamowienie zamowienie1 = new Zamowienie(koszykZakupowy, Zamowienie.Status.w_realizacji);
        Zamowienie zamowienie2 = new Zamowienie(koszykZakupowy, Zamowienie.Status.w_realizacji);
        zamowienie1.setStatusZamowienia(Zamowienie.Status.doreczone);
        zamowienie1.toString();

        System.out.println("ZADANIE 4");
        Klient jest_taki_klient = new Klient("Żbik", "Sewerynowski");
        jest_taki_klient.toString();
        jest_taki_klient.dodajZmowienie(zamowienie1);
        jest_taki_klient.dodajZmowienie(zamowienie2);

        jest_taki_klient.toString();

        System.out.println(jest_taki_klient.obliczLacznyKosztZamowien());

        System.out.println("ZADANIE 5");
        Sklep papierniczy = new Sklep("Artykuły biurowe", LocalDate.of(2001, 12, 3));

        papierniczy.toString();

        papierniczy.dodajProdukt(notes, 5);
        papierniczy.dodajProdukt(dlugopis, 7);

        papierniczy.toString();

        System.out.println(papierniczy.wyszukajProdukt("dlugopis"));

        KoszykZakupowy koszykZakupowy1 = new KoszykZakupowy();
        koszykZakupowy1.toString();
        //dodac pramaetr magazynu
        papierniczy.zakupy("notes", 1, koszykZakupowy1, magazyn2);
        koszykZakupowy1.toString();


    }
}
