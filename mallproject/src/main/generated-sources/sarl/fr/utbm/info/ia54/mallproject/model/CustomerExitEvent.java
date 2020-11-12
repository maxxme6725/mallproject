package fr.utbm.info.ia54.mallproject.model;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.Objects;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SarlSpecification("0.10")
@SarlElementType(15)
@SuppressWarnings("all")
public class CustomerExitEvent extends Event {
  public final UUID customerID;
  
  public final Long timeAlive;
  
  public CustomerExitEvent(final UUID customerID, final Long timeAlive) {
    this.customerID = customerID;
    this.timeAlive = timeAlive;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CustomerExitEvent other = (CustomerExitEvent) obj;
    if (!Objects.equals(this.customerID, other.customerID)) {
      return false;
    }
    if (other.timeAlive != this.timeAlive)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.customerID);
    result = prime * result + (int) (this.timeAlive ^ (this.timeAlive >>> 32));
    return result;
  }
  
  /**
   * Returns a String representation of the CustomerExitEvent event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected void toString(final ToStringBuilder builder) {
    super.toString(builder);
    builder.add("customerID", this.customerID);
    builder.add("timeAlive", this.timeAlive);
  }
}
