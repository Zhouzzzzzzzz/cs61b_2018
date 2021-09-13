import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    @Test
    public void testArrayDequeGold() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque();
        ArrayDequeSolution<Integer> array = new ArrayDequeSolution();

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i <= 100) {
            int Element = StdRandom.uniform(10);
            int Cases = StdRandom.uniform(4);
            if (student.isEmpty()) {
                double random = StdRandom.uniform();
                if (random < 0.5) {
                    student.addFirst(Element);
                    array.addFirst(Element);
                    builder.append(String.format("addFirst(%d)\n", Element));
                } else {
                    student.addLast(Element);
                    array.addLast(Element);
                    builder.append(String.format("addLast(%d)\n", Element));
                }
            }
            switch (Cases) {
                case 0:
                    student.addFirst(Element);
                    array.addFirst(Element);
                    builder.append(String.format("addFirst(%d)\n", Element));
                    i++;
                    break;
                case 1:
                    student.addLast(Element);
                    array.addLast(Element);
                    builder.append(String.format("addLast(%d)\n", Element));
                    i++;
                    break;
                case 2:
                    builder.append("removeFirst()\n");
                    Integer expect1 = array.removeFirst();
                    Integer actual1 = student.removeFirst();
                    assertEquals(builder.toString(), expect1, actual1);
                    i++;
                    break;
                case 3:
                    builder.append("removeLast()\n");
                    Integer expect2 = array.removeLast();
                    Integer actual2 = student.removeLast();
                    assertEquals(builder.toString(), expect2, actual2);
                    i++;
                    break;
            }
        }
    }
}