/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sigemp.gestion.client.activity.ventas.popup.RegisterUserPopup;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.client.api.interfaces.PanelActivityInterface;
import com.sigemp.gestion.client.api.menu.SgGrupo;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.shared.entity.GsyUser;
import java.util.List;

/**
 * Administra la aplicacion
 *
 * @author Server
 */
public class SGMainScreen {

    private final HandlerManager eventBus;
    private final Context context;

    interface SGMainScreenBinder extends UiBinder<DockLayoutPanel, SGMainScreen> {
    }

    private static SGMainScreenBinder uiBinder = GWT.create(SGMainScreenBinder.class);

    String userData;

    Image userImage;

    String systemTitle;

    @UiField
    DockLayoutPanel mainPanel;

    // Tiene el ToolBar
    @UiField
    HorizontalPanel toolBar;

    @UiField
    HorizontalPanel activityContainter;

    @UiField
    LayoutPanel borderMenu;

    @UiField
    HorizontalPanel panelUsuario;

    @UiField
    HorizontalPanel panelLogo;

    StackLayoutPanel menuPanel;

    private static SGMainScreen sgManager;

    public static SGMainScreen getInstance() {
        if (sgManager == null) {
            sgManager = new SGMainScreen();
        }
        return sgManager;
    }

    /**
     * Muestra la actividad
     *
     *
     * @param activity
     */
    public void showActibity(PanelActivityInterface activity) {

        toolBar.clear();
        activityContainter.clear();

        
        //inicializa la actividad
        activity.onInitialize(context,eventBus);

        activityContainter.add(activity.getMainPanel());
        if (activity.getToolMenu() != null) {
            toolBar.add(activity.getToolMenu());
        }
        

    }

    private StackLayoutPanel createMenu() {
        // creo menu
        StackLayoutPanel stackPanel = new StackLayoutPanel(Style.Unit.EM);

        SGSistemMenu sm = SGSistemMenu.getInstance();

        List<SgGrupo> menu = sm.getMenusList();

        for (SgGrupo m : menu) {

            //List<SGMenuItem> listMenus = sm.getItems(m);
            List<PanelActivityInterface> listMenus = m.getActivityList();
            if (!listMenus.isEmpty()) {

                // Create the list of contacts
                VerticalPanel panelOpciones = new VerticalPanel();
                panelOpciones.setSpacing(4);
                panelOpciones.setWidth("100%");

                for (PanelActivityInterface mi : listMenus) {

                    Menu mm = mi.getOption();

                    // Agrego Opcion Item
                    Widget opcion = createOption(mm.getIcon(), mm.getDescripcion(), mi);
                    panelOpciones.add(opcion);

                }
                SimplePanel sp = new SimplePanel(panelOpciones);
                Widget contactsHeader = getHeader(m.getDescripcion());

                stackPanel.add(sp, contactsHeader, 4);

            }

        }

        return stackPanel;
    }

    /**
     * Muestra la Actividad
     *
     * @param Id
     */
    public void showActibity(String Id) {

        PanelActivityInterface activity = SGSistemMenu.getInstance().findById(Id);
        if (activity == null) {
            return;
        }
        showActibity(activity);

    }

    private SGMainScreen() {
        mainPanel = uiBinder.createAndBindUi(this);
        
        eventBus = new HandlerManager(null);
        
        context = ContextImp.getInstance();

        borderMenu.add(createMenu());
        
        createHeader();

    }

    /**
     * Retorna el panel principal de la aplicacion
     *
     * @return
     */
    public Widget getMainPanel() {
        return mainPanel;
    }

    void cleanContentActivity() {
        toolBar.clear();
        activityContainter.clear();
    }

