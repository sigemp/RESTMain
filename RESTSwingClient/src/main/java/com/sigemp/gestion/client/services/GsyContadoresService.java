/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.entity.GsyContadores;
import java.util.List;

/**
 *
 * @author sigem
 */
public class GsyContadoresService {

    public GsyContadores findById(Integer conId) throws Exception {
        throw new SgException("no implementado");
    }

    public List<GsyContadores> getContadoresByPtoVtaId(Integer talId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public GsyContadores getDtoNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(GsyContadores con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
