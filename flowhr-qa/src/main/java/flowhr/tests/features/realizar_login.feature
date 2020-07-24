@login
Feature: Realizar login no sistema FlowHR
  Como um usuário
  Eu quero fazer login no sistema
  Para acessar informações sobre as vagas

  Scenario: Deve fazer login com sucesso
    Given que informei o usuário e senha corretamente
    When realizar o login
    Then deve acessar minha conta no sistema

  Scenario: Não deve fazer login com dados em branco
    Given que não informei os dados
    When realizar o login
    Then não deve acessar minha conta no sistema

  Scenario: Não deve fazer login com dados inválidos
    Given que informei dados invalidos
    When realizar o login
    Then não deve acessar minha conta no sistema