import java.util.Random;
import java.util.Scanner;


public class Main {
    public static boolean gamePlay = true;
    public static void main(String[] args){
        Scanner input = new Scanner( System.in );
        Inventory.setUserFood( 100 );
        Inventory.setUserWater( 100 );
        System.out.println("Welcome to the survival game!");
        System.out.println("The goal of the game is to survive.");
        System.out.println( "You wake up in the middle of the woods with no food or water." );
        System.out.println( "You can gather wood to build a small shelter." );
        System.out.println( "Type *commands* for a list of commands." );
        String text;
        while(gamePlay){
            SaveLoad.Load();

            while (Inventory.userFood > 0 && Inventory.userWater > 0){
                if(Inventory.userWater < 26|| Inventory.userFood <26){
                    System.out.println( "Your vitals are getting kinda low you might wanna check on that. " );
                }
                text  = input.nextLine();
                switch (text){
                    case "commands":
                        commands();
                        break;
                    case"chop wood":
                        collectWood();
                    break;

                    case"collect water":
                        collectWater();
                    break;
                    case"collect food":
                        collectFood();
                    break;
                    case"drink":
                        drink();
                    break;
                    case"eat food":
                        eat();
                     break;
                    case"vitals":
                        checkVitals();
                    break;
                    case "build":
                        Build.mainBuild();
                    break;
                    case"collect cloth":
                        collectScraps();
                    break;
                    case"save":
                        SaveLoad.Save();
                    break;
                    case"inventory":
                        System.out.println( "Wood: " + Inventory.wood );
                        System.out.println( "Water: " + Inventory.water );
                        System.out.println( "Food: " + Inventory.food );
                        System.out.println( "Cloth Scraps " + Inventory.clothSraps );
                    break;

                default:System.out.println( "This is not a valid command." );
                }




            }

            System.out.println( "your vitals have got to low. You have died. " );

        }

    }
    public static void commands(){
        System.out.println( "To build:              *build*" );
        System.out.println( "To check your vitals:  *vitals*" );
        System.out.println( "To gather food:        *get food*" );
        System.out.println( "To gather water:       *get water*" );
        System.out.println( "To chop wood:          *chop wood*" );
        System.out.println( "To drink water:        *drink*" );
        System.out.println( "To eat food:           *eat*" );
        System.out.println( "To build something     *build* " );
        




    }
    public static void collectWood(){
        //randomly gives 2-5 wood
        //takes away from water and food
        //puts into inventory


        Random rand = new Random();

        int n = rand.nextInt(11);

        n = n+ 1;
        Inventory.wood = Inventory.wood + n;
        System.out.println( "You collected " + n + "pieces of wood" );
        Inventory.setUserFood( -3 );
        Inventory.setUserWater( -3 );
    }
    public static void collectFood() {
        //randomly gives 2-5 food
        //takes away from water
        //puts into inventory
        Random rand = new Random();

        int n = rand.nextInt(2);

        n = n+ 1;
        Inventory.food = Inventory.food +n;
        vitalChanger();
        System.out.println( "You collected "+ n + " pieces of food. " );

    }
    public static void collectWater(){
        //randomly gives 2-5 water
        //takes away from water
        //puts into inventory
        Random rand = new Random();

        int n = rand.nextInt(1);

        n = n+ 1;
        Inventory.water = Inventory.water + n;
        vitalChanger();
        System.out.println( "You collected "+ n + " Bottles of water " );

    }

    public static void eat(){
        if(Inventory.food> 0){
        System.out.println("\033[3mCRUNCH\033[0m");
        System.out.println( "You consumed one piece of food. " );
        Inventory.setUserFood( 3 );
        Inventory.food= Inventory.food - 1;}
        else
            System.out.println( "You do not have any food!" );

    }
    public static void drink(){
        if(Inventory.water > 0 ){
        System.out.println("\033[3mGULP\033[0m");
        System.out.println( "You concumed one bottle of water" );
        Inventory.setUserWater( 5 );
        Inventory.water= Inventory.water - 1;}
        else
            System.out.println( "You dont have any water!" );



    }
    public static void checkVitals(){
        System.out.println( "Food: "+ Inventory.userFood );
        System.out.println( "Water: " + Inventory.userWater );

    }
    public static void vitalChanger(){
        Random rand = new Random( );
        if(rand.nextInt( 3 ) == 2){
            Inventory.setUserWater( -rand.nextInt( 4 ) );
            Inventory.setUserFood( -rand.nextInt( 4 ) );
        }


    }
    public static void collectScraps(){
        Random rand = new Random();

        int n = rand.nextInt(3);

        n = n+ 1;
        Inventory.wood = Inventory.clothSraps + n;
        System.out.println( "You collected " + n + "pieces of cloth" );
        Inventory.setUserFood( -3 );
        Inventory.setUserWater( -3 );
    }


    }
