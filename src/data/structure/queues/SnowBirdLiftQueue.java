package data.structure.queues;

public class SnowBirdLiftQueue {

	protected Queue<Gad2Chair> gad2Lift;
	
	public SnowBirdLiftQueue(Queue<Gad2Chair> gad2Lift) {
		this.gad2Lift = gad2Lift;
	}
	
	public void runLift() {
		loadLift();

		// print out the lift size
		System.out.println(gad2Lift.size());

		// does the lift contain skiers Mary and Anna
		System.out.println("Lift has Mary and Anna on it: " + gad2Lift.contains(new Gad2Chair("Mary", "Anna")));

		// who's at the 2nd position - remember 0 based index
		System.out.println("2nd chair has: " + gad2Lift.access(1).listChairRiders());

		unloadLift();

		// print out the lift size again, should be 0
		System.out.println(gad2Lift.size());
		
		// Throw an error because there are no more items
		try {
			gad2Lift.deQueue();
		} catch(IllegalStateException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private void loadLift() {
		// skiers in line to get on lift
		Gad2Chair chair1 = new Gad2Chair("John", "Dave");
		Gad2Chair chair2 = new Gad2Chair("Samantha", "Kelly");
		Gad2Chair chair3 = new Gad2Chair("Mary", "Anna");
		Gad2Chair chair4 = new Gad2Chair("Robert", "Chad");
		Gad2Chair chair5 = new Gad2Chair("Sarah", "Bill");

		// load them onto the lift
		gad2Lift.enQueue(chair1);
		gad2Lift.enQueue(chair2);
		gad2Lift.enQueue(chair3);
		gad2Lift.enQueue(chair4);
		gad2Lift.enQueue(chair5);
	}

	private void unloadLift() {
		while (gad2Lift.size() != 0) {
			Gad2Chair chair = gad2Lift.deQueue();
			System.out.println(chair.listChairRiders());
		}
	}

	class Gad2Chair {
		private String seat1Name;
		private String seat2Name;

		public Gad2Chair(String skierInFirstSeat, String skierInSecondSeat) {
			this.seat1Name = skierInFirstSeat;
			this.seat2Name = skierInSecondSeat;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((seat1Name == null) ? 0 : seat1Name.hashCode());
			result = prime * result + ((seat2Name == null) ? 0 : seat2Name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Gad2Chair other = (Gad2Chair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (seat1Name == null) {
				if (other.seat1Name != null)
					return false;
			} else if (!seat1Name.equals(other.seat1Name))
				return false;
			if (seat2Name == null) {
				if (other.seat2Name != null)
					return false;
			} else if (!seat2Name.equals(other.seat2Name))
				return false;
			return true;
		}

		public String listChairRiders() {
			return this.seat1Name + ", " + this.seat2Name;
		}

		private SnowBirdLiftQueue getOuterType() {
			return SnowBirdLiftQueue.this;
		}
	}
}
