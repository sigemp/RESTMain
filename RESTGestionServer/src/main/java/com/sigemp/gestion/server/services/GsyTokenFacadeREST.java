/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.entity.GsyToken;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GsyTokenFacadeREST implements Serializable {

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public void createToken(String authToken, String userName,String host,String userAgent) {
        GsyToken token = new GsyToken();
        token.setToken(authToken);
        token.setUserName(userName);
        token.setFechaCreacion(new Date());
        token.setFechaVencimiento(new Date());
        token.setHost(host);
        token.setUserAgent(userAgent);
        em.persist(token);
    }

    public GsyToken buscarToken(String authToken) {
        Query q = em.createQuery("SELECT s FROM GsyToken s WHERE s.fechaEndSession IS NULL AND s.token = :token");
        q.setParameter("token", authToken);
        List<GsyToken> lis = q.getResultList();

        if (lis.isEmpty()) {
            return null;
        }
        return lis.get(0);
    }

    public void logout(String authToken) {
        Query q = em.createQuery("SELECT s FROM GsyToken s WHERE s.token = :token");
        q.setParameter("token", authToken);
        List<GsyToken> lis = q.getResultList();

        if (!lis.isEmpty()) {
            GsyToken e = lis.get(0);
            e.setFechaEndSession(new Date());
            em.merge(e);
        }
    }

}
