export function isValidPasswordLength(password) {
  if (password.length >= 8 && password.length <=20) {
    return true;
  }
  window.alert(
    "Password should be greater than 7 characters and less than 20 characters"
  );
  return false;
}