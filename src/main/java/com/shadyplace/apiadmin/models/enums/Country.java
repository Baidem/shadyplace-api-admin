package com.shadyplace.apiadmin.models.enums;

import java.util.Arrays;
import java.util.List;

public enum Country {
    AFGHANISTAN("Afghanistan", "AF"),
    ALBANIA("Albania", "AL"),
    ALGERIA("Algeria", "DZ"),
    ANDORRA("Andorra", "AD"),
    ANGOLA("Angola", "AO"),
    ARGENTINA("Argentina", "AR"),
    ARMENIA("Armenia", "AM"),
    AUSTRALIA("Australia", "AU"),
    AUSTRIA("Austria", "AT"),
    BAHRAIN("Bahrain", "BH"),
    BANGLADESH("Bangladesh", "BD"),
    BELARUS("Belarus", "BY"),
    BELGIUM("Belgium", "BE"),
    BRAZIL("Brazil", "BR"),
    BULGARIA("Bulgaria", "BG"),
    CANADA("Canada", "CA"),
    CHILE("Chile", "CL"),
    CHINA("China", "CN"),
    COLOMBIA("Colombia", "CO"),
    CROATIA("Croatia", "HR"),
    CUBA("Cuba", "CU"),
    CYPRUS("Cyprus", "CY"),
    CZECH_REPUBLIC("Czech Republic", "CZ"),
    DENMARK("Denmark", "DK"),
    EGYPT("Egypt", "EG"),
    ESTONIA("Estonia", "EE"),
    FINLAND("Finland", "FI"),
    FRANCE("France", "FR"),
    GERMANY("Germany", "DE"),
    GREECE("Greece", "GR"),
    HONG_KONG("Hong Kong", "HK"),
    HUNGARY("Hungary", "HU"),
    ICELAND("Iceland", "IS"),
    INDIA("India", "IN"),
    INDONESIA("Indonesia", "ID"),
    IRAN("Iran", "IR"),
    IRAQ("Iraq", "IQ"),
    IRELAND("Ireland", "IE"),
    ISRAEL("Israel", "IL"),
    ITALY("Italy", "IT"),
    JAMAICA("Jamaica", "JM"),
    JAPAN("Japan", "JP"),
    JORDAN("Jordan", "JO"),
    KENYA("Kenya", "KE"),
    KOREA("Korea", "KR"),
    KUWAIT("Kuwait", "KW"),
    LEBANON("Lebanon", "LB"),
    LIBYA("Libya", "LY"),
    LITHUANIA("Lithuania", "LT"),
    LUXEMBOURG("Luxembourg", "LU"),
    MALAYSIA("Malaysia", "MY"),
    MALTA("Malta", "MT"),
    MEXICO("Mexico", "MX"),
    MOROCCO("Morocco", "MA"),
    NETHERLANDS("Netherlands", "NL"),
    NEW_ZEALAND("New Zealand", "NZ"),
    NORWAY("Norway", "NO"),
    PAKISTAN("Pakistan", "PK"),
    PHILIPPINES("Philippines", "PH"),
    POLAND("Poland", "PL"),
    PORTUGAL("Portugal", "PT"),
    QATAR("Qatar", "QA"),
    ROMANIA("Romania", "RO"),
    RUSSIA("Russia", "RU"),
    SAUDI_ARABIA("Saudi Arabia", "SA"),
    SERBIA("Serbia", "RS"),
    SINGAPORE("Singapore", "SG"),
    SLOVAKIA("Slovakia", "SK"),
    SLOVENIA("Slovenia", "SI"),
    SOUTH_AFRICA("South Africa", "ZA"),
    SPAIN("Spain", "ES"),
    SRI_LANKA("Sri Lanka", "LK"),
    SWEDEN("Sweden", "SE"),
    SWITZERLAND("Switzerland", "CH"),
    TAIWAN("Taiwan", "TW"),
    THAILAND("Thailand", "TH"),
    TUNISIA("Tunisia", "TN"),
    TURKEY("Turkey", "TR"),
    UKRAINE("Ukraine", "UA"),
    UNITED_ARAB_EMIRATES("United Arab Emirates", "AE"),
    UNITED_KINGDOM("United Kingdom", "UK"),
    UNITED_STATES("United States", "US"),
    URUGUAY("Uruguay", "UY"),
    VENEZUELA("Venezuela", "VE"),
    VIETNAM("Vietnam", "VN");

    private String name;
    private String abbreviation;

    Country(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<Country> getAllDestinationCountries() {
        return Arrays.asList(Country.values());
    }
    public static Country getCountryByNameOrAbbreviation(String input) {
        for (Country country : Country.values()) {
            if (country.getName().equalsIgnoreCase(input) || country.getAbbreviation().equalsIgnoreCase(input)) {
                return country;
            }
        }
        return null;
    }
}