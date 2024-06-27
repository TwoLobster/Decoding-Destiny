import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
 
//Class for organizing and managing the data needed for the astrological analysis.
class PlanetSign {
    private String planet;
    private String sign;

    public PlanetSign(String planet, String sign) {
        this.planet = planet;
        this.sign = sign;
    }

    public String getPlanet() {
        return planet;
    }

    public String getSign() {
        return sign;
    }
}

//Abstract class Acting as a blueprint for other classes.
abstract class Predictions {
    abstract void Predict(String[] rearrangedSigns, int[] matched); 
}

//Class representing predictions about position of moles on body
class Moles extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
    if(matched[2]==4||matched[7]==5||matched[7]==7||matched[7]==8||matched[8]==5||matched[8]==7||matched[8]==8||matched[6]==5||matched[6]==7||matched[6]==8){
     System.out.println("Mole Positions : Mole is on the Left hand Or Neck chest area or Left leg or lips or face");
   }
   else{
     System.out.println("Mole positions : Mole is on the Right hand or Right leg or Near Ears or fingers");
   }
   System.out.println();
 }
}

//Class representing predictions about initials of potential partners 
class PartnerStartingLetters extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
        System.out.print("The initials of potential partners could be:");
        if (rearrangedSigns[4].equals("Aries") || rearrangedSigns[6].equals("Aries") || rearrangedSigns[matched[5]-1].equals("Aries")) System.out.print(" C, L, A");
        if (rearrangedSigns[4].equals("Taurus") ||  rearrangedSigns[6].equals("Taurus") || rearrangedSigns[matched[5]-1].equals("Taurus")) System.out.print(" E, V, A, O, Y");
        if (rearrangedSigns[4].equals("Gemini") || rearrangedSigns[6].equals("Gemini") || rearrangedSigns[matched[5]-1].equals("Gemini")) System.out.print(" K, G, C, H");
        if (rearrangedSigns[4].equals("Cancer") || rearrangedSigns[6].equals("Cancer") || rearrangedSigns[matched[5]-1].equals("Cancer")) System.out.print(" H, D");
        if (rearrangedSigns[4].equals("Leo") || rearrangedSigns[6].equals("Leo") || rearrangedSigns[matched[5]-1].equals("Leo")) System.out.print(" M, T");
        if (rearrangedSigns[4].equals("Virgo") || rearrangedSigns[6].equals("Virgo") || rearrangedSigns[matched[5]-1].equals("Virgo")) System.out.print(" T, P, S, F");
        if (rearrangedSigns[4].equals("Libra") || rearrangedSigns[6].equals("Libra") || rearrangedSigns[matched[5]-1].equals("Libra")) System.out.print(" R, T");
        if (rearrangedSigns[4].equals("Scorpio") || rearrangedSigns[6].equals("Scorpio") || rearrangedSigns[matched[5]-1].equals("Scorpio")) System.out.print(" T, N, Y");
        if (rearrangedSigns[4].equals("Sagittarius") || rearrangedSigns[6].equals("Sagittarius") || rearrangedSigns[matched[5]-1].equals("Sagittarius")) System.out.print(" Y, B, D, P");
        if (rearrangedSigns[4].equals("Capricorn") || rearrangedSigns[6].equals("Capricorn") || rearrangedSigns[matched[5]-1].equals("Capricorn")) System.out.print(" B, J, K, G");
        if (rearrangedSigns[4].equals("Aquarius") || rearrangedSigns[6].equals("Aquarius") || rearrangedSigns[matched[5]-1].equals("Aquarius")) System.out.print(" G, S, D, T");
        if (rearrangedSigns[4].equals("Pisces") || rearrangedSigns[6].equals("Pisces") || rearrangedSigns[matched[5]-1].equals("Pisces")) System.out.print(" D, T, J, C");
        System.out.println("\n");
    }
}

