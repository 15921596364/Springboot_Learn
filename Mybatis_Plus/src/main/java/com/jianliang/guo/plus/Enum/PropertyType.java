package com.jianliang.guo.plus.Enum;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Description;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 通用枚举注入演示，注意需要实现 IEnums 也需要扫描枚举包
 * </p>
 *
 * @author hubin
 * @since 2018-08-15
 */
@Getter
@Description("影院业务类型")
@JSONType(serializeEnumAsJavaBean = true)
public enum PropertyType implements IBaseEnum<Integer> {
    A(1, "大型"),
    B(2, "中型"),
    C(3, "小型");

    private final int code;
    private final String desc;

    PropertyType(final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
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
