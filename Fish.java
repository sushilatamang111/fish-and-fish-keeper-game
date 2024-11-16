
public class Fish {
	private String name;
	private String color;
	private int weight;
	private boolean isHungry;

	public Fish(String name, String color, int weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
		this.isHungry = false;
	}

	public void swim() {
		System.out.println(name + " is swimming gracefully 🐟");
	}

	public void eat() {
		System.out.println(name + " is eating 🍖");
		weight += 10;
		if (weight >= 100) {
			isHungry = true;
			System.out.println(name + " is now hungry!");
		}
	}

	public void loseWeight(int grams) {
		System.out.println(name + " is losing weight 😣");
		weight -= grams;
		if (weight <= 0) {
			weight = 0;
		}
	}

	public void begForFood() {
		if (isHungry) {
			System.out.println(name + " is begging for food 🥺");
		} else {
			System.out.println(name + " is not hungry right now.");
		}
	}

	public void displayDetails() {
		System.out.println("Fish Name: " + name);
		System.out.println("Color: " + color);
		System.out.println("Weight: " + weight + " grams");
	}

	public boolean isAlive() {
		return weight > 0;
	}

	public void setHungry(boolean hungry) {
		isHungry = hungry;
	}

	public String getName() {
		return name;
	}

	public boolean isHungry() {
		return isHungry;
	}
}
