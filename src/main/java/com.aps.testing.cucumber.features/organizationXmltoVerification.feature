@tag
Feature: running an XML to db validation for organization data

  @tag1
  Scenario Outline: Taking input data from organization XML file and run a validation on how to gets written to the DB for organization
    Given I upload the organization xml file using a shell script using a "<user>" and a "<host>" and "<privateKey>" and "<file>"
    #When I run sql query to get the current identity organization attributes for "<currId>"
    #Then The "<BusinessName>", "<LegalBusinessName>", "<TaxID>" , "<IssueDate>" , "<IssueState>" and "<ExpirationDate>", "<AddressLine1>", "<AddressLine2>" , "<City>" , "<State>" , "<PostalCode>" from the XML should match with the output of the DB

    Examples: 
      | user     | host          | privateKey       | file                         | currId   | BusinessName                                   | LegalBusinessName                              | TaxID     | IssueDate  | ExpirationDate | AddressLine1 | AddressLine2           | City          | State           | PostalCode |       |
      | ec2-user | 34.207.124.72 | aps_instance.pem | Person.xml | 29820173 | ADIRONDACK MEDICAL HEALTH CARE ASSOCIATES PLLC | ADIRONDACK MEDICAL HEALTH CARE ASSOCIATES PLLC | 601000000 | 1967-08-13 | 1967-08-13     | VT           | 3000C, Corres-301 road | Line2 adreess | Corres-301 City | MD         | 30100 |
