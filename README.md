## Filmų rezervacija
Nedidelis projektėlis kurtas mokymosi tikslams. Prisijungus vartotojo role galime rezervuoti filmą, taip pat filmą prisidėti į mėgstamų sąrašą.
Prisijungus administratoriaus role papildomai galime atlikti filmų pridėjimą sąraše, taip pat trynimą ir atnaujinimą. Administratorius gali kurti,
trinti, redaguoti kategorijų sąrašą.

### Instaliavimas
1. Paleidžiame serverį su duomenų bazę (naudota lokali su [XAMPP](https://www.apachefriends.org/download.html))
2. Klonuojame repozitorija `https://github.com/ltaxem/Film-Reservation-System.git`
3. Kuriame duomenų bazę
   - Naršyklėje įvedame url adresą **localhost/phpmyadmin**
   - Sukuriame db pavadinimu **examv2**
   - Spaudžiame **Import** ir spaudžiame **Select a file**
   - Einame į projektą ..\Egzaminas, susirandame **MySQL.sql** ir spaudžiame **Open**
4. Paleidžiame projektą

### Taikytos technologijos
javafx, hibernate, mysql

### Kadrai iš projekto
- **Prisijungimo forma**
![login](https://user-images.githubusercontent.com/94172076/179853039-362efaa3-30b9-4390-923a-fb9c03f0b424.png)

- **Registracijos forma**
![register](https://user-images.githubusercontent.com/94172076/179853053-5dbe4324-2f8c-43b0-8034-6a4b0baf8515.png)

- **Pagrindinis**
![Dashboard](https://user-images.githubusercontent.com/94172076/179854261-5dd73a7f-4f07-4cf3-b7c6-e65e883f95ea.PNG)

- **Mėgstamų filmų sąrašas**
![liked](https://user-images.githubusercontent.com/94172076/180277354-5c36735e-4c17-46f9-a27f-033b9894d779.PNG)
