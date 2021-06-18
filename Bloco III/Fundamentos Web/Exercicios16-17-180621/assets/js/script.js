let nome = document.querySelector("#nome")
let email = document.querySelector("#email")
let assunto = document.querySelector("#assunto")
let mapa = document.querySelector("#mapa")
let nomeValidado = false
let emailValidado = false
let assuntoValidado = false


nome.style.width = "100%"
email.style.width = "100%"
assunto.style.width = "100%"

function validaNome() {
    let txtNome = document.querySelector("#txtNome")
    if(nome.value.length < 3) {
        txtNome.innerHTML = "Nome Inválido"
        txtNome.style.color = "red"
    } else {
        txtNome.innerHTML = "Nome Válido"
        txtNome.style.color = "green"
        nomeValidado = true
    }
}

function validaEmail() {
    let txtEmail = document.querySelector("#txtEmail")
    if(email.value.indexOf("@") == -1 || email.value.indexOf(".") == -1) {
        txtEmail.innerHTML = "Email Inválido"
        txtEmail.style.color = "red"
    } else {
        txtEmail.innerHTML = "Email Válido"
        txtEmail.style.color = "green"
        emailValidado = true
    }
}

function validaAssunto() {
    let txtAssunto = document.querySelector("#txtAssunto")
    if(assunto.value.length >= 100){
        txtAssunto.innerHTML = "Por favor, digite no máximo 100 caracteres"
        txtAssunto.style.fontWeight = "bold"
        txtAssunto.style.backgroundColor = "orangered"
    } else {
        txtAssunto.innerHTML = null
        assuntoValidado = true
    }
}

function enviar() {
    if (nomeValidado == true && emailValidado == true && assuntoValidado == true){
        alert("Formulário enviado com sucesso!")
    } else {
        alert("Por favor, preencha o formulário corretamente antes de envia-lo.")
    }
}

function mapaZoom(){
    mapa.style.width = "600px"
    mapa.style.height = "400px"
}

function mapaNormal(){
    mapa.style.width = "500px"
    mapa.style.height = "300px"
}