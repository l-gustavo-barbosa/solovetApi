
getNome();


 async function getNome(){
    try{
        const response = await fetch("http://localhost:8080/veterinario/gabrieladamasio@solovet.com", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": sessionStorage.getItem("token").replaceAll('"','')
                
            }
    });

    if(response.ok){
        const data = await response.json();
        console.log(JSON.stringify(data.nome));
        document.getElementById("nomeVeterinario").innerHTML = JSON.stringify(data.nome).replaceAll('"','');
    } else {
        console.error("Erro ao carregar as informações do usuário.", response.statusText)
    }
    } catch (error){
        console.error("Error: ", error);
    }
}