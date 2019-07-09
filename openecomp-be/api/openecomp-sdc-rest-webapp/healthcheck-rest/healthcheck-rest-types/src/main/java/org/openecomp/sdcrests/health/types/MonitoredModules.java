/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2019 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package org.openecomp.sdcrests.health.types;


public enum MonitoredModules {
    BE("BE"),
    CAS("Cassandra"),
    ZU("Zusammen");

    private String name;

    MonitoredModules(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    public static final MonitoredModules toValue(String inVal){
        for (MonitoredModules val : values()){
            if (val.toString().equals(inVal)){
                return val;
            }
        }
        return null;
    }
}
