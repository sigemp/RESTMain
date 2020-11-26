/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto;

import com.sigemp.gestion.shared.entity.GsyUser;

/**
 *
 * @author sigem
 */
public class AuthenticationData {
    private GsyUser user;

    /**
     * @return the user
     */
    public GsyUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(GsyUser user) {
        this.user = user;
    }
}
