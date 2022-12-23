/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS1 in Java language . 
The Date of sending :  monday , Soctober 7th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar1806065p1;

import java.io.*; // File
import java.util.*; // Scanner

public class StdMenue {

    //object of List
    static SeniorProjectSystem LinkList = new SeniorProjectSystem();

    //The Main 
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        readSupervisorFile();
        readStudentFile();
// important variables for Student
        int choice; //user choice 
        String studentID;
        String studentName;
        String research_intrest;
        String Topic;
        String coursesNumber = "";
        int[] course = new int[6]; // 6 courses
        String[] CoursesArr;
        String replace = "";
//Start of Loop
        do {
            showMenu();
            choice = input.nextInt();
            switch (choice) {
//////////////////////////////////////////////////////////////////////////////////////////////////////////
// 1- insert new node into list
                case 1: {
                    System.out.print("Please enter the student information :\n\n ");
                    System.out.print("Student ID : ");
                    studentID = input.next();
                    if (LinkList.checkStd(studentID)) {
                        System.out.println("The student already exists!");
                    } else {
                        System.out.print("Student Name : ");
                        studentName = input.next();

                        System.out.print("research interest : ");
                        research_intrest = input.next();

                        input.nextLine();
                        System.out.print("courses : ");
                        coursesNumber = input.nextLine();

                        replace = coursesNumber.replaceAll("[,]", " ");
                        CoursesArr = replace.split(" ");
                        //The courses will be taked "1" or not taked "0"
                        for (int i = 0; i < CoursesArr.length; i++) {
                            if (CoursesArr[i].compareTo("CPCS223") == 0) {
                                course[0] = 1;
                            } else if (CoursesArr[i].compareTo("CPIS334") == 0) {
                                course[1] = 1;
                            } else if (CoursesArr[i].compareTo("CPCS351") == 0) {
                                course[2] = 1;
                            } else if (CoursesArr[i].compareTo("CPCS241") == 0) {
                                course[3] = 1;
                            } else if (CoursesArr[i].compareTo("CPCS361") == 0) {
                                course[4] = 1;
                            } else if (CoursesArr[i].compareTo("CPCS331") == 0) {
                                course[5] = 1;
                            } else {
                                course[i] = 0;
                            }
                        }
                        LinkList.insertStudent(studentID, studentName, research_intrest, "nan", course, false, "0");
                        System.out.println("The student is added!");
                    }
                    System.out.println();
/////////////////////////////////////////////////////////////////////////////////////////////////////
                    break;
                }
                case 2: {
                    LinkList.PrintSupervisor();
                    System.out.println();
                    break;

/////////////////////////////////////////////////////////////////////////////////////////////////////
                }
                case 3: {
                    LinkList.PrintStudent();
                    System.out.println("");
                    break;

/////////////////////////////////////////////////////////////////////////////////////////////////////
                }
                case 4: {
                    System.out.print("Please enter the student information: \n\n");
                    System.out.print("student ID : ");
                    studentID = input.next();
                    if (!(LinkList.checkStd(studentID))) {
                        System.out.println("The student doesn't exists!");
                    } else if (LinkList.CheckCourse(studentID)) {
                        if (LinkList.checkStd(studentID)) {
                            System.out.print("The student studied all required subject, and please enter the topic: ");
                            String studentTopic = input.next();
                            input.nextLine();
                            LinkList.AddResearchTopic(studentID, studentTopic);
                            LinkList.PrintStudent();
                        }
                    } else {
                        System.out.println("The student doesn't studied all required subject");
                    }
                    break;
                }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 5: {
                    System.out.println("1- Delete Student By ID : ");
                    System.out.println("2- Delete All Students not complete requirement: ");

                    choice = input.nextInt();
                    if (choice == 1) {
                        System.out.print("Please enter the student information: \n\n");

                        System.out.print("student ID : ");
                        studentID = input.next();

                        if (!(LinkList.checkStd(studentID))) {
                            System.out.println("The student doesn't exists!");

                        } else {
                            LinkList.deleteStudentByID(studentID);
                        }
                    } else if (choice == 2) {
                        LinkList.deleteAllStudent();
                    }
                    System.out.println();

/////////////////////////////////////////////////////////////////////////////////////////////////////
                    break;
                }
                case 6: {
                    LinkList.PrintSeniorStudent();
                    System.out.println();
                    break;

/////////////////////////////////////////////////////////////////////////////////////////////////////
                }
                case 7: {
                    LinkList.PrintStudentInFile();
                    LinkList.PrintSupervisorInFile();
                    System.out.println("> Goodbye!");
                    System.out.println();

                    break;
                }
                default: {
                    System.out.println("> Wrong selection. Try again.");
                    System.out.println();

                    break;
                }
            }

        } while (choice!= 7);
    }//end of main 
