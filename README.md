# Software Engineering im Studiengang Media Engineering

## Assignment "JUnit Einführung"  

### Grundlagen

#### JUnit

Voraussetzung für Test Driven Development (TDD) sind maschinell ausführbare Tests. 
Für *Java* ist hierfür die Bibliothek *JUnit* verbreitet, die wir in diesem und ggf. weiteren Assignments nutzen werden.

Die Version *JUnit4* besteht aus zwei *JAR*-Dateien, in 
denen bereits kompilierte Java-Klasse enthalten sind. 
Sie finden diese Dateien im Unterverzeichnis *jars*.

Unter Verwendung dieser Pakete kann später ein
sog. Test-Runner gestartet werden, der die
im Projekt enthaltenen Testmethoden ausführt. 
Der normale Einstiegspunkt der *main*-Funktion wird
in diesem Fall nicht verwendet.


#### .replit

In der Umgebung [*repl.it*](https://repl.it/) wird 
in der Datei *.replit* festgelegt, was nach dem
Klick auf den Run-Button passieren soll. Normalerweise
wird dies bei Java-Projekten das Übersetzen der
Quellcode-Dateien mit dem Java-Compiler 
(Kommandozeilenbefehl *javac*) und
anschließend das Ausführen der Klasse mit der *main*-Funktion
(Kommandozeilenbefehl *java*) sein. 
Ein Beispiel für *.replit* ist:

<code>
language = "java"

run = "javac Main.java && java Main"
</code>

Sollen  Tests mit *JUnit4* ausgeführt werden, ergeben sich zwei Änderungen:
- Anstelle der Klasse mit der *main*-Funktion soll jetzt 
  der Test-Runner gestartet werden, der in einer der *JAR*-Dateien enthalten ist
- Die Klassen aus den *JAR*-Dateien müssen in den 
  *Classpath* aufgenommen werden, damit sie beim Programmstart
  geladen werden können

Dies führt zu einer veränderten Datei *.replit*:

<code>
language = "java"

run = "javac Main.java && java -cp .:./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar org.junit.runner.JUnitCore"
</code>

Mit der Option <code>-cp</code> wird der *Classpath* gesetzt,
der jetzt sowohl das aktuelle Verzeichnis 
(repräsentiert duch den Punkt),
als auch die beiden *JAR*-Dateien enthält. 
Die *main*-Funktion wird in der Klasse
<code>org.junit.runner.JUnitCore</code> gesucht,
die in einer der *JAR*-Dateien enthalten ist und den 
Test-Runner enthält.

Sie können das Verhalten des Projekts nach dem 
Klick auf den Run-Button ausprobieren. Es sollte der
Test-Runner starten, der jedoch keine Tests vorfindet
und dies auch entsprechend ausgibt.

### Aufgabenstellung

#### Ausführen der "normalen" *main*-Funktion

Auch wenn es hier um JUnit und den Test-Runner geht,
kann man dennoch den normalen Programmablauf starten -
nur eben nicht mehr über den Run-Button. Versuchen Sie,
das Programm über einen Kommandozeilenbefehl im
Consolefenster von *repl.it* zu starten.

#### Erstellen einer Testklasse

Damit der Test-Runner zukünftig auch Tests findet,
muss mindestens eine Testklasse erstellt werden,
in der dann Testmethoden eingefügt werden. Legen
Sie dazu eine weitere Java-Datei mit dem
Namen <code>MainTest</code> an und implementieren Sie
darin die gleichnamige leere Klasse. Die Klasse
muss <code>public</code> deklariert werden, damit
der Test-Runner auch Zugriff darauf erhält.

Sorgen Sie durch
Anpassungen in der Datei *.replit* dafür, dass auch diese
Klasse compiliert wird.

Erweiteren Sie Ihre Implementierung der Testklasse
um zwei Import-Statements:

<code>
import org.junit.Test;

import static org.junit.Assert.*;
</code>

Damit der Code weiterhin übersetzt werden kann, muss
nun auch beim Aufruf des Java-Compilers *javac* der
*Classpath* so gesetzt werden, dass die *JAR*-Dateien 
berückischtigt werden. Erweitern Sie die Datei *.replit*
entsprechend.


#### Erstellen einer Testmethode

Erst durch Testmethoden wird Ihre Klasse zu einer
Testklasse. Typischerweise enthält eine Testklasse
mehrere Testmethoden, die jeweils einen Aspekt 
einer Anforderung überprüfen. Testmethoden sind stets
<code>public</code>, besitzen keinen Rückgabewert
und auch keine Übergabeparameter. Sie werden 
mit der Annotation <code>@Test</code> als Testmethode
gekennzeichnet.

Ergänzen Sie in Ihrer Testklasse 
eine erste Testmethode:

<code>
@Test

public void testNothing() {}
</code>

Wenn Sie nun den Run-Button betätigen, sollte 
Ihre Testklasse kompiliert und der Test-Runner 
gestartet werden - allerdings werden noch immer
keine Tests ansgeführt.

Um dem Task-Runner mitzuteilen, in welchen
Klassen er nach Testmethoden suchen soll, 
sind diese Klassen beim Aufruf mitzugegeben.
Daher murr die Datei  *.replit* erneut 
angepasst werden:

<code>
language = "java"

run = "javac Main.java && java -cp .:./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MainTest"
</code>

#### Erstellen einer weiteren Testmethode

Es ist nicht sehr erstaunlich, dass der Test-Runner
keine Fehler findet, da in der Testmethode nichts 
getestet wird. Dies soll sich nun mit einer
zweiten Testmethode ändern.

Erstellen Sie eine weitere Testmethode
mit dem Namen <code>testSomeStuff</code>
(die genaue Signatur sollten Sie aus den
bisherigen Ausführungen ableiten können.)

Die eigentlichen Prüfungen werden in der 
Testmethode in Form von Zusicherungen (*Assertions*)
formuliert. Der Test ist fehlerfrei, wenn
alle Zusicherungen der Testmethode eingehalten werden.

*JUnit4* bringt eine Reihe von Funktionen mit, mit denen
Zusicherungen formuliert werden können, z.B.:

- <code>assertEquals</code>
- <code>assertTrue</code>
- <code>assertFalse</code>
- <code>assertNull</code>
- <code>assertNotNull</code>

Eine Dokumentation der Zusicherungsmethoden der
hier verwendeten *JUnit4*-Version finden Sie
[hier](https://junit.org/junit4/javadoc/4.12/org/junit/Assert.html)

Ergänzen Sie jetzt in Ihrer Testmethode Zusicherungen
für folgende Aussagen:

- Das Ergebnis der Addition von 2 und 3 ist 5.
- Das Neuanlegen eines Strings liefert ein Objekt ungleich Null
- 3 * 7 ist größer als 4 * 5

Fügen Sie bei den Zusicherungen eine aussagekräftige 
Meldung hinzu, die vom Test-Runner ausgegeben wird, falls 
die Zusicherung nicht erfüllt wird.







