-- SQL Script to create the database and table structure
-- Run this script in MySQL to set up the database for the Hotel Management System

-- Create Database
CREATE DATABASE IF NOT EXISTS fsadendexam;

-- Use the database
USE fsadendexam;

-- Drop existing table if it exists
DROP TABLE IF EXISTS hotels;

-- Create hotels table
CREATE TABLE hotels (
    hotel_id VARCHAR(50) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    status VARCHAR(50) DEFAULT 'ACTIVE',
    location VARCHAR(255),
    rating DECIMAL(3,1),
    contact_number VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert sample data (optional)
INSERT INTO hotels (hotel_id, name, date, status, location, rating, contact_number) VALUES
('H001', 'The Ritz Carlton', '2024-05-02', 'ACTIVE', 'New York', 5.0, '2125551234'),
('H002', 'Taj Mahal Palace', '2024-05-02', 'ACTIVE', 'Mumbai', 4.9, '9876543210'),
('H003', 'Burj Al Arab', '2024-05-02', 'MAINTENANCE', 'Dubai', 4.8, '9876543211'),
('H004', 'Marina Bay Sands', '2024-05-02', 'ACTIVE', 'Singapore', 4.7, '9876543212'),
('H005', 'Mandarin Oriental', '2024-05-02', 'INACTIVE', 'Bangkok', 4.6, '9876543213');

-- Display the table structure
DESCRIBE hotels;

-- Display all data in the table
SELECT * FROM hotels;
