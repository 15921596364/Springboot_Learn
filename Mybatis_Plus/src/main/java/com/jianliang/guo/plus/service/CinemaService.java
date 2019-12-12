package com.jianliang.guo.plus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jianliang.guo.plus.entity.Cinema;
import com.jianliang.guo.plus.model.CinemaModel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guojianliang
 * @since 2019-12-09
 */
public interface CinemaService extends IService<Cinema> {

    IPage<Cinema> findCinemasPage(Integer current, Integer size, CinemaModel.QueryCinema queryCinema);

    Cinema findCinemaById(Integer cinemaId);

    boolean delById(Integer cinemaId);

    boolean createCinema(Cinema cinema);

    boolean updateCinema(Cinema cinema);

    List<Cinema> findCinemasByCondition(Integer maxCount, Integer minCount);

    List<Cinema> findCinemasByType(String cinemaType);
}
