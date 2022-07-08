Feature: Xfleet app log out feature
  User Story: As a user, I should be able to log out

  Acceptance Criteria:

  1- The user can log out and ends up on the login page.
  2- The user can not go to the home page again by clicking the step back button after successfully logging out.
  3- The user must be logged out if the user close the open tab (all tabs if there are multiple open app tabs)

  Background: For the scenarios in the feature file, user is expected to be already logged in
    Given user is already logged as a "Store Manager"

  @FLTAPS-1884
  Scenario: The user can log out and ends up on the login page
    When user clicks username dropdown and clicks Logout button
    Then user should land on login page

  @FLTAPS-1885
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logging out
    When user clicks username dropdown and clicks Logout button
    And user clicks step back button
    Then user should land on login page

  @FLTAPS-1887
  Scenario: The user must be logged out if the user close the open tab (all tabs if there are multiple open app tabs)
    When user closes the all tabs without using logout function
    And user navigates to the profile page
    Then user should land on login page without logged in