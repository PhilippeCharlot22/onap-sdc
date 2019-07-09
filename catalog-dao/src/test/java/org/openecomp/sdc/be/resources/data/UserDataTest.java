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

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class UserDataTest {

	private UserData createTestSubject() {
		return new UserData();
	}

	@Test
	public void testCtor() throws Exception {
		new UserData(new HashMap<>());
		new UserData("mock", "mock", "mock", "mock", "mock", "mock", 0L);
	}
	
	@Test
	public void testGetFirstName() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getFirstName();
	}

	
	@Test
	public void testSetFirstName() throws Exception {
		UserData testSubject;
		String firstName = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setFirstName(firstName);
	}

	
	@Test
	public void testGetLastName() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getLastName();
	}

	
	@Test
	public void testSetLastName() throws Exception {
		UserData testSubject;
		String lastName = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setLastName(lastName);
	}

	
	@Test
	public void testGetUserId() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUserId();
	}

	
	@Test
	public void testSetUserId() throws Exception {
		UserData testSubject;
		String userId = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setUserId(userId);
	}

	
	@Test
	public void testGetEmail() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getEmail();
	}

	
	@Test
	public void testSetEmail() throws Exception {
		UserData testSubject;
		String email = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setEmail(email);
	}

	
	@Test
	public void testGetRole() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRole();
	}

	
	@Test
	public void testSetRole() throws Exception {
		UserData testSubject;
		String role = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setRole(role);
	}

	
	@Test
	public void testSetLastLoginTime() throws Exception {
		UserData testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.setLastLoginTime();
	}

	
	@Test
	public void testSetLastLoginTime_1() throws Exception {
		UserData testSubject;
		Long time = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setLastLoginTime(time);
	}

	
	@Test
	public void testGetLastLoginTime() throws Exception {
		UserData testSubject;
		Long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getLastLoginTime();
	}

	
	@Test
	public void testToString() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
	}

	
	@Test
	public void testHashCode() throws Exception {
		UserData testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.hashCode();
	}

	
	@Test
	public void testEquals() throws Exception {
		UserData testSubject;
		Object obj = null;
		boolean result;

		// test 1
		testSubject = createTestSubject();
		obj = null;
		result = testSubject.equals(obj);
		Assert.assertEquals(false, result);
		
		result = testSubject.equals(createTestSubject());
		Assert.assertEquals(true, result);
		
		result = testSubject.equals(testSubject);
		Assert.assertEquals(true, result);
		
		result = testSubject.equals(new Object());
		Assert.assertEquals(false, result);
	}

	
	@Test
	public void testToJson() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toJson();
	}

	
	@Test
	public void testToGraphMap() throws Exception {
		UserData testSubject;
		Map<String, Object> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toGraphMap();
	}

	
	@Test
	public void testGetUniqueIdKey() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUniqueIdKey();
	}

	
	@Test
	public void testGetUniqueId() throws Exception {
		UserData testSubject;
		Object result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUniqueId();
	}

	
	@Test
	public void testGetStatus() throws Exception {
		UserData testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getStatus();
	}

	
	@Test
	public void testSetStatus() throws Exception {
		UserData testSubject;
		String status = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setStatus(status);
	}
}
