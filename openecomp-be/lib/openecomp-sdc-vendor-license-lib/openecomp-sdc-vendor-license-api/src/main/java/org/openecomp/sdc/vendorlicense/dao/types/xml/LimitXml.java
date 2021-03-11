/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property. All rights reserved.
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

package org.openecomp.sdc.vendorlicense.dao.types.xml;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LimitXml {
  String description;
  String metric;
  String values;
  String unit;
  String time;
  String aggregationFunction;

  public EntitlementTimeForXml getTimeForArtifact() {
    EntitlementTimeForXml timeForXml = new EntitlementTimeForXml();
    if (time != null) {
      timeForXml.setValue(time);
    }

    return timeForXml;
  }

  public AggregationFunctionForXml getAggregationFunctionForArtifact() {
    AggregationFunctionForXml aggregationFunctionForXml = new AggregationFunctionForXml();
    if (aggregationFunction != null) {
      aggregationFunctionForXml.setValue(aggregationFunction);
    }
    return aggregationFunctionForXml;
  }
}
