package com.flight.bin.controller;

import com.flight.bin.service.BinService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BinControllerTest {

    @Mock
    private BinService binService;

    @InjectMocks
    private BinController binController;

    @Test
    public void shouldReturnBins() {
        // given - precondition or setup
        List<String> expected = List.of("bin-a", "bin-b");
        when(binService.bins()).thenReturn(expected);

        // when -  action or the behaviour that we are going test
        // bins method is invoked then list of bins are returned
        List<String> actual = binController.bins();

        // then - verify the output
        // returned list of bins are verified
        assertIterableEquals(expected, actual);
    }
}
