package fr.utbm.info.ia54.mallproject.view;

import fr.utbm.info.ia54.mallproject.StartWindow;
import fr.utbm.info.ia54.mallproject.model.AgentRepresentation;
import fr.utbm.info.ia54.mallproject.model.Environment;
import fr.utbm.info.ia54.mallproject.model.Metrics;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.application.Platform;

public class Display{
	
	private Environment environment;
	private Metrics metrics;
	
	public void changeDisplayFrameTitle(String title)
	{
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	StartWindow.getStage().setTitle(title);
            }
        });
	}
	
	public void changeDisplayFrameSize(Integer width, Integer height)
	{
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	StartWindow.getStage().setWidth(width);
            	StartWindow.getStage().setHeight(height);
            	StartWindow.getStage().centerOnScreen();
            }
        });
	}

    public void displaySimulationFrame() {

    	//I dont get it but somehow if I dont include the group stuff here I get errors in the console
    	Platform.runLater(new Runnable() {
            @Override
            public void run() {
    	
    	Group g = new Group();

    	g.getChildren().addAll(environment.getStores());
    	
    	g.getChildren().addAll(environment.getExits());
    	
    	//Beacons are invisible
        
    	g.getChildren().addAll(environment.getPillars());
    	
    	g.getChildren().addAll(environment.getBenches());
    	
    	g.getChildren().addAll(environment.getWalls());
    	
    	for(AgentRepresentation agent : environment.getAgents())
    	{
    		g.getChildren().add(agent.getCircle());
    	}
        
    	
    	
    	//Also display some metrics & stats
    	g.getChildren().addAll(metrics.getMetrics());
    	
    	
    	//Assuming stuff is already being displayed
        //stage.show();
    	
        Scene scene=new Scene(g, Screen.getPrimary().getBounds().getWidth()*3/4, Screen.getPrimary().getBounds().getHeight()*3/4);
        
        
            	StartWindow.getStage().setScene(scene);
            }
        });
    }

	public Display(Environment environment, Metrics metrics) {
		this.environment = environment;
		this.metrics = metrics;
	}
}