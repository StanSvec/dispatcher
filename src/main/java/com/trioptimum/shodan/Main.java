package com.trioptimum.shodan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by stan on 12/01/17.
 */
public class Main {

    public static void main(String[] args) {
        new Thread(Main::muckuj).start();
        Runtime.getRuntime().addShutdownHook(new Thread(Main::sleep));
        ExecutorService ex = Executors.newFixedThreadPool(5);
        ex.submit(Main::muckuj);
    }


    private static void muckuj() {
        for (;;) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("jebat");
            }
            System.out.println("matej");
        }
    }

    private static void sleep() {
        System.out.println("executed");
        try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("jebat");
            }

    }
}
