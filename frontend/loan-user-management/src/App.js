import "./App.css";
import { useState, useEffect } from "react";
import { Routes, Route, useNavigate, Navigate } from "react-router-dom";
import { Navbar } from "./Components/Common/Navbar";
import { Home } from "./Components/Common/Home";
import { Login } from "./Components/User/Login";
import { ApplyLoan } from "./Components/User/ApplyLoan";
import { Dashboard } from "./Components/User/Dashboard";
import { ViewLoans } from "./Components/User/ViewLoans";
import { ItemsPurchased } from "./Components/User/ItemsPurchased";
import { LogoutSuccess } from "./Components/User/LogoutSuccess";

function App() {
  const authorizedLoginFromSessionStorage =
    sessionStorage.getItem("authorizedLogin");

  // when user is logged in, this state contains the employeeId
  const [authorizedLogin, setAuthorizedLogin] = useState(
    authorizedLoginFromSessionStorage === null
      ? null
      : JSON.parse(authorizedLoginFromSessionStorage)
  );
  const navigate = useNavigate();

  function isUserLoggedIn() {
    //console.log(authorizedLogin);
    return authorizedLogin !== null;
  }

  useEffect(() => {
    // console.log(authorizedLoginFromSessionStorage);

    sessionStorage.setItem(
      "authorizedLogin",
      authorizedLogin === null || authorizedLogin === ""
        ? null
        : JSON.stringify(authorizedLogin)
    );

    return () => sessionStorage.removeItem("authorizedLogin");
  }, [authorizedLogin]);

  // handles logout by clearing authorizedLogin
  const logoutHandler = (event) => {
    event.preventDefault();
    if (window.confirm("Are you sure want to logout?")) {
      setAuthorizedLogin(null);
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
              isUserLoggedIn() ? (
                <Dashboard
                  authorizedLogin={authorizedLogin}
                  setAuthorizedLogin={setAuthorizedLogin}
                  logoutHandler={logoutHandler}
                  navigate={navigate}
                />
              ) : (
                <Navigate to="/login" />
              )
            }
          />
          <Route
            exact
            path="/applyLoan"
            element={
              isUserLoggedIn() ? (
                <ApplyLoan authorizedLogin={authorizedLogin} />
              ) : (
                <Navigate to="/login" />
              )
            }
          />
          <Route
            exact
            path="/viewLoans"
            element={
              isUserLoggedIn() ? (
                <ViewLoans authorizedLogin={authorizedLogin} />
              ) : (
                <Navigate to="/login" />
              )
            }
          />
          <Route
            exact
            path="/itemsPurchased"
            element={
              isUserLoggedIn() ? (
                <ItemsPurchased authorizedLogin={authorizedLogin} />
              ) : (
                <Navigate to="/login" />
              )
            }
          />

          <Route
            exact
            path="/logoutSuccess"
            element={<LogoutSuccess setAuthorizedLogin={setAuthorizedLogin} />}
          />
          <Route exact path="/" element={<Home />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
