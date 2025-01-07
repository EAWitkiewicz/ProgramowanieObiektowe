import java.util.HashMap;
import java.util.Map;

public class zestaw7 {
    static class Magazyn implements zestaw8.Magazyn {
        //przechowywane produktów i ich ilosci
        protected static HashMap<zestaw6.Produkt, Integer> produkty;

        public HashMap<zestaw6.Produkt, Integer> getProdukty() {
            return produkty;
        }

        public void setProdukty(HashMap<zestaw6.Produkt, Integer> produkty) {
            this.produkty = produkty;
        }

        private int iloscNaMagazynie = 0;

        public int getIloscNaMagzynie() {
            return iloscNaMagazynie;
        }

        public void setIloscNaMagzyne(int iloscNaMagazyne) {
            this.iloscNaMagazynie = iloscNaMagazyne;
        }

        Magazyn() {
            this.produkty = new HashMap<zestaw6.Produkt, Integer>();
        }

        public int getIloscDanegoProduktuNaMagzaynie(zestaw6.Produkt produkt) {
            //pobiera wartosc produktu a jali go nie ma w hmapie to zwraca 0
            return produkty.getOrDefault(produkt, 0);
        }

        public void dodajDoMagazynu(zestaw6.Produkt produkt, int ileDodac) {
            if (produkty.containsKey(produkt)) {
                int obecnaIlosc = produkty.get(produkt);
                produkty.put(produkt, obecnaIlosc + ileDodac);
            } else {
                produkty.put(produkt, ileDodac);
            }
            iloscNaMagazynie += ileDodac;
        }

        public void usunZMagazynu(zestaw6.Produkt produkt, int ileZabrac) {
            if (produkty.containsKey(produkt)) {
                int obecnaIlosc = produkty.get(produkt);
                if (obecnaIlosc >= ileZabrac) {
                    produkty.put(produkt, obecnaIlosc - ileZabrac);
                    iloscNaMagazynie -= ileZabrac;
                    if (produkty.get(produkt) == 0) {
                        produkty.remove(produkt);
                    }
                } else {
                    System.out.println("Nie mozna usuna " + ileZabrac + " sztuk. Na magazynie jest tylko " + obecnaIlosc);
                }
            } else {
                System.out.println("Produkt " + produkt + " nie znajduje się na magazynie.");
            }
        }

        //wyswitalnie asortymentu magazynu
        @Override
        public String toString() {
            String s = "Zawartosć magazynu:\n";
            for (Map.Entry<zestaw6.Produkt, Integer> entry : produkty.entrySet()) {
                s += entry.getKey() + ": " + entry.getValue() + " szt.\n";
            }
            return s;
        }

        public int getIloscNaMagazynie() {
            return iloscNaMagazynie;
        }

    }

    static class Adres implements zestaw8.Adres {
        private String ulica;

        public String getUlica() {
            return ulica;
        }

        public void setUlica(String ulica) {
            if (ulica == null || ulica.trim().isEmpty()) {
                throw new IllegalArgumentException("Ulica nie może być pusta ani null.");
            }
            this.ulica = ulica;
        }

        private int numerDomu;

        public int getNumerDomu() {
            return numerDomu;
        }

        public void setNumerDomu(int numerDomu) {
            if (numerDomu <= 0) {
                throw new IllegalArgumentException("Numer domu musi być większy od zera.");
            }
            this.numerDomu = numerDomu;
        }

        private int numerMieszkania;

        public int getNumerMieszkania() {
            return numerMieszkania;
        }

        public void setNumerMieszkania(int numerMieszkania) {
            if (numerMieszkania <= 0) {
                throw new IllegalArgumentException("Numer mieszkania nie moze byc mniejszy od zera");
            }
            this.numerMieszkania = numerMieszkania;
        }

        private String miasto;

        public String getMiasto() {
            return miasto;
        }

        public void setMiasto(String miasto) {
            if (miasto == null || miasto.trim().isEmpty()) {
                throw new IllegalArgumentException("Miasto nie może być puste ani null.");
            }
            this.miasto = miasto;
        }

        private int kodPocztowy;

        public int getKodPocztowy() {
            return kodPocztowy;
        }

        public void setKodPocztowy(int kodPocztowy) {
            if (kodPocztowy <= 0) {
                throw new IllegalArgumentException("Kod pocztowy musi być większy od zera.");
            }
            this.kodPocztowy = kodPocztowy;
        }

        Adres(String ulica, int numerDomu, String miasto, int kodPocztowy) {
            this.ulica = ulica;
            this.numerDomu = numerDomu;
            this.miasto = miasto;
            this.kodPocztowy = kodPocztowy;
        }

        Adres(String ulica, int numerDomu, int numerMieszkania, String miasto, int kodPocztowy) {
            this.ulica = ulica;
            this.numerDomu = numerDomu;
            this.numerMieszkania = numerMieszkania;
            this.miasto = miasto;
            this.kodPocztowy = kodPocztowy;
        }

        @Override
        public String toString() {
            String s = "Adress:\n" +
                    kodPocztowy + " " + miasto + "\n" +
                    "ul." + ulica + " " + numerDomu;
            if (numerMieszkania != 0) {
                s += "/" + numerMieszkania;
            }
            s += "\n";
            return s;
        }

        public boolean przed(Adres adres2) {
            if (this.kodPocztowy < adres2.kodPocztowy) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

        Adres adres = new Adres("Karwica", 47, "Ruciane-Nida", 12220);
        Adres adres1 = new Adres("Bursztynowa", 30, 1, "Olsztyn", 10457);
        adres.toString();
        adres1.toString();
        System.out.println(adres.przed(adres1));
    }
}
