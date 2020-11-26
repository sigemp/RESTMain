/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.entity.controladores;


import com.sigemp.gestion.client.constantes.ConstantesComprobantes;
import com.sigemp.gestion.client.constantes.ConstantesComprobantes.Comprobante;
import com.sigemp.gestion.client.constantes.ConstantesComprobantes.TipoComprobante;
import com.sigemp.gestion.shared.entity.constantes.FiltroPedidos;
import com.sigemp.gestion.shared.entity.constantes.FiltroQuery;
import com.sigemp.gestion.shared.dto.ListadoDeVentasDto;
import com.sigemp.server.util.DateUtils;
import com.sigemp.server.util.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author sigem
 */
public class ControladorVtaVta extends BaseControladores {

    private EntityManager em = null;
    
    private static final Logger LOG = Logger.getLogger(ControladorVtaVta.class.getName());

    public ControladorVtaVta(EntityManager em) {
        this.em = em;
    }

    public List<ListadoDeVentasDto> getDataVta(Map<String, String> map) {
        try (Connection con = getConnection()) {

            //SimpleDateFormat df = new SimpleDateFormat(Formats.DATE.getFormat());

            String sFecDesde = map.get("FECHADESDE");
            String sFecHasta = map.get("FECHAHASTA");

            Date pFecDesde = null;

            Date pFecHasta = null;

            if (sFecDesde != null) {
                pFecDesde = Date.from(Instant.parse(sFecDesde));
            }

            if (sFecHasta != null) {
                pFecHasta = Date.from(Instant.parse(sFecHasta));
            }

            List<ListadoDeVentasDto> list = new ArrayList<>();

            String sql;

            String where = " AND vta_vta.fec::date between '" + DateUtils.toDateDB(pFecDesde) + "' and '" + DateUtils.toDateDB(pFecHasta) + "'";

            String depositos = (String) map.get("DEPOSITOS_LIST");

            if (depositos != null && depositos.trim().length() > 0) {
                where += " AND vta_vta.depo_id in (" + depositos + ") \n";
            }

            FiltroPedidos filtroPedidos = FiltroPedidos.FACTURAS;

            String sFiltroPedidos = map.get(FiltroQuery.FILTRO_TIPO_COMPROBANTE.name());
            if (sFiltroPedidos != null) {
                filtroPedidos = FiltroPedidos.valueOf(sFiltroPedidos);

            }
            String comprobantes = Comprobante.getIdsComprobantesFiscales(filtroPedidos, TipoComprobante.NOTA_CREDITO, TipoComprobante.FACTURA, TipoComprobante.NOTA_DEBITO);

            where += " AND vta_vta.tc_id in (" + comprobantes + ") ";

            String notasCredito = ConstantesComprobantes.Comprobante.getIdsComprobantesFiscales(filtroPedidos, ConstantesComprobantes.TipoComprobante.NOTA_CREDITO);

            //con.setAutoCommit(false);
            Statement sta2 = con.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE); // para coorrer los execute

            sql = ""
                    + "drop table if exists tmp_listado_ventas;\n"
                    + "\n"
                    + "\n"
                    + "create temp table tmp_listado_ventas as (\n"
                    + "select vta_vta.cta_id,\n"
                    + "       gsy_pers.nom,\n"
                    + "       gsy_pers.nroident,\n"
                    + "       vta_vta.cpg_id || '-' || vta_cpg.des as cpg,\n"
                    + "       vta_vta.fec,\n"
                    + "       vta_vta.tc_id,\n"
                    + "       invertir(vta_vta.tc_id,1) as debcre,\n" // Debito o Credito (Se usa para sumar en el reporte
                    + "       vta_vta.ptovta,\n"
                    + "       vta_vta.num,\n"
                    + "       (case when vta_vta.tc_id in ( " + notasCredito + ") then vta_vta.tot_neto * -1 else vta_vta.tot_neto end) tot_neto,\n"
                    + "       (case when vta_vta.tc_id in ( " + notasCredito + ") then vta_vta.tot_iva * -1 else vta_vta.tot_iva end) tot_iva,\n"
                    + "       (case when vta_vta.tc_id in ( " + notasCredito + ") then vta_vta.tot_tributo * -1 else vta_vta.tot_tributo end) tot_tributo,\n"
                    + "       (case when vta_vta.tc_id in ( " + notasCredito + ") then vta_vta.tot * -1 else vta_vta.tot end) tot,\n"
                    + "       vta_vta.ven_id,\n"
                    + "       vta_vta.usr_id,\n"
                    + "       vta_vta.cuotas,\n"
                    + "       vta_ven.nom as nomven,\n"
                    + "       gsy_user.nick\n"
                    + "  from vta_vta,gsy_pers,vta_ven,gsy_user,vta_cpg\n"
                    + " where vta_vta.cta_id = gsy_pers.pers_id\n"
                    + "   and vta_vta.cpg_id = vta_cpg.cpg_id\n"
                    + "   and vta_vta.usr_id = gsy_user.usr_id\n"
                    + "   and vta_vta.ven_id = vta_ven.ven_id\n"
                    + where + "\n"
                    + "order by vta_vta.tc_id,vta_vta.num asc\n"
                    + ");\n"
                    + "\n"
                    + "";

            LOG.info(sql);
            sta2.execute(sql);

            ResultSet rs = sta2.executeQuery("select * from tmp_listado_ventas");

            while (rs.next()) {
                ListadoDeVentasDto dto = new ListadoDeVentasDto();

                ConstantesComprobantes.Comprobante comprobante = ConstantesComprobantes.Comprobante.getById(rs.getInt(6));
                Integer ptoVta = rs.getInt(8);
                Integer numer = rs.getInt(9);

                String num = Util.formatear(comprobante.getAbr(), ptoVta, numer);

                dto.setComprobante(comprobante);
                dto.setNumero(num);

                dto.setCtaId(rs.getLong(1));
                dto.setNom(rs.getString(2));
                dto.setNroIdent(rs.getLong(3));
                dto.setCondicionPago(rs.getString(4));
                dto.setFec(rs.getDate(5));
                dto.setTotNeto(rs.getBigDecimal(10));
                dto.setTotIva(rs.getBigDecimal(11));
                dto.setTotTributos(rs.getBigDecimal(12));
                dto.setTotal(rs.getBigDecimal(13));
                dto.setDebitoCredito(rs.getBigDecimal(7));

                dto.setVenId(rs.getInt(15));
                dto.setUsrId(rs.getInt(15));
                dto.setCuotas(rs.getInt(16));
                dto.setNomVendedor(rs.getString(17));
                dto.setNick(rs.getString(18));

                list.add(dto);
            }

            //con.commit();
            //con.setAutoCommit(true);
            return list;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } 
        return null;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
