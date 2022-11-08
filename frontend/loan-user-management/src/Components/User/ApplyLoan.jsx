import React, { useState, useEffect } from "react";
import { APPLY_LOAN_URL, getJsonPostRequestData } from "../../Services/ApiService";

export const ApplyLoan = (props) => {

  const ItemCategories = [{id:'1', name:'Furniture'},{id:'2', name:'Crockery'}];

  const products = [
      {id:"1",itemCategoryID:"1",name:"chair"},
      {id:"2",itemCategoryID:"1",name:"chair 2"},
      {id:"3",itemCategoryID:"2",name:"chair 3"},
      {id:"4",itemCategoryID:"2",name:"chair 4"},
      {id:"1",itemCategoryID:"3",name:"chair 5"},
      {id:"2",itemCategoryID:"3",name:"chair 6 "},
      {id:"3",itemCategoryID:"4",name:"chair 7"},
      {id:"4",itemCategoryID:"4",name:"chair 8"}
    ]


    const itemValues = [
        {id:"1",productID:"1",name:"Faridabad"},
        {id:"2",productID:"1",name:"Palwal"},
        {id:"3",productID:"2",name:"Mandi House"},
        {id:"4",productID:"2",name:"kalka Ji"},
        {id:"1",productID:"3",name:"Houston"},
        {id:"2",productID:"3",name:"Austin"},
        {id:"3",productID:"4",name:"Los Angeles"},
        {id:"4",productID:"4",name:"Son Diego"}
      ]

      const itemDescriptions = [
                                       {id:"1",productID:"1",name:"Faridabad"},
                                       {id:"2",productID:"1",name:"Palwal"},
                                       {id:"3",productID:"2",name:"Mandi House"},
                                       {id:"4",productID:"2",name:"kalka Ji"},
                                       {id:"1",productID:"3",name:"Houston"},
                                       {id:"2",productID:"3",name:"Austin"},
                                       {id:"3",productID:"4",name:"Los Angeles"},
                                       {id:"4",productID:"4",name:"Son Diego"}
                                     ]

const [ product, setProduct] = useState([]);
  const [itemDescription, setItemDescription] = useState([]);
  const [itemValue, setItemValue] = useState("");
  const [itemCategory, setItemCategory] = useState([]);
  const [itemMake, setItemMake] = useState("Ceramic");

useEffect(()=>{
    setItemCategory(ItemCategories);
  },[])


  const handleItemCategory = (id) => {
      const dt = products.filter(x => x.itemCategoryID === id);
      setProduct(dt);
    }

    const handleProduct = (id) => {
        const dt = itemValues.filter(x => x.productID === id);
        const dt2 = itemDescriptions.filter(x => x.productID === id);
        setItemValue(dt);
        setItemDescription(dt2);
      }


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
                id="ddlItemCategory"
                  className="form-select form-select-sm"
                  aria-label=".form-select-lg example"
                  name="itemCategory"
                    onChange={(e) => handleItemCategory(e.target.value)}
                >
                <option value="0">Select Category</option>
                      {
                        itemCategory &&
                        itemCategory !== undefined ?
                        itemCategory.map((ctr,index) => {
                            return(
                                <option key={index} value={ctr.id}>{ctr.name}</option>
                            )
                        })
                        :"No Category"

                      }

                </select>
              </div>
              <div className="mb-3">
                              <label htmlFor="itemMake" className="form-label">
                                Product
                              </label>
                              <select
                              id="ddlProducts"
                                className="form-select form-select-sm"
                                aria-label=".form-select-lg example"

                                name="itemMake"
                                htmlFor="itemMake"
                                onChange={(e) => handleProduct(e.target.value)}
                                required
                              >
                                <option value="0">Select Product</option>
                                      {
                                        product &&
                                        product !== undefined ?
                                        product.map((ctr,index) => {
                                            return(
                                                <option key={index} value={ctr.id}>{ctr.name}</option>
                                            )
                                        })
                                        :"No Product"

                                      }
                              </select>
                            </div>
              <div className="mb-3">
                <label htmlFor="itemDescription" className="form-label">
                  Item Description
                </label>
                <div className="form-control"> {

                                                           itemDescription &&
                                                           itemDescription !== undefined ?
                                                           itemDescription.map((ctr,index) => {
                                                               return(
                                                               <p key={index} value={ctr.id}>{ctr.name}</p>

                                                               )
                                                           })
                                                           :"No Item Description"

                                                         }

                                                         </div>
              </div>
              <div className="mb-3">
                <label htmlFor="itemValue" className="form-label">
                  Item Value
                </label>
                 <div className="form-control"> {

                                                                           itemValue &&
                                                                           itemValue !== undefined ?
                                                                           itemValue.map((ctr,index) => {
                                                                               return(
                                                                               <p key={index} value={ctr.id}>{ctr.name}</p>

                                                                               )
                                                                           })
                                                                           :"No Item Value"

                                                                         }

                                                                         </div>
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
