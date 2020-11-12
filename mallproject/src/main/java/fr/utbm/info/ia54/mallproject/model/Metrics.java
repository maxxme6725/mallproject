package fr.utbm.info.ia54.mallproject.model;

import java.io.File; 
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javafx.scene.text.Text;

public class Metrics
{
	private Integer activeAgents;				//Agents on screen
	private Integer simultaneousAgents;			//Max amount of agents on the screen
	private Integer spawnedAgents;				//Agents spawned
	private Integer totalAgents;				//Max amount of agents to spawn
	private Integer deadAgents;					//Amount of agents who died
	private Double density; 					//Density of the agents on screen
	private Long totalTimeAlive; 				//Time agents spent alive combined
	private Integer averageTimeAlive; 			//Average time agents spent alive
	private Integer crowdInfluence;
	private final Integer aloneAvrTime=106299;	//Based on simulating 1 agent 5000 times
	
	//These metrics are for the excel sheet
	private Calendar startTime;
	private List<Integer> deadAgentNow; //Helps for checking for dupes in the sheet
	private List<Long> clockTime;
	private List<Long> agentTime;
	private List<Integer> averageTime;
	private List<Double> densityMoment;
	
	private Text display;
	
	public Metrics(Integer simultaneousAgents, Integer totalAgents, Double density)
	{
		activeAgents=0;
		this.simultaneousAgents=simultaneousAgents;
		spawnedAgents=0;
		this.totalAgents=totalAgents;
		deadAgents=0;
		density=0.0;
		this.density=density;
		totalTimeAlive=0L;
		averageTimeAlive=0;

		startTime = Calendar.getInstance();
		deadAgentNow =new LinkedList<Integer>();
		clockTime=new LinkedList<Long>();
		agentTime=new LinkedList<Long>();
		averageTime=new LinkedList<Integer>();
		densityMoment=new LinkedList<Double>();
		
		display=new Text();
		display.setX(925);
		display.setY(25);
	}
	
	public void createExcelSheet()
	{
		try
		{
	        //Create excel
	        Workbook wb = new HSSFWorkbook(); 
	  
	        //Create excel tab
	        Sheet sheet = wb.createSheet("Results");
	        
	        // Specific row number 
	        Row row = sheet.createRow(1); 
	        
	        Cell cell=row.createCell(0);
	        
	        cell.setCellValue("|");
	  
	        // Specific cell number 
	        cell = row.createCell(1); 
	        
	        cell.setCellValue("Agents killed");
	  
	        // Specific cell number 
	        cell = row.createCell(2); 
	        
	        cell.setCellValue("Time elapsed when this agent left the store (in ms)");

	        cell = row.createCell(3); 
	        
	        cell.setCellValue("Time this agent spent in the store (in ms)");
	        
	        cell=row.createCell(4);
	        
	        cell.setCellValue("Average time agents spent in the store at this point in time (in ms)");
	        
	        cell=row.createCell(5);
	        
	        cell.setCellValue("Density of the crowd at this point in time (in customer per m²)");
	        
	        cell=row.createCell(6);
	        
	        cell.setCellValue("|");
	        
	        int i;
	        for(i=0;i<clockTime.size();i++)
	        {
	        	row=sheet.createRow(i+2);
	        	
	        	cell=row.createCell(1);
	        	cell.setCellValue(i+1);
	        	
	        	cell=row.createCell(2);
	        	cell.setCellValue(clockTime.get(i));
	        	
	        	cell=row.createCell(3);
	        	cell.setCellValue(agentTime.get(i));
	        	
	        	cell=row.createCell(4);
	        	cell.setCellValue(averageTime.get(i));
	        	
	        	cell=row.createCell(5);
	        	cell.setCellValue(densityMoment.get(i));
	        }
	        
	        //Create file to write the excel in
	        OutputStream file = new FileOutputStream("SimulationResults.xls"); 
	        
	        //Write to the file
	        wb.write(file);
	        
	        wb.close();
	        file.close();
	        
	        System.out.println("excel sheet successfully created");
		}
		catch(Exception e)
		{
			System.out.println("Error creating excel sheet");
		}
	}
	
	public Text getMetrics()
	{
		updateDisplay();
		return this.display;
	}
	
