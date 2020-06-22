//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SchoolDepartmentsParser {
private ArrayList<SchoolDepartments> departments ;
	
	public SchoolDepartmentsParser(){
		this.departments = new ArrayList<SchoolDepartments>();
	}
	
	public SchoolDepartmentsParser(String path){
		this.departments = new ArrayList<SchoolDepartments>();
		this.loadFile(path);
		
	}

    private void loadFile(String path) {
        int counter = 0; //counter grammhs arxeiou
        File f = null;
        BufferedReader reader = null;
        String line;

        try {
            f = new File(path);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }
        try {
            line = reader.readLine();
            counter++;
            while((line ==null)&&(counter <10)){
				line = reader.readLine();
				counter++;
			}
            if (line != null) {
                if ((line.trim().equalsIgnoreCase("Departments"))||(line.trim().equalsIgnoreCase("Departments{"))) {
                     line = reader.readLine();
                     counter++;
                     if (line != null) {    
                        if (line.trim().equals("{")) {
                                line = reader.readLine();
                                counter++;
                        }
                     }
                           
                           
                      while(!line.trim().equals("}")){
                    	  	                           
                    	    		
                            String dpms = line.trim();
                            SchoolDepartments sd = new SchoolDepartments(dpms);
                            departments.add(sd);
                            line = reader.readLine();
                            counter++;
                            if (line.equals("")){
                            	System.out.println("Sudden error in line:" +counter);
                            	break;
                            }
                
                      }//while      
                } //2nd if           
              } //1st if          
           } //try        
           catch (IOException e) {
            System.out.println("Line " + counter + ": Sudden end.");
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }

    public ArrayList<SchoolDepartments> getSchoolDepartments() {
        return this.departments;
    }

    public void setSchoolDepartments(ArrayList<SchoolDepartments> departments) {
        this.departments = departments;
    }

}
