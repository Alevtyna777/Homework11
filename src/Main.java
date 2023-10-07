public class Main {
    public static void main(String[] args) {
        PetrolStation station = new PetrolStation(100);

        Thread thread1 = new Thread(() -> station.doRefuel(30));
        Thread thread2 = new Thread(() -> station.doRefuel(40));
        Thread thread3 = new Thread(() -> station.doRefuel(25));
        Thread thread4 = new Thread(() -> station.doRefuel(20));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}