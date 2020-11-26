/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.util.jaxb;

/**
 *
 * @author cristian
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAnyElement;

public class Wrapper<T> {

    private static final Logger LOG = Logger.getLogger(Wrapper.class.getName());

    private List<T> items;

    public Wrapper() {
        items = new ArrayList<>();
    }

    public Wrapper(List<T> items) {
        this.items = items;
    }

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return items;
    }

}
