# language: pt

@leilão
Funcionalidade: Cadastrando um leilão

  Contexto:
    Dado um usuário logado

  Cenário: Um usuário logado pode cadastrar um leilão
    Quando acessa a página de novo leilão
    E prenche o formulário com dados válidos
    Então volta para a página de leilões
    E o novo leilão aparece na tabela