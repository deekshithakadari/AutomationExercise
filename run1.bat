@echo off
cd /d C:\Users\DELL\eclipse-workspace\AutomationExercise
mvn test -Dsurefire.suiteXmlFiles=testng.xml
pause