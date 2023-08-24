document.getElementById("submit").addEventListener("click", login( document.getElementById("login").innerHTML, document.getElementById("password").innerHTML)); 

async function login(username, password){
    console.log("teste");
    try{
        console.log("teste");
        const response = await fetch("http://localhost:8080/usuarios/login",{
            
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: {
                "username":username,
                "password":password
            }
        })
    } catch (error) {
        console.error("Error:", error);
      }
}