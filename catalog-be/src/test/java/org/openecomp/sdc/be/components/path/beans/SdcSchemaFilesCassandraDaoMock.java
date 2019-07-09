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

package org.openecomp.sdc.be.components.path.beans;

import org.openecomp.sdc.be.dao.cassandra.CassandraClient;
import org.openecomp.sdc.be.dao.cassandra.SdcSchemaFilesCassandraDao;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("sdc-schema-files-cassandra-dao")
public class SdcSchemaFilesCassandraDaoMock extends SdcSchemaFilesCassandraDao {

    public SdcSchemaFilesCassandraDaoMock(CassandraClient cassandraClient) {
        super(cassandraClient);
    }

    @PostConstruct
    @Override
    public void init() {
    }
}
