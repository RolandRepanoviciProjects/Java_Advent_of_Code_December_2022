import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class First_of_December {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Input_Files/1 of December.txt"));

                //Initialiazing the calorie and mostCalroies variable with 0
                int calorie = 0;
                int mostCalories = 0;

                //Creating the list of calories
                List<Integer> calorieList = new ArrayList<>();
                
                //Declaring the line variable for the created List calorieList
                String line;

                //Looping through the data and taking the blank lines into consideration. Checking which calorie is
                while ((line = br.readLine()) != null) {
                    String strCal = line.trim();
                    if (strCal.isBlank()) {
                        if (mostCalories < calorie) {
                            mostCalories = calorie;
                        }
                        calorieList.add(calorie);
                        calorie = 0;
                        continue;
                    }
                    calorie += Integer.parseInt(strCal);
                }

                //Checking which elf carries the most calories
                calorieList.add(calorie);
                if(mostCalories < calorie){
                    mostCalories = calorie;
                }

                System.out.println(mostCalories);

                //Sorting for part 2
                calorieList.sort((a, b) -> b - a);
                System.out.println(calorieList.get(0) + calorieList.get(1) + calorieList.get(2));
    br.close(); 

    }
}