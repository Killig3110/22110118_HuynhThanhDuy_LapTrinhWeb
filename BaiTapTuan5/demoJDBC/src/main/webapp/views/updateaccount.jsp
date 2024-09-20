<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Account</title>

</head>

<body>
<form action="/updateaccount" method="post" enctype="multipart/form-data">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to update an account.</p>
        <hr>

        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" id="username" value="${username}" readonly required>

        <br>

        <label for="fullname"><b>Fullname</b></label>
        <input type="text" placeholder="Enter Fullname" name="fullname" id="fullname" required>

        <br>

        <label for="phone"><b>Phone</b></label>
        <input type="text" placeholder="Enter Phone" name="phone" id="phone" required>

        <br>

        <label for="images"><b>Images</b></label>
        <input type="file" placeholder="Enter Image" name="multiPartServlet" id="images" required>

        <br>

        <button type="submit" class="updatebtn">Update</button>
    </div>
</form>

</body>
</html>