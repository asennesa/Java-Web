package app.model.entity;

import javax.persistence.*;

@Entity
@Table(name ="heroes")
public class Hero extends BaseEntity {
    private String name;
    private HeroClass aHeroClass;
    private Integer level;

    public Hero() {
    }
    @Column(name ="name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name= "class")
    @Enumerated(EnumType.STRING)
    public HeroClass getaHeroClass() {
        return aHeroClass;
    }

    public void setaHeroClass(HeroClass aHeroClass) {
        this.aHeroClass = aHeroClass;
    }
    @Column(name= "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
