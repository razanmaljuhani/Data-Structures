/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS1 in Java language . 
The Date of sending :  monday , Soctober 7th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar1806065p1;

import java.io.*;
import java.util.*;

public class SeniorProjectSystem {

    private student headStd; //head ..> represent Student 
    private supervisor headSupervisor; //head ..> represent Supervisor 
    //Constrctor of the class ****************

    public SeniorProjectSystem() {
        headStd = null;
        headSupervisor = null;
    }

// Mhehod1 
    //(isEmpityStudent)***********
    public boolean isEmptyStudent() {
        return headStd == null;
    }

    //isEmptySupervisor
    public boolean isEmptySupervisor() {
        return headSupervisor == null;
    }

//Method2 (insertStudent)**************
    public void insertStudent(String studentID, String studentName, String research_intrest, String Topic, int[] course, boolean approval, String supervisorID) {
        headStd = insertStudent(headStd, studentID, studentName, research_intrest, Topic, course, approval, supervisorID);
    }

    private student insertStudent(student headStd, String studentID, String studentName, String research_intrest, String Topic, int[] course, boolean approval, String supervisorID) {
        if (!(checkStd(studentID))) {
            //insert in the front : (id > frist node )
            if (headStd == null || headStd.getStudentID().compareTo(studentID) > 0) {
                headStd = new student(studentID, studentName, research_intrest, Topic, course, approval, supervisorID, headStd);
                return headStd;
            } else {
                //insert in the mid of List or in the End  .
                student helpPtr = headStd;
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getStudentID().compareTo(studentID) > 0) {
                        break; //out from loop
                    }
                    helpPtr = helpPtr.getNext();
                }
                student newNode = new student(studentID, studentName, research_intrest, Topic, course, approval, supervisorID, helpPtr.getNext());
                helpPtr.setNext(newNode);
            }
            return headStd;
        } else {
            return null; // when we cannot find the information .
        }
    }

