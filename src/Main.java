import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {

//        int n = 10;
//        PrintZeroEvenOdd printZeroEvenOdd = new PrintZeroEvenOdd(n);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        IntConsumer printNumber = number -> System.out.println(Thread.currentThread().getName() + " Printed " + number);
//
//        executorService.submit(() -> {
//                Thread.currentThread().setName("Zero-Thread");
//                try {
//                    printZeroEvenOdd.zero(printNumber);
//                }catch (InterruptedException e){
//                    Thread.currentThread().interrupt();
//                }
//            }
//        );
//
//        executorService.submit(() -> {
//                Thread.currentThread().setName("Even-Thread");
//                try {
//                    printZeroEvenOdd.even(printNumber);
//                }catch (InterruptedException e){
//                    Thread.currentThread().interrupt();
//                }
//            }
//        );
//
//        executorService.submit(() -> {
//                Thread.currentThread().setName("Odd-Thread");
//                try {
//                    printZeroEvenOdd.odd(printNumber);
//                }catch (InterruptedException e){
//                    Thread.currentThread().interrupt();
//                }
//            }
//        );
//
//        executorService.shutdown();


//        !!! <----------->          FizzBuzz Problem            <----------->!!!
        int n = 20;
        FizzBuzzProblem fizzBuzz = new FizzBuzzProblem(n);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> {
            try {
                fizzBuzz.fizz(() -> {
                    System.out.println("Fizz (" + Thread.currentThread().getName() + ") ");
                });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.submit(() -> {
            try {
                fizzBuzz.buzz(() -> {
                    System.out.println("Buzz (" + Thread.currentThread().getName() + ") ");
                });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.submit(() -> {
            try {
                fizzBuzz.fizzBuzz(() -> {
                    System.out.println("FizzBuzz (" + Thread.currentThread().getName() + ") ");
                });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.submit(() -> {
            try {
                fizzBuzz.number(num -> {
                    System.out.println(num + " (" + Thread.currentThread().getName() + ") ");
                });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.shutdown();
    }
}