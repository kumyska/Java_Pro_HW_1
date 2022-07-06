<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

      <title>Prog Academy</title>
  </head>
  <body>
    <% String login = (String)session.getAttribute("user_login");
        Integer age = (Integer)session.getAttribute("user_age");%>

    <% if (login == null || "".equals(login)) { %>
        <form action="/login" method="POST">

                <label>Login : </label>
                <input type="text" placeholder="Login" name="login"><br>
                <label>Password : </label>
            <input type="password" placeholder="no less than 10 sym"name="password"><br>
                <label>Age : </label>
            <input type="text" placeholder="Age"name="age"><br>
            <input type="submit" />

        </form>
    <% } else {
        if (age<18){ %>
    <h1>You are login successfully</h1>
    <h3>You are logged in as: <%= "You are less than 18" %></h3>
    <h3>You are logged in as: <%= age %></h3>

    <% } else { %>
    <h1>You are login successfully</h1>
    <h3>You are logged in as: <%= login %></h3>
    <h3>You are logged in as: <%= age %></h3>
    <br>Click this link to <a href="/login?a=exit">logout</a>
    <% }
    } %>
  </body>
</html>
