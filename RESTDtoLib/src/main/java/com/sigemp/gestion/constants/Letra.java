/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.constants;

public enum Letra {
        A("A"),
        B("B"),
        C("C"),
        M("M"),
        X("X"),
        Z("Z");
        private String letra;

        private Letra(String letra) {
            this.letra = letra;
        }

        public String getLetra() {
            return letra;
        }

    }
