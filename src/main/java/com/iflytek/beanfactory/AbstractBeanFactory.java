package com.iflytek.beanfactory;

import com.iflytek.BeanDefinition;
import com.iflytek.util.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取bean
     *
     * @param name bean name
     * @return
     */
    @Override
    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        return null == beanDefinition ? null : beanDefinition.getBean();
    }

    /**
     * 注册bean
     *
     * @param name
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        if (null != beanDefinition) {
            if(null==beanDefinition.getBean()){
                Object o = doCreateBean(beanDefinition);
                beanDefinition.setBean(o);
            }
            if (null == name) {
                name = CommonUtils.getDefaultBeanName(beanDefinition);
            }
            beanDefinitionMap.put(name, beanDefinition);
        }
    }

    /**
     * 初始化bean
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) ;
}
