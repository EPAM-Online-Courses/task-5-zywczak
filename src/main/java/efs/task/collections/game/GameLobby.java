package efs.task.collections.game;

import efs.task.collections.data.DataProvider;
import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameLobby {

    public static final String HERO_NOT_FOUND = "Nie ma takiego bohatera ";
    public static final String NO_SUCH_TOWN = "Nie ma takiego miasta ";

    private final DataProvider dataProvider;
    private Map<Town, List<Hero>> playableTownsWithHeroesList;

    public GameLobby() {
        this.dataProvider = new DataProvider();
        this.playableTownsWithHeroesList =
                mapHeroesToStartingTowns(dataProvider.getTownsList(), dataProvider.getHeroesSet());
    }

    public Map<Town, List<Hero>> getPlayableTownsWithHeroesList() {
        return playableTownsWithHeroesList;
    }

    //TODO Dodać miasta i odpowiadających im bohaterów z DLC gry do mapy dostępnych
    // miast - playableTownsWithHeroesList, tylko jeżeli jeszcze się na niej nie znajdują.
    public void enableDLC() {
        List<Town> dlcTownsList = DataProvider.getDLCTownsList();
        Set<Hero> dlcHeroesSet = DataProvider.getDLCHeroesSet();

        for (Town town : dlcTownsList) {
            if (!playableTownsWithHeroesList.containsKey(town)) {
                playableTownsWithHeroesList.put(town, new HashSet<>());
            }
        }

        for (Hero hero : dlcHeroesSet) {
            boolean heroExists = false;
            for (Set<Hero> heroesSet : playableTownsWithHeroesList.values()) {
                if (heroesSet.contains(hero)) {
                    heroExists = true;
                    break;
                }
            }
            if (!heroExists) {
                for (Town town : playableTownsWithHeroesList.keySet()) {
                    if (town.getHeroClass1().equals(hero.getHeroClass()) || town.getHeroClass2().equals(hero.getHeroClass())) {
                        playableTownsWithHeroesList.get(town).add(hero);
                        break;
                    }
                }
            }
        }
    }


    //TODO Usunąć miasta i odpowiadających im bohaterów z DLC gry z mapy dostępnych
    // miast - playableTownsWithHeroesList.
    public void disableDLC() {
        List<Town> dlcTownsList = DataProvider.getDLCTownsList();

        for (Town town : dlcTownsList) {
            playableTownsWithHeroesList.remove(town);
        }
    }

    // TODO Sprawdza czy mapa playableCharactersByTown zawiera dane miasto.
    //  Jeśli tak zwróć listę bohaterów z tego miasta.
    //  Jeśli nie rzuć wyjątek NoSuchElementException z wiadomością NO_SUCH_TOWN + town.getName()
    public List<Hero> getHeroesFromTown(Town town) { 
        if (playableCharactersByTown.containsKey(town)) {
            return playableCharactersByTown.get(town);
        } else {
            throw new NoSuchElementException("NO_SUCH_TOWN: " + town.getName());
        }
    }

    // TODO Metoda powinna zwracać mapę miast w kolejności alfabetycznej z odpowiadającymi im bohaterami.
    //  Każde z miast charakteryzuje się dwoma klasami bohaterów dostępnymi dla tego miasta - Town.startingHeroClass.
    //  Mapa ma zawierać pare klucz-wartość gdzie klucz: miasto, wartość: lista bohaterów;
    public Map<Town, List<Hero>> mapHeroesToStartingTowns(List<Town> availableTowns, Set<Hero> availableHeroes) {
        Map<Town, List<Hero>> heroesByStartingTowns = new TreeMap<>(Comparator.comparing(Town::getName));

        for (Town town : availableTowns) {
            List<Hero> heroesForTown = new ArrayList<>();
            for (Hero hero : availableHeroes) {
                if (town.getStartingHeroClass().equals(hero.getHeroClass())) {
                    heroesForTown.add(hero);
                }
            }
            heroesByStartingTowns.put(town, heroesForTown);
        }

        return heroesByStartingTowns;
    }

    //TODO metoda zwraca wybranego bohatera na podstawie miasta z którego pochodzi i imienia.
    // Jeżeli istnieje usuwa go z listy dostępnych bohaterów w danym mieście i zwraca bohatera.
    // Jeżeli nie ma go na liście dostępnych bohaterów rzuca NoSuchElementException z wiadomością HERO_NOT_FOUND + name
    public Hero selectHeroByName(Town heroTown, String name) {
        List<Hero> availableHeroes = playableCharactersByTown.get(heroTown);

        if (availableHeroes != null) {
            for (Iterator<Hero> iterator = availableHeroes.iterator(); iterator.hasNext();) {
                Hero hero = iterator.next();
                if (hero.getName().equals(name)) {
                    iterator.remove();
                    return hero;
                }
            }
        }

        throw new NoSuchElementException("HERO_NOT_FOUND: " + name);
    }
}
