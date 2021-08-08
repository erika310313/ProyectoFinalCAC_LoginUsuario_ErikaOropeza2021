/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function resetearFormularioRegistro(){
    document.getElementById("formularioRegistro").reset();
    var avisoContrasenia = document.getElementById("avisoContrasenia");
    var btnEnviarDatos = document.getElementById("btnEnviarDatos");
    
    btnEnviarDatos.disabled = true;
    avisoContrasenia.innerHTML = "------------------";
    avisoContrasenia.style.color = "black";
    
    
}

function coincidirContrasenia(){
    var txtContrasenia = document.getElementById("txtContrasenia");
    var txtRepetirContrasenia = document.getElementById("txtRepetirContrasenia");
    var avisoContrasenia = document.getElementById("avisoContrasenia");
    var btnEnviarDatos = document.getElementById("btnEnviarDatos");
    
    btnEnviarDatos.disabled = true; //Botón en desactivado o apagado
    
    
    if(txtContrasenia.value.length === 0 || txtRepetirContrasenia.value.length === 0){
        avisoContrasenia.innerHTML = "Ninguna de las contraseñas puede quedar vacias";
        avisoContrasenia.style.color = "blue";
        btnEnviarDatos.disabled = true;
        
    }else if(txtContrasenia.value !== txtRepetirContrasenia.value){
        avisoContrasenia.innerHTML = "Las contraseñas deben coincidir";
        avisoContrasenia.style.color = "red";
        btnEnviarDatos.disabled = true;
        
    }else{
        avisoContrasenia.innerHTML = "Las contraseñas coinciden";
        avisoContrasenia.style.color = "green";   
        btnEnviarDatos.disabled = false;
    }
}


