Feature: Task1

  Scenario Outline: Dodanie nowego adresu i sprawdzenie czy jest poprawny

    Given Uzytkownik jest zalogowany
    When Uzytkownik wchodzi w strone z adresami
    And Dodada nowy adres z danymi: "<alias>", "<address>", "<city>", "<postCode>", "<country>", "<phone>"
    Then Dane nowego adresu powinny byc zgodne z: "<alias>", "<address>", "<city>", "<postCode>", "<country>", "<phone>"
    And Zamknie przegladarke

    Examples:
      |alias        |address            |city       |postCode |country          |phone  |
      |Agnieszka1   |Pruszkowska 15/56  |Wiskitki   |03-562   |United Kingdom   |524365123  |
      |Agnieszka2   |Kolejarza 12/58    |Rybno      |01-235   |United Kingdom   |452147951  |
      |Agnieszka3   |Niema 25/98        |Tarczyn    |05-652   |United Kingdom   |632185945  |
      |Agnieszka4   |Nowowiejska 12     |Szczecin   |02-123   |United Kingdom   |598254678  |