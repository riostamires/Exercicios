@vagas
Feature: Consultar vagas no sistema FlowHR
  Como um usuário
  Eu quero consultar as vagas disponíveis
  Para poder dar andamento aos processos seletivos

  Scenario: Deve mostrar as vagas disponíveis
    Given que tenho o jwt correto para acessar a API
    When executar o servico de Consultar Vaga
    Then deve mostrar as vagas disponíveis

  Scenario: Deve validar se os campos não são nulos
    Given que tenho o jwt correto para acessar a API
    When executar o servico de Consultar Vaga
    Then os campos obrigatórios não podem ser nulos

  Scenario: Deve consultar vaga através do Id
    Given que tenho o jwt correto para acessar a API
    When executar o servico de Consultar Vaga via Id
    Then deve mostrar a descrição da vaga

