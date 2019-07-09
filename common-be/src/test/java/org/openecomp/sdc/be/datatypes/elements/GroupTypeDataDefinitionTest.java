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

package org.openecomp.sdc.be.datatypes.elements;

import org.junit.Test;

import java.util.List;
import java.util.Map;


public class GroupTypeDataDefinitionTest {

	private GroupTypeDataDefinition createTestSubject() {
		return new GroupTypeDataDefinition();
	}

	@Test
	public void testCopyConstructor() throws Exception {
		GroupTypeDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		new GroupTypeDataDefinition(testSubject);
	}
	
	@Test
	public void testGetType() throws Exception {
		GroupTypeDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getType();
	}

	
	@Test
	public void testSetType() throws Exception {
		GroupTypeDataDefinition testSubject;
		String type = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setType(type);
	}

	
	@Test
	public void testGetVersion() throws Exception {
		GroupTypeDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getVersion();
	}

	
	@Test
	public void testSetVersion() throws Exception {
		GroupTypeDataDefinition testSubject;
		String version = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setVersion(version);
	}

	
	@Test
	public void testGetMembers() throws Exception {
		GroupTypeDataDefinition testSubject;
		List<String> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getMembers();
	}

	
	@Test
	public void testSetMembers() throws Exception {
		GroupTypeDataDefinition testSubject;
		List<String> members = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setMembers(members);
	}

	
	@Test
	public void testGetMetadata() throws Exception {
		GroupTypeDataDefinition testSubject;
		Map<String, String> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getMetadata();
	}

	
	@Test
	public void testSetMetadata() throws Exception {
		GroupTypeDataDefinition testSubject;
		Map<String, String> metadata = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setMetadata(metadata);
	}

	
	@Test
	public void testGetDescription() throws Exception {
		GroupTypeDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDescription();
	}

	
	@Test
	public void testSetDescription() throws Exception {
		GroupTypeDataDefinition testSubject;
		String description = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setDescription(description);
	}

	
	@Test
	public void testGetUniqueId() throws Exception {
		GroupTypeDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUniqueId();
	}

	
	@Test
	public void testSetUniqueId() throws Exception {
		GroupTypeDataDefinition testSubject;
		String uniqueId = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setUniqueId(uniqueId);
	}

	
	@Test
	public void testGetCreationTime() throws Exception {
		GroupTypeDataDefinition testSubject;
		Long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCreationTime();
	}

	
	@Test
	public void testSetCreationTime() throws Exception {
		GroupTypeDataDefinition testSubject;
		Long creationTime = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setCreationTime(creationTime);
	}

	
	@Test
	public void testGetModificationTime() throws Exception {
		GroupTypeDataDefinition testSubject;
		Long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getModificationTime();
	}

	
	@Test
	public void testSetModificationTime() throws Exception {
		GroupTypeDataDefinition testSubject;
		Long modificationTime = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setModificationTime(modificationTime);
	}

	
	@Test
	public void testToString() throws Exception {
		GroupTypeDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
	}

	
	@Test
	public void testGetDerivedFrom() throws Exception {
		GroupTypeDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDerivedFrom();
	}

	
	@Test
	public void testSetDerivedFrom() throws Exception {
		GroupTypeDataDefinition testSubject;
		String derivedFrom = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setDerivedFrom(derivedFrom);
	}

	
	@Test
	public void testIsHighestVersion() throws Exception {
		GroupTypeDataDefinition testSubject;
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.isHighestVersion();
	}

	
	@Test
	public void testSetHighestVersion() throws Exception {
		GroupTypeDataDefinition testSubject;
		boolean isLatestVersion = false;

		// default test
		testSubject = createTestSubject();
		testSubject.setHighestVersion(isLatestVersion);
	}
}
