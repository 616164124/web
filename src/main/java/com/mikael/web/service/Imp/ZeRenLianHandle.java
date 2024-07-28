package com.mikael.web.service.Imp;

import com.mikael.web.service.ZeRenLian;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ZeRenLianHandle {

    @Resource
    private List<ZeRenLian> zeRenLians;

    public void execute(String msg) {
        for (ZeRenLian zeRenLian : zeRenLians) {
            zeRenLian.handle(msg);
        }

    }
}