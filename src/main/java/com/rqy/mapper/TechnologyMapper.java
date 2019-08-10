package com.rqy.mapper;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String ids);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByIdLike(String id);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> selectByNameLike(String name);
}