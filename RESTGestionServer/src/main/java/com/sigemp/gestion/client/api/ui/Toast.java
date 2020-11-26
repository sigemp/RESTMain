/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.ui;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author sigem
 */
public class Toast extends PopupPanel {

    private int delay;

    public Toast(Widget sender, int offsetX, int offsetY,
            final String text, final int delay, final String styleName) {
        super(true);

        this.delay = delay;

        HTML contents = new HTML(text);
        add(contents);

        int left = offsetX;
        int top = offsetY;

        if (sender != null) {
            left = sender.getAbsoluteLeft() + offsetX;
            top = sender.getAbsoluteTop() + offsetY;
        }

        if (styleName != null) {
            setStyleName(styleName);
        } else {
            getElement().setAttribute("Style",
                    "font-family: Arial Unicode MS, Arial, sans-serif;"
                    + "font-size: small;"
                    + "border: 1px solid #000000;"
                    + "padding: 3px;"
                    + "background: rgba(248, 255, 136, 0.90);"
                    + "color: black;"
                    + "border-radius: 5px;"
                    + "padding: 6px;"
                    + "box-shadow: 0 0 2px 1px maroon;");
        }

        setPopupPosition(left, top);
    }

    @Override
    public void show() {
        super.show();

        Timer t = new Timer() {

            @Override
            public void run() {
                Toast.this.hide();
            }

        };
        t.schedule(delay);
    }

    public static void show(Widget sender, int offsetX, int offsetY,
            String text, final int delay, String styleName) {
        new Toast(sender, offsetX, offsetY, text, delay, styleName).show();
    }

    public static void show(String text, final int delay) {
        new Toast(null, 10, 10, text, delay, null).show();
    }

    public static void show(String text) {
        new Toast(null, 10, 10, text, 5000, null).show();
    }
}
