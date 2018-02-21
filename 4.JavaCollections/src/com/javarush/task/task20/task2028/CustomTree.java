package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable,Serializable{
    Entry<String> root;
    int size = 0;

    public CustomTree() {
        this.root = new Entry<>("0");
    }

    @Override
    public int size() {
        return size;
    }



    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName){
            this.elementName = elementName;
            availableToAddLeftChildren=true;
            availableToAddRightChildren=true;
        }

        void checkChildren(){
            if (leftChild!=null) availableToAddLeftChildren=false;
            if (rightChild!=null) availableToAddRightChildren=false;
        }

        boolean isAvailableToAddChildren(){
            checkChildren();
            return availableToAddLeftChildren||availableToAddRightChildren;
        }

    }

    @Override
    public boolean add(String s) {
        Entry<String> entryN = new Entry<String>(s);
        int lineNumberElem;

        if (root == null) {
            entryN.lineNumber = 0;
            this.root = entryN;
            size ++;
        }
        else {
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.offer(root);
            while (true){
                if (queue.peek().isAvailableToAddChildren()){
                    lineNumberElem = queue.peek().lineNumber+1;
                    entryN.lineNumber = lineNumberElem;
                    entryN.parent = queue.peek();

                    if (queue.peek().availableToAddLeftChildren){
                       queue.peek().leftChild = entryN;
                       size++;
                       queue.peek().availableToAddLeftChildren=false;
                       return true;
                    }
                    else {
                        queue.peek().rightChild = entryN;
                        size++;
                        queue.peek().availableToAddRightChildren = false;
                        return true;
                    }
                }
                else {
                    queue.offer(queue.peek().leftChild);
                    queue.offer(queue.peek().rightChild);
                }
                queue.poll();
            }

            }
        return true;
    }

    private Entry<String> seekEntry(String seekStr){
        if (root == null) return null;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size()!=0) {
            if (queue.peek().leftChild !=null) {
                if (queue.peek().leftChild.elementName.equals(seekStr)) {
                    return queue.peek().leftChild;
                }
                else queue.offer(queue.peek().leftChild);
            }
            if (queue.peek().rightChild !=null) {

                if (queue.peek().rightChild.elementName.equals(seekStr)) {
                    return queue.peek().rightChild;
                }
                else queue.offer(queue.peek().rightChild);
            }

            queue.poll();
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // Проверяем что исходный элемент является String
        if (!(o instanceof String)) return false;
        if (size == 0) return false;
        String str = (String) o;

        //находим нужный елемент для удаления
        Entry<String> compareEntry= seekEntry(str);
        if (compareEntry == null) return false;

        //Удаляем детей
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(compareEntry);
        while (queue.size()!=0) {

            if ((queue.peek().parent.rightChild != queue.peek()) && (queue.peek().parent.leftChild != queue.peek())){
                queue.poll();
                continue;
            }

            if (queue.peek().leftChild != null) {
                if (queue.peek().leftChild.availableToAddLeftChildren && queue.peek().leftChild.availableToAddRightChildren) {
                    queue.peek().leftChild = null;
                    size--;
                }else queue.offer(queue.peek().leftChild);
            }

            if (queue.peek().rightChild != null) {
                if (queue.peek().rightChild.availableToAddLeftChildren && queue.peek().rightChild.availableToAddRightChildren) {
                    queue.peek().rightChild = null;
                    size--;
                }else queue.offer(queue.peek().rightChild);
            }

            if (queue.peek().rightChild == null && queue.peek().leftChild == null){
                    if (queue.peek().parent.leftChild ==queue.peek()){
                        queue.peek().parent.leftChild = null;
                        size--;
                    }
                    else {
                        queue.peek().parent.rightChild = null;
                        size--;
                    }
            } else queue.offer(queue.peek());
            queue.poll();
        }

        return true;
    }

    public String getParent(String s){
        Entry<String> entry= seekEntry(s);
        return entry.parent.elementName;
    }

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list.size());

        list.remove("1");
        System.out.println(list.size());



    }

    @Override
    public String get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }
    @Override

    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }
    @Override
    public String remove(int index){
        throw new UnsupportedOperationException();
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }
}
