package phone_;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class PhoneBook extends Phone{
    ArrayList<String> PhoneList = new ArrayList<>();





    @Override
    public void insertPhone(String name, String phone) {
        if (PhoneList.isEmpty()) {
            PhoneList.add(name + "," + phone);

        } else {
            boolean check = false;
            for (String i : PhoneList) {
                if(i.contains(name +',')){

                }



            }


        }
     }

        @Override
        public void removePhone (String name){

        }

        @Override
        public void updatePhone (String name, String oldPhone, String newPhone){

        }

        @Override
        public void searchPhone (String name){

        }

        @Override
        public void sort () {

        }
    }
