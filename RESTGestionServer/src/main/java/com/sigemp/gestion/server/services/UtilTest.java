/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.entity.GsyToken;
import com.sigemp.gestion.shared.entity.GsyUser;
import static com.sigemp.gestion.server.filter.AuthFilter.AUTHORIZATION_HEADER;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import org.postgresql.util.Base64;

/**
 *
 * @author sigem
 */
@Stateless
public class UtilTest {

    @Context
    private transient HttpServletRequest servletRequest;

    @EJB
    private GsyTokenFacadeREST tokenService;

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

//    @HeaderParam(AUTHORIZATION_HEADER)
//    String auth;
    public GsyUser getAuthenticatedUser() {
        int x = 2;
        //Get the authentification passed in HTTP headers parameters
        String auth = servletRequest.getHeader(AUTHORIZATION_HEADER);
        if (auth == null) {
            return null;
        }
        auth = auth.substring("Basic ".length()).trim();

        GsyToken gsyToken = tokenService.buscarToken(auth);
        if (gsyToken != null) {

            GsyUser user = getUserByNick(gsyToken.getUserName());
            return user;

        }
        return null;
    }

    public void validateUser(String user, String password) throws Exception {

        try {
            GsyUser gsyUser = getUserByNick(user);

            if (gsyUser == null) {
                throw new Exception("Usuario No Valido");
            }

            String pwdValidate = getMd5FromPassword(password);
            String pwdStore = gsyUser.getClave();

            if (gsyUser.getClave() == null) {
                throw new Exception("El usuario no tiene Clave asignada");
            }
            
            if (!pwdStore.equals(pwdValidate)) {
                throw new Exception("Clave Invalida");
            } else {
                return;
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(UtilTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        throw new Exception("Error Autenticando");

    }

    /**
     * Retorna la clave que esta almacenada en md5 en formato Base64
     *
     *
     */
    public String getMd5FromPassword(String pwd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        md.update(pwd.getBytes("UTF-8"));
        //md.update(pwd.getBytes(Charset.forName("UTF-8")));

        byte[] clave = md.digest();

        String str = Base64.encodeBytes(clave);

        //System.Text.Encoding.UTF8.GetString(clave);
        return str;
    }

    public GsyUser getUserByNick(String user) {
        Query query = em.createQuery("SELECT p FROM GsyUser p WHERE UPPER(p.nick) = upper(:text)");
        query.setParameter("text", user);
        query.setMaxResults(100);

        List<GsyUser> res = query.getResultList();
        if (res.isEmpty()) {
            return null;
        } else {
            return res.get(0);
        }
    }

}
