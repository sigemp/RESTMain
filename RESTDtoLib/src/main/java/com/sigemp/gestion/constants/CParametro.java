/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.constants;

public enum CParametro {
    EMPRESA_AGENTE_PERCEPCION_IIBB_CATAMARCA("general.percepcion.iibb.catamarca", ""),
    EMPRESA_AGENTE_PERCEPCION_IIBB_CATAMARCA_PORCENTAJE("general.percepcion.iibb.catamarca.porcentaje", ""),
    EMPRESA_AGENTE_PERCEPCION_MUNICIPAL_CATAMARCA("general.percepcion.municipal.catamarca", ""),
    EMPRESA_AGENTE_PERCEPCION_MUNICIPAL_CATAMARCA_PORCENTAJE("general.percepcion.municipal.catamarca.porcentaje", ""),
    EMPRESA_CONDICION_IVA("general.empresa_condicion_iva", ""),
    EMPRESA_CUIT("general.empresa_cuit", ""),
    EMPRESA_DIRECCION("general.empresa_dir", ""),
    EMPRESA_EMAIL("general.empresa_email", ""),
    EMPRESA_FECHA_INICIO_ACTIVIDADES("general.empresa_fecha_inicio_actividades", ""),
    GENERAL_LOGO_EMPRESA("general.logo_empresa", ""),
    EMPRESA_NOMBRE("general.empresa_nom", ""),
    EMPRESA_NOMBRE_FANTASIA("general.empresa_nombre_fantasia", ""),
    EMPRESA_NUMERO_INGRESO_BRUTOS("general.empresa_numero_ingreso_brutos", ""),
    GENERAL_OMI_CIVA_ID("general.omi.civa_id", ""),
    GENERAL_OMI_EST_ID("general.omi.est_id", ""),
    GENERAL_OMI_ESTC_ID("general.omi.estc_id", ""),
    GENERAL_OMI_GSY_SUC("general.omi.gsy_suc", ""),
    GENERAL_OMI_LOC_ID("general.omi.loc_id", ""),
    GENERAL_OMI_PAIS_ID("general.omi.pais_id", ""),
    GENERAL_OMI_PERS_ID("general.omi.pers_id", ""),
    GENERAL_OMI_PROV_ID("general.omi.prov_id", ""),
    GENERAL_OMI_TDOC_ID("general.omi.tdoc_id", ""),
    GENERAL_OMI_ZONA_ID("general.omi.zona_id", ""),
    GENERAL_CARPETA_ARCHIVOS_GENERADOS("general.archivos.carpeta_archivos_generados", "Carpeta donde se almacenaran los archivos generados"),
    EMPRESA_TELEFONO("general.empresa_telefono", ""),
    PREVENTA_CANTIDAD_COPIAS_COMP("preventas.omi.cnt_copias_comprobantes", ""),
    PREVENTA_DYNAMIC_DDNS("preventas.omi.ddns", ""),
    PREVENTA_HABILITA_GPS("preventas.omi.habilitaGPS", ""),
    PREVENTA_IMPRIMIR_FECHA_HORA_ORDEN("preventas.omi.imprimr_fecha_hora_orden", ""),
    PREVENTA_SALIDA_FACTURAS_EN_LOTE("preventas.omi.impresion_lote_facturas", ""),
    PREVENTA_SALIDA_LISTADOS("preventas.omi.impresion_lote_listados", ""),
    PREVENTAS_OMI_PVTARUTA("preventas.omi.pvtaruta", ""),
    PREVENTAS_OMI_PVTATIPONEGOCIO("preventas.omi.pvtatiponegocio", ""),
    PREVENTAS_OMI_CPG_PREVENTA("preventas.omi.cpg_preventa", "1"),
    PREVENTAS_VALOR_CARPETA_FTP("preventas.valor.carpetaftp", ""),
    PREVENTAS_VALOR_FTP_SERVER_IP("preventas.valor.ftp_server_ip", ""),
    PREVENTAS_VALOR_FTP_SERVER_CLAVE("preventas.valor.ftp_server_clave", ""),
    PREVENTAS_PRECIO_PRIORITARIO_CUENTA("preventas.valor.precio_prioritario", "false"),
    SINGRONIZAR_HOST("general.sincronizar.host", ""),
    SINGRONIZAR_PASSWORD("general.sincronizar.password", ""),
    SINGRONIZAR_PORT("general.sincronizar.port", ""),
    SINGRONIZAR_USER("general.sincronizar.user", ""),
    STOCK_CANTIDAD_ITEMS("stock.valor.cantidad_items", ""),
    STOCK_CFG_ADMINISTRA_CAJAS("stock.omi.administra_cajas", ""),
    STOCK_CFG_ADMINISTRA_UNIDAD_DE_MEDIDA("stock.omi.administra_unidad_medida", ""),
    STOCK_CFG_ADMINISTRA_UNIDADES("stock.omi.administra_unidades", ""),
    STOCK_OMI_GSY_ACTIVIDAD("stock.omi.gsy_actividad", ""),
    STOCK_OMI_MARCA("stock.omi.marca_id", ""),
    STOCK_OMI_PRVPRV("stock.omi.prv_prv", ""),
    STOCK_OMI_STK_DEP("stock.omi.stk_dep", ""),
    STOCK_OMI_STK_DEPOSITO("stock.omi.stk_deposito", ""),
    STOCK_OMI_TIPO_IVA("stock.omi.gsytiva", ""),
    STOCK_OMI_UNIDAD_MEDIDA("stock.omi.unidad_medida", ""),
    STOCK_OMI_MODO_CALCULO_PRECIOS("stock.omi.modo_calculo_precios", ""),
    VENTAS_AFIP_DST_DN("ventas.afip.dst_dn", ""),
    VENTAS_AFIP_ENDPOINTWSFEV1("ventas.afip.endpoint_wsfev1", ""),
    VENTAS_AFIP_ENDPOINTWSSA("ventas.afip.endpoint_wsaa", ""),
    VENTAS_AFIP_NAME_TAXML("ventas.afip.name.taxml", ""),
    VENTAS_AFIP_P12FILE("ventas.afip.p12_file", ""),
    VENTAS_AFIP_P12PASS("ventas.afip.p12_pass", ""),
    VENTAS_AFIP_SIGNER("ventas.afip.signer", ""),
    VENTAS_AFIP_TICKETTIME("ventas.afip.ticket_time", ""),
    VENTAS_ARTICULOS_AUTONUMERAR_POR_OMISION("stock.articulos.autonumerar_por_omision", ""),
    VENTAS_COB_MEDIO_COBRO_POR_OMISION("ventas.cobranza.mediocobro_por_omision", ""),
    VENTAS_CODIGO_GASTOS_FINANCIEROS("ventas.valor.codigo_gastos_financieros", ""),
    VENTAS_CODIGO_MORA_EN_DEBITOS("ventas.valor.codigo_mora_en_debitos", ""),
    VENTAS_CUE_AUTONUMERAR_POR_OMISION("ventas.cuentas.autonumerar_por_omision", ""),
    VENTAS_DIAS_TOLERANCIA_COBRO_MORA("ventas.valor.dias_tolerancia_para_cobro_de_mora", ""),
    VENTAS_FAC_FOCO_CAMPO_DESCUENTO("ventas.valor.facturacion.foco_campo_descuento", ""),
    VENTAS_FAC_IVA0_DCTO_567_2019("ventas.valor.facturacion.iva0_dto_567_2019", ""),
    VENTAS_FAC_IVA0_DCTO_567_2019_DESCUENTA_MONOTRIBUTO("ventas.valor.facturacion.iva0_dto_567_2019_descuenta_monotributo", ""),
    VENTAS_FAC_FPG_PREDEF_POR_CTA("ventas.valor.facturas.forma_pago_predefinida_por_cuenta", ""),
    VENTAS_FAC_MODO_SUPERMERCADO("ventas.valor.modo_supermercado", ""),
    VENTAS_FACT_USAR_VENDEDOR_P_VENTA("ventas.valor.facturas.usar_misma_vendedor_para_toda_venta", ""),
    VENTAS_FACT_VENDEDOR_PARA_TODA_VENTA("ventas.valor.facturas.usar_vendedor_para_toda_venta", ""),
    VENTAS_FACTURACION_CANTIDAD_ITEMS("ventas.valor.cantidad_items", ""),
    VENTAS_FACTURACION_DEJAR_PENDIENTES("ventas.valor.facturas.dejar_facturas_pendientes", ""),
    VENTAS_LOGO("ventas.omi.logo", ""),
    VENTAS_OMI_VTABANCOS("ventas.omi.vta_bancos", ""),
    VENTAS_OMI_VTACPG("ventas.omi.vta_cpg", ""),
    VENTAS_OMI_VTACTA("ventas.omi.vta_cta", ""),
    VENTAS_OMI_VTAEST("ventas.omi.vta_est", ""),
    VENTAS_OMI_VTATARJETAS("ventas.omi.vta_tarjetas", ""),
    VENTAS_OMI_VTAVEN("ventas.omi.vta_ven", ""),
    VENTAS_PORCENTAJE_MORA_COBRANZA_TDM("ventas.valor.porcentaje_cobranza", ""),
    VENTAS_PRESUPUESTO_LOGO("vta_logo_presupuesto", ""),
    VENTAS_PRESUPUESTO_TEXTO("vta_texto_presupuesto", ""),
    PREVENTAS_MARCAS_HABILITADAS_RUTA_A("preventa.ruta.marcas_habilitadas_grupo_a", ""),
    PREVENTAS_MARCAS_HABILITADAS_RUTA_B("preventa.ruta.marcas_habilitadas_grupo_b", ""),
    PREVENTAS_HABILITA_RUTA_B("preventa.ruta.habilita_ruta_b", "false");

    private final String msg;

    private final String clave;

    CParametro(String clave, String msg) {
        this.clave = clave;
        this.msg = msg;
    }

    public String getClave() {
        return clave;
    }

}
