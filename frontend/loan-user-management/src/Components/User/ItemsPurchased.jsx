import React from "react";
import "./ViewLoans.css";
import { useEffect, useState } from "react";
import {
  getJsonPostRequestData,
  PURCHASED_ITEMS_URL,
} from "../../Services/ApiService";

export const ItemsPurchased = (props) => {
  const [displayRows, setDisplayRows] = useState([]);
  const emp = { employeeId: props.authorizedLogin.employeeid };

  useEffect(() => {
    fetch(PURCHASED_ITEMS_URL, getJsonPostRequestData(emp)).then(
      async (res) => {
        setDisplayRows(await res.json());
      }
    );
  }, []);

  return (
    <div className="ViewLoans-main">
      <h3>Items Purchased</h3>
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
            <th scope="col">Issue_ID</th>
            <th scope="col">Item Description</th>
            <th scope="col">Item Make</th>
            <th scope="col">Item Category</th>
            <th scope="col">Item Valuation</th>
          </tr>
        </thead>
        <tbody>
          {displayRows.map((row, index) => (
            <tr key={index}>
              <th scope="row">{row.issueId}</th>
              <td>{row.itemDescription}</td>
              <td>{row.itemMake}</td>
              <td>{row.itemCategory}</td>
              <td>{row.itemValuation}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
