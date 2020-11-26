/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.entity.service.simples;

import com.sigemp.gestion.server.services.GsyParamsREST;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author sigem
 */
public class NewClass {
    @Test
    public void test() {
        List<String> list = Arrays.asList(new String[] {"sdf","sdsdfas"});
        String tt = GsyParamsREST.ListToSQLString(list);
        System.out.println(tt);
    }
}