//Method1 (showMenu)

    public static void showMenu() {

        System.out.println("|---------------------------------------------------|");
        System.out.println("|------ Assignment1 (Menu) ----------|");
        System.out.println("|---------------------------------------------------|");
        System.out.println("| 1. Add a new student |");
        System.out.println("| 2. Print supervisor list |");
        System.out.println("| 3. Print student list |");
        System.out.println("| 4. Add research topic |");
        System.out.println("| 5. Remove Student |");
        System.out.println("| 6. Print senior project list in ascending order |");
        System.out.println("| 7. Exit |");
        System.out.println("|---------------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter your choice: ");
    }

//Method2 (readSupervisor)
    public static void readSupervisorFile() throws Exception {
        File supeevisorFile = new File("supervisor.txt");
        if (!(supeevisorFile.exists())) {
            System.out.println(">>>> File Not Found <<<<");
            System.exit(0);
        } else {
            Scanner superF = new Scanner(supeevisorFile);
            supervisor sup = new supervisor(); //Object of Supervisor
            while (superF.hasNext()) {
                String[] insertSuperArr = new String[3]; //interest supervisor
                String[] splitSuperF = superF.nextLine().split("[,#]"); // storing after split (# , )

                sup.setSupervisorID(splitSuperF[0]); //index0
                sup.setSupervisorName(splitSuperF[1]); // index1

                //index3 interests ... Start loop from index 2 .
                for (int i = 2; i < splitSuperF.length; i++) {
                    if (splitSuperF[i] != null) {
                        insertSuperArr[i - 2] = splitSuperF[i];
                    }
                }
                sup.setIntrest(insertSuperArr);
                //insert data of supervisor in list
                LinkList.insertSupervisor(sup.getSupervisorID(), sup.getSupervisorName(), sup.getIntrest());
            }
            superF.close();
        }
    }

//Method3 (readStudent)
    public static void readStudentFile() throws Exception {
        File studentFile = new File("student.txt");
        if (!(studentFile.exists())) {
            System.out.println(" >>>> File Not Found <<<<");
            System.exit(0);
        }
        Scanner studentF = new Scanner(studentFile);
        while (studentF.hasNext()) {
            student std = new student(); //Object Of Student 
            int[] stdData = new int[6];
            String[] splitStdF = studentF.nextLine().split("[,#]");

            std.setStudentID(splitStdF[0]); //index0
            std.setStudentName(splitStdF[1]); //index1
            std.setResearch_intrest(splitStdF[2]); //index2
            std.setResearchTopic(splitStdF[3]); // index3
            //loop from index4 to index9
            for (int i = 4; i < 10; i++) {
                stdData[i - 4] = Integer.parseInt(splitStdF[i]);
            }
            std.setCourse(stdData);
            std.setApproval(Boolean.valueOf(splitStdF[10]));//index10
            std.setSupervisorID(splitStdF[11]);//index11
            //insert data of student in list
            LinkList.insertStudent(std.getStudentID(), std.getStudentName(), std.getResearch_intrest(),
                    std.getResearchTopic(), std.getCourse(), std.isApproval(), std.getSupervisorID());
        }
        studentF.close();
    }

}//end of class
