/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class Toast extends Thread {

    private static final Logger LOG = Logger.getLogger(Toast.class.getName());
    // Esta lista tiene todos los toas que se van activando.
    // queda la referencia para poder pararlos.
    private static final List<Thread> VIEW_LIST = new ArrayList<>();

    public static void show(String message) {
        //JComponent component = MenuInicio.getjDesktopPane();
        //Point location = component.getLocationOnScreen();
        Point location = new Point(0, 0);
        new Toast(null, location, message, 3000).show();
    }

    public static void showToastDownComponent(String message) {
        showToastDownComponent(null, message);
    }

    public static void showToastDownComponent(JComponent component, String message) {
        Point tmpLocation = new Point(0, 40);
        if (component != null) {
            tmpLocation.y = component.getHeight() + 5;
            tmpLocation.x = tmpLocation.x + 30;
        }
        showToastDownComponent(component, message, tmpLocation, 2000/*Default 2 Sec*/);
    }

    public static void showToastDownComponent(JComponent component, String message, Point location, long forDuration) {
        new Toast(component, location, message, forDuration).show();
    }
    private final ViewToast thread;

    private Toast(JComponent comp, Point toastLocation, String msg, long forDuration) {
        pararToast();
        thread = new ViewToast(comp, toastLocation, msg, forDuration);
        VIEW_LIST.add(thread);
    }

    public void show() {
        thread.start();
    }

    private static void pararToast() {
        Iterator i = VIEW_LIST.iterator();
        while (i.hasNext()) {
            ViewToast p = (ViewToast) i.next();
            if (p != null) {
                p.parar();
                i.remove();
            }
        }
    }

    class ViewToast extends Thread {

        private final JComponent component;
        private final long duration;
        //private boolean hide = false;
        private final Point location;
        private final String message;
        private final Popup view;

        public ViewToast(JComponent comp, Point toastLocation, String msg, long forDuration) {
            super("Toast Message");
            this.component = comp;
            this.location = toastLocation;
            this.message = msg;
            this.duration = forDuration;
            Label tip = new Label(message);
            tip.setForeground(Color.WHITE);
            tip.setBackground(Color.BLUE);
            tip.setSize(tip.getHeight(), 30);
            tip.setFont(new Font("Verdana", Font.BOLD, 20));

            //view = PopupFactory.getSharedInstance().getPopup(component, tip, 10, 10);
            view = PopupFactory.getSharedInstance().getPopup(component, tip, location.x, location.y);
            //view = ReflectUtils.callMethodSafely ( PopupFactory.getSharedInstance (), "getPopup", component, tip, location.x,location.y, 2 );

        }

        public void parar() {
            if (view != null) {
                Popup a = view;
                javax.swing.SwingUtilities.invokeLater(a::hide);

            }
        }

        @Override
        public void run() {

            try {
                //
                //JPanel panel = new JPanel();
                //panel.setBackground(Color.GRAY);
                //panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
                //

                view.show();
                Thread.sleep(duration);
            } catch (NullPointerException | InterruptedException ex) {
                LOG.log(Level.INFO, ex.getMessage(), ex);
            } finally {
                parar();
            }
        }

    }

}
