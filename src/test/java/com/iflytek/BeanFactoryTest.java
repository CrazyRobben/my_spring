package com.iflytek;

import com.iflytek.bean.BeanDefinition;
import com.iflytek.bean.PropertyValue;
import com.iflytek.bean.PropertyValues;
import com.iflytek.beanfactory.AutowireCapableBeanFactory;
import com.iflytek.beanfactory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void beanTest() {
        //创建bean工厂
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        //初始化bean
        String beanName="com.iflytek.HelloServiceImpl";
        BeanDefinition beanDefinition = new BeanDefinition();
        PropertyValue propertyValue = new PropertyValue("name","hufan");
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue);
        beanDefinition.setBeanClassName(beanName);
        beanDefinition.setPropertyValues(propertyValues);

        //注册bean
        beanFactory.registerBeanDefinition("helloServiceImpl",beanDefinition);
        Object object = beanFactory.getBean("helloServiceImpl");
        HelloServiceImpl helloServiceImpl = (HelloServiceImpl) object;
        helloServiceImpl.hello();
        System.out.println(helloServiceImpl);
    }
}
