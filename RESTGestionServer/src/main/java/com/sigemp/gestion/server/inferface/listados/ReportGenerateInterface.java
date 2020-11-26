/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.inferface.listados;

import com.sigemp.gestion.client.exception.SgException;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author sigem
 * @param <T>
 */
public interface ReportGenerateInterface<T> {
    
    public void setParameters(Map<String,String> map,EntityManager em);
    /**
     * Retorna el nombre del archivo que se genero
     * 
     * 
     * @return 
     * @throws com.sigemp.gestion.client.exception.SgException 
     */
    public String getResultFilePath() throws SgException;
    
    /**
     * retorna el listado con los datos
     * 
     * 
     * @return 
     */
    public List<T> getResultList();
    
}
