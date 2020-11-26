/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.constantes;

import com.sigemp.common.StringUtils;
import com.sigemp.common.exception.SgException;

import java.util.ArrayList;
import java.util.List;

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
    
    private static final StringUtils sc = new StringUtils();

    public static List<Comprobante> getComprobanteListFromString(String lista) {
        List<Comprobante> list = new ArrayList<>();
        if ("".equals(lista)) {
            return list;
        }
        int[] pks = StringUtils.stringToArray(lista);

        for (int x = 0; x < pks.length; x++) {

            Comprobante p = Comprobante.getById(pks[x]);
            if (!list.contains(p)) {
                list.add(p);
            }
        }
        return list;
    }

    public static String getStringFromList(List<Comprobante> list) {
        String sel;
        int size = list.size();
        int[] valores = new int[size];
        for (int x = 0; x < valores.length; x++) {
            valores[x] = list.get(x).getTcId();
        }
        sel = StringUtils.ArrayToString(valores);
        return sel;
    }

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
     * De tipos de comprobante que estan disponibles, siempre elije las facturas
     * prioritariamente
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
        List<Comprobante> tclist = new ArrayList<>();
        for (Comprobante t : Comprobante.values()) {
            if (t.getTipoComprobante().getSistema().equals(grupo)) {
                tclist.add(t);
            }
        }
        return tclist;
    }

    public static List<Comprobante> getComprobantes(TipoComprobante tcg) {
        List<Comprobante> tclist = new ArrayList<>();
        for (Comprobante t : Comprobante.values()) {
            if (t.getTipoComprobante().equals(tcg)) {
                tclist.add(t);
            }
        }
        return tclist;
    }

    /**
     * Este metodo determina si el tipo de comprobante se puede emitir segun la
     * segun la condicion de iva del emisor y comprador
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
        List<Comprobante> list = new ArrayList<>();
        for (Comprobante tc : Comprobante.values()) {
            if (!(tc.getTipoComprobante().equals(tcg) && tc.getTipoComprobante().getSistema().equals(sistema))) {
                continue;
            }
            list.add(tc);

        }
        return list;
    }

    public static List<Comprobante> getComprobantes(Sistema grupo, String buscar) {
        List<Comprobante> tclist = new ArrayList<>();
        String strbus = buscar.trim().toUpperCase();
        boolean bus = strbus.length() != 0;

        for (Comprobante t : Comprobante.values()) {
            if (t.getTipoComprobante().getSistema().equals(grupo)) {
                if (bus && !t.getDescripcion().toUpperCase().contains(strbus)) {
                    continue;
                }
                tclist.add(t);
            }
        }
        return tclist;
    }

    public static String getIdsComprobantesFiscales(TipoComprobante... tipo) {
        return getIdsComprobantesFiscales(FiltroPedidos.TODO, tipo);
    }

    public static String getIdsComprobantesFiscales(FiltroPedidos filtroPedidos, TipoComprobante... tipo) {
        List<Integer> lis = new ArrayList<>();
        List<Comprobante> lisComp = new ArrayList<>();

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
