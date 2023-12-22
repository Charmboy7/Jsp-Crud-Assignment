


<!DOCTYPE html>
<html>
<head>
  <title>Signup Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    
    .container {
      width: 400px;
      margin: 100px auto;
      background: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
      text-align: center;
    }
    
    form {
      display: flex;
      flex-direction: column;
    }
    
    label {
      margin-bottom: 5px;
    }
    
    input[type="text"],
    input[type="password"] {
      padding: 8px;
      margin-bottom: 15px;
      border-radius: 4px;
      border: 1px solid #ccc;
    }
    
    input[type="submit"] {
      padding: 10px;
      border: none;
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
      border-radius: 4px;
    }
    
    input[type="submit"]:hover {
      background-color: #45a049;
    }
    
    .error-message {
      color: red;
      margin-top: 5px;
    }
  </style>
  <script>
    // Your JavaScript validation code remains unchanged
    function validateForm() {
      var name = document.getElementById('name').value;
      var password = document.getElementById('password').value;
      var age = document.getElementById('age').value;
      var phoneNumber = document.getElementById('phoneNumber').value;
      var designation = document.getElementById('designation').value;
      
      // Simple validation checks
      if (name === '' || password === '' || age === '' || phoneNumber === '' || designation === '') {
        alert('All fields are required');
        return false;
      }
      
      if (isNaN(age) || age < 18) {
        alert('Please enter a valid age (must be a number and 18 or older)');
        return false;
      }
      
      var phonePattern = /^\d{10}$/;
      if (!phonePattern.test(phoneNumber)) {
        alert('Please enter a valid 10-digit phone number');
        return false;
      }
      
      return true;
    }
  </script>
</head>
<body>
  <div class="container">
    <h2>Signup</h2>
    <form  onsubmit="return validateForm()" method="post">
      <label for="name">UserName:</label>
      <input type="text" id="name" name="name"><br>
      
      <label for="password">Password:</label>
      <input type="password" id="password" name="password"><br>
      
      <label for="age">Age:</label>
      <input type="text" id="age" name="age"><br>
      
      <label for="phoneNumber">Phone Number:</label>
      <input type="text" id="phoneNumber" name="phoneNumber"><br>
      
      <label for="designation">Designation:</label>
      <input type="text" id="designation" name="designation"><br>
      
         <input type="hidden" name="form" value="adduseroperation">
      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>


