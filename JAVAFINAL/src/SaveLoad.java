import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

import java.io.*;

public class SaveLoad {
    public static void Save(){

        try {
            //this method takes all your current stats and inventory and saves it to a text file to be read the next time you start the game.
            PrintWriter write = new PrintWriter( "saveData.txt", StandardCharsets.UTF_8 );
            write.println( Inventory.wood );
            write.println( Inventory.food );
            write.println( Inventory.water );
            write.println( Inventory.userFood );
            write.println( Inventory.userWater );
            write.println( Inventory.clothSraps );
            write.close();
            System.out.println( "You have saved your game." );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void Load(){

        // The name of the file to open.
        String fileName = "saveData.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.

            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            line = bufferedReader.readLine();

            if (line == null) {
                Save();
                return;
            }

            Inventory.wood = Integer.parseInt(line);
            line = bufferedReader.readLine();
            Inventory.food = Integer.parseInt( line );
            line = bufferedReader.readLine();
            Inventory.water = Integer.parseInt( line );
            line = bufferedReader.readLine();
            Inventory.userFood = Integer.parseInt( line );
            line = bufferedReader.readLine();
            Inventory.userWater = Integer.parseInt( line );
            line = bufferedReader.readLine();
            Inventory.clothSraps = Integer.parseInt( line );
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
//            System.out.println(
//                    "Unable to open file '" +
//                            fileName + "'");
            System.out.println("Creating file " + fileName + "...");
            // Call the save method
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

    }

}
