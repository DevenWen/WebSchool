package com.cn.qpm.usermanage.dao;

import com.cn.lon.entity.AddandCut;

public interface AddandCutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddandCut record);

    int insertSelective(AddandCut record);

    AddandCut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddandCut record);

    int updateByPrimaryKey(AddandCut record);
}