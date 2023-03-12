package com.flight.bin.controller;

import com.flight.bin.service.BinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
public class BinController {

    private BinService binService;

    @Operation(summary = "Creates a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created book"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/bins", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> bins() {
        log.info("bins controller");
        return binService.bins();
    }

}
