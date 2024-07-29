**Secure Banking System**
The Secure Banking System is a Java-based application designed to provide a secure and user-friendly platform for managing basic banking operations. It integrates with a MySQL database to securely store and manage user data, including account balances and transaction histories.

**Features**
User Registration: Allows new users to create an account by providing a unique username and password. Stores user credentials and initial account balance in the MySQL database.
User Login: Authenticates users based on their username and password. Provides access to account functionalities upon successful login.
View Account Balance: Displays the current balance of the logged-in user’s account.
Deposit Funds: Allows users to deposit money into their account. Updates the account balance in the database accordingly. Records each deposit transaction in the transaction history.
Withdraw Funds: Enables users to withdraw money from their account. Ensures sufficient balance before processing the withdrawal. Updates the account balance and records the transaction in the database.
Transaction History: Maintains a record of all transactions (deposits and withdrawals) for each user. Allows users to view their transaction history for better financial management.

**Install dependencies**
mvn clean install

**Usage**
1) Clone the repository: 
git clone https://github.com/Aravind240803/secure-banking-system.git
cd Secure-Banking-System

2) Set up the MySQL database:
- Create a new database named banking_system.
- Run the SQL scripts provided in the sql directory to create the necessary tables.
  
3) Configure the database connection:
Update the database connection details in the DatabaseConnection.java file.

4) Run the application:
- Open the project in IntelliJ IDEA.
- Run the Main class to start the application.

**Result**
The Secure Banking System allows users to register, log in, view their account balance, deposit and withdraw funds, and view their transaction history. All operations are securely handled and recorded in the MySQL database.

**Future Improvements**
Security Enhancements: Implement additional security measures such as encryption for user credentials.
Feature Expansion: Add more banking features like fund transfers and account statements.
User Interface Improvements: Develop a graphical user interface for a better user experience.
