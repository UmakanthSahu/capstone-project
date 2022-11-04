import "./App.css";
import { Routes, Route, useNavigate } from "react-router-dom";
import { Navbar } from "./Components/Common/Navbar";
import { Home } from "./Components/Common/Home";
import { Login } from "./Components/User/Login";
import { Dashboard } from "./Components/User/Dashboard";
import { useState } from "react";

function App() {
  // when user is logged in, this state contains the email id
  const [authorizedLogin, setAuthorizedLogin] = useState("");
  const navigate = useNavigate();

  // handles logout by clearing authorizedLogin
  const logoutHandler = (event) => {
    event.preventDefault();
    if (window.confirm("Are you sure want to logout?")) {
      setAuthorizedLogin("");
      navigate("/logoutSuccess");
    }
  };

  return (
    <div className="App">
      <Navbar authorizedLogin={authorizedLogin} logoutHandler={logoutHandler} />
      <div className="my-3">
        <Routes>
          <Route
            exact
            path="/login"
            element={
              <Login
                authorizedLogin={authorizedLogin}
                setAuthorizedLogin={setAuthorizedLogin}
                navigate={navigate}

              />
            }
          />
          <Route
            exact
            path="/dashboard"
            element={
              <Dashboard
                authorizedLogin={authorizedLogin}
                setAuthorizedLogin={setAuthorizedLogin}
                logoutHandler={logoutHandler}
                navigate={navigate}
              />
            }
          />
          <Route exact path="/" element={<Home />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
