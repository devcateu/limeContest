import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawek on 2015-09-29.
 */
public class CounterTheLongestDynamicFilm {
    public static int count(int maxCuts, String scene) {//"DSDSSDSD"
        List<Integer> list = createListOfD(scene);

        List<Integer> list1 = new ArrayList<Integer>(list.size());
        list1.addAll(list);
        int maxValueFirstCase = firstCase(maxCuts, list1);
        int maxValueSecondCase = secondCase(maxCuts, list);

        if (maxValueFirstCase > maxValueSecondCase) {
            return maxValueFirstCase;
        } else {
            return maxValueSecondCase;
        }
    }


    private static int secondCase(int maxCuts, List<Integer> list) {
        if (maxCuts % 2 == 0 || list.get(0) == 0 || list.get(list.size() - 1) == 0 || list.size() < 2) {
            return 0;
        } else {
            list.set(0, list.get(0) + list.get(list.size() - 1));
            return firstCase(maxCuts - 1, list);
        }
    }

    private static int firstCase(int maxCuts, List<Integer> list) {
        int restCuts = maxCuts;
        int maxValueForIndex1 = searchMaxIndex(list);
        int maxValue1 = list.get(maxValueForIndex1);
        list.set(maxValueForIndex1, 0);

        while (restCuts > 0) {

            int maxValueForIndex2 = searchMaxIndex(list);
            int maxValue2 = list.get(maxValueForIndex2);
            if (maxValue2 == 0) {
                break;
            }
            restCuts -= getRestCuts(list, maxValueForIndex1, maxValueForIndex2);
            if (restCuts > -1) {
                maxValue1 = maxValue1 + maxValue2;
                list.set(maxValueForIndex2, 0);
            }
        }

        return maxValue1;
    }

    private static int getRestCuts(List<Integer> list, int maxvalueForIndex, int maxvalueForIndexNext) {
        int restCost;
        if (maxvalueForIndexNext < maxvalueForIndex) {
            int temp = maxvalueForIndex;
            maxvalueForIndex = maxvalueForIndexNext;
            maxvalueForIndexNext = temp;
        }

        if (maxvalueForIndex == 0 && maxvalueForIndexNext == list.size() - 1) {
            restCost = 1;
        } else {
            restCost = 2;
        }
        return restCost;
    }

    public static List<Integer> createListOfD(String scene) {
        List<Integer> listD = new ArrayList<Integer>();
        char prevCharacter = 'D';
        int count = 0;
        for (char currCharecter : scene.toCharArray()) {
            if (prevCharacter != currCharecter) {
                if (prevCharacter == 'D') {
                    listD.add(count);
                }
                prevCharacter = currCharecter;
                count = 1;
            } else {
                count++;
            }
        }

        if (prevCharacter == 'D') {
            listD.add(count);
        } else {
            listD.add(0);
        }
        return listD;
    }

    public static int searchMaxIndex(List<Integer> integers) {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > maxValue) {
                maxIndex = i;
                maxValue = integers.get(i);
            }
        }
        if (integers.get(integers.size() - 1) >= maxValue) {
            maxIndex = integers.size() - 1;
        }
        return maxIndex;
    }
}
