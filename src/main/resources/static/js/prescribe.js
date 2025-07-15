// static/js/prescribe.js

function validatePrescriptionForm() {
  const prescription = document.forms["prescriptionForm"]["prescription"].value.trim();
  if (prescription === "") {
    alert("Prescription cannot be empty.");
    return false;
  }
  return true;
}
