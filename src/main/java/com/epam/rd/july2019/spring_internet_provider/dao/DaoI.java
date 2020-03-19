package com.epam.rd.july2019.spring_internet_provider.dao;

import java.util.List;


public interface DaoI<T> {
    List<T> queryElements();
    T findElementName(String nameElement);
    T findElementId(Integer idElement);
    void updateElement(T element);
    void insertElement(T element);
    void deleteElement(Integer idElement);
}
