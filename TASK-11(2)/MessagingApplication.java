import java.util.LinkedList;
import java.util.Queue;

class MessageBuffer {
    private Queue<String> buffer = new LinkedList<>();
    private final int capacity;

    public MessageBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String message) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(message);
        System.out.println("Produced: " + message);
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        String message = buffer.poll();
        System.out.println("Consumed: " + message);
        notifyAll();
        return message;
    }
}

class Producer implements Runnable {
    private MessageBuffer buffer;

    public Producer(MessageBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce("Message " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private MessageBuffer buffer;

    public Consumer(MessageBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MessagingApplication {
    public static void main(String[] args) {
        MessageBuffer buffer = new MessageBuffer(3);
        
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        
        producerThread.start();
        consumerThread.start();
        
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Message exchange complete!");
    }
}
