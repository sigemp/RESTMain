/*
 * Comprobantes.java
 *
 * Created on 19 de marzo de 2007, 11:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.constantes;

import com.sigemp.gestion.client.api.util.StringUtils;
import com.sigemp.gestion.client.exception.SgException;
import com.sigemp.gestion.shared.entity.constantes.FiltroPedidos;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Mantiene las constantes de los tipos de comprobantes COMPROBANTES Tambien
 * sirve para hacer afectaciones y desafectaciones entre comprobantes tanto la
 * afectacion como la desafectacion la hago del lado del cliente
 *
 * @author Usuario
 */
public class ConstantesComprobantes {

    private static final StringUtils sc = new StringUtils();

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
        PREVENTAS_MARCAS_HABILITADAS_RUTA_B("preventa.ruta.marcas_habilitadas_grupo_a", ""), 
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

    public enum ArticuloFlag {
        FLAG_MODIFICA_PRECIOS("m", "Modifica Precio"),
        FLAG_MODIFICA_DESCRIPCION("d", "Modifica Descripcion"),
        FLAG_USO_EXPLUSIVO("x", "Uso Exclusivo Sistema"),
        FLAG_MODIFICA_CANTIDAD_PRECIO("P", "Modifica Cantidad"),
        FLAG_MERCADERIA_VENTA_PESO("e", "Venta Peso"),
        FLAG_NO_PERMITE_DESCUENTO_GLOBAL("D", "Descuento Global"),
        FLAG_NO_PERMITE_DESCUENTO_UNITARIO("u", "Descuento Unitario"),
        FLAG_NO_FINANCIA("y", "No Financia"),
        FLAG_INGRESA_TODA_FACTURA("f", "Ingresa Toda Factura"),
        FLAG_GESTIONA_STOCK("s", "Gestiona Stock"),
        FLAG_NO_EXPORTA_MOBILE("I", "No Exporta a Mobil"),
        FLAG_PERMITE_FRACCIONAR("F", "Permite Fraccionar"),
        FLAG_NO_TIENE_STOCK("K", "Articulo Bloqueado"),
        FLAG_NO_PEDIR_CANTIDAD("n", "Permitir Cantidad"),
        FLAG_PRESUPUESTO_SIVA("p", "Para presupuesto"),
        FLAG_NO_REPETIR_ARTICULOS_EN_DISTINTOS_RENGLONES("r", "Repetir Articulos en Factura");

        private final String codigo;
        private final String des;

        ArticuloFlag(String codigo, String des) {
            this.codigo = codigo;
            this.des = des;
        }

        /**
         * @return the codigo
         */
        public String getCodigo() {
            return codigo;
        }

        /**
         * @return the des
         */
        public String getDes() {
            return des;
        }

    }

    public enum PrecioBase {
        PRECIO_1(1, "PRECIO 1"),
        PRECIO_2(2, "PRECIO 2"),
        PRECIO_3(3, "PRECIO 3"),
        PRECIO_4(4, "PRECIO 4");

        private final String des;
        private final int numPrc;

        PrecioBase(int numPrc, String des) {
            this.numPrc = numPrc;
            this.des = des;
        }

        @Override
        public String toString() {
            return name().replaceAll("_", " ");
        }

        public int getId() {
            return numPrc;
        }

        public String getDes() {
            return des;
        }

