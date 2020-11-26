/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ajustes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.sigemp.gestion.client.activity.ventas.busquedas.PanelBusquedaPersonas;
import com.sigemp.gestion.client.api.Menu;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.client.api.interfaces.PanelActivity;
import com.sigemp.gestion.client.api.interfaces.PanelActivityInterface;
import com.sigemp.gestion.client.api.ui.SgButton;
import com.sigemp.gestion.client.api.ui.Toast;
import com.sigemp.gestion.client.constantes.ConstantesComprobantes.*;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.client.service.GsyParamsService;
import com.sigemp.gestion.client.service.GsyPersService;
import com.sigemp.gestion.client.service.GsyProvService;
import com.sigemp.gestion.shared.entity.GsyPers;
import com.sigemp.gestion.shared.entity.GsyProv;
import com.sigemp.gestion.shared.dto.PersonasDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 *
 * @author Server
 */
public class ActivityAjustes extends PanelActivity {

    private boolean init = false;
    private HandlerManager eventBus;

    private void bind() {
        paramService = GWT.create(GsyParamsService.class);
        gsyProvService = GWT.create(GsyProvService.class);
        serviceGsyServ = GWT.create(GsyPersService.class);
        crearMenu();

        widgetContainer = uiBinder.createAndBindUi(this);

        inicializar();

        init = true;
    }

    interface Binder extends UiBinder<Widget, ActivityAjustes> {
    }

    private static final Binder uiBinder = GWT.create(Binder.class);

    GsyParamsService paramService;
    GsyProvService gsyProvService;
    private static GsyPersService serviceGsyServ;

    private PanelActivityInterface panelActivityParent;

    private Widget widgetContainer;
    private Context context;

    private final String activityId = "0001";

    private final ResourcesImage image = ResourcesImage.INSTANCE;

    static final Logger LOGGER = Logger.getLogger(ActivityAjustes.class.getName());

    // Panel con botones de comando
    private HorizontalPanel toolbar;

    @UiField
    TextBox nombreEmpresa;

    @UiField
    TextBox direccion;

    @UiField
    TextBox cuit;

    @UiField
    ListBox condicionIva;

    @UiField
    TextBox nombrefantacia;

    @UiField
    TextBox ingresosBrutos;

    @UiField
    DateBox fechaInicioActividades;

    @UiField
    TextBox telefono;

    @UiField
    TextBox email;

    @UiField
    CheckBox agenteDePercepcionIIBB;

    @UiField
    TextBox porcentajePercepcionIIBB;

    @UiField
    CheckBox agenteDePercepcionMunicipal;

    @UiField
    TextBox porcentajePercepcionMunicipal;

    @UiField
    Button buttonSubirLogo;

    @UiField
    HTMLPanel panelLogo;

    @UiField
    ListBox estadoCivilList;

    @UiField
    ListBox tipoDocumentoList;

    @UiField
    ListBox condicionIvaList;

    @UiField
    ListBox provinciaList;

    @UiField
    ListBox localidadList;

    @UiField
    ListBox condicionDePagoList;

    @UiField
    ListBox vendedorList;

    @UiField
    ListBox medioDePagoList;

    @UiField
    ListBox estadoCuentaList;

    @UiField
    CheckBox autonumerarCuentasCorrientes;

    @UiField
    TextBox tazaDirectaMensual;

    @UiField
    TextBox codigoServicioFinanciero;

    @UiField
    TextBox comprobanteCntItemsPorFactura;

    @UiField
    CheckBox comprobanteModoSupermercado;

    @UiField
    CheckBox comprobantePermitirFacturasPendientes;

    @UiField
    CheckBox comprobanteFormasDePagoPredefinidasPorLaCuenta;

    @UiField
    CheckBox comprobanteNoHacerFocoAutomaticoEnDescuento;

    @UiField
    TextBox comprobanteCodigoCuentaPorOmision;

    @UiField
    Label comprobanteCodigoCuentaPorOmisionDes;

    @UiField
    TextBox preventaCarpetaFTP;

    @UiField
    TextBox preventaDDNS;

    @UiField
    ListBox preventaRutaPredefinida;

    @UiField
    ListBox preventaTipoNegocio;

    @UiField
    ListBox preventaSalidaFacturas;

    @UiField
    ListBox preventaSalidaParaListados;

    @UiField
    TextBox preventaCantidadCopias;

    @UiField
    CheckBox preventaImprimirFechaYHoraListadoEntrega;

    @UiField
    ListBox preventaCondicionPago;

    @UiField
    CheckBox preventaPrioridadPrecioPreventa;

    @UiField
    CheckBox preventaHabilitarGPS;

    @UiField
    CheckBox preventaHabilitarRutaB;

    @UiField
    TextBox stockValorOmisionProveedor;

    @UiField
    ListBox stockMarca;

    @UiField
    ListBox stockTipoIva;

    @UiField
    ListBox stockRubro;

    @UiField
    CheckBox stockGestionarUnidadMedida;

