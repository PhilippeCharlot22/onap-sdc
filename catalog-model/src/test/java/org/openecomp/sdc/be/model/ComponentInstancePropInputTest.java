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

package org.openecomp.sdc.be.model;

import org.junit.Test;


public class ComponentInstancePropInputTest {

	private ComponentInstancePropInput createTestSubject() {
		return new ComponentInstancePropInput();
	}

	@Test
	public void testCtor() throws Exception {
		new ComponentInstancePropInput(new ComponentInstanceProperty());
	}
	
	@Test
	public void testGetPropertiesName() throws Exception {
		ComponentInstancePropInput testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPropertiesName();
	}

	
	@Test
	public void testSetPropertiesName() throws Exception {
		ComponentInstancePropInput testSubject;
		String propertiesName = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPropertiesName(propertiesName);
	}

	
	@Test
	public void testGetInput() throws Exception {
		ComponentInstancePropInput testSubject;
		PropertyDefinition result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getInput();
	}

	
	@Test
	public void testSetInput() throws Exception {
		ComponentInstancePropInput testSubject;
		PropertyDefinition input = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setInput(input);
	}

	
	@Test
	public void testGetParsedPropNames() throws Exception {
		ComponentInstancePropInput testSubject;
		String[] result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getParsedPropNames();
		testSubject.setPropertiesName("mock");
		result = testSubject.getParsedPropNames();
	}
}
