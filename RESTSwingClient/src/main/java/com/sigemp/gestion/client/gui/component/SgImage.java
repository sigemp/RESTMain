/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.apache.batik.transcoder.SVGAbstractTranscoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
////////import org.apache.batik.transcoder.SVGAbstractTranscoder;
////////import org.apache.batik.transcoder.TranscoderException;
////////import org.apache.batik.transcoder.TranscoderInput;
////////import org.apache.batik.transcoder.TranscoderOutput;
////////import org.apache.batik.transcoder.image.PNGTranscoder;

/**
 *
 * @author sigem
 */
public enum SgImage {
    
    LOGO_EMPRESA("ic_logo.svg"),
    ACEPTAR("ic_aceptar.svg"),
    CANCELAR("ic_close.svg"),
    CLAVE("ic_password.svg"),
    PANTALLA_PROVINCIA("ic_provincia.svg"),
    PANTALLA_SIN_ICONO("ic_sin_icono.svg"),
    CONNECTION_ICON("ic_connect.svg"),
    CONNECTION_LOSS_ICON("ic_connect_loss.svg"),
    REGISTROS_AGREGAR("ic_record_agregar.svg"),
    REGISTROS_EDITAR("ic_record_edit.svg"),
    REGISTROS_BORRAR("ic_record_borrar.svg"),
    REGISTROS_ACTUALIZAR("ic_actualizar.svg"),
    ANTERIOR("ic_anterior.svg"),
    SIGUIENTE("ic_siguiente.svg"),
    CONTADOR("ic_contador.svg"),
    PTOVTA("ic_ptovta.svg"),
    AYUDA("ic_ayuda.svg")
    ;
    private String pathFile;
    private static String PATH_SVG = "/com/sigemp/client/gui/svg";

    SgImage(String pathFile) {
        this.pathFile = pathFile;
    }
    
//////    public ImageIcon getImage(SIZES size) {
//////        try {
//////            URL url = getClass().getResource(PATH_SVG + "/" + pathFile);
//////            Image image = new SvgRasterizer().rasterize(url,new Dimension(size.size(), size.size()));
//////            return new ImageIcon(image);
//////        } catch (SVGException  | IllegalArgumentException ex) {
//////            Logger.getLogger(SgImage.class.getName()).log(Level.SEVERE, null, ex);
//////        }
//////        return new ImageIcon();
//////    }

    public ImageIcon getImage(SIZES size) {

        // Create a multi-resolution image with all 0.25 scaling steps up to 3x
        //final int size = ...; // base size = 16, 24, 32 etc.
        // Create all resolution variants that Windows 10 offers by default
        // Could probably drop some, e.g. 1.25 = 2.50 / 2 (Swing should handle that...)
//        final List< Integer> sizes = ImmutableList.of(
//                (int) (size * 1.00), // Base image
//                (int) (size * 1.25),
//                (int) (size * 1.50),
//                (int) (size * 1.75),
//                (int) (size * 2.00),
//                (int) (size * 2.25),
//                (int) (size * 2.50),
//                (int) (size * 2.75),
//                (int) (size * 3.00));
        URL url = getClass().getResource(PATH_SVG + "/" + pathFile);

        try {
            // Create a PNG transcoder
            PNGTranscoder t = new PNGTranscoder();
            
            double s = size.size();

            // Set the transcoding hints
            t.addTranscodingHint(SVGAbstractTranscoder.KEY_WIDTH, new Float(s));
            t.addTranscodingHint(SVGAbstractTranscoder.KEY_HEIGHT, new Float(s));

            // Create the transcoder input
            TranscoderInput input = new TranscoderInput(url.toURI().toString());
            //input.setInputStream(new ByteArrayInputStream(url.toURI().toString()));
            // Create the transcoder output
            ByteArrayOutputStream ostream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(ostream);

            // Transcode the image
            t.transcode(input, output);

            // Create an image and ensure its size is initialised
            Image image = Toolkit.getDefaultToolkit().createImage(ostream.toByteArray());
            while (image.getWidth(null) == -1) {
                // HACK! Wait for the image to be loaded, else icons may not render at the correct
                // location as the width and height returned to Swing are -1
            }
            return new ImageIcon(image);
        } catch (TranscoderException | URISyntaxException ex) {
            Logger.getLogger(SgImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public enum SIZES {
        S16(16),S20(20),S30(30),S32(32),S40(40),S64(64);
        int size;
        SIZES(int size) {
            this.size = size;
        }
        
        public int size() {
            return size;
        }
    }
}
