/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.interfaces;

import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;

/**
 *
 * @author sigem
 */
public interface ReportInterface {

    public Widget getForm();

    /**
     * Obtiene el formulario para introducir los parametros
     *
     * @return
     */
    public HashMap<String, Object> getParameters();

    /**
     * Resetea los parametros del reporte
     *
     */
    public void clearParameters();

    /**
     * Path del reporte
     *
     * @return
     */
    public String getPath();
    
    
    /**
     * Es llamado para ejecutar el reporte
     * 
     * @param map
     * @return 
     */
    public String serviceRest(HashMap<String,Object> map);
        
}
