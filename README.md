# allgeier-maven-selenide

GUI-Automatisierungsprojekt mit Selenide gegen die Login-Funktion von `https://the-internet.herokuapp.com`.

## Zweck im Assessment

Dieses Repository dient **P02 - GUI-Automatisierung** und zeigt, wie Kandidaten UI-Tests mit einer kompakten Selenium-Abstraktion analysieren, debuggen und erweitern.

## Technischer Stack

| Komponente | Version |
|---|---|
| Selenide | 7.16.2 |
| JUnit Jupiter | 6.1.0 |
| Java | 25 |
| Maven | 3.9+ |
| Reporting | Maven Surefire |

## Zielsystem

**URL:** https://the-internet.herokuapp.com

The Internet ist ein öffentliches, bewusst für UI-Automatisierung bereitgestelltes Testziel.

## Voraussetzungen

- JDK 25+
- Maven 3.9+
- Google Chrome
- Internetzugang

## Ausführen

```bash
mvn clean verify
```

Die Ziel-URL und Zugangsdaten liegen in `src/test/resources/config.properties`.

## Reports

Surefire-Ergebnisse liegen nach dem Lauf unter:

```text
target/surefire-reports/
```

## Projektstruktur

```text
src/test/java/ch/allgeier/maven/selenide/pages/   Selenide Page Objects
src/test/java/ch/allgeier/maven/selenide/tests/   JUnit-Tests
src/test/resources/                               Testkonfiguration
pom.xml                                           Maven-Konfiguration
```

## Hinweise für das Assessment

Das Projekt enthält bewusst eingebaute Fehler. Kandidaten sollen das Fehlerbild analysieren, die Ursache finden und eine fachlich passende Korrektur umsetzen. Die Auflösung steht nicht in dieser README.
