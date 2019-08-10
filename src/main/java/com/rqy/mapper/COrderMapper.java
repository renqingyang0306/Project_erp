package com.rqy.mapper;

import com.rqy.domain.COrder;
import com.rqy.domain.COrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface COrderMapper {
    long countByExample(COrderExample example);

    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    List<COrder> selectByExample(COrderExample example);

    COrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByExample(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    List<COrder> findAllOrderByCustomName(String example);
    List<COrder> findAllOrderByProductName(String s);
}