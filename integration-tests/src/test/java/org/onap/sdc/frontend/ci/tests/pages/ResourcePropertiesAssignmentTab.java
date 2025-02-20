/*
 * ============LICENSE_START=======================================================
 *  Copyright (C) 2021 Nordix Foundation
 *  ================================================================================
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  SPDX-License-Identifier: Apache-2.0
 *  ============LICENSE_END=========================================================
 */

package org.onap.sdc.frontend.ci.tests.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aventstack.extentreports.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.onap.sdc.frontend.ci.tests.execute.setup.ExtentTestActions;
import org.onap.sdc.frontend.ci.tests.utilities.LoaderHelper;
import org.onap.sdc.frontend.ci.tests.utilities.NotificationComponent;
import org.onap.sdc.frontend.ci.tests.utilities.NotificationComponent.NotificationType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Handles the Resource Properties Assignment Properties Tab UI actions
 */
public class ResourcePropertiesAssignmentTab extends AbstractPageObject {

    private WebElement wrappingElement;
    private LoaderHelper loaderHelper;
    private NotificationComponent notificationComponent;

    public ResourcePropertiesAssignmentTab(final WebDriver webDriver) {
        super(webDriver);
        notificationComponent = new NotificationComponent(webDriver);
        loaderHelper = new LoaderHelper(webDriver);
    }

    @Override
    public void isLoaded() {
       wrappingElement = waitForElementVisibility(XpathSelector.MAIN_DIV.getXpath());
       waitForElementVisibility(XpathSelector.PROPERTIES_TAB.getXpath());
       isPropertiesTableLoaded();
    }

    /**
     * Waits for the table of properties to load
     */
    private void isPropertiesTableLoaded() {
        waitForElementVisibility(By.xpath(XpathSelector.PROPERTIES_TABLE.getXpath()), 5);
        waitForElementInvisibility(By.xpath(XpathSelector.NO_DATA_MESSAGE.getXpath()), 5);
    }

    /**
     * Gets the software_version property values.
     *
     * @return the list of software versions found
     */
    public List<String> getSoftwareVersionProperty() {
        isPropertiesTableLoaded();
        final By swVersionCheckboxLocator = By.xpath(XpathSelector.SOFTWARE_VERSION_PROPERTY_CHECKBOX.getXpath());
        waitForElementVisibility(swVersionCheckboxLocator, 5);

        final List<String> softwareVersionList = new ArrayList<>();
        final List<WebElement> elements = wrappingElement.findElements(By.xpath(XpathSelector.SOFTWARE_VERSION_INPUT.getXpath()));
        for (final WebElement element : elements) {
            softwareVersionList.add(element.getAttribute("value"));
        }

        return softwareVersionList;
    }

    /**
     * Sets a property value
     * @param propertyName the property name
     * @param value the property value
     */
    public void setPropertyValue(final String propertyName, final Object value) {
        if (value == null) {
            return;
        }

        if (value instanceof String) {
            setStringPropertyValue(propertyName, (String) value);
            return;
        }

        if (value instanceof Integer) {
            setStringPropertyValue(propertyName, ((Integer) value).toString());
            return;
        }

        if (value instanceof Boolean) {
            setBooleanPropertyValue(propertyName);
            return;
        }

        if (value instanceof Map) {
            setComplexPropertyValue(propertyName, value);
            return;
        }

        if (value instanceof List) {
            setComplexPropertyValue(propertyName, value);
            return;
        }

        throw new UnsupportedOperationException("Cannot set property value of type: " + value.getClass());
    }

