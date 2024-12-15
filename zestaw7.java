import java.util.HashMap;
import java.util.Map;

public class zestaw7 {
    static class Magazyn {
        Map<zestaw6.Produkt,Integer> produkty=new HashMap<zestaw6.Produkt,Integer>();
        public int iloscNaMagazynie;
        Magazyn(zestaw6.Produkt Produkt){
            this.produkty.put()
        }
        public int dodajDoMagazynu(zestaw6.Produkt produkt,int ileDodac) {
            this.iloscNaMagazynie = this.iloscNaMagazynie + ileDodac;
            return this.iloscNaMagazynie;
        }
        public void usunZMagazynu(zestaw6.Produkt produkt,int ileZabrac) {
            if (this.iloscNaMagazynie < ileZabrac) {
                System.out.println("Nie ma wystarczajcej ilosci");
            } else {
                this.iloscNaMagazynie = this.iloscNaMagazynie - ileZabrac;
            }
        }
        public int getIloscNaMagazynie() {
            return iloscNaMagazynie;
        }

    }
    public static void main(String[] args) {

    }
}
