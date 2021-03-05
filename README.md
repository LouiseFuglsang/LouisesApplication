# LouisesApplication

### Android projekt - Clean architecture demo

1. Lav en tom Android-app (benyt eksempelvis Empty Activity template).
<br>

2. Tilføj et TextView og et EditText på skærmen sammen med en Button.
Når knappen aktiveres skal labelen (TextView) opdateres med indholdet fra tekstfeltet (EditText).
<br>

3. Separer dataopbevaring ud af View så den opbevares og vedligeholdes i en separat Model-klasse. 
Placer modelklassen i sin egen "model"-package. Klassen kan eksempelvis hedde "Model".
Placer samtidigt View-klassen i sin egen "view"-package. Klassen kan eksempelvis hedde "AndroidView" (men kan også blot forblive navngivet som "MainActivity").
<br>

4. Implementer Observable-funktionalitet for Model-klassen,
så labelen først bliver opdateret når Model-klassen signalerer at der er sket en ændring,
dvs. som det sidste i Model-klassens set-metode.<br><br>
Anvend eksempelvis java.util.Observer og java.util.Observable til at realisere Observer-mønstret. 
(Vi ser stort på at de er blevet deprecated i Java 9.)<br>
Sørg for at der ikke er afhængighed fra Model-klassen til View-klassen, 
dvs. at den ikke må have direkte kendskab til View-klassen. 
(Den må kun kende View-klassen som en Observer.)
<br>

5. Tilpas View-klassen til at præsentere transformeret data i View'et. 
Den nye funktionalitet skal som udgangspunkt wrappe Model-klassen
og kan eksempelvis sættes til at præsentere modellens data i ren lower case.<br><br>
androidx.lifecycle.MutableLiveData kan evt. anvendes
til at facilitere nem Observer-funktionalitet i View-klassen.<br><br>
Sørg for at der stadig ikke er afhængighed fra Model-klassen til View-klassen.
<br>

6. Opret en selvstændig ViewModel-klasse til at præsentere transformeret data til View'et. 
Den konkrete ViewModel-klasse skal som udgangspunkt wrappe Model-klassen 
og kan eksempelvis sættes til at præsentere modellens data i ren lower case. 
I givet fald kan ViewModel-klassen navngives "LowerCasePresenter".
ViewModel-klassen placeres i "view"-package.<br><br>
Bemærk at ViewModel teknisk set hører til i 3. inderste ring af vores Clean Architecture. 
(Fordi den er en Presenter.)
Dvs. at ViewModel ikke bør være afhængig af et specifikt UI-framework (som fx Android). 
Det er derfor nødvendigt at lave en anden Observable-funktionalitet end den som blev benyttet i pkt. 5.<br><br>
Sørg for at der ikke er afhængighed fra ViewModel-klassen til View-klassen 
og at der heller ikke er afhængighed fra Model-klassen til ViewModel-klassen.
<br>

7. Persister data i en database, der ikke er Firebase,
benyt eksempelvis SQLite. 
Sørg for at placere databasekoden i en separat "persistence"-package. 
Sørg for at afhængighederne overholder guidelines for Clean Architecture, 
dvs. at Model ikke må være afhængig af noget i "persistence"-package.<br><br>
Hint: Det er nødvendigt at anvende Observer-mønstret
for at opdage når der er ændringer i Model.<br><br>
Næste gang programmet startes skal det vise den tekst der var gældende da programmet blev lukket.
<br>

8. Skift databasen ud med Firebase. 
Det bør kunne gøres uden at ændre i "model" og "view". 
Separer de to database-anvendelser i separate subpackages til "persistence", 
eksempelvis "sqlite" og "firebase".<br><br>
Når flere personer anvender samme app samtidigt bør teksten opdateres simultant på samtlige devices.
<br>

9. Lav et JavaFX-projekt med samme funktionalitet som Android-app'en. 
Placer Android-View'et i en separat "view.android"-subpackage.
Det bør være muligt at genanvende alt i projektet undtagen "view.android"-pakken. 
Placer det JavaFX-View i en separat "view.javafx"-subpackage.<br><br>
Brugsoplevelsen bør være lige som beskrevet i punkt 7.
<br>

10. Lav en sidste ViewModel-klasse som skal præsentere modellens data uden transformation, 
den kan eksempelvis navngives "TrueCasePresenter" 
og placeres ligeledes i "view"-package.<br><br>
Benyt den nye ViewModel-klasse i JavaFX-app'en, men ikke i Android-app'en. 
Brug opsætningen til at teste at de to ViewModels præsenterer transformerede data
uden at påvirke den underliggende model.
