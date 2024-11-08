<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Campus - Home</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/style.css">
</head>
<body>
    <header>
        <div class="container">
            <!-- <h1>Welcome to Smart Campus Surveillance System</h1> -->
            <h1>आपकी सुरक्षा हमारी जिम्मेदारी।</h1>

            <nav>
                <ul>
                    <li><a href="<%= request.getContextPath() %>/home.jsp">Home</a></li>
                    <li><a href="<%= request.getContextPath() %>/Login.jsp">Login</a></li>
                    <li><a href="<%= request.getContextPath() %>/Register.jsp">Register</a></li>
                    <li><a href="<%= request.getContextPath() %>/About.jsp">About</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <section class="hero">
        <div class="container">
            <!-- <h2>Enhancing Campus Security & Guidance</h2>
            <p>Monitoring student activities and ensuring safety through real-time guidance and surveillance systems.</p> -->
            <a href="https://cutm.ac.in/" class="cta-button">Learn More</a>
        </div>
    </section>

    <section class="features">
        <div class="container">
            <h3>Key Features</h3>
            <div class="feature-box">
                <h4>Real-Time Monitoring</h4>
                <p>Constant surveillance to monitor student movement.</p>
            </div>
            <div class="feature-box">
                <h4>Facial Recognition</h4>
                <p>Ensuring safety with identity-based tracking and guidance.</p>
            </div>
            <div class="feature-box">
                <h4>Unauthorized Access Alerts</h4>
                <p>Immediate notification to campus security in case of suspicious activities.</p>
            </div>
        </div>
    </section>

    <footer>
        <div class="container">
            <p> 2024 Smart Campus Surveillance System. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
