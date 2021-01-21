package data.structure.queues;

public class SnowBirdLiftListQueueApp extends SnowBirdLiftQueue {
	
	public SnowBirdLiftListQueueApp() {
		super(new ListQueue<Gad2Chair>());
	}

	public static void main(String[] args) {
		System.out.println("*** Snow Bird Lift List Queue App ***");
		SnowBirdLiftListQueueApp app = new SnowBirdLiftListQueueApp();
		app.runLift();
	}

}
