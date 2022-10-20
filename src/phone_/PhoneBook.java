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
                    check  =   true;
                    if(!i.contains(phone)){
                        PhoneList.set(PhoneList.indexOf(i),i+":"+phone);
                    }
                    break;
                }
            }
            if (!check){
                PhoneList.add(name+","+phone);
            }
        }
     }

        @Override
        public void removePhone (String name){
            for (String i: PhoneList
                 )if (i.contains(name+",")){
                PhoneList.remove(i);
                break;

            }

        }

        @Override
        public void updatePhone (String name, String oldPhone, String newPhone){
            for (String i : PhoneList) {
                if (i.contains(name + ",")) {

                    PhoneList.set(PhoneList.indexOf(i),name + ", "+newPhone);
                    break;
                }
            }
        }

        @Override
        public void searchPhone (String name){

        }

        @Override
        public void sort () {

        }
    }
