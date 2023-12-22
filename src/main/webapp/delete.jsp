<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Deletion Confirmation</title>
    <style>
        /* Basic card styles */
        .card {
            border-radius: 8px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding: 20px;
            margin: 20px;
            background-color: #fff;
        }
        /* Center content */
        .center {
            text-align: center;
        }
        /* Logout text style */
        .logout-info {
            font-style: italic;
            color: #888;
        }
        /* Delete button style */
        .delete-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #ff6347;
            color: #fff;
            cursor: pointer;
        }
        .delete-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2 class="center">Account Deletion Confirmation</h2>
        <p>Are you sure you want to delete your account?</p>
        <form  method="post">
            <!-- Add your delete account servlet URL in action attribute -->
             <input type="hidden" name="form" value="deleteuseroperation">
            <button type="submit" class="delete-btn">Delete Account</button>
        </form>
        <p class="logout-info">Note: Deleting your account will log you out permanently.</p>
    </div>
</body>
</html>
