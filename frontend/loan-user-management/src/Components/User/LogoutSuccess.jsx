import React, { useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";

export const LogoutSuccess = (props) => {
  const navigate = useNavigate();
  
  useEffect(() => {
    setTimeout(() => {
        props.setAuthorizedLogin(null);
        navigate("/login");
      }, 3000);
  });

  return (
    <div className="container">
      <h2>Logout Success</h2>
      <Link to="/login"> Login Here</Link>
    </div>
  );
};
