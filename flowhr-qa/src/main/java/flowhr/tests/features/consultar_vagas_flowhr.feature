@vagas
Feature: Consultar vagas no sistema FlowHR
  Como um usuário
  Eu quero consultar as vagas disponíveis
  Para poder dar andamento aos processos seletivos

  Scenario: Deve mostrar as vagas disponíveis
    Given que tenho o jwt correto para acessar a API
    When executar o servico de Consultar Vaga
    Then deve mostrar as vagas disponíveis