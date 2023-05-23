Feature: Swiggy Application

Background:
Given The user in in Swiggy Home Page

Scenario Outline: Check the user is displayed restaurants according to location selected

When The user enters <location>
Then The user clicks on Location from list of locations displayed
Then Verify the user is in restaurants page as per location selected
When The user clicks on any restaurant
Then Verify that the correct restaurant page is opened

Examples:
|location|
|Kolkata|
|Pune|
|Chandigarh|




  
