document.getElementById("registerForm").addEventListener("submit", async function(event){
    event.preventDefault()

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    try {
        const  response = await fetch("https://localhost:8443/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username, password })
        });

        if(response.ok){
            alert("User register with sucess");
            window.location.href = "/login";
        } else {
            const errorText = await response.text();
            alert("Error registring a user");
        }
    }
    catch (error){
        alert("Error de conexión: " + error.message);
    }
});