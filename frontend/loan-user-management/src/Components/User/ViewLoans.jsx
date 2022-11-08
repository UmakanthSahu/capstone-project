import React from "react";
import './ViewLoans.css';
import {useEffect, useState} from 'react';
import { getJsonPostRequestData, VIEW_LOANS_URL, getRequestHeaders} from "../../Services/ApiService";

export const ViewLoans = (props)=>{

    let employeeId="12345678";
    let designation = "Manager";
    let department = "Marketing";

    const [ displayRows, setDisplayRows ]=useState([]);

//         {id:"1001", type:"Furniture", duration:"5", issueDate:"15-07-2022"},
//         {id:"1002", type:"Stationary", duration:"2", issueDate:"15-09-2020"},
//         {id:"1003", type:"Crockery", duration:"12", issueDate:"25-09-2021"},
//         {id:"1004", type:"Education", duration:"15", issueDate:"12-08-2017"}

    const emp = {"employeeId":props.authorizedLogin.employeeid};
    //CHNAGE EMPLOYEEID NKCKCD
    useEffect(()=>{
    console.log(props.authorizedLogin, "ello");
    console.log(emp);
    fetch(VIEW_LOANS_URL,getJsonPostRequestData(emp))
    .then(async(res) => {
    setDisplayRows(await res.json());
    console.log(displayRows, "Umaaaaaa");
    })
    //fetch call
    },[])

    return(
        <div className="ViewLoans-main">
            <h3>Loan Cards Availed</h3>
            <div className="ViewLoans-header">
                <div className="ViewLoans-header-item">
                    <h5>Employee ID</h5>
                    <h6>{employeeId}</h6>
                </div>

                <div  className="ViewLoans-header-item">
                    <h5>Designation</h5>
                    <h6>{designation}</h6>
                </div>

                <div  className="ViewLoans-header-item">
                    <h5>Department</h5>
                    <h6>{department}</h6>
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
                {displayRows.map((row,index)=>(
                       <tr>
                       <th scope="row">{row.loadId}</th>
                       <td>{row.loanType}</td>
                       <td>{row.durationInYears}</td>
                       <td>{row.date}</td>
                       </tr>
                ))}

            </tbody>
            </table>

        </div>
    )

}

