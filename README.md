Student System ✨
Målet med uppgiften var att designa och utveckla en konsolbaserad applikation för att hantera en student system för en liten skola. Systemet
 hanterar studentuppgifter effektivt och enkelt via ett menybaserat
konsolgränssnitt. Systemet byggt med hjälp av Singleton-mönstret
och lämpliga MVC pattern för att hantera och lagra information.

Projektet utförds med Java i IntelliJIdea.
Projektets funtionalitet
1. Lägg till nya studentposter via menyn.
2. Sök efter en student via deras ID.
3. Visa alla sparade studenter.
4. Spara studentposter till fil.
5. Läs studentposter från fil och visa dem i systemet.
6. Avsluta programmet.

Det finns  i model: class Assessment,class enum Mark,class Student,enum Subject.
Singleton- classer i repo: AssessmentRepo ,StudentRepo 
Singleton- classer i service: AssessmentService,StudentService

Alla data sparas i filer  assessment.txt, student.txt

Programmet använder service, model, repository. Service är en Java-klass som tinnehåller Business Logic, inkapsling av applikationsfunktionalitet.

Att strarta programmet
När projektet oppnas, i projektverktygsfönstret leta upp källan | main | java | Main. java-filen och öppna den i editorn/ IntelliJIdea. I redigeraren klickar du på rännstensikonen för att köra programmet och väljer Kör 'Main'. main()'.
