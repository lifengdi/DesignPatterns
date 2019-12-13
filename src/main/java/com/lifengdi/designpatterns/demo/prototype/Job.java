package com.lifengdi.designpatterns.demo.prototype;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 李锋镝
 * @date Create at 14:13 2019/12/13
 */
@Data
@Builder
public class Job  implements Cloneable,Serializable {

    private static final long serialVersionUID = -183689694627620812L;

    private String name;

    private String company;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
