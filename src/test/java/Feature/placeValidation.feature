Feature: Validating Place API's


Scenario: Verify if Place is being added Successfully added using AddPlaceAPI
   Given  Add Place Payload 
   When  user calls "AddPlaceAPI" with Post http request 
   Then the API call got  success with status code 200
   And  "status" in response body  is "OK"
   And "status" in reponse body is "ok"
    And "scope" in reponse body is "APP"
    #When  user calls DeleteAPI with Post http request 

