import { useForm } from "react-hook-form";
import { useEffect, useState } from "react";
import Axios from "axios";
import { useNavigate } from "react-router-dom";
import {
  APPLY_LOAN_URL,
  getJsonPostRequestData,
} from "../../Services/ApiService";

export function ApplyLoan(props) {
  let [categoryData, setCategoryData] = useState([]);
  let [itemName, setItemName] = useState([]);
  let [itemsData, setItemsData] = useState([]);
  let [final, setFinal] = useState("");

  const {
    register,
    handleSubmit,
    watch,
    setValue,
    getValues,
    resetField,
    formState: { errors, isValid },
  } = useForm({ criteriaMode: "all" });

  const navigate = useNavigate();
  const onSubmit = async (data) => {
    // console.log(data);

    let applyLoanrequest = {
      itemCategory: data.itemcategory,
      itemId: final,
      employeeId: props.authorizedLogin.employeeid,
    };
    // console.log(applyLoanrequest);
    fetch(APPLY_LOAN_URL, getJsonPostRequestData(applyLoanrequest))
      .then((resp) => resp.json())
      .then((resp) => {
        console.log(resp);
        if(resp){
          navigate("/viewLoans");
        }else{
          navigate("/error");
        }
      });
  };

  const onError = () => {
    navigate("*");
  };
  const watchmakeandcategory = watch(["itemmake", "itemcategory"]);

  let disableExpression =
    !isValid ||
    !watchmakeandcategory[0] ||
    watchmakeandcategory[0] === "" ||
    !watchmakeandcategory[1] ||
    watchmakeandcategory[1] === ""; //|| !updateCheck;
  useEffect(() => {
    Axios.get("http://localhost:8080/api/v1/getAllItems").then((res) => {
      // console.log(res.data);
      // // setValue("employeeid", sessionStorage.getItem("username"));
      let data = res.data;
      let localCatData = [];
      let keys = [];
      for (let item in data) {
        if (!keys.includes(data[item].itemCategory)) {
          localCatData.push(
            <option key={item} value={data[item].itemCategory}>
              {data[item].itemCategory}
            </option>
          );
          keys.push(data[item].itemCategory);
        }
      }
      setCategoryData(localCatData);
      setItemsData(data);
      // console.log(categoryData, itemsData);
    });
  }, []);

  useEffect(() => {
    resetField("itemname");
    let presentCategory = watch("itemcategory");
    let data = itemsData.filter((val) => presentCategory === val.itemCategory);
    let localNameData = [];
    for (let item in data) {
      localNameData.push(
        <option key={data[item].itemName}>{data[item].itemName}</option>
      );
    }
    setItemName(localNameData);
  }, [watch("itemcategory")]);

  useEffect(() => {
    resetField("itemmake");
    resetField("itemvalue");
    resetField("itemdescription");
    let choice = itemsData.filter(
      (val) =>
        val.itemCategory === getValues("itemcategory") &&
        val.itemName === getValues("itemname")
    );
    setFinal(choice[0]?.itemId);
    setValue("itemmake", choice[0]?.itemMake);
    setValue("itemvalue", choice[0]?.itemValuation);
    setValue("itemdescription", choice[0]?.itemDescription);
  }, watch(["itemname"]));

  return (
    <div className="outer">
      <div className="card" style={{ width: "400px" }}>
        <div className="card-body">
          <h3 className="card-title text-center">Apply Loan</h3>

          <form className={"form"} onSubmit={handleSubmit(onSubmit, onError)}>
            <div className="mb-3">
              <label htmlFor={"employeeid"}>Employee id </label>
              <input
                className={"form-control"}
                placeholder={"Ex: E12345"}
                type={"text"}
                id={"employeeid"}
                disabled
                value={props.authorizedLogin.employeeid}
              />
              {errors.employeeid && (
                <small color={"red"}>{errors.employeeid.message}</small>
              )}
            </div>
            <div className="mb-3">
              <label htmlFor={"itemcategory"} className="form-label">
                Item Category
              </label>
              <select
                className={"form-control"}
                id={"itemcategory"}
                defaultValue={"/"}
                {...register("itemcategory", {
                  required: "Select one of the option",
                })}
              >
                <option value={""}>Select</option>
                {categoryData}
              </select>
              {errors.itemcategory}
            </div>

            <div className="mb-3">
              <label htmlFor={"itemname"}>Item Name</label>
              <select
                className={"form-control"}
                defaultValue={""}
                {...register("itemname")}
              >
                <option value={""}>Select Item Name</option>
                {itemName}
              </select>
            </div>
            <div className="mb-3">
              <label htmlFor={"itemmake"}>Item Make</label>
              <input
                className={"form-control"}
                placeholder={"Ex: Glass"}
                type={"text"}
                id={"itemmake"}
                disabled
                {...register("itemmake", { required: true })}
              />
            </div>
            <div className="mb-3">
              <label htmlFor={"itemvalue"}>Item Value</label>
              <input
                className={"form-control"}
                placeholder={"Ex: 10000"}
                type={"number"}
                id={"itemvalue"}
                disabled
                {...register("itemvalue", { required: true })}
              />
            </div>

            <div className="mb-3">
              <label htmlFor={"itemdescription"}>Item Description</label>
              <input
                className={"form-control"}
                placeholder={"Ex: Tea Table"}
                type={"text"}
                id={"itemdescription"}
                {...register("itemdescription", { required: true })}
                disabled
              />
            </div>

            <button
              className={"mt-2 btn btn-primary"}
              disabled={disableExpression}
              type={"submit"}
            >
              Apply Loan
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
