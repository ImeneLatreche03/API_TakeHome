# API_TakeHome



-This repository is for the API testing

-I have used:
	Java programming language,
	RestAssured library for Api automation.
	TestNG for the assertions and annotations.

-All the dependencies are added on the pom.xml file

-I have created a requestCall class where I provided all the request call methods using RestAssured.

-I created for each TC a separate class on ("src\test\java\testCases\")as below:

	TC_SuccessResponseforEachCall_VerifyUserCreated.java : to verify if Successful Response for each request call
        TC_Response_Code_422.java : to verify Response_Code_422 is returned as expected
        TC_Response_Code_405.java :  to verify Response_Code_404 is returned as expected
        TC_Response_Code_401.java : to verify Response_Code_401 is returned as expected
        TC_Response_Code_405.java : to verify Response_Code_405 is returned as expected

-An extent report is generated for my automation testing
