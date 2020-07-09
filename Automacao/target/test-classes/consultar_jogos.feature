Feature: Consultar jogos no site
  Como um torcedor
  Eu quero consultar os jogos do dia
  Para poder assistir

  Scenario: Deve informar se tera jogo hoje
    Given que acessei a URL SofaScore corretamente
    When clicar em Espanha
    Then deve mostrar se tera jogo hoje
