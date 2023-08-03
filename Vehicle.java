package first;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayDetails();
}

class Car extends Vehicle {
    private int numDoors;
    private String fuelType;

    public Car(String make, String model, int year, double price, int numDoors, String fuelType) {
        super(make, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double calculateMileage() {
        
        return 0;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Price: $" + getPrice());
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Mileage: " + calculateMileage());
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private int engineCapacity;

    public Motorcycle(String make, String model, int year, double price, boolean hasSidecar, int engineCapacity) {
        super(make, model, year, price);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public double calculateSpeed() {
        
        return 0;
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Price: $" + getPrice());
        System.out.println("Has Sidecar: " + hasSidecar);
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("Top Speed: " + calculateSpeed() + " mph");
    }

	public void setYear(int newYear) {
	
		
	}
}

public class Main {
    private static List<Vehicle> vehicleInventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("===== Vehicle Inventory System =====");
            System.out.println("1. Add a Vehicle");
            System.out.println("2. Display all Vehicles");
            System.out.println("3. Search for a Vehicle");
            System.out.println("4. Update Vehicle Details");
            System.out.println("5. Remove a Vehicle");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); /

            switch (choice) {
                case 1:
                    addVehicle(scanner);
                    break;
                case 2:
                    displayAllVehicles();
                    break;
                case 3:
                    searchVehicle(scanner);
                    break;
                case 4:
                    updateVehicleDetails(scanner);
                    break;
                case 5:
                    removeVehicle(scanner);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addVehicle(Scanner scanner) {
        System.out.println("===== Add a Vehicle =====");
        System.out.print("Enter vehicle type (Car/Motorcycle): ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        if (vehicleType.equalsIgnoreCase("Car")) {
            System.out.print("Enter number of doors: ");
            int numDoors = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter fuel type: ");
            String fuelType = scanner.nextLine();

            Car car = new Car(make, model, year, price, numDoors, fuelType);
            vehicleInventory.add(car);
        } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            System.out.print("Does it have a sidecar? (true/false): ");
            boolean hasSidecar = scanner.nextBoolean();
            System.out.print("Enter engine capacity (cc): ");
            int engineCapacity = scanner.nextInt();

            Motorcycle motorcycle = new Motorcycle(make, model, year, price, hasSidecar, engineCapacity);
            vehicleInventory.add(motorcycle);
        } else {
            System.out.println("Invalid vehicle type. Please try again.");
        }

        System.out.println("Vehicle added to the inventory.");
    }

    private static void displayAllVehicles() {
        System.out.println("===== All Vehicles in Inventory =====");
        if (vehicleInventory.isEmpty()) {
            System.out.println("No vehicles in the inventory.");
        } else {
            for (Vehicle vehicle : vehicleInventory) {
                vehicle.displayDetails();
                System.out.println("--------------------");
            }
        }
    }

    private static void searchVehicle(Scanner scanner) {
        System.out.println("===== Search for a Vehicle =====");
        System.out.println("1. Search by Make");
        System.out.println("2. Search by Model");
        System.out.println("3. Search by Price Range");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (searchChoice) {
            case 1:
                searchByMake(scanner);
                break;
            case 2:
                searchByModel(scanner);
                break;
            case 3:
                searchByPriceRange(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void searchByMake(Scanner scanner) {
        System.out.print("Enter the make to search for: ");
        String make = scanner.nextLine();

        List<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicleInventory) {
            if (vehicle.getMake().equalsIgnoreCase(make)) {
                searchResults.add(vehicle);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No vehicles found with the specified make.");
        } else {
            System.out.println("===== Search Results =====");
            for (Vehicle vehicle : searchResults) {
                vehicle.displayDetails();
                System.out.println("--------------------");
            }
        }
    }

    private static void searchByModel(Scanner scanner) {
        System.out.print("Enter the model to search for: ");
        String model = scanner.nextLine();

        List<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicleInventory) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                searchResults.add(vehicle);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No vehicles found with the specified model.");
        } else {
            System.out.println("===== Search Results =====");
            for (Vehicle vehicle : searchResults) {
                vehicle.displayDetails();
                System.out.println("--------------------");
            }
        }
    }

    private static void searchByPriceRange(Scanner scanner) {
        System.out.print("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter the maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine(); 

        List<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicleInventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                searchResults.add(vehicle);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No vehicles found within the specified price range.");
        } else {
            System.out.println("===== Search Results =====");
            for (Vehicle vehicle : searchResults) {
                vehicle.displayDetails();
                System.out.println("--------------------");
            }
        }
    }

    private static void updateVehicleDetails(Scanner scanner) {
        System.out.println("===== Update Vehicle Details =====");
        System.out.print("Enter the make of the vehicle to update: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the vehicle to update: ");
        String model = scanner.nextLine();

        Vehicle foundVehicle = null;
        for (Vehicle vehicle : vehicleInventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                foundVehicle = vehicle;
                break;
            }
        }

        if (foundVehicle == null) {
            System.out.println("Vehicle not found in the inventory.");
        } else {
            System.out.println("Current details of the vehicle:");
            foundVehicle.displayDetails();

            System.out.print("Enter new year: ");
            int newYear = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine(); 

            if (foundVehicle instanceof Car) {
                Car car = (Car) foundVehicle;
                System.out.print("Enter new number of doors: ");
                int newNumDoors = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter new fuel type: ");
                String newFuelType = scanner.nextLine();

                car.setYear(newYear);
                car.setPrice(newPrice);
                car.setNumDoors(newNumDoors);
                car.setFuelType(newFuelType);

                System.out.println("Car details updated successfully.");
            } else if (foundVehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) foundVehicle;
                System.out.print("Does it have a sidecar? (true/false): ");
                boolean newHasSidecar = scanner.nextBoolean();
                System.out.print("Enter new engine capacity (cc): ");
                int newEngineCapacity = scanner.nextInt();

                motorcycle.setYear(newYear);
                motorcycle.setPrice(newPrice);
                motorcycle.setHasSidecar(newHasSidecar);
                motorcycle.setEngineCapacity(newEngineCapacity);

                System.out.println("Motorcycle details updated successfully.");
            }
        }
    }

    private static void removeVehicle(Scanner scanner) {
        System.out.println("===== Remove a Vehicle =====");
        System.out.print("Enter the make of the vehicle to remove: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the vehicle to remove: ");
        String model = scanner.nextLine();

        boolean removed = vehicleInventory.removeIf(vehicle -> vehicle.getMake().equalsIgnoreCase(make)
                && vehicle.getModel().equalsIgnoreCase(model));

        if (removed) {
            System.out.println("Vehicle removed from the inventory.");
        } else {
            System.out.println("Vehicle not found in the inventory.");
        }
    }
}
