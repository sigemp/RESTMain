/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * https://iconos8.es/icon/pack/free-icons/windows
 * @author Server
 */
public interface ResourcesImage extends ClientBundle {

    ResourcesImage INSTANCE = GWT.create(ResourcesImage.class);

    @Source("contact.png")
    ImageResource contact();
    
    @Source("apple-icon-57x57.png")
    ImageResource logoApp();
    
    @Source("submenu.png")
    ImageResource submenuIcon();
    
    @Source("icons8-actualizar-32.png")
    ImageResource fromActualizar();
    
    @Source("icons8-basura-32.png")
    ImageResource formBorrar();
    
    @Source("icons8-busqueda-32.png")
    ImageResource formBuscar();
    
    @Source("icons8-editar-32.png")
    ImageResource formEditar();
    
    @Source("icons8-más-32.png")
    ImageResource formAgregar();

    @Source("icons8-ajustes-32.png")
    ImageResource ajustes();
    
    @Source("icons8-salir-32.png")
    ImageResource logout();


    @Source("icons8-cancelar-32.png")
    ImageResource formCancelar();


    @Source("icons8-volver-32.png")
    ImageResource formVolver();
    
    
    @Source("icons8-guardar-32.png")
    ImageResource formGuardar();
    
    @Source("icons8-imprimir-32.png")
    ImageResource imprimir();

    @Source("icons8-panel-de-vista-previa-32.png")
    ImageResource vistaPrevia();

    @Source("icons8-ms-excel-32.png")
    ImageResource excel();

    @Source("icons8-gmail-32.png")
    ImageResource email();

    @Source("icons8-pdf-2-32.png")
    ImageResource pdf();
    
    
    @Source("developing.png")
    ImageResource enDesarrollo();

    @Source("foto-perfil.png")
    ImageResource getFotoPerfilVacia();
    
}
