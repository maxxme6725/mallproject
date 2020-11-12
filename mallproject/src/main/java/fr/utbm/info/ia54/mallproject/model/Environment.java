package fr.utbm.info.ia54.mallproject.model;

import java.util.HashSet; 
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Environment {
	
	private Set<Line> walls;
	private Set<Rectangle> stores;
	private Set<Rectangle> exits;
	private Set<Rectangle> beacons;
	private List<AgentRepresentation> agents;
	private Set<Circle> pillars;
	private Set<Rectangle> benches;
	
	//It could have been a good idea to have rectangles be a class containing rectangle + name instead
	//But the project is almost done at this point so Im not gonna bother

	public Environment(boolean pillars, boolean benches)
	{
		initWalls();
		initStores();
		initExits();
		initBeacons();
		initAgents();
		
		if(pillars)
		{
			initPillars();
		}
		else
		{
			this.pillars=new HashSet<Circle>();
		}
		
		if(benches)
		{
			initBenches();
		}
		else
		{
			this.benches=new HashSet<Rectangle>();
		}
		
	}
	
	public void initShoppingMallWalls()
	{
		Line wall;
		
		//walls
        wall=new Line(50, 50, 50, 500);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(50, 600, 50, 800);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(50, 800, 400, 800);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(500, 800, 900, 800);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(900, 800, 900, 500);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(900, 400, 900, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(900, 50, 800, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(700, 50, 350, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(250, 50, 50, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        //exits walls
        
        // north 1
        wall=new Line(250, 0, 250, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(350, 0, 350, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        // north 2

        wall=new Line(700, 0, 700, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(800, 0, 800, 50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        //east
        
        wall=new Line(900, 400, 950, 400);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(900, 500, 950, 500);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        // south
        wall=new Line(400, 800, 400, 850);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(500, 800, 500, 850);
        wall.setFill(Color.BLACK);
        walls.add(wall); 
        
        // west
        
        wall=new Line(50, 500, 0, 500);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line(50, 600, 0, 600);
        wall.setFill(Color.BLACK);
        walls.add(wall); 
        
        
	}
	
	public void initShopsWalls()
	{
		Line wall;
		
		/////////////////
		
		wall=new Line(200, 50, 200, 100);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 150, 200, 200);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 200, 175, 225);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(175, 225, 120, 225);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(80, 225, 50, 225);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		 
		/////////////////
		
		wall=new Line(50, 300, 200, 300);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 300, 200, 350);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 400, 200, 450);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 450, 50, 450);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(50, 625, 100, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(150, 625, 200, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 625, 200, 700);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 700, 50, 700);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 700, 200, 730);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 770, 200, 800);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		wall=new Line(275, 800, 275, 700);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(275, 650, 275, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(275, 625, 375, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(375, 625, 375, 700);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(375, 750, 375, 800);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(200, 490, 250, 490);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 490, 190, 500);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(190, 500, 190, 520);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(190, 550, 190, 560);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(190, 560, 200, 570);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(200, 570, 250, 570);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(250, 570, 260, 560);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(260, 560, 260, 500);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(260, 500, 250, 490);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(520, 750, 520, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(520, 625, 600, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(650, 625, 700, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(700, 750, 700, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(650, 750, 520, 750);
		wall.setFill(Color.BLACK);
		walls.add(wall);

		/////////////////
		
		wall=new Line(700, 750, 775, 750);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(825, 750, 850, 750);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(850, 750, 850, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(850, 625, 750, 625);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(810, 50, 810, 80);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(810, 120, 810, 150);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(810, 150, 900, 150);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(810, 150, 810, 230);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(810, 270, 810, 300);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(810, 300, 900, 300);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(810, 300, 810, 350);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(810, 380, 810, 390);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(810, 390, 900, 390);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(380, 50, 380, 120);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(380, 120, 390, 130);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(390, 130, 430, 130);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(460, 130, 620, 130);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(650, 130, 680, 130);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(680, 130, 690, 120);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(690, 120, 690, 50);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(650, 500, 700, 500);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(730, 500, 750, 500);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(750, 500, 750, 400);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(750, 400, 650, 400);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(650, 400, 650, 500);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////
		
		wall=new Line(650, 400, 650, 270);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(650, 270, 750, 270);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(750, 300, 750, 400);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		/////////////////center
		
		wall=new Line(370, 290, 400, 290);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(450, 290, 590, 290);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(590, 290, 590, 310);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(590, 350, 590, 440);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(370, 470, 450, 470);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(480, 470, 590, 470);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(370, 470, 370, 290);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(480, 290, 480, 470);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(480, 350, 590, 350);
		wall.setFill(Color.BLACK);
		walls.add(wall);
		
		wall=new Line(370, 400, 480, 400);
		wall.setFill(Color.BLACK);
		walls.add(wall);
	}
	
	public void initWalls()
	{
		walls=new HashSet<Line>();
        
        initShoppingMallWalls();
        initShopsWalls();
	}
	
	public void initStores()
	{
		stores=new HashSet<Rectangle>();
    	int storeSize=20;
    	Color storeColor=Color.DEEPSKYBLUE;
    	
    	Rectangle store;
    	
    	store = new Rectangle(80, 80, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(525, 60, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(860, 95, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(860, 180, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(860, 320, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(670, 360, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(670, 410, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(780, 680, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(600, 680, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(310, 760, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(60, 745, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(115, 670, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(215, 520, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(60, 370, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(400, 370, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(390, 420, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(500, 370, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
    	
    	store = new Rectangle(500, 310, storeSize, storeSize);
    	store.setFill(storeColor);
    	stores.add(store);
	}
	
	public void initExits()
	{
		exits=new HashSet<Rectangle>();
    	Rectangle exit;
    	
    	Color exitColor=Color.PINK;
    	int exitWidth=100;
    	int exitHeight=50;

        exit=new Rectangle();
        exit.setX(250);
        exit.setWidth(exitWidth);
        exit.setY(0);
        exit.setHeight(exitHeight);
        exit.setFill(exitColor);
        exits.add(exit);

        exit=new Rectangle();
        exit.setX(700);
        exit.setWidth(exitWidth);
        exit.setY(0);
        exit.setHeight(exitHeight);
        exit.setFill(exitColor);
        exits.add(exit);
        
        exit=new Rectangle();
        exit.setX(900);
        exit.setWidth(exitHeight);
        exit.setY(400);
        exit.setHeight(exitWidth);
        exit.setFill(exitColor);
        exits.add(exit);
        
        exit=new Rectangle();
        exit.setX(400);
        exit.setWidth(exitWidth);
        exit.setY(800);
        exit.setHeight(exitHeight);
        exit.setFill(exitColor);
        exits.add(exit);
        
        exit=new Rectangle();
        exit.setX(0);
        exit.setWidth(exitHeight);
        exit.setY(500);
        exit.setHeight(exitWidth);
        exit.setFill(exitColor);
        exits.add(exit);
	}
	
	public void initPillars()
	{
		pillars=new HashSet<Circle>();
		Circle pillar;
		
		Color pillarColor=Color.GRAY;
		int pillarRadius=15;


    	int i,j;
    	for(i=0;i<2;i++)
    	{
    		for(j=0;j<2;j++)
    		{
    			pillar=new Circle();
    			pillar.setCenterX(325+250*i);
    			pillar.setCenterY(250+250*j);
    			pillar.setRadius(pillarRadius);
    			pillar.setFill(pillarColor);
    			pillars.add(pillar);
    		}
    	}
    	/* I dont like this pillar it looks ugly 
    	 * Imaging you enter a building and the first thing you see is a pillar in front of you
    	pillar=new Circle();
		pillar.setCenterX(450);
		pillar.setCenterY(700);
		pillar.setRadius(pillarRadius);
		pillar.setFill(pillarColor);
		pillars.add(pillar);
		*/
	}
	
	public void initBenches()
	{
		benches=new HashSet<Rectangle>();
		Rectangle bench;
		
		Color benchColor=Color.GRAY;

		bench=new Rectangle();
		bench.setX(510);
		bench.setWidth(50);
		bench.setY(135);
		bench.setHeight(25);
		bench.setFill(benchColor);
		benches.add(bench);
		
		bench=new Rectangle();
		bench.setX(75);
		bench.setWidth(50);
		bench.setY(455);
		bench.setHeight(25);
		bench.setFill(benchColor);
		benches.add(bench);
		
		bench=new Rectangle();
		bench.setX(775);
		bench.setWidth(50);
		bench.setY(595);
		bench.setHeight(25);
		bench.setFill(benchColor);
		benches.add(bench);
	}
	
	public void initBeacons()
	{
		beacons=new HashSet<Rectangle>();
		Rectangle beacon;

		Color beaconColor=Color.LIGHTGREEN;
		Color majorBeaconColor=Color.LIGHTCORAL;
    	int beaconSize=20;
    	
    	// Store numbers here are based on this image
    	// https://cdn.discordapp.com/attachments/691719686412566598/713328793640763502/carte.png
    	
    	//NorthWest Beacon
    	beacon = new Rectangle(275, 175, beaconSize, beaconSize);
    	beacon.setFill(majorBeaconColor);
    	beacons.add(beacon);
    	
    	//NorthEst Beacon
    	beacon = new Rectangle(725, 175, beaconSize, beaconSize);
    	beacon.setFill(majorBeaconColor);
    	beacons.add(beacon);
    	
    	//SouthWest Beacon
    	beacon = new Rectangle(275, 600, beaconSize, beaconSize);
    	beacon.setFill(majorBeaconColor);
    	beacons.add(beacon);
    	
    	//SouthEst Beacon
    	beacon = new Rectangle(725, 575, beaconSize, beaconSize);
    	beacon.setFill(majorBeaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 19 and 20 can have NorthWest and NorthEst as first beacon
    	
    	//Entrance 21 Beacon
    	beacon = new Rectangle(800, 450, beaconSize, beaconSize);
    	beacon.setFill(majorBeaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 22 Beacon
    	beacon = new Rectangle(425, 550, beaconSize, beaconSize);
    	beacon.setFill(majorBeaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 23 Beacon
    	beacon = new Rectangle(70, 530, beaconSize, beaconSize);
    	beacon.setFill(majorBeaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 1 to store 1
    	beacon = new Rectangle(90, 240, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 2 to store 1
    	beacon = new Rectangle(210, 120, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 1 to store 2
    	beacon = new Rectangle(415, 140, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 2 to store 2
    	beacon = new Rectangle(645, 140, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 3
    	beacon = new Rectangle(785, 90, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 4
    	beacon = new Rectangle(785, 250, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 5
    	beacon = new Rectangle(785, 360, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 6
    	beacon = new Rectangle(755, 265, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 7
    	beacon = new Rectangle(720, 505, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 1 to store 8
    	beacon = new Rectangle(710, 605, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 1 to store 8
    	beacon = new Rectangle(800, 755, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 1 to store 9
    	beacon = new Rectangle(615, 605, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);

    	//Entrance 2 to store 9
    	beacon = new Rectangle(675, 755, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 1 to store 10
    	beacon = new Rectangle(250, 635, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance 2 to store 10
    	beacon = new Rectangle(380, 690, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 11
    	beacon = new Rectangle(205, 735, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 12
    	beacon = new Rectangle(120, 600, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 13
    	beacon = new Rectangle(160, 530, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 14
    	beacon = new Rectangle(205, 360, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 15
    	beacon = new Rectangle(410, 265, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 16
    	beacon = new Rectangle(475, 475, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 17
    	beacon = new Rectangle(600, 460, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
    	
    	//Entrance to store 18
    	beacon = new Rectangle(600, 315, beaconSize, beaconSize);
    	beacon.setFill(beaconColor);
    	beacons.add(beacon);
		
		
	}
	
	public void initAgents()
	{
		agents=new LinkedList<AgentRepresentation>();
		//Further agents will be spawned and updated in MainAgent
	}
	
	
	//Getters & Setters
	
	public Set<Line> getWalls() {
		return walls;
	}

	public void setWalls(Set<Line> walls) {
		this.walls = walls;
	}

	public Set<Rectangle> getStores() {
		return stores;
	}

	public void setStores(Set<Rectangle> stores) {
		this.stores = stores;
	}

	public Set<Rectangle> getExits() {
		return exits;
	}

	public void setExits(Set<Rectangle> exits) {
		this.exits = exits;
	}

	public Set<Rectangle> getBeacons() {
		return beacons;
	}

	public void setBeacons(Set<Rectangle> beacons) {
		this.beacons = beacons;
	}

	public List<AgentRepresentation> getAgents() {
		return agents;
	}

	public void setAgents(List<AgentRepresentation> agents) {
		this.agents = agents;
	}

	public Set<Circle> getPillars() {
		return pillars;
	}

	public void setPillars(Set<Circle> pillars) {
		this.pillars = pillars;
	}

	public Set<Rectangle> getBenches() {
		return benches;
	}

	public void setBenches(Set<Rectangle> benches) {
		this.benches = benches;
	}
	
	public boolean updateAgent(UUID id, Circle pos, List<Point2D> objs) //Returns false if there is an error in the new position
	{
		boolean valid=true;
		
		for(AgentRepresentation agent : agents)
		{
			if(agent.getId()!=id && Math.abs(agent.getCircle().getCenterX()-pos.getCenterX())<5 && Math.abs(agent.getCircle().getCenterY()-pos.getCenterY())<5)
			{
				valid=false;
			}
			
			if(agent.getId()==id) //We update even if the position is invalid, but we say it's invalid in the console
			{
				agent.setCircle(pos);
				agent.setObjectives(objs);
			}
		}
		
		return valid;
	}
	
	public void removeAgent(UUID id)
	{
		AgentRepresentation theAgent=new AgentRepresentation();
		for(AgentRepresentation agent : agents)
		{
			if(agent.getId()==id) //We update even if the position is invalid, but we say it's invalid in the console
			{
				theAgent=agent;
			}
		}
		agents.remove(theAgent);
	}
	
	public AgentRepresentation getAgent(UUID id)
	{
		AgentRepresentation theAgent=new AgentRepresentation();
		for(AgentRepresentation agent : agents)
		{
			if(agent.getId()==id) //We update even if the position is invalid, but we say it's invalid in the console
			{
				theAgent=agent;
			}
		}
		return theAgent;
	}
	
	public Point2D wallProjection(AgentRepresentation ar, Line wall)
	{
		Point2D agentPos = new Point2D(ar.getCircle().getCenterX(), ar.getCircle().getCenterY());
		Point2D wallBegin = new Point2D(wall.getStartX(), wall.getStartY());
		Point2D wallEnd = new Point2D(wall.getEndX(), wall.getEndY());
		
		return projectOnWall(agentPos, wallBegin, wallEnd);
	}
	
	public Point2D projectOnWall(Point2D agentPos, Point2D wallBegin, Point2D wallEnd)
	{
		// determining a steering vector of the wall line
		
		Point2D steeringVector = new Point2D(wallEnd.getX() - wallBegin.getX(), wallEnd.getY() - wallBegin.getY());
		
		// vector which will be projected
		Point2D u = new Point2D(agentPos.getX() -  wallBegin.getX(), agentPos.getY() -  wallBegin.getY());
		
		//System.out.println("u" + u.getX() + " " + u.getY());
		//System.out.println("steeringVector" + steeringVector.getX() + " " + steeringVector.getY());
		
		double prod1 = steeringVector.getX() * u.getX() + steeringVector.getY() * u.getY();
		double prod2 = (steeringVector.getX()*steeringVector.getX()) + (steeringVector.getY()*steeringVector.getY());
		
		//System.out.println("p1 : " + prod1 + " p2:" + prod2);
		
		Point2D vectorProjection = steeringVector.multiply(prod1/prod2);
		Point2D projectedPoint = vectorProjection.add(wallBegin);
		
		Point2D wall = new Point2D(wallEnd.getX() - wallBegin.getX(), wallEnd.getY() - wallBegin.getY());
		
		double prod3 = vectorProjection.getX() * wall.getX() + vectorProjection.getY() * wall.getY();
		double prod4 = vectorProjection.getX() * vectorProjection.getX() + vectorProjection.getY() * vectorProjection.getY();
		
		if(prod3 > prod4 && prod3 > 0.1)
			return projectedPoint;
		else 
			return new Point2D(0, 0);
	}
	
	public List<Point2D> buildObstacleList(AgentRepresentation ar, double visionDistance)
	{
		List<Point2D> obsList = new LinkedList<Point2D>();
		List<Line> benchLines = new LinkedList<Line>();
		Line benchLine;
		
		Point2D agentCoord=new Point2D(ar.getCircle().getCenterX(), ar.getCircle().getCenterY());
		
		for(Line wall : walls)
		{
			if(wallProjection(ar, wall)!=null && wallProjection(ar, wall).distance(agentCoord)<visionDistance)
			{
				obsList.add(wallProjection(ar, wall));
			}
		}
		
		for(AgentRepresentation agent : agents)
		{
			if(agent.getId()!=ar.getId())
			{
				if(Math.pow(
						Math.pow(agent.getCircle().getCenterX()-ar.getCircle().getCenterX(),2) + 
						Math.pow(agent.getCircle().getCenterY()-ar.getCircle().getCenterY(),2), 0.5)<visionDistance)
				{
					obsList.add(new Point2D(agent.getCircle().getCenterX(), agent.getCircle().getCenterY()));
				}
			}
		}
		
		for(Circle pillar : pillars)
		{
			if(Math.pow(
					Math.pow(pillar.getCenterX()-ar.getCircle().getCenterX(),2) + 
					Math.pow(pillar.getCenterY()-ar.getCircle().getCenterY(),2), 0.5)<visionDistance)
			{
				obsList.add(new Point2D(pillar.getCenterX(), pillar.getCenterY()));
			}
		}
		
		for(Rectangle bench : benches)
		{
			//top line
			benchLine = new Line();
			benchLine.setStartX(bench.getX());
			benchLine.setStartY(bench.getY());
			benchLine.setEndX(bench.getX()+bench.getWidth());
			benchLine.setEndY(bench.getY());
			benchLines.add(benchLine);
			
			//left line
			benchLine = new Line();
			benchLine.setStartX(bench.getX());
			benchLine.setStartY(bench.getY());
			benchLine.setEndX(bench.getX());
			benchLine.setEndY(bench.getY()+bench.getHeight());
			benchLines.add(benchLine);
			
			//right line
			benchLine = new Line();
			benchLine.setStartX(bench.getX()+bench.getWidth());
			benchLine.setStartY(bench.getY()+bench.getHeight());
			benchLine.setEndX(bench.getX()+bench.getWidth());
			benchLine.setEndY(bench.getY());
			benchLines.add(benchLine);
			
			//bottom line
			benchLine = new Line();
			benchLine.setStartX(bench.getX()+bench.getWidth());
			benchLine.setStartY(bench.getY()+bench.getHeight());
			benchLine.setEndX(bench.getX());
			benchLine.setEndY(bench.getY()+bench.getHeight());
			benchLines.add(benchLine);
		}
		for(Line bLine : benchLines)
		{
			if(wallProjection(ar, bLine)!=null && wallProjection(ar, bLine).distance(agentCoord)<visionDistance)
			{
				obsList.add(wallProjection(ar, bLine));
			}
		}
		
		return obsList;
	}
	
	public boolean agentInSquare(double agentX, double agentY, double x, double y, double sampleSquareWidth, double sampleSquareHeight)
	{
		// the agent is considered as point and not a circle for this calculation : the error is very small and does not influence the density significantly
		boolean a = (agentX >= x);
		boolean b = (agentX < (x + sampleSquareWidth));
		boolean c = (agentY >= y);
		boolean d = (agentY < (y + sampleSquareHeight));
		
		if(a && b && c && d)
			return true;
		else
			return false;
	}
	
	
	public double computeDensity()
	{
		// The idea is to cut the map into a grid, and to compute the mean value of the density of each square of the grid
		
		int mallWidth = 850;
		int mallHeight = 750;
		
		int sampleSquareWidth = 85;
		int sampleSquareHeight = 170;
		
		int squareArea = sampleSquareWidth*sampleSquareHeight;
		
		double density = 0.0;
		
		// coordinates of the sample square left top corner
		int x = 50;//initial values
		int y = 50;
		
		int nbAgentsInSquare;
		
		//deep copy of the list of agents (used below to avoid checking agents which has already been tested)
		
		List<AgentRepresentation> agentsToTest = new LinkedList<AgentRepresentation>();
		
		for(AgentRepresentation a : agents)
		{
			agentsToTest.add(a);
		}
		
		while(y < mallHeight && !agentsToTest.isEmpty())
		{	
			nbAgentsInSquare = 0;
		
			Iterator<AgentRepresentation> it = agentsToTest.iterator();
			
			while(it.hasNext())
			{
				AgentRepresentation a = it.next();
				
				if(agentInSquare(a.getX(), a.getY(), x, y, sampleSquareWidth, sampleSquareHeight))
				{
					nbAgentsInSquare++;
					it.remove();
				}
			}
			
			/* 
			  agents width is 5px
			  A human is 40cm large in average
			  So 1px <==> 8cm = 0.08m
			*/
			
			density += nbAgentsInSquare / (squareArea*0.08*0.08);
				
			x += sampleSquareWidth;
			
			if(x > mallWidth && y < mallHeight)
			{
				x = 50; // next line
				y += sampleSquareHeight;
			}
		}
		
		int nbSquares = (mallWidth/sampleSquareWidth) * (mallHeight/sampleSquareHeight); 
		
		density /= nbSquares;
		
		return density;
	}
	
}
