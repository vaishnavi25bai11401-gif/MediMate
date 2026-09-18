package service;

import model.FamilyMember;

import java.util.ArrayList;

//create class to store family member data
public class FamilyServices 
{

//arraylist for family member
    private ArrayList<FamilyMember> members;

//variable for member id
    private int nextId;


//create constructor
    public FamilyServices() 
    {

        members = new ArrayList<>();

        nextId = 1;
    }
        //add member
    public FamilyMember addMember
    (
            String name,
            int age,
            String relationship
            ) 
            {
    
           //create member abject
        FamilyMember member =
                new FamilyMember
                (
                        nextId,
                        name,
                        age,
                        relationship
                );
     
           //add member to arraylist
        members.add(member);

        nextId++;

        return member;
    }

      //get method to return data of family member
    public ArrayList<FamilyMember> getMembers() 
    {

        return members;
    }

     //search member by id
    public FamilyMember findMember(int id) 
    {

        for (FamilyMember member : members) 
        {

             //check if member id matches
            if (member.getId() == id) 
            {

                return member;
            }
        }
     
         //return null if member not found
        return null;
    }
}