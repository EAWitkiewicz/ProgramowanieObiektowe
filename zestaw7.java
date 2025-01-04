import java.util.HashMap;
import java.util.Map;

public class zestaw7 {
    static class Magazyn {
        //przechowywane produktów i ich ilosci
        Map<zestaw6.Produkt,Integer> produkty;
        public int iloscNaMagazynie=0;

        //poprzedni
//        Magazyn(zestaw6.Produkt produkt,int ilosc){
//            this.produkty.put(produkt, ilosc);
//            this.iloscNaMagazynie=ilosc;

        Magazyn(){
            this.produkty=new HashMap<zestaw6.Produkt,Integer>();
        }

        public int getIloscDanegoProduktuNaMagzaynie(zestaw6.Produkt produkt){
            //pobiera wartosc produktu a jali go nie ma w hmapie to zwraca 0
            return produkty.getOrDefault(produkt,0);
        }
        public void dodajDoMagazynu(zestaw6.Produkt produkt,int ileDodac) {
            if(produkty.containsKey(produkt)){
                int obecnaIlosc=produkty.get(produkt);
                produkty.put(produkt, obecnaIlosc+ileDodac);
            }else {
                produkty.put(produkt, ileDodac);
            }
            iloscNaMagazynie+=ileDodac;
        }
        public void usunZMagazynu(zestaw6.Produkt produkt,int ileZabrac) {
            if (produkty.containsKey(produkt)) {
                int obecnaIlosc=produkty.get(produkt);
                if(obecnaIlosc>=ileZabrac) {
                    produkty.put(produkt, obecnaIlosc - ileZabrac);
                    iloscNaMagazynie -= ileZabrac;
                    if (produkty.get(produkt) == 0) {
                        produkty.remove(produkt);
                    }
                }else {
                    System.out.println("Nie mozna usuna "+ileZabrac+" sztuk. Na magazynie jest tylko "+obecnaIlosc);
                }
            }else {
                System.out.println("Produkt " + produkt + " nie znajduje się na magazynie.");
            }
        }
        //wyswitalnie asortymentu magazynu
        public void wyswitlZawartosc(){
            System.out.println("Zawartosć magazynu:");
            for (Map.Entry<zestaw6.Produkt,Integer> entry : produkty.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue()+" szt.");
            }
        }

        public int getIloscNaMagazynie() {
            return iloscNaMagazynie;
        }

    }
    public static void main(String[] args) {

    }
}
