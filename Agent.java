import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Agent {

	private int agentID;
	private int x, y, radius, velX, velY, stepCount, numFound;
	private int frameX, frameY;
	private String color;
	private Message broadcast;
<<<<<<< HEAD
	boolean isActive, won, isDiverting, willListen, lies;
=======
	private Random rand = new Random();
	boolean isActive, won, isDiverting;
>>>>>>> e45a93c5313e6d2e12e0f5e6d5ea7f24acc8f303

	private ArrayList<Node> targets = new ArrayList<Node>(); // found targets go here
	private ArrayList<Coordinate> undiscovered = new ArrayList<Coordinate>();
	private ArrayList<Double> happys = new ArrayList<Double>(); // happiness go here
	private Stack<Coordinate> path = new Stack<Coordinate>(); // path coordinates go here
	private Queue<Message> inbox = new LinkedList<Message>(); // direct messages go here
	private Coordinate currentTarget;

	public Agent(int agentID, int frameX, int frameY) {
		this.agentID = agentID;
		this.frameX = frameX;
		this.frameY = frameY;
		radius = 10; // radar radius
		numFound = stepCount = 0;
		spawn();
		setupPath(Simulation.mode);

		isActive = true;
	}

	public void spawn() {
		// randomly generate location
		x = ThreadLocalRandom.current().nextInt(0, frameX / 10 - 2 * radius);
		y = ThreadLocalRandom.current().nextInt(0, frameY / 10 - 2 * radius);
	}

	public void setupPath(int mode) {
		// set color and create path in reverse
		currentTarget = new Coordinate(0, 0); // set mode 1 start
		path.push(new Coordinate(0, 0)); // end
		switch (agentID) {
			case 0:
				color = "GREEN";
				break;
			case 1:
				color = "BLUE";
				break;
			case 2:
				color = "BLACK";
				break;
			case 3:
				color = "ORANGE";
				break;
			case 4:
				color = "RED";
				break;
		}
		generateUndiscovered();
		generatePath(Simulation.mode);
	}

	public void generateUndiscovered(){
		for (int i = 0; i <= 100; i+=20) {
			for (int j = 0; j <= 100; j += 20) {
				undiscovered.add(new Coordinate(i, j));
			}
		}
	}

	public void generatePath(int mode) {

<<<<<<< HEAD
		if (mode == 0) {
			//add path to stack in reverse inorder to unstack it normally
			path.add(new Coordinate(0, 0)); // top left
			path.add(new Coordinate(100, 0));
			path.add(new Coordinate(100, 20));
			path.add(new Coordinate(20, 20));
			path.add(new Coordinate(20, 40));
			path.add(new Coordinate(100, 40));
			path.add(new Coordinate(100, 60));
			path.add(new Coordinate(20, 60));
			path.add(new Coordinate(20, 80));
			path.add(new Coordinate(100, 80));
			path.add(new Coordinate(100, 100));
			path.add(new Coordinate(0, 100)); // bottom left
=======
		if (true) {
			switch (agentID) {
				//Jasindan
				case 0:
					// add path to stack in reverse inorder to unstack it normally
					path.add(new Coordinate(0, 0)); // top left
					path.add(new Coordinate(100, 0));
					path.add(new Coordinate(100, 20));
					path.add(new Coordinate(20, 20));
					path.add(new Coordinate(20, 40));
					path.add(new Coordinate(100, 40));
					path.add(new Coordinate(100, 60));
					path.add(new Coordinate(20, 60));
					path.add(new Coordinate(20, 80));
					path.add(new Coordinate(100, 80));
					path.add(new Coordinate(100, 100));
					path.add(new Coordinate(0, 100)); // bottom left
					break;
				//Amal
				case 1:
					while (undiscovered.size() != 0) {
						int n = rand.nextInt(undiscovered.size());
						path.add(undiscovered.get(n));
						undiscovered.remove(n);
					}
					break;
			}
>>>>>>> e45a93c5313e6d2e12e0f5e6d5ea7f24acc8f303
		}

		// scenario 2 and 3 path
		else {
			switch (agentID) {
<<<<<<< HEAD
			case 0:
				path.add(new Coordinate(50, 50)); // back to center
				path.add(new Coordinate(0, 0));
				path.add(new Coordinate(100, 0));
				path.add(new Coordinate(100, 100));
				path.add(new Coordinate(0, 100));
				path.add(new Coordinate(90, 10));
				currentTarget = new Coordinate(10, 10); // start
				break;
			case 1:
				path.add(new Coordinate(44, 44)); // back to center
				path.add(new Coordinate(0, 100));
				path.add(new Coordinate(0, 0));
				path.add(new Coordinate(100, 0));
				path.add(new Coordinate(100, 100));
				path.add(new Coordinate(10, 30));
				currentTarget = new Coordinate(90, 30); // start
				break;
			case 2:
				path.add(new Coordinate(56, 44)); // back to center
				path.add(new Coordinate(100, 100));
				path.add(new Coordinate(0, 100));
				path.add(new Coordinate(0, 0));
				path.add(new Coordinate(100, 0));
				path.add(new Coordinate(90, 50));
				currentTarget = new Coordinate(10, 50); // start
				break;
			case 3:
				path.add(new Coordinate(44, 54)); // back to center
				path.add(new Coordinate(100, 0));
				path.add(new Coordinate(100, 100));
				path.add(new Coordinate(0, 100));
				path.add(new Coordinate(0, 0));
				path.add(new Coordinate(10, 70));
				currentTarget = new Coordinate(90, 70); // start
				break;
			case 4:

				path.add(new Coordinate(54, 54)); // back to center
				path.add(new Coordinate(0, 0));
				path.add(new Coordinate(100, 100));
				path.add(new Coordinate(0, 100));
				path.add(new Coordinate(0, 100));
				path.add(new Coordinate(90, 90)); // end
				currentTarget = new Coordinate(10, 90); // start
				break;
=======
				case 0:
					path.add(new Coordinate(50, 50)); // back to center
					path.add(new Coordinate(0, 0));
					path.add(new Coordinate(100, 0));
					path.add(new Coordinate(100, 100));
					path.add(new Coordinate(0, 100));
					path.add(new Coordinate(90, 10));
					currentTarget = new Coordinate(10, 10); // start
					break;
				case 1:
					path.add(new Coordinate(44, 44)); // back to center
					path.add(new Coordinate(0, 100));
					path.add(new Coordinate(0, 0));
					path.add(new Coordinate(100, 0));
					path.add(new Coordinate(100, 100));
					path.add(new Coordinate(10, 30));
					currentTarget = new Coordinate(90, 30); // start
					break;
				case 2:
					path.add(new Coordinate(56, 44)); // back to center
					path.add(new Coordinate(100, 100));
					path.add(new Coordinate(0, 100));
					path.add(new Coordinate(0, 0));
					path.add(new Coordinate(100, 0));
					path.add(new Coordinate(90, 50));
					currentTarget = new Coordinate(10, 50); // start
					break;
				case 3:
					path.add(new Coordinate(44, 54)); // back to center
					path.add(new Coordinate(100, 0));
					path.add(new Coordinate(100, 100));
					path.add(new Coordinate(0, 100));
					path.add(new Coordinate(0, 0));
					path.add(new Coordinate(10, 70));
					currentTarget = new Coordinate(90, 70); // start
					break;
				case 4:
					path.add(new Coordinate(54, 54)); // back to center
					path.add(new Coordinate(0, 0));
					path.add(new Coordinate(100, 100));
					path.add(new Coordinate(0, 100));
					path.add(new Coordinate(0, 100));
					path.add(new Coordinate(90, 90)); // end
					currentTarget = new Coordinate(10, 90); // start
					break;
>>>>>>> e45a93c5313e6d2e12e0f5e6d5ea7f24acc8f303
			}
		}
	}

	public void setDirection() {
		// decide left, right or none
		if (x > currentTarget.getX())
			velX = -1;
		else if (x < currentTarget.getX())
			velX = 1;
		else
			velX = 0;

		// decide up, down or none
		if (y > currentTarget.getY())
			velY = -1;
		else if (y < currentTarget.getY())
			velY = 1;
		else
			velY = 0;
	}

	public void move() {
		// if we have reached the current target
		if (x == currentTarget.getX() && y == currentTarget.getY()) {
			if (!path.isEmpty()) {
				// get next in line, pop it from stack
				currentTarget = path.pop();
				if (isDiverting)
					isDiverting = false;
			}
		}

		for(int i = 0; i <  path.size(); i++){
			if (x == path.get(i).getX() && y == path.get(i).getY()){
				path.remove(i);
			}
		}

		setDirection(); // set the direction

		// move agent normally
		x += velX;
		y += velY;

		if (velX != 0) {
			stepCount++;
			addHappinessValue();
		}
		if (velY != 0) {
			stepCount++;
			addHappinessValue();
		}
	}

	// if 2 agents collide, 1 diverts
	public void divertPath(Coordinate c) {
		isDiverting = true;
		path.add(currentTarget); // add current target to path again
		currentTarget = c; // change current target to diverting path
		setDirection(); // change direction according to new target
	}

	// if agent learns of a target location, sidetrack
	public void sideTrack(Coordinate c) {
		path.add(currentTarget); // add current target to path again
		if (Simulation.mode == 1)
			path.add(new Coordinate(x, y)); // add current location to path, only needed for mode 2
		currentTarget = c; // change current target to target that was given
		setDirection();
	}

	public void checkInbox() {
		// if inbox isn't empty and the agent will listen, side track current path to new target
		if (!inbox.isEmpty()  && getListenAttribute()) {
			for (int i = 0; i < inbox.size(); i++) {
				sideTrack(inbox.remove().coordinate);
			}
		}
	}

	public void update() {

		checkInbox();
		move();

		// if we have won, no need to broadcast
		if (!won && targets.size() == 5) {
			broadcast = new Message(-1, "won", new Coordinate(x, y));
			won = true;
		}
	}

	public void draw(Graphics2D g2d) {
		// color code agents by rgb, 25% transparent
		switch (agentID) {
			case 0:
				g2d.setColor(new Color(0, 153, 51, 63));
				break;
			case 1:
				g2d.setColor(new Color(0, 102, 255, 63));
				break;
			case 2:
				g2d.setColor(new Color(0, 0, 0, 63));
				break;
			case 3:
				g2d.setColor(new Color(255, 102, 0, 63));
				break;
			case 4:
				g2d.setColor(new Color(255, 0, 0, 63));
				break;
		}
		// draw radar
		g2d.fillOval(x * 10 - radius * 10, y * 10 - radius * 10, 2 * radius * 10, 2 * radius * 10);

		// draw agent
		g2d.fillRect(x * 10 - radius / 2, y * 10 - radius / 2, 10, 10);
	}

	public int getAgentID() {
		return agentID;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public int getDiameter() {
		return 2 * radius;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public int getStepCount() {
		return stepCount;
	}

	public int getNumFound() {
		return numFound;
	}

	public void addHappinessValue() {
		happys.add((double) numFound / (stepCount + 1.0));
	}

	public double getHappiness() {
		return happys.get(happys.size() - 1);
	}

	public double getMaxHappiness() {
		return Collections.max(happys);
	}

	public double getMinHappiness() {
		return Collections.min(happys);
	}

	public double getAverageHappiness() {
		double total = 0;
		for (Double h : happys)
			total += (double) h;
		return total;
	}

	public double getVarianceHappiness() {
		double avg = getAverageHappiness(), temp = 0;
		for (Double d : happys)
			temp += (d - avg) * (d - avg);
		return temp / (happys.size() - 1);
	}

	public double getSTDHappiness() {
		return Math.sqrt(getVarianceHappiness());
	}

	public double getCompetitiveness() {
		if (getHappiness() == 0)
			return 0;
		return (getHappiness() - getMinHappiness()) / (getMaxHappiness() - getMinHappiness());
	}

	public boolean getListeningAbility() {
		return willListen;
	}

	public boolean getLyingAttribute() {
		return lies;
	}

	public void setLyingAttribute(boolean lie) {
		this.lies = lie;
	}

	public boolean getListenAttribute() {
		return willListen;
	}

	public void setListenAttribute(boolean listen) {
		this.willListen = listen;
	}

	public String getColor() {
		return color;
	}

	public String locationToString() {
		return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ArrayList<Node> getTargets() {
		return targets;
	}

	public void addTarget(Node target) {
		targets.add(target);
		numFound = targets.size();
	}

	public void addPath(Coordinate c) {
		path.add(c);
	}

	public Message getBroadcast() {
		return broadcast;
	}

	public void clearBroadcast() {
		broadcast = null;
	}

	public void addMessage(Message m) {
		System.out.print(m);
		inbox.add(m);
	}
}
