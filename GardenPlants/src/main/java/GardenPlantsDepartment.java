import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GardenPlantsDepartment {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static List<Plant> gardenPlants = new ArrayList<Plant>(createPlantsList());

    private GardenPlantsDepartment() {}

    private static GardenPlantsDepartment gardenPlantsDepartment = new GardenPlantsDepartment();

    public static GardenPlantsDepartment access(){
        return gardenPlantsDepartment;
    }

    public static ArrayList<Plant> createPlantsList(){
        ArrayList<Plant> gardenPlants = new ArrayList<Plant>();
        gardenPlants.add(new Iris(GardenningSeason.FALL, Lifetime.ONE_YEAR));
        gardenPlants.add(new Antidesma(GardenningSeason.SPRING, Lifetime.TWO_YEARS));
        gardenPlants.add(new Ceanothus(GardenningSeason.SUMMER, Lifetime.OVER_5_YEARS));
        gardenPlants.add(new Nicandra(GardenningSeason.WINTER, Lifetime.OVER_20_YEARS));

        return gardenPlants;
    }

    public void sortByLifetime(){
        Collections.sort(gardenPlants, new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                return o1.lifetime.compareTo(o2.lifetime);
            }
        });
        System.out.println("ArrayList<Plant> gardenPlants sorted by plant's lifetime.");
    }

    public void printPlants() {
        for (Plant plant :gardenPlants) {
            System.out.println(plant);
        }
        System.out.println();
    }

    public void viewPossibleSearchVariants() {
        try {
            System.out.println("To view plants with winter gardening season enter 1.\n" +
                    "To view plants with spring gardening season enter 2.\n" +
                    "To view plants with summer gardening season enter 3.\n" +
                    "To view plants with fall gardening season enter 4.");
            switch (Integer.parseInt(reader.readLine())) {
                case 1:
                    GardenPlantsDepartment.access().searchBySeason(GardenningSeason.WINTER);
                    break;
                case 2:
                    GardenPlantsDepartment.access().searchBySeason(GardenningSeason.SPRING);
                    break;
                case 3:
                    GardenPlantsDepartment.access().searchBySeason(GardenningSeason.SUMMER);
                    break;
                case 4:
                    GardenPlantsDepartment.access().searchBySeason(GardenningSeason.FALL);
                    break;
                default:
                    System.out.println("Entered wrong value. System shut down.");
                    System.exit(1);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error. Restart application.");
            System.exit(1);
        }
    }

    public void searchBySeason(GardenningSeason season) {
        ArrayList<Plant> foundPlants = new ArrayList<Plant>();
        for (Plant plant :gardenPlants) {
            if (plant.gardenningSeason.equals(season)){
                foundPlants.add(plant);
            }
        }

        if (foundPlants.isEmpty()) {
            System.out.println("There is no plants with " + season + " gardenning season.");
        } else {
            for (Plant plant1 :foundPlants) {
                System.out.println(plant1);
            }
        }
    }

}
