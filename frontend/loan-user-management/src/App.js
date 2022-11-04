import "./App.css";
import { useState, useEffect } from "react";
import { Routes, Route, useNavigate } from "react-router-dom";
import { Navbar } from "./Components/Common/Navbar";
import { Home } from "./Components/Common/Home";
import { Login } from "./Components/User/Login";
import { ApplyLoan } from "./Components/User/ApplyLoan";
import { Dashboard } from "./Components/User/Dashboard";
import { ViewLoans } from "./Components/User/ViewLoans";
import { ItemsPurchased} from "./Components/User/ItemsPurchased";
import { LogoutSuccess } from "./Components/User/LogoutSuccess";

function App() {
  const authorizedLoginFromLocalStorage =
    localStorage.getItem("authorizedLogin");
    
  // when user is logged in, this state contains the employeeId
  const [authorizedLogin, setAuthorizedLogin] = useState(
    authorizedLoginFromLocalStorage === null
      ? ""
      : authorizedLoginFromLocalStorage
  );
  const navigate = useNavigate();

  useEffect(() => {
    // console.log(authorizedLoginFromLocalStorage);
    localStorage.setItem("authorizedLogin", authorizedLogin);

    return () => localStorage.removeItem("authorizedLogin");
  }, [authorizedLogin]);

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
          <Route exact path="/applyLoan" element={<ApplyLoan authorizedLogin = {authorizedLogin}/>} />
          <Route exact path="/viewLoans" element={<ViewLoans authorizedLogin = {authorizedLogin}/>} />
          <Route exact path="/itemsPurchased" element={<ItemsPurchased authorizedLogin = {authorizedLogin}/>} />
          
          <Route exact path="/logoutSuccess" element={<LogoutSuccess setAuthorizedLogin={setAuthorizedLogin}/>}/>
          <Route exact path="/" element={<Home />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
