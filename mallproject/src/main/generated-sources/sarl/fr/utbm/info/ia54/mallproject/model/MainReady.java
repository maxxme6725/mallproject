package fr.utbm.info.ia54.mallproject.model;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

@SarlSpecification("0.10")
@SarlElementType(15)
@SuppressWarnings("all")
public class MainReady extends Event {
  @SyntheticMember
  public MainReady() {
    super();
  }
  
  @SyntheticMember
  public MainReady(final Address source) {
    super(source);
  }
  
  @SyntheticMember
  private static final long serialVersionUID = 588368462L;
}
