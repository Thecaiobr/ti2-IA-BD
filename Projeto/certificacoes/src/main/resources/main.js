function fazGet(url) {
    let request = new XMLHttpRequest()
    request.open("GET", url, false)

    request.send()

    return request.responseText
    
}

function criaLinha(usuario) {
    console.log(usuario)
    linha = document.createElement("tr");
    tdId = document.createElement("td");
    tdNome = document.createElement("td");
    tdLastName = document.createElement("td");
    email = document.createElement("td");
    tdId.innerHTML = usuario.id
    tdNome.innerHTML = usuario.firstName
    tdLastName.innerHTML = usuario.lastName
    email.innerHTML = usuario.email

    linha.appendChild(tdId);
    linha.appendChild(tdNome);
    linha.appendChild(tdLastName);
    linha.appendChild(email);

    return linha;
}

function main() {
    let data = fazGet("http://localhost:6787/employees");
    console.log(data);
    let usuarios = JSON.parse(data);
    console.log(usuarios.data);
    let tabela = document.getElementById("tabela");
    usuarios.data.forEach(element => {
        let linha = criaLinha(element);
        tabela.appendChild(linha);
    });
    // Para cada usuario
        // criar uma linha
        // adicionar na tabela
}

main()