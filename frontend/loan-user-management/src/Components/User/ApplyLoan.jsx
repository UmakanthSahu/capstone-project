import React, { useState } from "react";

export const ApplyLoan = (props) => {
  const [itemDescription, setItemDescription] = useState("");
  const [itemValue, setItemValue] = useState(0);

  return (
    <div>
      <div className="container my-3">
        <h2>Loan Management Application</h2>
        <h3>Apply Loan</h3>
      </div>
      <div className="outer">
        <div className="card w-45">
          <div className="card-body">
            <form>
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
                  class="form-select form-select-sm"
                  aria-label=".form-select-lg example"
                  name="itemCategory"
                  for="itemCategory"
                >
                  <option selected>Select Item Category</option>
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
                  placeholder="Enter Item Description"
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
                />
              </div>
              <div className="mb-3">
                <label htmlFor="itemMake" className="form-label">
                  Item Make
                </label>
                <select
                  class="form-select form-select-sm"
                  aria-label=".form-select-lg example"
                  name="itemMake"
                  for="itemMake"
                >
                  <option selected>Select Item Make</option>
                  <option value="Wooden">Wooden</option>
                  <option value="Glass">Glass</option>
                  <option value="Ceramic">Ceramic</option>
                  <option value="Plastic">Plastic</option>
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
