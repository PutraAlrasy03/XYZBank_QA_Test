# QA Automation – Banking Project

## 📋 Project Overview

This repository contains **manual and automated test coverage** for the **GlobalSQA Banking Project** application:

🔗 [https://www.globalsqa.com/angularJs-protractor/BankingProject](https://www.globalsqa.com/angularJs-protractor/BankingProject)

The purpose of this assessment is to validate core banking functionalities, ensure data integrity, and demonstrate a **well-structured automation framework** implemented using **Katalon Studio**.

---

## 🎯 Scope of Testing

### 👤 Customer Module

* Login (Valid)
* Account Display Verification
* Account Switching
* Deposit

  * Valid
  * Invalid
* Withdraw

  * Valid
  * Insufficient Balance
* Transaction History
* Transaction Record Validation

  * Type (Credit / Debit)
  * Amount
  * Timestamp
* Data Persistence

  * After Logout
  * After Page Refresh

### 👨‍💼 Manager Module

* Login
* Add Customer

  * Valid
  * Invalid
* Open Account
* Search Customer
* Delete Customer

---

## 🧪 Test Coverage Highlights

* Positive and negative test scenarios
* Input validation and error handling
* Transaction integrity verification
* Data persistence across sessions
* Clear separation of Customer and Manager flows
* Reusable and maintainable test cases
* Data-driven testing where applicable

---

## 🛠 Automation Framework

### Tools & Technologies

* **Katalon Studio**
* Groovy-based scripting
* Built-in WebUI keywords

### Framework Design Principles

* Reusable common utilities
* Modular test case structure
* Clear naming convention:

  * `TC_CUST_XX_*` for Customer test cases
  * `TC_MGR_XX_*` for Manager test cases
* Logical grouping via Test Suites
* Minimal duplication and improved maintainability

---

## 📂 Project Structure Overview

* **Test Cases**

  * `Common_Utilities`
  * `Customer_Testcase`
  * `Manager_Testcase`
* **Object Repository**

  * Page-based object organization
* **Test Suites**

  * Customer transaction suite
  * Manager operation suites
  * Full regression suite
* **Data Files**

  * Customer and account data for data-driven execution

---

## 📊 Manual Test Cases

Manual test cases were documented in Google Sheets and include:

* Test Case ID
* Test Description
* Preconditions
* Test Steps
* Expected Result
* Actual Result
* Priority
* Automation Feasibility

🔗 **Manual Test Case Document:**
[https://docs.google.com/spreadsheets/d/1GFQkwAv8OfXHHFQyxVPdsKXY0EOePtQaEKYu_Ph4Lxs/edit?usp=sharing](https://docs.google.com/spreadsheets/d/1GFQkwAv8OfXHHFQyxVPdsKXY0EOePtQaEKYu_Ph4Lxs/edit?usp=sharing)

These test cases comprehensively cover functional flows, validation scenarios, and data integrity checks.

---

## 🔄 Automation Coverage

The following key features have been automated:

* Customer Transactions (Deposit / Withdraw / Transaction History)
* Add Customer
* Open Account
* Search and Delete Customer
* Data Persistence Validation

---

## 📌 Key Validations Implemented

* Balance updates correctly after deposit and withdrawal
* Withdrawal is blocked when balance is insufficient
* Transaction history records correct:

  * Transaction type
  * Amount
  * Timestamp
* Customer data persists after logout and page refresh
* Validation alerts appear for invalid inputs
* Confirmation alerts appear for successful operations

---

## ▶ How to Execute Tests

1. Open the project in **Katalon Studio**
2. Navigate to **Test Suites**
3. Execute one of the following:

   * `TS_CUST_01_Customer_Transaction`
   * `TS_MGR_01_Manager_Operations`
   * `TS_MGR_02_Search_and_Delete_Operations`

### 🔁 Full Regression Execution

To run **all automated test cases**, execute:

```
TS_FULL_REGRESSION
```

---

## 📈 Evaluation Criteria Alignment

This project demonstrates:

* Comprehensive functional test coverage
* Strong focus on data validation and integrity
* Clean, modular automation framework
* Reusable and maintainable test design
* Clear traceability between manual and automated tests


