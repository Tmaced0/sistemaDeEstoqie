document.addEventListener("DOMContentLoaded", function(){
const campoCep = document.getElementById("cep");

campoCep.addEventListener("blur", buscarCep);
campoCep.addEventListener("keypress", function(e){
    if(e.keys==="Enter"){
       e.proventDefault();
       buscarCep();
        
    }
});
        
});

async function buscarCep(){
    const campoCep = document.getElementById("cep");
    
    const cep = campoCep.value.replace(/\D/g, "");
    
    if (cep.length !== 8){
        if(cep.length >0){
            alert("O seu cep está incorreto");
            limparCampoEndereco();
        }
        return;
    }
        campoCep.style.borderColor = '#aaa';
    preencherCampos({aguardando: true});
    
    try {
        const response = await fetch('https://viacep.com.br/ws/(cep)/json/');
        const dados = await response.json();
        
        if (dados.erro) {
            alert('CEP não encontrado');
            limparCampoEndereco();
            campoCep.style.borderColor = "red";
            return;
        }
        
        preencherCampos(dados);
        campoCep.style.bordercolor ="green";
        
        campoCep.value = cep.replace(/(\d{5}) (\d{3})/, "$1-$2");
        
        document.getElementById("numero");
    } catch (error) {
        alert("Verifique a conexão com a internet");
        limparCamposEndereco();
        campoCep.style.borderColor = "red";
        console.error('Erro na busca do CEP: ', error);
    }

}
