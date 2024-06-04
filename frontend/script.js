const form = document.getElementById('exercicio-form');
const nomeInput = document.getElementById('nome');
const grupoMuscularInput = document.getElementById('grupoMuscular');
const seriesInput = document.getElementById('series');
const repeticoesInput = document.getElementById('repeticoes');
const listaExercicios = document.getElementById('exercicios-list');

let exercicios = [];

form.addEventListener('submit', function(event) {
    event.preventDefault();

    const exercicio = {
        nome: nomeInput.value,
        grupoMuscular: grupoMuscularInput.value,
        series: parseInt(seriesInput.value),
        repeticoes: parseInt(repeticoesInput.value)
    };

    criarExercicio(exercicio);
});

function criarExercicio(exercicio) {
    exercicios.push(exercicio);
    renderizarExercicios();
    limparFormulario();
}

function renderizarExercicios() {
    listaExercicios.innerHTML = '';
    exercicios.forEach(function(exercicio, index) {
        const item = document.createElement('li');
        item.innerHTML = `
            <span>Nome:</span> ${exercicio.nome}<br>
            <span>Grupo Muscular:</span> ${exercicio.grupoMuscular}<br>
            <span>Séries:</span> ${exercicio.series}<br>
            <span>Repetições:</span> ${exercicio.repeticoes}<br>
            <button onclick="editarExercicio(${index})">Editar</button>
            <button onclick="deletarExercicio(${index})">Deletar</button>
        `;
        listaExercicios.appendChild(item);
    });
}

function limparFormulario() {
    nomeInput.value = '';
    grupoMuscularInput.value = '';
    seriesInput.value = '';
    repeticoesInput.value = '';
}

function editarExercicio(index) {
    const exercicio = exercicios[index];
    nomeInput.value = exercicio.nome;
    grupoMuscularInput.value = exercicio.grupoMuscular;
    seriesInput.value = exercicio.series;
    repeticoesInput.value = exercicio.repeticoes;

    exercicios.splice(index, 1);
    renderizarExercicios();
}

function deletarExercicio(id) {
    const confirmation = confirm('Tem certeza que deseja excluir este exercício?');
    if (confirmation) {
        fetch(`${URL_BASE}/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                carregarExercicios();
                console.log('Exercício deletado com sucesso');
            } else {
                throw new Error('Erro ao deletar exercício');
            }
        })
        .catch(error => console.error('Erro ao deletar exercício:', error));
    }
}

