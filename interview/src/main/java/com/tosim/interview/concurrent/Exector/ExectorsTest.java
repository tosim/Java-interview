package com.tosim.interview.concurrent.Exector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExectorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            List<Future<String>> rets = executorService.invokeAll(new ArrayList<Callable<String>>(Arrays.asList(new Callable<String>() {
                public String call() throws Exception {
                    Thread.sleep(5000);
                    return "abc";
                }
            })));
            System.out.println("done");
            System.out.println(rets.get(0).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
