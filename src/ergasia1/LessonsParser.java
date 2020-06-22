//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.io.*;

import java.util.ArrayList;

public class LessonsParser {
	private ArrayList<Lessons> lessons ;
	
	public LessonsParser(){
		this.lessons = new ArrayList<Lessons>();
	}
	
	public LessonsParser(String path){
		this.lessons = new ArrayList<Lessons>();
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
                if ((line.trim().equalsIgnoreCase("Lessons"))||(line.trim().equalsIgnoreCase("Lessons {"))) {
                     line = reader.readLine();
                     counter++;
                     if (line != null) {    
                        if (line.trim().equals("{")) {
                                line = reader.readLine();
                                counter++;
                        }
                     }
                           
                           
                      while(!line.trim().equals("}")){
                    	  	                           
                            Lessons l = new Lessons();		
                            String[] parts = line.split(",");
                            String[] lc = new String[parts.length];		
                            for(int i = 0;i<parts.length; i++){
                            	lc[i] = (parts[i].substring(parts[i].indexOf(':')+1)).trim();
                            	
                            } 
                            
                            l.setLessonCode(lc[0]);
                            l.setLessonName(lc[1]);
                            l.setSchoolClass(lc[2]);
                            int hours = Integer.parseInt(lc[3]);
                            l.setHours(hours);
                            lessons.add(l);
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

    public ArrayList<Lessons> getLessons() {
        return this.lessons;
    }

    public void setLessons(ArrayList<Lessons> lessons) {
        this.lessons = lessons;
    }


  }
