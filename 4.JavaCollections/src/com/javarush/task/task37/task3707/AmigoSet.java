package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable,Cloneable,Set<E> {
    private final static Object PRESENT = new Object();
    private transient HashMap<E,Object> map;


    @Override
    public AmigoSet<E> clone() {
        try {
            AmigoSet<E> cloneSet = new AmigoSet<>();
            cloneSet.map = (HashMap<E,Object> )map.clone();
            return cloneSet;
        } catch (Exception e) {
            throw new InternalError();
        }

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{

        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        int size = (int)(capacity/loadFactor);
        in.defaultReadObject();

        map = new HashMap<>(capacity,loadFactor);
        int sizeMap = in.readInt();
        for (int i = 0; i < sizeMap ; i++) {
            map.put((E)in.readObject(), PRESENT);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        int capacity = (int)HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = (float)HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");

        out.writeInt(capacity);
        out.writeFloat(loadFactor);
        out.defaultWriteObject();
        out.writeInt(size());
        map.keySet().forEach((key) -> {
            try {
                out.writeObject(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        out.flush();

    }

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int)(Math.ceil(collection.size()/.75f));
        this.map = new HashMap<>(capacity<16?16:capacity);
        addAll(collection);
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public boolean add(E e) {
        if (map.containsKey(e)){
            map.put(e,PRESENT);
            return false;
        }
        else {
            map.put(e,PRESENT);
            return true;
        }
    }



    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Spliterator<E>  spliterator() {
        return null;
    }

    @Override
    public Stream<E>  stream() {
        return null;
    }

    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }



    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean isChanged = false;
        for (E obj: collection) {
            if (add(obj)){
                isChanged=true;
            }
        }
        return isChanged;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public void forEach(Consumer consumer) {

    }

    @Override
    public boolean removeIf(Predicate predicate) {
        return false;
    }

    @Override
    public int size() {
        return map.size();
    }
}
