Feature: Sample test on parsing XML file

Scenario: Sample test 1
Given I have a xml file
And I connected to the DB
When I extract data from XML
And I extract data from DB
#Then XML data should match with DB data