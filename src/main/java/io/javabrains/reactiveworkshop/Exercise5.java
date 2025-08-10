package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
//        ReactiveSources.intNumberMono().subscribe(
//                num -> System.out.println(num),
//                error -> System.out.println("Error: " + error.getMessage()),
//                () -> System.out.println("Mono completed")
//        );


        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}


class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed happened");
        request(1); // Request one item
    }

    public void hookOnNext(T item) {
        System.out.println(item.toString() + " received");
        request(1);
    }
}