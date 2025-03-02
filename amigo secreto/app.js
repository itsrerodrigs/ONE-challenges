let amigos = []

function adicionarAmigo() {
    let inputAmigo = document.getElementById('amigo');
    let nomeAmigo = inputAmigo.value;

    if (!nomeAmigo) {
        alert("Opa, é necessário digitar o nome de, pelo menos, um amigo para cadastrar! Tente novamente.");
        return;
    }
    amigos.push(nomeAmigo);
    inputAmigo.value = "";
    inputAmigo.focus();
    atualizarAmigo();
}

function atualizarAmigo(){
    let listaAmigos = document.getElementById("listaAmigos");
    listaAmigos.innerHTML = "";

    for(let i = 0; i < amigos.length; i++){
        let item = document.createElement("li");
        item.textContent = amigos[i];
        listaAmigos.appendChild(item);
    }
}

function sortearAmigo(){
    if(amigos.length === 0){
        alert("Ops! Nenhum amigo foi cadastrado. Tente novamente!");
        return;
    }

    let amigoSorteado = amigos[Math.floor(Math.random() * amigos.length)];
    let resultado = document.getElementById("resultado");

    resultado.innerHTML = `Seu amigo secreto é: ${amigoSorteado}`;

    let limparLista = document.getElementById("listaAmigos");
    limparLista.innerHTML = "";
}