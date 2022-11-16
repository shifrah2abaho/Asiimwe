package assignment.com;

import java.io.*;

class MList {

static public StudentWrapper theStudents = new StudentWrapper();

public void ViewRecords() {

  System.out.println("_______________________________________________________________");

  System.out.println("SNo Student Name       Sub1   Sub2   Sub3   Sub4   Sub5   Total");

  System.out.println("_______________________________________________________________");

 

  for(int i = 0; i < theStudents.m_nMaxStudents; i++){

  System.out.format("%1$-5d", i+1);

 

  System.out.format("%1$-19s", theStudents.m_studList[i].name);

  System.out.format("%1$-7d", theStudents.m_studList[i].marks[0]);

  System.out.format("%1$-7d", theStudents.m_studList[i].marks[1]);

  System.out.format("%1$-7d", theStudents.m_studList[i].marks[2]);

  System.out.format("%1$-7d", theStudents.m_studList[i].marks[3]);

  System.out.format("%1$-7d", theStudents.m_studList[i].marks[4]);

  System.out.format("%1$-7d", theStudents.m_studList[i].total);

  System.out.println();

}

  System.out.println("_______________________________________________________________");

}

public void InputRecords() {

try{

  InputStreamReader input = new InputStreamReader(System.in);  

  BufferedReader reader = new BufferedReader(input);  

 

  System.out.print("Student Name : ");

  String name;

 

  int[] marks = new int[5];

  name = reader.readLine(); 

 

for(int i = 1; i <= 5; i++){

  System.out.print("Sub "+i+" Mark : ");

  marks[i-1] = Integer.parseInt(reader.readLine()); 

}

  theStudents.AddRecord(name, marks);

}

catch(Exception e){

  e.printStackTrace();

}

}

}

class Student extends MList  {

public static void main(String args[]) {

  MList obj_marks = new MList();

  String stdNumber = "";

  InputStreamReader input = new InputStreamReader(System.in);  

  BufferedReader reader = new BufferedReader(input);  

 

try{

  System.out.print("Enter the number of students: ");

  stdNumber = reader.readLine(); 

  int numStudents = Integer.parseInt(stdNumber); 

 

for(int i = 1; i <= numStudents; i++){

  System.out.println("\nEnter "+i+" Student Information \n");

  obj_marks.InputRecords();

}

  obj_marks.ViewRecords();

}

catch(Exception e){

  e.printStackTrace();

}

}

}

class StudentsInfo {

  public String name;

  public int[] marks = new int[5];

  public int total;

}

class StudentWrapper {

public StudentsInfo[] m_studList = new StudentsInfo[100];

public int m_nMaxStudents;

 

public int AddRecord(String name, int[] marks) {

  StudentsInfo stud = new StudentsInfo();

  stud.name = name; 

  stud.marks = marks; 

  stud.total = 0; 

for(int i = 0; i < 5; i++){

  stud.total += stud.marks[i]; 

}

  m_studList[m_nMaxStudents++] = stud; 

  return 1;

}

}
