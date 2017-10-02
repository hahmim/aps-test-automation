Feature: Validate what's in DB against the content of  XML input data

  Scenario: Taking input data from XML file and run a validation on how to gets written to the DB
    Given I upload xml file using a shell script using a <user> and a <host> and <privateKey> and <file>
    |ec2-user|<user>|
    |34.207.124.72|<host>|
    |aps_instance.pem|<privateKey>|
    |Person.xml|<file>|
    When I run sql query to get the current identity attributes for <currId>
    |29820140|<currId>|
    Then the <firstName>,  <lastName>, <SSN> and <DOB> from the XML should match with the output of the DB
