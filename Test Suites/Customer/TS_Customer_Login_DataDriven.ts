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
      <testCaseId>Test Cases/Customer_Testcase/Customer_Page</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>ffc6d8ae-05fb-4942-b28f-12ff7c950eb1</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/List_Customer_Name</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>ffc6d8ae-05fb-4942-b28f-12ff7c950eb1</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>CustomerName</value>
         <variableId>d88b9c42-a8c5-45d6-b907-21dabe5ad410</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
