/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//  
function validarLetras(e) { // 1
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) 
        return true; // backspace
    if (tecla==32) 
        return true; // espacio
    if (e.ctrlKey && tecla==86){ 
        return true;
    } //Ctrl v
    if (e.ctrlKey && tecla==67){ 
        return true;
    } //Ctrl c
    if (e.ctrlKey && tecla==88){ 
        return true;
    } //Ctrl x
 
    patron = /[a-zA-Z]/; //patron
 
    te = String.fromCharCode(tecla);
    return patron.test(te); // prueba de patron
}

function validaFormu() {
    var email = document.getElementById("correo").value;
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apel").value;
    var contra1 = document.getElementById("pass1").value;
    alert(contra1);
    var contra2 = document.getElementById("pass2").value;
    alert(contra2);
    var fecha = document.getElementById("fechaNac").value;

    patron =  /\S+@\S+\.\S+/;
  
    if((patron.test(email)) && (nombre!='') && (apellido!='') && (contra1!='') && (contra2!='') && (fecha!='') && (contra1==contra2)){ 
   return true;} 
  else{
       if(nombre=='')
        alert("Nombre vacío, ingrese su nombre.");
     if(apellido=='')
        alert("Apellido vacío, ingrese su apellido.");
     if(!patron.test(email))
        alert("Correo invalido");
     if(contra1=='' || contra2=='')
        alert("Revise sus contraseñas.");
     if(contra1!=contra2)
        alert("Las contraseñas no coinciden.");
     if(fecha=='')
        alert("Fecha vacía, ingrese una fecha.");
    
    
    return false;
    }
}
              
function validaForm() { 

//alert(flag);

  var email = document.getElementById("correo").value;
  var nombre = document.getElementById("nombre").value;
  var apellido = document.getElementById("apel").value;
  var contra1 = document.getElementById("pass4").value;
  var contra2 = document.getElementById("pass5").value;
  var fecha = document.getElementById("fechaNac").value;

  patron =  /\S+@\S+\.\S+/;

  if(flag){
	  if((patron.test(email)) && (nombre!='') && (apellido!='') && (contra1!='') && (contra2!='') && (fecha!='') && (contra1==contra2)){ 
	   return true;
	 } 
	  else{
	       if(nombre=='')
		alert("Nombre vacío, ingrese su nombre.");
	     if(apellido=='')
		alert("Apellido vacío, ingrese su apellido.");
	     if(!patron.test(email))
		alert("Correo invalido");
	     if(contra1=='' || contra2=='')
		alert("Revise sus contraseñas.");
	     if(contra1!=contra2)
		alert("Las contraseñas no coinciden.");
	     if(fecha=='')
		alert("Fecha vacía, ingrese una fecha.");
	    
	    return false;
           }
 }else{
	  var email = document.getElementById("correo").value;
	  var nombre = document.getElementById("nombre").value;
	  var apellido = document.getElementById("apel").value;
	  var fecha = document.getElementById("fechaNac").value;
	
	  patron =  /\S+@\S+\.\S+/;
	  
	  if((patron.test(email)) && (nombre!='') && (apellido!='') && (fecha!='')){ 
	   	return true;
	   }else{
	       if(nombre=='')
		alert("Nombre vacío, ingrese su nombre.");
	     if(apellido=='')
		alert("Apellido vacío, ingrese su apellido.");
	     if(!patron.test(email))
		alert("Correo invalido");
	     if(fecha=='')
		alert("Fecha vacía, ingrese una fecha.");
	    
	    return false;
         }
} 
}