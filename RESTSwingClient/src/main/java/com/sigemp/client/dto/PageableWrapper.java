/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.client.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Server
 * @param <T>
 */
public class PageableWrapper<T> {
    private long count;
    private int start ;
    private int index;
    private int next;
    private List<T> list = new ArrayList<>();

    /**
     * @return the count
     */
    public long getCount() {
        return count;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the next
     */
    public int getNext() {
        return next;
    }

    /**
     * @param count the count to set
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @param next the next to set
     */
    public void setNext(int next) {
        this.next = next;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }
    
}
