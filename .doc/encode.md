# java-caesar-cipher / encode
Encode a chain of chars using caesar cipher.

* **URL**

  `<host>:<port>/cipher/v1/encode`

* **Method:**

  `POST`
  
* **Data Params**

  `{ "numberShift": int, "cipher": "string" }`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ encoded : 5, name : "i walked alone at the night, and sang a reggae for lonely street dogs." }`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** `{ "timestamp" : "1587772800", "status": "400", "message": "the explained error message" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/cipher/v1/encode",
      data: "{ \"numberShift\": int, \"cipher\": \"string\" }"
      dataType: "json",
      type : "POST",
      success : function(r) {
        console.log(r);
      }
    });
  ```
  