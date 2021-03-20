window.onload = () => {
    retrieveQuestion();
    document.getElementById("reveal").onclick = reveal;
    document.getElementById("next").onclick = retrieveQuestion;
};

function retrieveQuestion() {
    document.getElementById("qdiv").style.display = 'none';
    var c = document.getElementById("category");
    var q = document.getElementById("question");
    var a = document.getElementById("answer");
    var v = document.getElementById("value");
    c.innerHTML = "Loading";

    a.innerHTML = "Loading";
    fetch('http://jservice.io/api/random')
    .then((response) => response.json())
    .then((data) => {



        c.innerHTML = data[0].category.title;
        q.innerHTML = data[0].answer;
        a.innerHTML = data[0].question;
        v.innerHTML = data[0].value
    })
}

function reveal() {
    document.getElementById("qdiv").style.display = 'block';
}