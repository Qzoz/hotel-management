/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Quraishi
 */
public class CustomerDetailsPOJO {
        public String customer_id;
        public String customer_name;
        public long customer_mobile;
        public String customer_email;
        public int customer_age;
        public char gender;
        
        public String getGender(){
                if(gender == 'F'){
                        return "Female";
                }
                else{
                        return "Male";
                }
        }
}
