import java.util.Scanner;

public class FishController {
	private String fishKeeperName;

	public FishController(String fishKeeperName) {
		this.fishKeeperName = fishKeeperName;
	}

	public void feedFish(Fish fish) {
		System.out.println(fishKeeperName + " is feeding " + fish.getName() + ".");
		fish.eat();
		if (fish.isHungry()) {
			fish.setHungry(false);
			System.out.println(fish.getName() + " is no longer hungry.");
			for (int i = 1; i <= 3; i++) {
				fish.eat();
				System.out.println("Day " + i + ": " + fish.getName() + " gains 10 grams.");
				fish.displayDetails();
				System.out.println();
			}
			System.out.println(fish.getName() + " and fish keeper are now happy! 🌟");
		}
	}

	public void neglectFish(Fish fish, int days) {
		System.out.println(fishKeeperName + " is neglecting " + fish.getName() + " for " + days + " days.");
		fish.loseWeight(days * 5);
		if (fish.isHungry()) {
			fish.begForFood();
		}
	}

	public String getFishKeeperName() {
		return fishKeeperName;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the fish keeper's name: ");
		String fishKeeperName = scanner.nextLine();
		FishController fishController = new FishController(fishKeeperName);

		Fish myFish = new Fish("Goldie", "Gold", 50);

		System.out.println("\nInitial Fish Details:");
		myFish.displayDetails();
		System.out.println();

		boolean continueGame = true;
		while (continueGame) {
			System.out.println("\nChoose an action:");
			System.out.println("1. Feed the fish");
			System.out.println("2. Neglect the fish");
			System.out.println("3. Swim");
			System.out.println("4. Display fish details");
			System.out.println("5. Quit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				fishController.feedFish(myFish);
				break;
			case 2:
				System.out.print("Enter number of days to neglect: ");
				int days = scanner.nextInt();
				scanner.nextLine();
				fishController.neglectFish(myFish, days);
				break;
			case 3:
				myFish.swim();
				break;
			case 4:
				myFish.displayDetails();
				break;
			case 5:
				continueGame = false;
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 5.");
			}

			if (!myFish.isAlive()) {
				System.out.println(myFish.getName() + " has died due to neglect.");
				continueGame = false;
			}
		}

		System.out.println("Game over. Thank you for playing!");
		scanner.close();
	}

}
