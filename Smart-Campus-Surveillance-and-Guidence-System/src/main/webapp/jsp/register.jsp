<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration</title>
    <script>
        async function registerEmployee(event) {
            event.preventDefault();  // Prevent the form from submitting in the traditional way

            // Collect form data
            const employeeData = {
                emp_id: document.getElementById('emp_id').value,
                emp_name: document.getElementById('emp_name').value,
                email: document.getElementById('email').value,
                mob_no: document.getElementById('mob_no').value,
                usename: document.getElementById('username').value,
                password: document.getElementById('password').value
            };

            try {
                // Send the data using Fetch API to the backend REST API
                const response = await fetch('http://localhost:8080/register', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(employeeData)
                });

                if (response.ok) {
                    alert('Employee registered successfully!');
                    // Optionally redirect to a success page or show success message
                } else {
                    alert('Failed to register employee.');
                }
            } catch (error) {
                console.error('Error:', error);
                alert('Error registering employee.');
            }
        }
    </script>
</head>
<body>
    <h2>Register Employee</h2>
    <form onsubmit="registerEmployee(event)">
        <label for="emp_id">Employee Id:</label>
        <input type="text" id="emp_id" name="emp_id" required><br>

        <label for="emp_name">Name:</label>
        <input type="text" id="emp_name" name="emp_name" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
		
		<label for="mob_no">Mobile Number:</label>
        <input type="text" id="mob_no" name="mob_no" required><br>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
