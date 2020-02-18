package java8.samples.stream;

public class Person {

	Person(int id, String name, int departmentId) {
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
	} 
	
	int id;
	String name;
	int departmentId;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", departmentId=" + departmentId +
				'}';
	}
}
