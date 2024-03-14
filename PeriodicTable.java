/** 
 * @Author: Jakob Tak
 * @Date: 14.03.2024
 * @Class: CS&145
 * @Assignment: Assignment3
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The PeriodicTable class represents the periodic table of chemical elements.
 * It provides methods to load elements from a CSV file and retrieve elements by atomic number, name, or symbol.
 */
public class PeriodicTable {
    private String CSV_FILE = "PeriodicTableCSV.csv";

    private List<Element> elements;
    private Map<Integer, Element> elementsByAtomicNumber;
    private Map<String, Element> elementsByName;
    private Map<String, Element> elementsBySymbol;

    /**
     * Constructs a new PeriodicTable object and loads elements from the CSV file.
     */
    public PeriodicTable() {
        elements = new ArrayList<>();
        elementsByAtomicNumber = new HashMap<>();
        elementsByName = new HashMap<>();
        elementsBySymbol = new HashMap<>();
        loadElementsFromCSV();
    }

    /**
     * Loads elements from the CSV file into memory.
     */
    private void loadElementsFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                Element element = parseElement(line);
                if (element != null) {
                    elements.add(element);
                    elementsByAtomicNumber.put(element.getAtomicNumber(), element);
                    elementsByName.put(element.getName(), element);
                    elementsBySymbol.put(element.getSymbol(), element);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses a CSV line to create an Element object.
     * @param line The CSV line representing an element.
     * @return The Element object parsed from the CSV line.
     */
    private Element parseElement(String line) {
        String[] data = line.split(",", -1); // ArrayIndexOutOfBoundException
        try {
            String name = data[0];
            double atomicMass = Double.parseDouble(data[1]);
            String category = data[2];
            int number = Integer.parseInt(data[3]);
            int period = Integer.parseInt(data[4]);
            int group = Integer.parseInt(data[5]);
            String symbol = data[6];
            String electronConfigurationSemantic = data[7];
            Double electronAffinity = data[8].isEmpty() ? null : Double.parseDouble(data[8]);
            Double electronegativity = data[9].isEmpty() ? null : Double.parseDouble(data[9]);
            Double atomicRadius = data[10].isEmpty() ? null : Double.parseDouble(data[9]);
            Double meltingPoint = data[11].isEmpty() ? null : Double.parseDouble(data[8]);
            Double boilingPoint = data[12].isEmpty() ? null : Double.parseDouble(data[9]);
            return new Element(name, atomicMass, category, number, period, group, symbol,
                    electronConfigurationSemantic, electronAffinity, electronegativity, atomicRadius, meltingPoint,
                    boilingPoint);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Handle parsing errors or missing data
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves a list of all elements in the periodic table.
     * @return A list of all elements in the periodic table.
     */
    public List<Element> getAllElements() {
        return elements;
    }

    /**
     * Retrieves an element from the periodic table by its atomic number.
     * @param atomicNumber The atomic number of the element to retrieve.
     * @return The element with the specified atomic number, or null if not found.
     */
    public Element getElementByAtomicNumber(int atomicNumber) {
        try {
            return elementsByAtomicNumber.get(atomicNumber);
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Given element is not found.");
            return null;
        }
    }

    /**
     * Retrieves an element from the periodic table by its name.
     * @param name The name of the element to retrieve.
     * @return The element with the specified name, or null if not found.
     */
    public Element getElementByName(String name) {
        try {
            return elementsByName.get(name);
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Given element is not found.");
            return null;
        }
    }

    /**
     * Retrieves an element from the periodic table by its symbol.
     * @param symbol The symbol of the element to retrieve.
     * @return The element with the specified symbol, or null if not found.
     */
    public Element getElementBySymbol(String symbol) {
        try {
            return elementsBySymbol.get(symbol);
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Given element is not found.");
            return null;
        }
    }

    /**
     * Displays the periodic table in the console.
     */
    public void display() {
        // Create a 2D array to represent the periodic table grid
        Element[][] grid = new Element[7][18]; // Main body of the periodic table

        // Populate the grid with elements
        for (Element element : getAllElements()) {
            int period = element.getPeriod() - 1; // Period starts from 1, array index starts from 0
            int group = element.getGroup() - 1; // Group starts from 1, array index starts from 0

            // For elements in the main body of the periodic table
            if (period < 7 && group < 18) {
                grid[period][group] = element;
            }
        }

        // Display the periodic table
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Element element = grid[row][col];
                if (element != null) {
                    System.out.print(String.format("%-3s ", element.getSymbol()));
                } else {
                    System.out.print("    "); // Empty cell
                }
            }
            System.out.println(); // Move to the next row
        }

        // Display lanthanides
        System.out.printf("\n%8s%-13s", "", "Lanthanides");
        for (Element element : getAllElements()) {
            if (element.getPeriod() == 6 && element.getGroup() >= 4 && element.getGroup() <= 13) {
                System.out.print(String.format("%-3s ", element.getSymbol()));
            }
        }

        // Display actinides
        System.out.printf("\n%8s%-13s", "", "Actinides");
        for (Element element : getAllElements()) {
            if (element.getPeriod() == 7 && element.getGroup() >= 4 && element.getGroup() <= 13) {
                System.out.print(String.format("%-3s ", element.getSymbol()));
            }
        }
    }
}
