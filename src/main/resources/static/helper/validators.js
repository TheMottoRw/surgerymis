function validateText(str){
    let pattern = /^[a-z0-9 ]+$/i;
    return pattern.test(str);
}
function validateAlphabets(str){
    let pattern = /^[a-z ]+$/i;
    return pattern.test(str);
}


function validatePhoneNumber(phone){
    let pattern = /^[0-9]{10,15}$/i;
    return pattern.test(phone);
}
function validateRwandanPhoneNumber(phone){
    let pattern = /^(25)?07(2|3|8|9)[0-9]{7}$/i;
    return pattern.test(phone);
}
function validateEmail(email){
    var pattern = /^[a-zA-Z0-9.]+@[a-zA-Z0-9_]+?\.[a-zA-Z]{2,3}$/;
    return pattern.test(email);
}
function validateNumber(num){
    let pattern = /^[0-9]+$/;
    return pattern.test(num);
}