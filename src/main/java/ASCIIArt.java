/**
 * This ASCIIArt class is a utility class that has methods that provide Strings with ASCII Art that is used throughout the simulator.
 * @author Lily You
 * @version 1.2
 */

public final class ASCIIArt {
    
    /*
     * Private constructor to prevent object creation.
     */
    private ASCIIArt(){

    }

    /**
     * Returns a string representing a ICS Unit 1 Test paper as ASCII art
     * @param num int - an integer between 0 to 4 that chooses which test paper version will be used in the simulator
     * @return a String of the test paper as ASCII art or an empty String if the integer is not between 0 to 4
     */
    public static String papers(int num){
        String paper = "";
        if(num == 0){
            String paper1 = 
            "+------------------------------+\n" +
            "|         ICS Unit 1 Test      |\n" +
            "|         Student Answers      |\n" +
            "|                              |\n" +
            "| 1.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 2.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 3.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 4.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 5.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 6.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 7.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 8.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 9.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 10. [ ] A [X] B [ ] C [ ] D  |\n" +
            "|                              |\n" +
            "+------------------------------+\n";
            paper = paper1;
        }
        if(num == 1){
            String paper2 = 
            "+------------------------------+\n" +
            "|         ICS Unit 1 Test      |\n" +
            "|         Student Answers      |\n" +
            "|                              |\n" +
            "| 1.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 2.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 3.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 4.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 5.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 6.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 7.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 8.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 9.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 10. [ ] A [ ] B [ ] C [X] D  |\n" +
            "|                              |\n" +
            "+------------------------------+\n";
            paper = paper2;

        }
        if(num == 2){
            String paper3 = 
            "+------------------------------+\n" +
            "|         ICS Unit 1 Test      |\n" +
            "|         Student Answers      |\n" +
            "|                              |\n" +
            "| 1.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 2.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 3.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 4.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 5.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 6.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 7.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 8.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 9.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 10. [ ] A [X] B [ ] C [ ] D  |\n" +
            "|                              |\n" +
            "+------------------------------+\n";
            paper = paper3;
        }
        
        if(num == 3){
            String paper4 = 
           "+-------------------------------+\n" +
            "|         ICS Unit 1 Test      |\n" +
            "|         Student Answers      |\n" +
            "|                              |\n" +
            "| 1.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 2.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 3.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 4.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 5.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 6.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 7.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 8.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 9.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 10. [X] A [ ] B [ ] C [ ] D  |\n" +
            "|                              |\n" +
            "+------------------------------+\n";
            paper = paper4;
        }

        if(num == 4){
            String paper5 = 
           "+-------------------------------+\n" +
            "|         ICS Unit 1 Test      |\n" +
            "|         Student Answers      |\n" +
            "|                              |\n" +
            "| 1.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 2.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 3.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 4.  [ ] A [ ] B [ ] C [X] D  |\n" +
            "| 5.  [ ] A [X] B [ ] C [ ] D  |\n" +
            "| 6.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 7.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 8.  [X] A [ ] B [ ] C [ ] D  |\n" +
            "| 9.  [ ] A [ ] B [X] C [ ] D  |\n" +
            "| 10. [ ] A [X] B [ ] C [ ] D  |\n" +
            "|                              |\n" +
            "+------------------------------+\n";
            paper = paper5;
        }
        return paper;
    }

    //Used https://www.asciiart.eu/image-to-ascii, https://www.compart.com/en/unicode/block/U+2580, https://www.compart.com/en/unicode/block/U+2500 to help create the components
    
    /**
     * Returns an array of Strings of ASCII art representing computer components, including a fan, CPU, RAM, PSU and GPU
     * @return an array of Strings that contain the ASCII art of 5 computer components
     */
    public static String[] components(){
        String fan = 
        "@@@@@@   +@@@.  =@@@+ \n" + 
        "@@@@@@@@  %@@-  @@@@* \n" + 
        "@   :%@@@+@@@ .@@@@@# \n" + 
        "      @@@@@%@@@@@  *  \n" + 
        "#@@@@@@@ FAN @@@@ = \n" + 
        "#@@%@@ @@@@@@@@@@@@@* \n" + 
        "%  @#@@@#@@@ =@@@@@%# \n" + 
        "@@# @@@@ *@@@.     @* \n" + 
        "@@@=@@@+  @@@@@. #@@* \n";

        String CPU = 
        ".-----------.\n"+
        "|    CPU    |\n"+
        "|   [====]  |\n"+
        "|___________|\n";


        String RAM =
        "_________________________\n"+
        "|  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ |\n"+
        "|  ▓ RAM  8GB DDR3 ▓▓   |\n"+
        "|_______________________|\n"+
        "|_|_|_|_|_|_|_|_|_|_|_|_|\n";

        String PSU =
        "┌───────────────────────────┐\n"+
        "│ ⚡ POWER SUPPLY UNIT ⚡  │\n"+
        "|         [850W]            │\n"+
        "|                           │\n"+
        "│  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ │\n"+
        "└───────────────────────────┘\n";

        String GPU =
        "┌────────────────────┐\n"+
        "│ GRAPHICS CARD      │\n"+
        "│ [====]     [====]  │\n"+
        "|                    |\n"+
        "│ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  │\n"+
        "└────────────────────┘\n";

        String[] components = {fan, CPU, RAM, PSU, GPU};
        return components;

    }
}
