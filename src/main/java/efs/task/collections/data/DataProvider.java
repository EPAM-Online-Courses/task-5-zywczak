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
        List<Town> listTowns = new ArrayList<>(Data.baseTownsArray.length);

        for (String town : Data.baseTownsArray) {
            String[] parts = town.split(DATA_SEPARATOR);

            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].replace(" ", "");
            }

            listTowns.add(new Town(parts[0], new ArrayList<>(Arrays.asList(parts[1], parts[2]))));
        }

        return listTowns;
    }
    

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> listDlcTowns = new ArrayList<>( Data.dlcTownsArray.length);

        for (String dlcTown : Data.dlcTownsArray) {

            String[] parts = dlcTown.split(DATA_SEPARATOR);

            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].replace(" ", "");
            }

            listDlcTowns.add(new Town(parts[0], new ArrayList<>(Arrays.asList(parts[1], parts[2]))));
        }

        return listDlcTowns;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
       Set<Hero> heroesDlcSet  = new HashSet<>();

        for (String hero : Data.dlcCharactersArray) {

            String[] parts = hero.split(DATA_SEPARATOR);

            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].replace(" ", "");
            }


            heroesDlcSet .add(new Hero(parts[0],parts[1]));

        }

        return heroesDlcSet;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> dlcHeroesSet = new HashSet<>();

        for (String heroData : Data.dlcCharactersArray) {
            String[] heroInfo = heroData.split(DATA_SEPARATOR);
            String heroName = heroInfo[0].trim();
            String heroClass = heroInfo[1].trim();

            Hero hero = new Hero(heroName, heroClass);
            dlcHeroesSet.add(hero);
        }

        return dlcHeroesSet;
    }
}
