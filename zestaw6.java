import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class zestaw6 {
    class KoszykZakupowy {
        HashMap<Produkt, Integer> produkty;

        public KoszykZakupowy() {
            this.produkty = new HashMap<Produkt, Integer>();

        }

        public void dodajProdukty(int ilosc, Produkt produkt) {
            if (produkt.getIloscNaMagazynie() < ilosc) {
                throw new ArithmeticException("maksymalnie mozna dodać " + produkt.getIloscNaMagazynie() + " sztuk");
            } else {
                produkt.usunZMagazynu(ilosc);
                produkty.put(produkt, ilosc);
            }
        }

        public void wyswietlZawartoscKoszyka() {
            if(produkty.isEmpty()){
                System.out.println("koszyk jest pusty");
            }else {
                for (Produkt produkt : produkty.keySet()) {
                    System.out.println(produkt.nazwa + "\nsztuk: " + produkty.get(produkt) + "\ncena 1 sztuki: " + produkt.cena + "\n");
                }
            }
        }

        public double obliczCalkowitaWartosc() {
            double wartoscCalkowita=0; //ilosc produktow+cena prodowktow
            for (Produkt produkt : produkty.keySet()) {
                wartoscCalkowita=wartoscCalkowita+(produkt.getCena()*produkty.get(produkt));
            }
            return wartoscCalkowita;
        }

    }
    class Magazyn {
        Map<String,Integer> produktyIichIlosc=new HashMap<String,Integer>();
    }
    public class Produkt {
        String nazwa;
        double cena;
        int iloscNaMagazynie;

        public Produkt(String nazwa, double cena, int iloscNaMagazynie) {
            this.nazwa = nazwa;
            this.cena = cena;
            this.iloscNaMagazynie = iloscNaMagazynie;
        }

        public void wyswietlInformacje() {
            System.out.println
                    ("Nazwa: " + this.nazwa + "\n"
                            + "Cena: " + this.cena + "\n" + "Ilość na magazynie: " + this.iloscNaMagazynie+"\n"
                    );
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
    }
    class Zamowienie {
        KoszykZakupowy koszyk;

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
            switch (status) {
                case przekazane_do_realizacji:
                    return this.statusZamowienia= Status.przekazane_do_realizacji;
                case w_realizacji:
                    return this.statusZamowienia= Status.w_realizacji;
                case gotowe_do_wysylki:
                    return this.statusZamowienia= Status.wyslane;
                case wydane_do_doreczenia:
                    return this.statusZamowienia= Status.wydane_do_doreczenia;
                case doreczone:
                    return this.statusZamowienia= Status.doreczone;
                case odebrane:
                    return this.statusZamowienia= Status.odebrane;
                default:
                    throw new AssertionError();
            }

        }
        public void wyswietlZamowienie(){
            koszyk.wyswietlZawartoscKoszyka();
            System.out.println(statusZamowienia);
        }
    }
    class Klient{
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

        public void wyswietlHistorieZamowien(){
            if(listaZamowien.isEmpty()){
                System.out.println("Brak zamowien do wyswitlenia");
            }else{
                System.out.println("Lista Zamowien");
                for (Zamowienie i : listaZamowien) {
                    i.wyswietlZamowienie();
                }
            }
        }

        public double obliczLacznyKosztZamowien(){
            double lacznyKosztZamowien = 0;

            for (Zamowienie i : listaZamowien) {
                lacznyKosztZamowien+=i.koszyk.obliczCalkowitaWartosc();
            }
            return lacznyKosztZamowien;
        }
    }
    class Sklep{
        ArrayList<Produkt>produkty;

        Sklep(){
            this.produkty=new ArrayList<Produkt>();
        }

        public ArrayList<Produkt> dodajProdukt(Produkt produkt){
            if(produkt==null){
                this.produkty.add(produkt);
                return this.produkty;
            }else{
                throw new AssertionError();
            }
        }

        public void wyswietlOferty(){
            for (Produkt i : produkty) {
                i.wyswietlInformacje();
            }
        }

        public Produkt wyszukajProdukt(String nazwaSzukanegoProduktu){
            Produkt szukanyProdukt=null;
            for (Produkt i : produkty) {
                if(nazwaSzukanegoProduktu==i.nazwa){
                    szukanyProdukt=i;
                }
            }
            return szukanyProdukt;
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

        koszykZakupowy.dodajProdukty(2,notes);
        koszykZakupowy.dodajProdukty(2,dlugopis);
        koszykZakupowy.dodajProdukty(2,olowek);

        koszykZakupowy.wyswietlZawartoscKoszyka();

        System.out.println("koszt całkowity:"+koszykZakupowy.obliczCalkowitaWartosc());
        System.out.println("ZADANIE 3");

        Zamowienie zamowienie1=new Zamowienie(koszykZakupowy, Zamowienie.Status.w_realizacji);
        Zamowienie zamowienie2=new Zamowienie(koszykZakupowy, Zamowienie.Status.w_realizacji);
        zamowienie1.ustawStatusZamowienia(Zamowienie.Status.doreczone);
        zamowienie1.wyswietlZamowienie();

        System.out.println("ZADANIE 4");
        Klient jest_taki_klient=new Klient("Żbik","Sewerynowski");
        jest_taki_klient.wyswietlHistorieZamowien();
        jest_taki_klient.dodajZmowienie(zamowienie1);
        jest_taki_klient.dodajZmowienie(zamowienie2);

        jest_taki_klient.wyswietlHistorieZamowien();

        System.out.println(jest_taki_klient.obliczLacznyKosztZamowien());
    }
}