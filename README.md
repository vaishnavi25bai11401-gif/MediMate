# MediMate

MediMate is a desktop application for keeping track of family members and their medicines. It gives you one dashboard for viewing medication details, recording doses, and noticing when stock is running low.

## What it can do

- Add and view family members
- Add medicines for a specific family member
- Store dosage, scheduled time, and current stock
- Mark a medicine as taken or missed
- Reduce stock automatically when a medicine is marked as taken
- Show a low-stock alert when the remaining stock reaches the threshold
- View the medication history for the current session

## Setup and running

Follow these steps from a fresh checkout. The commands below are for PowerShell on Windows; the same Java commands also work in a terminal on macOS or Linux with `/` used in place of `\`.

### 1. Install the environment

Install a Java Development Kit (JDK) version 8 or newer. MediMate uses standard Java and Swing APIs, so a JDK is required for both compiling and running the application.

Check that Java is available:

```powershell
java -version
javac -version
```

If either command is not recognized, install a JDK and reopen the terminal so the Java `bin` directory is available on your `PATH`.

### 2. Open the project directory

Change into the directory that contains this README and the `src` folder:

```powershell
cd path\to\MediMate
```

### 3. Install dependencies

There are no third-party libraries, package managers, or dependency installation commands required. MediMate uses only the Java standard library, including Swing and `java.time.LocalDateTime`.

### 4. Configure the project

No configuration file, database, environment variable, or API key is required. The application starts with sample data defined in `src\Main.java`. Runtime data is kept in memory and is not saved when the application closes.

### 5. Compile the source code

Create the compiled output in the `out` directory:

```powershell
javac -d out src\Main.java src\gui\DashboardFrame.java src\model\*.java src\service\*.java
```

Run this command again whenever the source code changes.

### 6. Start MediMate

Launch the compiled application from the project root:

```powershell
java -cp out Main
```

The dashboard opens with a sample family member and medicine already loaded:

- Lata, age 65, grandmother
- BP Tablet, one tablet at 08:00 AM, stock of 10

### 7. Stop and clean the build

Close the dashboard window to stop the application. To remove compiled output and perform a clean build later, delete the `out` directory and repeat steps 5 and 6:

```powershell
Remove-Item -Recurse -Force out
```

The dashboard opens with a sample family member and medicine already loaded:

- Lata, age 65, grandmother
- BP Tablet, one tablet at 08:00 AM, stock of 10

## Using the dashboard

The buttons at the bottom of the window cover the main workflow:

- **Refresh** updates the dashboard display.
- **Add Family Member** creates a member and assigns an ID automatically.
- **Add Medicine** links a medicine to an existing member ID.
- **Mark Taken** records a taken dose and decreases the stock by one.
- **Mark Missed** records a missed dose without changing the stock.
- **View Records** displays the taken and missed entries with their timestamps.

New medicines use a low-stock limit of `5` through the current dashboard form.

## Project structure

```text
src/
├── Main.java                    Application entry point
├── gui/
│   └── DashboardFrame.java      Swing dashboard and dialogs
├── model/
│   ├── FamilyMember.java        Family member data
│   ├── Medicine.java            Medicine and stock data
│   └── MedicineRecord.java      Taken/missed history entries
└── service/
    ├── FamilyServices.java      Family member management
    └── MedicineService.java     Medicine and record management
```

## Notes

This is currently an in-memory application. Any family members, medicines, and records are lost when the program closes. There is no login, reminder notification, or file/database persistence yet, which keeps the project easy to run and useful as a starting point for those features.

## Built with

- Java
- Java Swing
- `java.time.LocalDateTime`
