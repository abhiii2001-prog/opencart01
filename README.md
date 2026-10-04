# OpenCart Test Automation

This is my practice project for automating the OpenCart demo e-commerce site. I built it while learning Selenium and wanted to try a proper framework structure instead of writing scattered test scripts. It is still a work in progress and I keep adding new tests as I learn.

## What I used

Java, Selenium WebDriver, TestNG, Maven, Jenkins, Docker and Git.

## What's done so far

- Set up the Maven project with TestNG and a suite file (`master.xml`)
- Built the framework using Page Object Model
- Registration flow automated
- Login flow automated
- Negative test cases (invalid login, wrong registration details)
- Data-driven tests using external test data
- Explicit waits and assertions for stable tests
- Utility classes for screenshots and reading test data
- Automatic screenshot on test failure
- Logs and reports generated after every run
- Cross-browser testing on Chrome, Firefox and Edge
- Parallel execution
- Retry mechanism for flaky tests
- Jenkins job set up for CI
- Docker setup to run tests in a container
- Code pushed to GitHub with a `.gitignore` for generated files

## Coming soon

I'm adding the remaining flows one by one:

- Searching for a product
- Adding and removing items in the cart
- Checkout
- Logout

## Framework features

- Page Object Model so locators stay in page classes and tests stay clean
- Explicit waits instead of fixed waits so tests don't break on slow page loads
- Utility classes for common things like screenshots and reading data
- Data-driven testing, test data is kept outside the code in the `TestData` folder
- Screenshot is saved automatically when a test fails
- Runs on Chrome, Firefox and Edge
- Parallel execution to cut down the run time
- Retry for flaky failures
- Readable reports and logs after every run
- Jenkins integration for CI
- Can run inside a Docker container

## Folders

```
opencart01
│
├── src/test        # Page classes, test classes and utility classes
├── TestData        # External input data for data-driven tests
├── master.xml      # TestNG suite file that runs all the tests
├── pom.xml         # Maven dependencies and build configuration
├── run.bat         # Batch file to run the tests on Windows
└── .gitignore      # Files and folders Git should not track
```

`logs`, `reports` and `screenshots` folders are created automatically when tests run.


## Running it

Clone the repo:

```
git clone https://github.com/abhiii2001-prog/opencart01.git
```

Then from the project folder:

```
mvn clean test
```

or just double click `run.bat` on Windows. You need Java, Maven and a browser (Chrome, Firefox or Edge) installed.

## Things I want to improve

- Complete the remaining flows (search, cart, checkout, logout)
- Cover more modules like wishlist, product compare and order history
- Add database validation for registered users
- Try a BDD approach with Cucumber

## About me

I'm Abhay, a B.Tech CSE graduate from PSIT Kanpur, working towards a career in QA automation.

LinkedIn: https://linkedin.com/in/abhay-singh-39938325a
Email: 30853csiot@gmail.com
