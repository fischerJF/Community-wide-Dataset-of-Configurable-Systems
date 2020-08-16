package tests;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import org.junit.Assert;
import org.junit.Test;
import org.softlang.util.AddDoubles;
import org.softlang.util.AddToList;
import org.softlang.util.MaxDoubles;
import org.softlang.util.ObservableSimpleList;
import org.softlang.util.RemoveFromList;
import org.softlang.util.SimpleLinkedList;
import org.softlang.util.SimpleList;

public class TestUtil extends CompaniesTest {

//  protected void configure() {
//    super.configure();
//    
//    if (testName == null) {
//      throw new RuntimeException();
//    }
//    
//    String strTestName = testName.getMethodName();
//    //FIXME do we need to add an "if" for each method here?
//  }
  
  @Test
  public void testAddDoubles() {
    double[] arr = new double[10];
    Arrays.fill(arr, 10.0);
    
    double total = AddDoubles.getInstance().unit();
    for (double d : arr) {
      total = AddDoubles.getInstance().append(d, total);
    }
    
    Assert.assertEquals(100, total, 0.0001);
  }
  
  @Test
  public void testMaxDoubles() {
    double[] arr = new double[10];
    Arrays.fill(arr, 10.0);
    
    Double total = MaxDoubles.getInstance().unit();
    for (double d : arr) {
      total = MaxDoubles.getInstance().append(d, total);
    }
    
    Assert.assertEquals(10, total, 0.0001);
    
    arr[5] = 100.13;
    total = MaxDoubles.getInstance().unit();
    for (double d : arr) {
      total = MaxDoubles.getInstance().append(d, total);
    }
    
    Assert.assertEquals(100.13, total, 0.0001);
  }
  
  @Test
  public void testNullObservableListOperations() {
    ObservableSimpleList list = new ObservableSimpleList<Double>(null);
    
    try {
      list.add(2.0);
      Assert.assertTrue(false);
    } catch (NullPointerException e) {
      //expected exception
    }
  }
  
  @Test
  public void testObservableListOperations() {
    SimpleList<Double> list = new SimpleLinkedList<Double>();
    ObservableSimpleList<Double> olist = new ObservableSimpleList<Double>(list);
    
    olist.add(2.0);
    olist.add(2.0);
    
    Iterator<Double> it = list.iterator();
    Iterator<Double> oit = list.iterator();
    
    while (it.hasNext()) {
      Assert.assertEquals(it.next(), oit.next(),0.0000001);
    }
    
    Assert.assertFalse(oit.hasNext());
  }
  
  @Test
  public void testObservableListObservations() {
    SimpleList<Double> list = new SimpleLinkedList<Double>();
    final ObservableSimpleList<Double> olist = new ObservableSimpleList<Double>(list);
    
    olist.addObserver(new Observer() {
      @Override
      public void update(Observable o, Object arg) {
        Assert.assertEquals(olist, o);
        if (arg instanceof AddToList) {
          Double d = (Double) ((AddToList) arg).element; 
          Assert.assertTrue(d > 0);
        } else {
          Assert.assertTrue(arg instanceof RemoveFromList);
          Double d = (Double) ((RemoveFromList) arg).element;
          Assert.assertTrue(d > 0);
        }
      }
    });
    
    olist.add((double) 50);
    list.add((double) -50);
    olist.add(100.0);
    
    olist.remove(50.0);
    list.remove(-50.0);
    olist.remove(100.0);
  }
}
