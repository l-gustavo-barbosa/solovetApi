document.getElementById("cadastroVet").addEventListener("submit", function(event) {
    event.preventDefault(); // Evitar o comportamento padrão do formulário

    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const fone = document.getElementById("fone").value;
    const crmv = document.getElementById("crmv").value;
    cadastro(nome, email, fone, crmv);
});

const token = localStorage.getItem("tokenJWT");

async function cadastro(nome, email, fone, crmv){
    try{
        const response = await fetch("http://localhost:8080/veterinario/cadastrar", {
            
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${token}`
            },
            body: JSON.stringify({
                nome:nome,
                email:email,
                fone:fone,
                crmv:crmv
            })
        });

        if(response.ok){
            const data = await response.json();
            console.log("Cadastro finalizado: ", data);
            location.href = "dashboard.html";
        } else {
            console.error("Erro no cadastro:", response.statusText)
        }
    } catch (error) {
        console.error("Error:", error);
      }
}