    /**
     * Gets the property value. Only properties with a text value like string, float, integer or a list of string, float, integer are supported.
     *
     * @param propertyName the property name
     * @return the value of the given property
     */
    public Object getPropertyValue(final String propertyName) {
        isPropertiesTableLoaded();
        final Map<String, String> propertyNamesAndTypes = getPropertyNamesAndTypes();
        final String propertyType = propertyNamesAndTypes.get(propertyName);
        final WebElement propertyRow = getPropertyRow(propertyName);
        switch (propertyType) {
            case "string":
            case "float":
            case "integer":
                final WebElement propertyInput = propertyRow.findElement(By.xpath(XpathSelector.INPUT_PROPERTY.getXpath(propertyName)));
                return propertyInput.getAttribute("value");
            case "list":
                final List<WebElement> elements = propertyRow
                    .findElements(By.xpath(XpathSelector.INPUT_PROPERTY_LIST_STRING_TYPE_VALUE.getXpath(propertyName)));
                return elements.stream().map(webElement -> webElement.getAttribute("value")).collect(Collectors.toList());
            default:
                throw new UnsupportedOperationException(String.format("Retrieve value of property type %s is not yet supported", propertyType));
        }
    }

    /**
     * Checks if a property exists.
     * @param propertyName the property name
     * @return the value of the property
     */
    public boolean isPropertyPresent(final String propertyName) {
        isPropertiesTableLoaded();
        try {
            waitForElementVisibility(By.xpath(XpathSelector.PROPERTY_CHECKBOX.getXpath(propertyName)), 5);
        } catch (final Exception ignored) {
            return false;
        }
        return true;
    }

    /**
     * Saves a property
     */
    public void saveProperties() {
        final WebElement saveBtn = waitForElementVisibility(By.xpath(XpathSelector.PROPERTY_SAVE_BTN.getXpath()));
        assertTrue(saveBtn.isEnabled(), "Property save button should be enabled.");
        saveBtn.click();
        loaderHelper.waitForLoaderInvisibility(20);
        notificationComponent.waitForNotification(NotificationType.SUCCESS, 20);
    }

    /**
     * Adds a property
     * @param propertiesMap the properties map to be added
     */
    public void addProperties(final Map<String, String> propertiesMap) {
        isPropertiesTableLoaded();
        propertiesMap.forEach((propertyName, propertyType) -> {
            final By addPropertyButtonLocator = By.xpath(XpathSelector.PROPERTY_ADD_BTN.getXpath());
            waitForElementVisibility(addPropertyButtonLocator, 30);
            final WebElement addPropertyRightColumn = findElement(By.xpath(XpathSelector.PROPERTY_ADD_RIGHT_COLUMN_DIV.getXpath()));
            final WebElement propertyAddButton = addPropertyRightColumn.findElement(addPropertyButtonLocator);
            assertTrue(propertyAddButton.isDisplayed(), "Property add button should be enabled.");
            propertyAddButton.click();
            createProperty(propertyName, propertyType);
            verifyProperty(propertyName);
            ExtentTestActions.takeScreenshot(Status.INFO, "added-property",
                String.format("Property '%s' was created on component", propertyName));
        });
    }

    /**
     * Creates a map based on property names and data types
     */
    public Map<String, String> getPropertyNamesAndTypes() {
        isPropertiesTableLoaded();
        final Map<String, String> namesAndTypes = new HashMap<>();
        final List<WebElement> names = findElements(By.xpath(XpathSelector.PROPERTY_NAMES.getXpath()));
        final List<WebElement> types = findElements(By.xpath(XpathSelector.PROPERTY_TYPES.getXpath()));

        for (int i = 0;i < names.size();i++) {
            namesAndTypes.put(names.get(i).getAttribute("innerText"), types.get(i).getAttribute("innerText"));
        }

        return namesAndTypes;
    }

    /**
     * Gets the property row element for the given propertyName
     * @param propertyName the property name
     * @return the property row element
     */
    private WebElement getPropertyRow(String propertyName) {
        final By propertyCheckboxLocator = By.xpath(XpathSelector.PROPERTY_CHECKBOX.getXpath(propertyName));
        final WebElement propertyCheckbox = waitForElementVisibility(propertyCheckboxLocator, 5);
        return propertyCheckbox.findElement(By.xpath("./../../.."));
    }

    /**
     * Sets a String value to a TOSCA property.
     * @param propertyName the property name
     * @param value property value to be set
     */
    private void setStringPropertyValue(final String propertyName, final String value) {
        if (value == null) {
            return;
        }
        isPropertiesTableLoaded();
        getPropertyRow(propertyName).findElement(By.xpath(XpathSelector.INPUT_PROPERTY.getXpath(propertyName))).sendKeys(value);
    }

