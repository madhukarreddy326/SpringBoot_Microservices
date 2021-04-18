package com.example.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {

@Test
    public void testMono()
    {
        Mono<?> monoString = Mono.just("RGP")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        monoString.subscribe(System.out::println,e -> System.out.println(e.getMessage()));
    }
    @Test
    public void testFlux(){
        Flux<String> fluxtString = Flux.just("sample", "sample1", "sample2", "sample3", "sample4")
                .concatWithValues("another sample")
                .concatWith(Flux.error(new RuntimeException("Exception occcured in flux")))
                .log();
        fluxtString.subscribe(System.out::println,e -> System.out.println(e.getMessage()));
    }
}

