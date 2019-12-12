package com.jianliang.guo.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jianliang.guo.plus.dao.CinemaMapper;
import com.jianliang.guo.plus.entity.Cinema;
import com.jianliang.guo.plus.mapper.CinemaModelMapper;
import com.jianliang.guo.plus.model.CinemaModel;
import com.jianliang.guo.plus.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guojianliang
 * @since 2019-12-09
 */
@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CinemaServiceImpl extends ServiceImpl<CinemaMapper, Cinema> implements CinemaService {

    private CinemaMapper cinemaMapper;

    @Override
    public IPage<Cinema> findCinemasPage(Integer current, Integer size, CinemaModel.QueryCinema queryCinema) {
        Page<Cinema> page = (Objects.isNull(current) || Objects.isNull(size)) ? new Page<>() : new Page<>(current,size);
        Cinema cinema = CinemaModelMapper.toEntity(queryCinema);
        return this.page(page, Wrappers.lambdaQuery(cinema));
    }

    @Override
    public Cinema findCinemaById(Integer cinemaId) {
        return this.getOne(Wrappers.<Cinema>lambdaQuery().eq(Objects.nonNull(cinemaId), Cinema::getId, cinemaId));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delById(Integer cinemaId) {
        return this.update(Wrappers.<Cinema>lambdaUpdate().eq(Objects.nonNull(cinemaId), Cinema::getId, cinemaId).set(Cinema::getDeleted, Boolean.TRUE));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean createCinema(Cinema cinema) {
        return this.save(cinema);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateCinema(Cinema cinema) {
        return this.update(cinema,Wrappers.<Cinema>lambdaUpdate().eq(Objects.nonNull(cinema.getId()),Cinema::getId,cinema.getId()));
    }

    @Override
    public List<Cinema> findCinemasByCondition(Integer maxCount, Integer minCount) {
        LambdaQueryWrapper<Cinema> wrapper = Wrappers.<Cinema>lambdaQuery().gt(Cinema::getSeatCount, minCount).le(Cinema::getSeatCount, maxCount);
        List<Cinema> cinemas = cinemaMapper.findCinemasByCondition(wrapper);
        if (CollectionUtils.isEmpty(cinemas)) return Collections.emptyList();
        return cinemas;
    }

    @Override
    public List<Cinema> findCinemasByType(String cinemaType) {
        LambdaQueryWrapper<Cinema> wrapper = Wrappers.<Cinema>lambdaQuery().eq(Cinema::getPropertyType, cinemaType);
        List<Cinema> cinemas = cinemaMapper.findCinemasByType(wrapper);
        if (CollectionUtils.isEmpty(cinemas)) return Collections.emptyList();
        return cinemas;
    }
}
