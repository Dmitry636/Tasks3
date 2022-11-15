import java.util.ArrayList;
import java.util.List;

public class Tasks3 {
    public static void main(String[] args) {
        // task1
        System.out.println("--Task1--");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        // task2
        System.out.println("--Task2--");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        // task3
        System.out.println("--Task3--");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        // task4
        System.out.println("--Task4--");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));

        // task5
        System.out.println("--Task5--");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        // task6
        System.out.println("--Task6--");
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println(same(new int[]{2}, new int[]{3, 3, 3, 3, 3}));

        // task7
        System.out.println("--Task7--");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));

        // task8
        System.out.println("--Task8--");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));

        // task9
        System.out.println("--Task9--");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));

        // task10
        System.out.println("--Task10--");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }

    public static int solutions(int a, int b, int c) {
        int res = 0;
        int d = b * b - 4 * a * c;
        if (d > 1) {
            res = 2;
        } else if (d == 0) {
            res = 1;
        } else if (d < 0) {
            res = 0;
        }
        return res;
    }

    public static int findZip(String s) {
        String res;
        res = s.replaceFirst("zip", "___"); // замена первого "zip"
        return res.indexOf("zip"); // возврат индекса вхождения 2го "zip"
    }

    public static boolean checkPerfect(int a) {
        int sum = 0;
        for (int i = 1; i <= a / 2; i++) {
            if (a % i == 0) {
                sum += i;
            }
        }
        return sum == a;
    }

    public static String flipEndChars(String s) {
        String res;
        if (s.length() < 2) {
            res = "Incompatible.";
        } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
            res = "Two's a pair.";
        } else {
            res = s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
        }
        return res;
    }

    public static boolean isValidHexCode(String s) {
        String res = s.substring(1);
        if (!s.startsWith("#")) {
            return false;
        } else if (s.length() - 1 > 6) {
            return false;
        }
        return res.matches("^[0-9a-fA-F]+$");
    }

    public static boolean same(int[] a, int[] b) {
        List<Integer> list1 = new ArrayList<>(); // лист чисел
        for (int x : a) { // цикл for each - для каждого
            if (!list1.contains(x)) // проверка содержания числа в массиве, если уже есть не добавлять
                list1.add(x);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int x : b) { // цикл for each - для каждого(!!!тип значения совпадает с типом массива)
            if (!list2.contains(x)) // проверка содержания числа в массиве
                list2.add(x);
        }
        String l1 = list1.toString(); // счет уникальных чисел
        int count1 = 0;
        for (int i = 0; i <= l1.length(); i++) {
            count1 += 1;
        }
        String l2 = list2.toString();
        int count2 = 0;
        for (int i = 0; i <= l2.length(); i++) {
            count2 += 1;
        }
        return count1 == count2;
    }

    public static boolean isKaprekar(int a) {
        if (a == 0 || a == 1) {
            return true;
        }
        String leftpart, rightpart;
        String l1;
        int leftpartint, rightpartint;
        int b;
        b = a * a;
        l1 = String.valueOf(b);

        if (l1.length() % 2 == 0) {
            int count1 = l1.length() / 2;
            leftpart = l1.substring(0, count1);
            rightpart = l1.substring(count1);
            leftpartint = Integer.parseInt(leftpart);
            rightpartint = Integer.parseInt(rightpart);
            return leftpartint + rightpartint == a;
        } else if (l1.length() > 2){
            int count2 = l1.length() / 2;
            leftpart = l1.substring(0, count2);
            rightpart = l1.substring(count2);
            leftpartint = Integer.parseInt(leftpart);
            rightpartint = Integer.parseInt(rightpart);
            return leftpartint + rightpartint == a;
        } else {
            leftpartint = 0;
            rightpart = l1;
            rightpartint = Integer.parseInt(rightpart);
            return leftpartint + rightpartint == a;
        }
    }

    public static String longestZero(String s) {
        String res;
        int count1 = 0;
        int count2 = 0;
        char[] arr = s.toCharArray();

        for (char c : arr) {
            String a = String.valueOf(c);
            if (a.equals("0")) {
                count1++;
            } else {
                count1 = 0;
            }
            count2 = Math.max(count1, count2);
        }
        res = "0".repeat(count2);
        return res;
        }

    public static int nextPrime(int a) {
        if (Primes.isPrime(a)) {
            return a;
        } else {
            for (int i = a; i < 100; i++) {
                if (Primes.isPrime(i)) {
                    return i;
                }
            }
        }
        return a;
    }

    public static boolean rightTriangle(int a, int b, int c) {
        if (!(a + b > c) || !(b + c > a) || !(a + c > b)) {
            return false;
        } else {
            a = a * a;
            b = b * b;
            c = c * c;
            return a + b == c || b + c == a || a + c == b;
        }
    }
}
