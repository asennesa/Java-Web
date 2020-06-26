package app.model.binding;

import app.model.entity.HeroClass;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HeroAddBindingModel {
    private String heroName;
    private HeroClass heroClass;
    private Integer level;

    public HeroAddBindingModel() {
    }

    @Length(min = 2, message = "Name length must be at least two characters")
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    @Min(value = 0, message = "Level must be a positive number.")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    @NotNull(message = "Enter valid class.")
    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }
}
