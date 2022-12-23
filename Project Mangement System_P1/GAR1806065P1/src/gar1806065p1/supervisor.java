/* Hi teatcher , I hope you'r alawys happy >> Here The solving of ASS1 in Java language . 
The Date of sending :  monday , Soctober 7th , 2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(GAR), Email(Raljohani0084@stu.kau.edu.sa) .\
package gar1806065p1;
//Class supervisor (node)
public class supervisor {

    private String supervisorID;
    private String supervisorName;
    private String[] Intrest;
    private supervisor next; //Link Of Node

    public supervisor() {
        supervisorID = "";
        supervisorName = "";
        Intrest = null;
        next = null;
    }

    public supervisor(String supervisorID, String supervisorName, String[] Intrest) {
        this(supervisorID, supervisorName, Intrest, null);
    }

    public supervisor(String supervisorID, String supervisorName, String[] Intrest, supervisor next) {
        this.supervisorID = supervisorID;
        this.supervisorName = supervisorName;
        this.Intrest = Intrest;
        this.next = next;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(String supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getSupervisorName() {

        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String[] getIntrest() {

        return Intrest;
    }

    public void setIntrest(String[] Intrest) {
        this.Intrest = Intrest;
    }

    public supervisor getNext() {
        return next;
    }

    public void setNext(supervisor next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String interests = "";
        for (int i = 0; i < Intrest.length; i++) {
            if (Intrest[i] != null) {
                interests = interests + " " + Intrest[i];
            }
        }
        return supervisorID + " \t\t " + supervisorName + "\t\t " + interests + "\n";
    }
}