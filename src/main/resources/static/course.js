// Course modules data
const modules = [
    { id: 1, topic: "Topic 1", view: "java-module1.html", quiz: "java-quiz1.html" },
    { id: 2, topic: "Topic 2", view: "java-module2.html", quiz: "java-quiz2.html" },
    { id: 3, topic: "Topic 3", view: "java-module3.html", quiz: "java-quiz3.html" },
    { id: 4, topic: "Topic 4", view: "java-module4.html", quiz: "java-quiz4.html" },
    { id: 5, topic: "Topic 5", view: "java-module5.html", quiz: "java-quiz5.html" },
    { id: 6, topic: "Topic 6", view: "java-module6.html", quiz: "java-quiz6.html" },
    { id: 7, topic: "Topic 7", view: "java-module7.html", quiz: "java-quiz7.html" }
];

// Track completed quizzes
let completedQuizzes = JSON.parse(localStorage.getItem("completedQuizzes") || "[]");

// Load modules dynamically
function loadModules() {
    const container = document.getElementById("modules-container");
    container.innerHTML = "";

    modules.forEach(mod => {
        // Locked until 5 quizzes completed
        const locked = completedQuizzes.length < 5 && mod.id > 5;

        container.innerHTML += `
        <div class="col-md-6 mb-2">
            <div class="d-flex justify-content-between align-items-center border p-2">
                <span>Module ${mod.id}: ${mod.topic}</span>
                <div>
                    <a href="${locked ? "#" : mod.view}" class="btn btn-primary btn-sm ${locked ? "disabled" : ""}">View</a>
                    <a href="${locked ? "#" : mod.quiz}" class="btn btn-success btn-sm ${locked ? "disabled" : ""}">Quiz</a>
                </div>
            </div>
        </div>
        `;
    });
}

loadModules();
