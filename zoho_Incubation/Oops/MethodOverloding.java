class Mark{
    public void mark(int tamil, int english ,int maths, int science, int socialScience){
        int total = tamil+english+maths+science+socialScience;

        if(checkMark(tamil)|| checkMark(english)|| checkMark(maths)||checkMark(science)||checkMark(socialScience)){
            System.out.println("Input Invalid");
            return;
        }
        if(total >450 && total <=500){
            System.out.println("Grade 1 ");
        }
        else if(total<= 450 && total >300){
            System.out.println("Grade 2 ");
        }
        else if (total > 250 && total <=300){
            System.out.println("Grade 3");
        }
        else {
            System.out.println("Failed");
            return;
        }
        System.out.println("Student Passed Mark Obtained in SSLC is "+total);
    }
    private boolean checkMark(int mark){
        return !(mark>0 && mark <=100);
    }
    public void mark(int tamil, int english ,int maths,  int physics,int chemistry,int computerScience){
        int total = tamil+english+maths+physics+chemistry+computerScience;

        if(checkMark(tamil)|| checkMark(english)|| checkMark(maths)||checkMark(physics)||checkMark(chemistry)|| checkMark(computerScience)){
            System.out.println("Input Invalid");
            return;
        }
        if(total >550 && total <=600){
            System.out.println("Grade 1 ");
        }
        else if(total<= 550 && total >400){
            System.out.println("Grade 2 ");
        }
        else if (total > 350 && total <=400){
            System.out.println("Grade 3");
        }
        else {
            System.out.println("Failed");
            return;
        }
        System.out.println("Student Passed Mark Obtained in HSC is "+total);
    }
}
public class MethodOverloding {
    public static void main(String[] args) {
        Mark mark = new Mark();
        mark.mark(12, 34, 56, 440, 89, 90);
        mark.mark(12, 34, 56, 80, 89);
    }
}
