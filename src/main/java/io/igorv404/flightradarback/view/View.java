package io.igorv404.flightradarback.view;

import io.igorv404.flightradarback.airport.Airport;
import io.igorv404.flightradarback.airport.implementation.AiportControllerImpl;
import io.igorv404.flightradarback.city.City;
import io.igorv404.flightradarback.city.implementation.CityControllerImpl;
import io.igorv404.flightradarback.company.Company;
import io.igorv404.flightradarback.company.implementation.CompanyControllerImpl;
import io.igorv404.flightradarback.country.Country;
import io.igorv404.flightradarback.country.implementation.CountryControllerImpl;
import io.igorv404.flightradarback.model.Model;
import io.igorv404.flightradarback.model.implementation.ModelControllerImpl;
import io.igorv404.flightradarback.terminal.Terminal;
import io.igorv404.flightradarback.terminal.implementation.TerminalControllerImpl;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class View {
  private final CountryControllerImpl countryController;
  private final CityControllerImpl cityController;
  private final AiportControllerImpl aiportController;
  private final TerminalControllerImpl terminalController;
  private final CompanyControllerImpl companyController;
  private final ModelControllerImpl modelController;
  private final Map<String, String> menu;
  private final Map<String, Methods> methodsMenu;
  private final Scanner input = new Scanner(System.in);

  public View(CountryControllerImpl countryController, CityControllerImpl cityController, AiportControllerImpl aiportController,
              TerminalControllerImpl terminalController, CompanyControllerImpl companyController, ModelControllerImpl modelController) {
    this.countryController = countryController;
    this.cityController = cityController;
    this.aiportController = aiportController;
    this.terminalController = terminalController;
    this.companyController = companyController;
    this.modelController = modelController;
    this.menu = new LinkedHashMap<>();
    menu.put("A", "A - select all tables");
    menu.put("1", "1 - select country table");
    menu.put("2", "2 - select city table");
    menu.put("3", "3 - select airport table");
    menu.put("4", "4 - select terminal table");
    menu.put("5", "5 - select company table");
    menu.put("6", "6 - select model table");
    menu.put("7", "7 - select plane table");
    menu.put("8", "8 - select pilot table");
    menu.put("9", "9 - select flight table");
    menu.put("10", "10 - get all from table");
    menu.put("11", "11 - get one by name");
    menu.put("12", "12 - create new");
    menu.put("13", "13 - update");
    menu.put("14", "14 - delete");
    menu.put("21", "21 - get all from table");
    menu.put("22", "22 - get one by id");
    menu.put("23", "23 - get one by name");
    menu.put("24", "24 - create");
    menu.put("25", "25 - update");
    menu.put("26", "26 - delete");
    menu.put("31", "31 - get all from table");
    menu.put("32", "32 - get one by id");
    menu.put("33", "33 - get one by name");
    menu.put("34", "34 - create");
    menu.put("35", "35 - update");
    menu.put("36", "36 - delete");
    menu.put("41", "41 - get all from table");
    menu.put("42", "42 - get one by id");
    menu.put("43", "43 - create");
    menu.put("44", "44 - update");
    menu.put("45", "45 - delete");
    menu.put("51", "51 - get all from table");
    menu.put("52", "52 - get one by id");
    menu.put("53", "53 - create");
    menu.put("54", "54 - update");
    menu.put("55", "55 - delete");
    menu.put("61", "61 - get all from table");
    menu.put("62", "62 - get one by id");
    menu.put("63", "63 - create");
    menu.put("64", "64 - update");
    menu.put("65", "65 - delete");
    menu.put("Q", "Q - exit");

    this.methodsMenu = new LinkedHashMap<>();
    methodsMenu.put("A", this::getAllTables);
    methodsMenu.put("10", this::getAllCountries);
    methodsMenu.put("11", this::findByNameCountry);
    methodsMenu.put("12", this::createCountry);
    methodsMenu.put("13", this::updateCountry);
    methodsMenu.put("14", this::deleteCountry);
    methodsMenu.put("21", this::getAllCities);
    methodsMenu.put("22", this::getCityById);
    methodsMenu.put("23", this::getCityByName);
    methodsMenu.put("24", this::createCity);
    methodsMenu.put("25", this::updateCity);
    methodsMenu.put("26", this::deleteCity);
    methodsMenu.put("31", this::getAllAirports);
    methodsMenu.put("32", this::getAirportById);
    methodsMenu.put("33", this::getAirportByName);
    methodsMenu.put("34", this::createAirport);
    methodsMenu.put("35", this::updateAirport);
    methodsMenu.put("36", this::deleteAirport);
    methodsMenu.put("41", this::getAllTerminals);
    methodsMenu.put("42", this::getTerminalById);
    methodsMenu.put("43", this::createTerminal);
    methodsMenu.put("44", this::updateTerminal);
    methodsMenu.put("45", this::deleteTerminal);
    methodsMenu.put("51", this::getAllCompanies);
    methodsMenu.put("52", this::getCompanyById);
    methodsMenu.put("53", this::createCompany);
    methodsMenu.put("54", this::updateCompany);
    methodsMenu.put("55", this::deleteCompany);
    methodsMenu.put("61", this::getAllModels);
    methodsMenu.put("62", this::getModelById);
    methodsMenu.put("63", this::createModel);
    methodsMenu.put("64", this::updateModel);
    methodsMenu.put("65", this::deleteModel);
  }

  private void outputMenu() {
    System.out.println("Menu:");
    for (String key : menu.keySet())
      if (key.length() == 1) System.out.println(menu.get(key));
  }

  private void outputSubMenu(String fig) {
    System.out.println("Table menu:");
    for (String key : menu.keySet())
      if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
  }

  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = input.nextLine().toUpperCase();

      if (keyMenu.matches("^\\d")) {
        outputSubMenu(keyMenu);
        System.out.println("Please, select menu point.");
        keyMenu = input.nextLine().toUpperCase();
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } while (!keyMenu.equals("Q"));
  }

  private void getAllTables() {
    getAllCountries();
    getAllCities();
    getAllAirports();
    getAllTerminals();
    getAllCompanies();
    getAllModels();
  }

  //-------------------------//

  private void createCountry() {
    System.out.println("Create new country");
    System.out.println("Add name:");
    String name = input.nextLine();
    Country newCountry = new Country(name);
    System.out.println(this.countryController.save(newCountry));
  }

  private void getAllCountries() {
    List<Country> countries = this.countryController.findAll();
    for (Country country: countries) {
      System.out.println(country);
    }
  }

  private void findByNameCountry() {
    System.out.println("What country?");
    String name = input.nextLine();
    System.out.println(this.countryController.findById(name));
  }

  private void updateCountry() {
    System.out.println("What country");
    String name = input.nextLine();
    System.out.println("Add new name");
    String newName = input.nextLine();
    Country updatedCountry = new Country(newName);
    System.out.println(this.countryController.update(name, updatedCountry));
  }

  private void deleteCountry() {
    System.out.println("What country");
    String name = input.nextLine();
    this.countryController.delete(name);
  }

  //-------------------------//

  private void createCity() {
    System.out.println("Create new city");
    System.out.println("Add name:");
    String name = input.nextLine();
    System.out.println("Add country:");
    String country = input.nextLine();
    City newCity = new City(null, name, country);
    System.out.println(this.cityController.save(newCity));
  }

  private void getAllCities() {
    List<City> cities = this.cityController.findAll();
    for (City city: cities) {
      System.out.println(city);
    }
  }

  private void getCityById() {
    System.out.println("What city id?");
    String id = input.nextLine();
    System.out.println(this.cityController.findById(Integer.valueOf(id)));
  }

  private void getCityByName() {
    System.out.println("What city name?");
    String name = input.nextLine();
    System.out.println(this.cityController.findByName(name));
  }

  private void updateCity() {
    System.out.println("What city id");
    Integer id = Integer.valueOf(input.nextLine());
    System.out.println("Add new name");
    String newName = input.nextLine();
    System.out.println("Add new country");
    String newCountry = input.nextLine();
    City updatedCity = new City(id, newName, newCountry);
    System.out.println(this.cityController.update(id, updatedCity));
  }

  private void deleteCity() {
    System.out.println("What city id");
    String id = input.nextLine();
    this.cityController.delete(Integer.valueOf(id));
  }

  //-------------------------//

  private void createAirport() {
    System.out.println("Create new airport");
    System.out.println("Add name:");
    String name = input.nextLine();
    System.out.println("Add city:");
    String city = input.nextLine();
    Airport newAirport = new Airport(null, name, Integer.valueOf(city));
    System.out.println(this.aiportController.save(newAirport));
  }

  private void getAllAirports() {
    List<Airport> airports = this.aiportController.findAll();
    for (Airport airport: airports) {
      System.out.println(airport);
    }
  }

  private void getAirportById() {
    System.out.println("What airport id?");
    String id = input.nextLine();
    System.out.println(this.aiportController.findById(Integer.valueOf(id)));
  }

  private void getAirportByName() {
    System.out.println("What airport name?");
    String name = input.nextLine();
    System.out.println(this.aiportController.findByName(name));
  }

  private void updateAirport() {
    System.out.println("What airport id");
    Integer id = Integer.valueOf(input.nextLine());
    System.out.println("Add new name");
    String newName = input.nextLine();
    System.out.println("Add new city");
    String newCity = input.nextLine();
    Airport updatedAirport = new Airport(id, newName, Integer.valueOf(newCity));
    System.out.println(this.aiportController.update(id, updatedAirport));
  }

  private void deleteAirport() {
    System.out.println("What airport id");
    String id = input.nextLine();
    this.aiportController.delete(Integer.valueOf(id));
  }

  //-------------------------//

  private void createTerminal() {
    System.out.println("Create new terminal");
    System.out.println("Add number:");
    String name = input.nextLine();
    System.out.println("Add airport id:");
    String city = input.nextLine();
    Terminal newTerminal = new Terminal(null, Integer.valueOf(name), Integer.valueOf(city));
    System.out.println(this.terminalController.save(newTerminal));
  }

  private void getAllTerminals() {
    List<Terminal> terminals = this.terminalController.findAll();
    for (Terminal terminal: terminals) {
      System.out.println(terminal);
    }
  }

  private void getTerminalById() {
    System.out.println("What terminal id?");
    String id = input.nextLine();
    System.out.println(this.terminalController.findById(Integer.valueOf(id)));
  }

  private void updateTerminal() {
    System.out.println("What terminal id");
    Integer id = Integer.valueOf(input.nextLine());
    System.out.println("Add new number");
    String newName = input.nextLine();
    System.out.println("Add new airport");
    String newAirport = input.nextLine();
    Terminal updatedTerminal = new Terminal(id, Integer.valueOf(newName), Integer.valueOf(newAirport));
    System.out.println(this.terminalController.update(id, updatedTerminal));
  }

  private void deleteTerminal() {
    System.out.println("What terminal id");
    String id = input.nextLine();
    this.terminalController.delete(Integer.valueOf(id));
  }

  //-------------------------//

  private void createCompany() {
    System.out.println("Create new company");
    System.out.println("Add name:");
    String name = input.nextLine();
    System.out.println("Add country:");
    String country = input.nextLine();
    System.out.println("Add count of planes:");
    String count = input.nextLine();
    Company newCompany = new Company(name, country, Integer.valueOf(count));
    System.out.println(this.companyController.save(newCompany));
  }

  private void getAllCompanies() {
    List<Company> companies = this.companyController.findAll();
    for (Company company: companies) {
      System.out.println(company);
    }
  }

  private void getCompanyById() {
    System.out.println("What company?");
    String name = input.nextLine();
    System.out.println(this.companyController.findById(name));
  }

  private void updateCompany() {
    System.out.println("What company");
    String name = input.nextLine();
    System.out.println("Add new country");
    String newCountry = input.nextLine();
    System.out.println("Add new count of planes");
    String newCount = input.nextLine();
    Company updatedCompany = new Company(name, newCountry, Integer.valueOf(newCount));
    System.out.println(this.companyController.update(name, updatedCompany));
  }

  private void deleteCompany() {
    System.out.println("What company");
    String name = input.nextLine();
    this.companyController.delete(name);
  }

  //-------------------------//

  private void createModel() {
    System.out.println("Create new model");
    System.out.println("Add name:");
    String name = input.nextLine();
    System.out.println("Add length:");
    Float length = Float.valueOf(input.nextLine());
    System.out.println("Add wingspan:");
    Float wingspan = Float.valueOf(input.nextLine());
    System.out.println("Add count of seats:");
    Integer count = Integer.valueOf(input.nextLine());
    Model newModel = new Model(name, length, wingspan, count);
    System.out.println(this.modelController.save(newModel));
  }

  private void getAllModels() {
    List<Model> models = this.modelController.findAll();
    for (Model model: models) {
      System.out.println(model);
    }
  }

  private void getModelById() {
    System.out.println("What model?");
    String name = input.nextLine();
    System.out.println(this.modelController.findById(name));
  }

  private void updateModel() {
    System.out.println("What model");
    String name = input.nextLine();
    System.out.println("Add new length");
    Float newLength = Float.valueOf(input.nextLine());
    System.out.println("Add new wingspan");
    Float newWingspan = Float.valueOf(input.nextLine());
    System.out.println("Add new count of seats");
    Integer newCount = Integer.valueOf(input.nextLine());
    Model updatedModel = new Model(name, newLength, newWingspan, newCount);
    System.out.println(this.modelController.update(name, updatedModel));
  }

  private void deleteModel() {
    System.out.println("What model");
    String name = input.nextLine();
    this.modelController.delete(name);
  }
}
