import java.util.HashMap;
import java.util.Map;

public class Housework {
	
	public static Map houseworkMap() {
		Map<String, String> map = new HashMap();
		map.put("Domestic/household chores", "Домашні обов’язки");
		map.put("To clean", "Чистити");
		map.put("To clear up", "Прибирати (зі столу)");
		map.put("To do the cooking", "Готувати їсти");
		map.put("To do the dusting", "Витирати пил");
		map.put("To do the ironing", "Прасувати");
		map.put("To do the shopping", "Закуповуватися");
		map.put("To do the vacuuming", "Пилососити");
		map.put("To do the washing-up", "Мити посуд");
		map.put("To do washing", "Прати");
		map.put("To empty the dishwasher", "Витягати посуд з посудомийної машини");
		map.put("To lay the table", "Накривати на стіл");
		map.put("To load the dishwasher", "Завантажувати посудомийну машину");
		map.put("To put the pots away", "Витягати кастрюлі");
		map.put("To put the rubbish out", "Викидати сміття");
		map.put("To share the chores", "Розділяти обов’язки");
		map.put("To take the dog for a walk", "Вигулювати собаку");
		map.put("To take turns to do housework", "Чергувати домашню роботу");
		map.put("To tidy one’s room", "Прибирати у кімнаті");
		return map;
	}
}
