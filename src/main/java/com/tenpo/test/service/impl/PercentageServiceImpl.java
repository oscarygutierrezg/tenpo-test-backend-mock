package com.tenpo.test.service.impl;

import com.tenpo.test.dto.PercentageDto;
import com.tenpo.test.service.PercentageService;
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
