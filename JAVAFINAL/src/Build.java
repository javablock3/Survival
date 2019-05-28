import java.util.Scanner;

public class Build {



    public static void mainBuild(){
        boolean buildTrue = true;
        boolean stickShelter;
        boolean tent;
        boolean boat;
        System.out.println( "------Build menu------" );
        System.out.println( "basic stick shelter:      100 wood" );
        System.out.println( "basic tent:               100 wood and 10 cloth scraps" );
        System.out.println( "boat:            1000 wood and 100 cloth scraps" );
        System.out.println( "To leave:         *exit*" );
        Scanner input = new Scanner(System.in);
        String text;
        while(buildTrue) {
            text = input.nextLine();

            switch (text) {
                case "bacis stick shelter":
                    if (Inventory.wood >= 100) {
                        Inventory.wood = Inventory.wood - 100;
                        System.out.println( "You build a basic stick shelter. You now have " + Inventory.wood + " pieces of wood left." );
                        stickShelter = true;
                    } else
                        System.out.println( "You do not have enough wood to do that." );
                    break;
                case "basic tent":
                    if (Inventory.wood >= 100 && Inventory.clothSraps >= 10) {
                        Inventory.clothSraps = Inventory.clothSraps - 10;
                        Inventory.wood = Inventory.wood - 100;
                        System.out.println( "You built a basic Tent. You know have " + Inventory.wood + " wood left and " + Inventory.clothSraps + " pieces of cloth left." );
                        tent = true;
                    }
                    break;
                case "boat":
                    if (Inventory.wood >= 1000 && Inventory.clothSraps >= 100) {
                        System.out.println( "You managed to build a boat to float down the river to civilization. Congratulations." );
                        Main.gamePlay = false;
                    }
                    break;
                case"exit":
                    buildTrue = false;
                    System.out.println( "Exiting to main menu." );
                break;
                default:
                    System.out.println( "That is not a valid command." );
            }
        }

    }
}
