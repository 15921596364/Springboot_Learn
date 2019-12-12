package com.jianliang.guo.plus.Enum;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

/**
 *
 * @param <T>
 */
public interface IBaseEnum<T extends Serializable> extends IEnum<T>{

    String getDesc();
}
