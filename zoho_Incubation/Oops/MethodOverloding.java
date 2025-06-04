class Mark{
    public void mark(int tamil, int english ,int maths, int Science, int socialScience){
        System.out.println("Total Marks  SSLC is "+(tamil+english+maths+Science+socialScience));
    }
    public void mark(int tamil, int english ,int maths,  int physics,int chemistry,int computerScience){
        System.out.println("Total Marks HSC  is "+(tamil+english+maths+physics+chemistry+computerScience));

    }
}
public class MethodOverloding {
    public static void main(String[] args) {
        Mark mark = new Mark();
        mark.mark(12, 34, 56, 78, 89, 90);
        mark.mark(12, 34, 56, 78, 89);
    }
}
