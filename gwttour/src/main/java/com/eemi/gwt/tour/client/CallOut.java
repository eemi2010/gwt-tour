/************************************************************************
  CallOut.java is part of Gwt-Tour 0.1  Copyright 2013 Alain Ekambi

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
**************************************************************************/
package com.eemi.gwt.tour.client;

import com.eemi.gwt.tour.client.jso.JsoHelper;
import com.eemi.gwt.tour.client.jso.StepPeer;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Represents a simple callout
 * 
 * @author Alain Ekambi
 * 
 */
public class CallOut extends TourStep {

    private String id;

    public CallOut(String target, Placement placement) {
        peer = StepPeer.newInstance();
        JsoHelper.setAttribute(peer, "id", target);
        peer.setTarget(target);
        peer.setPlacement(placement.getValue());
    }

    /**
     * Creates a new callout
     * 
     * @param placement
     *            , the position where the bubble should appear in relation to
     *            its target
     * @param targets
     *            , DOM Element that will we be the target of this step
     */
    public CallOut(Element target, Placement placement) {
        peer = StepPeer.newInstance();
        id = getOrCreateId(target);
        JsoHelper.setAttribute(peer, "id", id);
        peer.setPlacement(placement.getValue());
        peer.setTarget(id);
    }

    /**
     * Creates a new callout
     * 
     * @param placement
     *            , the position where the bubble should appear in relation to
     *            its target
     * @param targets
     *            , Widget that will we be the target of this step
     */
    public CallOut(Widget target, Placement placement) {
        peer = StepPeer.newInstance();
        id = getOrCreateId(target.getElement());
        JsoHelper.setAttribute(peer, "id", id + "-callout");
        peer.setPlacement(placement.getValue());
        peer.setTarget(id);
    }

    public String getId() {
        return id;
    }

}
