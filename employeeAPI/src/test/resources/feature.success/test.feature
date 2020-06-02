Feature: ATBS API - successful outcomes for
  - start a new application

  Background:
    * def apiBaseUrl = 'http://localhost:8081/'


  Scenario: dont worry about it
    Given path apiBaseUrl, 'allRoles'
    Given request ''
    Given header Content-Type = 'application/json'
    When method GET
    Then status 200
    And match response ==
  """
  {
    "roles": [
        {
            "roleName": "dev",
            "bandMin": 100.0,
            "bandMax": 500.0
        },
        {
            "roleName": "manager",
            "bandMin": 500.0,
            "bandMax": 1000.0
        },
        {
            "roleName": "ceo",
            "bandMin": 1000.0,
            "bandMax": 50000.0
        }
    ]
}
  """
