package com.iflytek.beanfactory;

import com.iflytek.BeanDefinition;

public interface BeanFactory {
    /**
     * 获取bean
     *
     * @param name bean的名称
     * @return
     */
    Object getBean(String name);

    /**
     * 注册bean
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
