package com.rqy.service;

import com.rqy.domain.Manufacture;
import com.rqy.domain.ManufactureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 18:05
 */
public interface ManufactureService {
    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> findAllManufacture(int page, int rows);

    List<Manufacture> findAllManufactureByIdOrOrderId(int page, int rows, ManufactureExample manufactureExample);

    List<Manufacture> findAllManufactureByTechnologyName(int page, int rows, String s);
}
