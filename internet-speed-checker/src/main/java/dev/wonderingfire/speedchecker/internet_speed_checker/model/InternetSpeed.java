package dev.wonderingfire.speedchecker.internet_speed_checker.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InternetSpeed {

    private double download_speed;
    private String init_datetime;
    private String id;
    private String end_datetime;
    private String isp_name;
    private double upload_speed;
}
