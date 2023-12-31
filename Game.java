import java.util.Random;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors\
import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text files

public class Game {
  int points;
  int smileyFaceCnt;
  int warriorFaceCnt;
  int coolFaceCnt;
  int redCnt;
  int orangeCnt;
  int yellowCnt;
  int greenCnt;
  int blueCnt;
  int purpleCnt;
  int brownCnt;
  int blackCnt;
  int whiteCnt;
  int letterCnt;
  int GDP;
  int mSpendings;
  int population;
  String nameOfCountry;
  int cnt;
  int cnt2;
  Random rand = new Random();
  String[] names = { "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
      "Belarus", "Belgium", "Botswana", "Brazil", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada",
      "Chad", "China", "Colombia", "Comoros", "Congo", "Ecuador", "Egypt", "Eritrea", "Estonia", "Ethiopia", "Fiji",
      "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Guinea", "Japan", "Jordan", "Kazakhstan", "Kenya",
      "Liechtenstein", "Lithuania", "Luxembourg", "Malawi", "Malaysia" };
  String[][] questions = { { "Which country has the largest population in the world?", "China" },
      { "What American city is the Golden Gate Bridge located in", "San Francisco" },
      { "What is the capital of Mexico?", "New Mexico" },
      { "What is the name of the largest country in the world?", "Russia" },
      { " What U.S. state is home to no documented poisonous snakes?", "Alaska" },
      { "In which city is the Eiffel Tower Located", "Paris" }, { "What is the capital of Canada?", "Ottawa" },
      { "What present-day Italian city does Mt. Vesuvius overlook?", "Naples" },
      { "What country are the Great Pyramids of Giza located in?", "Egypt" },
      { "What is the capital of Thailand?", "Bangkok" },
      { "What is the capital of the American State of California?", "Sacramento" },
      { "What country has the most natural lakes?", "Canada" } };
  String[] answers;
  String[] answerQuestion;
  String[][] sampleCountry;
  String[][] realCountry;

  public Game() {
    points = 0;
    cnt = -1;
    cnt2 = -1;
    answers = new String[5];
    answerQuestion = new String[5];
    realCountry = new String[10][10];
    // for (int i = 0; i < 10; i++){
    // for(int j = 0; j < 10; j++){
    // realCountry[i][j] = "-";
    // }
    // }
  } // Game logic constructor

  public String[][] map() {
    return realCountry;
  }

  public String askSentence() {
    cnt2++;
    int newIndexValue = rand.nextInt(12);
    String question = questions[newIndexValue][0];
    answerQuestion[cnt2] = questions[newIndexValue][1];
    return question;
  }