//Class representing predictions about initials of potential partners
class LoveLife extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
        if(matched[6]==5 || matched[6]==8 || matched[6]== 7|| matched[8]==5 || matched[8]==7 || matched[8]==8 || matched[7]==5 || matched[7]==7 || matched[7]==8 || matched[5]==matched[6] || matched[5]==matched[7] || matched[5]==matched[8]){
            System.out.println("Love and Married Life : Arranged marriage likely, problems with family accepting love, love failure might be expected.");
          }
          else{
            System.out.println("Love and Married Life : Love marriage possible, love Life might be successful.");
          }
          System.out.println();
    }
}

//Class representing predictions about Health
class Health extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
        if(matched[7]==6||matched[8]==6||matched[6]==6){
            System.out.println("Health and Well Being : Health problems might occur repeatedly; possible risk of accidents, injuries, or developing diabetes.");
            if(matched[6]==5 || matched[6]==8 || matched[6]== 7|| matched[8]==5 || matched[8]==7 || matched[8]==8 || matched[7]==5 || matched[7]==7 || matched[7]==8 || matched[5]==matched[6] || matched[5]==matched[7] || matched[5]==matched[8]){
                System.out.println("Health and Well Being : Health issues related to nerves and stomach possible, women might suffer from irregular periods.");
              }
           }
           else{
               System.out.println("Health and Well Being : There won't be any major health concerns, just minor issues like a slight fever or headache that will resolve easily.");
           }
           System.out.println();
    }
}

//Class representing predictions about Education
class Education extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
        if(matched[7]==4||matched[8]==4||matched[6]==4){
            System.out.println("Education : Primary education will be comparatively less comprehensive than secondary education.");
        }
        else if(matched[7]==matched[4] || matched[8]==matched[4] || matched[4]==1 || matched[6]==matched[4]){
            System.out.println("Education : While one may possess capabilities, the outcomes may often be disappointing or fall short of expectations.");
        }
        else{
            System.out.println("Primary education will be comparatively good than secondary education. ");
        }
        System.out.println();
    }
}

//Class representing predictions about Carrer 
class Career extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
        if(matched[4]==10||matched[2]==10||matched[3]==10){
            System.out.println("Career : Career opportunities may involve software development, with potential for employment abroad in the private sector offering competitive salaries, as well as opportunities in government jobs.");
        }
        if(matched[5]==10 || matched[5]==matched[3] || matched[5]==matched[4]){
            System.out.println("Career : The career path involves becoming an Instagram influencer, a traveler, or a vlogger, with two additional sources of income , businesses.");
        }
        if (matched[0]==matched[3]) {
            System.out.println(" The person might inherit land, money, or properties from parents.");
        }
        else{
            System.out.println(" Starting its possible to do a private sector job in your life and after some extent there is a possibility that you will achieve govt sector");
        }
        System.out.println();
    }
}

//Class representing predictions about Family
class Family extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
        if(matched[6]==9 || matched[7]==9 || matched[8]==9){
            System.out.println("Life and Relations : Person might have very capable and hardworking.");
            if(matched[0]==matched[3])System.out.println("Luck Factor : Luck may work in your favour at times.");
            else System.out.println("Luck Factor : Luck might not always be on your side.");
        }
        if(matched[0]==2 || matched[3]==2 || matched[4]==2 || matched[0]==3 || matched[3]==3 || matched[4]==3){
            System.out.println("Family Relations : Stressful relations with siblings, fights etc; Girl might have good relationship with her father but not so good with her mother; Boy might have fights and in general bad relations with his father, however he might be close to his mother.");
        }
        else{
            System.out.println("You will have a understanding and Supportive family");
        }
        System.out.println();
    }
}

