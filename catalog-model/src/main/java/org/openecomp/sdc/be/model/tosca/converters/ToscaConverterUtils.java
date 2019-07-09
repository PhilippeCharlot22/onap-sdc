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

package org.openecomp.sdc.be.model.tosca.converters;

import com.google.gson.JsonObject;
import org.openecomp.sdc.be.model.tosca.ToscaFunctions;

public class ToscaConverterUtils {

    private ToscaConverterUtils() {}

    public static boolean isGetInputValue(JsonObject value) {
        return value.get(ToscaFunctions.GET_INPUT.getFunctionName()) != null;
    }

    public static boolean isGetPolicyValue(JsonObject value) {
        return value.get(ToscaFunctions.GET_POLICY.getFunctionName()) != null;
    }

}
