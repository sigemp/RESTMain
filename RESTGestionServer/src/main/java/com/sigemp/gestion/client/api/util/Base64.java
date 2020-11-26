/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.util;

/**
 *
 * @author sigem
 */
public class Base64 {

    public static native String decode(String a) /*-{
  return window.atob(a);
}-*/;
    
    public static native String encode(String a) /*-{
  return window.btoa(a);
}-*/;
}
