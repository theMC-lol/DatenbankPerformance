# DatenbankPerformance
Dieses Repository beinhaltet das Asssignment im Fach Datenbanken des 4.Semester an der DHBW Stuttgart.
Die Aufgabe ist es, verschiedene Programmiertechniken zu testen, um herauszufinden, welche Strukturierung
der Abfragen bei einem Versandhändler zur besten Performance führt.
Gruppenmitglieder sind: Tayfun Kan, Alen Arifi, Fritz Bewersdorf und Manuel Klinger

# Abgabe
Die Abgabe dieser Arbeit hat bis zum 24. Mai zu erfolgen. Hierbei ist ein maximal vier Seiten langes Worddukument abzugeben. 
Die Datei dafür ist in Microsoft Teams: Team Fallstudie: Kanal Datenbanken hinterlegt.

# Datenbank aufsetzen
Um die Datenbank aufzusetzen, muss sowohl ein DBMS (z.B. DBeaver) als auch ein Programm zur Socketerstellung (xampp) installiert sein.
Nachdem in xampp das Skript für MySql gestartet wurde, kann der Inhalt der Datei Performance.txt als Skript in DBeaver ausgeführt werden.

# JDBC 
Um von einer Entwicklungsumgebung wie VSC oder Eclipse auf die Datenbank zugreifen zu können, muss die JRE dementsprechend angepasst werden. Für weitere Informationen siehe https://elearning.dhbw-stuttgart.de/moodle/pluginfile.php/232075/mod_resource/content/1/Installation%20und%20Setup.pdf

# Aufgabe 1 - Datenbank aufsetzen
Die Datenbank wurde aufgesetzt. Bei der Programmierung wurde sich minimalisitisch an die Forderungen gehalten, um im Bereich Performance die bestmöglichen Ergebnisse zu erzielen. Das Vorgehen ist in der Word Datei erläutert.

# Aufgabe 2 - Testdaten erstellen
Die Testdaten wurden programmatisch, also durch das Programm (Skript) eingefügt. Der Umfang ist gering, stellt aber einen Querschnitt da und kann deshalb als Basis zur Hochrechnung dienen. Genauere Information sind bereits in der Word Datei.

# Aufgabe 3 - Entwicklung von Testfällen
Diese Aufgabe ist zweigeteilt. Zuert muss sich ingenieurmäßig Fragen überlegt werden, welche sich der Versandhandel überlegen könnte, um ihre Produktvorschläge zu verbessern. Die Abfragen sollten sich auf die Tabelle history in der Datenbank beziehen. Eine Anzahl zwischen 3 und 5 sollten hierbei genügen. Beispiel sind in der Aufgabenstellung enthalten, solten allerdings ergänzt/ erweitert werden. 

Die Laufzeiten sollen bezogen auf drei verschiedene Ansätze getestet werden. 
  - Programmatisch: SQL-Abfragen, die im Java Code enthalten sind.
  - Index: Das Vergeben von Index Variablen zum schnelleren ansteuern von gesuchten Werten. Siehe Skript 06 Klein_DB
  - Stored Procedures: Die verwendeten Abfragen werden nicht in JAVA mit SQL Syntax geschrieben, sondern im Skript der Datenbank, um daraufhin lediglich aus Java heraus aufgerufen zu werden. Siehe Skript 04 Klein_DB
  
 Da sich die beiden letzten Szenarien nicht gegenseitig ausschließen, ist auch der Test an einer Kombination dieser beiden Varianten durchzuführen. 
 
# Datenerhebung
Die Daten die erhoben werden sollen, sind die Durchlaufzeiten der verschiedenen Testszenarien. Der Wert ist die Differenz zwischen der Endzeit und der Startzeit. Diese Funktion ist bereits in Java hinterlegt. Da die Performance auch von der Gesamtauslasung des Computers abhängt, sollten folgende Vorkehrung getroffen worden sein:
  - Alle Programme schließen, die nicht zur Aufgabe gehören.
  - Alle Tests sind durch dieselbe Maschine durchzuführen.
  - Alle Ergebnisse sind zu dokumentieren und zu berücksichtigen. Starke Ausreißer können trotzdem rausgestrichen werden.
  - Alle Variationen einer Abfrage müssen vorher programmiert sein und dasselbe Ergebnis liefern.
  - Verschiedene Abfragen können unabhängig voneinenader durchgeführt werden, da die Ergebnisse eine Referenz auf die anderen Variationen darstellen sollen, und nicht auf die anderen Abfragen.
  
# Implementation
Die Implementation findet in der Klasse DatabaseService statt. Jede Variation bekommt eine eigene Funktion und sollte so schlank wie möglich programmiert werden. Alle möglicherweise benötigten Objekte (für Listen) sind bereits als Klasse in Java hinterlegt. Der Aufruf findet dann immer in der Main-Klasse statt. (zwischen den beiden Zeitstempeln)

# Aufgabe 4 - Auswertung
Die erhobenen Daten werden ausgewertet und mit Daten aus der Literatur verglichen. Also ob die Literatur unsere Ergebnisse wiederspiegelt. Unter Berücksichtigung der Vor- und Nachteile, welche die einzelnen Variationen mit sich bringen, wird für unseren Kunden eine Handlungsempfehlung ausgepsprochen. Es besteht die Möglichkeit, dass diese eine hybride Form ist.

# Docker - Anbindung
Das gesamte Projekt soll über Docker realisiert werden, sodass kein Xampp verwendet werden muss. 
Die Laufzeitmessung erhält man dann in dem man sich über das Terminal in den Projektordner einwählt und die Docker-Container mithilfe des Befehls --> (docker-compose up --build) erstellt. Im Docker Dashboard sieht man anschließend Container die gestartet werden. Direkt nach der Container-Erstellung kann man sich die Laufzeitmessungen im Terminal, ansehen. Die Art des Programmieransatzes bzw. die Kombination lässt sich aus der Klammer direkt nach der Abfrage herauslesen. 
