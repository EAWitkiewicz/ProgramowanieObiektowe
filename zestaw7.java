import java.util.HashMap;
import java.util.Map;

public class zestaw7 {
    static class Magazyn {
        //przechowywane produktów i ich ilosci
        static HashMap<zestaw6.Produkt,Integer> produkty;
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

    static class Adres{
        String ulica;
        int numerDomu;
        int numerMieszkania=0;
        String miasto;
        int kodPocztowy;

        Adres(String ulica,int numerDomu,String miasto,int kodPocztowy){
            this.ulica=ulica;
            this.numerDomu=numerDomu;
            this.miasto=miasto;
            this.kodPocztowy=kodPocztowy;
        }

        Adres(String ulica,int numerDomu,int numerMieszkania,String miasto,int kodPocztowy){
            this.ulica=ulica;
            this.numerDomu=numerDomu;
            this.numerMieszkania=numerMieszkania;
            this.miasto=miasto;
            this.kodPocztowy=kodPocztowy;
        }

        void pokaz(){
            System.out.println("Adress:");
            System.out.println(kodPocztowy+" "+miasto);
            System.out.print("ul."+ulica+" "+numerDomu);
            if(numerMieszkania!=0){
                System.out.print("/"+numerMieszkania);
            }
            System.out.println("\n");
        }

        boolean przed(Adres adres2)
        {
            if(this.kodPocztowy<adres2.kodPocztowy){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {

        Adres adres=new Adres("Karwica",47,"Ruciane-Nida",12220);
        Adres adres1=new Adres("Bursztynowa",30,1,"Olsztyn",10457);
        adres.pokaz();
        adres1.pokaz();
        System.out.println(adres.przed(adres1));
    }
}
