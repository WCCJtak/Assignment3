/** 
 * @Author: Jakob Tak
 * @Date: 14.03.2024
 * @Class: CS&145
 * @Assignment: Assignment3
 */

/**
 * The ChemistryTools class provides static methods for various chemistry calculations.
 */
public class ChemistryTools {

    /**
     * Calculates the molarity of a solution.
     * @param molesOfSolute The number of moles of solute
     * @param litersOfSolution The volume of the solution in liters
     * @return The molarity of the solution
     */
    public static double getMolarity(double molesOfSolute, double litersOfSolution) {
        return molesOfSolute / litersOfSolution;
    }

    /**
     * Calculates the molality of a solution.
     * @param molesOfSolute The number of moles of solute
     * @param kilogramsOfSolvent The mass of the solvent in kilograms
     * @return The molality of the solution
     */
    public static double getMolality(double molesOfSolute, double kilogramsOfSolvent) {
        return molesOfSolute / kilogramsOfSolvent;
    }

    /**
     * Calculates the normality of a solution.
     * @param equivalentsOfSolute The number of equivalents of solute
     * @param litersOfSolution The volume of the solution in liters
     * @return The normality of the solution
     */
    public static double getNormality(double equivalentsOfSolute, double litersOfSolution) {
        return equivalentsOfSolute / litersOfSolution;
    }

    /**
     * Calculates the partial pressure of a gas.
     * @param moleFraction The mole fraction of the gas
     * @param totalPressure The total pressure of the gas mixture
     * @return The partial pressure of the gas
     */
    public static double getPartialPressure(double moleFraction, double totalPressure) {
        return moleFraction * totalPressure;
    }

    /**
     * Calculates the concentration of a solution.
     * @param massOfSolute The mass of the solute
     * @param volumeOfSolution The volume of the solution in liters
     * @return The concentration of the solution
     */
    public static double getConcentration(double massOfSolute, double volumeOfSolution) {
        return massOfSolute / volumeOfSolution;
    }

    /**
     * Calculates the density of a substance.
     * @param mass The mass of the substance
     * @param volume The volume of the substance
     * @return The density of the substance
     */
    public static double getDensity(double mass, double volume) {
        return mass / volume;
    }

    /**
     * Calculates the number of moles from the given mass and molar mass.
     * @param mass The mass of the substance
     * @param molarMass The molar mass of the substance
     * @return The number of moles
     */
    public static double getMolesFromMass(double mass, double molarMass) {
        return mass / molarMass;
    }

    /**
     * Calculates the mass from the given number of moles and molar mass.
     * @param moles The number of moles of the substance
     * @param molarMass The molar mass of the substance
     * @return The mass of the substance
     */
    public static double getMassFromMoles(double moles, double molarMass) {
        return moles * molarMass;
    }
}
