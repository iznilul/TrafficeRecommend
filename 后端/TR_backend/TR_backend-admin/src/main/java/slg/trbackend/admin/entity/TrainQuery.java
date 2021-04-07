package slg.trbackend.admin.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@ApiModel(value = "列车类",description = "查询列车")
@Data
public class TrainQuery implements Serializable {

    @ApiModelProperty(value = "起始城市")
    private String StartCity;

    @ApiModelProperty(value = "结束城市")
    private String EndCity;

    @ApiModelProperty(value = "起始和结束城市")
    private String StartAndEndCity;

    @ApiModelProperty(value = "起始站")
    private String StartTrainstation;

    @ApiModelProperty(value = "结束站")
    private String EndTrainstation;

    @ApiModelProperty(value = "推荐依据1")
    private Integer recommand;

}
