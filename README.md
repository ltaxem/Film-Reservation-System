## Filmų rezervacija
Mažas projektas, kurtas mokymosi tikslams. Prisijungus vartotojo role, galima rezervuoti filmą, taip pat prisidėti į mėgstamų sąrašą.
Prisijungus administratoriaus role, galima papildomai pridėti filmus, ištrinti ir atnaujinti. Taip pat administratorius gali kurti,
trinti, redaguoti kategorijų sąrašą.

### Instaliavimas
1. Paleiskite serverį su duomenų baze (naudota lokali su [XAMPP](https://www.apachefriends.org/download.html))
2. Klonuokite repozitoriją `https://github.com/ltaxem/Film-Reservation-System.git`
3. Sukurkite duomenų bazę:
   - Naršyklėje įveskite URL adresą **localhost/phpmyadmin**
   - Sukurkite db pavadinimu **examv2**
   - Spauskite **Import**, toliau **Select a file**
   - Eikite į projektą **..\Film-Reservation-System**, susiraskite **MySQL.sql** ir paspauskite **Open**
4. Paleiskite projektą

### Taikytos technologijos
javafx, jdbc, mysql

### Kadrai iš projekto
- **Prisijungimo forma**
![login](https://user-images.githubusercontent.com/94172076/179853039-362efaa3-30b9-4390-923a-fb9c03f0b424.png)

- **Registracijos forma**
![register](https://user-images.githubusercontent.com/94172076/179853053-5dbe4324-2f8c-43b0-8034-6a4b0baf8515.png)

- **Pagrindinis**
![Dashboard](https://user-images.githubusercontent.com/94172076/179854261-5dd73a7f-4f07-4cf3-b7c6-e65e883f95ea.PNG)

- **Skaityti plačiaus**
![FilmMore](https://user-images.githubusercontent.com/94172076/181637324-70ce74d2-bbf7-4aac-98df-621ebbad1ec9.PNG)

- **Mėgstamų filmų sąrašas**
![liked](https://user-images.githubusercontent.com/94172076/180277354-5c36735e-4c17-46f9-a27f-033b9894d779.PNG)
