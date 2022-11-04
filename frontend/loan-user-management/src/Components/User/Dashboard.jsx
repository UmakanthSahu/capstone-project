import React, { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

export const Dashboard = (props) => {
  const navigate = useNavigate();

  useEffect(() => {
    // if (props.authorizedLogin === "") {
    //   navigate("/login");
    // }
  });

  return (
    <div>
      <div className="container my-3">
        <h2>Loan Management Application</h2>
        <h3>User Dashboard</h3>

        <div>
          <Link to="/viewLoans" className="m-2">
            <button className="btn btn-primary">View Loans</button>
          </Link>

          <Link to="/applyLoan" className="m-2">
            <button className="btn btn-primary">Apply for Loan</button>
          </Link>

          <Link to="/itemsPurchased" className="m-2">
            <button className="btn btn-primary">
              View Items Purchased
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
};
