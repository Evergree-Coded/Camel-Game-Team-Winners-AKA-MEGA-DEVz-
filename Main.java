import java.util.Random;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    // Default Values
    int milesTraveled = 0;
    int thirst = 0;
    int Fatigue = 0;
    int nativesTraveled = -20;
    int canteen = 3;
    boolean camelExist = true;
    boolean stillPlaying = true;

    while(stillPlaying){
      // Menu
      System.out.println("A) Drink from your canteen");
      System.out.println("B) Ahead at Moderate Speed");
      System.out.println("C) Ahead at Full Speed");
      System.out.println("D) Stop for the night");
      System.out.println("E) Use Magic Teleportation Potion");
      System.out.println("F) Status Check");
      System.out.println("Q) Quit");
      System.out.println("Choose an option from above: ");
      String userChoice = scan.nextLine(); // take in user input

      int nativesDistance = rand.nextInt(8) + 7;
      
      if(userChoice.equalsIgnoreCase("a")){
        if(canteen == 0){
          System.out.println("You have no canteens left");
        }
        else{
          canteen--;
          thirst = 0;
        }
      }
      if(userChoice.equalsIgnoreCase("b")){
        //milesTraveled += 8*Math.random() + 5;
        if(camelExist){
          milesTraveled += rand.nextInt(8) + 5; //MIN:5 MAX:12
          }
        else if(!camelExist){ // Triggers when camel dead/gone
          milesTraveled += rand.nextInt(4) + 1; //MIN:1 MAX:4 
        }
        System.out.println("You have traveled: " + milesTraveled);
        thirst++;
        Fatigue++;
        nativesTraveled += nativesDistance;
      }
      if(userChoice.equalsIgnoreCase("c")){
        if(camelExist){
          milesTraveled += rand.nextInt(11)+ 10; //Min: 10 Max:20
        }
        else if(!camelExist){
          milesTraveled += rand.nextInt(6)+ 5; // Min: 5 Max: 10
        }
        System.out.println("You have traveled: " + milesTraveled);
        thirst++;
        Fatigue += rand.nextInt(3) + 1; 
        nativesTraveled += nativesDistance;
      }
      if(userChoice.equalsIgnoreCase("d")){
        Fatigue = 0;
        if(camelExist){
          System.out.println("The Camel Fatigue value: " +  Fatigue);
        }
        if(!camelExist){
          System.out.println("Your Fatigue Level: " +  Fatigue);
        }
        nativesTraveled += nativesDistance;
      }
      if(userChoice.equalsIgnoreCase("e")){
        // Natives forward (24% chance)
        // Natives backward(24% chance)
        // Automatically win game (2%)
        // Automatically lose game (2%)
        // Move forward(24% chance)
        // Move backward(24% chance)
        
        int potionNum = rand.nextInt(101); //Creates random number between 0-100
        if(potionNum >= 0 && potionNum <= 24){ // Natives Forward
          nativesTraveled += 50;
          System.out.print();
          System.out.println("The Natives have skipped forward ")
          System.out.println("The natives are " + (milesTraveled - nativesTraveled) + " miles behind you");
        }
        else if(potionNum >= 25 && potionNum <= 49){ // Natives Backward
          nativesTraveled += -50;
          System.out.print();
          System.out.println("The Natives have fallen backward ")
          System.out.println("The natives are " + (milesTraveled - nativesTraveled) + " miles behind you");
        }
        else if(potionNum >= 50 && potionNum <= 74){ // Player Forward
          milesTraveled += 50;
          System.out.print();
          System.out.println("You have skipped forward ")
          System.out.println("Miles Traveled " + milesTraveled);
        }
        else if(potionNum >= 74 && potionNum <= 98){ // Natives Backward
          milesTraveled += -50;
          System.out.print();
          System.out.println("You have fallen backward ")
          System.out.println("Miles Traveled " + milesTraveled);
      }
      if(userChoice.equalsIgnoreCase("f")){
        System.out.println("Miles Traveled " + milesTraveled);
        System.out.println("You have " + canteen + " canteens");
        if(camelExist){
          System.out.println("The Camel Fatigue value: " +  Fatigue);
        }
        if(!camelExist){
          System.out.println("Your Fatigue Level: " +  Fatigue);
        }
        System.out.println("The natives are " + (milesTraveled - nativesTraveled) + " miles behind you");
      }
      if(userChoice.equalsIgnoreCase("q")){
        stillPlaying = false;
      }
      
      if(milesTraveled >= 200){
        stillPlaying = false;
        System.out.println("You won!");
      }

      if(thirst >= 4 && thirst <= 6){
        System.out.println("You are thirsty!");
      }

      if(thirst > 6){
        System.out.println("Died of dehydration! You Lose");
        stillPlaying = false;
      }
      
      if(Fatigue >= 5 && Fatigue <= 8){
        if(camelExist){
          System.out.println("The camel is getting tired!");
          }
        else if(!camelExist){
          System.out.println("You are getting tired!");
        }
      }

      if(Fatigue > 8){
        if(camelExist){
          camelExist = false; // Camel no longer exists
          Fatigue = 0; // Convert to Human Fatigue
          System.out.println("Your camel dead. Your speed decreased.");
          }
        else if(!camelExist){
          stillPlaying = false;
          System.out.println("You walked too much so you lose");
        }
        
      }

      if(milesTraveled - nativesTraveled <= 15){
        System.out.println("The natives are within 15 miles of you.");
      }

      if(milesTraveled <= nativesTraveled){
        System.out.println("You got caught by the natives.");
        stillPlaying = false;
      }
      
    }
    System.out.println("You traveled " + milesTraveled + " miles.");
  }
}