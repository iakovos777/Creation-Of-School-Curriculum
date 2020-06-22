//IAKOVOS EVDAIMON 3130059
package ergasia1;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;



public class Main {
	
	/* Models and Parsers static declaration */
	
	/* Courses */
	private static ArrayList<Lessons> lessons;
	private static LessonsParser lessonsParser;
	
	/* Departments */
	private static ArrayList<SchoolDepartments> departments;
	private static SchoolDepartmentsParser departmentsParser;
	
	/* Teachers */
	private static ArrayList<Teachers> teachers;
	private static TeachersParser teachersParser;
	
	
	
	
	/* Current Directory Detection */
	private static File currentDirectory = new File(new File(".").getAbsolutePath());
	private static String currentDirectoryPath = currentDirectory.getAbsolutePath()
												.substring(0,currentDirectory.getAbsolutePath().length() - 1);
	
	/* txt Files Base Path */
	private static String basePath =  currentDirectoryPath + "\\Text Files\\";
	
	/*  Path for each file */
	private static String lessonsTxtPath = 	 basePath + "lessons.txt";
	private static String departmentsTxtPath = basePath + "departments.txt";
	private static String teachersTxtPath = basePath + "teachers.txt";
	
	public static void listsInstallation() throws FileNotFoundException{
		
		lessons = new ArrayList<Lessons>();
		departments = new ArrayList<SchoolDepartments>();
		teachers = new ArrayList<Teachers>();
		
		
		lessonsParser = new LessonsParser(lessonsTxtPath);
		departmentsParser = new SchoolDepartmentsParser(departmentsTxtPath);
		teachersParser = new TeachersParser(teachersTxtPath);
		
		
		lessons = lessonsParser.getLessons();
		//System.out.println(lessons.size());
		departments = departmentsParser.getSchoolDepartments();
		//System.out.println(departments.size());
		teachers = teachersParser.getTeachers();
		//System.out.println(teachers.size());
		
	}
	
	
	/* Main */
	public static void main(String[] args) {
		
		try {
			listsInstallation();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Genetic newGen= new Genetic(lessons,departments,teachers);
		Chromosome x=newGen.geneticAlgorithm(100, 0.01,500,1000);
		System.out.println("Score--> "+x.getFitness());
		
		String schedule= new State(UsefulMethods.finalSchedule(), x.getCollection(), teachers,departments).toString();
		
		write_file(schedule);

	
	}
	
	public static void write_file(String s){
		File f=null;
		BufferedWriter wr= null;
		
		try 
		{
			f = new File("schedule.txt");
		}
		catch(NullPointerException e)
		{
			System.err.println("File not found!");
		}
		
		try
		{
			f.delete();
		}
		catch(SecurityException e)
		{
			System.err.println("Error in file deletion!");
		}
		
		try
		{
			wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("schedule.txt")));
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Error opening file.");
		}
		
		try
		{
			wr.write(s);
		}
		catch(IOException e)
		{
			System.err.println("Error while writing file!");
		}
		catch(NullPointerException e)
		{
			System.err.println("Tried to write empty string!");
		}
		
		try
		{
			wr.close();
		}
		catch(IOException e)
		{
			System.err.println("Error while trying to close file!");
		}
		
		System.out.println("schedule.txt file successfully created.");
	}

		
	
}