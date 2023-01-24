// Call the dataTables jQuery plugin

async function iniciarSesion(){
    let datos = {};
    
    datos.email = document.getElementById("txtEmail").value;
    datos.password = document.getElementById("txtPassword").value;
    
    console.log("Datos que viajan: " + JSON.stringify(datos));
    
    const response = await fetch('api/login', {
        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    
    //const request = await response.json();
    const request = await response.text();
    console.log("Respuesta de la invocacion de logueo: " + request);
    
    if(request != 'FAIL'){
        localStorage.token = request;
        localStorage.email = datos.email;
        window.location.href = 'usuarios.html';
    }
    else{
        alert("Las credenciales son incorrectas, por favor intente nuevamente");
    }
}