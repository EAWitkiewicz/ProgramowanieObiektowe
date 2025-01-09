import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zestaw8 {

    //zadanie 1
    interface KoszykZakupowy{
        void setKoszyk(HashMap<zestaw6.Produkt, Integer> koszyk);
        HashMap<zestaw6.Produkt, Integer> getKoszyk();
        void dodajProdukty(int ilosc, zestaw6.Produkt produkt, zestaw7.Magazyn magazyn);
        String toString();
        double obliczCalkowitaWartosc();
    };
    interface Produkt{
        String getNazwa();
        void setNazwa(String nazwa);
        double getCena();
        void setCena(double cena);
        void wyswietlInformacje();
        String toString();
        boolean equals(Object obj);
        int hashCode();
    };
    interface Zamowienie{
        zestaw6.KoszykZakupowy getKoszyk();
        void setKoszyk(zestaw6.KoszykZakupowy koszyk);
        zestaw6.Platnosc getPlatnosc();
        void setPlatnosc(zestaw6.Platnosc platnosc);
        zestaw6.Zamowienie.Status getStatusZamowienia();
        void setStatusZamowienia(zestaw6.Zamowienie.Status status);
        String toString();
        void finalizujZamowienie(zestaw6.Platnosc platnosc);
        void zwrocProdukt(zestaw6.Produkt produkt, int ilosc, double pieniadze, zestaw6.KoszykZakupowy koszyk, zestaw7.Magazyn magazyn);
    };
    interface Klient{
        String getImie();
        void setImie(String imie);
        String getNazwisko();
        void setNazwisko(String nazwisko);
        ArrayList<zestaw6.Zamowienie> getListaZamowien();
        void setListaZamowien(ArrayList<zestaw6.Zamowienie> listaZamowien);
        zestaw7.Adres getAdres();
        void setAdres(zestaw7.Adres adres);
        List<zestaw6.Zamowienie> dodajZmowienie(zestaw6.Zamowienie zamowienie);
        String toString();
        boolean equals(Object obj);
        int hashCode();
        double obliczLacznyKosztZamowien();
    };
    interface Sklep{
        String getNazwaSklepu();
        void setNazwaSklepu(String nazwaSklepu);
        LocalDate getDataPowstania();
        void setDataPowstania(LocalDate dataPowstania);
        zestaw7.Magazyn getMagazynSklepu();
        void setMagazynSklepu(zestaw7.Magazyn magazynSklepu);
        void dodajProdukt(zestaw6.Produkt produkt, int ilosc);
        String toString();
        zestaw6.Produkt wyszukajProdukt(String nazwaSzukanegoProduktu);
        void zakupy(String nazwaProduktu, int ilosc, zestaw6.KoszykZakupowy koszykKlienta, zestaw7.Magazyn magazyn);
    };
    interface Platnosc{
        double getKwota();
        void setKwota(double kwota);
        zestaw6.Platnosc.Status getStatusPlatnosci();
        void setStatusPlatnosci(zestaw6.Platnosc.Status statusPlatnosci);
        void zaplac();
        int hashCode();
        boolean equals(Object obj);
    };
    interface Magazyn{
        HashMap<zestaw6.Produkt, Integer> getProdukty();
        void setProdukty(HashMap<zestaw6.Produkt, Integer> produkty);
        int getIloscNaMagzynie();
        void setIloscNaMagzyne(int iloscNaMagzyne);
        int getIloscDanegoProduktuNaMagzaynie(zestaw6.Produkt produkt);
        void dodajDoMagazynu(zestaw6.Produkt produkt, int ileDodac);
        void usunZMagazynu(zestaw6.Produkt produkt, int ileZabrac);
        String toString();
    };
    interface Adres{
        String getUlica();
        void setUlica(String lica);
        int getNumerDomu();
        void setNumerDomu(int numerDomu);
        int getNumerMieszkania();
        void setNumerMieszkania(int numerMieszkania);
        String getMiasto();
        void setMiasto(String miasto);
        int getKodPocztowy();
        void setKodPocztowy(int kodPocztowy);
        String toString();
        boolean przed(zestaw7.Adres adres2);
    };

    //zadanie 2
    static class Osoba{
        String imie;
        String nazwisko;
        Osoba(String imie, String nazwisko){
            this.imie = imie;
            this.nazwisko = nazwisko;
        }
    }

    //zadanie 3
    public class KlientFirmowy extends zestaw6.Klient{
        //w poleceniu 3 jest aby te pola byly stalymi ale potem w setcie
        // nie bedzie mozna ich ustawić więc rozumiem, że mamy zmienić aby nie były "final" ?
        String NIP;
        public String getNIP(){
            return NIP;
        }
        public void setNIP(String NIP){
            if(NIP==null || NIP.length()!=10 || !NIP.matches("^[0-9]*$") ){
                throw  new IllegalArgumentException("NIP musi mieć 10 cyfr");
            }else {
            this.NIP=NIP;}
        }

        String REGON;
        public String getREGON(){
            return REGON;
        }
        public void setREGON(String REGON){
            if(REGON==null || (REGON.length()!=9&&REGON.length()!=14) || !REGON.matches("^[0-9]*$") )
            {
                throw new IllegalArgumentException("REGON musi miec 9 lub 14 cyfr");
            }else {
                this.REGON=REGON;
            }
        }
        public KlientFirmowy(String imie, String nazwisko) {
            super(imie, nazwisko);
        }

    }
    public class KlientIndwiudualny extends zestaw6.Klient{
        String PESEL;
        public String getPESEL(){
            return PESEL;
        }
        public void setPESEL(String PESEL){
            if(PESEL==null || PESEL.length()!=11 || !PESEL.matches("^[0-9]*$") ){
                throw  new IllegalArgumentException("NIP musi mieć 10 cyfr");
            }else {
                this.PESEL=PESEL;}
        }

        private KlientIndwiudualny(String imie, String nazwisko)
        {
            super(imie, nazwisko);
        }

    }

    //zadanie 5
    interface IProduktSpozywczy{
        public abstract void smak(String smak);
        public abstract void umyj();
        public abstract void zjedz();
    }
    class Owoc implements IProduktSpozywczy{

        public void smak(String smak) {
            System.out.println("Owoc ma smak :"+smak);
        }

        public void umyj(){
            System.out.println("Owoc został umyty");
        }
        public void zjedz(){
            System.out.println("owoc został zjedzony");
        }

    }
    class Warzywo implements IProduktSpozywczy{
        public void smak(String smak) {
            System.out.println("warzywo ma smak :"+smak);
        }
        public void umyj(){
            System.out.println("Warzywo został umyty");
        }
        public void zjedz(){
            System.out.println("Warzywo został zjedzony");
        }
    }

    //zadanie 6
    class ProduktSpozywczy extends zestaw6.Produkt{
        ProduktSpozywczy(String nazwa,double cena){
            super(nazwa,cena);
        }
    }
    class ProduktPrzemyslowy extends zestaw6.Produkt{
        ProduktPrzemyslowy(String nazwa,double cena){
            super(nazwa,cena);
        }
    }

    //zadanie 7
    abstract class UrzadzenieElektorniczne{
        public abstract void napraw();
        public abstract void uzyj();
        public abstract void wlacz();
        public abstract void wylacz();
    }

    abstract class Ubranie{
        public abstract void wypierz();
        public abstract void zaloz();
        public abstract void wyprasuj();
        public abstract void wyszusz();
        public abstract void zniszcz();
    }

    //zadanie 8

    public static void main(String[] args) {

    }
}
