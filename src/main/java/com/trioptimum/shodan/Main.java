package com.trioptimum.shodan;

import java.util.concurrent.TimeUnit;

/**
 * Created by stan on 12/01/17.
 */
public class Main {

    public static void main(String[] args) {
        for (;;) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("jebat");
            }
            System.out.println("matej");
        }
    }
}
