
# Prerequisites

- Java 11 or later
- Maven 3.6+
- Google Chrome / Firefox / Edge browser
- Internet connection (for WebDriverManager)
# project structure 

pat/
├── src/
│ ├── basetest/ 
│ ├── genericUtilities/ # Thread-safe WebDriver & ExtentTest handlers
│ ├── businessUtilities/ # Custom business logic (e.g., date validation)
│ ├── listenerimplementation/ # TestNG Listener + Extent report integration
│ ├── task/ # Test classes (Task1, Task2, etc.)
│ └── resources/ # Properties files and test data
├── reports/ # Auto-generated Extent HTML reports
├── pom.xml # Maven project config
└── testng.xml # TestNG suite for parallel execution

# Author
**Anil Kumar Uppari**