    @UiField
    ListBox stockUnidadMedida;

    @UiField
    CheckBox stockAdministraUnidades;

    @UiField
    CheckBox stockAdministraCajas;

    @UiField
    CheckBox stockAutonumerarArticulos;

    @UiField
    ListBox stockSistemaCalculoPrecio;

    @UiField
    ListBox stockActividadOmision;

    @UiField
    TextBox stockCantidadItemsArticulos;

    @UiField
    TextBox codigoMora;

    @UiField
    TabLayoutPanel tabPanel;

    private void inicializar() {
        fechaInicioActividades.getDatePicker().setYearAndMonthDropdownVisible(true);
        fechaInicioActividades.getDatePicker().setYearAndMonthDropdownVisible(true);
        fechaInicioActividades.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));

        for (CondicionIva o : CondicionIva.values()) {
            condicionIva.addItem(o.getDescripcion());
        }

        for (TiposIva o : TiposIva.values()) {
            stockTipoIva.addItem(o.getDescripcion());
        }

        for (EstadoCivil o : EstadoCivil.values()) {
            estadoCivilList.addItem(o.getDescripcion());
        }

        for (TipoDocumento o : TipoDocumento.values()) {
            tipoDocumentoList.addItem(o.getDescripcion());
        }

        for (CondicionIva o : CondicionIva.values()) {
            condicionIvaList.addItem(o.getDescripcion());
        }

        updateRemoteList();

        comprobanteCodigoCuentaPorOmision.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    buscarCuenta(comprobanteCodigoCuentaPorOmision.getText());

                }
            }

        });
    }

    private void buscarCuenta(String text) {

        if (text.matches("[0-9]+")) {
            GWT.log("contiene numeros");
            comprobanteCodigoCuentaPorOmision.setText(text);

            Long val = Long.valueOf(text.trim());

            serviceGsyServ.find(val, new MethodCallback<GsyPers>() {
                @Override
                public void onFailure(Method method, Throwable exception) {
                    String a = "";
                    if (exception.getMessage() != null) {
                        a = exception.getMessage() + " " + exception.getLocalizedMessage();

                    }
                    comprobanteCodigoCuentaPorOmisionDes.setText("No existe la persona..." + method.getResponse().getStatusCode() + "  " + a);

                }

                @Override
                public void onSuccess(Method method, GsyPers response) {
                    comprobanteCodigoCuentaPorOmisionDes.setText(response.getNom());
                }
            });
        } else {
            PanelBusquedaPersonas panelBusqueda = new PanelBusquedaPersonas();
            // texto a buscar
            panelBusqueda.setTextToFind(text);
            panelBusqueda.addCloseEvent((Object o) -> {
                PersonasDto per = (PersonasDto) o;
                // llamo nuevamente al metodo pero con el codigo seleccionado
                buscarCuenta(per.getCtaId().toString());
            });
            panelBusqueda.show();
        }

    }

    public ActivityAjustes() {
        Menu menu = getOption();
        menu.setDescripcion("Ajustes");
        menu.setGrupo(Constantes.MENU_SISTEMAS.CONFIGURACION.getDescripcion());

    }

    @Override
    public String getId() {
        return activityId;
    }

    private void crearMenu() {
        Image i = new Image(image.fromActualizar());
        SgButton btUpdate = new SgButton(image.fromActualizar(), "Actualizar");

        btUpdate.addClickHandler((ClickEvent event) -> {
            updateRemoteList();
            updateParams();
        });

        SgButton btNew = new SgButton(image.formGuardar(), "Guardar Cambios");
        btNew.addClickHandler((ClickEvent event) -> {

        });

        toolbar = new HorizontalPanel();
        toolbar.add(btUpdate);
        toolbar.add(btNew);

    }

    @Override
    public void onInitialize(Context context, HandlerManager eventBus) {
        this.context = context;
        this.eventBus = eventBus;

        if (!init) {
            bind();
        }

    }

    @Override
    public Widget getToolMenu() {
        return toolbar;
    }

    @Override
    public Widget getMainPanel() {
        return widgetContainer;
    }

    private void updateRemoteList() {
        gsyProvService.findAll(new MethodCallback<List<GsyProv>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {

            }

            @Override
            public void onSuccess(Method method, List<GsyProv> list) {
                provinciaList.clear();
                list.forEach((anObject) -> {
                    provinciaList.addItem(anObject.getDes(), anObject.getDes());
                });
                Toast.show("Fin Actualizacion Parametros");
            }
        });
    }

    private void updateParams() {
        // pedido de Parametros
        ArrayList<String> list = new ArrayList<>();
        list.add("general.percepcion.municipal.catamarca");
        list.add("general.percepcion.municipal.catamarca.porcentaje");

        paramService.getParametros(list, new MethodCallback<Map<String, String>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {

            }

            @Override
            public void onSuccess(Method method, Map<String, String> response) {
                Toast.show("Fin Actualizacion Parametros");
            }
        });
    }
}
