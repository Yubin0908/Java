public class NumberOverflow {

    public static void main(String[] args) {

        int value = 10;
        int maxInt = Integer.MAX_VALUE;

        System.out.println(value + 1);
        System.out.println(maxInt + 1);

        // 여기서부터 형변환
        // long > int > short > byte

        System.out.println("아래값은 형변환 결과입니다");

        double d1 = 50;
        double d2 = 500L;

        System.out.println(d1);
        System.out.println(d2);

    }
}
