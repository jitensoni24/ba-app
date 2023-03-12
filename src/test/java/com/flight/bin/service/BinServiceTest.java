package com.flight.bin.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinServiceTest {
    private BinService binService;

    @BeforeEach
    public void init() {
        binService = new BinService();
    }

    @Test
    public void shouldReturnBins() {
        // given - precondition or setup
        // no repo present yet so list.of bins is going to be returned
        List<String> expected = List.of("bin-a", "bin-b");

        // when -  action or the behaviour that we are going test
        // bins method is invoked then list of bins are returned
        List<String> actual = binService.bins();

        // then - verify the output
        // returned list of bins are verified
        Assertions.assertIterableEquals(expected, actual);
    }
}
