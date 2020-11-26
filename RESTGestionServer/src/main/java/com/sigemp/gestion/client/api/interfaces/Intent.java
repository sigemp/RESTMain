/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.interfaces;

import java.util.HashMap;

/**
 *
 * @author cristian
 */
public class Intent {

    HashMap<String, Object> map = new HashMap();

    public Intent(PanelActivityInterface parentActivity,PanelActivityInterface childActivity) {
        
    }
    
    
    
    

    public void putExtra(String key, Object value) {
        map.put(key, value);
    }

    public void getExtra(String key) {
        map.get(key);
    }

}
