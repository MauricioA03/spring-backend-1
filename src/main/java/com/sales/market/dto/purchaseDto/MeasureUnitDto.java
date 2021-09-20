/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.dto.purchaseDto;

import com.sales.market.dto.DtoBase;
import com.sales.market.model.purchases.MeasureUnit;

public class MeasureUnitDto extends DtoBase<MeasureUnit> {
    private String measureUnitCode;
    private String name;
    private String description;

    public String getMeasureUnitCode() {
        return measureUnitCode;
    }

    public void setMeasureUnitCode(String measureUnitCode) {
        this.measureUnitCode = measureUnitCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
