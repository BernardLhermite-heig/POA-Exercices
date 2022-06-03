import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit2ExB {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>(List.of(Country.countries));

        System.out.println("Smallest Populations");

        Collections.sort(countries, Comparator.comparing(c -> c.getPopulation()));

        for (int i = 0; i < 10; i++)
            System.out.println(countries.get(i));

        System.out.println("\nSmallest Population Densities");
        Collections.sort(countries, Comparator.comparing(c -> c.getPopulation() / c.getArea()));

        for (int i = 0; i < 10; i++)
            System.out.println(countries.get(i));
    }
}

class Country {
    private String name;
    private int population;
    private double area;

    /**
     * Constructs a country.
     *
     * @param aName       the name of the country
     * @param aPopulation the population of the country
     * @param anArea      the area of the country
     */
    public Country(String aName, int aPopulation, double anArea) {
        name = aName;
        population = aPopulation;
        area = anArea;
    }

    /**
     * Gets the country name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the area of the country.
     *
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * Gets the population of the country.
     *
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    public static Country fromString(String input) {
        String[] inputs = input.split(";");
        return new Country(inputs[0], Integer.parseInt(inputs[1]), Double.parseDouble(inputs[2]));
    }

    public String toString() {
        return (name + ";" + population + ";" + area).replaceAll(".0$", "");
    }

    public static final Country[] countries = new Country[]{new Country("Afghanistan", 29835392, 250000), new

            Country("Albania", 2994667, 11100), new

            Country("Algeria", 34994937, 919590), new

            Country("Andorra", 84825, 181), new

            Country("Angola", 13338541, 481351), new

            Country("Antigua and Barbuda", 87884, 171), new

            Country("Argentina", 41769726, 1068296), new

            Country("Armenia", 2967975, 11506), new

            Country("Australia", 21766711, 2967893), new

            Country("Austria", 8217280, 32382), new

            Country("Azerbaijan", 8372373, 33436), new

            Country("Bahamas, The", 313312, 5382), new

            Country("Bahrain", 1214705, 257), new

            Country("Bangladesh", 158570535, 55598), new

            Country("Barbados", 286705, 166), new

            Country("Belarus", 9577552, 80154), new

            Country("Belgium", 10431477, 11787), new

            Country("Belize", 321115, 8867), new

            Country("Benin", 9325032, 43483), new

            Country("Bhutan", 708427, 18147), new

            Country("Bolivia", 10118683, 424162), new

            Country("Bosnia and Herzegovina", 4622163, 19741), new

            Country("Botswana", 2065398, 231803), new

            Country("Brazil", 203429773, 3286470), new

            Country("Brunei", 401890, 2228), new

            Country("Bulgaria", 7093635, 42822), new

            Country("Burkina Faso", 16751455, 105869), new

            Country("Burundi", 10216190, 10745), new

            Country("Cambodia", 14701717, 69900), new

            Country("Cameroon", 19711291, 183567), new

            Country("Canada", 34030589, 3855081), new

            Country("Cape Verde", 516100, 1557), new

            Country("Central African Republic", 4950027, 240534), new

            Country("Chad", 10758945, 495752), new

            Country("Chile", 16888760, 292258), new

            Country("China", 1336718015, 3705386), new

            Country("Colombia", 44725543, 439733), new

            Country("Comoros", 794683, 838), new

            Country("Congo,Democratic Republic of the", 71712867, 905563), new

            Country("Congo,Republic of the", 4243929, 132046), new

            Country("Costa Rica", 4576562, 19730), new

            Country("Cote d'Ivoire", 21504162, 124502), new Country("Croatia", 4483804, 21831), new

            Country("Cuba", 11087330, 42803), new

            Country("Cyprus", 1120489, 3571), new

            Country("Czech Republic", 10190213, 30450), new

            Country("Denmark", 5529888, 16639), new

            Country("Djibouti", 757074, 8880), new

            Country("Dominica", 72969, 291), new

            Country("Dominican Republic", 9956648, 18815), new

            Country("Ecuador", 15007343, 109483), new

            Country("Egypt", 82079636, 386660), new

            Country("El Salvador", 6071774, 8124), new

            Country("Equatorial Guinea", 668225, 10830), new

            Country("Eritrea", 5939484, 46842), new

            Country("Estonia", 1282963, 17462), new

            Country("Ethiopia", 90873739, 435184), new

            Country("Fiji", 883125, 7054), new

            Country("Finland", 5259250, 130558), new

            Country("France", 65312249, 211208), new

            Country("Gabon", 1576665, 103346), new

            Country("Gambia", 1797860, 4363), new

            Country("Georgia", 4585874, 26911), new

            Country("Germany", 81471834, 137846), new

            Country("Ghana", 24791073, 92456), new

            Country("Greece", 10760136, 50942), new

            Country("Grenada", 108419, 133), new

            Country("Guatemala", 13824463, 42042), new

            Country("Guinea", 10601009, 94925), new

            Country("Guinea-Bissau", 1596677, 13946), new

            Country("Guyana", 744768, 83000), new

            Country("Haiti", 9719932, 10714), new

            Country("Honduras", 8143564, 43278), new

            Country("Hungary", 9976062, 35919), new

            Country("Iceland", 311058, 39768), new

            Country("India", 1189172906, 1269338), new

            Country("Indonesia", 245613043, 741096), new

            Country("Iran", 77891220, 636293), new

            Country("Iraq", 30399572, 168753), new

            Country("Ireland", 4670976, 27135), new

            Country("Israel", 7473052, 8019), new

            Country("Italy", 61016804, 116305), new

            Country("Jamaica", 2868380, 4244), new

            Country("Japan", 126475664, 145882), new

            Country("Jordan", 6508271, 35637), new

            Country("Kazakhstan", 15522373, 1049150), new

            Country("Kenya", 41070934, 224961), new

            Country("Kiribati", 100743, 313), new

            Country("Korea,North", 24457492, 46540), new

            Country("Korea,South", 48754657, 38023), new

            Country("Kosovo", 1825632, 4211), new

            Country("Kuwait", 2595628, 6880), new

            Country("Kyrgyzstan", 5587443, 76641), new

            Country("Laos", 6477211, 91428), new

            Country("Latvia", 2204708, 24938), new

            Country("Lebanon", 4143101, 4015), new

            Country("Lesotho", 1924886, 11720), new

            Country("Liberia", 3786764, 43000), new

            Country("Libya", 6597960, 679358), new

            Country("Liechtenstein", 35236, 62), new

            Country("Lithuania", 3535547, 25174), new

            Country("Luxembourg", 503302, 998), new

            Country("Macedonia", 2077328, 9781), new

            Country("Madagascar", 21926221, 226656), new

            Country("Malawi", 15879252, 45745), new

            Country("Malaysia", 28728607, 127316), new

            Country("Maldives", 394999, 116), new

            Country("Mali", 14159904, 478764), new

            Country("Malta", 408333, 122), new

            Country("Marshall Islands", 67182, 4577), new

            Country("Mauritania", 3281634, 397953), new

            Country("Mauritius", 1303717, 788), new

            Country("Mexico", 113724226, 761602), new

            Country("Micronesia ,Federated States of", 106836, 271), new

            Country("Moldova", 4314377, 13067), new

            Country("Monaco", 30539, 1), new

            Country("Mongolia", 3133318, 603905), new

            Country("Montenegro", 661807, 5415), new

            Country("Morocco", 31968361, 172413), new

            Country("Mozambique", 22948858, 309494), new

            Country("Myanmar (Burma)", 53999804, 261969), new

            Country("Namibia", 2147585, 318694), new

            Country("Nauru", 9322, 8), new

            Country("Nepal", 29391883, 54363), new

            Country("Netherlands", 16847007, 16033), new

            Country("New Zealand", 4290347, 103737), new

            Country("Nicaragua", 5666301, 49998), new

            Country("Niger", 16468886, 489189), new

            Country("Nigeria", 155215573, 356667), new

            Country("Norway", 4691849, 125181), new

            Country("Oman", 3027959, 82031), new

            Country("Pakistan", 187342721, 310401), new

            Country("Palau", 20956, 177), new

            Country("Panama", 3460462, 30193), new

            Country("Papua New Guinea", 6187591, 178703), new

            Country("Paraguay", 6459058, 157046), new

            Country("Peru", 29248943, 496223), new

            Country("Philippines", 101833938, 115830), new

            Country("Poland", 38441588, 120728), new

            Country("Portugal", 10760305, 35672), new

            Country("Qatar", 848016, 4416), new

            Country("Romania", 21904551, 91669), new

            Country("Russia", 138739892, 6592735), new

            Country("Rwanda", 11370425, 10169), new

            Country("Saint Kitts and Nevis", 50314, 101), new

            Country("Saint Lucia", 161557, 238), new

            Country("Saint Vincent and the Grenadines", 103869, 150), new

            Country("Samoa", 193161, 1137), new

            Country("San Marino", 31817, 24), new

            Country("Sao Tome and Principe", 179506, 386), new

            Country("Saudi Arabia", 26131703, 756981), new

            Country("Senegal", 12643799, 75749), new

            Country("Serbia", 7310555, 29913), new

            Country("Seychelles", 89188, 176), new

            Country("Sierra Leone", 5363669, 27699), new

            Country("Singapore", 4740737, 267), new

            Country("Slovakia", 5477038, 18859), new

            Country("Slovenia", 2000092, 7827), new

            Country("Solomon Islands", 571890, 10985), new

            Country("Somalia", 9925640, 246199), new

            Country("South Africa", 49004031, 471008), new

            Country("South Sudan", 8260490, 400367), new

            Country("Spain", 46754784, 194896), new

            Country("Sri Lanka", 21283913, 25332), new

            Country("Sudan", 45047502, 728215), new

            Country("Suriname", 491989, 63039), new

            Country("Swaziland", 1370424, 6704), new

            Country("Sweden", 9088728, 173731), new

            Country("Switzerland", 7639961, 15942), new

            Country("Syria", 22517750, 71498), new

            Country("Taiwan", 23071779, 13892), new

            Country("Tajikistan", 7627200, 55251), new

            Country("Tanzania", 42746620, 364898), new

            Country("Thailand", 66720153, 198455), new

            Country("Timor-Leste", 1177834, 5641), new

            Country("Togo", 6771993, 21925), new

            Country("Tonga", 105916, 289), new

            Country("Trinidad and Tobago", 1227505, 1980), new

            Country("Tunisia", 10629186, 63170), new

            Country("Turkey", 78785548, 301382), new

            Country("Turkmenistan", 4997503, 188455), new

            Country("Tuvalu", 10544, 10), new

            Country("Uganda", 34612250, 91135), new

            Country("Ukraine", 45134707, 233089), new

            Country("United Arab Emirates", 5148664, 32000), new

            Country("United Kingdom", 62698362, 94525), new

            Country("United States", 313232044, 3718691), new

            Country("Uruguay", 3308535, 68039), new

            Country("Uzbekistan", 28128600, 172741), new

            Country("Vanuatu", 224564, 4710), new

            Country("Vatican City", 832, 0.17), new

            Country("Venezuela", 27635743, 352143), new

            Country("Vietnam", 90549390, 127243), new

            Country("Western Sahara", 507160, 102703), new

            Country("Yemen", 24133492, 203849), new

            Country("Zambia", 13881336, 290584), new

            Country("Zimbabwe", 12084304, 150803)};
}