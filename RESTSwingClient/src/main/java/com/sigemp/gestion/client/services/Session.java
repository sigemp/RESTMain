/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.gestion.client.services.SessionListener.STATUS;
import java.util.ArrayList;

/**
 *
 * @author sigem
 */
public class Session {

    private static Session session;
    private STATUS status = STATUS.DISCONNECTED;


    String idSesion = "";

    ArrayList<SessionListener> listener = new ArrayList<>();

    public static Session getInstance() {
        if (session == null) {
            session = new Session();
        }
        return session;
    }

    private Session() {
    }

    /**
     * Chequea y conecta
     * 
     * Falta hacer este codigo, tiene recibir el hash para auntenticar las solicitudes
     *
     * @param user
     * @param password
     * @return
     */
    public boolean connect(String user, String password) {
        status = STATUS.CONNECTED;
        fireConnectionStatus();
        return true;

    }

    public boolean disconnect() {
        status = STATUS.DISCONNECTED;
        fireConnectionStatus();
        return true;
    }

    public void addTableButtonListener(SessionListener l) {
        listener.add(l);
    }

    public void removeTableButtonListener(SessionListener l) {
        listener.remove(l);
    }

    protected void fireConnectionStatus() {
        listener.forEach((s) -> {
            s.tableButtonClicked(status);
        });
    }

}
