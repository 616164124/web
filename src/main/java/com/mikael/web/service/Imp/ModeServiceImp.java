package com.mikael.web.service.Imp;

import com.mikael.web.service.ModeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service("ModeServiceImp")
public class ModeServiceImp implements ModeService {
    @Override
    public String test01() {
        log.info("test01");
        return "";
    }
}