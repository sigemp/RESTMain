/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.interfaces;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Widget;
import com.sigemp.gestion.client.api.Menu;

/**
 * Esta interface es utilizada para envolver una actividad
 *
 * @author Server
 */
public interface PanelActivityInterface {
    
    
    /**
     * Retorna el winget que define esta actividad
     * 
     * @param context
     * @param eventBus
     * @return 
     */
    public void onInitialize(Context context,HandlerManager eventBus);
    
    /**
     * Este es el menu en donde debe estar ubicada esta actividad
     * @return 
     */
    public Menu getOption();

    
    
    /**
     * Si el panel que contiene la actividad es scrollable
     * 
     * 
     * @return 
     */
    public boolean Scrollable();
    
    
    /**
     * El Panel Principal que sera ingresado en 
     * 
     * 
     * 
     * @return 
     */
    public Widget getMainPanel();
    
    /**
     * EL panel ToolBar con botones
     * 
     * 
     * @return 
     */
    public Widget getToolMenu();
    
    public void onReturn(boolean confirm,Object form);
    
    public String getId();
    
}
