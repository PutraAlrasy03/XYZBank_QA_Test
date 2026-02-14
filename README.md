# QA Automation Assessment – Banking Project

## 📋 Project Overview

This repository contains manual and automated test coverage for the GlobalSQA Banking Project application:

https://www.globalsqa.com/angularJs-protractor/BankingProject

The objective of this assessment is to validate core banking functionalities, ensure data integrity, and demonstrate structured automation framework design using Katalon Studio.

---

## 🎯 Scope of Testing

The following modules were covered:

### 👤 Customer Module
- Login (Valid)
- Account Display Verification
- Account Switching
- Deposit (Valid & Invalid)
- Withdraw (Valid & Insufficient Balance)
- Transaction History
- Transaction Record Validation (Credit/Debit/Amount/Timestamp)
- Data Persistence (Logout & Refresh)

### 👨‍💼 Manager Module
- Login
- Add Customer (Valid & Invalid)
- Open Account
- Search Customer
- Delete Customer

---

## 🧪 Test Coverage Highlights

- Positive and Negative scenarios
- Data validation and integrity checks
- Transaction record verification (type, amount, timestamp)
- Data persistence across sessions
- Structured reusable test cases
- Data-driven testing (where applicable)

---

## 🛠 Automation Framework

### Tool Used
- **Katalon Studio**
- Groovy-based scripting
- Built-in WebUI keywords

### Design Principles Applied
- Reusable login logic
- Separation of Customer and Manager flows
- Clear naming convention (TC_CUST_XX / TC_MGR_XX)
- Dynamic object handling where necessary
- Minimal duplication

---

## 📊 Manual Test Cases

Manual test cases were created in Excel format including:

- Test Case ID
- Description
- Preconditions
- Test Steps
- Expected Result
- Actual Result
- Priority
- Automation Feasibility

The test cases comprehensively cover functional, validation, and data integrity scenarios.

---

## 🔄 Automation Coverage

The following key functionalities were automated:

- Transaction Handling (Deposit / Withdraw / History)
- Add Customer
- Open Account
- Data Persistence Validation

Automation exceeds the minimum requirement of two key features.

---

## 📌 Key Validations Implemented

- Balance updates correctly after deposit/withdraw
- Withdrawal restriction when insufficient funds
- Transaction history records correct:
  - Type (Credit/Debit)
  - Amount
  - Timestamp
- Customer data persists after logout and refresh
- Validation alerts for invalid inputs
- Confirmation alerts for successful operations

---

## ▶ How to Execute

1. Open project in Katalon Studio
2. Select desired Test Suite:
   - `TS_CUST_01_Customer_Transaction`
   - `TS_MGR_01_Manager_Operations`
   - `TS_MGR_02_Search_and_Delete_Operations`
3. Execute in preferred browser

---

## 📈 Evaluation Criteria Alignment

This solution addresses:

- Comprehensive functional coverage
- Attention to data validation
- Structured automation framework
- Clean modular organization
- Reusability and maintainability

---

## 👤 Candidate Information

QA Automation Assessment Submission  
Prepared as part of technical evaluation.

---

## ✅ Status

All core functional scenarios have been validated and automated where applicable.

