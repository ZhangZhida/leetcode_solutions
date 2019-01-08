public class Solution {
    public int[] largestAndSecond(int[] array) {
      // Assumptions: The given array is not null and has length of at least 2
      Element[] elems = convert(array);
      int comparedLength = array.length;
      while (comparedLength > 1) {
        compareAndSwap(elems, comparedLength);
        comparedLength = (comparedLength + 1) / 2;
      }
      int largest = elems[0].value;
      int secondLargest = largest(elems[0].comparedValues);
      return new int[] {largest, secondLargest};
    }
    
    static class Element {
      int value;
      List<Integer> comparedValues;
      Element(int value) {
        this.value = value;
        this.comparedValues = new ArrayList<>();
      }
    }
    
    private void compareAndSwap(Element[] elems, int compareLength) {
      for (int i = 0; i < compareLength / 2; i++) {
        if (elems[i].value < elems[compareLength - 1 - i].value) {
          swap(elems, i, compareLength - 1 - i);
        }
        elems[i].comparedValues.add(elems[compareLength - 1 - i].value);
      }
    }
    
    private Element[] convert(int[] array) {
      Element[] elems = new Element[array.length];
      for (int i = 0; i < array.length; i++) {
        elems[i] = new Element(array[i]);
      }
      return elems;
    }
    
    private int largest(List<Integer> values) {
      int largest = Integer.MIN_VALUE;
      for (int value : values) {
        largest = Math.max(value, largest);
      }
      return largest;
    }
    
    private void swap(Element[] array, int i, int j) {
      Element temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }