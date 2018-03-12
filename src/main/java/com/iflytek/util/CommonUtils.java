package com.iflytek.util;


public class CommonUtils {
    /**
     * 根据Class获取bean的bame
     * @param clazz
     * @return
     */
    public static String getDefaultBeanName(Class clazz){
        String[] split = clazz.getName().split(".");
        String name=null;
        if(split.length!=0){
            name = split[split.length - 1];
        }
        return name;
    }

    /**
     * 根据对象获取bean的name
     * @param object
     * @return
     */
    public static String getDefaultBeanName(Object object){
        Class<?> aClass = object.getClass();
        return getDefaultBeanName(aClass);
    }
}
