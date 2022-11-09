import React, { useState, useEffect } from "react";
import {
  GET_ALL_ITEMS_URL,
  getRequestHeaders,
} from "../../Services/ApiService";

export const ApplyLoan = (props) => {
  //   const ItemCategories = [{id:'1', name:'Furniture'},{id:'2', name:'Crockery'}];
  //
  //   const products = [
  //       {id:"1",itemCategoryID:"1",name:"chair"},
  //       {id:"2",itemCategoryID:"1",name:"chair 2"},
  //       {id:"3",itemCategoryID:"2",name:"chair 3"},
  //       {id:"4",itemCategoryID:"2",name:"chair 4"},
  //       {id:"1",itemCategoryID:"3",name:"chair 5"},
  //       {id:"2",itemCategoryID:"3",name:"chair 6 "},
  //       {id:"3",itemCategoryID:"4",name:"chair 7"},
  //       {id:"4",itemCategoryID:"4",name:"chair 8"}
  //     ]

  //     const itemValues = [
  //         {id:"1",productID:"1",name:"Faridabad"},
  //         {id:"2",productID:"1",name:"Palwal"},
  //         {id:"3",productID:"2",name:"Mandi House"},
  //         {id:"4",productID:"2",name:"kalka Ji"},
  //         {id:"1",productID:"3",name:"Houston"},
  //         {id:"2",productID:"3",name:"Austin"},
  //         {id:"3",productID:"4",name:"Los Angeles"},
  //         {id:"4",productID:"4",name:"Son Diego"}
  //       ]
  //
  //       const itemDescriptions = [
  //                                        {id:"1",productID:"1",name:"Faridabad"},
  //                                        {id:"2",productID:"1",name:"Palwal"},
  //                                        {id:"3",productID:"2",name:"Mandi House"},
  //                                        {id:"4",productID:"2",name:"kalka Ji"},
  //                                        {id:"1",productID:"3",name:"Houston"},
  //                                        {id:"2",productID:"3",name:"Austin"},
  //                                        {id:"3",productID:"4",name:"Los Angeles"},
  //                                        {id:"4",productID:"4",name:"Son Diego"}
  //                                      ]
  //
  // const[afewItem, setafewItem] =useState([]);
  // const [ product, setProduct] = useState([]);
  //   const [itemDescription, setItemDescription] = useState("");
  //const [itemCategory, setItemCategory] = useState("");
  
  const [categoryData, setCategoryData] = useState([]);
  const [makeData, setMakeData] = useState([]);
  const [itemsData, setItemsData] = useState([]);
  //   const [itemMake, setItemMake] = useState("Ceramic");

  // useEffect(()=>{
  //     setItemCategory(ItemCategories);
  //   },[])
  //
  //
  //   useEffect(()=>{
  //       setafewItem(afewItems);
  //     },[])

  //
  //     const handleProduct = (id) => {
  //         const dt = itemValues.filter(x => x.productID === id);
  //         const dt2 = itemDescriptions.filter(x => x.productID === id);
  //         setItemValue(dt);
  //         setItemDescription(dt2);
  //       }

  //   const onApplyLoanSubmitHandler = (e) => {
  //     e.preventDefault();
  //     let applyLoanFormData = {
  //       employeeId: props.authorizedLogin,
  //       itemValue: itemValue,
  //       itemCategory: itemCategory,
  //       itemMake: itemMake,
  //       itemDescription: itemDescription,
  //     };}
  //
  //     console.log(applyLoanFormData);

  const [products, setProducts] = useState([]);
  //CHNAGE EMPLOYEEID NKCKCD
  useEffect(() => {
    console.log(props.authorizedLogin, "ello");
    //console.log(emp);
    fetch(GET_ALL_ITEMS_URL, getRequestHeaders()).then((res) => 
       res.json())
      .then( (products) => {
      console.log(products, "Umaaaaaa");
      let localData = [];
      let keys = [];
      for (let index in products) {
        // if (!keys.includes(products[item].itemCategory)) {
        //   localData.push(
        //     <option
        //       key={item}
        //       value={products[item].itemCategory.toLowerCase()}
        //     >
        //       {products[item].itemCategory}
        //     </option>
        //   );
        //   keys.push(products[item].itemCategory);
        // }
        // console.log(products[index].itemCategory, "cat");
        if(!keys.includes(products[index].itemCategory)){
          keys.push(products[index].itemCategory)
        }
        
      }
      setCategoryData(keys);
        console.log(categoryData, "catergory");
    });
    //fetch call
  }, []);

  // const handleItemCategory = (id)=>{
  //
  //
  // }
  //         const handleItemCategory = (category) => {
  //         console.log(category);
  // //          let localData=[];
  // //
  // //         let dt = products.filter(x => x.itemCategory === category);
  // //         for(let item in dt){
  // //             localData.push(<option key={item} value={dt[item].itemMake.toLowerCase()}>{dt[item].itemMake}</option>);
  // //
  // //
  // //         setMakeData(localData);
  //
  // }

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
                  value={props.authorizedLogin.employeeid}
                  disabled
                />
              </div>
              <div className="mb-3">
                <label htmlFor="itemCategory" className="form-label">
                  Item Category
                </label>
                <select
                  id="itemCategory"
                  className="form-select form-select-sm"
                  aria-label=".form-select-lg example"
                  name="itemCategory"
                  // onChange={(e)=>console.log(e.target.value)}
                >
                  <option value="1">Hello</option>
                  <option value="0">Select Category</option>
                  {categoryData}

                  {/*                      { */}
                  {/*                                              afewItem && */}
                  {/*                                              afewItem !== undefined ? */}
                  {/*                                              afewItem.map((ctr,index) => { */}
                  {/*                                                  return( */}

                  {/*                                                  <option key={index} value={ctr.itemCategory}>{ctr.itemCategory}</option> */}

                  {/*                                                  ) */}
                  {/*                                              }) */}
                  {/*                                              :"No Category" */}

                  {/*                                            } */}
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
                  required
                >
                  <option value="0">Select Product</option>

                  {/*                                       { */}
                  {/*                                         product && */}
                  {/*                                         product !== undefined ? */}
                  {/*                                         product.map((ctr,index) => { */}
                  {/*                                             return( */}
                  {/*                                                 <option key={index} value={ctr.id}>{ctr.name}</option> */}
                  {/*                                             ) */}
                  {/*                                         }) */}
                  {/*                                         :"No Product" */}

                  {/*                                       } */}
                </select>
              </div>
              <div className="mb-3">
                <label htmlFor="itemDescription" className="form-label">
                  Item Description
                </label>
                <div className="form-control">
                  {/*                                                            itemDescription && */}
                  {/*                                                            itemDescription !== undefined ? */}
                  {/*                                                            itemDescription.map((ctr,index) => { */}
                  {/*                                                                return( */}
                  {/*                                                                <p key={index} value={ctr.id}>{ctr.name}</p> */}

                  {/*                                                                ) */}
                  {/*                                                            }) */}
                  {/*                                                            :"No Item Description" */}

                  {/*                                                          } */}
                </div>
              </div>
              <div className="mb-3">
                <label htmlFor="itemValue" className="form-label">
                  Item Value
                </label>
                <div className="form-control">
                  {/*                                                                            itemValue && */}
                  {/*                                                                            itemValue !== undefined ? */}
                  {/*                                                                            itemValue.map((ctr,index) => { */}
                  {/*                                                                                return( */}
                  {/*                                                                                <p key={index} value={ctr.id}>{ctr.name}</p> */}

                  {/*                                                                                ) */}
                  {/*                                                                            }) */}
                  {/*                                                                            :"No Item Value" */}

                  {/*                                                                          } */}
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
