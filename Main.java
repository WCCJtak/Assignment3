/** 
 * @Author: Jakob Tak
 * @Date: 14.03.2024
 * @Class: CS&145
 * @Assignment: Assignment3
 */
import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

/**
 * The Main class provides a command-line interface for interacting with the
 * Periodic Table and performing chemical calculations.
 */
public class Main {
    public final static char OPT_VIEW_PERIODIC_TABLE = 'p';
    public final static char OPT_CHEM_HELPER = 'h';
    public final static char OPT_QUIT = 'q';

    public final static char OPT_FIND_ELEMENT_BY_ATOMIC_NUM = 'a';
    public final static char OPT_FIND_ELEMENT_BY_NAME = 'n';
    public final static char OPT_FIND_ELEMENT_BY_SYMBOL = 's';

    public final static char OPT_YES = 'y';
    public final static char OPT_NO = 'n';

    public final static char OPT_USER_INPUT = 'i';
    public final static char OPT_LOAD_VALUE = 'l';
    public final static char OPT_VIEW_VALUES = 'v';

    public final static char OPT_GET_MOLARITY = '1';
    public final static char OPT_GET_MOLALITY = '2';
    public final static char OPT_GET_NORMALITY = '3';
    public final static char OPT_GET_PARTIAL_PRESSURE = '4';
    public final static char OPT_GET_CONCENTRATION = '5';
    public final static char OPT_GET_DENSITY = '6';
    public final static char OPT_GET_MOLES_FROM_MASS = '7';
    public final static char OPT_GET_MASS_FROM_MOLES = '8';

    private static Map<String, String> userValue;

