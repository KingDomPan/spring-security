package com.gemini.support;

import java.util.List;

/**
 * 数据集分页容器
 * @author KingDom
 * @param <E>
 */
public class Container<E> {

    private int totalPages;
    private List<E> dataContainer;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<E> getDataContainer() {
        return dataContainer;
    }

    public void setDataContainer(List<E> dataContainer) {
        this.dataContainer = dataContainer;
    }

}
