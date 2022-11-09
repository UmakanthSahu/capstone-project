import React from "react";
import "./ViewLoans.css";
import { useEffect, useState } from "react";
import {
  getJsonPostRequestData,
  VIEW_LOANS_URL,
} from "../../Services/ApiService";

export const ViewLoans = (props) => {
  const [displayRows, setDisplayRows] = useState([]);

  const emp = { employeeId: props.authorizedLogin.employeeid };

  useEffect(() => {
    fetch(VIEW_LOANS_URL, getJsonPostRequestData(emp)).then(async (res) => {
      setDisplayRows(await res.json());
    });
  }, []);

  return (
    <div className="ViewLoans-main">
      <h3>Loan Cards Availed</h3>
      <div className="ViewLoans-header">
        <div className="ViewLoans-header-item">
          <h5>Employee ID</h5>
          <h6>{props.authorizedLogin.employeeid}</h6>
        </div>

        <div className="ViewLoans-header-item">
          <h5>Designation</h5>
          <h6>{props.authorizedLogin.employeeDesignation}</h6>
        </div>

        <div className="ViewLoans-header-item">
          <h5>Department</h5>
          <h6>{props.authorizedLogin.department}</h6>
        </div>
      </div>

      <table className="table">
        <thead className="thead-dark">
          <tr>
            <th scope="col">Loan ID</th>
            <th scope="col">Loan Type</th>
            <th scope="col">Duration</th>
            <th scope="col">Card Issue Date</th>
          </tr>
        </thead>
        <tbody>
          {displayRows.map((row, index) => (
            <tr key={index}>
              <th scope="row">{row.loadId}</th>
              <td>{row.loanType}</td>
              <td>{row.durationInYears}</td>
              <td>{row.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
