import java.util.HashMap;
import java.util.Map;

public class AbstractBeanFactory {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取bean
     * @param name bean name
     * @return
     */
    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        return null == beanDefinition ? null : beanDefinition.getBean();
    }

    /**
     *注册一个bean
     * @param name bean的name
     * @param object bean
     */
    public void registerBean(String name, Object object) {
        name = null == name ? object.getClass().getName() : name;
        beanDefinitionMap.put(name, new BeanDefinition(object));
    }
}