    /**
     * Crea el ItemMenu, con la actividad asociada
     *
     *
     * @param icon
     * @param descripcion
     * @param panelAcivity
     * @return
     */
    private Widget createOption(ImageResource icon, String descripcion, PanelActivityInterface panelAcivity) {
        Image imgSinIcon= new Image(ResourcesImage.INSTANCE.submenuIcon());
        
        HorizontalPanel penelOpcion = new HorizontalPanel();
        penelOpcion.setStyleName("sg-SgOptionMenu");
        penelOpcion.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        penelOpcion.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        penelOpcion.setHeight("20px");
        //penelOpcion.setWidth("25px");
        

        //penelOpcion.setSpacing(4);

        SimplePanel sp = new SimplePanel();
        sp.getElement().setAttribute("Style", "width: 25px;");
        // Agrego el Icono        
        sp.add(icon != null ? new Image(icon): imgSinIcon);
        penelOpcion.add(sp);

        Anchor opt = new Anchor(descripcion);
        opt.getElement().setAttribute("style", "width: 100%;font-weight: 500;font-size: small;font-family: 'Open Sans', sans-serif;");

        penelOpcion.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        penelOpcion.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        penelOpcion.setWidth("100%;");
        penelOpcion.add(opt);

        penelOpcion.setCellWidth(opt,"100%");
        penelOpcion.setCellWidth(sp,"25px");
        
        final PanelActivityInterface a = panelAcivity;

        opt.addClickHandler((ClickEvent event) -> {
            ContextImp.getInstance().getScreenDrive().showActibity(a);
        });
        return penelOpcion;
    }
////        private Widget createOption(ImageResource icon, String descripcion, PanelActivityInterface panelAcivity) {
////        HorizontalPanel penelOpcion = new HorizontalPanel();
////        //penelOpcion.getElement().getStyle().setTextAlign(TextAlign.CENTER);
////        //penelOpcion.getElement().getStyle().setProperty("margin", "0 auto");
////        penelOpcion.setStyleName("sg-SgOptionMenu");
////        penelOpcion.setHeight("20px");
////        penelOpcion.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
////        //penelOpcion.setSpacing(4);
////        Anchor opt = new Anchor(descripcion);
////
////        SimplePanel s = new SimplePanel();
////        s.getElement().setAttribute("Style", "width: 25px;");
////        // Agrego el Icono        
////        if (icon != null) {
////            s.add(new Image(icon));
////
////        } else {
////            s.add(new Image(ResourcesImage.INSTANCE.submenuIcon()));
////        }
////        penelOpcion.add(s);
////
////        opt.getElement().setAttribute("style", "font-weight: 500;font-size: small;font-family: 'Open Sans', sans-serif;");
////        penelOpcion.add(opt);
////
////        final PanelActivityInterface a = panelAcivity;
////
////        opt.addClickHandler((ClickEvent event) -> {
////            ContextImp.getInstance().getScreenDrive().showActibity(a);
////        });
////        return penelOpcion;
////    }


    private Widget getHeader(String text) {

        // Add the image and text to a horizontal panel
        HorizontalPanel hPanel = new HorizontalPanel();
////        if (image !=null)
////        hPanel.add(new Image(image));
        hPanel.add(new Image(ResourcesImage.INSTANCE.contact()));
        HTML headerText = new HTML(text);
        //headerText.setStyleName("cw-StackPanelHeader");
        hPanel.add(headerText);
        return new SimplePanel(hPanel);
    }

    /**
     * retorna la Cabezera de la aplicacion
     *
     *
     * @return
     */
    private void createHeader() {

        systemTitle = "TITULO SISTEMA";
        String userName = "sin usuario";
        userData = "sin usuario";

        HTML headerText = new HTML(systemTitle);
        headerText.setStyleName("sg-AppTitulo");

        panelLogo.add(new Image(ResourcesImage.INSTANCE.logoApp()));
        panelLogo.add(headerText);

        Image userAjustes = new Image(ResourcesImage.INSTANCE.ajustes());
        userAjustes.setTitle("Ajustes del Sistema");

        userAjustes.addClickHandler((ClickEvent event) -> {
            ContextImp.getInstance().getScreenDrive().showActibity("0001");
        });

        userImage = new Image(ResourcesImage.INSTANCE.getFotoPerfilVacia());
        userImage.setSize("25px", "25px");

        Image userLogout = new Image(ResourcesImage.INSTANCE.logout());
        userLogout.setTitle("Cerrar Session");

        userLogout.addClickHandler((ClickEvent event) -> {
            ContextImp.getInstance().getSecurity().logout();
        });

        panelUsuario.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panelUsuario.add(userAjustes);
        panelUsuario.add(userImage);
        panelUsuario.add(userLogout);

        userImage.addClickHandler((ClickEvent event) -> {
            RegisterUserPopup.showPopup(panelUsuario.getAbsoluteTop() + panelUsuario.getOffsetHeight());
        });

        userImage.setTitle(userData);
    }
    
     public void setUpdateUser() {
        GsyUser user = context.getSecurity().getUser();
        if (user == null) {
            return;
        }
        //usuarioOpcion.setText(user.getNick());
        userData = "Nick:" + user.getNick() + "\n" + "Nombre:" + user.getNom();
        userImage.setResource(context.getSecurity().getImageUser());
        userImage.setTitle(userData);
    }

}
