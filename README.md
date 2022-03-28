# System Requirements

1. JAVA - Java [JDK or JRE - 1.8](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

# Software Requirements

1. Gradle - Gradle 4.7 [Gradle](https://gradle.org/install) for higher version gradle does not compile lombok code [BUG](https://github.com/rzwitserloot/lombok/issues/1945)
2. IDE - [Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac)
3. TestNG for eclipse [link](https://www.jetbrains.com/idea/download/#section=mac)
4. lombok setup for eclipse [link](https://projectlombok.org/setup/eclipse)

# Tools Used
1. [Gradle](https://gradle.org) - This is the build tool used to configure and install all the required dependant libraries and run tests from command line on local and remote machines.
2. [Selenium](https://www.seleniumhq.org/) - This is library used to intaract with browser and perform all the actions required.
3. [TestNG](https://testng.org/doc/index.html) - Test framework used to organise and run tests.
4. [lombok](https://projectlombok.org/) - To generate setter,getter,constructors and toString methods at runtime for POJO as data providers. 
5. Java 1.8 as programming language.
6. Extent,TestNG - For reporting after execution of test cases.
7. Log4j - For logging information, warnings and errors.

# Steps to Setup
1. Install all the prerequisite softwares. 
2. Unzip the file which is sent in email.
3. Import this project as gradle project (File -> Import -> Gradle -> Existing gradle project -> Next -> Browse to the project location on local system -> Finish)
4. All the dependencies mentioned in build.gradle file will be downloaded automatically by eclipse,wait till download is completed.
5. Open qa.config.properties file (under src/test/resources) and fill up the required details.
i.e. 	`url=https://www.amazon.com`
		`browser=chrome`
		`remoteDriver=false`
		`apppassword=<your_app_password>`
6. Goto project location (till you see build.gradle file) in command line interface.
7. Locate `src/test/resources/testng.xml` file and right click and run as `Run as TestNG Suite`
8. If all the softwares are downloaded properly,browser will pop up and test cases will start executing.

For any queries please drop an email to `umang.lavania@gmail.com`.
