package fr.utbm.info.ia54.mallproject.model;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SarlSpecification("0.10")
@SarlElementType(15)
@SuppressWarnings("all")
public class CustomerInitializedEvent extends Event {
  public final UUID customerID;
  
  public final Circle circle;
  
  public final List<Point2D> objectives;
  
  public CustomerInitializedEvent(final UUID customerID, final Circle circle, final List<Point2D> objectives) {
    this.customerID = customerID;
    this.circle = circle;
    this.objectives = objectives;
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
    CustomerInitializedEvent other = (CustomerInitializedEvent) obj;
    if (!Objects.equals(this.customerID, other.customerID)) {
      return false;
    }
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.customerID);
    return result;
  }
  
  /**
   * Returns a String representation of the CustomerInitializedEvent event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected void toString(final ToStringBuilder builder) {
    super.toString(builder);
    builder.add("customerID", this.customerID);
    builder.add("circle", this.circle);
    builder.add("objectives", this.objectives);
  }
}
