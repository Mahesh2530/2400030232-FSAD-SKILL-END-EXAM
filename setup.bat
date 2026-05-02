@echo off
REM Hotel Management System - Frontend Setup Script
REM Run this script to automatically set up the React frontend

echo ========================================
echo Hotel Management System - Frontend Setup
echo ========================================
echo.

echo Checking Node.js installation...
node --version
if errorlevel 1 (
    echo ERROR: Node.js is not installed. Please install Node.js first.
    echo Download from: https://nodejs.org/
    pause
    exit /b 1
)

echo.
echo Node.js found! Proceeding with setup...
echo.

cd frontend

if not exist "node_modules" (
    echo Installing dependencies... This may take a few minutes.
    echo.
    call npm install
    if errorlevel 1 (
        echo ERROR: Failed to install dependencies
        pause
        exit /b 1
    )
) else (
    echo Dependencies already installed.
)

echo.
echo ========================================
echo Installation Complete!
echo ========================================
echo.
echo Frontend will start on: http://localhost:3000
echo.
echo Starting development server...
echo.

call npm start

pause
