import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final int length = 10;
        List<Integer> numbers = new ArrayList<>(length);
        for(int i = 0; i < length; i++){
            numbers.add(getRandomNumber(-15, 15));
        } //random fill numbers

        showNumbers("Исходный список ", numbers);
        showNumbers("Сотировка по возрастанию: ", ascendingSort(numbers));
        showNumbers("Сотировка по убыванию: ", descendingSort(numbers));
        showNumbers("Исходный список не изменился: ", numbers);
        showNumbers("Список только из без чётных чисел и 0: ", filteredNumbers(numbers));
        System.out.println("Конвертированный массив чисел в строку " + convertToString(numbers));

    }
    static public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    static public void showNumbers(String str, List<Integer> numbers) {
        System.out.println(str + numbers);
    }
    static public void showNumbers(List<Integer> numbers){
        System.out.println(numbers);
    }
    static public List<Integer> ascendingSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    static public List<Integer> descendingSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    static public List<Integer> filteredNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0 && number != 0)
                .collect(Collectors.toList());
    }

    static public List<String> convertToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

    }
}