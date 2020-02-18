import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    public boolean isvalid_streetAddress(String address){
        String addressRegex = "\\d{1,4}\\s\\w.*";
        return (address.matches(addressRegex));
    }
    public boolean isvalid_city (String city){
        String cityRegex= "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
        return (city.matches(cityRegex));
    }
    public boolean isvalid_state (String state){
        List<String> allstates = Arrays.asList("Alabama","AL","Alaska","AK","Arizona","AZ","Arkansas","AR","California","CA","Colorado","CO","Connecticut","CT","Delaware","DE","Florida","FL","Georgia","GA","Hawaii","HI",
                "Idaho","ID","Illinois","IL","Indiana","IN","Iowa","IA","Kansas","KS","Kentucky","KY","Louisiana","LA","Maine","ME","Maryland","MD","Massachusetts","MA","Michigan","MI","Minnesota","MN",
                "Mississippi","MS","Missouri","MO","Montana","MT","Nebraska","NE","Nevada","NV","New Hampshire","NH","New Jersey","NJ","New Mexico","NM","New York","NY","North Carolina","NC",
                "North Dakota","ND","Ohio","OH","Oklahoma","OK","Oregon","OR","Pennsylvania","PA","Rhode Island","RI","South Carolina","SC","South Dakota","SD","Tennessee","TN","Texas","TX",
                "Utah","UT","Vermont","VT","Virginia","VA","Washington","WA","West Virginia","WV","Wisconsin","WI","Wyoming","WY");

        if (allstates.contains(state)) {
            return true;
        }
        return false;

    }
    public boolean isvalid_zipcode (CharSequence zipcode){
        String zipcodeRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(zipcodeRegex);
        Matcher matcher = pattern.matcher(zipcode);
        return(matcher.matches());
    }
    public boolean isvalid_email (String email){
        String emailRegex = "\\w[\\w._]{1,25}@\\w*.(com|edu|net)";
        return(email.matches(emailRegex));

    }
}
