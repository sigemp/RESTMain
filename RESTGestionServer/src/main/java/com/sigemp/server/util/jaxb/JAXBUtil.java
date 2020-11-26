/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.util.jaxb;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author cristian
 */
public class JAXBUtil {

    private static final Logger LOG = Logger.getLogger(JAXBUtil.class.getName());

    /**
     * Wrap List in Wrapper, then leverage JAXBElement to supply root element
     * information.
     *
     * @param marshaller
     * @param list
     * @param name
     * @param f
     * @throws javax.xml.bind.JAXBException
     */
    public static void marshal(Marshaller marshaller, List<?> list, String name, File f)
            throws JAXBException {
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<>(qName, Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, f);
        //marshaller.marshal(jaxbElement, System.out);
    }
    
    /**
     * Wrap List in Wrapper, then leverage JAXBElement to supply root element
     * information.
     *
     * @param clazz
     * @param list
     * @param name
     * @throws javax.xml.bind.JAXBException
     */
    public static void marshal(Class clazz, List<?> list, String name, File f)
            throws JAXBException {
        
        JAXBContext jc = JAXBContext.newInstance(Wrapper.class, clazz);

        // Marshal
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<>(qName, Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, f);
        //marshaller.marshal(jaxbElement, System.out);
    }

    /**
     * Unmarshal XML to Wrapper and return List value.
     *
     * @param <T>
     * @param unmarshaller
     * @param clazz
     * @param file
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public static <T> List<T> unmarshal(Unmarshaller unmarshaller,
            Class<T> clazz, File file) throws JAXBException {
        StreamSource xml = new StreamSource(file);
        Wrapper<T> wrapper = unmarshaller.unmarshal(xml, Wrapper.class).getValue();
        return wrapper.getItems();
    }
}
