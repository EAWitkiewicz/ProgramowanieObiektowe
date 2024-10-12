import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class zestaw1_12_10_2024 {
    public static void main(String[] args) {
        System.out.println("zad 1");
        String name="Elżbieta";
        String lastname="Witkiewicz";
        System.out.println(name);
        System.out.println(lastname);
        System.out.println();


        System.out.println("zad 2");
        System.out.println("Name lenght: "+name.length());
        System.out.println("Last name lenght: "+lastname.length());
        System.out.println();

        System.out.println("zad 3");
        String a="Ala";
        String b="ma";
        String c="kota";
        System.out.println(a+b+c);
        System.out.println();

        System.out.println("zad 4");
        System.out.println("                    * ");
        System.out.println("                    * *");
        System.out.println("                    * * *");
        System.out.println("* * * * * * * * * * * * * * ");
        System.out.println("* * * * * * * * * * * * * * * ");
        System.out.println("* * * * * * * * * * * * * * ");
        System.out.println("                    * * *");
        System.out.println("                    * *");
        System.out.println("                    * ");
        System.out.println();

        System.out.println("     *  ");
        System.out.println("    * *  ");
        System.out.println("   * * * ");
        System.out.println("  * * * * ");
        System.out.println(" * * * * *");
        System.out.println("* * * * * *");
        System.out.println(" * * * * *");
        System.out.println("  * * * * ");
        System.out.println("   * * * ");
        System.out.println("    * *  ");
        System.out.println("     *  ");
        System.out.println();

        System.out.println("zad 5");
        String sentence="Ala ma kota";
        System.out.println(sentence.replace("a","e"));
        System.out.println();

        System.out.println("zad 6");
        System.out.println(sentence.toUpperCase());   // Outputs "HELLO WORLD"
        System.out.println(sentence.toLowerCase());
        System.out.println();

        System.out.println("zad 7");
        System.out.println((int)'A');
        System.out.println((int)'!');
        System.out.println((int)'@');
        System.out.println((int)'>');
        System.out.println((int)'~');
        System.out.println((int)'\n');
        System.out.println((int)'\b');
        System.out.println();


        System.out.println("zad 8");
        System.out.println("Zakres wielkich liter w ascii jest od "+(int)'A'+" do "+(int)'Z' );
        System.out.println("Zakres malych liter w ascii jest od "+(int)'a'+" do "+(int)'z' );
        System.out.println("Zakres cyfr w asci jest od "+(int)'0'+" do "+(int)'9' );
        System.out.println();


        System.out.println("zad 9");
        String text="Grzesiek nie wiedział dlaczego %s jest tak drapieżnym %s mimo, że jego %s na to nie wykazuje";
        String result=String.format(text,"szop","zwierzeciem","aparycja");
        System.out.println(result);
        System.out.println();


        System.out.println("zad 10");
        String text2="%s to najlepsza ksiązka napisana przez %s";
        String result2=String.format(text2,"Zatracenie","Osamu Dazai");
        System.out.println(result2);
        System.out.println();


        System.out.println("zad 11");
        String word="wodrze";
        word.repeat(5);
        System.out.println(word.repeat(5));

        System.out.println("zad 12");
        DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Dzisiaj jest "+LocalDate.now()+" godzina "+ (LocalTime.now()).format(myFormat));
        System.out.println();


        System.out.println("zad 13");
        System.out.println((char)54);
        System.out.println((char)103);
        System.out.println((char)241);
        System.out.println((char)67);
        System.out.println((char)9999);
        System.out.println((char)"Elzbiata".length());
        System.out.println((char)"Witkiewicz".length());
        System.out.println((char)175226);

    }
    }
