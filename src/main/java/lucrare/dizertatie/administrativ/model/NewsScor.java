package lucrare.dizertatie.administrativ.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewsScor implements Serializable {
    private String oxygenAssistance;

    private String oxygenSaturation;

    private String pulse;

    private String respiratoryRate;

    private String systolicBloodPressure;

    private String temperature;

    private String total;

    private String pacientId;
}
