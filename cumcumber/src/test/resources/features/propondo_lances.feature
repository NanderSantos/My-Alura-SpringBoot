# language: pt

Funcionalidade: Propondo lances

  Cenário: Propondo um único lance válido
    Dado um lance válido
    Quando propõe ao leilão
    Então o lance é aceito

  Cenário: Propondo vários lances válidos
    Dado um lance de 10.00 reais do usuário "fulano"
    E um lance de 15.00 reais do usuário "beltrano"
    Quando propõe vários lances ao leilão
    Então os lances são aceitos