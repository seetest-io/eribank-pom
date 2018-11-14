# seetest.io - Page Object Model using TestNG Framework.

This Project demonstrates Page Object Model Design Pattern using Java based TestNG Framework and Applium libraries

This example will cover:

1. Test which run against seetest cloud.
2. Usage of Appium and Selenium libraries to test Mobile and Web Application.
3. Running tests on iOS \ Android.

### Steps to run demo test

1. Clone this git repository

	```
	git clone 
	```

2. Obtain access key from seetest.io cloud

    https://docs.seetest.io/display/SEET/Execute+Tests+on+SeeTest+-+Obtaining+Access+Key

    note :  you need to have a valid subscription or a trial to run this test (Trial \ paid)

3. Upload the eribank application to your project
    Download the Android app : https://experitest.s3.amazonaws.com/eribank.apk
    Download the iOS app : https://experitest.s3.amazonaws.com/EriBank.ipa

    Go to the cloud "Mobile Application Center" and upload both apps 
    https://cloud.seetest.io/index.html#/applications

4. To Run the the tests use testng.xml file
    
    Make sure you set the envionment variable with valid access key obtained using Step 2.
    
    Use the command line set Environment variable.
    
	```
	set SEETEST_IO_ACCESS_KEY = <your access key>
	``` 
	
    Use the command line run the test as below
    
	```
	gradlew runTests
	```
    
    ### Note : 
    If you are using IDE like IntelliJ, make sure you create a Run configuration to use testng.xml. 
    Set the Enviornment variable and then proceed to execute the test.

### How to change to your own application

1. Upload you application to the cloud

(review step two in guide)

2. Change the android application name or iOS application name in the /src/main/java/resources/seetest.properties file

    For IOS,
    
	```
	ios.app.name = com.company.app
	``` 
    
    For Android,
    
    ```
    android.app.name = com.company.app/.appActivity
    ```

4. Modify the tests 

change the @Test methods at EriBankTests

you can paste the code you've exported from SeeTestAutomation 

