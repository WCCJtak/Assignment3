/** 
 * @Author: Jakob Tak
 * @Date: 14.03.2024
 * @Class: CS&145
 * @Assignment: Assignment3
 */

/**
 * The Element class represents a chemical element with various properties.
 */
public class Element {
    private String name;
    private double atomicMass;
    private String category;
    private int atomicNumber;
    private int period;
    private int group;
    private String symbol;
    private String electronConfigurationSemantic;
    private Double electronAffinity; // Nullable
    private Double electronegativity; // Nullable
    private Double atomicRadius; // Nullable
    private Double meltingPoint; // Nullable
    private Double boilingPoint; // Nullable

    /**
     * Constructs a new Element object with the specified properties.
     * @param name The name of the element.
     * @param atomicMass The atomic mass of the element.
     * @param category The category of the element.
     * @param atomicNumber The atomic number of the element.
     * @param period The period of the element.
     * @param group The group of the element.
     * @param symbol The symbol of the element.
     * @param electronConfigurationSemantic The electron configuration of the element.
     * @param electronAffinity The electron affinity of the element.
     * @param electronegativity The electronegativity of the element.
     * @param atomicRadius The atomic radius of the element.
     * @param meltingPoint The melting point of the element.
     * @param boilingPoint The boiling point of the element.
     */
    public Element(String name, double atomicMass, String category, int atomicNumber, int period, int group,
            String symbol, String electronConfigurationSemantic, Double electronAffinity, Double electronegativity,
            Double atomicRadius, Double meltingPoint, Double boilingPoint) {
        this.name = name;
        this.atomicMass = atomicMass;
        this.category = category;
        this.atomicNumber = atomicNumber;
        this.period = period;
        this.group = group;
        this.symbol = symbol;
        this.electronConfigurationSemantic = electronConfigurationSemantic;
        this.electronAffinity = electronAffinity;
        this.electronegativity = electronegativity;
        this.atomicRadius = atomicRadius;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
    }

    /**
     * Gets the name of the element.
     * @return The name of the element.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the atomic mass of the element.
     * @return The atomic mass of the element.
     */
    public double getAtomicMass() {
        return atomicMass;
    }

    /**
     * Gets the category of the element.
     * @return The category of the element.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the atomic number of the element.
     * @return The atomic number of the element.
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }

    /**
     * Gets the period of the element.
     * @return The period of the element.
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Gets the group of the element.
     * @return The group of the element.
     */
    public int getGroup() {
        return group;
    }

    /**
     * Gets the symbol of the element.
     * @return The symbol of the element.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets the electron configuration of the element.
     * @return The electron configuration of the element.
     */
    public String getElectronConfigurationSemantic() {
        return electronConfigurationSemantic;
    }

    /**
     * Gets the electron affinity of the element.
     * @return The electron affinity of the element.
     */
    public Double getElectronAffinity() {
        return electronAffinity;
    }

    /**
     * Gets the electronegativity of the element.
     * @return The electronegativity of the element.
     */
    public Double getElectronegativity() {
        return electronegativity;
    }

    /**
     * Gets the atomic radius of the element.
     * @return The atomic radius of the element.
     */
    public Double getAtomicRadius() {
        return atomicRadius;
    }

    /**
     * Gets the melting point of the element.
     * @return The melting point of the element.
     */
    public Double getMeltingPoint() {
        return meltingPoint;
    }

    /**
     * Gets the boiling point of the element.
     * @return The boiling point of the element.
     */
    public Double getBoilingPoint() {
        return boilingPoint;
    }

    /**
     * Returns a JSON-formatted string representation of the element.
     * @return A JSON-formatted string representation of the element.
     */
    @Override
    public String toString() {
        return "{\n" + "\t\"name\": \"" + name + "\",\n" + "\t\"atomicMass\": " + atomicMass + ",\n"
                + "\t\"category\": \"" + category + "\",\n" + "\t\"atomicNumber\": " + atomicNumber + ",\n"
                + "\t\"period\": " + period + ",\n" + "\t\"group\": " + group + ",\n" + "\t\"symbol\": \"" + symbol
                + "\",\n" + "\t\"electronConfigurationSemantic\": \"" + electronConfigurationSemantic + "\",\n"
                + "\t\"electronAffinity\": " + electronAffinity + ",\n" + "\t\"electronegativity\": "
                + electronegativity + "\n" + "}";
    }

    /**
     * Returns a formatted string representation of the element's properties.
     * @return A formatted string representation of the element's properties.
     */
    public String toTable() {
        return String.format(
                "+---------------------------------------------+\n"
                + "|%-45s|\n"
                + "+---------------------------------------------+\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "|%-25s%20s|\n"
                + "+---------------------------------------------+\n",
                name, 
                "AtomicMass", atomicMass, 
                "Category", category, 
                "Atomic Number", atomicNumber, 
                "Period", period,
                "Group", group, 
                "Symbol", symbol, 
                "ElectronConfiguration", electronConfigurationSemantic,
                "ElectronAffinity", electronAffinity, 
                "Electronegativity", electronegativity);
    }

}
