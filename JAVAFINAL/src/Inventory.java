public class Inventory {
    public static int userWater, water, userFood, food, wood;

    public void setFood(int f){
        food = food + f;
    }

    public int getFood(){
        return food;

    }

    public int getUserFood(){
    return userFood;

    }
    public static void setUserFood(int j){

        userFood = userFood + j;
    }

    public static void setUserWater(int j){
        userWater = userWater + j;

    }
}
