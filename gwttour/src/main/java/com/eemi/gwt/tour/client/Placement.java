/************************************************************************
  Placement.java is part of Gwt-Tour 0.1  Copyright 2013 Alain Ekambi

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

/**
 * Specifies where the bubble should appear in relation to the target
 * 
 * @author Alain Ekambi
 * 
 */
public enum Placement {

    TOP("top"), LEFT("left"), BOTTOM("bottom"), RIGHT("right");

    private String value;

    private Placement(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
