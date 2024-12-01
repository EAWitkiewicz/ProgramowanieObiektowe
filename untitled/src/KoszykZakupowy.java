import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KoszykZakupowy {
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
        for (Produkt produkt : produkty.keySet()) {
            System.out.println(produkt.nazwa+"\nsztuk: "+produkty.get(produkt)+"\ncena 1 sztuki: "+produkt.cena+"\n");
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

