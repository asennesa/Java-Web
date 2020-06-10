package demos.spring.vehicles.model.binding;

import demos.spring.vehicles.model.entity.Brand;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

public class ModelAddBindingModel {
    private String name;
    private Integer startYear;
    private Integer endYear;
    private Brand brand;
    private String imageUrl;

    public ModelAddBindingModel() {
    }

    @Length(min = 1, max = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(1900)
    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    @Min(1900)
    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Length(min = 8, max = 512)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
