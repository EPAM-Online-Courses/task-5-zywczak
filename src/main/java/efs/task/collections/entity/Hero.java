package efs.task.collections.entity;

public class Hero {
    private String name;
    private String heroClass;

    public Hero(String name, String heroClass) {
        this.name = name;
        this.heroClass = heroClass;
    }

    public String getName() {
        return name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    //TODO implementacja metody equal porównująca obiekty Hero na podstawie pól name i heroClass.
    @Override
    public boolean equals(Object o) {      
        if (this == o){
            return true;
        }
        if (o == null || Hero.class != o.getClass()){
            return false;
        }
        Hero hero = (Hero) o;
        
        return name.equals(hero.name) && heroClass.equals(hero.heroClass);
    }

    //TODO implementacja metody equal biorąca pod uwagę name i heroClass.
    @Override
    public int hashCode() {
        return name.hashCode() + heroClass.hashCode();
    }

    @Override
    public String toString() {
        return "My name is " + name + "and I am " + heroClass;
    }
}
