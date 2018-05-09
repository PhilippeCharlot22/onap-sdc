/*
 * Copyright © 2016-2018 European Support Limited
 *
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
 */
package org.openecomp.sdc.be.tosca.model;

import java.util.Map;

/**
 * @author KATYR
 * @since March 26, 2018
 */

public class ToscaInterfaceDefinition {

    private String type;
    private Map<String, Object> operations; // ToscaLifecycleOperationDefinition <-> Object

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getOperations() {
        return operations;
    }

//    public void setOperations(Map<String, Object> operations) {
//        this.operations = operations;
//    }

    public void setOperations(Map<String,Object> toscaOperations) {
        this.operations = toscaOperations;
    }
}

