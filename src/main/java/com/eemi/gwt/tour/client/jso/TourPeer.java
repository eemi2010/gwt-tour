/************************************************************************
  TourPeer.java is part of Gwt-Tour 0.1  Copyright 2013 Alain Ekambi

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
package com.eemi.gwt.tour.client.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class TourPeer extends JavaScriptObject {

    protected TourPeer() {

    }

    public static native TourPeer newInstance()/*-{
		return {};
    }-*/;

    public final native void setId(String value)/*-{
		this.id = value;
    }-*/;

    public final native void setSteps(JsArray<JavaScriptObject> values)/*-{
		this.steps = values;
    }-*/;

    public final native void onNext(Function callback)/*-{
		this.onNext = $entry(function() {
			callback.@com.eemi.gwt.tour.client.jso.Function::execute()();
		});
    }-*/;

    public final native void onPrev(Function callback)/*-{
		this.onPrev = $entry(function() {
			callback.@com.eemi.gwt.tour.client.jso.Function::execute()();
		});
    }-*/;

    public final native void onStart(Function callback)/*-{
		this.onStart = $entry(function() {
			callback.@com.eemi.gwt.tour.client.jso.Function::execute()();
		});
    }-*/;

    public final native void onEnd(Function callback)/*-{
		this.onEnd = $entry(function() {
			callback.@com.eemi.gwt.tour.client.jso.Function::execute()();
		});
    }-*/;

    public final native void onError(Function callback)/*-{
		this.onError = $entry(function() {
			callback.@com.eemi.gwt.tour.client.jso.Function::execute()();
		});
    }-*/;

    public final native void onClose(Function callback)/*-{
		this.onClose = $entry(function() {
			callback.@com.eemi.gwt.tour.client.jso.Function::execute()();
		});
    }-*/;
}
