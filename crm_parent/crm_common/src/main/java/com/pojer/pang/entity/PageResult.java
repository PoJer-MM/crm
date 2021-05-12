package com.pojer.pang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/05/12/下午 8:02
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    private Long total;
    private List<T> rows;

}
