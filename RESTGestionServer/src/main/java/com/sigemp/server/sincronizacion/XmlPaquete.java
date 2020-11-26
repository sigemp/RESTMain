/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.sincronizacion;

import com.sigemp.server.constantes.TipoPaquete;
import java.io.File;
import javax.xml.bind.JAXBException;

/**
 *
 * @author cristian
 */
public class XmlPaquete {

    // Path donde se almacenan los archivos generados y recibidos
    private String pathFiles;
    // Sucursal en la que esta funcionando el sistema
    private int sucActual;
    // Url para el envio y descarga de archivos
    private String restURL;
    // Sucursal que es la servidora
    private int sucServer;

    /**
     * Genera el paqeute y actualiza la tabla de de punteros de paquetes no debe
     * ser igual a la sucursal actual
     *
     * @param tipo
     * @param sucDestino
     */
    public void generarPaquete(TipoPaquete tipo, int sucDestino) {

    }

    /**
     * Asiente los paquetes del tipo y de la sucursal especificada no debe ser
     * igual a la sucursal actual
     *
     * @param tipo
     * @param sucOrigen
     */
    public void asenarPaquete(TipoPaquete tipo, int sucOrigen) {

    }

    /**
     * Se conecta con el servidor por medio del servicio rest y descarga los
     * paquetes que hay para la sucursal actual
     *
     * @param tipo
     */
    public void recibirPaquetes(TipoPaquete tipo) {
        // tiene en cuenta la sucursal actual y la sucursal server
    }

    /**
     * @return the pathFiles
     */
    public String getPathFiles() {
        return pathFiles;
    }

    /**
     * @param pathFiles the pathFiles to set
     */
    public void setPathFiles(String pathFiles) {
        this.pathFiles = pathFiles;
    }

    /**
     * @return the sucActual
     */
    public int getSucActual() {
        return sucActual;
    }

    /**
     * @param sucActual the sucActual to set
     */
    public void setSucActual(int sucActual) {
        this.sucActual = sucActual;
    }

    /**
     * @return the restURL
     */
    public String getRestURL() {
        return restURL;
    }

    /**
     * @param restURL the restURL to set
     */
    public void setRestURL(String restURL) {
        this.restURL = restURL;
    }

    /**
     * @return the sucServer
     */
    public int getSucServer() {
        return sucServer;
    }

    /**
     * @param sucServer the sucServer to set
     */
    public void setSucServer(int sucServer) {
        this.sucServer = sucServer;
    }

    public void generatePreciosData() throws JAXBException {
       /* comentado para poder ejecutar la aplicacion
        
        
        ControladorStkMar controladorStkMar = DAOFactory.getDaoStkMar();
        ControladorStkDep controladorStkDep = DAOFactory.getDaoStkDep();
        ControladorVtaVen controladorVtaVen = DAOFactory.getDaoVtaVen();
        ControladorVtaVta controladorVtaVta = DAOFactory.getDaoVtaVta();
        ControladorStkArt controladorStkArt = DAOFactory.getDaoStkArt();

        List<StkMar> listMarcas = controladorStkMar.getDtoList();
        List<VtaVen> listVendedores = controladorVtaVen.getDtoList();
        List<StkDep> listRubros = controladorStkDep.getDtoList();
        List<VtaVta> listVentas = controladorVtaVta.getListBy(null, Boolean.TRUE);
        List<StkArt> listArticulo = controladorStkArt.getList();
        List<PrvPrv> listProveedor = DAOFactory.getDaoPrvPrv().getDtoList();
        List<StkDepositos> listDeposito = DAOFactory.getDaoStkDepositos().getDtoList();
        List<GsyUser> listGsyUser = DAOFactory.getDaoGsyUser().getDtoList();

        // Step 2 - Convert the Domain Model to XML
        Map<String, Source> metadata = new HashMap<>();
        URL url = getClass().getResource("/META-INF/eclipselink-oxm.xml");
        metadata.put("com.sigemp.server.gestion.entity", new StreamSource(url.openStream()));

        Map<String, Object> properties = new HashMap<>();

        //
        //JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY se reeplazo por JAXBContextProperties.OXM_METADATA_SOURCE
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, metadata);

        Class[] classes = new Class[10];
        classes[0] = StkMar.class;
        classes[1] = VtaVen.class;
        classes[2] = VtaVta.class;
        classes[3] = StkArt.class;
        classes[4] = StkMar.class;
        classes[5] = StkDep.class;
        classes[6] = PrvPrv.class;
        classes[7] = StkDepositos.class;
        classes[8] = GsyUser.class;
        classes[9] = Wrapper.class;

        JAXBContext jaxbContext = JAXBContext.newInstance(classes, properties);

        // Creacion del marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Archivos
        File fileMarca = getFile(StkMar.class);
        File fileRubro = getFile(StkDep.class);
        File fileArticulo = getFile(StkArt.class);
        File fileVendedor = getFile(VtaVen.class);
        File fileVentas = getFile(VtaVta.class);
        File fileProveedor = getFile(PrvPrv.class);
        File fileDeposito = getFile(StkDepositos.class);
        File fileGsyUser = getFile(GsyUser.class);

        // grabo las listas en los archivos
        JAXBUtil.marshal(marshaller, listMarcas, "record", fileMarca);
        JAXBUtil.marshal(marshaller, listVentas, "record", fileVentas);
        JAXBUtil.marshal(marshaller, listVendedores, "record", fileVendedor);
        JAXBUtil.marshal(marshaller, listArticulo, "record", fileArticulo);
        JAXBUtil.marshal(marshaller, listRubros, "record", fileRubro);
        JAXBUtil.marshal(marshaller, listProveedor, "record", fileProveedor);
        JAXBUtil.marshal(marshaller, listDeposito, "record", fileDeposito);
        JAXBUtil.marshal(marshaller, listGsyUser, "record", fileGsyUser);
        */
    }

    public File getFile(Class clazz) {
        String className = clazz.getCanonicalName();
        int x = className.lastIndexOf('.');
        x++;
        className = className.substring(x);
        String sfile = pathFiles.concat("/").concat(className + ".xml");
        return new File(sfile);
    }

}
