var validate = function () {

    //FullName validation
    var fullname = document.getElementById("fullname").value;

    if(fullname.length === 0) {
        document.getElementById("invalid_fullname").innerText = "Field can not be empty";

    } else if(isNumeric(fullname)) {
        document.getElementById("invalid_fullname").innerText = "Field can not contain digits";
    }else {
        document.getElementById("invalid_fullname").innerText = "";
    }

    // Login validation
    var login = document.getElementById("login").value;

    if(login.length === 0) {
        document.getElementById("invalid_login").innerText = "Field can not be empty";

    } else if (login.length < 4) {
        document.getElementById("invalid_login").innerText = "Login must be at least 4 characters";
    }else {
        document.getElementById("invalid_login").innerText = "";
    }

    //Password validation
    var password = document.getElementById("password").value;

    var confirmPassword = document.getElementById("confirm_password").value;

    if (password !== confirmPassword) {
        document.getElementById("invalid_password").innerText = "Passwords do not match";
        return false;

    } else if(password.length < 6) {
        document.getElementById("invalid_password").innerText = "Password must be at least 6 characters";
        return false;

    } else {
        document.getElementById("invalid_password").innerText = "";

    }

    //Email validation
    var pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var email = document.getElementById("email").value;

    if(email.length === 0) {
        document.getElementById("invalid_email").innerText = "Email can not be empty";

        return false;
    }else if(!pattern.test(String(email).toLowerCase())) {

        document.getElementById("invalid_email").innerText = "Email has an incorrect format";
        return false;
    } else {
        document.getElementById("invalid_email").innerText = "";
    }

    return true;
};

function isNumeric(n) {
    if(!isNaN(n))
    {
        return true
    }
    else
    {
        return false
    }
}