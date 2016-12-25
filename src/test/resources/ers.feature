Feature: Login
  As a user
  I can login to the website

  Scenario Outline:
    Given I am on the login page
    And I enter "<username>" as the username
    And I enter "<password>" as the password
    When I click the login button
    Then I will be greeted by "<greeting>"

    Examples:
      | username   | password     | greeting                  |
      | rprice0    | xJGak5i      | Welcome Robin Price       |
      | plawson1   | 6IDxbwM      | Welcome Paula Lawson      |
      | jwhite2    | bfgM7gsx     | Welcome Jonathan White    |
      | fphillips3 | R75R8Yo      | Welcome Frances Phillips  |
      | jrogers4   | KLwWkq       | Welcome John Rogers       |
      | pthompson5 | 358xE0ht     | Welcome Philip Thompson   |
      | bberry6    | fKvzo0MiPFxH | Welcome Bruce Berry       |
      | jgibson7   | Q3VvYJRivz   | Welcome Jacqueline Gibson |
      | hwells8    | AypzJhAD34   | Welcome Harold Wells      |
      | jcarr9     | QpNtyqA66    | Welcome Julia Carr        |