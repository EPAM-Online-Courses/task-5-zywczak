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
        List<Town> listTowns = new ArrayList<>();
        for (String town : Data.baseTownsArray) {
            String[] townData = town.split(DATA_SEPARATOR);
            List<String> parts = new ArrayList<>();
            parts.add(townData[1].trim());
            parts.add(townData[2].trim());
            listTowns.add(new Town(townData[0], parts));
        }
        return listTowns;
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> listDlcTowns = new ArrayList<>();
        for (String town : Data.dlcTownsArray) {
            String[] townData = town.split(DATA_SEPARATOR);
            List<String> parts = new ArrayList<>();
            parts.add(townData[1].trim());
            parts.add(townData[2].trim());
            listDlcTowns.add(new Town(townData[0], parts));
        }
        return listDlcTowns;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        Set<Hero> heroesSet = new HashSet<>();
        for (String hero : Data.baseCharactersArray) {
            String[] parts = hero.split(DATA_SEPARATOR);
            heroesSet.add(new Hero(parts[0].trim(), parts[1].trim()));
        }
        return heroesSet;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> heroesDlcSet = new HashSet<>();
        for (String hero : Data.dlcCharactersArray) {
            String[] parts = hero.split(DATA_SEPARATOR);
            heroesDlcSet.add(new Hero(parts[0].trim(), parts[1].trim()));
        }
        return heroesDlcSet;
    }
}
