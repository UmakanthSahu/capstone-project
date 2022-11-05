import React, { useState } from "react";
import { APPLY_LOAN_URL, getJsonPostRequestData } from "../../Services/ApiService";

export const ApplyLoan = (props) => {
  const [itemDescription, setItemDescription] = useState("");
  const [itemValue, setItemValue] = useState(0);
  const [itemCategory, setItemCategory] = useState("Crockery");
  const [itemMake, setItemMake] = useState("Ceramic");
  const onApplyLoanSubmitHandler = (e) => {
    e.preventDefault();
    let applyLoanFormData = {
      employeeId: props.authorizedLogin,
      itemValue: itemValue,
      itemCategory: itemCategory,
      itemMake: itemMake,
      itemDescription: itemDescription,
    };

    console.log(applyLoanFormData);

    fetch(APPLY_LOAN_URL, getJsonPostRequestData(applyLoanFormData))
    .then((resp) => {
      console.log(resp);
    });
  };

  return (
    <div>
      <div className="container my-3">
        <h2>Loan Management Application</h2>
        <h3>Apply Loan</h3>
      </div>
      <div className="outer">
        <div className="card w-45">
          <div className="card-body">
            <form onSubmit={onApplyLoanSubmitHandler}>
              <div className="mb-3">
                <label htmlFor="ememployeeId" className="form-label">
                  Employee Id
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="text"
                  name="employeeId"
                  value={props.authorizedLogin}
                  disabled
                />
              </div>
              <div className="mb-3">
                <label htmlFor="itemCategory" className="form-label">
                  Item Category
                </label>
                <select
                  className="form-select form-select-sm"
                  aria-label=".form-select-lg example"
                  name="itemCategory"
                  value={itemCategory}
                  htmlFor="itemCategory"
                  onChange={(e) => setItemCategory(e.target.value)}
                  required
                >
                  <option value="Crockery">Crockery</option>
                  <option value="Furniture">Furniture</option>
                  <option value="Stationary">Stationary</option>
                </select>
              </div>
              <div className="mb-3">
                <label htmlFor="itemDescription" className="form-label">
                  Item Description
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="itemDescription"
                  name="itemDescription"
                  value={itemDescription}
                  onChange={(e) => setItemDescription(e.target.value)}
                  onBlur={(e) => setItemDescription(e.target.value.trim())}
                  placeholder="Enter Item Description"
                  required
                />
              </div>
              <div className="mb-3">
                <label htmlFor="itemValue" className="form-label">
                  Item Value
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="itemValue"
                  name="itemValue"
                  value={itemValue}
                  onChange={(e) => setItemValue(e.target.value)}
                  placeholder="Enter Item Value"
                  required
                />
              </div>
              <div className="mb-3">
                <label htmlFor="itemMake" className="form-label">
                  Item Make
                </label>
                <select
                  className="form-select form-select-sm"
                  aria-label=".form-select-lg example"
                  value={itemMake}
                  name="itemMake"
                  htmlFor="itemMake"
                  onChange={(e) => setItemMake(e.target.value)}
                  required
                >
                  <option value="Ceramic">Ceramic</option>
                  <option value="Glass">Glass</option>
                  <option value="Plastic">Plastic</option>
                  <option value="Wooden">Wooden</option>
                </select>
              </div>

              <button type="submit" className="btn btn-primary mx-auto">
                Apply Loan
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
