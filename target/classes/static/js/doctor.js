document.addEventListener("DOMContentLoaded", () => {
  const appointments = ["Patient A - 10:00 AM", "Patient B - 11:00 AM"];
  const list = document.getElementById("appointmentList");
  appointments.forEach(item => {
    const li = document.createElement("li");
    li.textContent = item;
    list.appendChild(li);
  });
});

function logout() {
  window.location.href = "/logout";
}
