#!/bin/bash
# Hotel Management System - Frontend Setup Script
# Run this script to automatically set up the React frontend

echo "========================================"
echo "Hotel Management System - Frontend Setup"
echo "========================================"
echo ""

echo "Checking Node.js installation..."
node --version
if [ $? -ne 0 ]; then
    echo "ERROR: Node.js is not installed. Please install Node.js first."
    echo "Download from: https://nodejs.org/"
    exit 1
fi

echo ""
echo "Node.js found! Proceeding with setup..."
echo ""

cd frontend

if [ ! -d "node_modules" ]; then
    echo "Installing dependencies... This may take a few minutes."
    echo ""
    npm install
    if [ $? -ne 0 ]; then
        echo "ERROR: Failed to install dependencies"
        exit 1
    fi
else
    echo "Dependencies already installed."
fi

echo ""
echo "========================================"
echo "Installation Complete!"
echo "========================================"
echo ""
echo "Frontend will start on: http://localhost:3000"
echo ""
echo "Starting development server..."
echo ""

npm start
