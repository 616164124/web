package com.mikael.web.service.Imp;

import com.mikael.web.bo.Result;
import com.mikael.web.service.Test01Service;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("Test01ServiceImp")
public class Test01ServiceImp implements Test01Service {
    @Override
    public String test01() {
        return "jkfoipw";
    }

    @Override
    public Result test02() {
        return null;
    }
}
