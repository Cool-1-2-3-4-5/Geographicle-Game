import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Game logic = new Game();
    Random rand = new Random();
    logic.read();
    String input;
    int choice;
    int choice2;
    int difficulty;
    String y;
    String guess;
    boolean matcher;
    boolean enabler;
    String[] answers;
    String[] sentence;
    int number;
    int smilyFaceCnt = logic.varSet(1);
    int warriorFaceCnt = logic.varSet(2);
    int coolFaceCnt = logic.varSet(3);
    int redCnt = logic.varSet(4);
    int orangeCnt = logic.varSet(5);
    int yellowCnt = logic.varSet(6);
    int greenCnt = logic.varSet(7);
    int blueCnt = logic.varSet(8);
    int purpleCnt = logic.varSet(9);
    int brownCnt = logic.varSet(10);
    int blackCnt = logic.varSet(11);
    int whiteCnt = logic.varSet(12);
    int letterCnt = logic.varSet(13);
    int GDP = logic.varSet(14);
    int mS = logic.varSet(15);
    int population = logic.varSet(16);
    String nameOfCountry = logic.nameSet();
    String[][] sampleMap = new String[10][10];
    String[][] realMap = logic.map();
    boolean quit = true;

    System.out.println("Hello user!");
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        sampleMap[i][j] = i + "" + j;
      }
    }
    while (true) {
      System.out.println("1. Questions");
      System.out.println("2. Your Country");
      System.out.println("3. Shop");
      System.out.println("4. Help");
      System.out.println("5. Exit");
      choice = kb.nextInt();
      if (choice < 1 || choice > 5) {
        System.out.println("Error, please try again!");
      } else {
        switch (choice) {
          case 1:
            System.out.println("Which difficulty would like to play in");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard \n");
            difficulty = kb.nextInt();
            if (difficulty < 1 || difficulty > 3) {
              System.out.println("Error, please try again!");
            } else {
              kb.nextLine(); // Flush character space
              for (int i = 0; i < 5; i++) {
                y = logic.ask(difficulty);
                System.out.println("Q" + ((i * 2) + 1) + ": " + y);
                System.out.println("Your Answer:");
                guess = kb.nextLine();
                answers = logic.rightAnswer();
                matcher = logic.correct(guess);
                if (matcher) {
                  System.out.println("Correct!");
                  logic.addPoints(difficulty);
                } else {
                  System.out.println("Sorry but that is incorrect. The correct answer is " + answers[i]);
                }
                String m = logic.askSentence();
                System.out.println("Q" + ((i + 1) * 2) + ": " + m);
                guess = kb.nextLine();
                sentence = logic.rightAnswer2();
                boolean matcher2 = logic.correct2(guess);
                if (matcher2) {
                  System.out.println("Correct!");
                  logic.addPoints(4);
                } else {
                  System.out.println("Sorry but that is incorrect. The correct answer is " + sentence[i]);
                }
              }
              System.out.println("Total Points: " + logic.totalPoints());
              logic.cntReset();
              System.out.print("\n");
            }
            break;
          case 2: // My Country
            System.out.println("This is your inventory\n");
            System.out.println("EMOJIS");
            System.out.println("1. Smiley Face: " + smilyFaceCnt);
            System.out.println("2. Warrior Face: " + warriorFaceCnt);
            System.out.println("3. Cool Face: " + coolFaceCnt + "\n");
            System.out.println("COLOURS");
            System.out.println("4. Red colour: " + redCnt);
            System.out.println("5. Orange colour: " + orangeCnt);
            System.out.println("6. Yellow colour: " + yellowCnt);
            System.out.println("7. Green colour: " + greenCnt);
            System.out.println("8. Blue colour: " + blueCnt);
            System.out.println("9. Purple colour: " + purpleCnt);
            System.out.println("10. Brown colour: " + brownCnt);
            System.out.println("11. Black colour: " + blackCnt);
            System.out.println("12. White colour: " + whiteCnt + "\n");
            System.out.println("You also have " + letterCnt + " letters.");
            System.out.println("Name of Country: " + nameOfCountry + "\n");

            System.out.println("These are the indexes to your map");
            for (int i = 0; i < 10; i++) {
              for (int j = 0; j < 10; j++) {
                System.out.print(sampleMap[i][j] + " ");
              }
              System.out.print("\n");
            }
            System.out.print("\n");
            System.out.println("Nation's Stats");
            System.out.println("1. GDP: " + GDP);
            System.out.println("2. Military Spendings: " + mS);
            System.out.println("3. Population: " + population + "\n");
            quit = true;
            while (quit) {
              System.out.println("What would like to do user?");
              System.out.println("1. Name your country?");
              System.out.println("2. Make your country");
              System.out.println("3. Increase nations's stats");
              System.out.println("4. View your map");
              System.out.println("5. Quit");
              int selection3 = kb.nextInt();
              if (selection3 < 1 || selection3 > 5) {
                System.out.println("Invalid key. Please try again");
              } else {
                switch (selection3) {
                  case 1:
                    if (letterCnt == 0) {
                      System.out.println("Sorry user but you do not have enough letters");
                    } else {
                      System.out.print("Enter country name: ");
                      kb.nextLine();
                      String country = kb.nextLine();
                      if (country.length() != letterCnt) {
                        System.out.println(
                            "Sorry, not valid. Only pick a name that has the same amount of letters that you bought in the same.");
                      } else {
                        nameOfCountry = country;
                        letterCnt = 0;
                        System.out.println("Welcome to the kingdom of " + nameOfCountry);
                      }
                    }
                    break;
                  case 2:
                    System.out.println("Enter the item you would like to place: ");
                    int selection5 = kb.nextInt();
                    int confirm = 0;
                    if (selection5 == 1) {
                      if (smilyFaceCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 2) {
                      if (warriorFaceCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 3) {
                      if (coolFaceCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 4) {
                      if (redCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 5) {
                      if (orangeCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 6) {
                      if (yellowCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 7) {
                      if (greenCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 8) {
                      if (blueCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 9) {
                      if (purpleCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 10) {
                      if (brownCnt == 0) {
                        confirm = 1;
                      }
                    } else if (selection5 == 11) {
                      if (blackCnt == 0) {
                        confirm = 1;
                      }
                    } else {
                      if (whiteCnt == 0) {
                        confirm = 1;
                      }
                    }
                    if (confirm == 1) {
                      System.out.println("Sorry you do not have that item");
                    } else {
                      System.out.print("Enter your first digit: ");
                      int index1 = kb.nextInt();
                      if (index1 < 0 || index1 > 9) {
                        System.out.println("Invalid index");
                      } else {
                        System.out.print("Enter your second digit: ");
                        int index2 = kb.nextInt();
                        if (index2 < 0 || index2 > 9) {
                          System.out.println("Invalid index");
                        } else {
                          if (selection5 == 1) {
                            input = "\uD83D\uDE00";
                            smilyFaceCnt--;
                          } else if (selection5 == 2) {
                            input = "⚔️";
                            warriorFaceCnt--;
                          } else if (selection5 == 3) {
                            input = "😎";
                            coolFaceCnt--;
                          } else if (selection5 == 4) {
                            input = "🟥";
                            redCnt--;
                          } else if (selection5 == 5) {
                            input = "🟧";
                            orangeCnt--;
                          } else if (selection5 == 6) {
                            input = "🟨";
                            yellowCnt--;
                          } else if (selection5 == 7) {
                            input = "🟩";
                            greenCnt--;
                          } else if (selection5 == 8) {
                            input = "🟦";
                            blueCnt--;
                          } else if (selection5 == 9) {
                            input = "🟪";
                            purpleCnt--;
                          } else if (selection5 == 10) {
                            input = "🟫";
                            brownCnt--;
                          } else if (selection5 == 11) {
                            input = "⬛";
                            blackCnt--;
                          } else {
                            input = "⬜";
                            whiteCnt--;
                          }
                          int i = index1;
                          int j = index2;
                          realMap[i][j] = input;
                        }
                      }
                      for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                          System.out.print(realMap[i][j] + " ");
                        }
                        System.out.print("\n");
                      }
                    }
                    break;
                  case 3:
                    System.out.println("What would you like to upgrade: ");
                    System.out.println("1. GDP");
                    System.out.println("2. Military Spendings");
                    System.out.println("3. Population");
                    System.out.println("4. Return");
                    int selection4 = kb.nextInt();
                    if (logic.totalPoints() < 10 && selection4 != 4) {
                      System.out.println("Sorry user, you do not have enough points.\n");
                    } else if (selection4 < 1 || selection4 > 4) {
                      System.out.println("Invalid option. Please try again.");
                    } else {
                      switch (selection4) {
                        case 1:
                          GDP = GDP + rand.nextInt(50000, 100000);
                          logic.deductPoints(10);
                          break;
                        case 2:
                          mS = mS + rand.nextInt(100, 500);
                          logic.deductPoints(10);
                          break;
                        case 3:
                          population = population + rand.nextInt(50000, 100000);
                          logic.deductPoints(10);
                          break;
                        default:
                          System.out.println("Returning");
                          break;
                      }
                    }
                    break;
                  case 4:
                    System.out.println("");
                    for (int i = 0; i < 10; i++) {
                      for (int j = 0; j < 10; j++) {
                        System.out.print(realMap[i][j] + " ");
                      }
                      System.out.print("\n");
                    }
                    break;
                  default:
                    quit = false;
                    break;
                }
              }
            }
            System.out.println("Departing Country");
            break;
          case 3:
            enabler = true;
            while (enabler) {
              System.out.println("1. Buy Emojis");
              System.out.println("2. Buy Colours");
              System.out.println("3. Buy Letters");
              System.out.println("4. Quit");
              choice = kb.nextInt();
              kb.nextLine();
              if (choice < 1 || choice > 4) {
                System.out.println("Invalid option. Try again.");
              }
              if (choice == 4) {
                enabler = false;
              } else {
                if (logic.totalPoints() < 10) {
                  System.out.println("You do not posses enough points to gain items");
                  enabler = false;
                } else {
                  switch (choice) {
                    case 1:
                      System.out.println("1. Smily Face (1)");
                      System.out.println("2. Warrior face(1)");
                      System.out.println("3. Cool Face(1)");
                      System.out.println("4. Quit");
                      choice2 = kb.nextInt();
                      kb.nextLine();
                      if (choice2 < 1 || choice2 > 4) {
                        System.out.println("Invalid option. Try again.");
                      } else if (choice2 == 4) {
                        enabler = false;
                      } else {
                        switch (choice2) {
                          case 1:
                            smilyFaceCnt++;
                            logic.deductPoints(10);
                            System.out.println("Smily Face added. Viewable when you open your country");
                            break;
                          case 2:
                            warriorFaceCnt++;
                            logic.deductPoints(10);
                            System.out.println("Warrior Face added. Viewable when you open your country");
                            break;
                          case 3:
                            coolFaceCnt++;
                            logic.deductPoints(10);
                            System.out.println("Cool Face added. Viewable when you open your country");
                            break;
                        }
                        break;
                      }
                      break;
                    case 2:
                      System.out.println("1. Red (1)");
                      System.out.println("2. Orange (1)");
                      System.out.println("3. Yellow (1)");
                      System.out.println("4. Green (1)");
                      System.out.println("5. Blue (1)");
                      System.out.println("6. Purple (1)");
                      System.out.println("7. Brown (1)");
                      System.out.println("8. Black (1)");
                      System.out.println("9. White (1)");
                      System.out.println("10. Quit");
                      choice2 = kb.nextInt();
                      kb.nextLine();
                      if (choice2 < 1 || choice2 > 10) {
                        System.out.println("Invalid option. Try again.");
                      } else if (choice2 == 10) {
                        enabler = false;
                      } else {
                        switch (choice2) {
                          case 1:
                            redCnt++;
                            logic.deductPoints(10);
                            System.out.println("Red colour added. Viewable when you open 'My country'");
                            break;
                          case 2:
                            orangeCnt++;
                            logic.deductPoints(10);
                            System.out.println("Orange colour added. Viewable when you open 'My country'");
                            break;
                          case 3:
                            yellowCnt++;
                            logic.deductPoints(10);
                            System.out.println("Yellow colour added. Viewable when you open 'My country'");
                            break;
                          case 4:
                            greenCnt++;
                            logic.deductPoints(10);
                            System.out.println("Green colour added. Viewable when you open 'My country'");
                            break;
                          case 5:
                            blueCnt++;
                            logic.deductPoints(10);
                            System.out.println("Blue colour added. Viewable when you open 'My country'");
                            break;
                          case 6:
                            purpleCnt++;
                            logic.deductPoints(10);
                            System.out.println("Purple colour added. Viewable when you open 'My country'");
                            break;
                          case 7:
                            brownCnt++;
                            logic.deductPoints(10);
                            System.out.println("Brown colour added. Viewable when you open 'My country'");
                            break;
                          case 8:
                            blackCnt++;
                            logic.deductPoints(10);
                            System.out.println("Black colour added. Viewable when you open 'My country'");
                            break;
                          case 9:
                            whiteCnt++;
                            logic.deductPoints(10);
                            System.out.println("White colour added. Viewable when you open 'My country'");
                            break;
                        }
                        break;
                      }
                      break;
                    case 3:
                      int countryLetters;
                      int selection2;
                      System.out.println("1. Continue");
                      System.out.println("2. Quit");
                      selection2 = kb.nextInt();
                      if (selection2 < 1 || selection2 > 2) {
                        System.out.println("That command is not valid");
                      } else if (selection2 == 2) {
                        enabler = false;
                      } else {
                        System.out.println("Enter how many letter you want to use: ");
                        countryLetters = kb.nextInt();
                        if ((countryLetters * 10) <= logic.totalPoints()) {
                          System.out.println("Succesfully purchased " + countryLetters + " letters.");
                          logic.deductPoints(countryLetters * 10);
                          letterCnt = letterCnt + countryLetters;
                        } else {
                          System.out.println("Unfortunaltly you do not have enough points");
                        }
                      }
                      System.out.println("Exiting");
                      break;
                  }
                }
              }
            }
            System.out.println("Exiting Shop");
            break;
          case 4:
            System.out.println(
                "The main objective of this game is to answer geography questions to accumulate points which you can use to build your nation. Answering questions will enable you to purchase items including emojis, letters, and colors. These items can then be placed in your country to make a cool name and layout. You can also use points to increase your nation’s GDP, population, and Military power. Are You the greatest ruler of the lands or will you, like everyone else, make your country go bankrupt?");
            break;
          case 5:
            logic.recieveCountry(realMap);
            logic.recieveUserStats(1, smilyFaceCnt);
            logic.recieveUserStats(2, warriorFaceCnt);
            logic.recieveUserStats(3, coolFaceCnt);
            logic.recieveUserStats(4, redCnt);
            logic.recieveUserStats(5, orangeCnt);
            logic.recieveUserStats(6, yellowCnt);
            logic.recieveUserStats(7, greenCnt);
            logic.recieveUserStats(8, blueCnt);
            logic.recieveUserStats(9, purpleCnt);
            logic.recieveUserStats(10, brownCnt);
            logic.recieveUserStats(11, blackCnt);
            logic.recieveUserStats(12, whiteCnt);
            logic.recieveUserStats(13, letterCnt);
            logic.recieveUserStats(14, GDP);
            logic.recieveUserStats(15, mS);
            logic.recieveUserStats(16, population);
            logic.recieveCountryName(nameOfCountry);
            logic.write();
            System.out.println("Thank you for playing");
            System.exit(0);
            break;
        }
      }
    }
  }
}