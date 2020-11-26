/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ventas;

import com.sigemp.gestion.client.api.Menu;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.interfaces.PanelActivity;

/**
 *
 * @author Server
 */
public class ActivityConsultaCobranza extends PanelActivity {

    public ActivityConsultaCobranza() {
        Menu menu = getOption();
        menu.setDescripcion("Consulta Cobranza");
        menu.setGrupo(Constantes.MENU_SISTEMAS.CONSULTAS.getDescripcion());
    }
    
}
