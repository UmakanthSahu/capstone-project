import React from "react";
import { Link } from "react-router-dom";

export const Error = () => {
  return (
    <>
      <h2>Your Loan couldn't be processed</h2>
      <Link to="/dashboard">
        <button className="btn btn-primary">Go to Dashboard</button>
      </Link>
    </>
  );
};
