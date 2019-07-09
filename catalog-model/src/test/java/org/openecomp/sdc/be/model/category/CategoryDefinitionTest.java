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

package org.openecomp.sdc.be.model.category;

import java.util.List;

import org.junit.Test;


public class CategoryDefinitionTest {

	private CategoryDefinition createTestSubject() {
		return new CategoryDefinition();
	}

	
	@Test
	public void testGetSubcategories() throws Exception {
		CategoryDefinition testSubject;
		List<SubCategoryDefinition> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSubcategories();
	}

	
	@Test
	public void testSetSubcategories() throws Exception {
		CategoryDefinition testSubject;
		List<SubCategoryDefinition> subcategories = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setSubcategories(subcategories);
	}

	
	@Test
	public void testAddSubCategory() throws Exception {
		CategoryDefinition testSubject;
		SubCategoryDefinition subcategory = null;

		// default test
		testSubject = createTestSubject();
		testSubject.addSubCategory(subcategory);
	}

	
	@Test
	public void testToString() throws Exception {
		CategoryDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
	}
}
