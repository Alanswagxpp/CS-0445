package IfStatementTest;

public class andOrTest {
    public static void main(String[] args) {
        int a=0;
        int b=1;
        int c=2;
        if((a==0 && b==1) || c==3){
            System.out.println("&& || can be used together");
        } else {
            System.out.println("&& || can not be used together");
        }
    }
}
