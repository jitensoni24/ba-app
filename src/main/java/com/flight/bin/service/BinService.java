package com.flight.bin.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class BinService {

    @Transactional(readOnly = true)
    public List<String> bins() {
        log.info("service");
        return List.of("bin-a", "bin-b");
    }
}
