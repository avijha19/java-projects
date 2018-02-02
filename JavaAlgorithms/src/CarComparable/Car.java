package CarComparable;

public class Car implements Comparable<Car>{

	private String name;
	private String color;
	private Integer model;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	//@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub

		if (obj instanceof Car && ((Car) obj).getColor() == this.color && ((Car) obj).getModel().equals(this.model)
				&& ((Car) obj).getName() == this.name) {
			return true;
		} else {
			return false;
		}
		
//		if (obj instanceof Car && ((Car) obj).getName() == this.name) {
//			return true;
//		} else {
//			return false;
//		}

		// return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.color.hashCode()*this.model.hashCode());
		// return this.model.hashCode();
		//return this.color.hashCode();
		//return 1;
		

	}

	@Override
	public int compareTo(Car o) {
		return model.compareTo(o.getModel());
//		// TODO Auto-generated method stub
//		if(o.getModel()>this.getModel()){
//			return 1;
//		} else {
//			return 0;
//		}
	}

}
