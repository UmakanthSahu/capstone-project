import React from "react";
import './ViewLoans.css';
import {useEffect,useState} from 'react';
import { getJsonPostRequestData, PURCHASED_ITEMS_URL, getRequestHeaders} from "../../Services/ApiService";

export const ItemsPurchased = (props)=>{

    let employeeId="12345678";
    let designation = "Manager";
    let department = "Marketing";

//     const displayRows =[
//         {id:"1001", description:"Tea Table ", make:"Wooden", category:"Furniture", valuation:"5000"},
//         {id:"1002", description:"Tea set ", make:"Glass", category:"Crockery", valuation:"2000"},
//         {id:"1003", description:"Dining Set ", make:"Wooden", category:"Furniture", valuation:"25000"},
//         {id:"1004", description:"Pen", make:"Plastic", category:"Furniture", valuation:"4000"}
//     ]
    const [ displayRows, setDisplayRows ]=useState([]);
    const emp = {"employeeId":props.authorizedLogin.employeeid};
        //CHNAGE EMPLOYEEID NKCKCD
        useEffect(()=>{
        console.log(props.authorizedLogin, "ello");
        console.log(emp);
        fetch(PURCHASED_ITEMS_URL,getJsonPostRequestData(emp))
        .then(async(res) => {
        setDisplayRows(await res.json());
        console.log(displayRows, "Umaaaaaa");
        })
        //fetch call
        },[])

    return(
        <div className="ViewLoans-main">
            <h3>Items Purchased</h3>
            <div className="ViewLoans-header">
                <div className="ViewLoans-header-item">
                    <h5>Employee ID</h5>
                    <h6>{props.authorizedLogin.employeeid}</h6>
                </div>

                <div  className="ViewLoans-header-item">
                    <h5>Designation</h5>
                    <h6>{props.authorizedLogin.employeeDesignation}</h6>
                </div>

                <div  className="ViewLoans-header-item">
                    <h5>Department</h5>
                    <h6>{props.authorizedLogin.department}</h6>
                </div>
            </div>

            <table class="table">
            <thead class="thead-dark">
                <tr>
                <th scope="col">Issue_ID</th>
                <th scope="col">Item Description</th>
                <th scope="col">Item Make</th>
                <th scope="col">Item Category</th>
                <th scope="col">Item Valuation</th>
                </tr>
            </thead>
            <tbody>
                {displayRows.map((row,index)=>(
                       <tr>
                       <th scope="row">{row.itemId}</th>
                       <td>{row.itemDescription}</td>
                       <td>{row.itemMake}</td>
                       <td>{row.itemCategory}</td>
                       <td>{row.itemValuation}</td>
                       </tr>
                ))}

            </tbody>
            </table>

        </div>
    )

}

