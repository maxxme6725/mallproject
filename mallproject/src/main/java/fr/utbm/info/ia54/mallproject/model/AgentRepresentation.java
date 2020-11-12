package fr.utbm.info.ia54.mallproject.model;

import java.util.LinkedList; 
import java.util.List;
import java.util.UUID;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class AgentRepresentation {
	
	private UUID id; //Contains the UUID of the agent this class represents
	private Circle circle; //Contains position, radius, color... Everything needed for display
	private List<Point2D> objectives; //List of shops the agent wants to visit before leaving
	
	
	public AgentRepresentation(UUID id, Circle circle, List<Point2D> objectives) {
		this.id = id;
		this.circle = circle;
		this.objectives = objectives;
	}
	
	public AgentRepresentation(AgentRepresentation ar)
	{
		this.id=null;
		
		this.circle=new Circle();
		this.circle.setCenterX(ar.getCircle().getCenterX());
		this.circle.setCenterY(ar.getCircle().getCenterY());
		this.circle.setRadius(ar.getCircle().getRadius());
		this.circle.setFill(ar.getCircle().getFill());
		
		this.objectives=ar.objectives;
	}
	
	public AgentRepresentation() 
	{
		this.id=null;
		this.circle=new Circle();
		this.objectives=new LinkedList<Point2D>();
	}



	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public List<Point2D> getObjectives() {
		return objectives;
	}
	public void setObjectives(List<Point2D> objectives) {
		this.objectives = objectives;
	}
	
	
	public double getX() {
		return circle.getCenterX();
	}
	public double getY() {
		return circle.getCenterY();
	}

}