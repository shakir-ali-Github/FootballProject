"use strict";

document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault(); 

    console.log("THIS:", this);

    const data = {
        name: this.name.value,
        position: this.position.value,
        email: this.email.value,
        age: this.age.value
    }

    console.log("DATA:", data);

    axios.post("http://localhost:8080/createFootballer", data)
            .then(res => {
                console.log("RES:", res);
                this.reset();
                this.name.focus();
                renderFootballers();
            })
            .catch(err => console.error(err));
});

const output = document.querySelector("#output");

function renderFootballers() {
    axios.get("http://localhost:8080/getFootballers")
        .then(res => {
            console.log("footballers: ", res.data);
            output.innerHTML = "";
            for (let footballer of res.data) {
                const footballerCol = document.createElement("div");
                footballerCol.className = "col";

                const footballerCard = document.createElement("div");
                footballerCard.className = "card";
                footballerCol.appendChild(footballerCard);

                const footballerDiv = document.createElement("div");
                footballerDiv.className = "card-body";
                footballerCard.appendChild(footballerDiv);

                const footballerName = document.createElement("h2");
                footballerName.innerText = footballer.name;
                footballerDiv.appendChild(footballerName);

                const footballerPosition = document.createElement("p");
                footballerPosition.innerText = footballer.position;
                footballerDiv.appendChild(footballerPosition);

                const footballerEmail = document.createElement("p");
                footballerEmail.innerText = footballer.email;
                footballerDiv.appendChild(footballerEmail);

                const footballerAge = document.createElement("p");
                footballerAge.innerText = footballer.age + " years old.";
                footballerDiv.appendChild(footballerAge);

                const footballerUpdate = document.createElement('button');
                footballerUpdate.innerText = "UPDATE";
                footballerUpdate.classList.add("btn", "btn-secondary");
                footballerUpdate.addEventListener("click", () => {
                    console.log();
                    updateFootballer(footballer.id);
                });
                

                footballerDiv.appendChild(footballerUpdate);

                output.appendChild(footballerCol);

                const footballerDelete = document.createElement('button');
                footballerDelete.innerText = "DELETE";
                footballerDelete.classList.add("btn", "btn-danger");
                footballerDelete.addEventListener("click", () => {
                    console.log("FOOTBALLER: ", footballer);
                    deleteFootballer(footballer.id);
                });

                footballerDiv.appendChild(footballerDelete);

                output.appendChild(footballerCol);
            }
        })
        .catch(err => console.error(err));
}

const deleteFootballer = (id) => {
    axios.delete("http://localhost:8080/removeFootballer/" + id)
            .then(res => {
                console.log("Delete successful");
                renderFootballers();
            }).catch(err => console.error(err));
}

function updateFootballer(id) {

    const updatedName = document.getElementById("name").value

    const updatedPosition = document.getElementById("position").value

    const updatedEmail = document.getElementById("email").value

    const updatedAge = document.getElementById("age").value

    axios.patch(`http://localhost:8080/updateFootballer/${id}?name=${updatedName}&position=${updatedPosition}&email=${updatedEmail}&age=${updatedAge}`)

                .then(res => {

                    console.log("RESPONSE: ", res);

                    renderFootballers();

                })

                .catch(err => console.error(err));

        }

renderFootballers();