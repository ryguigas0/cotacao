function actionsHTML(idMoeda) {
    return `
    <button onClick="deletarMoeda('${idMoeda}')">Deletar</button>
    `
}

function moeda2HTML(moeda) {
    return `
    <tr class="moeda">
        <th scope="row">${moeda.id}</th>
        <td class="name">${moeda.nome}</td>
        <td>${moeda.simbolo}</td>
        <td>${moeda.sigla}</td>
        <td>${actionsHTML(moeda.id)}</td>
    </tr>
    `
}

async function listarMoedas() {
    try {
        const response = await fetch('http://localhost:8080/moedas', {
            method: "get",
            headers: {
                "Content-Type": "application/json"
            }
        });

        const listaMoedas = await response.json();

        console.log("Sucesso:", listaMoedas);

        const moedaTable = document.querySelector("#table-moedas")

        moedaTable.innerHTML = "";

        for (let i = 0; i < listaMoedas.length; i++) {
            moedaTable.innerHTML += moeda2HTML(listaMoedas[i])
        }

    } catch (error) {
        console.error("List error:", error);
    }
}

listarMoedas()

async function deletarMoeda(idMoeda) {
    console.log("Deletar:", idMoeda)

    try {
        const response = await fetch(`http://localhost:8080/moeda/${idMoeda}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json",
            }
        });

        if (response.status == 200) {
            listarMoedas()
        }
    } catch (error) {
        console.log("Delete error: ", error)
    }
}

function filtrarMoedas() {
    console.log("pesquisando")
    const target = document.querySelector("#target").value.toLocaleLowerCase()
    const moedaElements = document.querySelectorAll("#table-moedas > tr.moeda")

    for (let i = 0; i < moedaElements.length; i++) {
        let nomeMoeda = moedaElements[i].querySelector(("td.name")).textContent.toLocaleLowerCase()
        if (!nomeMoeda.includes(target)) {
            moedaElements[i].classList.add("d-none")
        } else {
            moedaElements[i].classList.remove("d-none")
        }

    }
}

async function criarMoeda() {
    console.log("Criar moeda")

    try {
        const response = await fetch(`http://localhost:8080/moeda`, {
            method: "post",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "nome": document.getElementById("moeda-nome").value,
                "simbolo": document.getElementById("moeda-simbolo").value,
                "sigla": document.getElementById("moeda-sigla").value
            })
        });

        if (response.status == 200) {
            listarMoedas()
        } else {
            console.error(response.status, response.body)
        }
    } catch (error) {
        console.log("Create error: ", error)
    }
}