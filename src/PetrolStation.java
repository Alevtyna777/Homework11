import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class PetrolStation {
    private volatile int amount;
    private final ReentrantLock lock = new ReentrantLock();

    public PetrolStation(int initialAmount) {
        this.amount = initialAmount;
    }

    public void doRefuel(int requestedAmount) {
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                try {
                    if (amount >= requestedAmount) {
                        Thread.sleep((int) (Math.random() * 8000 + 3000)); // Від 3 до 10 секунд
                        amount -= requestedAmount;
                        System.out.println("Заправлено " + requestedAmount + " літрів пального.");
                    } else {
                        System.out.println("Пального недостатньо для заправки.");
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Не вдалося отримати доступ до заправки.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}