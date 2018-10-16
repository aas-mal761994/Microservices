import java.util.HashSet;
import java.util.Set;

public class EqualStacks {
    public static void main(String[] args) {
        int arr1[] = {3, 2, 1, 1, 1};
        int arr2[] = {4, 3, 2};
        int arr3[] = {1, 1, 4, 1};
        System.out.println(equalStacks(arr1, arr2, arr3));
    }

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();
        for (int i = 0; i < h1.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += h1[j];
            }
            s1.add(sum);
        }
        for (int i = 0; i < h2.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += h2[j];
            }
            if (s1.contains(sum)) {
                s2.add(sum);
            }
        }
        for (int i = 0; i < h3.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += h3[j];
            }
            if (s2.contains(sum)) {
                s3.add(sum);
            }
        }

        return s3.stream().findFirst().get();
    }
}
