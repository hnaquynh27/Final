package com.countrylistmanager;

import com.AbstractCountry;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static CountryFactory countryFactory = new CountryFactory();
    private static CountryListManager countryListManager = new CountryListManager();

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("code")) {
                    continue;
                }

                CountryData newCountryData = new CountryData.CountryDataBuilder(dataList.get(0))
                        .setName(dataList.get(1))
                        .setPopulation(Integer.parseInt(dataList.get(2)))
                        .setArea(Double.parseDouble(dataList.get(3)))
                        .setGdp(Double.parseDouble(dataList.get(4)))
                        .build();

                /* TODO
                 * Từ dữ liệu nhận được, tạo các đối tượng Country và đưa và CountryListManager để quản lý.
                 */
                AbstractCountry abstractCountry = countryFactory.createCountry(dataList.get(5), newCountryData);
                countryListManager.getCountryList().add(abstractCountry);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            Collections.addAll(result, splitData);
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        testOriginalData();
        System.out.println();
        testSortAreaIncreasing();
        System.out.println();
        testSortAreaDecreasing();
        System.out.println();
        testSortAreaIncreasing();
        System.out.println();
        testSortAreaDecreasing();
        System.out.println();
        testSortGdpIncreasing();
        System.out.println();
        testSortGdpDecreasing();
        System.out.println();
        testFilterCountriesMostPopulous();
        System.out.println();
        testFilterCountriesLeastPopulous();
        System.out.println();
        testFilterCountriesLargestArea();
        System.out.println();
        testFilterCountriesSmallestArea();
        System.out.println();
        testFilterCountriesHighestGdp();
        System.out.println();
        testFilterCountriesLowestGdp();
        System.out.println();
        testFilterContinent();
    }

    public static void init() {
        String filePath = "/Users/nguyenquynhanh/IdeaProjects/FinalExam/src/com/countrylistmanager/data/countries.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        init();
        String codes = CountryListManager.getInstance().codeOfCountriesToString(CountryListManager.getInstance().getCountryList());
        System.out.print(codes);
    }

    public static void testSortPopulationIncreasing() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().sortPopulationIncreasing();
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testSortPopulationDecreasing() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().sortPopulationDecreasing();
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testSortAreaIncreasing() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().sortAreaIncreasing();
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testSortAreaDecreasing() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().sortAreaDecreasing();
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testSortGdpIncreasing() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().sortGdpIncreasing();
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testSortGdpDecreasing() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().sortAreaDecreasing();
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testFilterContinent() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().filterContinent("AsiaCountry");
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testFilterCountriesMostPopulous() {
        init();
        List<AbstractCountry> countries = CountryListManager.getInstance().sortPopulationDecreasing();
        List<AbstractCountry> nMostPopulousCountries = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nMostPopulousCountries.add(countries.get(i));
        }
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(nMostPopulousCountries);
        System.out.print(codeString);
    }

    public static void testFilterCountriesLeastPopulous() {
        init();
        List<AbstractCountry> countries = CountryListManager.getInstance().sortPopulationIncreasing();
        List<AbstractCountry> nLeastPopulousCountries = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLeastPopulousCountries.add(countries.get(i));
        }

        String codeString = CountryListManager.getInstance().codeOfCountriesToString(nLeastPopulousCountries);
        System.out.print(codeString);
    }

    public static void testFilterCountriesLargestArea() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().filterCountriesLargestArea(14);
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testFilterCountriesSmallestArea() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().filterCountriesSmallestArea(14);
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testFilterCountriesHighestGdp() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().filterCountriesHighestGdp(14);
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

    public static void testFilterCountriesLowestGdp() {
        /* TODO */
        List<AbstractCountry> countries = CountryListManager.getInstance().filterCountriesLowestGdp(14);
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(countries);
        System.out.print(codeString);
    }

}
