
document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evitar o comportamento padrão do formulário

    const username = document.getElementById("login").value;
    const password = document.getElementById("password").value;

    login(username, password);
});

document.getElementById("btnLogin").addEventListener("click", function(event){
    document.getElementById("containerCadastro").classList.remove("hidden");
    document.getElementById("containerLogin").classList.add("hidden");
})

document.getElementById("btnCadastro").addEventListener("click", function(event){
    document.getElementById("containerLogin").classList.remove("hidden");
    document.getElementById("containerCadastro").classList.add("hidden");
})

document.getElementById("signupForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evitar o comportamento padrão do formulário

    const username = document.getElementById("loginCadastro").value;
    const password = document.getElementById("passwordCadastro").value;
    const password2 = document.getElementById("password2").value;
    if(password == password2){
        cadastro(username, password);
    } else {
        window.alert("Suas senhas não coincidem.");
        document.getElementById("passwordCadastro").value = "";
        document.getElementById("password2").value = "";
    }
    
});

async function login(username, password){
    try{
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
            const data = await response.json();
            console.log("Login bem sucedido: ", data.stringify(Object.token));
            localStorage.setItem("tokenJWT", data);
            localStorage.setItem("email", username);
            location.href = "dashboard.html"
            
        } else {
            console.error("Erro no login:", response.statusText)
        }
    } catch (error) {
        console.error("Error:", error);
      }
}

async function cadastro(username, password){
    try{
        const response = await fetch("http://localhost:8080/usuarios/cadastro", {
            
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
            const token = await fetch("http://localhost:8080/usuarios/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    username:username,
                    password:password
                })
            })
            console.log(token.stringify());
            localStorage.setItem("tokenJWT", token.JSON());
            location.href = "veterinarioForm.html";
            
        } else {
            console.error("Erro no cadastro:", response.statusText)
        }
    } catch (error) {
        console.error("Error:", error);
      }
}