# BooApp
########################################################################

dodanie nowej rezerwacji - metoda HTTP - POST
localhost:8089/api/addReservation

w ciele wiadomości wysyłamy przykładowego jsona:

{
    "id": 9,
    "user": {
        "id": 1,
        "name": "Tomek",
        "role": "LANDLORD",
        "reservationId": 0
    },
    "objectForRent": {
        "id": 1,
        "name": "Mieszkanie",
        "unitPrice": 50.0,
        "area": 2000.0,
        "description": "Bardzo ładny dom"
    },
    "price": 9.0,
    "date": "2022-04-24",
    "userId": 2,
    "objectId": 1
}

w nagłówkach dodajemy nagłówek objectId z wartością obiektu: 1

########################################################################

edycja rezerwacji - metoda HTTP - POST
localhost:8089/api/editReservation

w ciele wiadomości wysyłamy przykładowego jsona obiektu którego chcemy edytować wraz ze zmodyfikowanymi elementami np. cena, data, userId, objectId.

{
    "id": 9,
    "user": {
        "id": 1,
        "name": "Tomek",
        "role": "LANDLORD",
        "reservationId": 0
    },
    "objectForRent": {
        "id": 1,
        "name": "Mieszkanie",
        "unitPrice": 50.0,
        "area": 2000.0,
        "description": "Bardzo ładny dom"
    },
    "price": 9.0,
    "date": "2022-04-24",
    "userId": 2,
    "objectId": 1
}

########################################################################

pobranie listy rezerwacji dla użytkownika - po jego nazwie-imieniu - metoda HTTP - GET
localhost:8089/api/reservations

w nagłówkach dodajemy nagłówek userName z wartością: Tomek

########################################################################

pobranie listy rezerwacji dla danego obiektu - po jego nazwie obiektu - metoda HTTP - POST
localhost:8089/api/reservations

w nagłówkach dodajemy nagłówek objectName z wartością: Mieszkanie lub Dom

########################################################################

-wgrywanie do bazy danych obiektów możliwych do zarezerwowania, oraz użytkowników, odbywa się przy pomocy odpowiednio RestObjectForRentController i RestUserController, a nie z pliku, to też mogę zmienić, ale potrzebuję na to jeszcze trochę czasu
-do uruchomienia bazy danych jest potrzebny zainstalowany i uruchomiony xamp, po jego uruchomieniu należy uruchomić dwa moduły: Apache i MySQL i zmienić port dla MySQLa na 3307 
-w testach korzystam ze stubów, a nie mocków
-nie dodałem jeszcze hibernate-a/korzystam z JDBC
-w wyciąganych jsonach nie zamieniłem niepotrzebnych obiektów na ich referencje/adresy
