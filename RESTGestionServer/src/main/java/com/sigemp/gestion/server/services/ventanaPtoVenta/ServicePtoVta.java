/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services.ventanaPtoVenta;

import com.sigemp.common.exception.SgStatusDto;
import com.sigemp.gestion.constants.Comprobante;
import com.sigemp.gestion.constants.Sistema;
import com.sigemp.gestion.constants.TipoSalida;
import com.sigemp.gestion.server.services.*;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.FormatoComprobanteDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.GsyContadorDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.GsySucDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.GsyContadorTipoDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.PtoVtaDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.OpcionesContadorDto;
import com.sigemp.gestion.shared.entity.GsyContadores;
import com.sigemp.gestion.shared.entity.GsyContadorestipos;
import com.sigemp.gestion.shared.entity.GsySuc;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author cristian
 */
@Path("/ptovta")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicePtoVta extends AbstractFacade<GsyTalonarios> {

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public ServicePtoVta() {
        super(GsyTalonarios.class);
    }

    @GET
    @Path("sucursales")
    public Response restFindRange() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(GsySuc.class));
        List<GsySuc> list = getEntityManager().createQuery(cq).getResultList();

        List<GsySucDto> listSucDto = new ArrayList<>();

        for (GsySuc suc : list) {
            GsySucDto lsucDto = new GsySucDto();
            lsucDto.setDes(suc.getDes());
            lsucDto.setSucId(suc.getSucId());

            List<PtoVtaDto> listPtoVta = ptoVtaList(suc.getSucId(), null);
            lsucDto.setPuntosDeVentas(listPtoVta);

            listSucDto.add(lsucDto);
        }

        GenericEntity<List<GsySucDto>> lista = new GenericEntity<List<GsySucDto>>(listSucDto) {
        };
        return Response.ok(lista).build();
    }

    @GET
    @Path("ptovtas")
    public List<PtoVtaDto> restPtoVtaList(@QueryParam("sucId") Integer sucId, @QueryParam("des") String des) {
        return ptoVtaList(sucId, des);
    }

    public List<PtoVtaDto> ptoVtaList(Integer sucId, String des) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery();

        //Metamodel m = em.getMetamodel();
        //EntityType<GsyTalonarios> Pet_ = m.entity(GsyTalonarios.class);
        Root<GsyTalonarios> pet = cq.from(GsyTalonarios.class);

        if (sucId != null) {
            cq.where(cb.equal(pet.get("depoId").get("sucId").get("sucId"), sucId));
        }
        if (des != null) {
            cq.where(cb.like(pet.get("des"), "%" + des.trim().toUpperCase() + "%"));
//            cq.where(cb.equal(pet.get("des"),des.trim().toUpperCase()));
        }

        List<GsyTalonarios> listTalonarios = getEntityManager().createQuery(cq).getResultList();;

        List<PtoVtaDto> listDto = new ArrayList<>();
        for (GsyTalonarios gsyTalonarios : listTalonarios) {
            PtoVtaDto dto = new PtoVtaDto();
            dto.setDes(gsyTalonarios.getDes());
            dto.setPtoVta(gsyTalonarios.getTalId());
            

            dto.setContadores(contadorList(gsyTalonarios.getTalId()));

            listDto.add(dto);
        }

        return listDto;
    }

    public List<GsyContadorDto> contadorList(Integer ptoVta) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery();

        //Metamodel m = em.getMetamodel();
        //EntityType<GsyTalonarios> Pet_ = m.entity(GsyTalonarios.class);
        Root<GsyContadores> pet = cq.from(GsyContadores.class);

        if (ptoVta != null) {
            cq.where(cb.equal(pet.get("talId").get("talId"), ptoVta));
        }

        List<GsyContadores> listContadores = getEntityManager().createQuery(cq).getResultList();

        List<GsyContadorDto> listDto = new ArrayList<>();
        for (GsyContadores contador : listContadores) {
            GsyContadorDto dto = new GsyContadorDto();
            dto.setContadorId(contador.getConId());
            dto.setDes(contador.getDes());

            dto.setTiposComprobantes(contadoresTipoList(dto.getContadorId()));

            listDto.add(dto);
        }

        return listDto;
    }

    /**
     * Retorna una estructura con los Puntos de ventas,sus contadores y
     * comprobantes
     *
     * @param contadorId
     * @return
     */
    public List<GsyContadorTipoDto> contadoresTipoList(Integer contadorId) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery();

        //Metamodel m = em.getMetamodel();
        //EntityType<GsyTalonarios> Pet_ = m.entity(GsyTalonarios.class);
        Root<GsyContadorestipos> contadores = cq.from(GsyContadorestipos.class);

        if (contadorId != null) {
            cq.where(cb.equal(contadores.get("conId").get("conId"), contadorId));
        }

        List<GsyContadorestipos> listContadores = getEntityManager().createQuery(cq).getResultList();;

        List<GsyContadorTipoDto> listDto = new ArrayList<>();
        for (GsyContadorestipos contador : listContadores) {
            GsyContadorTipoDto dto = new GsyContadorTipoDto();
            dto.setTipoId(contador.getTipoId());
            dto.setTcId(contador.getTcId().getTcId());
            dto.setDes(contador.getTcId().getDes());
            listDto.add(dto);
        }

        return listDto;
    }

    @GET
    @Path("opcionesContador")
    public Response restOpconesContador(@QueryParam("tipoContador") String tipoContador) {

        if (tipoContador == null) {
            Status res = Response.Status.BAD_REQUEST;
            SgStatusDto status = new SgStatusDto("error", res.getStatusCode(), "Requiere argumento");
            return Response.status(res).entity(status).build();
        }
        Sistema sistema = null;
        try {
            sistema = Sistema.valueOf(tipoContador);
        } catch (IllegalArgumentException e) {
            Status res = Response.Status.BAD_REQUEST;
            SgStatusDto status = new SgStatusDto("error", res.getStatusCode(), "Parametro invalido. Requere:" + Sistema.getNames());
            return Response.status(res).entity(status).build();
        }

        OpcionesContadorDto opcionesContador = new OpcionesContadorDto();

        // leo los comprobantes y los agrego 
        // AbstractComprobante
        FormatoComprobanteDto f = new FormatoComprobanteDto(1, "Formato dinamico 1", TipoSalida.GRAFICA.getId());
        FormatoComprobanteDto f2 = new FormatoComprobanteDto(2, "Formato dinamico 2", TipoSalida.GRAFICA.getId());
        List<FormatoComprobanteDto> lisFormatoComprobantes = new ArrayList<>();
        lisFormatoComprobantes.add(f);
        lisFormatoComprobantes.add(f2);

        opcionesContador.setFormatoImpresion(lisFormatoComprobantes);
        opcionesContador.setFormatoVistaPrevia(lisFormatoComprobantes);

        List<Comprobante> listComprobante = Comprobante.getComprobantes(sistema);
        List<Integer> listComprobantes = new ArrayList<>();

        for (Comprobante c : listComprobante) {

            listComprobantes.add(c.getTcId());
        }

        opcionesContador.setComprobantes(listComprobantes);
        return Response.ok().entity(opcionesContador).build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
