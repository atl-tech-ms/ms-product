package az.atl.productms.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SaveProductDto {

    @Size(min = 3, max = 50, message = "Name Required - The name must be between 3 and 50 characters.")
    String name;

    @NotNull(message = "Price Required")
    BigDecimal price;

    @NotNull(message = "Count Required")
    Integer count;
}
