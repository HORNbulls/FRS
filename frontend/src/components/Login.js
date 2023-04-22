import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import "bootstrap/dist/css/bootstrap.min.css";

function Login() {
  const [details, setDetails] = useState({
    username: "",
    password: "",
  });
  const nav = useNavigate();

  const handleChange = (e) => {
    e.preventDefault();
    setDetails({ ...details, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const { username, password } = details;
    if (username && password) {
      if (username === "AD001" && password === "AD001") {
        nav("/addflight");
      }
      if (username === "AD002" && password === "AD002") {
        nav("/getflights");
      }
      if (username === "AD003" && password === "AD003") {
        nav("/addschedule");
      }
      if (username === "AD004" && password === "AD004") {
        nav("/viewschedule");
      }
      if (username === "AD005" && password === "AD005") {
        nav("/addRoute");
      }
      if (username === "AD006" && password === "AD006") {
        nav("/getroute");
      }
    } else {
      alert("error");
    }
  };

  return (
    <>
      <nav className="navbar navbar-expand-lg gradient-navbar">
        <div className="container">
          <a className="navbar-brand" href="#">
            SUNDARAM FLIGHT RESERVATION SYSTEM
          </a>
        </div>
      </nav>
      <div className="crazy-bg">
        <div className="login-container">
          <h2 style={{ textAlign: "center" }}>LOGIN</h2>
          <form className="form-group" onSubmit={handleSubmit}>
            <div>
              <label>Username:</label>
              <input
                type="text"
                name="username"
                value={details.username}
                placeholder="username"
                onChange={handleChange}
                className="neon-input"
              ></input>
            </div>
            <div>
              <label>Password:</label>
              <input
                type="text"
                name="password"
                value={details.password}
                placeholder="password"
                onChange={handleChange}
                className="neon-input"
              ></input>
            </div>
            <input className="btn gradient-btn" type="submit" value="Login"></input>
          </form>
        </div>
      </div>
      <footer className="footer">
        <div className="container">
          <p>&copy; 2023 Sundaram Flight Reservation System. All Rights Reserved.</p>
          <p>Contact: info@sundaramflights.com | Tel: +1 (123) 456-7890</p>
        </div>
      </footer>
    </>
  );
}

export default Login;