import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Lesson_3 {
    public static void main(String[] args) {
//      Exp1 На вход приходят два ArrayList<Integer> напишите метод, который проверяет два массива на равенство.
//      Нужно реализовать алгоритм, не использовать метод equals.

        ArrayList<Integer> exp1_arr1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> exp1_arr2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Exp1: " + ArrayListEquals(exp1_arr1, exp1_arr2));

//      Exp2 На вход методу приходят два ArrayList<Integer> и целое число num.
//      Проверьте, что число num встречается в обоих массивах одинаковое кол-во раз.

        ArrayList<Integer> exp2_arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        ArrayList<Integer> exp2_arr2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        Integer num = 5;
        System.out.println("Exp2: " + IsEqualCountInArray(exp2_arr1, exp2_arr2, num));

//      Exp3 На вход приходит ArrayList<Integer>.
//      Отсортируйте в нем только четные числа. Пример: [10, 4, 5, 6, 7, 2, 2, 9] -> [2, 2, 5, 4, 7, 6, 10, 9]

        ArrayList<Integer> exp3_arr = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9));
        System.out.println("Exp3: " + SortedEvenNum(exp3_arr));

//      Exp4 На вход приходт ArrayList<Integer> удалите из него четные числа (на итератор)

        ArrayList<Integer> exp4_arr = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9));
        System.out.println("Exp4: " + ArrayWOEvenNum(exp4_arr));
    }

    public static boolean ArrayListEquals(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        if (array1.size() != array2.size()) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsEqualCountInArray(ArrayList<Integer> array1, ArrayList<Integer> array2, Integer num) {
        int cnt = 0;
        for (int i = 0; i < array1.size(); i++) if (array1.get(i) == num) cnt++;
        for (int i = 0; i < array2.size(); i++) if (array2.get(i) == num) cnt--;
        if (cnt == 0) return true;
        return false;
    }

    public static ArrayList<Integer> SortedEvenNum(ArrayList<Integer> array) {
        ArrayList<Integer> EvenNumArray = new ArrayList<>();
        ArrayList<Integer> NewNumArray = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if ((array.get(i) & 1) == 0) {
                EvenNumArray.add(array.get(i));
            }
        }
        Collections.sort(EvenNumArray);
        int a = 0;
        for (int i = 0; i < array.size(); i++) {
            if ((array.get(i) & 1) == 0) {
                NewNumArray.add(EvenNumArray.get(a));
                a += 1;
            } else {
                NewNumArray.add(array.get(i));
            }
        }
        return NewNumArray;
    }

    public static ArrayList<Integer> ArrayWOEvenNum(ArrayList<Integer> array) {
        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            Object curr = iterator.next();
            if ((curr.hashCode() & 1) == 0) {
                iterator.remove();
            }
        }
        return array;
    }
}
