
function fazPost(url, body) {
    console.log("Body=", body)
    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.send(JSON.stringify(body))

    request.onload = function() {
        console.log(this.responseText)
    }

    return request.responseText
}


function cadastraUsuario() {
    event.preventDefault()
    let url = "http://localhost:6787/employees"
    let nome = document.getElementById("nome").value
    let email = document.getElementById("email").value
    let lastName = document.getElementById("lastName").value
    let id = document.getElementById("id").value
    console.log(nome)
    console.log(email)

    body = {
        "firstName": nome,
        "lastName": lastName,
        "email":email,
        "id":id
    }

    fazPost(url, body)
}