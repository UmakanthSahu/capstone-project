import React, { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

export const Dashboard = (props) => {


  return (
    <div>
      <div className="container my-3">
        <h2>Loan Management Application</h2>


        {/*<div className="container my-5">
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
        </div>*/}
        <div>
          <Link to="/logoutSuccess" className="m-2">
            <button className="btn btn-danger" >Logout</button>
          </Link>
        </div>
      </div>
    </div>
  );
};
