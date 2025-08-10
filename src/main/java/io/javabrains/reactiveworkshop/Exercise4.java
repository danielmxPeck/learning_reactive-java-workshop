package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()
        // Print the value from intNumberMono when it emits 
        // TODO: Write code here
        ReactiveSources.intNumberMono()
                .subscribe(num -> System.out.println("Value from Mono: " + num),
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Mono completed"));


        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer intValue = ReactiveSources.intNumberMono().block();
        System.out.println("Value from Mono: " + intValue);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
