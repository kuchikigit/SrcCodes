//: interfaces/interfaceprocessor/FilterProcessor.java
package net.mindview.interfaces.interfaceprocessor;
import net.mindview.interfaces.filters.BandPass;
import net.mindview.interfaces.filters.Filter;
import net.mindview.interfaces.filters.HighPass;
import net.mindview.interfaces.filters.LowPass;
import net.mindview.interfaces.filters.Waveform;

class FilterAdapter implements Processor {
  Filter filter;
  public FilterAdapter(Filter filter) {
    this.filter = filter;
  }
  public String name() { return filter.name(); }
  public Waveform process(Object input) {
    return filter.process((Waveform)input);
  }
}	

public class FilterProcessor {
  public static void main(String[] args) {
    Waveform w = new Waveform();
    Apply.process(new FilterAdapter(new LowPass(1.0)), w);
    Apply.process(new FilterAdapter(new HighPass(2.0)), w);
    Apply.process(
      new FilterAdapter(new BandPass(3.0, 4.0)), w);
  }
} /* Output:
Using Processor LowPass
Waveform 0
Using Processor HighPass
Waveform 0
Using Processor BandPass
Waveform 0
*///:~
