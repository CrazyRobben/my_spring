package com.iflytek;

import com.iflytek.beanfactory.AutowireCapableBeanFactory;
import com.iflytek.beanfactory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void beanTest() {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        String beanName="com.iflytek.HelloServiceImpl";
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(beanName);
        beanFactory.registerBeanDefinition("helloServiceImpl",beanDefinition);
        Object helloServiceImpl = beanFactory.getBean("helloServiceImpl");
        System.out.println(helloServiceImpl);
    }
}
