import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    @Test
    public void testArrayDequeGold() {
        StudentArrayDeque student = new StudentArrayDeque();
        ArrayDequeSolution array = new ArrayDequeSolution();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            int Element = StdRandom.uniform(10);
            int Cases = StdRandom.uniform(4);
            if (array.isEmpty()) {
                Cases /= 2;
            }
            switch (Cases) {
                case 0:
                    student.addFirst(Element);
                    array.addFirst(Element);
                    builder.append(String.format("addfirst(%d)\n", Element));
                    break;
                case 1:
                    student.addLast(Element);
                    array.addLast(Element);
                    builder.append(String.format("addlast(%d)\n", Element));
                    break;
                case 2:
                    builder.append("removeFirst()\n");
                    assertEquals(builder.toString(), student.removeFirst(), array.removeFirst());
                    break;
                case 3:
                    student.removeLast();
                    array.removeLast();
                    builder.append("removeLast()\n");
                    assertEquals(builder.toString(), student.removeLast(), array.removeLast());
                    break;
            }
        }

    }
}