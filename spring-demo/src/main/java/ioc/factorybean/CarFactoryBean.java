package ioc.factorybean;

import ioc.entity.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author CBeann
 * @create 2020-01-30 18:50
 */
@Component
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        System.out.println("CarFactory.BeangetObject()..........");
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
