/************************************************************************
 * UIController.java is part of Gwt-Tour 0.1 Copyright 2013 Alain Ekambi
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
package com.gwt.demo.client;

import com.eemi.gwt.tour.client.CallOut;
import com.eemi.gwt.tour.client.GwtTour;
import com.eemi.gwt.tour.client.Placement;
import com.eemi.gwt.tour.client.Tour;
import com.eemi.gwt.tour.client.TourStep;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class UIController {

    private UIController() {

    }

    public static void start() {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                CallOut startCallOut = new CallOut("startTourBtn", Placement.TOP);
                startCallOut.setTitle("Take an example tour");
                startCallOut.setContent("Start by taking an example tour to see GWT-Tour in action!");
                startCallOut.setWidth(240);
                startCallOut.centerXOffset();
                startCallOut.centerArrowOffset();
                GwtTour.createCallOut(startCallOut);

                Button.wrap(Document.get().getElementById("startTourBtn")).addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        GwtTour.removeAllCallOuts();
                        startTour();
                    }
                });
            }
        });
    }

    private static void startTour() {
        Tour tour = new Tour("gwt-tour-demo");
        tour.setScrollTopMargin(100);
        tour.setShowPrevButton(true);

        TourStep step = new TourStep(Placement.BOTTOM, "gwt-tour-title");
        step.setTitle("Welcome to GWT-Tour!");
        step.setContent("Hey there! This is an example tour. There will be plenty of time to read documentation and sample code, but let's just take some time to see how GWT-Tour actually works.");
        step.centerXOffset();
        step.centerArrowOffset();
        tour.addStep(step);

        step = new TourStep(Placement.RIGHT, "general-use-desc");
        step.setTitle("Where to begin");
        step.setContent("At the very least, you'll need to include this line in your .gwt xml to get started.");
        step.setXOffset(-550);
        tour.addStep(step);

        step = new TourStep(Placement.TOP, "my-first-tour-file");
        step.setTitle("Define and start your tour");
        step.setContent("Once you have Gwt-Tour on your page, you're ready to start making your tour! The biggest part of your tour definition will probably be the tour steps.");
        tour.addStep(step);

        step = new TourStep(Placement.RIGHT, "start-tour");
        step.setTitle("Starting your tour");
        step.setContent("After you've created your tour, pass it in to the GwtTour.startTour() method to start it.");
        step.setYOffset(-25);
        tour.addStep(step);

        step = new TourStep(Placement.TOP, "basic-options");
        step.setTitle("Basic step options");
        step.setContent("These are the most basic step options: <b>target</b>, <b>placement</b>, <b>title</b>, and <b>content</b>. For some steps, they may be all you need.");
        step.setArrowOffset(100);
        tour.addStep(step);

        step = new TourStep(Placement.TOP, "api-methods");
        step.setTitle("Gwt-Tour API methods");
        step.setContent("Control your tour programmatically using these methods.");
        tour.addStep(step);

        step = new TourStep(Placement.TOP, "tour-example");
        step.setTitle("This tour's code");
        step.setContent("This is the Java Code for the current tour! Pretty simple, right?");
        tour.addStep(step);

        step = new TourStep(Placement.BOTTOM, "gwt-tour-title");
        step.setTitle("You're all set!");
        step.setContent("Now go and build some great tours!");
        step.centerArrowOffset();
        step.centerXOffset();
        tour.addStep(step);

        GwtTour.startTour(tour);

    }
}
