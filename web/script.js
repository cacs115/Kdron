//
//var idUsuario = document.getElementById("idUsuario");
//var idNombreUsuario = document.getElementById("nombreUsuario");
//var idPassword = document.getElementById("password");
//var idRepitaPassword = document.getElementById("repitaPassword");

//idUsuario.value = "Entre Usuario ID";

// Cuando el cuadro de texto obtenga el foco, se ejecuta la siguiente función anónima
//idUsuario.onfocus = function () {
//    if (idUsuario.value == "Entre Usuario ID") {
//        idUsuario.value = "";
//    }
//};


//function desenfoqueIdUsuario() {
//    if (idUsuario.value == "") {
//       // idUsuario.value = "Entre Usuario ID";
//        document.getElementById("idUsuarioReq").style.display = "inline";
//    } else {
//        document.getElementById("idUsuarioReq").style.display = "none";
//    }
//}

//idPassword.onblur = function(){
//    var expReg = /[A-Z]([A-Z]|\d)*/i;
//    if (RegExp(expReg).test(idPassword.value)){
//        alert("Password válido");
//    }else{
//        alert("Password inválido");
//    }
//};

//Cuando se desenfoca el cuadro de texto idUsuario, se ejecuta la función desenfoqueIdUsuario
//idUsuario.onblur = desenfoqueIdUsuario;


// Asocia la función desenfoqueIdUsuario con el evento onblur (desenfoque) del cuandro de texto idUsuario
//idUsuario.addEventListener('blur', desenfoqueIdUsuario);
//
//function formularioValido() {
//    var esValidoElFormulario = true;
//
//    if (idUsuario.value == "" || idUsuario.value =="Entre identificador usuario") {
//        esValidoElFormulario = false;
//    }
//
//    if (idNombreUsuario.value == "") {
//        esValidoElFormulario = false;
//    }
//    return esValidoElFormulario;
//}

/* 
 * Si se le asigna true al evento onsubmit del formulario,
 *  el formulario es enviado; en caso contrario no.
 */
//document.getElementById("frmRegistrese").onsubmit = function () {
//    return formularioValido();
//};