  public void recieveCountry(String[][] array) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        realCountry[i][j] = array[i][j];
      }
    }
  }

  public String[] rightAnswer2() {
    return answerQuestion;
  }

  public String ask(int difficulty) {
    int charValue;
    int indexValue = rand.nextInt(44);
    String nation = names[indexValue];
    String newName;
    cnt++;
    answers[cnt] = nation;
    if (difficulty == 1) {
      charValue = rand.nextInt(nation.length());
      newName = nation.substring(0, charValue) + '-' + nation.substring(charValue + 1);
      nation = newName;
    } else if (difficulty == 2) {
      for (int i = 0; i < 2; i++) {
        charValue = rand.nextInt(nation.length());
        newName = nation.substring(0, charValue) + '-' + nation.substring(charValue + 1);
        nation = newName;
      }
    } else {
      for (int i = 0; i < 3; i++) {
        charValue = rand.nextInt(nation.length());
        newName = nation.substring(0, charValue) + '-' + nation.substring(charValue + 1);
        nation = newName;
      }
    }
    return nation;
  }

  public String[] rightAnswer() {
    return answers;
  }

  public boolean correct(String answer) {
    if ((answer.toUpperCase()).equals((answers[cnt]).toUpperCase())) {
      return true;
    } else {
      return false;
    }
  }

  public boolean correct2(String answer) {
    if ((answer.toUpperCase()).equals((answerQuestion[cnt2]).toUpperCase())) {
      return true;
    } else {
      return false;
    }
  }

  public void cntReset() {
    cnt = -1;
    cnt2 = -1;
  }

  public void addPoints(int difficulty) {
    if (difficulty == 1) {
      points = points + 1;
    } else if (difficulty == 2) {
      points = points + 3;
    } else if (difficulty == 3) {
      points = points + 5;
    } else {
      points = points + 2;
    }
  }

  public int totalPoints() {
    return points;
  }

  public void deductPoints(int deduct) {
    points = points - deduct;
  }

  public int varSet(int num) {
    if (num == 1) {
      return smileyFaceCnt;
    } else if (num == 2) {
      return warriorFaceCnt;
    } else if (num == 3) {
      return coolFaceCnt;
    } else if (num == 4) {
      return redCnt;
    } else if (num == 5) {
      return orangeCnt;
    } else if (num == 6) {
      return yellowCnt;
    } else if (num == 7) {
      return greenCnt;
    } else if (num == 8) {
      return blueCnt;
    } else if (num == 9) {
      return purpleCnt;
    } else if (num == 10) {
      return brownCnt;
    } else if (num == 11) {
      return blackCnt;
    } else if (num == 12) {
      return whiteCnt;
    } else if (num == 13) {
      return letterCnt;
    } else if (num == 14) {
      return GDP;
    } else if (num == 15) {
      return mSpendings;
    } else {
      return population;
    }
  }

  public String nameSet() {
    return nameOfCountry;
  }

  public void recieveUserStats(int selection, int number) {
    if (selection == 1) {
      smileyFaceCnt = number;
    } else if (selection == 2) {
      warriorFaceCnt = number;
    } else if (selection == 3) {
      coolFaceCnt = number;
    } else if (selection == 4) {
      redCnt = number;
    } else if (selection == 5) {
      orangeCnt = number;
    } else if (selection == 6) {
      yellowCnt = number;
    } else if (selection == 7) {
      greenCnt = number;
    } else if (selection == 8) {
      blueCnt = number;
    } else if (selection == 9) {
      purpleCnt = number;
    } else if (selection == 10) {
      brownCnt = number;
    } else if (selection == 11) {
      blackCnt = number;
    } else if (selection == 12) {
      whiteCnt = number;
    } else if (selection == 13) {
      letterCnt = number;
    } else if (selection == 14) {
      GDP = number;
    } else if (selection == 15) {
      mSpendings = number;
    } else {
      population = number;
    }
  }

  public void recieveCountryName(String name) {
    nameOfCountry = name;
  }

  public void read() { // file reader
    try {
      // local variables
      int h = 0;
      int k = 0;
      BufferedReader input = new BufferedReader(new FileReader("flename.txt")); // connecting to file reader
      points = Integer.parseInt(input.readLine());
      smileyFaceCnt = Integer.parseInt(input.readLine());
      warriorFaceCnt = Integer.parseInt(input.readLine());
      coolFaceCnt = Integer.parseInt(input.readLine());
      redCnt = Integer.parseInt(input.readLine());
      orangeCnt = Integer.parseInt(input.readLine());
      yellowCnt = Integer.parseInt(input.readLine());
      greenCnt = Integer.parseInt(input.readLine());
      blueCnt = Integer.parseInt(input.readLine());
      purpleCnt = Integer.parseInt(input.readLine());
      brownCnt = Integer.parseInt(input.readLine());
      blackCnt = Integer.parseInt(input.readLine());
      whiteCnt = Integer.parseInt(input.readLine());
      letterCnt = Integer.parseInt(input.readLine());
      GDP = Integer.parseInt(input.readLine());
      mSpendings = Integer.parseInt(input.readLine());
      population = Integer.parseInt(input.readLine());
      nameOfCountry = input.readLine();
      for (int i = 0; i < 100; i++) {
        realCountry[h][k] = input.readLine();// the 2-D array recieves and sets it to a designating index
        h++; // incrementing the rows
        if (h > 9) { // if it completed the first entry
          h = 0; // serring row back to one
          k++; // incrementing column
        }
      }
      input.close(); // close the file
    } catch (Exception e) { // need this for try catch
      System.out.println("An error occurred. Progress was restored.");
    }
  }

  public void write() { // write
    try {
      BufferedWriter mw = new BufferedWriter(new FileWriter("flename.txt"));
      mw.write(points + "\n");
      mw.write(smileyFaceCnt + "\n");
      mw.write(warriorFaceCnt + "\n");
      mw.write(coolFaceCnt + "\n");
      mw.write(redCnt + "\n");
      mw.write(orangeCnt + "\n");
      mw.write(yellowCnt + "\n");
      mw.write(greenCnt + "\n");
      mw.write(blueCnt + "\n");
      mw.write(purpleCnt + "\n");
      mw.write(brownCnt + "\n");
      mw.write(blackCnt + "\n");
      mw.write(whiteCnt + "\n");
      mw.write(letterCnt + "\n");
      mw.write(GDP + "\n");
      mw.write(mSpendings + "\n");
      mw.write(population + "\n");
      mw.write(nameOfCountry + "\n");
      for (int i = 0; i < 10; i++) { // looping through all entries
        for (int j = 0; j < 10; j++) {
          mw.write(realCountry[j][i] + "\n"); // writing these entries to the file
        }
      }
      mw.close(); // closing file
    } catch (IOException e) { // need this line for try catch
      System.out.println("An error occurred. Did not write to file.");
      e.printStackTrace();
    }
  }
}