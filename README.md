# Java Banking System

A console-based banking system developed using Core Java and Object-Oriented Programming concepts.

## Technologies

- Java
- OOP
- Collections
- Generics
- Exception Handling
- Serialization / Deserialization
- Streams
- Lambda Expressions
- Multithreading
- ExecutorService
- Synchronization
- ConcurrentHashMap

## Features

- Savings Account
- Gold Account
- Salary Account
- Current Account
- Account creation and closure
- Deposit
- Withdrawal
- Transfer
- Overdraft handling
- Custom exception handling
- Month-end processing
- File-based persistence
- Concurrent banking operations

## Java Concepts Demonstrated

### Object-Oriented Programming

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces

### Collections and Generics

- ArrayList
- ConcurrentHashMap
- Generic account filtering
- Java Streams
- Lambda Expressions

### Persistence

Bank data is persisted using Java Serialization and restored using Deserialization.

### Concurrency

The project demonstrates:

- Runnable
- Threads
- ExecutorService
- synchronized methods
- ConcurrentHashMap
- Concurrent deposit and withdrawal operations
- Shared account state protection

## Example Account Types


BankAccount
├── SavingsAccount
├── GoldAccount
├── SalaryAccount
└── CurrentAccount


Compile:

```bash
javac *.java


run:
java Bank
