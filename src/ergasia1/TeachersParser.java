//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TeachersParser {
private ArrayList<Teachers> teachers ;
	
	public TeachersParser(){
		this.teachers = new ArrayList<Teachers>();
	}
	
	public TeachersParser(String path){
		this.teachers = new ArrayList<Teachers>();
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
                if ((line.trim().equalsIgnoreCase("Teachers"))||(line.trim().equalsIgnoreCase("Teachers {"))) {
                     line = reader.readLine();
                     counter++;
                     if (line != null) {    
                        if (line.trim().equals("{")) {
                                line = reader.readLine();
                                counter++;
                        }
                     }
                           
                           
                      while(!line.trim().equals("}")){
                    	  	                           
                    	  	Teachers t = new Teachers();		
                            String[] parts = line.split(",");
                            String[] tch = new String[parts.length];		
                            for(int i = 0;i<parts.length; i++){
                            	tch[i] = parts[i].substring(parts[i].indexOf(':')+1).trim();
                            	
                            } 
                            
                            t.setTeacherCode(tch[0]);
                            
                            t.setTeacherName(tch[1]);
                            
                            String[] lc = tch[2].split(" ");
                            
                            t.setLessonCode(lc);
                            // check it
                            String[] hd = tch[3].split("-");
                            int[] hoursDay = new int[2];
                            int j;
                            
                           
                            for(j=0;j<hd.length;j++){ 
                            	
                                hoursDay[j]=Integer.parseInt(hd[j]);
                                
                            }
                            
                            
                            int hoursWeek = Integer.parseInt(tch[4]);
                            t.setHoursDay(hoursDay);
                            t.setHoursWeek(hoursWeek);
                            teachers.add(t);
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

    public ArrayList<Teachers> getTeachers() {
        return this.teachers;
    }

    public void setTeachers(ArrayList<Teachers> teachers) {
        this.teachers = teachers;
    }

}
