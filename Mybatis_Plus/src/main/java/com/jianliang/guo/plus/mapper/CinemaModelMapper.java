package com.jianliang.guo.plus.mapper;

import com.jianliang.guo.plus.Enum.PropertyType;
import com.jianliang.guo.plus.entity.Cinema;
import com.jianliang.guo.plus.model.CinemaModel;
import org.springframework.beans.BeanUtils;

/**
 * Created by jianliang.guo@mtime.com on
 *
 * @Description
 */
public class CinemaModelMapper {

    public static Cinema toEntity(CinemaModel.CreateCinema cinemaInfo) {
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaInfo,cinema);
        cinema.setPropertyType(PropertyType.getValue(cinemaInfo.getPropertyType()));
        return cinema;
    }

    public static Cinema toEntity(CinemaModel.UpdateCinema cinemaInfo){
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaInfo,cinema);
        return cinema;
    }

    public static Cinema toEntity(CinemaModel.QueryCinema queryCinema){
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(queryCinema,cinema);
        return cinema;
    }
}
