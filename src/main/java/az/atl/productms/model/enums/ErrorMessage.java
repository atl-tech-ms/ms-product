package az.atl.productms.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    PRODUCT_NOT_FOUND("Product not found with id: %d");

    private final String message;

    public String format(Object... args) {
        return String.format(message, args);
    }
}
