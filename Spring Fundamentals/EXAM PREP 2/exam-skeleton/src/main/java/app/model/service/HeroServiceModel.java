package app.model.service;

import app.model.entity.HeroClass;

public class HeroServiceModel extends BaseServiceEntity {
    private String name;
    private HeroClass aHeroClass;
    private Integer level;

    public HeroServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroClass getaHeroClass() {
        return aHeroClass;
    }

    public void setaHeroClass(HeroClass aHeroClass) {
        this.aHeroClass = aHeroClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
