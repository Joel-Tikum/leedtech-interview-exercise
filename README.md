# LeedTech LTD Student Fee Payment System

This project implements a one-time fee payment feature with an incentive matching program for LeedTech's Student Management Platform. It consists of a Spring Boot backend and an Angular frontend.

## Project Structure

The project is organized into two main directories within the `LeedTech` folder:

- `one_time_fee_payment_backend` – Java Spring Boot application (backend)
- `one_time_fee_payment_frontend` – Angular application (frontend)

## Prerequisites

Ensure the following tools are installed on your machine:

- **Java 17** or higher
- **Node.js 18** or higher (includes npm)
- **Angular CLI** – Install globally via `npm install -g @angular/cli`
- **Maven** (optional, the project includes a Maven wrapper)
- **Git** (optional, for version control)

## Setup Instructions

### 1. Backend Setup

1. Open a terminal and navigate to the backend folder:

   ```bash
   cd LeedTech/one_time_fee_payment_backend

   ```

2. Build the application using Maven:

   ```bash
   ./mvnw clean install   # on Linux/Mac
   mvnw.cmd clean install # on Windows

   ```

3. Run the Java Spring Boot application using the command:
   ```bash
   ./mvnw spring-boot:run
   ```

### 1. Frontend Setup

1. Open a terminal and navigate to the backend folder:

   ```bash
   cd LeedTech/one_time_fee_payment_frontend

   ```

2. Install the required npm packages:

   ```bash
   npm install

   ```

3. Start the Angular development server:
   ```bash
   ng serve
   The frontend should be available at http://localhost:4200
   ```

## Running the application

- Ensure that the backend and frontend are running simultaneously.
- Open the browser and go to http://localhost:4200
- You will see the `One-Time Fee Payment` form

## Test Data

The backend comes preloaded with two student accounts for testing:

Student Number Initial Balance (XAF)
S12345 800,000
S54321 500,000

Use these student numbers to test successful payments. If you enter any other student number, you will receive a `Student not found` error.
