0) Spring cloud server URI
--------------------------------
#http://localhost:8888/config-client-employee/config/master

Note: Make sure you start the cloud server first before starting this client application.

1) Running the application
----------------------------
mvn spring-boot:run



2) Employee Application URI (Client App)
----------------------------------------
http://localhost:7500/swagger-ui.html


3) Request / Responses
---------------------------
A) Successful
----------------
Request:
------------
{
  "password": "string",
  "username": "string"
}


Response:
-----------
{
  "httpStatus": "UNAUTHORIZED",
  "applicationErrorCode": "9000",
  "applicationErrorMessage": "Invalid username or password"
}

B) Unsucessful
-------------------
Request:
------------
{
  "password": "ankur",
  "username": "ankur"
}

Response:
-----------
{
  "items": [
    {
      "id": 1,
      "name": "Laptop",
      "price": 99.67,
      "info": {
        "manufacturedBy": "Apple",
        "description": "16' macbook pro"
      }
    },
    {
      "id": 2,
      "name": "Phone",
      "price": 100.33,
      "info": {
        "manufacturedBy": "Samsung",
        "description": "Android phone"
      }
    },
    {
      "id": 3,
      "name": "Brown Lamp",
      "price": 65.99,
      "info": {
        "manufacturedBy": "Costco",
        "description": "Teak lamp - brown color"
      }
    },
    {
      "id": 4,
      "name": "Alladin's Lamp",
      "price": 67.99,
      "info": {
        "manufacturedBy": "Genie",
        "description": "Magic lamp with 3 wishes"
      }
    }
  ]
}
