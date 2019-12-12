package com.jianliang.guo.plus.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jianliang.guo.plus.entity.Cinema;
import com.jianliang.guo.plus.mapper.CinemaModelMapper;
import com.jianliang.guo.plus.model.CinemaModel;
import com.jianliang.guo.plus.service.CinemaService;
import com.jianliang.guo.plus.utils.RestResult;
import com.jianliang.guo.plus.utils.RestResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guojianliang
 * @since 2019-12-09
 */
@RestController
@RequestMapping(value = "/cinema", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "影院,CRUD-PAGE 测试示例")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CinemaController {

    private static final Logger logger = LoggerFactory.getLogger(CinemaController.class);
    private CinemaService cinemaService;

    @ApiOperation(value="获取影院信息列表",tags={"查询列表"},notes="分页默认:current:1,size:10")
    @GetMapping("/list")
    public RestResult getCinemas(CinemaModel.QueryCinema queryCinema, Integer current, Integer size){
        IPage<Cinema> cinemaIPage = cinemaService.findCinemasPage(current,size,queryCinema);
        logger.info("find cinema data list size :{}",cinemaIPage.getTotal());
        return RestResultGenerator.getSuccessResult(cinemaIPage);
    }

    @ApiOperation(value="获取影院详情信息",tags={"查询详情"},notes="注意事项:cinemaId必传")
    @GetMapping("/detail")
    public Object getCinema(Integer cinemaId){
        if (Objects.isNull(cinemaId)) return RestResultGenerator.getErrorResult("请求参数为空!");
        Cinema cinema = cinemaService.findCinemaById(cinemaId);
        if (Objects.isNull(cinema)) return RestResultGenerator.getErrorResult("影院不存在!");
        logger.info("find cinema data detail :{}", JSON.toJSONString(cinema));
        return RestResultGenerator.getSuccessResult(cinema);
    }

    @ApiOperation(value="删除影院",tags={"删除影院"},notes="注意事项:cinemaId必传")
    @GetMapping("/delete")
    public Object delCinema(Integer cinemaId){
        if (Objects.isNull(cinemaId)) return RestResultGenerator.getErrorResult("请求参数为空!");
        boolean success = cinemaService.delById(cinemaId);
        logger.info("delete cinema data :{} ",success);
        if (success) return RestResultGenerator.getSuccessResult("删除成功!");
        return RestResultGenerator.getErrorResult("删除失败!");
    }

    @ApiOperation(value="根据影院ID更新影院信息",tags={"更新影院"},notes="注意事项:cinemaId必传")
    @PostMapping("/update")
    public Object updateCinema(@Validated CinemaModel.UpdateCinema cinemaInfo,BindingResult result){
        if (result.hasErrors()) return RestResultGenerator.getErrorResult("请求参数有误!");
        if (Objects.isNull(cinemaInfo) || Objects.isNull(cinemaInfo.getId())) return RestResultGenerator.getErrorResult("请求参数不可为空!");
        Cinema cinema = CinemaModelMapper.toEntity(cinemaInfo);
        boolean success = cinemaService.updateCinema(cinema);
        logger.info("update cinema data :{}",success);
        return success ? RestResultGenerator.getSuccessResult() : RestResultGenerator.getErrorResult("修改失败");
    }

    @ApiOperation(value="创建影院信息",tags={"创建影院"},notes="注意事项:cinemaId必传,innerCode不可为空")
    @PostMapping("/create")
    public Object createCinema(@Validated CinemaModel.CreateCinema cinemaInfo,BindingResult result){
        if (result.hasErrors()) return RestResultGenerator.getErrorResult("请求参数有误");
        if (Objects.isNull(cinemaInfo) || Objects.isNull(cinemaInfo.getInnerCode())) return RestResultGenerator.getErrorResult("请求InnerCode参数不可为空!");
        Cinema cinema = CinemaModelMapper.toEntity(cinemaInfo);
        boolean success = cinemaService.createCinema(cinema);
        logger.info("create cinema data :{}",success);
        return success ? RestResultGenerator.getSuccessResult("添加成功!") : RestResultGenerator.getErrorResult("添加失败!");
    }

    @ApiOperation(value = "根据座位区间查询影院,自定义mapper.java",tags = {"查询影院(座位区间)"},notes = "注意事项:区间参数必传")
    @GetMapping("/findCinemasByCount")
    public RestResult findCinemasByCondition(Integer maxCount,Integer minCount){
        if (Objects.isNull(maxCount) || Objects.isNull(minCount)) return RestResultGenerator.getErrorResult("请求参数不可为空!");
        List<Cinema> cinemaList = cinemaService.findCinemasByCondition(maxCount,minCount);
        logger.info("find cinemas data by condition {} = {} => size:{}",maxCount,minCount,cinemaList.size());
        return RestResultGenerator.getSuccessResult(cinemaList);
    }

    @ApiOperation(value = "根据类型查询影院,自定义mapper.xml文件",tags = {"查询影院(影院类型查询)"},notes = "注意事项:参数必传")
    @GetMapping("/findCinemasByType")
    public RestResult findCienmasByType(String cinemaType){
        if (StringUtils.isEmpty(cinemaType)) return RestResultGenerator.getErrorResult("请求参数不可为空!");
        List<Cinema> cinemas = cinemaService.findCinemasByType(cinemaType);
        logger.info("find cinemas data by type :{} => size:{}",cinemaType,cinemas.size());
        return RestResultGenerator.getSuccessResult(cinemas);
    }
}
