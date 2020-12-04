/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.inicio;

import com.sigemp.gestion.shared.dto.GsyProvDto;
import com.sigemp.gestion.client.services.GsyProvService;
import com.sigemp.gestion.shared.dto.GsyTalonariosDto;
import java.util.ArrayList;

//import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class TestRest {

    public static void main(String[] args) {

        GsyProvService customerService = new GsyProvService();

        try {

            HttpAuthenticationFeature authentication = HttpAuthenticationFeature.basic("ccc", "cc");

            // busco cuentas que existen y las borro
            List<GsyProvDto> listCu = customerService.restList(null, 0, 100).getList();

            System.out.println(Arrays.asList(listCu).toString());

            for (GsyProvDto c : listCu) {
                //customerService.remove(c.getProvId());
            }

            // Creo cuentas
            List<GsyProvDto> lisToCreate = getCuentas();

            for (GsyProvDto c : lisToCreate) {
                customerService.restCreate(c);
            }

            // Listo las cuentas que cree
            listCu = customerService.restList(null, 0, 100).getList();

            System.out.println(Arrays.asList(listCu).toString());

            // cambio los atributos de una cuenta
            GsyProvDto cu = customerService.restFind(1);
            if (cu != null) {
                System.out.println(cu);
                cu.setDes("Rita Paola");
                customerService.restEdit(cu);
            }

            // Listo con la modificacion del nombre
            listCu = customerService.restList(null, 0, 100).getList();

            System.out.println(Arrays.asList(listCu).toString());


        } catch (Exception ex) {
            Logger.getLogger(TestRest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<GsyProvDto> getCuentas() {
////        List<GsyProv> listGsyProv = new ArrayList<>();
////
////        GsyProv customer1 = new GsyProv();
////
////        customer1.setId(1L);
////        customer1.setFirstName("Gomez");
////        customer1.setLastName("Paola Gomezz");
////        
////        listGsyProv.add(customer1);
////        
////        PhoneNumber phone = new PhoneNumber();
////        phone.setId(1);
////        phone.setNum("3834318210");
////        phone.setType("Personal-Celular");
////        phone.setGsyProv(customer1);
////        
////        PhoneNumber phone2 = new PhoneNumber();
////        phone2.setId(2);
////        phone2.setNum("383432939");
////        phone2.setType("Casa");
////        phone2.setGsyProv(customer1);
////        
////        customer1.getPhoneNumbers().add(phone);
////        customer1.getPhoneNumbers().add(phone2);
////
////        //////////////
////        
////        GsyProv customer2 = new GsyProv();
////
////        customer2.setId(2L);
////        customer2.setFirstName("Eguaras Cristian");
////        customer2.setLastName("David");
////        
////        Address address = new Address();
////        address.setCity("Catamarca");
////        address.setGsyProv(customer2);
////        address.setId(1);
////        address.setStreet("San Fernando del Valle de Catamarca");
////        
////        customer2.setAddress(address);
////        
////        listGsyProv.add(customer2);
////        
////        return listGsyProv;
        return new ArrayList<>();
    }

}