//Method3 (insertSupervisor)************
    public void insertSupervisor(String supervisorID, String supervisorName, String Intrest[]) {
        headSupervisor = insertSupervisor(headSupervisor, supervisorID, supervisorName, Intrest);
    }

    private supervisor insertSupervisor(supervisor headSupervisor, String supervisorID, String supervisorName, String Intrest[]) {
        //insert in the EmpityList or in front of list :
        if (headSupervisor == null) {
            headSupervisor = new supervisor(supervisorID, supervisorName, Intrest, headSupervisor);
            return headSupervisor;
        } else {
            //insert in any plase of list except front
            supervisor helpPtr = headSupervisor;
            while (helpPtr.getNext() != null) {
                helpPtr = helpPtr.getNext();
            }
            supervisor newNode = new supervisor(supervisorID, supervisorName, Intrest, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        return headSupervisor;
    }

//Method4 (PrintStudent) *****************
    public void PrintStudent() {
        PrintStudent(headStd);
    }

    private void PrintStudent(student headStd) {
        System.out.printf("|%-12s|%-24s|%-46s|%-47s|%-14s|%-14s|\n", "Student ID", "Research Interest", "Suggested Topic", "Courses", "Approval", "Supervisor ID");
        System.out.printf("|%-12s%-25s%-47s%-47s%-15s%-15s|\n", "", "|", "|", "|CPCS223|CPIS334|CPCS351|CPCS241|CPCS361|CPCS331", "|", "|");
        student helpPtr = headStd;
        while (helpPtr != null) {
            System.out.printf("|%-12s|%-24s|%-46s|", helpPtr.getStudentID(), helpPtr.getResearch_intrest(), helpPtr.getResearchTopic().equals("nan") ? "" : helpPtr.getResearchTopic());
            for (int i = 0; i < helpPtr.getCourse().length; i++) {
                System.out.printf("%-7d|", helpPtr.printCourses(i));
            }
            System.out.printf("%-14b|%-14s|\n", helpPtr.isApproval(), helpPtr.getSupervisorID());
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

//Method5(PrintSupervisor) ****************
    public void PrintSupervisor() {
        PrintSupervisor(headSupervisor);
    }

    private void PrintSupervisor(supervisor headSupervisor) {
        supervisor helpPtr = headSupervisor;
        System.out.printf("Supervisor ID \t\t Name \t\t Research Intersts \n");
        while (helpPtr != null) {
            System.out.printf(helpPtr.toString());
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

//Method6 (PrintStudentInFile)******************
    public void PrintStudentInFile() throws Exception {
        PrintStudentInFile(headStd);
    }

    private void PrintStudentInFile(student headStd) throws Exception {
        PrintWriter p = new PrintWriter("studentOutput.txt");
        p.printf("|%-12s|%-24s|%-46s|%-47s|%-14s|%-14s|\r\n", "Student ID", "Research Interest", "Suggested Topic", "Courses", "Approval", "Supervisor ID");
        p.printf("|%-12s%-25s%-47s%-47s%-15s%-15s|\r\n", "", "|", "|", "|CPCS223|CPIS334|CPCS351|CPCS241|CPCS361|CPCS331", "|", "|");
        student helpPtr = headStd;
        while (helpPtr != null) {
            p.printf("|%-12s|%-24s|%-46s|", helpPtr.getStudentID(), helpPtr.getResearch_intrest(), helpPtr.getResearchTopic().equals("nan") ? "" : helpPtr.getResearchTopic());
            for (int i = 0; i < helpPtr.getCourse().length; i++) {
                p.printf("%-7d|", helpPtr.printCourses(i));
            }
            p.printf("%-14b|%-14s|\r\n", helpPtr.isApproval(), helpPtr.getSupervisorID());
            helpPtr = helpPtr.getNext();
        }
        p.println();
        p.close();
    }

//Method7 (PrintSupervisorInFile)*****************
    public void PrintSupervisorInFile() throws Exception {
        PrintSupervisorInFile(headSupervisor);
    }

    private void PrintSupervisorInFile(supervisor headsupervisor) throws Exception {
        PrintWriter p = new PrintWriter("supervisorOutput.txt");
        supervisor helpPtr = headsupervisor;
        while (helpPtr != null) {
            p.println(helpPtr.toString() + " ");
            helpPtr = helpPtr.getNext();
        }
        p.close();
    }

//Method8 (PrintSeniorStudent) ************* 
    //thats method print student in acseding order and if the student complete the minimum num. of requirement
    public void PrintSeniorStudent() {
        PrintSeniorStudent(headStd);
    }

    private void PrintSeniorStudent(student headStd) {
        student helpPtr = headStd;
        System.out.printf("|%-14s|%-20s|%-24s|%-46s|%-14s|\n", "Student ID", "Student Name", "Research Interest", "Suggested Topic", "Supervisor ID");
        while (helpPtr != null) {
            if (this.CheckCourse(helpPtr.getStudentID()) && (!(helpPtr.getResearchTopic().trim().equals("nan")))) {
                System.out.printf("|%-14s|%-20s|%-24s|%-46s|", helpPtr.getStudentID(), helpPtr.getStudentName(), helpPtr.getResearch_intrest(), helpPtr.getResearchTopic().equals("nan") ? "" : helpPtr.getResearchTopic());
                System.out.printf("%-14S|\n", helpPtr.getSupervisorID());
            }
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

//Method9 (CheackStd)**************
    public boolean checkStd(String ID) {
        return checkStd(headStd, ID);
    }

    private boolean checkStd(student headStd, String ID) {
        student helpPtr = headStd;
        while (helpPtr != null) {
            if (helpPtr.getStudentID().compareTo(ID) == 0) {
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

//Method10(CheackCourse) ************* 
    //to check the student take the all courses ? if take > true , else take > false
    public boolean CheckCourse(String ID) {
        return CheckCourse(headStd, ID);
    }

    private boolean CheckCourse(student headStd, String ID) {
        student helpPtr = headStd;
        while (helpPtr != null) {
            if (helpPtr.getStudentID().compareTo(ID) == 0) {
                int[] coursesArr = helpPtr.getCourse();
                for (int i = 0; i < coursesArr.length; i++) {
                    if (coursesArr[i] == 0) {
                        return false; // the student doesnt take the all courses
                    }
                }
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

//Method11 (AddTopic)***********
    public void AddResearchTopic(String ID, String ResearchTopicTopic) {
        AddResearchTopic1(ID, ResearchTopicTopic);
    }

    private void AddResearchTopic1(String ID, String ResearchTopic) {
        student helpPtr = headStd;
        while (helpPtr != null) {
            if ((helpPtr.getStudentID().equals(ID))) {
                helpPtr.setResearchTopic(ResearchTopic);
            }
            helpPtr = helpPtr.getNext();

        }
    }

//Method12(SpervisorStudentInterests)***************
    //match interest with student and cheak the supervisor matched with interest stuent
    //find the supervisor the same of intersest of the topic
    public String SpervisorStudentInterests(String researchInterest) {
        supervisor helpPtr = headSupervisor;
        String supervisorID = "";
        while (helpPtr != null) {
            for (int i = 0; i < helpPtr.getIntrest().length; i++) {
                if ((helpPtr.getIntrest()[i].compareTo(researchInterest)) == 0 && (helpPtr.getIntrest()[i] != null)) {
                    supervisorID = helpPtr.getSupervisorID();
                }
            }
            helpPtr = helpPtr.getNext();
        }
        return supervisorID;
    }

//Method13 (deleteStuentByID)**************
    public void deleteStudentByID(String ID) {
        headStd = deleteStudentByID(headStd, ID);
    }

    private student deleteStudentByID(student headStd, String ID) {
        System.out.printf("|%-12s|%-24s|%-46s|%-47s|%-14s|%-14s|\n", "Student ID", "Research Interest", "Suggested Topic", "Courses", "Approval", "Supervisor ID");
        System.out.printf("|%-12s%-25s%-47s%-47s%-15s%-15s|\n", "", "|", "|", "|CPCS223|CPIS334|CPCS351|CPCS241|CPCS361|CPCS331", "|", "|");
        if (!(isEmptyStudent())) {
            //if student in the front :
            if (headStd.getStudentID().compareTo(ID) == 0) {
                System.out.printf("|%-12s|%-24s|%-46s|", headStd.getStudentID(), headStd.getResearch_intrest(), headStd.getResearchTopic().equals("nan") ? "" : headStd.getResearchTopic());
                for (int i = 0; i < headStd.getCourse().length; i++) {
                    System.out.printf("%-7d|", headStd.printCourses(i));
                }
                System.out.printf("%-14b|%-14s|\n", headStd.isApproval(), headStd.getSupervisorID());
                headStd = headStd.getNext();
            } else {
                student helpPtr = headStd;
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getStudentID().compareTo(ID) == 0) {
                        System.out.printf("|%-12s|%-24s|%-46s|", helpPtr.getNext().getStudentID(), helpPtr.getNext().getResearch_intrest(), helpPtr.getNext().getResearchTopic().equals("nan") ? "" : helpPtr.getNext().getResearchTopic());
                        for (int i = 0; i < helpPtr.getCourse().length; i++) {
                            System.out.printf("%-7d|", helpPtr.getNext().printCourses(i));
                        }
                        System.out.printf("%-14b|%-14s|\n", helpPtr.getNext().isApproval(), helpPtr.getNext().getSupervisorID());
                        helpPtr.setNext(helpPtr.getNext().getNext());
                        break;
                    }
                    helpPtr = helpPtr.getNext();
                }
            }
            return headStd;
        }
        return headStd;
    }

    //Method14 (deleteAll)****************
    public void deleteAllStudent() {
        student helpPtr = headStd;
        while (helpPtr != null) {
            if (!(CheckCourse(helpPtr.getStudentID()))) {
                deleteStudentByID(helpPtr.getStudentID());
            }
            helpPtr = helpPtr.getNext();
        }
    }
}