//Class representing predictions about Personality
class Personality extends Predictions{
    void Predict(String[] rearrangedSigns, int[] matched){
        if(matched[0]==matched[9])System.out.println("Personality :  This person might be a good Leader with strong and loving personality. They are likely to be extroverted, having many friends, however might experience hurt from others often. People might misunderstand them.");
        else if(matched[1]==matched[9])System.out.println("Personality :  This person is likely to be introverted. They may suffer from situations that result in confusion and overthinking, leading ot instability.");
        else if(matched[2]==matched[9])System.out.println("Personality : This person possesses fighting spirit strong enough to overcome obstacles. But they might also place high expectations from themselves and others.");
        else if(matched[3]==matched[9])System.out.println("Personality : This person is likely to be a good decision maker. They might have a unique personality trait of appearing introverted outside, while being extroverted inside.");
        else if(matched[4]==matched[9])System.out.println("Personality : This person might have a good vision of things in future, they might find a lot of success in their career and be Goal-oriented and positive.");
        else if(matched[5]==matched[9])System.out.println("Personality : This person might attract others a lot, and they have good communication skills as well. They might be dreamy and express lots of desires.");
        else if(matched[6]==matched[9])System.out.println("Personality : This person is likely to be lazy and moody, and might take their own sweet time when doing something. They also might be an inner thinker.");
        else System.out.println("This person might be very intelligent and capable, but results of their work may take time to come to fruition. They are likely to be extroverted among their friends, and contrarily, introverted with outsiders.");
        System.out.println();
    }
}

//Class representing predictions about Mangal dosh
class Dosha extends Predictions{
    void Predict(String[] rearrangedSigns, int []matched){
        if(matched[2]==1 || matched[2]==2 || matched[2]==8 || matched[2]==12)System.out.println("Mangal Dosha : This person has Mangal dosh in his/ her kundali.");
        else System.out.println("Mangal Dosha : Your kundali is free from Mangal dosha.");
        System.out.println();
    }
}

//Class representing predictions about the Remedies one should do.
class Remedies extends Predictions{
    void Predict(String[] rearrangedSigns, int []matched){
        if(rearrangedSigns[matched[1]-1].equals("Aries"))System.out.println("Suggested Remedies : Donate items related to Mars, such as red lentils, fennel, or barley. Favourable colour is Red. Wearing a bracelet with Red colored stones is recommended.");
        else if(rearrangedSigns[matched[1]-1].equals("Taurus"))System.out.println("Suggested Remedies : Donation of cotton, curd, sugar or rice are recommended. It is advisable to get rid of outdated White clothes that are not functional. Yellow is your favourable color, and wearing Yellow stones are recommended.");
        else if(rearrangedSigns[matched[1]-1].equals("Gemini"))System.out.println("Suggested Remedies : Donate green chillies or anything that is green in color, Camphor can also be donated. Green is your favourable color, and wearing Green colored stones is recommended.");
        else if(rearrangedSigns[matched[1]-1].equals("Cancer"))System.out.println("Suggested Remedies : Donating items related to moon such as milk, rice, gram, or white candy is recommended. Favourable color is White, and the person should wear White stones.");
        else if(rearrangedSigns[matched[1]-1].equals("Leo"))System.out.println("Suggested Remedies : Donate things related to Sun such as jaggery or Wheat grains. Favourable color is Red, and wearing Red stones is recommended.");
        else if(rearrangedSigns[matched[1]-1].equals("Virgo"))System.out.println("Suggested Remedies : Donating items related to Mercury such as Moong dal or green fruits is recommended. Green is your favourable color,and you are recommended to wear Green stones.");
        else if(rearrangedSigns[matched[1]-1].equals("Libra"))System.out.println("Suggested Remedies : Donating rice grains, boora sugar, or paneer is recommended, as these are items that are related to Venus. Color Pink favours you, and it is recommended that you wear stones of Pink color.");
        else if(rearrangedSigns[matched[1]-1].equals("Scorpio"))System.out.println("Suggested Remedies : Items related to Mars such as khand or saffron. Green and Red are colors that favour you, and you should wear stones of either color.");
        else if(rearrangedSigns[matched[1]-1].equals("Sagittarius"))System.out.println("Suggested Remedies : Donating items related to Jupiter sucha as honey, turmeric powder, or chana dal is recommended. Favourable colors are White or Cream, and wearing White or Cream colored stones is recommended.");
        else if(rearrangedSigns[matched[1]-1].equals("Capricorn"))System.out.println("Suggested Remedies : Donating mustard oil or black grams will be recommended as these are related to Saturn. Black is your favourable color, and wearing a black colored stone is recommended.");
        else if(rearrangedSigns[matched[1]-1].equals("Aquarius"))System.out.println("Suggested Remedies : Saturn related items such as Iron, tea leaves etc, are recommended to be donated.Since Black is your favourable color, it is recommended that you wear a black colored stone.");
        else if(rearrangedSigns[matched[1]-1].equals("Pisces"))System.out.println("Suggested Remedies : Donating items like cow's ghee or saffron might prove beneficiary as they are related to Jupiter. Favourable color is Orange, and wearing an Orange colored stone is recommended.");
        System.out.println();
    }
}

