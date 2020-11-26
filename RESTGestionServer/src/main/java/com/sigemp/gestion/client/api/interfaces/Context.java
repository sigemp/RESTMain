/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.interfaces;

import com.sigemp.gestion.client.api.SGErrorDrive;
import com.sigemp.gestion.client.api.SGMainScreen;
import com.sigemp.gestion.client.api.SGSecurity;

/**
 *
 * @author sigem
 */
public interface Context {

    /**
     * Manejo de Actividaes
     *
     * @return
     */
    public SGMainScreen getScreenDrive();

    /**
     * Manejo de Errores
     *
     * @return
     */
    public SGErrorDrive getErrorDrive();

    /**
     * Gestion de Seguridad
     *
     * @return
     */
    public SGSecurity getSecurity();

}
