const BASE_API_URL = "http://localhost:8080/api/v1/";
export const APPLY_LOAN_URL = BASE_API_URL + "applyLoan";
export const VIEW_LOANS_URL = BASE_API_URL + "viewLoans";
export const PURCHASED_ITEMS_URL = BASE_API_URL + "viewPurchasedItems";
export const getJsonPostRequestData = (data) => {
  return {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "*"
    },
    body: JSON.stringify(data)
  };
};
export const getRequestHeaders = () => {
  return {
    method: "GET",
    headers: {
      "Access-Control-Allow-Origin": "*"
    }
  };
};

export const getLoginUrl = (username, password) => {
  return BASE_API_URL +"loginEmployee/" + username + "/" + password;
};
