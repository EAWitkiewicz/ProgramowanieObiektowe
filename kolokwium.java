public class kolokwium {
    //zad6
    static <T extends Comparable<T>> void sortDescending(T[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i].compareTo(array[i + 1]) == 1) {
                T swap = array[i];
                array[i] = array[i + 1];
                array[i + 1] = swap;
            }
            System.out.println(array[i]);
        }

    }

    public static void main(String[] args) {
        //zad1
        House dom = new House(13, "zolty", 7);
        Building budynek = new Building(13, "zielony");
        System.out.println(dom);
        System.out.println(budynek);

        //zad 2
        Bitmap bitmap = new Bitmap();
        Vector vector = new Vector();
        bitmap.loadFile();
        bitmap.saveFile();
        vector.loadFile();
        vector.saveFile();

        //zad3
        VideoPlayer videoPlayer = new VideoPlayer();
        System.out.println(videoPlayer.getCurrentTrack());
        videoPlayer.play("xyz");
        videoPlayer.pause();


        //zad 6
        //String[] tab={"b","d","c","a","b"};
        //sortDescending(tab);
    }

    //zad3
    interface MediaPlayer {
        void play(String tackName);

        void pause();

        String getCurrentTrack();
    }

    //zad5
    interface Authentication {
        boolean login(String username, String password);

        void logout();

        boolean resetPasswoard(String username, String oldPasswoard, String newPassword);
    }

    //zad1
    public static class Building {
        public int height;
        public String color;

        Building(int height, String color) {
            this.height = height;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Budynek - wysokosci: " + height + " , koloru: " + color;
        }
    }

    public static class House extends Building {
        public int numberOfRooms;

        House(int heignt, String color, int numberOfRooms) {
            super(heignt, color);
            this.numberOfRooms = numberOfRooms;
        }

        @Override
        public String toString() {
            return "Budynek - wysokosci: " + height + " , koloru: " + color + " , ilosc pokoi :" + numberOfRooms;
        }

    }

    //zad2
    abstract public static class ComputerGraphic {
        int width;
        int heigth;
        String fileName;

        abstract void loadFile();

        abstract void saveFile();

    }

    public static class Bitmap extends ComputerGraphic {

        @Override
        void loadFile() {
            System.out.println("wczytano");
        }

        @Override
        void saveFile() {
            System.out.println("Zapisano");
        }
    }

    public static class Vector extends ComputerGraphic {

        @Override
        void loadFile() {
            System.out.println("wczytano");
        }

        @Override
        void saveFile() {
            System.out.println("Zapisano");
        }
    }

    public static class AudioPlayer implements MediaPlayer {
        @Override
        public void play(String trackName) {
            System.out.println("muzyka gra");
        }

        @Override
        public void pause() {
            System.out.println("muzyka została zapuzowana");
        }

        @Override
        public String getCurrentTrack() {
            return "obecny kawałek";
        }
    }

    public static class VideoPlayer implements MediaPlayer {

        @Override
        public void play(String trackName) {
            System.out.println("leci film");
        }

        @Override
        public void pause() {
            System.out.println("film zapauzowany");
        }

        @Override
        public String getCurrentTrack() {
            return "obecny film";
        }
    }

    //zad 4
    public static class Storage<T> {
        T item;

        void store(T item) {
            this.item = item;
        }

        T retrieve() {
            return item;
        }

    }

    public static class UserAuthentication implements Authentication {
        private final String username;
        private final String password;

        UserAuthentication(String username, String passwprd) {
            this.username = username;
            this.password = passwprd;
        }

        @Override
        public boolean login(String username, String password) {
            return this.username == username && this.password == password;
        }

        @Override
        public void logout() {
            System.out.println("wylogowano");
        }

        @Override
        public boolean resetPasswoard(String username, String oldPasswoard, String newPassword) {
            return this.username == username && this.password == password;
        }
    }

    public static class AdminAuthentication implements Authentication {

        @Override
        public boolean login(String username, String password) {
            return false;
        }

        @Override
        public void logout() {

        }

        @Override
        public boolean resetPasswoard(String username, String oldPasswoard, String newPassword) {
            return false;
        }
    }
}