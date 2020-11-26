/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api;

import com.google.gwt.core.shared.GWT;
import com.sigemp.gestion.client.activity.ajustes.ActivityAjustes;
import com.sigemp.gestion.client.activity.ventas.ActivityABMActividad;
import com.sigemp.gestion.client.activity.ventas.ActivityABMConceptosCaja;
import com.sigemp.gestion.client.activity.ventas.ActivityABMMediosCobro;
import com.sigemp.gestion.client.activity.ventas.ActivityABMPersonas;
import com.sigemp.gestion.client.activity.ventas.ActivityCambioClave;
import com.sigemp.gestion.client.activity.ventas.ActivityCobranza;
import com.sigemp.gestion.client.activity.ventas.ActivityComprobanteCaja;
import com.sigemp.gestion.client.activity.ventas.ActivityConsultaAfip;
import com.sigemp.gestion.client.activity.ventas.ActivityConsultaCobranza;
import com.sigemp.gestion.client.activity.ventas.ActivityConsultasVentas;
import com.sigemp.gestion.client.activity.ventas.ActivityDatosSistema;
import com.sigemp.gestion.client.activity.ventas.ActivityEmiteComprobanteVenta;
import com.sigemp.gestion.client.activity.ventas.ActivityListadoCobranza;
import com.sigemp.gestion.client.activity.ventas.ActivityListadoComprobanteCaja;
import com.sigemp.gestion.client.activity.ventas.ActivityListadoVentas;
import com.sigemp.gestion.client.activity.ventas.ActivityPuntosVentas;
import com.sigemp.gestion.client.api.interfaces.PanelActivityInterface;
import com.sigemp.gestion.client.api.menu.SgGrupo;
import com.sigemp.gestion.client.ventas.activity.estadocuenta.ActivityABMEstadosCuenta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Server
 */
public class SGSistemMenu {

    private static SGSistemMenu INSTANCE;

    public static SGSistemMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SGSistemMenu();
        }
        return INSTANCE;
    }
    
    
    static final Logger logger = Logger.getLogger("NameOfYourLogger");

    ArrayList<SgGrupo> grupoList = new ArrayList<>();

    public void addActivity(PanelActivityInterface activity) {

        boolean encontrado = false;
        for (SgGrupo grupo : grupoList) {
            // Si es el mismo menu.. veo si lo agrego
            if (grupo.getDescripcion().equals(activity.getOption().getGrupo())) {

                for (PanelActivityInterface activityB : grupo.getActivityList()) {
                    // Si la Opcion es igual, es que ya fue agregado
                    if (activityB.getOption().getDescripcion().equals(activity.getOption().getDescripcion())) {
                        return;
                    }
                }
                // SI se encuentra el menu y no encontro la opcion, la agrego y retorno
                grupo.add(activity);
                return;
            }
        }
        // Si no encontro el menu, lo creo y agrego la actividad
        if (!encontrado) {
            SgGrupo grupo = new SgGrupo(activity.getOption().getGrupo());
            grupo.add(activity);
            grupoList.add(grupo);
        }
    }

    public SGSistemMenu() {

        initMenus();

    }

////    private List<PanelActivityInterface> getItems(SgGrupo menu) {
////        for (SgGrupo ma : menuList) {
////            if (ma.equals(menu)) {
////                return ma.getMenuItemList();
////            }
////        }
////        return new ArrayList<>();
////    }

    public List<SgGrupo> getMenusList() {
        return grupoList;
    }

    /**
     * Agrego los menus con sus actividades
     *
     *
     */
    private void initMenus() {
        try {
            logger.log(Level.INFO, "Estados de Cuenta");
            addActivity(new ActivityABMActividad());
            addActivity(new ActivityABMEstadosCuenta());
            addActivity(new ActivityABMConceptosCaja());
            addActivity(new ActivityABMMediosCobro());
            addActivity(new ActivityABMPersonas());
            addActivity(new ActivityCambioClave());
            addActivity(new ActivityCobranza());
            addActivity(new ActivityComprobanteCaja());
            addActivity(new ActivityConsultaAfip());
            addActivity(new ActivityConsultaCobranza());
            addActivity(new ActivityConsultasVentas());
            addActivity(new ActivityDatosSistema());
            addActivity(new ActivityEmiteComprobanteVenta());
            addActivity(new ActivityListadoCobranza());
            addActivity(new ActivityListadoComprobanteCaja());
            addActivity(new ActivityListadoVentas());
            addActivity(new ActivityPuntosVentas());
            addActivity(new ActivityAjustes());
            logger.log(Level.INFO, "Se Agregaron " + grupoList.size() + " actividades.");
        } catch (Exception e) {
            GWT.log(e.getMessage(), e);

        }
    }

    public PanelActivityInterface findById(String Id) {
        for (SgGrupo menu : grupoList) {
            for (PanelActivityInterface activity : menu.getActivityList()) {
                if (activity.getId().equals(Id)) {
                    return activity;
                }
            }
        }
        return null;
    }

}
