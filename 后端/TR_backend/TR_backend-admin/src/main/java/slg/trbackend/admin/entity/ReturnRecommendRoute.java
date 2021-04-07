package slg.trbackend.admin.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @author Administrator
 */
@Data
@ApiModel(value = "列车类",description = "返回推荐路线")
public class ReturnRecommendRoute {

    @ApiModelProperty(value = "返回开始城市和结束城市")
    private String JourneyName;

    @ApiModelProperty(value = "返回开始城市")
    private String DepartureStationName;

    @ApiModelProperty(value = "返回开始城市的纬度")
    private Float DepartureStationNameLocationLat;

    @ApiModelProperty(value = "返回开始城市的经度")
    private Float DepartureStationNameLocationLng;

    @ApiModelProperty(value = "返回结束城市")
    private String ArriveStationName;

    @ApiModelProperty(value = "返回结束城市的纬度")
    private Float ArriveStationNameLocationLat;

    @ApiModelProperty(value = "返回结束城市的经度")
    private Float ArriveStationNameLocationLng;

    @ApiModelProperty(value = "推荐值总分")
    private double recommad;

    @ApiModelProperty(value = "车辆名称")
    private String VehicleName;

    @ApiModelProperty(value = "出发时间")
    private String departureTime;

    @ApiModelProperty(value = "结束时间")
    private String ArriveTime;

    @ApiModelProperty(value = "价格")
    private double thePrice;

}
