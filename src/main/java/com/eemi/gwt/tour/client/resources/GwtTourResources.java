package com.eemi.gwt.tour.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface GwtTourResources extends ClientBundle {

    @Source("hopscotch.css")
    TextResource css();

    @Source("hopscotsch-0.1.2.min.js")
    TextResource js();

}
