package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.List;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        List<Town> townsList = new ArrayList<>();

        for (String townData : Data.baseTownsArray) {
            String[] townDetails = townData.split(DATA_SEPARATOR);
            String townName = townDetails[0].trim();
            String hero1 = townDetails[1].trim();
            String hero2 = townDetails[2].trim();
            townsList.add(new Town(townName, hero1, hero2));
        }

        return townsList;
    }
    

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> dlcTownsList = new ArrayList<>();

        for (String townData : Data.dlcTownsArray) {
            String[] townDetails = townData.split(DATA_SEPARATOR);
            String townName = townDetails[0].trim();
            String hero1 = townDetails[1].trim();
            String hero2 = townDetails[2].trim();
            dlcTownsList.add(new Town(townName, hero1, hero2));
        }

        return dlcTownsList;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        Set<Hero> heroesSet = new HashSet<>();

        for (String heroData : Data.baseCharactersArray) {
            String[] heroDetails = heroData.split(DATA_SEPARATOR);
            String heroName = heroDetails[0].trim();
            String heroClass = heroDetails[1].trim();
            heroesSet.add(new Hero(heroName, heroClass));
        }

        return heroesSet;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> dlcHeroesSet = new HashSet<>();

        for (String heroData : Data.dlcCharactersArray) {
            String[] heroDetails = heroData.split(DATA_SEPARATOR);
            String heroName = heroDetails[0].trim();
            String heroClass = heroDetails[1].trim();
            dlcHeroesSet.add(new Hero(heroName, heroClass));
        }

        return dlcHeroesSet;
    }
}
