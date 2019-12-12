package com.jianliang.guo.plus.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jianliang.guo.plus.entity.Cinema;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author guojianliang
 * @since 2019-12-09
 */
@Mapper
public interface CinemaMapper extends BaseMapper<Cinema> {

    @Select("select * from cinema ${ew.customSqlSegment}")
    List<Cinema> findCinemasByCondition(@Param(Constants.WRAPPER) Wrapper<Cinema> wrapper);

    List<Cinema> findCinemasByType(@Param(Constants.WRAPPER) Wrapper<Cinema> wrapper);
}