    /**
     * Sets a boolean value to a TOSCA property.
     * @param propertyName
     */
    private void setBooleanPropertyValue(final String propertyName) {
        isPropertiesTableLoaded();
        new Select(getPropertyRow(propertyName).findElement(By.xpath(XpathSelector.SELECT_INPUT_PROPERTY.getXpath(propertyName)))).
            selectByVisibleText("TRUE");
    }

    /**
     * Sets a complex property  type value to a TOSCA property. It handles List and Map
     * @param propertyName the property name
     * @param objectValue the property complex type value
     */
    private void setComplexPropertyValue(final String propertyName, final Object objectValue) {
        if (objectValue == null) {
            return;
        }
        isPropertiesTableLoaded();
        final WebElement addToListLink = getPropertyRow(propertyName)
            .findElement(By.xpath(XpathSelector.PROPERTY_ADD_VALUE_COMPLEX_TYPE.getXpath(propertyName)));
        if (objectValue instanceof List) {
            setValueFromList(propertyName, (List) objectValue, addToListLink);
        }
        if (objectValue instanceof Map) {
            setValueFromMap(propertyName, (Map<?, ?>) objectValue, addToListLink);
        }
    }

    /**
     * Sets a value to a complex (List) property type.
     * @param propertyName the property name
     * @param values the List of values to be added to the given property name
     * @param addToListLink the link to add the input value
     */
    private void setValueFromList(final String propertyName, final List<String> values, final WebElement addToListLink) {
        final AtomicInteger inputIndex = new AtomicInteger(0);
        values.forEach(value -> {
            addToListLink.click();
            final WebElement propertyInput = addToListLink.findElement(By.xpath(XpathSelector.INPUT_PROPERTY_COMPLEX_TYPE_VALUE.getXpath(
                String.valueOf(new StringBuilder(propertyName).append(".").append(inputIndex)))));
            propertyInput.sendKeys(value);
            inputIndex.getAndIncrement();
        });
    }

    /**
     * Sets a value to a complex (Map) property type.
     * @param propertyName the property name
     * @param values the Map of values to be added to the given property name
     * @param addToListLink the link to add the input value
     */
    private void setValueFromMap(final String propertyName, final Map<?, ?> values, final WebElement addToListLink) {
        final AtomicInteger inputIndex = new AtomicInteger(0);
        values.forEach((key, value) -> {
            addToListLink.click();
            WebElement propertyInput;
            // Add Key
            propertyInput = addToListLink.findElement(By.xpath(XpathSelector.INPUT_PROPERTY_COMPLEX_TYPE_KEY.getXpath(
                String.valueOf(new StringBuilder(propertyName).append(".").append(inputIndex)))));
            propertyInput.sendKeys(key.toString());
            // Add Value
            propertyInput = addToListLink.findElement(By.xpath(XpathSelector.INPUT_PROPERTY_COMPLEX_TYPE_VALUE.getXpath(
                String.valueOf(new StringBuilder(propertyName).append(".").append(inputIndex)))));
            propertyInput.sendKeys(value.toString());
            inputIndex.getAndIncrement();
        });
    }

    /**
     * Fills the creation property modal.
     * @param propertyName the property name to be created
     * @param propertyType the property type to be selected
     */
    private void createProperty(final String propertyName, final String propertyType) {
        final AddPropertyModal addPropertyModal = new AddPropertyModal(webDriver);
        addPropertyModal.isLoaded();
        addPropertyModal.fillPropertyForm(propertyName, propertyType);
        addPropertyModal.clickOnCreate();
    }

    /**
     * Verifies if the added property is displayed on the UI.
     * @param propertyName the property name to be found
     */
    private void verifyProperty(final String propertyName) {
        final By propertyCheckboxLocator = By.xpath(XpathSelector.PROPERTY_CHECKBOX.getXpath(propertyName));
        final WebElement propertyCheckbox = waitForElementVisibility(propertyCheckboxLocator, 5);
        assertTrue(propertyCheckbox.isDisplayed(), String.format("%s Property should be displayed", propertyName));
        assertTrue(this.getPropertyNamesAndTypes().containsKey(propertyName),
            String.format("%s Property should be listed but found %s", propertyName, this.getPropertyNamesAndTypes().toString()));
    }

