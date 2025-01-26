package dev.dhiraj.productservicef.repositories.projections;

import dev.dhiraj.productservicef.models.Category;

public interface ProductProjection {
    Long getId();
    String getTitle();
    String getDescription();
    Double getPrice();
    String getImage();
    Category getCategory();
}
