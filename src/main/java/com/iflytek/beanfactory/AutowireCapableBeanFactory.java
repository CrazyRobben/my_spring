package com.iflytek.beanfactory;

import com.iflytek.bean.BeanDefinition;
import com.iflytek.bean.PropertyValue;
import com.iflytek.bean.PropertyValues;

import java.lang.reflect.Field;
import java.util.List;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = this.newInstance(beanDefinition);
        this.applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected Object newInstance(BeanDefinition beanDefinition){
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition)  {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        List<PropertyValue> valueList = propertyValues.getPropertyValues();
        for (PropertyValue propertyValue : valueList) {
            try {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getKey());
                declaredField.setAccessible(true);
                declaredField.set(bean,propertyValue.getValue());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
