import React, { useState } from "react";
import { getLoginUrl, getRequestHeaders } from "../../Services/ApiService";
import { isValidEmail, isValidPasswordLength } from "../../Services/FormValidation";

export const Login = (props) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const onSubmitLoginHandler = (event) => {
    event.preventDefault();

    // validation of form input
    if (isValidEmail(username) && isValidPasswordLength(password)) {
      //connecting with backend
      fetch(getLoginUrl(username, password), getRequestHeaders())
        .then(async (resp) => {
          if (resp.status === 200) {
            const data = await resp.json();
            props.setAuthorizedLogin(data);
            props.navigate("/dashboard");
          }else if(resp.status === 401){
            window.alert("Invalid Credentials.")
            props.navigate("/register")
          }
        })
        .catch((err) => {
          window.alert(
            "Something went wrong.... Please try again after some time"
          );
        });
    } else {
      setPassword("");
    }
  };

  return (
    <div className="outer">
      <div className="card">
        <div className="card-body">
          <h3 className="card-title text-center">Login</h3>
          <form onSubmit={onSubmitLoginHandler}>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                Email
              </label>
              <input
                type="text"
                className="form-control"
                id="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                onBlur={(e) => setUsername(e.target.value.trim())}
                placeholder="Enter your Email Id"
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password" className="form-label">
                Password
              </label>
              <input
                type="password"
                className="form-control"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Enter your Password"
                required
              />
              <div id="passwordHelpBlock" className="form-text">
                Your password must be atleast 8 characters long.
              </div>
            </div>

            <button type="submit" className="btn btn-primary mx-auto">
              Login
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};
