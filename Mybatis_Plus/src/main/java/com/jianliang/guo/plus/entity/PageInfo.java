package com.jianliang.guo.plus.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by jianliang.guo@mtime.com on
 *
 * @Description
 */
@Data
@Accessors(chain = true)
public class PageInfo<T> extends Page<T> {

    public PageInfo(long current, long size) {
        super(current, size);
    }
}
