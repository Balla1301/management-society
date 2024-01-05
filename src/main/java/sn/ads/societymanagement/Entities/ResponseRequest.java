package sn.ads.societymanagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseRequest {
    private boolean error;
    private String message;
}
