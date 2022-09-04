function checkHasLoggedIn() {
    var pageArr = document.documentURI.split("/"),
        page = pageArr[pageArr.length - 1];

    if (page !== 'login.html' && page !== 'logout.html' && page !== 'forgot-password.html') {
        isLoggedIn();
    }

}

function isLoggedIn() {
    if (localStorage.hasOwnProperty("surgerymis_user_id")) {
        if (localStorage.getItem("surgerymis_user_id") !== "0") {
            $(".welcome-text").html(`Hello,<span class="text-black fw-bold">${localStorage.getItem("surgerymis_user_name")}</span>`);
            manageMenu();
        } else {
            alert("You should login first.");
            window.location = '/login.html';
        }
    } else {
        alert("You should login first.");
        window.location = '/login.html';
    }
}

function logout() {
    localStorage.removeItem("surgerymis_user_id");
    localStorage.removeItem("surgerymis_user_name");
    localStorage.removeItem("surgerymis_user_email");
    localStorage.removeItem("surgerymis_user_type");
    localStorage.removeItem("surgerymis_user_status");
    window.location = '/login.html';
}

function setLoginSession(id, username) {
    localStorage.setItem("surgerymis_user_id", id);
    localStorage.setItem("surgerymis_user_email", username);
}

function formatDate(str) {
    var d = new Date(str);
    return d.getFullYear() + "-" + (d.getMonth() + 1 < 10 ? "0" + (d.getMonth() + 1) : d.getMonth() + 1) + "-" + d.getDate() + " " + d.getHours() + ":" + d.getDate();
}

function manageMenu() {
    var is_allowed = true;
    var user_role = localStorage.getItem("surgerymis_user_type"),
        pageArr = document.documentURI.split("/"),
        page = pageArr[pageArr.length - 1];

    var admin_pages = ["users.html", "add-user.html", "add-pharmacy.html", "pharmacy.html"],
        receptionist_pages = ["patients.html", "add-patient.html"],
        pharmacist_pages = ["pharmacy-orders.html", "add-pharmacy-orders.html"]
    console.log(user_role);
    switch (user_role) {
        case 'Admin':
            is_allowed = admin_pages.indexOf(page) !== -1;
            break;
        case 'Receptionist':
            is_allowed = receptionist_pages.indexOf(page) !== -1;
            break;
        case 'Pharmacist':
            is_allowed = pharmacist_pages.indexOf(page) !== -1;
            break;
        case 'Operation manager':
            is_allowed = admin_pages.indexOf(page) === -1 && receptionist_pages.indexOf(page) === -1 && pharmacist_pages.indexOf(page) === -1;
            break;
        default:
            is_allowed = false;
    }
    console.log(`Is allowed ${is_allowed}`);

    if (!is_allowed) {
        alert("Unauthorized access denied.");
        window.location = '/logout.html';
    }

}

// Loaded by default
checkHasLoggedIn();

