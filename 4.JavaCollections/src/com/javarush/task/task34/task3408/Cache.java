package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V object = cache.get(key);
        if (object == null){
            Constructor[] constructors = clazz.getConstructors();
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            object = constructor.newInstance(key);
            cache.put(key,object);
        }
        return object;
    }

    public boolean put(V obj) {
        //TODO add your code here
        Method method = null;
        try {
            method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K)method.invoke(obj);
            cache.put(key,obj);
            return true;

        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        }


        return false;
    }

    public int size() {
        return cache.size();
    }
}
