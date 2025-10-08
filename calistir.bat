@echo off
chcp 65001 > nul
echo [*] Ozgecmis olusturuluyor...

javac -encoding UTF-8 -cp "itextpdf-5.5.13.3.jar;." ResumeGenerator.java
if %errorlevel% neq 0 (
    echo Derleme hatasi!
    pause
    exit /b
)

java -cp "itextpdf-5.5.13.3.jar;." ResumeGenerator

echo.
echo [*] Ozgecmis.pdf olusturuldu!
pause
