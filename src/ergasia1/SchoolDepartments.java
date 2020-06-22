//IAKOVOS EVDAIMON 3130059
package ergasia1;

public class SchoolDepartments {
	private String department;
	private String sClass;
	
	public SchoolDepartments(){}
	
	public SchoolDepartments(String department){
		this.department = department;
		char s = this.department.charAt(0);
		if(s=='A'){
			this.sClass = "A";
		}
		else if(s=='B'){
			this.sClass = "B";
		}
		else if(s=='C'){
			this.sClass = "C";
		}
		
	}

	public void setSClass(String sClass) {
		this.sClass = sClass;
		
	}
	
	public void setDepartment(String department) {
		this.department = department;
		
	}
	
	public String getSClass(){
		return this.sClass;
	}
	public String getDepartment(){
		return this.department;
	}
}
