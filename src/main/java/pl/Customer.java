package main.java.pl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "customer")
    public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        private String firstName;

        private String lastName;
       
        private Integer moneySpended;
        
        private Boolean isRegularCustomer;

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public Integer getMoneySpended() {
			return moneySpended;
		}

		public void setMoneySpended(Integer moneySpended) {
			this.moneySpended = moneySpended;
		}
		
		public Boolean getIsRegularCustomer() {
			return isRegularCustomer;
		}

		public void setIsRegularCustomer(Boolean isRegularCustomer) {
			this.isRegularCustomer = isRegularCustomer;
		}
		
		@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
		public List<Visit> listVisit = new ArrayList<Visit>();
		

    }