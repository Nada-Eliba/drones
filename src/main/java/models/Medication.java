package models;

import java.io.File;

public class Medication {
    String name;
    float weight;
    String code;
    File image;

    /** Valid Regular Expressions **/
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9_-]+$";
    private static final String VALID_CODE_PATTERN = "^[A-Z0-9_]+$";

    /** Constructors **/

    public Medication () {
        // default constructor
        // do nothing
    }

    public Medication (String name,
                       float weight,
                       String code,
                       File image) {
        if (getIsAttributeValid(name, VALID_NAME_PATTERN)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Medication name should contain" +
                    " only letters, numbers, '_', and '-'");
        }

        this.weight = weight;

        if (getIsAttributeValid(code, VALID_CODE_PATTERN)) {
            this.code = code;
        }
        else {
            throw new IllegalArgumentException("Medication code should contain" +
                    " only uppercase letters, numbers, and '_'");
        }

        this.image = image;
    }

    /** Getter Methods **/

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public String getCode() {
        return code;
    }

    public File getImage() {
        return image;
    }

    /** Setter Methods **/
    public void setName(String name) {
        if (getIsAttributeValid(name, VALID_NAME_PATTERN)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Medication name should contain" +
                    " only letters, numbers, '_', and '-'");
        }
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setCode(String code) {
        if (getIsAttributeValid(code, VALID_CODE_PATTERN)) {
            this.code = code;
        }
        else {
            throw new IllegalArgumentException("Medication code should contain" +
                    " only uppercase letters, numbers, and '_'");
        }
    }

    public void setImage(File image) {
        this.image = image;
    }

    /** Validate attributes against their corresponding regex **/

    boolean getIsAttributeValid(String attributeString, String regex) {
        return attributeString.matches(regex);
    }
}
