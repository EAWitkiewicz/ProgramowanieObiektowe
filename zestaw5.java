import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class zestaw5 {
    public static void main(String[] args) {

        System.out.println("Zadanie 1");
        ArrayList<Integer> tablica1=new ArrayList<>();
        tablica1.add(1);
        tablica1.add(2);
        tablica1.add(3);
        tablica1.add(4);

        ArrayList<Integer> tablica2=new ArrayList<>();
        tablica2.add(2137);
        tablica2.add(420);
        tablica2.add(143);
        tablica2.add(69);
        tablica2.add(47);
        tablica2.add(2115);


        System.out.println(append(tablica1, tablica2));
        System.out.println("Zadanie 2");
        merge(tablica1, tablica2);
        System.out.println(mergeSorted(tablica1, tablica2));

        //do tego co na zajeciach
        ArrayList<Integer> tablicaIntow = new ArrayList<Integer>();
        tablicaIntow.add(1);
        tablicaIntow.add(4);
        tablicaIntow.add(5);
        tablicaIntow.add(5);
        tablicaIntow.add(8);
        tablicaIntow.add(7);

        uniqueArrayList(tablicaIntow);
        toArrayList("koteczek");
    }
    public static ArrayList<Integer> append(ArrayList<Integer> tab1, ArrayList<Integer> tab2){
        ArrayList<Integer> tab3 = new ArrayList<>(tab1);
        tab3.addAll(tab2);
         return tab3;
    }

    public static void merge(ArrayList<Integer> tab1, ArrayList<Integer> tab2){
        /*
        ArrayList<Integer> tab3 = new ArrayList<>(Collections.nCopies(tab1.size()+tab2.size(),0));
        int i=0,j=0,k=0;
        System.out.println(tab3);
        for (;i< tab3.size(); i++) {
            if(i%2==0) {
                tab3.set(i, tab2.get(j));
                j++;
                if(j==tab2.size()) break;
            }else{
                tab3.set(i, tab1.get(k));
                k++;
                if(k==tab1.size()) break;
            }
        }

         if(tab1.size()>tab2.size()){
             for(int e=tab1.size()+2;e<tab3.size();e++){
                 tab3.set(e,tab1.get(j));
                 k++;
             }
        }else if(tab1.size()<tab2.size()){
             for(int e=tab2.size()+2;e<tab3.size();e++){
                 tab3.set(e,tab2.get(j));
                 j++;
             }
        }
        System.out.println(tab3);*/

            ArrayList<Integer> tab3 = new ArrayList<>(); // Tworzymy nową listę wynikową
            int i = 0;

            // Dodajemy elementy przemiennie, aż skończy się jedna z list
            while (i < tab1.size() || i < tab2.size()) {
                //ify wykonuja sie oba po kolei a potem tylko ten dla dl tablicy
                if (i < tab1.size()) {
                    tab3.add(tab1.get(i));
                }
                if (i < tab2.size()) {
                    tab3.add(tab2.get(i));
                }
                i++;
            }

            System.out.println(tab3);
    }

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> tab1, ArrayList<Integer> tab2){
        ArrayList<Integer> tab3 = append(tab1, tab2);
        Collections.sort(tab3);
        return tab3;
    }

    //todo dkokonczyc
    public static void toArrayList(String napis){
        ArrayList<Character> tablicacharow=new ArrayList<>();
        for (int i=0;i<napis.length();i++) {
            tablicacharow.add(napis.charAt(i));
        }
        Collections.sort(tablicacharow);

    }
    public static void uniqueArrayList(ArrayList<Integer>tablicaIntow){
        HashSet<Integer> uniaklnyZbior = new HashSet<Integer>(tablicaIntow);
        for (Integer el : uniaklnyZbior) {
            System.out.println(el);
        }
        ArrayList<Integer> listatablicowaUnikalnychIntow=new ArrayList<>(uniaklnyZbior);

        ArrayList<ArrayList> tablicatablic = new ArrayList<>();
        for (int i = 0;i<listatablicowaUnikalnychIntow.size();i++ ) {
            ArrayList<Integer> pary=new ArrayList<>();
            pary.add(listatablicowaUnikalnychIntow.get(i));
            pary.add(0);
            tablicatablic.add(pary);
        }
        for(int i = 0; i < tablicatablic.size(); i++) {
            System.out.print(tablicatablic.get(i));
        }
    }
}
