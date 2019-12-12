package com.jianliang.guo.plus.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jianliang.guo@mtime.com on
 *
 * @Description
 */
@Setter
@Getter
@ToString
public class CinemaModel {

    @NotNull
    @Getter
    @Setter
    @ToString
    public static class CreateCinema{
        @NotBlank
        @ApiModelProperty(value="影院内码",name="innerCode",example="118")
        private String innerCode;
        @ApiModelProperty(value="影院专制码",name="govCode",example="1111118")
        private String govCode;
        @ApiModelProperty(value="影院名称",name="name",example="测试万达广场店")
        private String name;
        @ApiModelProperty(value="影厅数",name="hallCount",example="20")
        private Integer hallCount;
        @ApiModelProperty(value="座位数",name="seatCount",example="1000")
        private Integer seatCount;
        @ApiModelProperty(value="物业类型",name="propertyType",example="大型")
        private String propertyType;
        @ApiModelProperty(value="区域",name="regionId",example="01")
        private String regionId;
        @ApiModelProperty(value="省份",name="provinceId",example="1")
        private Integer provinceId;
        @ApiModelProperty(value="城市",name="cityId",example="1")
        private Integer cityId;
        @ApiModelProperty(value="开业状态",name="openStatus",example="1")
        private String openStatus;
        @ApiModelProperty(value="营业起始时间",name="businessStartTime",example="")
        private Date businessStartTime;
        @ApiModelProperty(value="营业终止时间",name="businessEndTime",example="")
        private Date businessEndTime;
        @ApiModelProperty(value="DNA标签",name="dnaItems",example="f,g,h")
        private String dnaItems;
        @ApiModelProperty(value="是否删除",name="deleted",example="0")
        private String deleted;
        @ApiModelProperty(value="去年票房总量",name="boxOfficeCount",example="160000000")
        private Double boxOfficeCount;
        @ApiModelProperty(value="操作用户",name="updateUser",example="1")
        private Integer updateUser;
        @ApiModelProperty(value="更新时间",name="updateTime",example="")
        private Date updateTime;
    }

    @Getter
    @Setter
    @ToString
    public static class QueryCinema{

        @ApiModelProperty(value="影院内码",name="innerCode",example="111")
        private String innerCode;
        @ApiModelProperty(value="影院专制码",name="govCode",example="1111111")
        private String govCode;
        @ApiModelProperty(value="影院名称",name="name",example="北京CBD万达影院")
        private String name;
        @ApiModelProperty(value="区域",name="regionId",example="01")
        private String regionId;
        @ApiModelProperty(value="省份",name="provinceId",example="1")
        private Integer provinceId;
        @ApiModelProperty(value="城市",name="cityId",example="1")
        private Integer cityId;
        @ApiModelProperty(value="开业状态",name="openStatus",example="true")
        private String openStatus;
        @ApiModelProperty(value="是否删除",name="deleted",example="0")
        private String deleted;
        @ApiModelProperty(value="去年票房总量",name="boxOfficeCount",example="200000000")
        private Double boxOfficeCount;
        @ApiModelProperty(value="操作用户",name="updateUser",example="1")
        private Integer updateUser;
    }

    @NotNull
    @Getter
    @Setter
    @ToString
    public static class UpdateCinema{
        /**
         * 主键自增
         */
        @NotNull
        private Integer id;
        /**
         * 影院内码
         */
        private String innerCode;
        /**
         * 影院内码
         */
        private String govCode;
        /**
         * 影院名称
         */
        private String name;
        /**
         * 影厅数
         */
        private Integer hallCount;
        /**
         * 座位数
         */
        private Integer seatCount;
        /**
         * 物业类型
         */
        private String propertyType;
        /**
         * 区域
         */
        private String regionId;
        /**
         * 省份
         */
        private Integer provinceId;
        /**
         * 城市
         */
        private Integer cityId;
        /**
         * 开业状态
         */
        private String openStatus;
        /**
         * 营业起始时间
         */
        private Date businessStartTime;
        /**
         * 营业终止时间
         */
        private Date businessEndTime;
        /**
         * DNA标签
         */
        private String dnaItems;
        /**
         * 是否删除
         */
        private String deleted;
        /**
         * 去年票房总量
         */
        private Double boxOfficeCount;
        /**
         * 操作用户
         */
        private Integer updateUser;
        /**
         * 更新时间
         */
        private Date updateTime;
    }
}
