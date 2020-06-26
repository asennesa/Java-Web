package app.model.binding;

import app.model.entity.HeroClass;

public class HeroDeleteBindingModel {
    private String heroName;
    private HeroClass heroClass;
    private Integer level;

    public HeroDeleteBindingModel() {
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
