package fr.utbm.info.ia54.mallproject.model;

import javafx.scene.text.Text;

public class Metrics
{
	private Integer activeAgents;		//
	private Integer spawnedAgents;		//
	private Integer simultaneousAgents;	//Agents on the screen at once
	private Integer totalAgents;		//Total amount of agents to spawn
	
	private Text display;
	
	public Metrics(Integer simultaneousAgents, Integer totalAgents)
	{
		activeAgents=0;
		this.simultaneousAgents=simultaneousAgents;
		spawnedAgents=0;
		this.totalAgents=totalAgents;
		display=new Text();
		display.setX(925);
		display.setY(25);
	}
	
	public Text getMetrics()
	{
		updateDisplay();
		return this.display;
	}
	
	public void updateDisplay()
	{
		display.setText("\n\n"
				+ "Agents active : " + activeAgents + "/" + simultaneousAgents + ".\n"
				+ "Agents spawned : " + spawnedAgents + "/" + totalAgents + ".\n");
	}

	
	
	
	
	
	
	
	

	
	
	public Integer getActiveAgents() {
		return activeAgents;
	}

	public void setActiveAgents(Integer activeAgents) {
		this.activeAgents = activeAgents;
	}

	public Integer getSpawnedAgents() {
		return spawnedAgents;
	}

	public void setSpawnedAgents(Integer spawnedAgents) {
		this.spawnedAgents = spawnedAgents;
	}

	public Integer getSimultaneousAgents() {
		return simultaneousAgents;
	}

	public void setSimultaneousAgents(Integer simultaneousAgents) {
		this.simultaneousAgents = simultaneousAgents;
	}

	public Integer getTotalAgents() {
		return totalAgents;
	}

	public void setTotalAgents(Integer totalAgents) {
		this.totalAgents = totalAgents;
	}

	public Text getDisplay() {
		return display;
	}

	public void setDisplay(Text display) {
		this.display = display;
	}
	
	
}
