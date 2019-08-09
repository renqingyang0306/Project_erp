package com.rqy.controller.quality;

import com.rqy.domain.Custom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/8 21:54
 */
@Controller
public class ProductMeasurementController {


    @RequestMapping("measure/find")
    public String findMeasureJsp() {
        return "measurement_list";
    }


}
