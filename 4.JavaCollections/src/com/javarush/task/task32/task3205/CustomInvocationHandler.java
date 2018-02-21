package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods methods;

    public CustomInvocationHandler(SomeInterfaceWithMethods methods) {
        this.methods = methods;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.printf("%s in%n",method.getName());
        Object result = method.invoke(methods, objects);
        System.out.printf("%s out%n",method.getName());

        return result;
    }
}
