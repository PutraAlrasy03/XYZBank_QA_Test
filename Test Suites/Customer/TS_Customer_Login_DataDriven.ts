<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>TS_Customer_Login_DataDriven</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>10</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>5b06e375-d92c-435f-8f03-13914f217ab6</testSuiteGuid>
   <testCaseLink>
      <guid>0dbc953f-fa56-43cb-a02d-b756a11a2124</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <iterationNameVariable>
         <defaultValue>'Hermoine Granger'</defaultValue>
         <description></description>
         <id>d88b9c42-a8c5-45d6-b907-21dabe5ad410</id>
         <masked>false</masked>
         <name>customerName</name>
      </iterationNameVariable>
      <testCaseId>Test Cases/Customer_Testcase/TC_CUST_01_Login_Valid</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>454f8fc6-31e4-4216-ba1a-481cb002bc34</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/List_Customer_Name</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>454f8fc6-31e4-4216-ba1a-481cb002bc34</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>CustomerName</value>
         <variableId>d88b9c42-a8c5-45d6-b907-21dabe5ad410</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
