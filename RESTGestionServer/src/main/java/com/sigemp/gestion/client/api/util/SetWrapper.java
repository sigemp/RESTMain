/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.util;

import com.google.gwt.view.client.MultiSelectionModel;
import java.util.Set;

/**
 * Envoltorio para buscar en un MultiSelectionModel
 * @author sigem
 * @param <T>
 */
public class SetWrapper<T>  {

    private final Set<T> set;

    
    public SetWrapper(MultiSelectionModel<T> ms) {
        this.set = ms.getSelectedSet();
    }
    
    public SetWrapper(Set<T> set) {
        this.set = set;
    }

    // ... implement all methods from Set and delegate to the internal Set
    public int getIndex(T entry) {
        int result = 0;
        for (T value : set) {
            if (entry.equals(value)) {
                return result;
            }
            result++;
        }
        return -1;
    }
    
    public T get(int index) {
        
        // si se pide un registro que no exite 
        if (set.isEmpty() && index > set.size()) {
            return null;
        }
        
        // Busco el registro y lo retorno
        int idx = 0;
        for (T value : set) {
            if (idx == index) {
                return value;
            }
        }
        return null;
    }
    
    public Set getSet() {
        return set;
    }

}
