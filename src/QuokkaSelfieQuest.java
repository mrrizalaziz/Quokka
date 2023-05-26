import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuokkaSelfieQuest {
    private static final int SIMULATION_DAYS = 30;
    private static final double BIRTH_PROBABILITY = 0.05;
    private static final int FOOD_PER_DAY = 2;
    private static final int FOOD_PER_DAY_WITH_BABY = 3;

    private static FileWriter writer;

    private static void writeSummaryToFile(int quokkaPopulation, int newQuokkas, int deadQuokkas, int foodSupply) {
        try {
            writer = new FileWriter("populationFinal.txt");
            writer.write("Final Simulation Summary\n");
            writer.write("=========================\n");
            writer.write("Total alive including babies: " + quokkaPopulation + "\n");
            writer.write("Total new born babies: " + newQuokkas + "\n");
            writer.write("Total dead quokkas: " + deadQuokkas + "\n");
            writer.write("Total food bags: " + foodSupply + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the summary to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Quokka Selfie Quest Simulation\n");

        int initialPopulation = readInitialPopulation();

        System.out.println("\nSetting up the Quokka population");
        List<Quokka> quokkas = initializeQuokkaPopulation(initialPopulation);
        int newBabies = 0; // Initialize newBabies variable

        System.out.println("\nSimulation started\n");

        for (int day = 1; day <= SIMULATION_DAYS; day++) {
            System.out.println("*** Day #" + day + " ***");

            System.out.println("Current alive quokka (including babies): " + quokkas.size());

            int totalBags = getTotalFoodBags(quokkas);
            System.out.println("Current total bags: " + totalBags);

            // Additional code for sorting quokkas based on food supply goes here

            // Additional code for handling tourist groups and selfies goes here

            // Additional code for displaying daily summary goes here

            System.out.println("Press ENTER to continue to the next day\n");
            waitForEnterKey();

            // Update newBabies variable based on new births during the day
            int births = countNewBabies(quokkas);
            quokkas.addAll(generateNewBabies(births));
        }

        System.out.println("\nWriting summary to populationFinal.txt");
        writeSummaryToFile(quokkas.size(), newBabies, 0, getTotalFoodBags(quokkas));

        System.out.println("\nGoodbye >\n");
    }
    // Method to count the number of new babies born during the day
    private static int countNewBabies(List<Quokka> quokkas) {
        int newBabies = 0;
        for (Quokka quokka : quokkas) {
            if (quokka.hasBaby()) {
                newBabies++;
            }
        }
        return newBabies;
    }

    private static List<Quokka> generateNewBabies(int numberOfBabies) {
        List<Quokka> newBabies = new ArrayList<>();
        for (int i = 0; i < numberOfBabies; i++) {
            String name = "Quokka" + (i + 1);
            int age = 0;
            boolean isAlive = true;
            newBabies.add(new Quokka(name, age, isAlive));
        }
        return newBabies;
    }


    private static int readInitialPopulation() {
        Random random = new Random();
        int population = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        System.out.println("How many Quokka? " + population);
        return population;
    }

    private static int newBabies = 0; // Declare newBabies as an instance variable

    private static List<Quokka> initializeQuokkaPopulation(int initialPopulation) {
        List<Quokka> quokkas = new ArrayList<>();
        Random random = new Random();
      //  int newBabies = 0; // Variable to track the number of new quokkas born

        for (int i = 1; i <= initialPopulation; i++) {
            String id = "Q" + String.format("%03d", i);
            boolean hasBaby = random.nextDouble() <= BIRTH_PROBABILITY;
            int foodSupply = hasBaby ? FOOD_PER_DAY_WITH_BABY : FOOD_PER_DAY;
            quokkas.add(new Quokka(id, foodSupply, hasBaby));

            if (hasBaby) {
                newBabies++;
            }
        }

        System.out.println("\tNew babies: " + newBabies);
        return quokkas;
    }

    private static int getTotalFoodBags(List<Quokka> quokkas) {
        return quokkas.stream().mapToInt(Quokka::getFoodSupply).sum();
    }

    private static void waitForEnterKey() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Quokka {
    private String id;
    private int foodSupply;
    private boolean hasBaby;

    public Quokka(String id, int foodSupply, boolean hasBaby) {
        this.id = id;
        this.foodSupply = foodSupply;
        this.hasBaby = hasBaby;
    }

    public String getId() {
        return id;
    }

    public int getFoodSupply() {
        return foodSupply;
    }

    public boolean hasBaby() {
        return hasBaby;
    }
}
