/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS1 in Java language . 
The Date of sending :  monday , Soctober 7th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar1806065p1;
//Class student (node)
public class student {

    private String studentID;
    private String studentName;
    private String research_intrest;
    private String ResearchTopic;
    private int[] course; //if the studend took the course return (1) else return (0)
    private boolean approval; // accepted education project ?
    private String supervisorID;
    private student next; //Link Of Node

    //construtor 1
    public student() {
        studentID = "";
        studentName = "";
        research_intrest = "";
        ResearchTopic = "";
        course = null;
        approval = false;
        supervisorID = "";
        next = null;
    }
    
    //construtor 2
    public student(String studentID, String studentName, String research_intrest, String Topic, int[] course, boolean approval, String supervisorID) {
        this(studentID, studentName, research_intrest, Topic, course, approval, supervisorID, null); //next (null)
    }

    //construtor 2
    public student(String studentID, String studentName, String research_intrest, String Topic, int[] course, boolean approval, String supervisorID, student next) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.research_intrest = research_intrest;
        this.ResearchTopic = Topic;
        this.course = course;
        this.approval = approval;
        this.supervisorID = supervisorID;
        this.next = next;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getResearch_intrest() {
        return research_intrest;
    }

    public void setResearch_intrest(String research_intrest) {
        this.research_intrest = research_intrest;
    }

    public String getResearchTopic() {
        return ResearchTopic;
    }

    public void setResearchTopic(String Topic) {
        this.ResearchTopic = Topic;
    }

    public int[] getCourse() {
        return course;
    }

    public void setCourse(int[] course) {
        this.course = course;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(String supervisorID) {
        this.supervisorID = supervisorID;
    }

    public student getNext() {
        return next;
    }

    public void setNext(student next) {
        this.next = next;
    }

    public int printCourses(int i) {
        return course[i];
    }

    @Override
    public String toString() {
        return "student{" + "studentID=" + studentID + ", studentName=" + studentName + ", research_intrest=" + research_intrest + ", ResearchTopic=" + ResearchTopic + ", course=" + course + ", approval=" + approval + ", supervisorID=" + supervisorID + ", next=" + next + '}';
    }

}
