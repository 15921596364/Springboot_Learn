package com.jianliang.guo.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jianliang.guo.plus.Enum.PropertyType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *  影院实体
 * </p>
 *
 * @author guojianliang
 * @since 2019-12-09
 */
@Data
public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(type = IdType.AUTO)
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
	private PropertyType propertyType;
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

    public void setPropertyType(Integer code){
        this.propertyType = PropertyType.getType(code);
    }
}
