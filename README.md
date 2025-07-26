# Java Command-Line Mood Tracker Application

This is a simple console-based Mood Tracker application built with Java. It allows users to record their daily moods and view a history of their past entries. All mood data is persistently stored in a MySQL database.

## Features

-   **Record Mood:** Users can input their current mood (e.g., Happy, Sad, Neutral, Excited).
-   **View Mood History:** Retrieve and display all previously recorded moods, along with their respective dates.
-   **Data Persistence:** All mood entries are stored in a MySQL database, ensuring data is saved even after the application closes.

## Technologies Used

-   **Java:** Core programming language.
-   **JDBC (Java Database Connectivity):** Used to establish and manage connections to the MySQL database, execute SQL queries, and process results.
-   **MySQL Database:** The relational database management system used for storing mood entries.
-   **`java.sql.*`:** Core Java API for database operations (Connection, Statement, PreparedStatement, ResultSet).
-   **`java.util.ArrayList`:** For temporarily storing mood data retrieved from the database.
-   **`java.util.Scanner`:** For handling user input from the console.

## Prerequisites

Before running this application, you need to have:

1.  **Java Development Kit (JDK):** Java 8 or newer is recommended.
2.  **MySQL Server:** A running instance of MySQL.
3.  **MySQL JDBC Driver:** You'll need the `mysql-connector-java` JAR file.
    * **In IntelliJ IDEA:**
        * Go to `File > Project Structure...` (`Ctrl+Alt+Shift+S` / `Cmd+;`).
        * Under "Project Settings," select "Libraries."
        * Click the `+` icon, then "Java."
        * Navigate to where you downloaded the `mysql-connector-java-X.X.X.jar` file and select it. (If you don't have it, search for "mysql-connector-java download" online).
        * Click "OK" on all dialogs.
4.  **Database Setup:**
    * **Create the database:** Open your MySQL client (e.g., MySQL Workbench, command line) and run:
        ```sql
        CREATE DATABASE mood_tracker;
        ```
    * **Create the `moods` table:**
        ```sql
        USE mood_tracker;
        CREATE TABLE moods (
            id INT AUTO_INCREMENT PRIMARY KEY,
            mood VARCHAR(255) NOT NULL,
            date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        );
        ```
    * **Update credentials in `MoodDAO.java`:** Ensure `DB_USER` (`"root"`) and `DB_PASS` (`"Kanish@030805"`) in `MoodDAO.java` match your MySQL credentials.

## How to Run

1.  **Clone/Download the Repository:**
    ```bash
    git clone [https://github.com/Kanishka0308-05/MoodTracker.git](https://github.com/Kanishka0308-05/MoodTracker.git)
    cd MoodTracker
    ```
    (Ensure `Kanishka0308-05` matches your actual GitHub username.)
2.  **Open in IntelliJ IDEA:**
    * Open IntelliJ IDEA and select "Open" then navigate to the `MoodTracker` project folder.
3.  **Ensure JDBC Driver is Configured:** Follow the "MySQL JDBC Driver" steps in the Prerequisites section above within IntelliJ.
4.  **Run the Main Application:**
    * Locate your main application class (likely `MoodTracker.java` or `App.java` if you have a separate main class, otherwise `MoodDAO.java` could be extended with a main method for demonstration).
    * Right-click the file with the `public static void main(String[] args)` method (e.g., `MoodTracker.java`) in IntelliJ's Project pane.
    * Select **"Run 'YourMainClass.main()'"**.
    * Follow the on-screen prompts in the console.

## Lessons Learned & Skills Demonstrated

-   **Database Integration (JDBC):** Gained practical experience connecting Java applications to a relational database (MySQL) using JDBC.
-   **SQL Operations:** Implemented basic SQL commands (INSERT, SELECT) within Java code to perform CRUD (Create, Read, Update, Delete) operations.
-   **Data Persistence:** Successfully achieved persistent data storage, allowing application data to survive restarts.
-   **Exception Handling:** Practiced handling `SQLException` for robust database interactions.
-   **Modular Design (DAO Pattern):** Designed and implemented a Data Access Object (DAO) layer to separate database logic from business logic, improving code organization and maintainability.
-   **User Input and Console Interaction:** Used `Scanner` for effective user interaction in a command-line environment.
-   **Project Setup & Dependencies:** Understood how to configure external libraries (JDBC driver) within an IntelliJ IDEA project.
