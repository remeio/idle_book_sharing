package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.ChineseLength;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/3/25 14:18
 */
@Getter
@Setter
public class UploadBookRequest extends BaseRequest {
    /**
     * 书籍名称
     */
    @ApiModelProperty("书籍名称")
    @ChineseLength(min = 1, max = 50)
    private String bookName;

    /**
     * 书籍ISBN
     */
    @ApiModelProperty("书籍ISBN")
    private String bookIsbn;

    /**
     * 书籍描述
     */
    @ApiModelProperty("书籍描述")
    @ChineseLength(min = 1, max = 500)
    private String bookDescription;

    /**
     * 书籍借出最大周期
     */
    @ApiModelProperty("书籍借出最大周期")
    @Min(7)
    @Max(98)
    private Integer bookMaxPeriod;

    /**
     * 书籍所需押金
     */
    @ApiModelProperty("书籍所需押金")
    @Min(0)
    @Max(99)
    private Integer bookDeposit;

    /**
     * 书籍图片URL
     */
    @ApiModelProperty("书籍图片URL")
    @NotBlank
    private String bookImageUrl;

    /**
     * 书籍分类ID
     */
    @ApiModelProperty("书籍分类ID")
    @NotNull
    private Long bookCatalogId;
}
