console.log("teste");
getNome();


 function getNome(){
    try{
        const response = fetch("http://localhost:8080/veterinario/" + localStorage.getItem("email"), {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorizathion": "Bearer: " + localStorage.getItem("tokenJWT")
            }
    });

    if(response.ok){
        const data = response.json();
        document.getElementById("nomeVeterinario").value = response;
    } else {
        console.error("Erro ao carregar as informações do usuário.", response.statusText)
    }
    } catch (error){
        console.error("Error: ", error);
    }
}