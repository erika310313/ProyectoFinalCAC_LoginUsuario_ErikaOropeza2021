/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargarElemento(url, elemento){
    var request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send(null);
    elemento.innerHTML = request.responseText;
}

function cargarRegistroUsuario(){
    cargarElemento("registroUsuario.jsp", document.getElementById("contenidoDinamico"));
}

function cargarLogin(){
    cargarElemento("loginUsuario.jsp", document.getElementById("contenidoDinamico"));
}
