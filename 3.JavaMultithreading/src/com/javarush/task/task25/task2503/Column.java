package com.javarush.task.task25.task2503;

import java.util.*;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new ArrayList<>();
        Column[] columnss = Column.values();

        TreeMap<Integer,Column> mapOrder = new TreeMap<>();
        for (int i = 0; i < realOrder.length ; i++) {
            mapOrder.put(realOrder[i],columnss[i]);
        }
        for (Map.Entry<Integer, Column> maps: mapOrder.entrySet()){
            if(maps.getKey()!=-1){
                result.add(maps.getValue());
            }
        }

        return result;
    }


    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public boolean isShown() {
        if (getVisibleColumns().contains(this)) return true;
        else return false;
    }

    @Override
    public void hide() {
        List<Column> list = getVisibleColumns();
        list.remove(this);
        Column[] columns = new Column[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            columns[i] = list.get(i);
        }

        configureColumns(columns);

    }


}
