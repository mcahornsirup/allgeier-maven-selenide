# Assessment-Lösung: allgeier-maven-selenide

> **ACHTUNG:** Diese Datei ist ausschliesslich für Prüfer bestimmt und darf nicht an Kandidaten weitergegeben werden.

## Eingebaute Fehler

### Bug 1 – Fehlerhafter Selektor im Page Object

**Datei:** `src/test/java/ch/allgeier/maven/selenide/pages/LoginPage.java`
**Code:** `private final SelenideElement flashMessage = $("#flash-container");`

**Fehlerbild:**
Beide Tests schlagen mit einem Selenide-Timeout fehl, da das Element `#flash-container` nicht existiert:
```
com.codeborne.selenide.ex.ElementNotFound: Element not found {#flash-container}
```

**Ursache:** Die tatsächliche ID des Flash-Elements lautet `flash`, nicht `flash-container`.

**Korrektur:** `$("#flash-container")` → `$("#flash")`

**Erwartetes Verhalten nach Korrektur:** `testSuccessfulLogin` besteht; `testInvalidLogin` schlägt wegen Bug 2 weiter fehl.

---

### Bug 2 – Falsche erwartete Zeichenkette in Assertion

**Datei:** `src/test/java/ch/allgeier/maven/selenide/tests/LoginTest.java`
**Code:** `assertTrue(flash.contains("Invalid credentials"), ...)`

**Fehlerbild:**
```
AssertionError: Flash-Nachricht soll Fehlermeldung enthalten, war: Your username is invalid! ×
expected: <true> but was: <false>
```

**Ursache:** Die tatsächliche Fehlermeldung lautet "Your username is invalid!", nicht "Invalid credentials".

**Korrektur:** `flash.contains("Invalid credentials")` → `flash.contains("Your username is invalid!")`

**Erwartetes Verhalten nach Korrektur:** Beide Tests bestehen.
