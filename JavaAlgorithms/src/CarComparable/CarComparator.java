package CarComparable;
import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		// TODO Auto-generated method stub
		if(o1.getModel()>o2.getModel()){
			return 1;
		} else {
			return 0;
		}
	}
}
