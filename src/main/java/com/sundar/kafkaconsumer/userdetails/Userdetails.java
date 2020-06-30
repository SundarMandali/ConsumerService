package com.sundar.kafkaconsumer.userdetails;

public class Userdetails {
	private String name;
	private String dept;
	private int salary;
	
	
	public Userdetails() {
		
	}
	
	
	public Userdetails(String name, String dept,int salary) {

        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
	
	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dept='").append(dept).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append('}');
        return sb.toString();
    }
	
	
	

}
