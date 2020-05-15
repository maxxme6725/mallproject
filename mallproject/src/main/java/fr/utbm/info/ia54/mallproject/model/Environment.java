package fr.utbm.info.ia54.mallproject.model;

import java.util.HashSet;
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
	
	public void initWalls()
	{
		walls=new HashSet<Line>();
        Line wall;
        
        //Around the mall
        wall=new Line();
        wall.setStartX(250);
        wall.setStartY(50);
        wall.setEndX(250);
        wall.setEndY(700);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line();
        wall.setStartX(250);
        wall.setStartY(700);
        wall.setEndX(700);
        wall.setEndY(700);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line();
        wall.setStartX(800);
        wall.setStartY(700);
        wall.setEndX(900);
        wall.setEndY(700);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line();
        wall.setStartX(900);
        wall.setStartY(700);
        wall.setEndX(900);
        wall.setEndY(50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line();
        wall.setStartX(900);
        wall.setStartY(50);
        wall.setEndX(450);
        wall.setEndY(50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line();
        wall.setStartX(350);
        wall.setStartY(50);
        wall.setEndX(250);
        wall.setEndY(50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        //Top exit
        wall=new Line();
        wall.setStartX(350);
        wall.setStartY(0);
        wall.setEndX(350);
        wall.setEndY(50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        wall=new Line();
        wall.setStartX(450);
        wall.setStartY(0);
        wall.setEndX(450);
        wall.setEndY(50);
        wall.setFill(Color.BLACK);
        walls.add(wall);
        
        //Bottom exit
        wall=new Line();
        wall.setStartX(800);
        wall.setStartY(700);
        wall.setEndX(800);
        wall.setEndY(750);
        wall.setFill(Color.BLACK);
        walls.add(wall);

        wall=new Line();
        wall.setStartX(700);
        wall.setStartY(700);
        wall.setEndX(700);
        wall.setEndY(750);
        wall.setFill(Color.BLACK);
        walls.add(wall);
	}
	
	public void initStores()
	{
		stores=new HashSet<Rectangle>();
    	Rectangle store;
    	int storeSize=50;
    	Color storeColor=Color.DEEPSKYBLUE;
    	
    	int i, j;
    	for(i=0;i<3;i++)
    	{
    		for(j=0;j<2;j++)
        	{
                store=new Rectangle();
                store.setX(300+500*j);
                store.setWidth(storeSize);
                store.setY(100+250*i);
                store.setHeight(storeSize);
                store.setFill(storeColor);
                stores.add(store);
        	}
    	}
	}
	
	public void initExits()
	{
		exits=new HashSet<Rectangle>();
    	Rectangle exit;
    	
    	Color exitColor=Color.PINK;
    	int exitWidth=100;
    	int exitHeight=50;


        exit=new Rectangle();
        exit.setX(350);
        exit.setWidth(exitWidth);
        exit.setY(0);
        exit.setHeight(exitHeight);
        exit.setFill(exitColor);
        exits.add(exit);

        exit=new Rectangle();
        exit.setX(700);
        exit.setWidth(exitWidth);
        exit.setY(700);
        exit.setHeight(exitHeight);
        exit.setFill(exitColor);
        exits.add(exit);
	}
	
	public void initPillars()
	{
		pillars=new HashSet<Circle>();
		Circle pillar;
		
		Color pillarColor=Color.GRAY;
		int pillarRadius=10;


    	int i,j;
    	for(i=0;i<2;i++)
    	{
    		for(j=0;j<2;j++)
    		{
    			pillar=new Circle();
    			pillar.setCenterX(450+250*i);
    			pillar.setCenterY(250+250*j);
    			pillar.setRadius(pillarRadius);
    			pillar.setFill(pillarColor);
    			pillars.add(pillar);
    		}
    	}
	}
	
	public void initBenches()
	{
		benches=new HashSet<Rectangle>();
		Rectangle bench;
		
		Color benchColor=Color.GRAY;

		bench=new Rectangle();
		bench.setX(550);
		bench.setWidth(50);
		bench.setY(75);
		bench.setHeight(25);
		bench.setFill(benchColor);
		benches.add(bench);
		
		bench=new Rectangle();
		bench.setX(550);
		bench.setWidth(50);
		bench.setY(650);
		bench.setHeight(25);
		bench.setFill(benchColor);
		benches.add(bench);
	}
	
	public void initBeacons()
	{
		beacons=new HashSet<Rectangle>();
		//idk what to put here yet
	}
	
	public void initAgents()
	{
		agents=new LinkedList<AgentRepresentation>();
		//Further agents will be spawned and updated in MainAgent
		
		Point2D agentPos = new Point2D(5, 3);
		Point2D wallBegin = new Point2D(1, 2);
		Point2D wallEnd = new Point2D(1, 4);

		Point2D p = this.wallProjection(agentPos, wallBegin, wallEnd);

		System.out.println("#############################");
		System.out.println("" + p.getX() + " " + p.getY());
		System.out.println("#############################");
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
		
		return wallProjection(agentPos, wallBegin, wallEnd);
	}
	
	public Point2D wallProjection(Point2D agentPos, Point2D wallBegin, Point2D wallEnd)
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
		
		if(prod3 >= prod4 && prod3 >= 0.0)
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
	
}
