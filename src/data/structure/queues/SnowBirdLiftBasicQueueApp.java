package data.structure.queues;

public class SnowBirdLiftBasicQueueApp extends SnowBirdLiftQueue {

	public SnowBirdLiftBasicQueueApp() {
		super(new BasicQueue<Gad2Chair>());
	}

	public static void main(String[] args) {
		System.out.println("*** Snow Bird Lift Basic Queue App ***");
		SnowBirdLiftListQueueApp app = new SnowBirdLiftListQueueApp();
		app.runLift();
	}
}
