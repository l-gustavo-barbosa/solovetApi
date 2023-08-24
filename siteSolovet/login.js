document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evitar o comportamento padrão do formulário

    const username = document.getElementById("login").value;
    const password = document.getElementById("password").value;

    login(username, password);
}); 

async function login(username, password){
    console.log("teste");
    try{
        console.log("teste");
        const response = await fetch("http://localhost:8080/usuarios/login", {
            
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                username:username,
                password:password
            })
        });
        if(response.ok){
            const data = await responde.json();
            console.log("Login bem sucedido: ", data);
        } else {
            console.error("Erro no login:", response.statusText)
        }
    } catch (error) {
        console.error("Error:", error);
      }
}
