/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.entity.controladores;

import java.sql.Connection;
import javax.persistence.EntityManager;


/**
 *
 * @author sigem
 */
public abstract class BaseControladores {

    protected abstract EntityManager getEntityManager();
    
    /**
     * retorna la coneccion
     * hay que cerrar la coneccion
     * 
     * @return 
     */
    protected Connection getConnection() {
        //Connection conn = getEntityManager().unwrap(Session.class).connection();
        return (Connection)this.getEntityManager().unwrap(Connection.class);
        //return conn;
    }
}
