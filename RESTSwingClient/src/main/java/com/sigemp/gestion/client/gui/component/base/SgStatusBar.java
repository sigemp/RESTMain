/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component.base;

import com.sigemp.gestion.client.gui.component.SgImage;
import com.sigemp.gestion.client.services.Session;
import com.sigemp.gestion.client.services.SessionListener;
import com.sigemp.gestion.client.services.SessionListener.STATUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 *
 * @author sigem
 */
public class SgStatusBar implements ContainerListener {

    private static final Logger LOG = Logger.getLogger(SgStatusBar.class.getName());

    private final JPanel container;
    private final JPanel iconsBar;
    private final ImageIcon connectIcon;
    private final ImageIcon disconnectIcon;

    public SgStatusBar() {
        super();

        container = new PanelFondo();

        container.setOpaque(false);
        container.setLayout(new BorderLayout(2, 2));

        iconsBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        iconsBar.setOpaque(false);

        JProgressBar barrMemory = new JProgressBar();
        barrMemory.setPreferredSize(new Dimension(100, 35));
        barrMemory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 2) {
                    System.gc();
                }
            }
        });

        ///////
        JLabel connecStatus = new JLabel();
        connecStatus.setOpaque(true);
        connectIcon = SgImage.CONNECTION_ICON.getImage(SgImage.SIZES.S30);
        disconnectIcon = SgImage.CONNECTION_LOSS_ICON.getImage(SgImage.SIZES.S30);
        connecStatus.setIcon(disconnectIcon);
        connecStatus.setPreferredSize(new Dimension(33, 33));
        connecStatus.setHorizontalAlignment(SwingConstants.CENTER);
        connecStatus.setVerticalAlignment(SwingConstants.CENTER);
        
        Session.getInstance().addTableButtonListener((SessionListener.STATUS status) -> {
            if (status == STATUS.DISCONNECTED) {
                connecStatus.setIcon(disconnectIcon);
                connecStatus.setToolTipText("Desconectado");
            } else {
                connecStatus.setIcon(connectIcon);
                connecStatus.setToolTipText("Conectado");
            }
        });
        //////
        JPanel conenedor2 = new JPanel();
        conenedor2.setOpaque(false);
        

        
        conenedor2.add(barrMemory, BorderLayout.WEST);
        conenedor2.add(connecStatus, BorderLayout.EAST);
        
        container.add(iconsBar, BorderLayout.WEST);
        container.add(conenedor2, BorderLayout.EAST);

        new InspectorMemoria(barrMemory).start();

    }

    public JPanel getContainer() {
        return container;
    }

    @Override
    public void componentAdded(ContainerEvent e) {
        LOG.log(Level.INFO, "Agregando {0}", e.getChild().getClass().getName());
        if (e.getChild() instanceof SgJInternalFrame) {
            SgIconed sgIconed = new SgIconed((SgJInternalFrame) e.getChild());

            iconsBar.add(sgIconed);
        }
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        LOG.log(Level.INFO, "Cerrando {0}", e.getChild().getClass().getName());
        for (Component c : iconsBar.getComponents()) {
            if (c instanceof SgIconed) {
                SgIconed si = ((SgIconed) c);
                if (si.getSgJInternalFrame().equals(e.getChild())) {
                    iconsBar.remove(c);
                }
            }

        }
    }

    class PanelFondo extends JPanel {

        @Override
        public void paint(Graphics g) {
////        Graphics2D g2 = (Graphics2D) g;
////        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
////        Paint oldPaint = g2.getPaint();
////        g2.setPaint(new GradientPaint(0.0f, 0.0f, getColorPrimario().darker(),0.0f, getHeight(), getColorSecundario().darker()));
////        g2.fillRect(0, 0, getWidth(), getHeight());
////        g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 18, 18);
////        g2.setPaint(oldPaint);
////        super.paint(g2);

            Graphics2D g2D = (Graphics2D) g;
//g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_ANTIALIAS_ON));
//g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
            g2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            g2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
            g2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);

            Paint oldPaint = g2D.getPaint();
            BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_3BYTE_BGR);//se va a componer de un rectangulo y de un ovalo
            Graphics2D big = bi.createGraphics();
            big.setPaint(new GradientPaint(0.0f, 0.0f, new Color(0x66707f).darker(), 3.0f, 10f, new Color(0x262d3d).darker()));
//       big.setPaint(new GradientPaint(0.0f, 0.0f, new Color(0x666f7f).darker(), 3.0f, 10f, new Color(0x90667f).darker()));
            big.fillRect(0, 0, 10, 10);
            Rectangle r = new Rectangle(0, 0, 10, 10);
            g2D.setPaint(new TexturePaint(bi, r));
            g2D.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
            g2D.setPaint(oldPaint);
            super.paint(g2D);
        }
    }

    /**
     * Es utilizado para representar el icono en la barra de tareas
     * 
     * 
     */
    class SgIconed extends JLabel {

        private final SgJInternalFrame sgJInternalFrame;

        public SgIconed(SgJInternalFrame sgJInternalFrame) {
            this.sgJInternalFrame = sgJInternalFrame;
            setIcon(sgJInternalFrame.getIcon().getImage(SgImage.SIZES.S32));
            setToolTipText(sgJInternalFrame.getClass().getSimpleName());
            setBackground(Color.CYAN);
            setOpaque(true);
        }

        /**
         * @return the sgJInternalFrame
         */
        public SgJInternalFrame getSgJInternalFrame() {
            return sgJInternalFrame;
        }

    }

    class InspectorMemoria extends Thread {

        public static final float KB = 1024.0f;
        public static final float MB = 1048576.0f;
        public static final String SKB = " KB";
        public static final String SLASH = " / ";
        public static final String SMB = " MB";

        float divisor = KB;
        float heap = Runtime.getRuntime().freeMemory();
        int iremain = 0;
        int itotal = 0;
        javax.swing.JProgressBar jpb;
        float remain = KB;
        String sremain = null;
        String stotal = null;
        String sufix = null;
        float total = Runtime.getRuntime().totalMemory();
        StringBuilder sb = new StringBuilder();

        InspectorMemoria(JProgressBar jpb) {
            this.jpb = jpb;
            this.jpb.setStringPainted(true);
            //this.jpb.setFont(new Font("SansSerif",Font.PLAIN,12));
            this.jpb.getFont().deriveFont(10);
            this.jpb.setIndeterminate(false);
            //this.jpb.setBackground(Color.WHITE);
            //this.jpb.setForeground(Color.BLACK);
        }

        public void actualizar() {
            heap = Runtime.getRuntime().freeMemory();
            total = Runtime.getRuntime().totalMemory();

            divisor = (total < MB) ? KB : MB;
            sufix = (total < MB) ? SKB : SMB;

            heap /= divisor;
            total /= divisor;
            remain = total - heap;

            itotal = Math.round(total * 1000);
            iremain = Math.round(remain * 1000);

            sremain = String.valueOf(remain);
            stotal = String.valueOf(total);

            sb.setLength(0);

            jpb.setMaximum(itotal);
            jpb.setValue(iremain);
            jpb.setString(sb.append(sremain.substring(0, sremain.indexOf('.') + 2))
                    .append(SLASH).append(stotal.substring(0, stotal.indexOf('.')
                    + 2)).append(sufix).toString());
        }

        @Override
        public void run() {
            while (true) {
                actualizar();
                //yield();
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

}
