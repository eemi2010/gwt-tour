/************************************************************************
  TourStep.java is part of Gwt-Tour 0.1  Copyright 2013 Alain Ekambi

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

import com.eemi.gwt.tour.client.jso.Function;
import com.eemi.gwt.tour.client.jso.JsoHelper;
import com.eemi.gwt.tour.client.jso.StepPeer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Represents a step in a Hopscotch tour
 * 
 * @author Alain Ekambi
 * 
 */
public class TourStep {

    protected StepPeer peer;

    protected TourStep() {
        peer = StepPeer.newInstance();
    }

    /**
     * Creates a new tour step
     * 
     * @param placement
     *            , the position where the bubble should appear in relation to
     *            its target
     * @param targets
     *            , ids of DOM Element that will we be the target of this step
     */
    public TourStep(Placement placement, String... targets) {
        peer = StepPeer.newInstance();

        JsArrayString values = JsArrayString.createArray().cast();
        for (String s : targets) {
            values.push(s);
        }
        peer.setTarget(values);
        peer.setPlacement(placement.getValue());
    }

    /**
     * Creates a new tour step
     * 
     * @param placement
     *            , the position where the bubble should appear in relation to
     *            its target
     * @param targets
     *            , DOM Element that will we be the target of this step
     */
    public TourStep(Placement placement, Element... targets) {
        peer = StepPeer.newInstance();
        peer.setPlacement(placement.getValue());

        JsArrayString values = JsArrayString.createArray().cast();
        for (Element el : targets) {
            values.push(getOrCreateId(el));
        }
        peer.setTarget(values);
    }

    /**
     * Creates a new tour step
     * 
     * @param placement
     *            , the position where the bubble should appear in relation to
     *            its target
     * @param targets
     *            , Widget that will we be the target of this step
     */
    public TourStep(Placement placement, Widget... targets) {
        peer = StepPeer.newInstance();
        peer.setPlacement(placement.getValue());

        JsArrayString values = JsArrayString.createArray().cast();
        for (Widget el : targets) {
            values.push(getOrCreateId(el.getElement()));
        }
        peer.setTarget(values);
    }

    /**
     * Step title
     * 
     * @param title
     *            , title of the step
     */
    public void setTitle(String title) {
        peer.setTitle(title);
    }

    /**
     * Step content
     * 
     * @param content
     *            , content of the step
     */
    public void setContent(String content) {
        peer.setContent(content);
    }

    /**
     * Sets the bubble width
     * 
     * @param width
     *            , the bubble width
     */
    public void setWidth(int width) {
        JsoHelper.setAttribute(peer, "width", width);
    }

    /**
     * The bubble padding
     * 
     * @param padding
     *            , bubble padding
     */
    public void setPadding(int padding) {
        JsoHelper.setAttribute(peer, "padding", padding);
    }

    /**
     * horizontal position adjustment for bubble. Default: 0
     * 
     * @param xOffset
     *            , xOffset
     */
    public void setXOffset(int xOffset) {
        JsoHelper.setAttribute(peer, "xOffset", xOffset);
    }

    public void centerXOffset() {
        JsoHelper.setAttribute(peer, "xOffset", "center");
    }

    /**
     * vertical position adjustment for bubble. Default: 0
     * 
     * @param yOffset
     *            , yOffset
     */
    public void setYOffset(int yOffset) {
        JsoHelper.setAttribute(peer, "yOffset", yOffset);
    }

    public void centerYOffset() {
        JsoHelper.setAttribute(peer, "yOffset", "center");
    }

    /**
     * offset for the bubble arrow.
     * 
     * @param yOffset
     *            , yOffset
     */
    public void setArrowOffset(int arrowOffset) {
        JsoHelper.setAttribute(peer, "arrowOffset", arrowOffset);
    }

    public void centerArrowOffset() {
        JsoHelper.setAttribute(peer, "arrowOffset", "center");
    }

    /**
     * number in milliseconds to wait before showing step. Default: 0.
     * 
     * @param delay
     *            , the delay
     */
    public void setDelay(int delay) {
        JsoHelper.setAttribute(peer, "delay", delay);
    }

    /**
     * sets the z-index of the bubble
     * 
     * @param zIndex
     *            , the zIndex
     */
    public void setZIndex(int zIndex) {
        JsoHelper.setAttribute(peer, "zIndex", zIndex);

    }

    /**
     * should show the next button. Default: true.
     * 
     * @param showNextButton
     */
    public void setShowNextButton(boolean showNextButton) {
        JsoHelper.setAttribute(peer, "showNextButton", showNextButton);
    }

    /**
     * should show the prev button. Default: true.
     * 
     * @param showNextButton
     */
    public void setShowPrevButton(boolean prevNextButton) {
        JsoHelper.setAttribute(peer, "prevNextButton", prevNextButton);
    }

    /**
     * should show the call-to-action button. Default: false.
     * 
     * @param showCTAButton
     */
    public void setShowCTAButton(boolean showCTAButton) {
        JsoHelper.setAttribute(peer, "showCTAButton", showCTAButton);
    }

    /**
     * label for the call-to-action button.
     * 
     * @param label
     */
    public void setCTALabel(String label) {
        JsoHelper.setAttribute(peer, "ctalLabel", label);
    }

    /**
     * indicates that the next step is on a different page. Default: false.
     * 
     * @param multiPage
     */
    public void setMultiPage(boolean multiPage) {
        JsoHelper.setAttribute(peer, "multipage", multiPage);
    }

    /**
     * if true, 'Next' button reads 'Skip'. Default: false.
     * 
     * @param showSkip
     */
    public void setShowSkip(boolean showSkip) {
        JsoHelper.setAttribute(peer, "showSkip", showSkip);
    }

    /**
     * set to true if the target element has fixed positioning. Default: false.
     * 
     * @param fixedElement
     */
    public void setFixedElement(boolean fixedElement) {
        JsoHelper.setAttribute(peer, "fixedElement", fixedElement);
    }

    /**
     * triggers nextStep() when the target is clicked. Default: false.
     * 
     * @param nextTargetOnClick
     */
    public void setNextTargetOnClick(boolean nextTargetOnClick) {
        JsoHelper.setAttribute(peer, "nextTargetOnClick", nextTargetOnClick);
    }

    /**
     * callback for when 'Next' button is clicked
     * 
     * @param callback
     */
    public void onNext(Function callback) {
        peer.onNext(callback);
    }

    /**
     * callback for when 'Previous' button is clicked
     * 
     * @param callback
     */
    public void onPrev(Function callback) {
        peer.onPrev(callback);
    }

    /**
     * callback for when step is first displayed
     * 
     * @param callback
     */
    public void onShow(Function callback) {
        peer.onShow(callback);
    }

    /**
     * callback for the optional call-to-action button
     * 
     * @param callback
     */
    public void onCTA(Function callback) {
        peer.onCTA(callback);
    }

    public JavaScriptObject getPeer() {
        return this.peer;
    }

    protected String getOrCreateId(Element element) {
        String id = element.getId();
        if (id == null || id.isEmpty()) {
            id = GwtTour.generateId();
            element.setId(id);
        }
        return id;

    }
}
