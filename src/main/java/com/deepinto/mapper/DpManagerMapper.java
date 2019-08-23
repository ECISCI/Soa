package com.deepinto.mapper;

import com.deepinto.pojo.DpManager;
import com.deepinto.pojo.DpManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DpManagerMapper {
    int countByExample(DpManagerExample example);

    int deleteByExample(DpManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DpManager record);

    int insertSelective(DpManager record);

    List<DpManager> selectByExample(DpManagerExample example);

    DpManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DpManager record, @Param("example") DpManagerExample example);

    int updateByExample(@Param("record") DpManager record, @Param("example") DpManagerExample example);

    int updateByPrimaryKeySelective(DpManager record);

    int updateByPrimaryKey(DpManager record);
}