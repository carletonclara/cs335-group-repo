/**
 * @ author Amran Hassan
 */

public class ProducerReadingMain {
        public static void main(String[] args) throws InterruptedException {
            MultithreadingProducer p1 = new MultithreadingProducer(1);
            MultithreadingProducer p2 = new MultithreadingProducer(2);
            MultithreadingProducer p3 = new MultithreadingProducer(3);
            MultithreadingProducer p4 = new MultithreadingProducer(4);
            MultithreadingProducer p5 = new MultithreadingProducer(5);
            MultithreadingProducer p6 = new MultithreadingProducer(6);
            MultithreadingProducer p7 = new MultithreadingProducer(7);
            MultithreadingProducer p8 = new MultithreadingProducer(8);
            MultithreadingProducer p9 = new MultithreadingProducer(9);
            MultithreadingProducer p10 = new MultithreadingProducer(10);
            p1.start();
            p1.sleep(1000);

        }
}


