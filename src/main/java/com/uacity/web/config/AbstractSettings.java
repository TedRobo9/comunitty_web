package com.uacity.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public abstract class AbstractSettings {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        }catch (Exception e){
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }
}
