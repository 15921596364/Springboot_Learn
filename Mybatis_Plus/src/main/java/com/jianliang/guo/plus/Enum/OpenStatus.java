package com.jianliang.guo.plus.Enum;

import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Description;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by jianliang.guo@mtime.com on
 *
 * @Description
 */
@Description("影院营业状态")
public enum OpenStatus implements IBaseEnum<Integer>{

    OPEN(1,"开业"),
    CLOSE(2,"关闭");

    OpenStatus(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public Integer getValue() {
        return code;
    }

    public static String getDesc(Integer code) {
        List<PropertyType> types = Arrays.asList(PropertyType.values());
        if (CollectionUtils.isEmpty(types)) return Strings.EMPTY;
        Optional<PropertyType> first = types.stream().filter(type -> type.getCode() == code).findFirst();
        if (first.isPresent()) return first.get().getDesc();
        return Strings.EMPTY;
    }

    public static PropertyType getType(Integer code) {
        List<PropertyType> types = Arrays.asList(PropertyType.values());
        if (CollectionUtils.isEmpty(types)) return null;
        Optional<PropertyType> first = types.stream().filter(type -> type.getCode() == code).findFirst();
        return first.orElse(null);
    }

    public static Integer getValue(String desc){
        List<PropertyType> types = Arrays.asList(PropertyType.values());
        if (CollectionUtils.isEmpty(types)) return null;
        Optional<PropertyType> first = types.stream().filter(type -> type.getDesc().equals(desc)).findFirst();
        if (first.isPresent()) return first.get().getCode();
        return null;
    }

    public static PropertyType getType(String desc){
        List<PropertyType> types = Arrays.asList(PropertyType.values());
        if (CollectionUtils.isEmpty(types)) return null;
        Optional<PropertyType> first = types.stream().filter(type -> type.getDesc().equals(desc)).findFirst();
        return first.orElse(null);
    }
}
