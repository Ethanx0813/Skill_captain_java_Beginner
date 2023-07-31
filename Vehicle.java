package first;

//Vehicle class
class Vehicle {
 private String brand;
 private String model;
 private int year;
 private double rentalPrice;

 public Vehicle(String brand, String model, int year, double rentalPrice) {
     this.brand = brand;
     this.model = model;
     this.year = year;
     this.rentalPrice = rentalPrice;
 }

 public void displayInfo() {
     System.out.println("Brand: " + brand);
     System.out.println("Model: " + model);
     System.out.println("Year: " + year);
     System.out.println("Rental Price: $" + rentalPrice);
 }
}

//Car class (subclass of Vehicle)
class Car extends Vehicle {
 private int numberOfSeats;

 public Car(String brand, String model, int year, double rentalPrice, int numberOfSeats) {
     super(brand, model, year, rentalPrice);
     this.numberOfSeats = numberOfSeats;
 }

 public int getNumberOfSeats() {
     return numberOfSeats;
 }
}

//Motorcycle class (subclass of Vehicle)
class Motorcycle extends Vehicle {
 private int engineCapacity;

 public Motorcycle(String brand, String model, int year, double rentalPrice, int engineCapacity) {
     super(brand, model, year, rentalPrice);
     this.engineCapacity = engineCapacity;
 }

 public int getEngineCapacity() {
     return engineCapacity;
 }
}

//Main class
public static class Main {
 public static void main(String[] args) {
     // Creating instances of Car and Motorcycle
     Car car = new Car("Toyota", "Camry", 2022, 50.5, 5);
     Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2020, 30.0, 1200);

     
     System.out.println("Car Information:");
     car.displayInfo();
     System.out.println("Number of Seats: " + car.getNumberOfSeats());

     System.out.println();

     System.out.println("Motorcycle Information:");
     motorcycle.displayInfo();
     System.out.println("Engine Capacity (cc): " + motorcycle.getEngineCapacity());
 }
}

