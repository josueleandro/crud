// Call the dataTables jQuery plugin

async function registrarUsuarios(){
    let datos = {};
    datos.nombre = document.getElementById("txtNombre").value;
    datos.apellido = document.getElementById("txtApellido").value;
    datos.email = document.getElementById("txtEmail").value;
    datos.telefono = document.getElementById("txtTelefono").value;
    datos.password = document.getElementById("txtPassword").value;
    
    let repetirPassword = document.getElementById("txtRepetirPassword").value;
    
    if(repetirPassword != datos.password){
        alert("La contrasena que ingresaste no es igual");
        return;
    }
    
    console.log("Datos que viajan: " + JSON.stringify(datos));
    
    const response = await fetch('api/usuarios', {
        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("La cuenta fue creada con exito");
    window.location.href = 'login.html';
}