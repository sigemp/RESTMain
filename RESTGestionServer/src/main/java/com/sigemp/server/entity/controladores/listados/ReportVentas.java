/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.entity.controladores.listados;

import com.sigemp.gestion.client.exception.SgException;
import com.sigemp.gestion.server.inferface.listados.ReportGenerateInterface;
import com.sigemp.gestion.server.inferface.listados.ReportGenerateInterfaceImp;
import com.sigemp.gestion.shared.entity.constantes.ConstantesReportes;
import com.sigemp.gestion.shared.entity.constantes.FiltroQuery;
import com.sigemp.gestion.shared.entity.constantes.TypeArchive;
import com.sigemp.gestion.shared.dto.ListadoDeVentasDto;
import com.sigemp.server.constantes.General;
import com.sigemp.server.entity.controladores.ControladorVtaVta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author sigem
 */
public class ReportVentas extends ReportGenerateInterfaceImp implements ReportGenerateInterface<ListadoDeVentasDto> {

    private static final Logger LOG = Logger.getLogger(ReportVentas.class.getName());

    private Map<String, String> map;
    private List<ListadoDeVentasDto> list;
    private EntityManager em;
    private String extension;
    private File file;
    private String nameReport = "listadoDeVentas-";

    @Override
    public void setParameters(Map<String, String> map, EntityManager em) {
        this.map = map;
        this.em = em;
    }

    @Override
    public String getResultFilePath() throws SgException {
        if (list == null) {
            process();

        }
        return file.getName();
    }

    @Override
    public List<ListadoDeVentasDto> getResultList() {
        if (list == null) {
            try {
                process();
            } catch (SgException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
        return list;

    }

    private void process() throws SgException {
        this.list = new ControladorVtaVta(em).getDataVta(map);

        if (list.isEmpty()) {
            throw new SgException("No se generaron registros");
        }

        String type = map.get(FiltroQuery.TYPE.name());
        if (type == null) {
            // lanzo excepcion
        }
        TypeArchive fq = TypeArchive.valueOf(type);

        switch (fq) {
            case EXCEL:
                extension = "xlsx";
                break;
            case CSV:
                extension = "csv";
                break;
            case VISTA_PREVIA:
            case PDF:
                extension = "pdf";
                generarPDF();
                break;
            case SEND_EMAIL:
                extension = "pdf";
                break;
            case SISTEM_PRINT:
                extension = "pdf";
                break;
        }

    }

    private JasperPrint getJasperReport() throws SgException {
        try {
            HashMap<String, Object> hm = new HashMap<>();

            JRDataSource dataSourceCobranza = new JRBeanCollectionDataSource(list);

            hm.put("EMPRESA_NOMBRE", "Nombre EMpresa");
            hm.put("EMPRESA_DATOS1", "Datos");
//            hm.put("EMPRESA_NOMBRE", ParametrosReportes.getEmpresaNombre());
//            hm.put("EMPRESA_DATOS1", ParametrosReportes.getEmpresaDatos());
            InputStream is = getClass().getResourceAsStream(ConstantesReportes.PATH_REPORTE_VENTAS + "vta_ventas.jasper");

            JasperPrint jasperPrint = JasperFillManager.fillReport(is, hm, dataSourceCobranza);

            return jasperPrint;
        } catch (JRException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new SgException("Error Generando Reporte");
        }
    }

    private void generarPDF() throws SgException {
        try {

            generateFileName();

            JasperPrint print = getJasperReport();
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(file));
        } catch (FileNotFoundException | JRException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Se pasa la extension del archivo
     *
     *
     * @param extension
     * @return
     */
    private void generateFileName() {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");

        String fn = sdf.format(new Date());

        String nomArchivo = nameReport + fn;

        file = new File(General.getTempDirectory() + nomArchivo + "." + extension);

    }

}
