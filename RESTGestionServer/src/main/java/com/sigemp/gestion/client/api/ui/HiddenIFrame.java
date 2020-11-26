/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.RootPanel;

/**
 *
 * @author sigem
 */
public class HiddenIFrame extends Frame {

    public HiddenIFrame(String url) {
        super();
        setSize("0px", "0px");
        setVisible(false);
        sinkEvents(Event.ONLOAD);
        // TODO: Add Form here so that it will POST instead of GET
        RootPanel.get().add(this);
        // Do a GET currently
        setUrl(url);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (DOM.eventGetType(event) == Event.ONLOAD) {
            unsinkEvents(Event.ONLOAD);
            DOM.eventCancelBubble(event, true);
            RootPanel.get().remove(this);
        } else {
            super.onBrowserEvent(event);
        }
    }
}
