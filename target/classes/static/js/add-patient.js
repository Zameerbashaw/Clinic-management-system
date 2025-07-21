// static/js/add-patient.js

function validatePatientForm() {
  const name = document.forms["patientForm"]["name"].value.trim();
  const token = document.forms["patientForm"]["tokenNumber"].value;
  const symptoms = document.forms["patientForm"]["symptoms"].value.trim();

  if (name === "" || token === "" || symptoms === "") {
    alert("Please fill all fields: Name, Token, and Symptoms.");
    return false;
  }

  if (token <= 0) {
    alert("Token number must be a positive number.");
    return false;
  }

  return true;
}
