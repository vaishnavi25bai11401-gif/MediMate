package model;

//create a class to family member
public class FamilyMember 
{

    //input variable
    private int id;
    private String name;
    private int age;
    private String relationship;

    //create constructor
    public FamilyMember
    (
            int id,
            String name,
            int age,
            String relationship
            ) 
            {

        this.id = id;
        this.name = name;
        this.age = age;
        this.relationship = relationship;
    }

    //create getter method
    public int getId()
     {
        return id;
    }

     //get method to return data
    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getRelationship() 
    {
        return relationship;
    }

     // convert details into string
    @Override
    public String toString() 
    {

        return id + " - "
                + name
                + " ("
                + relationship
                + ", Age: "
                + age
                + ")";
    }
}