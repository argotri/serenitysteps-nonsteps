Feature: Lookup a definition
  In order to talk better
  As an English student
  I want to look up word definitions

  Scenario: Looking up the definition of 'apple' with step
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'apple'
    Then they should see the definition 'A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.'

  Scenario: Looking up the definition of 'apple' without step
    Given the user is on the Wikionary home page without step
    When the user looks up the definition of the word 'apple' without step
    Then they should see the definition '' without step