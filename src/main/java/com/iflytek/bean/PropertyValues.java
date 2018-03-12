package com.iflytek.bean;

import java.util.*;

public class PropertyValues {
    public PropertyValues() {
    }

    private final List<PropertyValue> propertyValues=new ArrayList<>();
    @SuppressWarnings("unchecked")
    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    /**
     * 添加配置
     * @param pv
     */
    public void addPropertyValue(PropertyValue pv){
        Collections.sort(propertyValues);
        int i = Collections.binarySearch(propertyValues, pv);
        if(i<0){
            propertyValues.add(pv);
        }
    }
}
