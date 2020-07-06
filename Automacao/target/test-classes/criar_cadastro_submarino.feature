Feature: Testar tela de cadastro do site submarino
  Como um cliente
  Eu quero me cadastrar no site submarino
  Para realizar compras

  Scenario: Deve realizar cadastro com sucesso
  Given que acessei a URL correta
  And preenchi o email com "teste@teste.com"
  And preenchi a senha com "STR@da230411"
  And preenchi o cpf com "01457340054"
  And preenchi o nome e sobrenome com "Tamires Rios"
  And preenchi a data de nascimento com "04111993"
  And cliquei no sexo corretamente
  And preenchi o telefone com "51985262322"
  When clicar em criar seu cadastro
  Then deve mostrar a mensagem "VERIFICAR"

  Scenario: Deve deixar o email em branco
    Given que acessei a URL correta
    And preenchi o email com " "
    And preenchi a senha com "STR@da230411"
    And preenchi o cpf com "01457340054"
    And preenchi o nome e sobrenome com "Tamires Rios"
    And preenchi a data de nascimento com "04111993"
    And cliquei no sexo corretamente
    And preenchi o telefone com "51985262322"
    When clicar em criar seu cadastro
    Then devo ser alertado "Campo obrigatório"