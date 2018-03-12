package com.iflytek.bean;

/**
 * 封装bean的参数
 */
public class PropertyValue implements Comparable<PropertyValue>{
    private String key;
    private Object value;

    public PropertyValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public int compareTo(PropertyValue o) {
        return this.key.compareTo(o.key);
    }
}
