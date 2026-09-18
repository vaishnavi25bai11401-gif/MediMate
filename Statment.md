# MediMate – Smart Medicine Reminder & Family Health Tracker

## Problem Statement

Managing medicines for multiple family members can be difficult when different people have different medicines, dosages, timings, and stock levels. Manual tracking can lead to confusion, missed medicines, and difficulty knowing when medicine stock is low.

MediMate provides a simple digital solution to organize family member and medicine information and track medicine usage.

## Scope of the Project

MediMate focuses on basic family medicine management. The system allows users to add family members, assign medicines to them, track medicine details and stock, mark medicines as taken or missed, and view medicine history.

The current version stores data temporarily using Java `ArrayList` and does not require a database.

## Target Users

- Individuals managing their own medicines
- Family members managing medicines for elderly family members
- Users who need a simple way to track medicine usage and stock

## High-Level Features

- Add and manage family members
- Add medicines for specific family members
- Store medicine name, dosage, timing, and stock
- Mark medicines as **Taken** or **Missed**
- Automatically reduce stock when medicine is taken
- Display low-stock alerts
- View medicine history
- Simple Java Swing graphical interface

## Technology Used

- Java
- Java Swing
- ArrayList
- LocalDateTime
- GitHub

## Project Type

Java Desktop Application

## GitHub structure:
MediMate/
├── README.md
├── statement.md
├── Main.java
├── model/ 
        ├──FamilyMember
        ├──Medicine
        ├──MedicineRecord
├── service/
        ├──FamilyServices
        ├──MedicineService
└── gui/
        ├──Dashboard