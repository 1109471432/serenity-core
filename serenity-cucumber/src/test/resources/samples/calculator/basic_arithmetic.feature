@foo
@issue:ISSUE-123
@issue:ISSUE-234
@issue:ISSUE-456
Feature: Basic Arithmetic
  Calculing additions

  Background: A Calculator
    Given a calculator I just turned on

  @issue:ISSUE-456
  Scenario: Addition
  # Try to change one of the values below to provoke a failure
    When I add 4 and 5
    Then the result is 9

  Scenario: Another Addition
  # Try to change one of the values below to provoke a failure
    When I add 4 and 7
    Then the result is 11
