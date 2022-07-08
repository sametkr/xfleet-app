Feature: Xfleet app login feature
  User Story: As a user, I should be able to log in

  Acceptance Criteria:

  1- All users can log in with valid credentials (We have 3 types of users such as sales manager, store manager, truck driver).
  - Driver should land on the "Quick Launchpad" page after successful login
  - Sales Manager/ Store Manager should land on the "Dashboard" page after successful login
  2- "Invalid username or password." should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
  3- "Please fill out this field" message should be displayed if the password or username is empty
  4- User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
  5- User can see "Remember Me" link exists and is clickable on the login page
  6- User should see the password in bullet signs by default
  7- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
  8- All users can see their own usernames in the profile menu, after successful login

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the login page

  @FLTAPS-1830
  Scenario: Login as a Driver
    When user enters username "user1"
    And user enters password "UserUser123"
    And user clicks login button
    Then user should land on "Quick Launchpad" page

  @FLTAPS-1831
  Scenario: Login as a Sales Manager
    When user enters username "Salesmanager101"
    And user enters password "UserUser123"
    And user clicks login button
    Then user should land on "Dashboard" page

  @FLTAPS-1832
  Scenario: Login as a Store Manager
    When user enters username "storemanager51"
    And user enters password "UserUser123"
    And user clicks login button
    Then user should land on "Dashboard" page

  @FLTAPS-1833
  Scenario Outline: "Invalid user name or password." should be displayed for invalid credentials
    When user enters invalid credentials "<username>" and "<password>"
    Then user should see "Invalid user name or password."
    Examples:
      | username | password    |
      | user1    | useruser321 |
      | kuser1   | UserUser123 |

  @FLTAPS-1834
  Scenario Outline: "Please fill out this field" message should be displayed if the password or username is empty
    When user enters invalid credentials "<username>" and "<password>"
    Then user should see Please fill out this field. message
    Examples:
      | username | password    |
      | user1    |             |
      |          | UserUser123 |

  @FLTAPS-1835
  Scenario: User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    When user clicks Forgot your password?
    Then user should land on "Forgot Password" page

  @FLTAPS-1836
  Scenario: User can see "Remember Me" link exists and is clickable on the login page
    Then user should see Remember me on this computer
    Then user should be able to click Remember me on this computer checkbox

  @FLTAPS-1837
  Scenario: User should see the password in bullet signs by default
    When user enters password "UserUser123"
    Then User should see the password in bullet signs by default

  @FLTAPS-1838
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When user enters username "Salesmanager101"
    And user enters password "UserUser123"
    And user presses the enter key on the keyboard
    Then user should land on "Dashboard" page

  @FLTAPS-1839
  Scenario Outline: All users can see their own usernames in the profile menu, after successful login
    When user enters invalid credentials "<username>" and "<password>"
    Then user should see own "<username>" in the profile menu
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | Salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |




