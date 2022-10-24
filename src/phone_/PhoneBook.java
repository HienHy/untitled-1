package phone_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook extends Phone{
ArrayList<PhoneNumber> phoneList = new ArrayList<>();

    public ArrayList<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    @Override
    public void insertPhone(String name, String phone) {
        for (PhoneNumber p: getPhoneList()){
            if (p.getName().equals(name)){
            for (String s: p.getTel()){
                if (s.equals(phone))
                {
                     return;
                }

            }
            p.getTel().add(phone);
            return;

        }
//
//
     }
     PhoneNumber pn = new PhoneNumber(name,phone);
        getPhoneList().add(pn);
    }

        @Override
        public void removePhone (String name){
            for (PhoneNumber p : getPhoneList()) {
                if (p.getName().equals(name)){
                    getPhoneList().remove(p);
                    return;

                }

            }


        }

        @Override
        public void updatePhone (String name, String oldPhone, String newPhone){
           for (PhoneNumber p : getPhoneList()){
               if (p.getName().equals(name)){
                   p.getTel().remove(oldPhone);
                   p.getTel().add(newPhone);
                   return;
               }
           }
        }

        @Override
        public PhoneNumber searchPhone (String name){
        for (PhoneNumber p : getPhoneList()){
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;

        }

        @Override
        public void sort () {
            Collections.sort(getPhoneList(), new Comparator<PhoneNumber>() {
                @Override
                public int compare(PhoneNumber o1, PhoneNumber o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });




        }
    }