    public static void main(String[] args) {
        PeriodicTable periodicTable = new PeriodicTable();
        Scanner scanner = new Scanner(System.in);
        userValue = new HashMap<String, String>();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println(); // newline
            switch (getOptUserOptions(scanner)) {
            case OPT_VIEW_PERIODIC_TABLE:
                viewPeriodicTable(scanner, periodicTable);
                break;
            case OPT_CHEM_HELPER:
                chemHelper(scanner);
                break;
            case OPT_VIEW_VALUES:
                viewStoredValues();
                break;
            case OPT_QUIT:
                isRunning = false;
                break;
            default:
                System.out.println("Error: Unknown command.");
                break;
            }
        }
    }

    public static char getOptUserOptions(Scanner scanner) {
        System.out.print("what are you looking for?\n");
        System.out.printf("View periodic table (%c)\n", OPT_VIEW_PERIODIC_TABLE);
        System.out.printf("Use Chem Helper (%c)\n", OPT_CHEM_HELPER);
        System.out.printf("To exit (%c)\n", OPT_QUIT);
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    public static char getOptFindElements(Scanner scanner) {
        System.out.print("What Element are you looking for?\n");
        System.out.printf("To find your element by atomic number (%c)\n", OPT_FIND_ELEMENT_BY_ATOMIC_NUM);
        System.out.printf("To find your element by name (%c)\n", OPT_FIND_ELEMENT_BY_NAME);
        System.out.printf("To find your element by symbol (%c)\n", OPT_FIND_ELEMENT_BY_SYMBOL);
        System.out.printf("To exit (%c)\n", OPT_QUIT);
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    public static char getOptStoreValue(Scanner scanner) {
        System.out.printf("Do you want to store a value? (%s/%s)\n", OPT_YES, OPT_NO);
        System.out.printf("If you want to view stored value (%s)\n", OPT_VIEW_VALUES);
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    public static char getChemTool(Scanner scanner) {
        System.out.printf("Get molarity [molesOfSolute / litersOfSolution] (%s)\n", OPT_GET_MOLARITY);
        System.out.printf("Get molality [molesOfSolute / kilogramsOfSolvent] (%s)\n", OPT_GET_MOLALITY);
        System.out.printf("Get normality [equivalentsOfSolute / litersOfSolution] (%s)\n", OPT_GET_NORMALITY);
        System.out.printf("Get partial pressure [moleFraction * totalPressure] (%s)\n", OPT_GET_PARTIAL_PRESSURE);
        System.out.printf("Get concentration [massOfSolute / volumeOfSolution] (%s)\n", OPT_GET_CONCENTRATION);
        System.out.printf("Get density [mass / volume] (%s)\n", OPT_GET_DENSITY);
        System.out.printf("Get moles [mass / molarMass] (%s)\n", OPT_GET_MOLES_FROM_MASS);
        System.out.printf("Get mass [moles * molarMass;] (%s)\n", OPT_GET_MASS_FROM_MOLES);
        System.out.printf("If you want to view stored value (%s)\n", OPT_VIEW_VALUES);
        System.out.printf("If you want to quit (%s)\n", OPT_QUIT);
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    public static char getValueMethod(Scanner scanner) {
        System.out.printf("If you want to view stored value (%s)\n", OPT_VIEW_VALUES);
        System.out.printf("If you want to load from cache (%s)\n", OPT_LOAD_VALUE);
        System.out.printf("If you want to input your own value (%s)\n", OPT_USER_INPUT);
        System.out.printf("If you want to abort the operation (%s)\n", OPT_NO);
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    public static String getUserValue(Scanner scanner) throws AbortedException {
        while (true) {
            System.out.println(); // newline
            switch (getValueMethod(scanner)) {
            case OPT_VIEW_VALUES:
                viewStoredValues();
                break;
            case OPT_LOAD_VALUE:
                viewStoredValues();
                System.out.println("Input name of stored value: ");
                return userValue.get(scanner.nextLine());
            case OPT_USER_INPUT:
                return scanner.nextLine();
            case OPT_NO:
                throw new AbortedException("User aborted the input");
            default:
                System.out.println("Error: Unknown command.");
                break;
            }
        }
    }

    public static void chemHelper(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println(); // newline
            try {
                switch (getChemTool(scanner)) {
                case OPT_GET_MOLARITY:
                    System.out.println("ANS: " + ChemistryTools.getMolarity(Double.parseDouble(getUserValue(scanner)),
                            Double.parseDouble(getUserValue(scanner))));
                    break;
                case OPT_GET_MOLALITY:
                    System.out.println("ANS: " + ChemistryTools.getMolality(Double.parseDouble(getUserValue(scanner)),
                            Double.parseDouble(getUserValue(scanner))));
                    break;
                case OPT_GET_NORMALITY:
                    System.out.println("ANS: " + ChemistryTools.getNormality(Double.parseDouble(getUserValue(scanner)),
                            Double.parseDouble(getUserValue(scanner))));
                    break;
                case OPT_GET_PARTIAL_PRESSURE:
                    System.out.println("ANS: " + ChemistryTools.getPartialPressure(
                            Double.parseDouble(getUserValue(scanner)), Double.parseDouble(getUserValue(scanner))));
                    break;
                case OPT_GET_CONCENTRATION:
                    System.out.println("ANS: " + ChemistryTools.getConcentration(
                            Double.parseDouble(getUserValue(scanner)), Double.parseDouble(getUserValue(scanner))));
                    break;
                case OPT_GET_DENSITY:
                    System.out.println("ANS: " + ChemistryTools.getDensity(Double.parseDouble(getUserValue(scanner)),
                            Double.parseDouble(getUserValue(scanner))));
                    break;
                case OPT_GET_MOLES_FROM_MASS:
                    System.out.println("ANS: " + ChemistryTools.getMolesFromMass(
                            Double.parseDouble(getUserValue(scanner)), Double.parseDouble(getUserValue(scanner))));
                    break;
                case OPT_GET_MASS_FROM_MOLES:
                    System.out.println("ANS: " + ChemistryTools.getMassFromMoles(
                            Double.parseDouble(getUserValue(scanner)), Double.parseDouble(getUserValue(scanner))));
                    break;
                }
                checkIfUserStoresValue(scanner); // let user store value after calculations
            } catch (AbortedException e) {
                System.out.println("The user has aborted the task.");
                running = false;
            } catch (NullPointerException e) {
                System.out.println("Given value is not found in stored values.");
            } catch (NumberFormatException e) {
                System.out.println("Given value is not supported for the formula.");
            }catch (Exception e) {
                System.out.print("Unexpected error has occured please try it again with valid values. Error: ");
                e.printStackTrace();
            }
        }
    }

    public static void checkIfUserStoresValue(Scanner scanner) {
        boolean storeSession = true;
        while (storeSession) {
            System.out.println(); // newline
            switch (getOptStoreValue(scanner)) {
            case OPT_YES:
                storeValue(scanner);
                break;
            case OPT_VIEW_VALUES:
                viewStoredValues();
                break;
            case OPT_NO:
                storeSession = false;
                break;
            default:
                System.out.println("Error: Unknown command.");
                break;
            }
        }
    }

    public static void viewPeriodicTable(Scanner scanner, PeriodicTable periodicTable) {
        boolean running = true;
        periodicTable.display();
        while (running) {
            boolean viewed = false;
            System.out.println(); // newline
            try {
                switch (getOptFindElements(scanner)) {
                case OPT_FIND_ELEMENT_BY_ATOMIC_NUM:
                    System.out.println("Please input atomic number ");
                    System.out.println(
                            periodicTable.getElementByAtomicNumber(Integer.parseInt(scanner.nextLine())).toTable());
                    viewed = true;
                    break;
                case OPT_FIND_ELEMENT_BY_NAME:
                    System.out.println("Please input element name ");
                    System.out.println(periodicTable.getElementByName(scanner.nextLine()).toTable());
                    viewed = true;
                    break;
                case OPT_FIND_ELEMENT_BY_SYMBOL:
                    System.out.println("Please input element symbol ");
                    System.out.println(periodicTable.getElementBySymbol(scanner.nextLine()).toTable());
                    viewed = true;
                    break;
                case OPT_QUIT:
                    running = false;
                    break;
                default:
                    System.out.println("Error: Unknown command.");
                    break;
                }
                if (viewed) {
                    checkIfUserStoresValue(scanner); // End of every view check if user wants to store value
                }
            } catch (NullPointerException e) {
                System.out.print("Given atomic number is not found. Please try it again.");
            } catch (NumberFormatException e) {
                System.out.print("Value you provided is not a number.");
            }
        }
    }

    public static void storeValue(Scanner scanner) {
        System.out.println("Please input value you want to store.");
        String value = scanner.nextLine();
        System.out.println("How would you call it?");
        String key = scanner.nextLine();
        userValue.put(key, value);
    }

    public static void viewStoredValues() {
        for (String key : userValue.keySet()) {
            System.out.printf("%s: %s\n", key, userValue.get(key));
        }
    }
}
