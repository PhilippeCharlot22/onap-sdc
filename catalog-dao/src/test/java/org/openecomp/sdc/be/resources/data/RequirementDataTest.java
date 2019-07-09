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

package org.openecomp.sdc.be.resources.data;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class RequirementDataTest {

	private RequirementData createTestSubject() {
		return new RequirementData();
	}

	@Test
	public void testCtor() throws Exception {
		new RequirementData(new HashMap<>());
	}
	
	@Test
	public void testToGraphMap() throws Exception {
		RequirementData testSubject;
		Map<String, Object> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toGraphMap();
	}

	
	@Test
	public void testGetNode() throws Exception {
		RequirementData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getNode();
	}

	
	@Test
	public void testSetNode() throws Exception {
		RequirementData testSubject;
		String node = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setNode(node);
	}

	
	@Test
	public void testGetCreationTime() throws Exception {
		RequirementData testSubject;
		Long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCreationTime();
	}

	
	@Test
	public void testSetCreationTime() throws Exception {
		RequirementData testSubject;
		Long creationTime = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setCreationTime(creationTime);
	}

	
	@Test
	public void testGetModificationTime() throws Exception {
		RequirementData testSubject;
		Long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getModificationTime();
	}

	
	@Test
	public void testSetModificationTime() throws Exception {
		RequirementData testSubject;
		Long modificationTime = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setModificationTime(modificationTime);
	}

	
	@Test
	public void testSetUniqueId() throws Exception {
		RequirementData testSubject;
		String uniqueId = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setUniqueId(uniqueId);
	}

	
	@Test
	public void testGetRelationshipType() throws Exception {
		RequirementData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRelationshipType();
	}

	
	@Test
	public void testSetRelationshipType() throws Exception {
		RequirementData testSubject;
		String relationshipType = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setRelationshipType(relationshipType);
	}

	
	@Test
	public void testGetMinOccurrences() throws Exception {
		RequirementData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getMinOccurrences();
	}

	
	@Test
	public void testSetMinOccurrences() throws Exception {
		RequirementData testSubject;
		String minOccurrences = "";

		// test 1
		testSubject = createTestSubject();
		minOccurrences = null;
		testSubject.setMinOccurrences(minOccurrences);

		// test 2
		testSubject = createTestSubject();
		minOccurrences = "";
		testSubject.setMinOccurrences(minOccurrences);
	}

	
	@Test
	public void testGetMaxOccurrences() throws Exception {
		RequirementData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getMaxOccurrences();
	}

	
	@Test
	public void testSetMaxOccurrences() throws Exception {
		RequirementData testSubject;
		String maxOccurrences = "";

		// test 1
		testSubject = createTestSubject();
		maxOccurrences = null;
		testSubject.setMaxOccurrences(maxOccurrences);

		// test 2
		testSubject = createTestSubject();
		maxOccurrences = "";
		testSubject.setMaxOccurrences(maxOccurrences);
	}

	
	@Test
	public void testGetUniqueId() throws Exception {
		RequirementData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUniqueId();
	}

	
	@Test
	public void testToString() throws Exception {
		RequirementData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
	}
}
