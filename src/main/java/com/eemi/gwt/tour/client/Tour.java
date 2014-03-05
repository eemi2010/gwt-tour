/************************************************************************
 * Tour.java is part of Gwt-Tour 0.1 Copyright 2013 Alain Ekambi
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 **************************************************************************/
package com.eemi.gwt.tour.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eemi.gwt.tour.client.jso.Function;
import com.eemi.gwt.tour.client.jso.JsoHelper;
import com.eemi.gwt.tour.client.jso.TourPeer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * Represents a tour in Hopscotch
 *
 * @author Alain Ekambi
 *
 */
public class Tour {

    private TourPeer peer;
    private List<TourStep> steps;

    public Tour(String id) {
        peer = TourPeer.newInstance();
        peer.setId(id);
        steps = new ArrayList<TourStep>();
    }

    /**
     * Add a new step to this tour
     *
     * @param step
     */
    public void addStep(TourStep step) {
        steps.add(step);
        this.setSteps(steps);
    }

    /**
     * Default bubble width. Default: 280.
     *
     * @param bubbleWidth
     */
    public void setBubbleWidth(double bubbleWidth) {
        JsoHelper.setAttribute(peer, "bubbleWidth", bubbleWidth);
    }

    /**
     * Default padding width. Default: 280.
     *
     * @param bubblePadding
     */
    public void setBubblePadding(double bubblePadding) {
        JsoHelper.setAttribute(peer, "bubblePadding", bubblePadding);
    }

    /**
     * Should the page scroll smoothly to the next step? Default: true.
     *
     * @param smoothScroll
     */
    public void setSmoothScroll(boolean smoothScroll) {
        JsoHelper.setAttribute(peer, "smoothScroll", smoothScroll);
    }

    /**
     * Duration of page scroll in milliseconds. Only relevant when smoothScroll
     * is set to true. Default: 1000
     *
     * @param scrollDuration
     */
    public void setScrollDuration(int scrollDuration) {
        JsoHelper.setAttribute(peer, "scrollDuration", scrollDuration);
    }

    /**
     * When the page scrolls, how much space should there be between the
     * bubble/targetElement and the top of the viewport? Default: 200.
     *
     * @param value
     */
    public void setScrollTopMargin(int value) {
        JsoHelper.setAttribute(peer, "scrollTopMargin", value);
    }

    /**
     * Should the tour bubble show a close (X) button? Default: true.
     *
     * @param value
     */
    public void setShowCloseButton(boolean value) {
        JsoHelper.setAttribute(peer, "showCloseButton", value);
    }

    /**
     * Should the bubble have the Next button? Default: true.
     *
     * @param value
     */
    public void setShowNextButton(boolean value) {
        JsoHelper.setAttribute(peer, "showNextButton", value);
    }

    /**
     * Should the bubble have the Prev button? Default: false.
     *
     * @param value
     */
    public void setShowPrevButton(boolean value) {
        JsoHelper.setAttribute(peer, "showPrevButton", value);
    }

    /**
     * Default arrow width. (space between the bubble and the targetEl) Used for
     * bubble position calculation. This option is provided for the case where
     * the developer wants to use custom CSS to adjust the size of the arrow.
     * Default: 20.
     *
     * @param value
     */
    public void setArrowWidth(int value) {
        JsoHelper.setAttribute(peer, "arrowWidth", value);
    }

    /**
     * If a specified target element is not found, should we skip to the next
     * step? Default: true.
     */
    public void setSkipIfNoElement(boolean value) {
        JsoHelper.setAttribute(peer, "skipIfNoElement", value);
    }

    /**
     * Should we advance to the next step when the user clicks on the target?
     * Default: false.
     */
    public void setNextOnTargetClick(boolean value) {
        JsoHelper.setAttribute(peer, "nextOnTargetClick", value);
    }

    /**
     * Invoked after every click on a "Next" button.
     *
     * @param callback
     */
    public void onNext(Function callback) {
        peer.onNext(callback);
    }

    /**
     * Invoked after every click on a "Prev" button.
     *
     * @param callback
     */
    public void onPrev(Function callback) {
        peer.onPrev(callback);
    }

    /**
     * Invoked when the tour is started.
     *
     * @param callback
     */
    public void onStart(Function callback) {
        peer.onStart(callback);
    }

    /**
     * Invoked when the user closed the tour
     * before finishing it.
     *
     * @param callback
     */
    public void onClose(Function callback){
        peer.onClose(callback);
    }

    /**
     * Invoked when the tour is ended.
     *
     * @param callback
     */
    public void onEnd(Function callback) {
        peer.onEnd(callback);
    }

    /**
     * Label for next button
     *
     * @param value
     */
    public native void setNextBtnText(String value) /*-{
        var obj = this.@com.eemi.gwt.tour.client.Tour::peer;
        obj.i18n.nextBtn = value;
    }-*/;

    /**
     * Label for prev button
     *
     * @param value
     */
    public native void setPrevBtnText(String value) /*-{
        var obj = this.@com.eemi.gwt.tour.client.Tour::peer;
        obj.i18n.prevBtn = value;
    }-*/;

    /**
     * Label for done button
     *
     * @param value
     */
    public native void setDoneBtnText(String value) /*-{
        var obj = this.@com.eemi.gwt.tour.client.Tour::peer;
        obj.i18n.doneBtn = value;
    }-*/;





    /**
     * Label for skip button
     *
     * @param value
     */
    public native void setSkiptBtnText(String value) /*-{
        var obj = this.@com.eemi.gwt.tour.client.Tour::peer;
        obj.i18n.skipBtn = value;
    }-*/;

    /**
     * Text for close button tooltip
     *
     * @param value
     */
    public native void setCloseTooltipTextText(String value) /*-{
        var obj = this.@com.eemi.gwt.tour.client.Tour::peer;
        obj.i18n.closeTooltip = value;
    }-*/;

    public void setStepNums(String... values) {
        JsArrayString peers = JsArrayString.createArray().cast();
        for (String s : values) {
            peers.push(s);
        }
        setStepNums(peers);
    }

    /**
     * Provide a list of strings to be shown as the step number, based on index
     * of array.
     */
    public native void setStepNums(JsArrayString value) /*-{
        var obj = this.@com.eemi.gwt.tour.client.Tour::peer;
        obj.i18n.stepNums = value;
    }-*/;

    public void setSteps(List<TourStep> steps) {
        JsArray<JavaScriptObject> peers = JsArray.createArray().cast();
        for (TourStep step : steps) {
            peers.push(step.getPeer());
        }
        peer.setSteps(peers);
    }

    public void setSteps(TourStep... steps) {
        this.setSteps(Arrays.asList(steps));
    }

    public JavaScriptObject getPeer() {
        return this.peer;
    }
}
