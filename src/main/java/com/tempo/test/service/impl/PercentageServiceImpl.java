package com.tempo.test.service.impl;

import com.tempo.test.dto.PercentageDto;
import com.tempo.test.service.PercentageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class PercentageServiceImpl implements PercentageService {

    @Override
    public PercentageDto getCurrent() {
        return PercentageDto.builder().value(
                generateValue()
        ).build();
    }

    private Double generateValue() {
        return  ThreadLocalRandom.current().nextInt(1, 100)/ 100D;
    }
}
