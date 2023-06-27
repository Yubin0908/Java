public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java");

        int i;
        i = 30;
        System.out.println(i);

        int j;
        j = 45;
        System.out.println(j);

        if (i == j) {
            System.out.println("검증 : " + "같은 값입니다.");
        } else {
            System.out.println("검증 : " + "같은 값이 아닙니다.");
        }
    }
}