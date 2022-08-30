Feature: Task2

  Scenario: Kupienie swetra
    Given Uzytkownik jest juz zalogowany
    When wybierze do zakupu Hummingbird Printed Sweater
    And wybierze rozmiar "M"
    And wybierze 5 sztuk według parametru podanego w teście
    And doda produkt do koszyka
    And przejdzie do opcji - checkout
    And potwierdzi address
    And wybierze metodę odbioru - PrestaShop pick up in store
    And wybierze opcję płatności - Pay by Check
    And kliknie na - order with an obligation to pay
    Then zrobi screenshot z potwierdzeniem zamówienia i kwotą
    And Zamknie okno przegladarki