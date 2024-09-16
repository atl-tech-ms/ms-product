package az.atl.productms.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class ExceptionResponse {
    Integer status;
    String error;
    String message;
    String path;
    LocalDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, String> validationErrors;
}