/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.inicio;

import com.sigemp.gestion.shared.entity.GsyProv;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author cristian
 */
public class TestMarshall {

////    public static void main(String[] args) {
////
////        try {
////            new TestMarshall().test();
////        } catch (JAXBException ex) {
////            Logger.getLogger(TestMarshall.class.getName()).log(Level.SEVERE, null, ex);
////        }
////    }
////
////    public void test() throws JAXBException {
////        List<GsyProv> lisCus = TestRest.Cuentas();
////
////        for (GsyProv cus : lisCus) {
////            test(cus);
////        }
////
////    }
////
////    public void test(GsyProv customer) throws JAXBException {
////
////        StringWriter sw = new StringWriter();
////
////        JAXBContext jaxbContext = JAXBContext.newInstance(GsyProv.class);
////
////        System.out.println("Implementacion: " + jaxbContext.getClass());
////        System.out.println("Implementacion: " + jaxbContext.getClass());
////        System.out.println("Implementacion: " + jaxbContext.getClass());
////
////        Marshaller marshaller = jaxbContext.createMarshaller();
////        marshaller.marshal(customer, sw);
////        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
////        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
////
////        System.out.println(sw.toString());
////
////    }

}