	public void updateDisplay()
	{
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    	symbols.setDecimalSeparator('.');
		DecimalFormat dec = new DecimalFormat("#0.0000", symbols);
    	double roundedDensity = Double.parseDouble(dec.format(density.doubleValue()));
    	
    	if(deadAgents!=0)
    	{
        	averageTimeAlive=(int) (totalTimeAlive/deadAgents);
        	crowdInfluence=averageTimeAlive-aloneAvrTime;
    	}
    	
    	if(deadAgents!=0)
    	{
    		display.setText("\n\n"
    				+"Metrics : " + "\n"
    				+ "Elapsed time : " + (Calendar.getInstance().getTime().getTime() - startTime.getTime().getTime())/1000 + " s\n"
    	    		+ "Agents active : " + activeAgents + "/" + simultaneousAgents + "\n"
    				+ "Agents spawned : " + spawnedAgents + "/" + totalAgents + "\n"
    				//I dont know why but both deadAgents and totalTimeAlive both increment twice as much as they are supposed to
    				//Since I divide them for the average it's not an issue but I need to divide this one if I display it
    				+ "Agents killed : " + deadAgents/2 + "\n"
    				
    				+ "Average agent lifetime : " + averageTimeAlive.toString().substring(0, averageTimeAlive.toString().length()-3)+","+averageTimeAlive.toString().substring(averageTimeAlive.toString().length()-3)+" seconds" + "\n"
    				+ "Crowd Influence : " + crowdInfluence.toString().substring(0, crowdInfluence.toString().length()-3)+","+crowdInfluence.toString().substring(crowdInfluence.toString().length()-3)+" seconds" + "\n"
    				+ "Density : " + roundedDensity + " customers/m^2" + "\n" + "\n"
    				+ "Information : " + "\n" 
    				+ "Shopping mall width : 68m"
    				+ "\n" + "Shopping mall length: 60m");
    	}
    	else
    	{
    		display.setText("\n\n"
    				+"Metrics : " + "\n"
    				+ "Elapsed time : " + (Calendar.getInstance().getTime().getTime() - startTime.getTime().getTime())/1000 + " s\n"
    				+ "Agents active : " + activeAgents + "/" + simultaneousAgents + "\n"
    				+ "Agents spawned : " + spawnedAgents + "/" + totalAgents + "\n"
    				//I dont know why but both deadAgents and totalTimeAlive both increment twice as much as they are supposed to
    				//Since I divide them for the average it's not an issue but I need to divide this one if I display it
    				+ "Agents killed : " + deadAgents/2 + "\n"
    				
    				+ "Average agent lifetime : Cant compute yet" + "\n"
    				+ "Crowd Influence : Cant compute yet" + "\n"
    				+ "Density : " + roundedDensity + " customers/m^2" + "\n" + "\n"
    				+ "Information : " + "\n" 
    				+ "Shopping mall width : 68m"
    				+ "\n" + "Shopping mall length: 60m");
    	}
	}

	
	
	
	
	
	
	
	

	public void updateSheetMetrics(Long timeAlive)
	{
		updateDisplay();
		//I have to do this check cus this function (along with all other functions in CustomerExitEvent) gets called twice for some reason
		if(!deadAgentNow.contains(deadAgents/2) && deadAgents/2!=0)
		{
			deadAgentNow.add(deadAgents/2);
			clockTime.add(Calendar.getInstance().getTime().getTime() - startTime.getTime().getTime());
			agentTime.add(timeAlive);
			averageTime.add(averageTimeAlive);
			densityMoment.add(density);
			createExcelSheet(); //Since ExitApplicationEvent is broken and only works half the time Ill just create a new sheet everytime an agent exists instead of at the end of the application
		}
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
	
	public void setDensity(Double density) {
		this.density = density;
	}

	public Text getDisplay() {
		return display;
	}

	public void setDisplay(Text display) {
		this.display = display;
	}

	public Long getTotalTimeAlive() {
		return totalTimeAlive;
	}

	public void setTotalTimeAlive(Long totalTimeAlive) {
		this.totalTimeAlive = totalTimeAlive;
	}

	public Integer getDeadAgents() {
		return deadAgents;
	}

	public void setDeadAgents(Integer deadAgents) {
		this.deadAgents = deadAgents;
	}
	
	
}
