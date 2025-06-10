/**
 * This FileIO class is a utility class that has methods to use for _________.
 * @author Lily You
 * @version 1.1 2025/06/10
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	private static final String winsPath = "winsFile.txt";

	public static int getWins() throws IOException {
		//Create a fileWriter
		FileReader inputStream = null;
		int num = 0;
		try {
			inputStream = new FileReader(winsPath);
			int c;
			String numStr = "";
			while((c = inputStream.read()) != -1){
				numStr = numStr + (char)c;
				num = Integer.parseInt(numStr);
			}
		} catch (IOException e){
			System.out.println(e);
		} finally {
			try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file.");
            }
		}
		return num;
	}
	//Source: https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
	public static void setWins(int wins){
		FileWriter writer = null;
        try {
            writer = new FileWriter(winsPath, false);
            writer.write(Integer.toString(wins));
        } catch (IOException e) {
            System.out.println("Error while writing to the file.");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file.");
            }
        }
	}

    
}
