@consultaFipe
Feature: Validar retorno de campos da Consulta FIPE

	@TestCaseKey=TEST-T3247
  Scenario Outline: Validar ajuste de campos na lista e página de Detalhes da Consulta FIPE
    Given o usuário está logado com um dos perfis <perfil>
    And acessar um dos apps <app>
    When o usuário clicar na Guia Consulta FIPE
    Then o sistema deverá validar se os campos "Aceita veículos novos" e "Vidros" estão retornando "SIM" ou "NÃO" na listagem e na página de Detalhes da Guia Consulta FIPE

    Examples: 
      | perfil               | app                        |
      | Analista             | Azul - Console atendimento |
      | Auditor              | Azul - Console atendimento |
      | Atendimento          | Azul - Console atendimento |
      | Atendimento chat     | Azul - Console atendimento |
      | Backoffice           | Azul - Console atendimento |
      | Monitor Qualidade    | Azul - Console atendimento |
      | Monitor Qualidade    | Supervisor                 |
      | Promotor             | Azul - Console atendimento |
      | Sinistro Regulação   | Azul - Console atendimento |
      | Supervisor           | Supervisor                 |
      | Supervisor Live chat | Supervisor                 |
      | Integração SF        | Azul - Console atendimento |
      | Integração SF        | Supervisor                 |
