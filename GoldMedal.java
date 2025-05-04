import java.io.*;

public class GoldMedal {
    public static void main(String[] args) throws Exception {
        // Reading the file
        BufferedReader br = new BufferedReader(new FileReader("Marks.txt"));
        String line;

        // Arrays to store subject names, top scores, and toppers' names
        String[] subjects = {"English", "Maths", "Physics", "Chemistry", "Biology"};
        int[] topScores = new int[5];  // To track the highest scores in each subject
        String[] toppers = new String[5]; // To track the toppers for each subject

        int highestTotal = 0;  // To track the highest total marks
        String goldMedalist = "";  // Name of the gold medalist

        // Read each line from the file
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");  // Split the line by commas
            String name = parts[0];  // Extract the name of the student
            int total = 0;  // Initialize total marks for this student

            // Loop through each subject's score
            for (int i = 0; i < 5; i++) {
                String[] sub = parts[i + 3].split(":");  // Extract subject name and score
                int score = Integer.parseInt(sub[1]);  // Convert score to integer
                total += score;  // Add score to the total

                // Check if this score is higher than the current top score for this subject
                if (score > topScores[i]) {
                    topScores[i] = score;  // Update the top score
                    toppers[i] = name;  // Update the topper for this subject
                }
            }

            // Check if this student's total marks are higher than the current highest total
            if (total > highestTotal) {
                highestTotal = total;  // Update highest total
                goldMedalist = name;  // Update gold medalist's name
            }
        }

        br.close();  // Close the file after reading

        // Output results
        System.out.println("Gold Medalist: " + goldMedalist + " with total marks: " + highestTotal);
        System.out.println("\nSubject-wise Toppers:");
        for (int i = 0; i < 5; i++) {
            System.out.println(subjects[i] + ": " + toppers[i] + " (" + topScores[i] + ")");
        }
    }
}