// Class representing an Astrologer
class Astrologer {
    //generatePredictions method takes in several inputs,passes them to astro API, decodes the output, arranges the signs according 
    //to house positions and stores these respective positions in an array. 
    public void generatePredictions(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth,int hourOfBirth, int minuteOfBirth, String placeName) throws Exception {
                                            
        Map<String, String> locationDetails = fetchLocationDetails(placeName);
        String latitude = locationDetails.get("latitude");
        String longitude = locationDetails.get("longitude");

    // Construct the JSON representing the birth data
        String birthDataJson = "{"
                + "\"name\": \"" + name + "\","
                + "\"place\": {"
                + "\"name\": \"" + placeName + "\","
                + "\"longitude\": " + longitude + ","
                + "\"latitude\": " + latitude + ","
                + "\"timeZoneId\": \"" + "Asia/Kolkata" + "\""
                + "},"
                + "\"year\": " + yearOfBirth + ","
                + "\"month\": " + monthOfBirth + ","
                + "\"date\": " + dayOfBirth + ","
                + "\"hour\": " + hourOfBirth + ","
                + "\"minutes\": " + minuteOfBirth + ","
                + "\"seconds\": 0,"
                + "\"options\": {"
                + "\"Ayanamsa\": \"LAHARI\""
                + "}"
                + "}";

        // API endpoint URL and your API key
        String apiUrl = "https://api.innovativeastrosolutions.com/v0/horoscope";
        String apiKey = "0lhJfgnIXu53mlePBwbBn22qppahXTS95Xi3NXMG";

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("x-api-key", apiKey);
        // Create HTTP client
        HttpClient client = HttpClient.newHttpClient();
        // Create HTTP request
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .POST(HttpRequest.BodyPublishers.ofString(birthDataJson));
        // Add headers to the request
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder.header(entry.getKey(), entry.getValue());
        }
        // Build the request
        HttpRequest request = requestBuilder.build();
        // Send the request and retrieve the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String data = response.body();

        planetSigns = extractPlanetAndSignNames(data);
        // Print the stored planet and sign names
        printStoredValues(planetSigns);
        // Method for Rearranging the signs to match the 12 astrological houses
        String[] rearrangedSigns = rearrangeSigns();

        System.out.println("\n The 12 houses are : ");
        for (int i=0; i<rearrangedSigns.length; i++) {
        System.out.print(rearrangedSigns[i] + " ");
        }

        // Method for Matching  planets to their corresponding signs in the rearranged order
        int [] matched = matchPlanetsToSigns(rearrangedSigns);
        
