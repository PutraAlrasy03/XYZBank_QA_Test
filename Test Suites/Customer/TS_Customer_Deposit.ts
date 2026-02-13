<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>TS_Customer_Deposit</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>10</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>fe1cec6b-6329-4dfc-a518-35f44b1f479b</testSuiteGuid>
   <testCaseLink>
      <guid>a982664e-2b73-456c-8f8b-3d834810bade</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <iterationNameVariable>
         <defaultValue>'Hermoine Granger'</defaultValue>
         <description></description>
         <id>7424c329-dcf7-41b9-82b0-cbbd2d3229df</id>
         <masked>false</masked>
         <name>customerName</name>
      </iterationNameVariable>
      <testCaseId>Test Cases/Customer_Testcase/TC_CUST_04_Deposit_Valid</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>590ba6a0-561d-4ac2-bbc5-c9b2cf274a2c</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/List_Customer_Name</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>590ba6a0-561d-4ac2-bbc5-c9b2cf274a2c</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>CustomerName</value>
         <variableId>7424c329-dcf7-41b9-82b0-cbbd2d3229df</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
