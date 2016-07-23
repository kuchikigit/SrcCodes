package net.mindview.reusing;
//: reusing/PlaceSetting.java
// Combining composition & inheritance.
import static net.mindview.util.Print.*;

class Plate {
  Plate(int i) {
    print("Plate constructor:: " + i);
  }
}

class DinnerPlate extends Plate {
  DinnerPlate(int i) {
    super(i);
    print("DinnerPlate constructor:: " + i);
  }
}	

class Utensil {
  Utensil(int i) {
    print("Utensil constructor:: " + i);
  }
}

class Spoon extends Utensil {
  Spoon(int i) {
    super(i);
    print("Spoon constructor:: " + i);
  }
}

class Fork extends Utensil {
  Fork(int i) {
    super(i);
    print("Fork constructor:: " + i);
  }
}	

class Knife extends Utensil {
  Knife(int i) {
    super(i);
    print("Knife constructor:: " + i);
  }
}

// A cultural way of doing something:
class Custom {
  Custom(int i) {
    print("Custom constructor:: " + i);
  }
}	

public class PlaceSetting extends Custom {
  private Spoon sp;
  private Fork frk;
  private Knife kn;
  private DinnerPlate pl;
  public PlaceSetting(int i) {
    super(i + 1);
    sp = new Spoon(i + 2);
    frk = new Fork(i + 3);
    kn = new Knife(i + 4);
    pl = new DinnerPlate(i + 5);
    print("PlaceSetting constructor:: " + i);
  }
  public static void main(String[] args) {
    PlaceSetting x = new PlaceSetting(9);
  }
} /* Output:
Custom constructor
Utensil constructor
Spoon constructor
Utensil constructor
Fork constructor
Utensil constructor
Knife constructor
Plate constructor
DinnerPlate constructor
PlaceSetting constructor
*///:~
