import java.io.FileWriter;
import java.io.IOException;

public class SummaryWriter {
    public static void writeSummaryToFile(int liveQuokkas, int newbornQuokkas, int deadQuokkas, int foodSupply) {
        try {
            FileWriter writer = new FileWriter("populationFinal.txt");
            writer.write("Live Quokkas: " + liveQuokkas + "\n");
            writer.write("Newborn Quokkas: " + newbornQuokkas + "\n");
            writer.write("Dead Quokkas: " + deadQuokkas + "\n");
            writer.write("Total Food Supply: " + foodSupply + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the summary to the file.");
            e.printStackTrace();
        }
    }
}
