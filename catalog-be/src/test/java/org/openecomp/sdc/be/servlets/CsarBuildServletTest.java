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

package org.openecomp.sdc.be.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.junit.Test;


public class CsarBuildServletTest {

	private CsarBuildServlet createTestSubject() {
		return new CsarBuildServlet();
	}

	
	@Test
	public void testGetDefaultTemplate() throws Exception {
		CsarBuildServlet testSubject;
		HttpServletRequest request = null;
		String serviceName = "";
		String serviceVersion = "";
		Response result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDefaultTemplate(request, serviceName, serviceVersion);
	}

	
	@Test
	public void testGetToscaCsarTemplate() throws Exception {
		CsarBuildServlet testSubject;
		HttpServletRequest request = null;
		String serviceName = "";
		String serviceVersion = "";
		Response result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getToscaCsarTemplate(request, serviceName, serviceVersion);
	}

	

}
