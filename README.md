# Inventory Management System - Core Java

A console-based inventory management application built using Core Java with file persistence.

## Features
- **Add Product**: Add new products with ID, Name, Quantity, Price
- **Update Stock**: Modify existing product quantity
- **Delete Product**: Remove products from inventory
- **Search Product**: Find products by ID
- **Low Stock Alert**: Displays products with quantity < 5
- **Display All**: View complete inventory list
- **File Handling**: Auto-saves data to `inventory.txt`

## Tech Stack
- **Language**: Java 23
- **Concepts**: OOP (Classes, Objects, Encapsulation)
- **Data Structures**: ArrayList for dynamic storage
- **File I/O**: BufferedReader, FileWriter for persistence

## How to Run
1. Clone the repository:
```bash
   git clone https://github.com/teja-1308/Inventory-Management-System-Java.git
      cd Inventory-Management-System-Java
      javac *.java
      java Main
```

## Project Structure
├── Main.java           # Main class with menu-driven interface
├── Product.java           # Product class with getters/setters
├── InventoryManager.java  # Business logic for CRUD operations
└── inventory.txt          # Auto-generated data file
## Author
