/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

/**
 *
 * @author sigem
 */
public interface SessionListener {

    public enum STATUS {
        CONNECTED, DISCONNECTED;
    }

    public void tableButtonClicked(STATUS status);
}