        System.out.println("\n\nThe positions of planets with respect to the houses are :");
        for (int i=0; i<matched.length; i++) {
            System.out.print(matched[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Your zodiac sign as per vedic astrology : "+ rearrangedSigns[matched[1]-1]+"\n");
        // Creating instances of prediction classes for different aspects of life
        Moles objMoles=new Moles();
        objMoles.Predict(rearrangedSigns, matched);

        PartnerStartingLetters objLettersP=new PartnerStartingLetters();
        objLettersP.Predict(rearrangedSigns,matched);

        LoveLife objLove=new LoveLife();
        objLove.Predict(rearrangedSigns, matched);

        Health objHealth=new Health();
        objHealth.Predict(rearrangedSigns, matched);

        Education objEducation= new Education();
        objEducation.Predict(rearrangedSigns, matched);

        Career objCareer=new Career();
        objCareer.Predict(rearrangedSigns, matched);

        Family objFamily=new Family();
        objFamily.Predict(rearrangedSigns, matched);

        Personality objPersonality=new Personality();
        objPersonality.Predict(rearrangedSigns, matched);

        Dosha objDosha=new Dosha();
        objDosha.Predict(rearrangedSigns, matched);

        Remedies objRemedies=new Remedies();
        objRemedies.Predict(rearrangedSigns, matched);
        
    }
     
    //Method for fetching Co-ordinates from API.
    private Map<String, String> fetchLocationDetails(String cityName) throws IOException, InterruptedException {
        String apiUrl = "https://nominatim.openstreetmap.org/search?format=json&q=" + cityName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Check if the request was successful
        if (response.statusCode() == 200) {
            // Parse the JSON response to get the coordinates
            Scanner scanner = new Scanner(response.body());
            scanner.useDelimiter("\\A");
            String responseBody = scanner.hasNext() ? scanner.next() : "";

            scanner.close();

            // Extract latitude and longitude
            String latitude = null;
            String longitude = null;

            // Parse JSON manually
            int latIndex = responseBody.indexOf("\"lat\":\"");
            if (latIndex != -1) {
                int latStartIndex = latIndex + 7;
                int latEndIndex = responseBody.indexOf("\"", latStartIndex);
                latitude = responseBody.substring(latStartIndex, latEndIndex);
            }

            int lonIndex = responseBody.indexOf("\"lon\":\"");
            if (lonIndex != -1) {
                int lonStartIndex = lonIndex + 7;
                int lonEndIndex = responseBody.indexOf("\"", lonStartIndex);
                longitude = responseBody.substring(lonStartIndex, lonEndIndex);
            }

            if (latitude != null && longitude != null) {

                Map<String, String> locationDetails = new HashMap<>();
                locationDetails.put("latitude", latitude);
                locationDetails.put("longitude", longitude);

                return locationDetails;
            }
        }
        throw new RuntimeException("Failed to fetch location details for the city: " + cityName);
    }

    private List<PlanetSign> planetSigns;
    public List<PlanetSign> getPlanetSigns() {
        return planetSigns;
    }
    
    //Method for decoding the Astro API response
    private static List<PlanetSign> extractPlanetAndSignNames(String data) {
        List<PlanetSign> planetSigns = new ArrayList<>();
        try {
            int index = data.indexOf("\"planet\":\"");
            while (index != -1) {
                index += "\"planet\":\"".length();
                int endIndex = data.indexOf("\"", index);
                String planetName = data.substring(index, endIndex);
    
                int signIndex = data.indexOf("\"sign\":\"", endIndex);
                signIndex += "\"sign\":\"".length();
                int signEndIndex = data.indexOf("\"", signIndex);
                String signName = data.substring(signIndex, signEndIndex);
                // Create a new PlanetSign object and add it to the list
                PlanetSign planetSign = new PlanetSign(planetName, signName);
                planetSigns.add(planetSign);
                index = data.indexOf("\"planet\":\"", signEndIndex);
            }
    
        } catch (Exception e) {
            System.err.println("An error occurred while extracting planet and sign names: " + e.getMessage());
        }
        return planetSigns;
    }
    
    //Method for printing the planets and their signs
    public void printStoredValues(List<PlanetSign> planetSigns) {
        System.out.println("Stored Planet and Sign Names:");
        for (PlanetSign ps : planetSigns) {
            System.out.println("Planet: " + ps.getPlanet() + ", Sign: " + ps.getSign());
        }
    }

      //Method for Assigning signs to houses
    public String[] rearrangeSigns() {
    
        // Create a new array to store rearranged planet and sign names
        String[] rearrangedSigns = new String[12]; // Assuming there are 12 signs
        String[] signs = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
    
        String ascendant = null;
        int index = -1;
        //Copy the ascendant at the first index of the rearrangedSigns array
        for (PlanetSign ps : planetSigns) {
            if (ps.getPlanet().equals("Ascendant")) {
                ascendant = ps.getSign();
                rearrangedSigns[0]= ascendant;
                break; // Stop searching once the Ascendant sign is found
            }
        }
        for (int i=0; i<signs.length; i++){
            if(ascendant.equals(signs[i])){
                index=i;
            }
        }
        for(int j=1, k=index+1; k<12; j++, k++){
            rearrangedSigns[j]= signs[k];
        }
        for(int j=12-index, k=0; k<index; j++, k++){
            rearrangedSigns[j]= signs[k];
        }
        return rearrangedSigns;
    }
    
    //Method for determining positions of planets
    public int[] matchPlanetsToSigns(String[] rearrangedSigns) {
        int[] planetIndexes = new int[planetSigns.size()]; // Assuming planetSigns is initialized elsewhere

        for (int i = 0; i < planetSigns.size(); i++) {
            PlanetSign pSign = planetSigns.get(i);
            String pSignName = pSign.getSign();

            for (int j = 0; j < rearrangedSigns.length; j++) {
                if (pSignName.equals(rearrangedSigns[j])) {
                    planetIndexes[i] = j+1;
                    break; // No need to continue checking once a match is found
                }
            }
        }

        return planetIndexes;
    }
}

public class astromainFinal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your year of birth (yyyy): ");
            int yearOfBirth = scanner.nextInt();

            if (yearOfBirth < 1900 || yearOfBirth > 2024) {
                throw new IllegalArgumentException("Invalid year of birth. Please enter a year between 1900 and 2024.");
            }

            System.out.print("Enter your month of birth (1-12): ");
            int monthOfBirth = scanner.nextInt();

            if (monthOfBirth < 1 || monthOfBirth > 12) {
                throw new IllegalArgumentException("Invalid month of birth. Please enter a month between 1 and 12.");
            }

            System.out.print("Enter your day of birth (1-31): ");
            int dayOfBirth = scanner.nextInt();

            if (dayOfBirth < 1 || dayOfBirth > 31) {
                throw new IllegalArgumentException("Invalid day of birth. Please enter a day between 1 and 31.");
            }

            if ((monthOfBirth == 4 || monthOfBirth == 6 || monthOfBirth == 9 || monthOfBirth == 11) && dayOfBirth > 30) {
                throw new IllegalArgumentException("Invalid day of birth. April, June, September, and November have 30 days.");
            }

            if (monthOfBirth == 2) {
                boolean isLeapYear = (yearOfBirth % 4 == 0 && yearOfBirth % 100 != 0) || (yearOfBirth % 400 == 0);
                if ((isLeapYear && dayOfBirth > 29) || (!isLeapYear && dayOfBirth > 28)) {
                    throw new IllegalArgumentException("Invalid day of birth. February has 28 or 29 days depending on the year.");
                }
            }

            System.out.print("Enter the hour of birth (0-23): ");
            int hourOfBirth = scanner.nextInt();

            if (hourOfBirth < 0 || hourOfBirth > 23) {
                throw new IllegalArgumentException("Invalid hour of birth. Please enter an hour between 0 and 23.");
            }

            System.out.print("Enter the minute of birth (0-59): ");
            int minuteOfBirth = scanner.nextInt();

            if (minuteOfBirth < 0 || minuteOfBirth > 59) {
                throw new IllegalArgumentException("Invalid minute of birth. Please enter a minute between 0 and 59.");
            }

            scanner.nextLine();
            System.out.print("Enter your place of birth: ");
            String placeName = scanner.nextLine();
            System.out.println();

            Astrologer astrologer = new Astrologer();
            astrologer.generatePredictions(name, yearOfBirth, monthOfBirth, dayOfBirth, hourOfBirth, minuteOfBirth, placeName);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}