package com.iflytek.beanfactory;

import com.iflytek.BeanDefinition;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition)  {
        if(null!=beanDefinition.getBeanClass()){
            try {
                return beanDefinition.getBeanClass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
