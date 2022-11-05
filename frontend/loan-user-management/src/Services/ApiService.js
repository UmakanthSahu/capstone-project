const BASE_API_URL = "http://localhost:8080/api/";
export const APPLY_LOAN_URL = BASE_API_URL + "applyLoan";

export const getJsonPostRequestData = (data) => {
  return {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  };
};

export const getLoginUrl = (username, password) => {
  return BASE_API_URL +"loginUser/"+ username + "/" + password;
};
