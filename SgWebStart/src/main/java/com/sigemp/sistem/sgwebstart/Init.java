/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.sistem.sgwebstart;

import java.net.URL;

/**
 *
 * @author sigem
 */
public class Init {

    private void showHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append(versionJava())
                .append("SgWebStart Version:")
                .append(VERSION)
                .append(RC)
                .append("-entrypoint <URL>        Especifica el punto de entrada para la descarga del sistema")
                .append(RC)
                .append("-h -help                 Muestra esta Ayuda");
        show(sb.toString());
    }

    private static void exit() {
        System.exit(0);
    }

    private static void show(String msg) {
        System.out.println(msg);
    }

    public String versionJava() {
        StringBuilder sb = new StringBuilder();
        sb.append(RC).append("Java Version: ")
                .append(System.getProperty("java.version"))
                .append(RC)
                .append("Java Runtime Version: ")
                .append(System.getProperty("java.runtime.version"))
                .append(RC)
                .append("Java Home: ")
                .append(System.getProperty("java.home"))
                .append(RC)
                .append("Java Vendor: ")
                .append(System.getProperty("java.vendor"))
                .append(RC)
                .append("Java Vendor URL: ")
                .append(System.getProperty("java.vendor.url"))
                .append(RC)
                .append("Java Class Path: ")
                .append(System.getProperty("java.class.path"))
                .append(RC);

        return sb.toString();
    }

    static final String ARCHIVO_CHK = "files.chk";
    static final String VERSION = "0.001";
    URL entryPoint;
    static final String RC = "\n\r";

    public static void main(String[] args) throws Exception {
        new Init().start(args);
    }

    private void start(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (s.endsWith("-entrypoint")) {

                if ((i + 1) < args.length) {
                    i++;
                    String param = args[i];
                    URL url = new URL(param);
                }
            }
            if (s.equals("-help") || s.equals("-h")) {
                showHelp();
                exit();
            }
        }
        
       //load init
        
        new Start().start();

    }
}
