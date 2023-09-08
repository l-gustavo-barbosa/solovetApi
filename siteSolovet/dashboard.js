console.log(localStorage.getItem("email"));
getNome();


 async function getNome(){
    try{
        const response = await fetch("http://localhost:8080/veterinario/" + localStorage.getItem("email"), {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer: " + localStorage.getItem("tokenJWT"),
                "Acess-Control-Allow-Origin": "*"
            }
    });

    if(response.ok){
        const data = await response.json();
        document.getElementById("nomeVeterinario").value = response;
    } else {
        console.error("Erro ao carregar as informações do usuário.", response.statusText)
    }
    } catch (error){
        console.error("Error: ", error);
    }
}