    /**
     * select property
     */
    public void selectProperty(String propertyName){
        isPropertyPresent(propertyName);
        waitToBeClickable(By.xpath(ResourcePropertiesAssignmentTab.XpathSelector.PROPERTY_CHECKBOX.getXpath(propertyName))).click();
    }

    public void loadComponentInstanceProperties(final String instanceName){
        waitToBeClickable(By.xpath(ResourcePropertiesAssignmentTab.XpathSelector.INSTANCE_SPAN.getXpath(instanceName))).click();
    }

    public void clickOnDeclareInput(){
        waitToBeClickable(By.xpath(ResourcePropertiesAssignmentTab.XpathSelector.DECLARE_INPUT_BTN.getXpath())).click();
    }

    public void loadCompositionTab(){
        waitToBeClickable(By.xpath(ResourcePropertiesAssignmentTab.XpathSelector.COMPOSITION_TAB.getXpath())).click();
    }

    /**
     * Enum that contains identifiers and xpath expressions to elements related to the enclosing page object.
     */
    @AllArgsConstructor
    private enum XpathSelector {
        MAIN_DIV("w-sdc-main-right-container", "//div[@class='%s']"),
        PROPERTIES_TAB("//*[contains(@data-tests-id, 'Properties') and contains(@class, 'active')]"),
        PROPERTIES_TABLE("properties-table", "//div[contains(@class,'%s')]"),
        NO_DATA_MESSAGE("no-data", "//div[contains(@class,'%s') and text()='No data to display']"),
        SOFTWARE_VERSION_PROPERTY_CHECKBOX("software_versions", "//checkbox[@data-tests-id='%s']"),
        SOFTWARE_VERSION_INPUT("value-prop-software_versions", "//input[starts-with(@data-tests-id,'%s')]"),
        PROPERTY_CHECKBOX("//checkbox[@data-tests-id='%s']"),
        PROPERTY_SAVE_BTN("properties-save-button", "//button[@data-tests-id='%s']"),
        PROPERTY_ADD_RIGHT_COLUMN_DIV("right-column", "//div[@class='%s']"),
        PROPERTY_ADD_BTN("add-btn", "//div[contains(@class,'%s')]"),
        PROPERTY_ADD_VALUE_COMPLEX_TYPE("//a[contains(@data-tests-id, 'add-to-list-%s')]"),
        INPUT_PROPERTY_COMPLEX_TYPE_KEY("//input[contains(@data-tests-id, 'value-prop-key-%s')]"),
        INPUT_PROPERTY_COMPLEX_TYPE_VALUE("//input[contains(@data-tests-id, 'value-prop-%s')]"),
        INPUT_PROPERTY_LIST_STRING_TYPE_VALUE("//input[starts-with(@data-tests-id, 'value-prop-%s')]"),
        INPUT_PROPERTY("//input[@data-tests-id='value-prop-%s']"),
        SELECT_INPUT_PROPERTY("//select[@data-tests-id='value-prop-%s']"),
        PROPERTY_TYPES("//*[contains(@data-tests-id, 'propertyType')]"),
        PROPERTY_NAMES("//*[contains(@data-tests-id, 'propertyName')]"),
        DECLARE_INPUT_BTN("declare-button declare-input", "//button[@data-tests-id='%s']"),
        COMPOSITION_TAB("Composition", "//div[contains(@class,'tab') and contains(text(), '%s')]"),
        INSTANCE_SPAN("//span[@data-tests-id='%s']");

        @Getter
        private String id;
        private final String xpathFormat;

        XpathSelector(final String xpathFormat) {
            this.xpathFormat = xpathFormat;
        }

        public String getXpath() {
            return String.format(xpathFormat, id);
        }

        public String getXpath(final Object... xpathParams) {
            return String.format(xpathFormat, xpathParams);
        }
    }

}
