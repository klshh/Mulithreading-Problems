import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSimulationExecutorService {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i = 0; i< 10; i++){
            int task = i;
            service.execute(() -> System.out.println("taskId: "+ task));
        }

//        gracefull shutdown
        service.shutdown();
    }
}
