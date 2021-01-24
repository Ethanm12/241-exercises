package week09;
import java.util.List;

public interface ExamPile{
  public void load(List<Integer> items);
  public int peek();
  public int mark(int depth, int value);
  public void delay(int count);
} 