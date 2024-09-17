# Low Level Design / Machine Coding: JIRA / Ticketing System

This repository contains the low-level design (LLD) implementation of a simplified JIRA-like ticketing system. It demonstrates key principles of object-oriented design and programming, including design patterns and best practices in Java.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Design Patterns](#design-patterns)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

LLD_JIRA is a simple implementation of a ticketing system similar to JIRA. It allows users to create, update, and manage tickets. This project showcases how a real-world ticketing system can be designed at a low level using core object-oriented principles and some of the most common design patterns like Singleton and State.

## Features

- Create, update, and delete tickets.
- Manage ticket statuses (e.g., InProgress, Review, Done).
- Basic user authentication and role management.
- Notifications system.
- State transition handling.

## Technologies Used

- **Java**: Core language used for the project.
- **Maven**: Build and dependency management.
- **JUnit**: Unit testing framework.
- **Design Patterns**: Implementation of common design patterns.

## Design Patterns

### Singleton
- Ensures that only one instance of certain classes (e.g., `InProgress`, `Review`, `Done`) exists throughout the application. It optimizes memory usage and object management.

### State
- Used to manage the state transitions of tickets (e.g., transitioning between `InProgress`, `Review`, and `Done`).

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/FazeelUsmani/LLD_JIRA.git
   ```

2. Navigate to the project directory:
    ```bash
    cd LLD_JIRA
    ```

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

4. Run the project:
    ```bash
    mvn exec:java
    ```