        public static PrecioBase getById(Integer numPrc) {
            if (numPrc == null) {
                return null;
            }
            for (PrecioBase x : PrecioBase.values()) {
                if (numPrc.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

    }

    public enum VentasFlags {

        ANULADO("Anulado", "A"),
        SEGUNDA_VENTA("Vta. Seg. Vendedor", "s"),
        ANULADA_NC("Anulada p NC", "N"),
        NADA("Nada", "");

        private final String descripcion;
        private final String id;

        private VentasFlags(String des, String id) {
            this.descripcion = des;
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getId() {
            return id;
        }

        /**
         * Busca por medio de su id, si no encuentra retorna null
         *
         * @param id
         * @return VentasFlags
         */
        public static VentasFlags getById(String id) {
            if (id == null) {
                return null;
            }
            for (VentasFlags x : VentasFlags.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }

    }

    public enum EstadoCuentaFlag {
        FLAG_PERMITE_FACTURAR("f", "Permite Facturar"),
        FLAG_PERMITA_COBRAR("c", "Permite Cobrar");
        private final String des;
        private final String id;

        private EstadoCuentaFlag(String id, String des) {
            this.id = id;
            this.des = des;
        }

        /**
         * @return the des
         */
        public String getDes() {
            return des;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

    }

    

    public enum FiltroCobranzaSaldo {
        TODO, SIN_SALDO, CON_SALDO;

        @Override
        public String toString() {
            return name().replace("_", " ");
        }

    };

    public enum TipoSalida {
        GRAFICA, MATRIZ_PUNTO
    };

    public enum Sistema {
        VENTA("VENTAS", 1),
        COBRANZA("COBRANZA", 2),
        CAJA("CAJA", 3),
        STOCK("MOVIMIENTO MERCADERIA", 4),
        PROVEEDORES("PROVEEDORES", 5),
        STOCK_INVENTARIO("PROCESO INVENTARIO", 6),
        COBANZA_LOTE("LOTE COBRANZA", 7);

        private final String descripcion;
        private final int id;

        private Sistema(String descripcion, int id) {
            this.descripcion = descripcion;
            this.id = id;

        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * Busca la TiposContadores por id, si no se encuentra retorna null
         *
         * @param id
         * @return CondicionIva
         */
        public static Sistema getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (Sistema x : Sistema.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return descripcion;
        }
    }

    public enum ComportamientoEmisionComprobante {

        NO_HACER_NADA("No Hacer Nada", 1),
        IMPRIMIR("Imprimir Comprobante", 2),
        VISTA_PREVIA("Mostrar Vista Previa", 3),
        PERMITIR_SELECCIONAR_IMPRESORA("Permitir seleccionar impresora de salida", 4);

        private final String desdescripcion;
        private final Integer id;

        private ComportamientoEmisionComprobante(String descripcion, Integer id) {
            this.desdescripcion = descripcion;
            this.id = id;

        }

        /**
         * @return the desdescripcion
         */
        public String getDescripcion() {
            return desdescripcion;
        }

        /**
         * @return the civaId
         */
        public Integer getId() {
            return id;
        }

        /**
         * Busca la ComportamientoEmisionComprobante por id, si no se encuentra
         * retorna null
         *
         * @param id
         * @return CondicionIva
         */
        public static ComportamientoEmisionComprobante getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (ComportamientoEmisionComprobante x : ComportamientoEmisionComprobante.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }
    }
    // PARA PRESENTACIONES FUNERARIA
    public static final int NO_FISCAL_PRESENTACIONES = 601;

    // Agregados para el sistema cobranza
    // 22-01-2008
    public static final int NO_FISCAL_REFINANCIACION = 521;
    public static final int NO_FISCAL_REF_CREDITO = 524;
    public static final int NO_FISCAL_REF_DEBITO = 523;

    // Constantes para tipos de salida de comprobantes
    public static final int SALIDA_VISTA_PREVIA = 1;
    // VARIOS
    public static String SIN_NUMERO = "S/NUMERO";

    private static final Logger LOG = Logger.getLogger(ConstantesComprobantes.class.getName());

    public ConstantesComprobantes() {
    }

    public enum TiposPercepcionesMunicipal {
        TIPO_PERCEPCION_NO_INSCRIPTO("NO INSCRIPTO", 0),
        TIPO_PERCEPCION_CONTRIBUYENTE("CONTRIBUYENTE MUNICIPAL", 1),
        TIPO_PERCEPCION_CONTRIBUYENTE_EXENTO("EXENTO", 2);

        private final String descripcion;
        private final int id;

        private TiposPercepcionesMunicipal(String descripcion, int id) {
            this.descripcion = descripcion;
            this.id = id;
        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * Busca TiposPercepcionesMunicipal por su id, si no encuentra retorna
         * null
         *
         * @param id
         * @return TiposPercepcionesMunicipal
         */
        public static TiposPercepcionesMunicipal getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (TiposPercepcionesMunicipal x : TiposPercepcionesMunicipal.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }
    }

    public enum TiposPercepcionesRentas {
        TIPO_PERCEPCION_NO_INSCRIPTO("NO INSCRIPTO", 0),
        TIPO_PERCEPCION_CONTRIBUYENTE_LOCAL("CONTRIBUYENTE LOCAL", 1),
        TIPO_PERCEPCION_CONTRIBUYENTE_MULTILATERAL("CONTRIBUYENTE MULTILATERAL", 2);

        private final String descripcion;
        private final int id;

        private TiposPercepcionesRentas(String descripcion, int id) {
            this.descripcion = descripcion;
            this.id = id;
        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * Busca la TiposPercepcionesRentas por ID, si no existe retora null
         *
         * @param id
         * @return TiposPercepcionesRentas
         */
        public static TiposPercepcionesRentas getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (TiposPercepcionesRentas x : TiposPercepcionesRentas.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }

    }

    public enum Percepciones {

        PERC_2126("Perc.Rg2126", 1),
        PERC_IIBB_CATAMARCA("Perc.IIBB Catamarca", 2),
        PERC_MUNICIPAL_CATAMARCA("Perc.Municipal Catamarca", 3);

        private final String descripcion;
        private final int id;

        private Percepciones(String des, int id) {
            this.descripcion = des;
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getId() {
            return id;
        }

        /**
         * Busca Percepciones por ID, si no existe retora null
         *
         * @param id
         * @return Percepciones
         */
        public static Percepciones getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (Percepciones x : Percepciones.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }
    }

    public enum TipoComprobante {

        FACTURA(1, "FACTURAS", Sistema.VENTA),
        NOTA_DEBITO(2, "NOTA DEBITO", Sistema.VENTA),
        NOTA_CREDITO(3, "NOTA CREDITO", Sistema.VENTA),
        INGRESO_COB(4, "INGRESO", Sistema.COBRANZA),
        EGRESO_COB(5, "EGRESO", Sistema.COBRANZA),
        INGRESO_CAJ(6, "OTRO", Sistema.CAJA),
        EGRESO_CAJ(7, "OTRO", Sistema.CAJA),
        INGRESO_STK(8, "OTRO", Sistema.STOCK),
        EGRESO_STK(9, "OTRO", Sistema.STOCK),
        INGRESO_PRV(10, "OTRO", Sistema.PROVEEDORES),
        EGRESO_PRV(11, "OTRO", Sistema.PROVEEDORES),
        OTRO_CAJ(12, "OTRO", Sistema.CAJA),
        LOTE_COBRANZA(13, "LOTE", Sistema.COBANZA_LOTE),
        INVENTARIO_PROCESO(14, "PROCESO INVENTARIO", Sistema.STOCK_INVENTARIO);

        private final int codigo;
        private final String des;
        private final Sistema sistema;

        TipoComprobante(int codigo, String des, Sistema sistema) {
            this.codigo = codigo;
            this.des = des;
            this.sistema = sistema;
        }

        public Sistema getSistema() {
            return sistema;
        }

        /**
         * @return the codigo
         */
        public int getCodigo() {
            return codigo;
        }

        /**
         * @return the des
         */
        public String getDes() {
            return des;
        }


    }

    public enum Letra {
        A("A"),
        B("B"),
        C("C"),
        M("M"),
        X("X"),
        Z("Z");
        private String letra;

        private Letra(String letra) {
            this.letra = letra;
        }

        public String getLetra() {
            return letra;
        }

    }

    public enum Comprobante {

        VTA_FACTURA_A(1, "FACTURA A", "FA", "f", Letra.A, TipoComprobante.FACTURA),
        VTA_NOTA_DEBITO_A(2, "NOTA DE DEBITO A", "DA", "f", Letra.A, TipoComprobante.NOTA_DEBITO),
        VTA_NOTA_CREDITO_A(3, "NOTA DE CREDITO A", "CA", "f", Letra.A, TipoComprobante.NOTA_CREDITO),
        CAJ_RECIBO_A(4, "RECIBO A", "RA", "f", Letra.X, TipoComprobante.INGRESO_COB),
        VTA_FACTURA_B(6, "FACTURA B", "FB", "f", Letra.B, TipoComprobante.FACTURA),
        VTA_NOTA_DEBITO_B(7, "NOTA DE DEBITO B", "DB", "f", Letra.B, TipoComprobante.NOTA_DEBITO),
        VTA_NOTA_CREDITO_B(8, "NOTA DE CREDITO B", "CB", "f", Letra.B, TipoComprobante.NOTA_CREDITO),
        CAJ_RECIBO_B(9, "RECIBO B", "RB", "f", Letra.B, TipoComprobante.INGRESO_COB),
        VTA_FACTURA_C(11, "FACTURA C", "FC", "f", Letra.C, TipoComprobante.FACTURA),
        VTA_NOTA_DEBITO_C(12, "NOTA DE DEBITO C", "DC", "f", Letra.C, TipoComprobante.NOTA_DEBITO),
        VTA_NOTA_CREDITO_C(13, "NOTA DE CREDITO C", "CC", "f", Letra.C, TipoComprobante.NOTA_CREDITO),
        CAJ_RECIBO_C(15, "RECIBO C", "RC", "f", Letra.C, TipoComprobante.INGRESO_COB),
        VTA_FACTURA_M(51, "FACTURA M", "FM", "f", Letra.M, TipoComprobante.FACTURA),
        VTA_NOTA_DEBITO_M(52, "NOTA DE DEBITO M", "DM", "f", Letra.M, TipoComprobante.NOTA_DEBITO),
        VTA_NOTA_CREDITO_M(53, "NOTA DE CREDITO M", "CM", "f", Letra.M, TipoComprobante.NOTA_CREDITO),
        CAJ_RECIBO_M(54, "RECIBO M", "RM", "f", Letra.M, TipoComprobante.INGRESO_COB),
        CAJ_CIERREZ(80, "COMPROBANTE DIARIO DE CIERRE (ZETA)", "Z", "f", Letra.Z, TipoComprobante.OTRO_CAJ),
        VTA_TICKET_FACTURA_A(81, "TICKET FACTURA A", "TA", "f", Letra.A, TipoComprobante.FACTURA),
        VTA_TICKET_FACTURA_B(82, "TICKET FACTURA B", "TB", "f", Letra.B, TipoComprobante.FACTURA),
        VTA_TICKET(83, "TICKET", "T ", "f", Letra.B, TipoComprobante.FACTURA),
        VTA_FACTURA_X(97, "NOTA PEDIDO", "OP", "f", Letra.X, TipoComprobante.FACTURA),
        VTA_NOTA_CREDITO_X(99, "ANULA NOTA PEDIDO", "*OP", "f", Letra.X, TipoComprobante.NOTA_CREDITO),
        CAJ_RECIBO(500, "RECIBO", "RE", "f", Letra.X, TipoComprobante.INGRESO_COB),
        CAJ_RECIBO_ANULA(501, "ANULA-RECIBO", "*RE", "f", Letra.X, TipoComprobante.EGRESO_COB),
        STK_REMITO_TRANSFERENCIA(502, "REMITO TRANSFERENCIA", "RT", "f", Letra.X, TipoComprobante.EGRESO_STK),
        STK_REMITO_TRANSFERENCIA_ANULA(503, "ANULA-REMITO TRANSFERENCIA", "*RT", "f", Letra.X, TipoComprobante.INGRESO_STK),
        STK_ORDEN_COMPRA(504, "ORDEN DE COMPRA", "OC", "f", Letra.X, TipoComprobante.INGRESO_STK),
        STK_ORDEN_COMPRA_ANULA(505, "ANULA-ORDEN DE COMPRA", "*OC", "f", Letra.X, TipoComprobante.EGRESO_STK),
        CAJ_INGRESO_CAJA(506, "INGRESO-CAJA", "IC", "f", Letra.X, TipoComprobante.INGRESO_CAJ),
        CAJ_INGRESO_CAJA_ANULA(107, "ANULA-INGRESO CAJA", "*OC", "f", Letra.X, TipoComprobante.EGRESO_CAJ),
        CAJ_EGRESO_CAJA(508, "EGRESO-CAJA", "OC ", "f", Letra.X, TipoComprobante.EGRESO_CAJ),
        CAJ_EGRESO_CAJA_ANULA(509, "ANULA-EGRESO CAJA", "*IC", "f", Letra.X, TipoComprobante.INGRESO_CAJ),
        STK_REMITO_COMPRA(510, "REMITO COMPRA", "RC", "f", Letra.X, TipoComprobante.INGRESO_STK),
        STK_REMITO_COMPRA_ANULA(511, "ANULA-REMITO COMPRA", "*RC", "f", Letra.X, TipoComprobante.EGRESO_STK),
        STK_REMITO_INGRESO(512, "REMITO INGRESO", "RI", "f", Letra.X, TipoComprobante.INGRESO_STK),
        STK_REMITO_INGRESO_ANULA(513, "ANULA-REMITO INGRESO", "*RI", "f", Letra.X, TipoComprobante.EGRESO_STK),
        STK_REMITO_EGRESO(514, "REMITO EGRESO", "RE", "f", Letra.X, TipoComprobante.EGRESO_STK),
        STK_REMITO_EGRESO_ANULA(515, "ANULA-REMITO EGRESO", "*RE", "f", Letra.X, TipoComprobante.INGRESO_STK),
        STK_REMITO_VENTA(519, "REMITO-VENTA", "RM", "f", Letra.X, TipoComprobante.EGRESO_STK),
        STK_REMITO_VENTA_ANULA(520, "ANULA-REMITO-VENTA", "*RM", "f", Letra.X, TipoComprobante.INGRESO_STK),
        PRV_PAGO(516, "PAGO PROVEEDORES", "PP", "f", Letra.X, TipoComprobante.EGRESO_PRV),
        PRV_PAGO_ANULA(517, "ANULA-PAGO-PROVEEDORES", "*PP", "f", Letra.X, TipoComprobante.INGRESO_PRV),
        STK_REMITO_INVENTARIO(518, "REMITO DE INVENTARIO", "IN", "f", Letra.X, TipoComprobante.INGRESO_STK),
        STK_PROCESO_INVENTARIO(535, "PROCESO DE INVENTARIO", "IN", "f", Letra.X, TipoComprobante.INVENTARIO_PROCESO),
        VTA_TICKET_FACTURA_C(111, "TICKET FACTURA C", "TFC", "f", Letra.C, TipoComprobante.FACTURA), //111 - 600
        VTA_TICKET_CREDITO_A(112, "TICKET N.CREDITO A", "TNA", "f", Letra.A, TipoComprobante.NOTA_CREDITO), //112 - 604
        VTA_TICKET_CREDITO_B(113, "TICKET N.CREDITO B", "TNB", "f", Letra.B, TipoComprobante.NOTA_CREDITO), //113 - 605
        VTA_TICKET_CREDITO_C(114, "TICKET N.CREDITO C", "TNC", "f", Letra.C, TipoComprobante.NOTA_CREDITO), //114 - 606
        VTA_TICKET_DEBITO_A(115, "TICKET N.DEBITO A", "TDA", "f", Letra.A, TipoComprobante.NOTA_DEBITO), //115 - 607
        VTA_TICKET_DEBITO_B(116, "TICKET N.DEBITO B", "TDB", "f", Letra.B, TipoComprobante.NOTA_DEBITO), //116 - 608
        VTA_TICKET_DEBITO_C(117, "TICKET N.DEBITO C", "TDC", "f", Letra.C, TipoComprobante.NOTA_DEBITO), //117 - 609
        VTA_TICKET_FACTURA_M(118, "TICKET FACTURA M", "TFM", "f", Letra.M, TipoComprobante.FACTURA), //118
        VTA_TICKET_CREDITO_M(119, "TICKET N.CREDITO M", "TNM", "f", Letra.M, TipoComprobante.NOTA_CREDITO), //119
        VTA_TICKET_DEBITO_M(120, "TICKET N.DEBITO M", "TDM", "f", Letra.M, TipoComprobante.NOTA_DEBITO), //120
        PRV_LOTE_COBRANZA(550, "LOTE COBRANZA", "LC", "x", Letra.X, TipoComprobante.LOTE_COBRANZA),
        STK_REINTEGRO(552, "REINTEGRO", "CR", "x", Letra.X, TipoComprobante.EGRESO_STK), // como transferencia pero pide el id del cliente
        STK_REINTEGRO_ANULA(553, "ANULA-REINTEGRO", "*CR", "x", Letra.X, TipoComprobante.INGRESO_STK); // como transferencia pero pide el id del cliente

        private final String tipo;
        private final String abr;
        private final String descripcion;
        private final Integer id;
        private final Letra letra;
        private final TipoComprobante tipoComprobante;

        private Comprobante(Integer id, String descripcion, String abr, String tipo, Letra letra, TipoComprobante tipoComprobante) {
            this.id = id;
            this.descripcion = descripcion;
            this.abr = abr;
            this.tipo = tipo;
            this.letra = letra;
            this.tipoComprobante = tipoComprobante;

        }

        /**
         * @return the tipo
         */
        public String getTipo() {
            return tipo;
        }

        /**
         * @return the abr
         */
        public String getAbr() {
            return abr;
        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @return the id
         */
        public Integer getTcId() {
            return id;
        }

        /**
         * @return the letra
         */
        public Letra getLetra() {
            return letra;
        }

        /**
         * Retorna verdadero si el tipo de comprobante esta presente en el grupo
         *
         * @param tipoComprobanteGeneral
         * @param tipoComprobante
         * @return
         */
        public static boolean contiene(TipoComprobante tipoComprobanteGeneral, Comprobante tipoComprobante) {
            List<Comprobante> grupo = Comprobante.getComprobantes(tipoComprobanteGeneral);
            for (Comprobante t : grupo) {
                if (t.equals(tipoComprobante)) {
                    return true;
                }
            }
            return false;
        }

        public static Comprobante comprobanteContrario(Comprobante comprobante) throws SgException {
            switch (comprobante) {
                case VTA_FACTURA_A:
                case VTA_NOTA_DEBITO_A:
                    return VTA_NOTA_CREDITO_A;
                case VTA_FACTURA_B:
                case VTA_NOTA_DEBITO_B:
                    return VTA_NOTA_CREDITO_B;
                case VTA_FACTURA_C:
                case VTA_NOTA_DEBITO_C:
                    return VTA_NOTA_CREDITO_C;
                case VTA_FACTURA_M:
                case VTA_NOTA_DEBITO_M:
                    return VTA_NOTA_CREDITO_M;
                case VTA_TICKET_FACTURA_A:
                case VTA_TICKET_DEBITO_A:
                    return VTA_TICKET_CREDITO_A;
                case VTA_TICKET_FACTURA_B:
                case VTA_TICKET_DEBITO_B:
                    return VTA_TICKET_CREDITO_B;
                case VTA_TICKET_FACTURA_C:
                case VTA_TICKET_DEBITO_C:
                    return VTA_TICKET_CREDITO_C;
                case VTA_FACTURA_X:
                    return VTA_NOTA_CREDITO_X;
                default:
                    throw new SgException("No hay comprobante para anular " + comprobante.getDescripcion());
            }
        }

        /**
         * De tipos de comprobante que estan disponibles, siempre elije las
         * facturas prioritariamente
         *
         *
         * @param listTcDisponibles
         * @return
         */
        public static Comprobante getComprobantePrioritario(List<Comprobante> listTcDisponibles) {

            Comprobante tcOmicion = null;
            for (Comprobante currentTc : listTcDisponibles) {

                tcOmicion = currentTc;
                // selecciono siempre una factura como tipo de comrpobante
                switch (currentTc) {
                    case VTA_FACTURA_A:
                    case VTA_FACTURA_B:
                    case VTA_FACTURA_C:
                    case VTA_FACTURA_M:
                    case VTA_TICKET_FACTURA_A:
                    case VTA_TICKET_FACTURA_B:
                    case VTA_TICKET_FACTURA_C:
                    case VTA_TICKET_FACTURA_M:
                    case VTA_FACTURA_X:
                        return currentTc;

                }
            }
            return tcOmicion;
        }

        /**
         * Busca el TiposComprobantes por ID, si no existe retora null
         *
         * @param id
         * @return the descripcion
         */
        public static Comprobante getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (Comprobante x : Comprobante.values()) {
                if (id.equals(x.getTcId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }

        /**
         * @return the tipoComprobanteGeneral
         */
        public TipoComprobante getTipoComprobante() {
            return tipoComprobante;
        }

        public static List<Comprobante> getComprobantes(Sistema grupo) {
            List<Comprobante> tclist = new ArrayList<Comprobante>();
            for (Comprobante t : Comprobante.values()) {
                if (t.getTipoComprobante().getSistema().equals(grupo)) {
                    tclist.add(t);
                }
            }
            return tclist;
        }

        public static List<Comprobante> getComprobantes(TipoComprobante tcg) {
            List<Comprobante> tclist = new ArrayList<Comprobante>();
            for (Comprobante t : Comprobante.values()) {
                if (t.getTipoComprobante().equals(tcg)) {
                    tclist.add(t);
                }
            }
            return tclist;
        }

        /**
         * Este metodo determina si el tipo de comprobante se puede emitir segun
         * la segun la condicion de iva del emisor y comprador
         *
         * @param tipoComprobante
         * @param condicionIvaEmisor
         * @param condicionIvaComprador
         * @return
         */
        public static void comprobarTipoComprobante(Comprobante tipoComprobante, CondicionIva condicionIvaEmisor, CondicionIva condicionIvaComprador) throws SgException {
            switch (condicionIvaEmisor) {
                case IVA_LIBERADO:
                case RESPONSABLE_INSCRIPTO_AGENTE_PERCEPCION:
                case RESPONSABLE_INSCRIPTO:
                    switch (condicionIvaComprador) {
                        case IVA_LIBERADO:
                        case RESPONSABLE_INSCRIPTO_AGENTE_PERCEPCION:
                        case RESPONSABLE_INSCRIPTO:
                            switch (tipoComprobante) {
                                case VTA_FACTURA_A:
                                case VTA_TICKET_FACTURA_A:
                                case VTA_NOTA_DEBITO_A:
                                case VTA_NOTA_CREDITO_A:
                                case VTA_TICKET_CREDITO_A:
                                    return;
                                default:
                                    throw new SgException("No se puede emitir un/a " + tipoComprobante + " a un " + condicionIvaComprador);
                            }
                        case CONSTRIBUYENTE_EVENTUAL:
                        case MONOTRIBUTISTA_SOCIAL:
                        case CONTRIBUYENTE_EVENTUAL_SOCIAL:
                        case RESPONSABLE_MONOTRIBUTO:
                        case CONSUMIDOR_FINAL:
                        case SUJETO_EXENTO:
                        case SUJETO_NO_CATEGORIZADO:
                            switch (tipoComprobante) {
                                case VTA_FACTURA_B:
                                case VTA_TICKET_FACTURA_B:
                                case VTA_NOTA_DEBITO_B:
                                case VTA_NOTA_CREDITO_B:
                                case VTA_TICKET_CREDITO_B:
                                    return;
                                default:
                                    throw new SgException("No se puede emitir un/a " + tipoComprobante + " a un " + condicionIvaComprador);
                            }
                        case RESPONSABLE_NO_INSCRIPTO:
                            switch (tipoComprobante) {
                                case VTA_FACTURA_X:
                                case VTA_NOTA_CREDITO_X:
                                    return;
                                default:
                                    throw new SgException("No se puede emitir un/a " + tipoComprobante + " a un " + condicionIvaComprador);
                            }
                    }
                case CONSTRIBUYENTE_EVENTUAL:
                case MONOTRIBUTISTA_SOCIAL:
                case CONTRIBUYENTE_EVENTUAL_SOCIAL:
                case RESPONSABLE_MONOTRIBUTO:
                    switch (condicionIvaComprador) {
                        case IVA_LIBERADO:
                        case RESPONSABLE_INSCRIPTO_AGENTE_PERCEPCION:
                        case RESPONSABLE_INSCRIPTO:
                        case CONSTRIBUYENTE_EVENTUAL:
                        case MONOTRIBUTISTA_SOCIAL:
                        case CONTRIBUYENTE_EVENTUAL_SOCIAL:
                        case RESPONSABLE_MONOTRIBUTO:
                        case CONSUMIDOR_FINAL:
                            switch (tipoComprobante) {
                                case VTA_FACTURA_C:
                                case VTA_NOTA_DEBITO_C:
                                case VTA_NOTA_CREDITO_C:
                                case VTA_TICKET_FACTURA_C:
                                case VTA_TICKET_CREDITO_C:
                                    return;
                                default:
                                    throw new SgException("No se puede emitir un/a " + tipoComprobante + " a un " + condicionIvaComprador);
                            }
                    }
                    break;
                default:
                    throw new SgException("No se puede emitir un/a " + tipoComprobante + " a un " + condicionIvaComprador);
            }
        }

        public static String getArbolComprobantes() {
            StringBuilder sb = new StringBuilder();
            for (Sistema s : Sistema.values()) {
                sb.append(s.name()).append(sc.RC);
                for (TipoComprobante tcg : TipoComprobante.values()) {

                    List<Comprobante> list = getComprobantes(s, tcg);

                    if (list.isEmpty()) {
                        continue;
                    }
                    sb.append(sc.repetir(" ", 2)).append(tcg.name()).append(sc.RC);
                    for (Comprobante tc : list) {
                        sb.append(sc.repetir(" ", 4))
                                .append(sc.fillIzquierda(tc.getTcId().toString(), 5))
                                .append(" ")
                                .append(sc.fillDerecha(tc.name(), 38))
                                .append(" ")
                                .append(tc.getDescripcion())
                                .append(sc.RC);
                    }
                }
            }
            return sb.toString();

        }

        private static List<Comprobante> getComprobantes(Sistema sistema, TipoComprobante tcg) {
            List<Comprobante> list = new ArrayList<Comprobante>();
            for (Comprobante tc : Comprobante.values()) {
                if (!(tc.getTipoComprobante().equals(tcg) && tc.getTipoComprobante().getSistema().equals(sistema))) {
                    continue;
                }
                list.add(tc);

            }
            return list;
        }

        public static String getIdsComprobantesFiscales(TipoComprobante... tipo) {
            return getIdsComprobantesFiscales(FiltroPedidos.TODO, tipo);
////            List<Integer> lis = new ArrayList<>();
////            List<Comprobante> lisComp = new ArrayList<>();
////
////            for (TipoComprobante t : tipo) {
////                lisComp.addAll(Comprobante.getComprobantes(t));
////            }
////
////            for (Comprobante c : lisComp) {
////                lis.add(c.getTcId());
////            }
////
////            return StringUtils.listToString(lis);
        }

        public static String getIdsComprobantesFiscales(FiltroPedidos filtroPedidos, TipoComprobante... tipo) {
            List<Integer> lis = new ArrayList<Integer>();
            List<Comprobante> lisComp = new ArrayList<Comprobante>();

            switch (filtroPedidos) {
                case FACTURAS:
                    // Se agregan solo comprobantes facturas
                    for (TipoComprobante t : tipo) {
                        lisComp.addAll(Comprobante.getComprobantes(t));
                    }
                    lisComp.remove(Comprobante.VTA_FACTURA_X);
                    lisComp.remove(Comprobante.VTA_NOTA_CREDITO_X);
                    break;
                case PEDIDOS:
                    for (TipoComprobante t : tipo) {
                        if (t.equals(TipoComprobante.FACTURA)) {
                            lisComp.add(Comprobante.VTA_FACTURA_X);
                        }
                        // Se agregan solo notas de pedido
                        if (t.equals(TipoComprobante.NOTA_CREDITO)) {
                            lisComp.add(Comprobante.VTA_NOTA_CREDITO_X);
                        }
                    }
                    break;
                case TODO:
                    // Se agregan todos los comprobantes 
                    for (TipoComprobante t : tipo) {
                        lisComp.addAll(Comprobante.getComprobantes(t));
                    }
            }

            for (Comprobante c : lisComp) {
                lis.add(c.getTcId());
            }

            return StringUtils.listToString(lis);
        }

    }

    public enum CondicionIva {

        RESPONSABLE_INSCRIPTO("Responsable Inscripto", 1, true),
        RESPONSABLE_NO_INSCRIPTO("No Responsable Incripto", 2, true),
        NO_RESPONSABLE("No Responsable", 3, false),
        SUJETO_EXENTO("Exento", 4, true),
        CONSUMIDOR_FINAL("Consumidor Final", 5, true),
        RESPONSABLE_MONOTRIBUTO("Monotributo", 6, true),
        SUJETO_NO_CATEGORIZADO("No Categorizado", 7, true),
        PROVEEDOR_DEL_EXTERIOR("Proveedor del Exterior", 8, false),
        CLIENTE_DEL_EXTERIOR("Cliente del Exterior", 9, false),
        IVA_LIBERADO("Iva Liberado", 10, false),
        RESPONSABLE_INSCRIPTO_AGENTE_PERCEPCION("Iva Responsable Incripto Agente Percepcion", 11, false),
        CONSTRIBUYENTE_EVENTUAL("Constribuyente Eventual", 12, false),
        MONOTRIBUTISTA_SOCIAL("Monotributo Social", 13, true),
        CONTRIBUYENTE_EVENTUAL_SOCIAL("Contribuyente Eventual Social", 14, false);

        private final String desdescripcion;
        private final Integer id;
        private final boolean habilitado;
        public static final long DOCUMENTO_SUJETO_NO_CATEGORIZADO = 23000000000L;

        private CondicionIva(String descripcion, Integer id, boolean habilitado) {
            this.desdescripcion = descripcion;
            this.id = id;
            this.habilitado = habilitado;

        }

        /**
         * @return the desdescripcion
         */
        public String getDescripcion() {
            return desdescripcion;
        }

        /**
         * @return the civaId
         */
        public Integer getId() {
            return id;
        }

        /**
         * Busca la CondicionIva por id, si no se encuentra retorna null
         *
         * @param id
         * @return CondicionIva
         */
        public static CondicionIva getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (CondicionIva x : CondicionIva.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }

        /**
         * @return the habilitado
         */
        public boolean isHabilitado() {
            return habilitado;
        }
    }

    public enum EstadoCivil {

        SOLTERO("SOLTERO/A", 49),
        CASADO("CASADO", 50),
        VIUDO("VIUDO", 51),
        SEPARADO_LEGAL("SEPARADO LEGAL", 52),
        SEPERADO_DE_ECHO("SEPARADO DE ECHO", 53),
        DIVORCIADO("DIVORCIADO", 54),
        CONVIVIENTE("CONVIVIENTE", 55);

        private final String descripcion;
        private final int id;

        private EstadoCivil(String des, int id) {
            this.descripcion = des;
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getId() {
            return id;
        }

        /**
         * Busca UnidadMedidas por ID, si no existe retora null
         *
         * @param id
         * @return UnidadMedidas
         */
        public static EstadoCivil getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (EstadoCivil x : EstadoCivil.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }
    }

    public enum UnidadMedidas {

        UNIDADES("UNIDADES", 1),
        MILIGRAMOS("MILIGRAMOS", 2),
        GRAMOS("GRAMOS", 3),
        KILOGRAMOS("KILOGRAMOS", 4),
        MILILITRO("MILILITRO", 5),
        LITRO("LITRO", 6),
        KILOLITRO("KILOLITRO", 7),
        MILIMETRO("MILIMETRO", 8),
        METRO("METRO", 9),
        KILOMETRO("KILOMETRO", 10);

        private final String descripcion;
        private final int id;

        private UnidadMedidas(String des, int id) {
            this.descripcion = des;
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getId() {
            return id;
        }

        /**
         * Busca UnidadMedidas por ID, si no existe retora null
         *
         * @param id
         * @return UnidadMedidas
         */
        public static UnidadMedidas getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (UnidadMedidas x : UnidadMedidas.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }
    }

    public enum TiposIva {

        EXENTO("EXENTO 0 %", 3, new BigDecimal("0")),
        IVA105("IVA 10,50 %", 4, new BigDecimal("10.5")),
        IVA21("IVA 21,00%", 5, new BigDecimal("21")),
        IVA27("IVA 27,00%", 6, new BigDecimal("27")),
        IVA5("IVA 5,00%", 8, new BigDecimal("5")),
        IVA25("IVA 2,50", 9, new BigDecimal("2.5"));

        private final String descripcion;
        private final int id;
        private final BigDecimal porcentaje;

        private TiposIva(String des, int id, BigDecimal porcentaje) {
            this.descripcion = des;
            this.id = id;
            this.porcentaje = porcentaje;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getId() {
            return id;
        }

        public BigDecimal getPorcentaje() {
            return porcentaje;
        }

        /**
         * Busca la TiposIva por ID, si no existe retora null
         *
         * @param id
         * @return TiposIva
         */
        public static TiposIva getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (TiposIva x : TiposIva.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        /**
         * Busca TiposIva por su id, si no encuentra retorna null
         *
         *
         * @param alicuota
         * @return
         */
        public static TiposIva getTiposByAlicuota(BigDecimal alicuota) {
            if (alicuota == null) {
                return null;
            }
            for (TiposIva x : TiposIva.values()) {
                if (alicuota.compareTo(x.getPorcentaje()) == 0) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }
    }
    
//////    public enum GrupoRuta {
//////        GRUPO_RUTA_A,
//////        GRUPO_RUTA_B;
//////
//////        public static GrupoRuta getByOrdinal(Integer grupo) {
//////            for (GrupoRuta g : GrupoRuta.values()) {
//////                if (grupo == g.ordinal()) {
//////                    return g;
//////                }
//////            }
//////            return null;
//////        }
//////    }

    public enum TipoDocumento {

        ACTA_NACIMIENTO(93, "ACTA NACIMIENTO"),
        CDI(87, "CDI"),
        CI_BS_AS_RNP(95, "CI BS. AS. RNP"),
        CI_BUENOS_AIRES(1, "CI BUENOS AIRES"),
        CI_CATAMARCA(2, "CI CATAMARCA"),
        CI_CHACO(16, "CI CHACO"),
        CI_CHUBUT(17, "CI CHUBUT"),
        CI_CORDOBA(3, "CI CORDOBA"),
        CI_CORRIENTES(4, "CI CORRIENTES"),
        CI_ENTRE_RIOS(5, "CI ENTRE R�?OS"),
        CI_EXTRANJERA(91, "CI EXTRANJERA"),
        CI_FORMOSA(18, "CI FORMOSA"),
        CI_JUJUY(6, "CI JUJUY"),
        CI_LA_PAMPA(21, "CI LA PAMPA"),
        CI_LA_RIOJA(8, "CI LA RIOJA"),
        CI_MENDOZA(7, "CI MENDOZA"),
        CI_MISIONES(19, "CI MISIONES"),
        CI_NEUQUEN(20, "CI NEUQUEN"),
        CI_POLICIA_FEDERAL(0, "CI POLICIA FEDERAL"),
        CI_RIO_NEGRO(22, "CI RIO NEGRO"),
        CI_SALTA(9, "CI SALTA"),
        CI_SAN_JUAN(10, "CI SAN JUAN"),
        CI_SAN_LUIS(11, "CI SAN LUIS"),
        CI_SANTA_CRUZ(23, "CI SANTA CRUZ"),
        CI_SANTA_FE(12, "CI SANTA FE"),
        CI_SANTIAGO_DEL_ESTERO(13, "CI SANTIAGO DEL ESTERO"),
        CI_TIERRA_DEL_FUEGO(24, "CI TIERRA DEL FUEGO"),
        CI_TUCUMAN(14, "CI TUCUMAN"),
        CUIL(86, "CUIL"),
        CUIT(80, "CUIT"),
        DNI(96, "DNI"),
        DOC_OTRO(99, "DOC. (OTRO)"),
        EN_TRAMITE(92, "EN TRAMITE"),
        LC(90, "LC"),
        LE(89, "LE"),
        PASAPORTE(94, "PASAPORTE");

        public static TipoDocumento getByDes(String tipoClave) {
            for (TipoDocumento x : TipoDocumento.values()) {
                if (x.getDescripcion().equals(tipoClave)) {
                    return x;
                }
            }
            return null;
        }

        private final String descripcion;
        private final Integer id;

        private TipoDocumento(Integer id, String des) {
            this.id = id;
            this.descripcion = des;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public Integer getId() {
            return id;
        }

        /**
         * Busca la TiposDocumento por ID, si no existe retora null
         *
         * @param id
         * @return the descripcion
         */
        public static TipoDocumento getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (TipoDocumento x : TipoDocumento.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }
    }

    public static enum TipoMedioCobro {
        EFECTIVO, CHEQUE, TARJETA, MUTUAL
    }

    public enum AccionFormulario {

        ALTA, BAJA, MODIFICACION
    }

    public enum TipoCheques {

        PROPIOS(1, "PROPIOS"),
        TERCEROS(2, "TERCEROS");

        private final String descripcion;
        private final Integer id;

        private TipoCheques(Integer id, String des) {
            this.descripcion = des;
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public Integer getId() {
            return id;
        }

        /**
         * Busca por medio de su id, si no encuentra retorna null
         *
         * @param id
         * @return VentasFlags
         */
        public static TipoCheques getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (TipoCheques x : TipoCheques.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return getDescripcion();
        }

    }

}
