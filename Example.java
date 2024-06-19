import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.time.*;
import java.util.ArrayList;
import javax.swing.table.*;

class Example{
	public static void main(String args[]){
    new ContactMainForm().setVisible(true);
}
}
		
		
//-------------------------------------------------------------------Contact Mainform-------------------------------------------------------------------------------		
class ContactMainForm extends JFrame{
	
	public static ContactList contactList=new ContactList();
	
	    //------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;

    }
    //-------------------VALIDATE SALARY----------------------
    public static boolean isValidSalary(double salary){
        return salary>0;
    }
    // -------------------BIRTHDAY VALIDATION----------------
	public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
					return false;
    }
	
	private AddContactForm addContactForm;
	private ContactMainForm contactMainForm;
	private UpdateContactForm updatecontactForm;
	private SearchContactForm searchcontactForm;
	private DeleteContactForm deletecontactForm;
	private ContactListMenu contactlistmenu;
	private JLabel titleLabel;
	private JLabel subtitleLabel;
	private JButton btnAddContact;
	private JButton btnUpdateContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnListContact;
	private JButton btnExit;
	
	ContactMainForm(){
		setTitle("iFriend Contact Manager");
		setSize(700,520);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,350,520);
		panel1.setBackground(new Color(37,67,54));
		
		titleLabel = new JLabel("iFRIEND Contact Manager");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("",1,25));
        titleLabel.setBounds(0,200,350,30);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);
		
		subtitleLabel = new JLabel("Homepage");
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        subtitleLabel.setFont(new Font("",1,25));
        subtitleLabel.setBounds(0,250,350,30);
        subtitleLabel.setForeground(new Color(183,181,151));
        panel1.add(subtitleLabel);
        
        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(350,0,350,520);
        panel2.setBackground(new Color(107,138,122));
        
		add(panel1);
		add(panel2);
		
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("", 1, 25));
		btnAddContact.setBounds(65, 100, 220, 25);
		btnAddContact.setBackground(new Color(218, 211, 190));
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addContactForm==null){
					addContactForm=new AddContactForm();
					ContactMainForm.this.dispose();
				}
				addContactForm.setVisible(true);
			}
		});
		panel2.add(btnAddContact);
		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("", 1, 25));
		btnUpdateContact.setBounds(65, 160, 220, 25);
		btnUpdateContact.setBackground(new Color(218, 211, 190));
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updatecontactForm==null){
					updatecontactForm=new UpdateContactForm();
					ContactMainForm.this.dispose();
				}
				updatecontactForm.setVisible(true);
			}
		});
		panel2.add(btnUpdateContact);
		
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,25));
		btnSearchContact.setBounds(65, 220, 220, 25); 
        btnSearchContact.setBackground(new Color(218, 211, 190));
        btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(searchcontactForm==null){
					searchcontactForm=new SearchContactForm();
					ContactMainForm.this.dispose();
				}
				searchcontactForm.setVisible(true);
			}
		});
		panel2.add(btnSearchContact);
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,25));
		btnDeleteContact.setBounds(65, 280, 220, 25); 
        btnDeleteContact.setBackground(new Color(218, 211, 190));
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(deletecontactForm==null){
					deletecontactForm=new DeleteContactForm();
					ContactMainForm.this.dispose();
				}
				deletecontactForm.setVisible(true);
			}
		});
		panel2.add(btnDeleteContact);
		
		btnListContact=new JButton("List Contact");
		btnListContact.setFont(new Font("",1,25));
		btnListContact.setBounds(65, 340, 220, 25); 
        btnListContact.setBackground(new Color(218, 211, 190));
        btnListContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactlistmenu==null){
					contactlistmenu=new ContactListMenu();
					ContactMainForm.this.dispose();
				}
				contactlistmenu.setVisible(true);
			}
		});
		panel2.add(btnListContact);
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,25));
		btnExit.setBounds(65, 400, 220, 25); 
        btnExit.setBackground(new Color(218, 211, 190));
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("Exited...");
				System.exit(0);
				}
			});
		panel2.add(btnExit);
		} 
    }
//---------------------------------------------------------------AddContactForm-----------------------------------------------------------------------------------
class AddContactForm extends JFrame{
	
	private ContactMainForm contactMainForm;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnBacktoHome;
	private JLabel titleLabel;
	private JLabel subtitleLabel;
	private JLabel IblId;
	private JLabel IblName;
	private JLabel IblContactNumber;
	private JLabel IblCompany;
	private JLabel IblSalary;
	private JLabel IblBirthday;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	AddContactForm(){
		setSize(700,520);
		setTitle("Add Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("ADD CONTACT");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
		IblId = new JLabel("Contact ID");
		IblId.setFont(new Font("",1,20));
		IblId.setBounds(70, 70, 700, 20);
		panel2.add(IblId);

		IblName = new JLabel("Name");
		IblName.setFont(new Font("",1,20));
		IblName.setBounds(70, 115, 700, 20);
		panel2.add(IblName);

		IblContactNumber = new JLabel("Contact Number");
		IblContactNumber.setFont(new Font("",1,20));
		IblContactNumber.setBounds(70, 160, 700, 20);
		panel2.add(IblContactNumber);
		
		IblCompany = new JLabel("Company");
		IblCompany.setFont(new Font("",1,20));
		IblCompany.setBounds(70, 205, 700, 20);
		panel2.add(IblCompany);

		IblSalary = new JLabel("Salary");
		IblSalary.setFont(new Font("",1,20));
		IblSalary.setBounds(70, 250, 700, 20);
		panel2.add(IblSalary);

		IblBirthday = new JLabel("Birthday");
		IblBirthday.setFont(new Font("",1,20));
		IblBirthday.setBounds(70, 295, 700, 20);
		panel2.add(IblBirthday);
		
		txtId=new JTextField(15);
        txtId.setFont(new Font ("",1,20));
        txtId.setBounds(280, 70, 200, 25);
		txtId.setText(ContactMainForm.contactList.generateId());
		txtId.setEditable(false);
		
        panel2.add(txtId);
        
        txtName=new JTextField(15);
        txtName.setFont(new Font ("",1,20));
        txtName.setBounds(280, 115, 200, 25);
        panel2.add(txtName);
        
        txtContactNumber=new JTextField(15);
        txtContactNumber.setFont(new Font ("",1,20));
        txtContactNumber.setBounds(280, 160, 200, 25);
        panel2.add(txtContactNumber);
        
        txtCompany=new JTextField(15);
        txtCompany.setFont(new Font ("",1,20));
        txtCompany.setBounds(280, 205, 200, 25);
        panel2.add(txtCompany);
        
        txtSalary=new JTextField(15);
        txtSalary.setFont(new Font ("",1,20));
        txtSalary.setBounds(280, 250, 200, 25);
        panel2.add(txtSalary);
        
        txtBirthday=new JTextField(15);
        txtBirthday.setFont(new Font ("",1,20));
        txtBirthday.setBounds(280, 295, 200, 25);
        panel2.add(txtBirthday);
       
		btnAdd = new JButton("Add Contact");
		btnAdd.setFont(new Font("", 1, 20));
		btnAdd.setBounds(280, 360, 170, 25);
		btnAdd.setBackground(new Color(218, 211, 190));
		btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
        try {
            String id = txtId.getText();
            String name = txtName.getText();
            String phoneNumber = txtContactNumber.getText();
            String company = txtCompany.getText();
            String birthday = txtBirthday.getText();
            String salaryStr = txtSalary.getText();

            if (id.isEmpty() || name.isEmpty() || phoneNumber.isEmpty() || company.isEmpty() || birthday.isEmpty() || salaryStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            double salary;
            try {
                salary = Double.parseDouble(salaryStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for salary.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!ContactMainForm.isValidPhoneNumber(phoneNumber)) {
                int option = JOptionPane.showConfirmDialog(null, "Invalid phone number. Do you want to input again?", "Invalid Input", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    txtContactNumber.setText("");
                    return;
                }else if (option==JOptionPane.NO_OPTION){
					
					}
            }
            if (!ContactMainForm.isValidSalary(salary)) {
                int option = JOptionPane.showConfirmDialog(null, "Invalid salary. Do you want to input again?", "Invalid Input", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    txtSalary.setText("");
                    return;
                }
            }
            if (!ContactMainForm.isValidBirthday(birthday)) {
                int option = JOptionPane.showConfirmDialog(null, "Invalid birthday. Do you want to input again?", "Invalid Input", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    txtBirthday.setText("");
                    return;
                }
            }

            Contact contact = new Contact(id, name, phoneNumber, company, salary, birthday);
            ContactMainForm.contactList.add(contact);

           int option = JOptionPane.showConfirmDialog(null, "Contact added successfully. Do you want to add another contact?", "Success", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                txtId.setText(ContactMainForm.contactList.generateId());
                txtName.setText("");
                txtContactNumber.setText("");
                txtCompany.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please re check all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
		panel2.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("", 1, 20));
		btnCancel.setBounds(500, 360, 170, 25);
		btnCancel.setBackground(new Color(218, 211, 190));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					AddContactForm.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnCancel);
		
		btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					AddContactForm.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
	}
    }
    
//-----------------------------------------------------------Update Contact-----------------------------------------------------------------------------------
class UpdateContactForm extends JFrame{
	
	private ContactMainForm contactMainForm;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnBacktoHome;
	private JButton btnSearch;
	
	private JLabel titleLabel;
	private JLabel subtitleLabel;
	private JLabel IblId;
	private JLabel IblName;
	private JLabel IblContactNumber;
	private JLabel IblCompany;
	private JLabel IblSalary;
	private JLabel IblBirthday;
	
	private JTextField txtSearching;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	UpdateContactForm(){
		setSize(700,520);
		setTitle("Update Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("UPDATE CONTACT");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
        txtSearching=new JTextField(15);
        txtSearching.setFont(new Font ("",1,20));
        txtSearching.setBounds(200, 25, 250, 25);
        panel2.add(txtSearching);
        
        btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("", 1, 20));
		btnSearch.setBounds(460, 25, 130, 25);
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrphone=txtSearching.getText();
				int index=ContactMainForm.contactList.searchByNameOrPhoneNumber(nameOrphone);
				if(txtSearching.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Text Field is empty");
				}else if(index!=-1){
					txtId.setText(contactMainForm.contactList.get(index).getId());
					txtName.setText(contactMainForm.contactList.get(index).getName());
					txtContactNumber.setText(contactMainForm.contactList.get(index).getphoneNumber());
					txtCompany.setText(contactMainForm.contactList.get(index).getcompanyName());
					txtSalary.setText(String.valueOf(contactMainForm.contactList.get(index).getSalary()));
					txtBirthday.setText(contactMainForm.contactList.get(index).getBirthday());
				}else{
					JOptionPane.showMessageDialog(null,"No contact found for "+nameOrphone);
				}
				int option=JOptionPane.showConfirmDialog(null,"Do you want to search contact again ? ","Confirm",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION){
					txtSearching.setText("");
					txtSearching.requestFocus();
					txtId.setText("");
					txtName.setText("");
					txtContactNumber.setText("");
					txtCompany.setText("");
					txtSalary.setText("");
					txtBirthday.setText("");
				}
			} 
		});
		btnSearch.setBackground(new Color(218, 211, 190));
		panel2.add(btnSearch);
		
		IblId = new JLabel("Contact ID");
		IblId.setFont(new Font("",1,20));
		IblId.setBounds(70, 70, 700, 20);
		panel2.add(IblId);

		IblName = new JLabel("Name");
		IblName.setFont(new Font("",1,20));
		IblName.setBounds(70, 115, 700, 20);
		panel2.add(IblName);

		IblContactNumber = new JLabel("Contact Number");
		IblContactNumber.setFont(new Font("",1,20));
		IblContactNumber.setBounds(70, 160, 700, 20);
		panel2.add(IblContactNumber);

		IblCompany = new JLabel("Company");
		IblCompany.setFont(new Font("",1,20));
		IblCompany.setBounds(70, 205, 700, 20);
		panel2.add(IblCompany);

		IblSalary = new JLabel("Salary");
		IblSalary.setFont(new Font("",1,20));
		IblSalary.setBounds(70, 250, 700, 20);
		panel2.add(IblSalary);

		IblBirthday = new JLabel("Birthday");
		IblBirthday.setFont(new Font("",1,20));
		IblBirthday.setBounds(70, 295, 700, 20);
		panel2.add(IblBirthday);
		
		txtId=new JTextField(15);
        txtId.setFont(new Font ("",1,20));
        txtId.setBounds(280, 70, 200, 25);
        panel2.add(txtId);
        txtId.setEditable(false);
        
        txtName=new JTextField(15);
        txtName.setFont(new Font ("",1,20));
        txtName.setBounds(280, 115, 200, 25);
        panel2.add(txtName);
        
        txtContactNumber=new JTextField(15);
        txtContactNumber.setFont(new Font ("",1,20));
        txtContactNumber.setBounds(280, 160, 200, 25);
        panel2.add(txtContactNumber);
        
        txtCompany=new JTextField(15);
        txtCompany.setFont(new Font ("",1,20));
        txtCompany.setBounds(280, 205, 200, 25);
        panel2.add(txtCompany);
        
        txtSalary=new JTextField(15);
        txtSalary.setFont(new Font ("",1,20));
        txtSalary.setBounds(280, 250, 200, 25);
        panel2.add(txtSalary);
        
        txtBirthday=new JTextField(15);
        txtBirthday.setFont(new Font ("",1,20));
        txtBirthday.setBounds(280, 295, 200, 25);
        panel2.add(txtBirthday);
       
		btnAdd = new JButton("Update Contact");
		btnAdd.setFont(new Font("", 1, 20));
		btnAdd.setBounds(280, 360, 180, 25);
		btnAdd.setBackground(new Color(218, 211, 190));
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrphone=txtSearching.getText();
				int index=ContactMainForm.contactList.searchByNameOrPhoneNumber(nameOrphone);
				String newName =txtName.getText();  
				ContactMainForm.contactList.updateName(index,newName);
				String newPhone=txtContactNumber.getText();
				ContactMainForm.contactList.updatePhoneNumber(index,newPhone);
				String newCompany=txtCompany.getText();
				ContactMainForm.contactList.updateCompanyName(index,newCompany);
				double newSalary=Double.parseDouble(txtSalary.getText());
				ContactMainForm.contactList.updateSalary(index,newSalary);
				JOptionPane.showMessageDialog(null, "Contact updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		panel2.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("", 1, 20));
		btnCancel.setBounds(500, 360, 170, 25);
		btnCancel.setBackground(new Color(218, 211, 190));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					UpdateContactForm.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnCancel);
		
		btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					UpdateContactForm.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
	}
    }
    
//-------------------------------------------------------Search Contact--------------------------------------------------------------------------------
class SearchContactForm extends JFrame{
	
	private ContactMainForm contactMainForm;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnBacktoHome;
	private JButton btnSearch;
	
	private JLabel titleLabel;
	private JLabel subtitleLabel;
	private JLabel IblId;
	private JLabel IblName;
	private JLabel IblContactNumber;
	private JLabel IblCompany;
	private JLabel IblSalary;
	private JLabel IblBirthday;
	
	private JTextField txtSearching;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	SearchContactForm(){
		setSize(700,520);
		setTitle("Search Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("SEARCH CONTACT");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
        txtSearching=new JTextField(15);
        txtSearching.setFont(new Font ("",1,20));
        txtSearching.setBounds(200, 25, 250, 25);
        panel2.add(txtSearching);
        
        btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("", 1, 20));
		btnSearch.setBounds(460, 25, 130, 25);
		btnSearch.setBackground(new Color(218, 211, 190));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrphone=txtSearching.getText();
				int index=ContactMainForm.contactList.searchByNameOrPhoneNumber(nameOrphone);
				if(txtSearching.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Text Field is empty");
				}else if(index!=-1){
					txtId.setText(contactMainForm.contactList.get(index).getId());
					txtName.setText(contactMainForm.contactList.get(index).getName());
					txtContactNumber.setText(contactMainForm.contactList.get(index).getphoneNumber());
					txtCompany.setText(contactMainForm.contactList.get(index).getcompanyName());
					txtSalary.setText(String.valueOf(contactMainForm.contactList.get(index).getSalary()));
					txtBirthday.setText(contactMainForm.contactList.get(index).getBirthday());
				}else{
					JOptionPane.showMessageDialog(null,"No contact found for "+nameOrphone);
				}
				int option=JOptionPane.showConfirmDialog(null,"Do you want to search contact again ? ","Confirm",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION){
					txtSearching.setText("");
					txtSearching.requestFocus();
					txtId.setText("");
					txtName.setText("");
					txtContactNumber.setText("");
					txtCompany.setText("");
					txtSalary.setText("");
					txtBirthday.setText("");
				}
			}
		});
		panel2.add(btnSearch);
		
		IblId = new JLabel("Contact ID");
		IblId.setFont(new Font("",1,20));
		IblId.setBounds(70, 70, 700, 20);
		panel2.add(IblId);

		IblName = new JLabel("Name");
		IblName.setFont(new Font("",1,20));
		IblName.setBounds(70, 115, 700, 20);
		panel2.add(IblName);

		IblContactNumber = new JLabel("Contact Number");
		IblContactNumber.setFont(new Font("",1,20));
		IblContactNumber.setBounds(70, 160, 700, 20);
		panel2.add(IblContactNumber);

		IblCompany = new JLabel("Company");
		IblCompany.setFont(new Font("",1,20));
		IblCompany.setBounds(70, 205, 700, 20);
		panel2.add(IblCompany);

		IblSalary = new JLabel("Salary");
		IblSalary.setFont(new Font("",1,20));
		IblSalary.setBounds(70, 250, 700, 20);
		panel2.add(IblSalary);

		IblBirthday = new JLabel("Birthday");
		IblBirthday.setFont(new Font("",1,20));
		IblBirthday.setBounds(70, 295, 700, 20);
		panel2.add(IblBirthday);
		
		txtId=new JTextField(15);
        txtId.setFont(new Font ("",1,20));
        txtId.setBounds(280, 70, 200, 25);
        panel2.add(txtId);
        
        txtName=new JTextField(15);
        txtName.setFont(new Font ("",1,20));
        txtName.setBounds(280, 115, 200, 25);
        panel2.add(txtName);
        
        txtContactNumber=new JTextField(15);
        txtContactNumber.setFont(new Font ("",1,20));
        txtContactNumber.setBounds(280, 160, 200, 25);
        panel2.add(txtContactNumber);
        
        txtCompany=new JTextField(15);
        txtCompany.setFont(new Font ("",1,20));
        txtCompany.setBounds(280, 205, 200, 25);
        panel2.add(txtCompany);
        
        txtSalary=new JTextField(15);
        txtSalary.setFont(new Font ("",1,20));
        txtSalary.setBounds(280, 250, 200, 25);
        panel2.add(txtSalary);
        
        txtBirthday=new JTextField(15);
        txtBirthday.setFont(new Font ("",1,20));
        txtBirthday.setBounds(280, 295, 200, 25);
        panel2.add(txtBirthday);
       
		btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					SearchContactForm.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
	}
}

//---------------------------------------------------------DeleteContact--------------------------------------------------------------------
class DeleteContactForm extends JFrame{
	
	private ContactMainForm contactMainForm;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnBacktoHome;
	private JButton btnSearch;
	
	private JLabel titleLabel;
	private JLabel subtitleLabel;
	private JLabel IblId;
	private JLabel IblName;
	private JLabel IblContactNumber;
	private JLabel IblCompany;
	private JLabel IblSalary;
	private JLabel IblBirthday;
	
	private JTextField txtSearching;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	DeleteContactForm(){
		setSize(700,520);
		setTitle("Update Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("DELETE CONTACT");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
        txtSearching=new JTextField(15);
        txtSearching.setFont(new Font ("",1,20));
        txtSearching.setBounds(200, 25, 250, 25);
        panel2.add(txtSearching);
        
        btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("", 1, 20));
		btnSearch.setBounds(460, 25, 130, 25);
		btnSearch.setBackground(new Color(218, 211, 190));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrphone=txtSearching.getText();
				int index=ContactMainForm.contactList.searchByNameOrPhoneNumber(nameOrphone);
				if(txtSearching.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Text Field is empty");
				}else if(index!=-1){
					txtId.setText(contactMainForm.contactList.get(index).getId());
					txtName.setText(contactMainForm.contactList.get(index).getName());
					txtContactNumber.setText(contactMainForm.contactList.get(index).getphoneNumber());
					txtCompany.setText(contactMainForm.contactList.get(index).getcompanyName());
					txtSalary.setText(String.valueOf(contactMainForm.contactList.get(index).getSalary()));
					txtBirthday.setText(contactMainForm.contactList.get(index).getBirthday());
				}else{
					JOptionPane.showMessageDialog(null,"No contact found for "+nameOrphone);
				}
				int option=JOptionPane.showConfirmDialog(null,"Do you want to search contact again ? ","Confirm",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION){
					txtSearching.setText("");
					txtSearching.requestFocus();
					txtId.setText("");
					txtName.setText("");
					txtContactNumber.setText("");
					txtCompany.setText("");
					txtSalary.setText("");
					txtBirthday.setText("");
				}
			}
		});
		panel2.add(btnSearch);
		
		IblId = new JLabel("Contact ID");
		IblId.setFont(new Font("",1,20));
		IblId.setBounds(70, 70, 700, 20);
		panel2.add(IblId);

		IblName = new JLabel("Name");
		IblName.setFont(new Font("",1,20));
		IblName.setBounds(70, 115, 700, 20);
		panel2.add(IblName);

		IblContactNumber = new JLabel("Contact Number");
		IblContactNumber.setFont(new Font("",1,20));
		IblContactNumber.setBounds(70, 160, 700, 20);
		panel2.add(IblContactNumber);

		IblCompany = new JLabel("Company");
		IblCompany.setFont(new Font("",1,20));
		IblCompany.setBounds(70, 205, 700, 20);
		panel2.add(IblCompany);

		IblSalary = new JLabel("Salary");
		IblSalary.setFont(new Font("",1,20));
		IblSalary.setBounds(70, 250, 700, 20);
		panel2.add(IblSalary);

		IblBirthday = new JLabel("Birthday");
		IblBirthday.setFont(new Font("",1,20));
		IblBirthday.setBounds(70, 295, 700, 20);
		panel2.add(IblBirthday);
		
		txtId=new JTextField(15);
        txtId.setFont(new Font ("",1,20));
        txtId.setBounds(280, 70, 200, 25);
        panel2.add(txtId);
        
        txtName=new JTextField(15);
        txtName.setFont(new Font ("",1,20));
        txtName.setBounds(280, 115, 200, 25);
        panel2.add(txtName);
        
        txtContactNumber=new JTextField(15);
        txtContactNumber.setFont(new Font ("",1,20));
        txtContactNumber.setBounds(280, 160, 200, 25);
        panel2.add(txtContactNumber);
        
        txtCompany=new JTextField(15);
        txtCompany.setFont(new Font ("",1,20));
        txtCompany.setBounds(280, 205, 200, 25);
        panel2.add(txtCompany);
        
        txtSalary=new JTextField(15);
        txtSalary.setFont(new Font ("",1,20));
        txtSalary.setBounds(280, 250, 200, 25);
        panel2.add(txtSalary);
        
        txtBirthday=new JTextField(15);
        txtBirthday.setFont(new Font ("",1,20));
        txtBirthday.setBounds(280, 295, 200, 25);
        panel2.add(txtBirthday);
       
		btnAdd = new JButton("Delete Contact");
		btnAdd.setFont(new Font("", 1, 20));
		btnAdd.setBounds(280, 360, 180, 25);
		btnAdd.setBackground(new Color(218, 211, 190));
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrphone=txtSearching.getText();
				int option=JOptionPane.showConfirmDialog(null,"Do you want to Delete this contact ? ","Confirm",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION){
				int index=ContactMainForm.contactList.searchByNameOrPhoneNumber(nameOrphone);
				ContactMainForm.contactList.delete(index);
				JOptionPane.showMessageDialog(null,"Contact deleted successfully");
			}
				}
			});
		panel2.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("", 1, 20));
		btnCancel.setBounds(500, 360, 170, 25);
		btnCancel.setBackground(new Color(218, 211, 190));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					DeleteContactForm.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnCancel);
		
		btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					DeleteContactForm.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
	}
}
//------------------------------------------------------------List Menu--------------------------------------------------------------------------------------
class ContactListMenu extends JFrame{
	
	private ContactMainForm contactMainForm;
	private SortByName sortbyname;
	private SortBySalary sortbysalary;
	private SortByBirthday sortbybirthday;
	
	private JLabel titleLabel;
	private JButton btnlbname;
	private JButton btnlbsalary;
	private JButton btnlbbirthday;
	private JButton btnBacktoHome;
	ContactListMenu(){
		setSize(700,520);
		setTitle("List Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("LIST CONTACT");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
        btnlbname=new JButton("List By name");
        btnlbname.setFont(new Font("",1,30));
        btnlbname.setBounds(200,100,300,35);
        btnlbname.setBackground(new Color(218,211,190));
        btnlbname.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortbyname==null){
					sortbyname=new SortByName();
					ContactListMenu.this.dispose();
				}
				sortbyname.setVisible(true);
			}
		});
        panel2.add(btnlbname);
        
        btnlbsalary=new JButton("List By Salary");
        btnlbsalary.setFont(new Font("",1,30));
        btnlbsalary.setBounds(200,180,300,35);
        btnlbsalary.setBackground(new Color(218,211,190));
        btnlbsalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortbysalary==null){
					sortbysalary=new SortBySalary();
					ContactListMenu.this.dispose();
				}
				sortbysalary.setVisible(true);
			}
		});
        panel2.add(btnlbsalary);
        
        btnlbbirthday=new JButton("List By Birthday");
        btnlbbirthday.setFont(new Font("",1,30));
        btnlbbirthday.setBounds(200,260,300,35);
        btnlbbirthday.setBackground(new Color(218,211,190));
         btnlbbirthday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortbybirthday==null){
					sortbybirthday=new SortByBirthday();
					ContactListMenu.this.dispose();
				}
				sortbybirthday.setVisible(true);
			}
		});
        panel2.add(btnlbbirthday);
        
        btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					ContactListMenu.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
		}
	}
//-----------------------------------------------------------------------SORT BY NAME------------------------------------------------------------------------
class SortByName extends JFrame{
	
	private ContactMainForm contactMainForm;
	private ContactListMenu contactlistmenu;
	
	private JTable contactsTable;
	private DefaultTableModel dtm;
	
	private JLabel titleLabel;
	private JButton btnlbname;
	private JButton btnlbsalary;
	private JButton btnlbbirthday;
	private JButton btnBacktoHome;
	private JButton btnBacktoListMenu;
	private JButton btnReload;
	
	SortByName(){
		setSize(700,520);
		setTitle("Sort By Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("SORT BY NAME");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
        String [] columnNames={"Id","Name","Phone Number","Company Name","Salary","Birthday"};
        dtm=new DefaultTableModel(columnNames,0);
        contactsTable=new JTable(dtm);
        
        JScrollPane tablePane=new JScrollPane(contactsTable);
        tablePane.setBounds(0,30,700,300);
        tablePane.setBackground(new Color(248,205,248));
        panel2.add(tablePane);
        
        btnReload=new JButton("Reload");
        btnReload.setFont(new Font("",1,20));
		btnReload.setBounds(50,360, 200, 25);
		btnReload.setBackground(new Color(218, 211, 190));
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactMainForm.contactList.sortingByName();
				dtm.setRowCount(0);
				for(int i=0;i<ContactMainForm.contactList.getSize();i++){
					Contact contact = ContactMainForm.contactList.get(i);
					Object[] rowData={contact.getId(),contact.getName(),contact.getphoneNumber(),contact.getcompanyName(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData);
					}
				}
			});
        panel2.add(btnReload);
        
        btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					SortByName.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
		
		btnBacktoListMenu = new JButton("Back to list menu");
		btnBacktoListMenu.setFont(new Font("", 1, 20));
		btnBacktoListMenu.setBounds(370, 360, 200, 25);
		btnBacktoListMenu.setBackground(new Color(218, 211, 190));
		btnBacktoListMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					SortByName.this.dispose();
					contactlistmenu=new ContactListMenu();
				}
				contactlistmenu.setVisible(true);
			}
		});
		panel2.add(btnBacktoListMenu);
		
		}
	}
//-----------------------------------------------------------------------SORT BY SALARY------------------------------------------------------------------------
class SortBySalary extends JFrame{
	
	private ContactMainForm contactMainForm;
	private ContactListMenu contactlistmenu;
	
	private JTable contactsTable;
	private DefaultTableModel dtm;
	
	private JLabel titleLabel;
	private JButton btnlbname;
	private JButton btnlbsalary;
	private JButton btnlbbirthday;
	private JButton btnBacktoHome;
	private JButton btnBacktoListMenu;
	private JButton btnReload;
	
	SortBySalary(){
		setSize(700,520);
		setTitle("Sort By Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("SORT BY SALARY");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
        btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					SortBySalary.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
		
		btnBacktoListMenu = new JButton("Back to list menu");
		btnBacktoListMenu.setFont(new Font("", 1, 20));
		btnBacktoListMenu.setBounds(370, 360, 200, 25);
		btnBacktoListMenu.setBackground(new Color(218, 211, 190));
		btnBacktoListMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					SortBySalary.this.dispose();
					contactlistmenu=new ContactListMenu();
				}
				contactlistmenu.setVisible(true);
			}
		});
		panel2.add(btnBacktoListMenu);
		
		String [] columnNames={"Id","Name","Phone Number","Company Name","Salary","Birthday"};
        dtm=new DefaultTableModel(columnNames,0);
        contactsTable=new JTable(dtm);
        
        JScrollPane tablePane=new JScrollPane(contactsTable);
        tablePane.setBounds(0,30,700,300);
        tablePane.setBackground(new Color(248,205,248));
        panel2.add(tablePane);
        
        btnReload=new JButton("Reload");
        btnReload.setFont(new Font("",1,20));
		btnReload.setBounds(50,360, 200, 25);
		btnReload.setBackground(new Color(218, 211, 190));
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactMainForm.contactList.sortingBySalary();
				dtm.setRowCount(0);
				for(int i=0;i<ContactMainForm.contactList.getSize();i++){
					Contact contact = ContactMainForm.contactList.get(i);
					Object[] rowData={contact.getId(),contact.getName(),contact.getphoneNumber(),contact.getcompanyName(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData);
					}
				}
			});
        panel2.add(btnReload);
		
		}
	}

//-----------------------------------------------------------------------SORT BY BIRTHDAY------------------------------------------------------------------------
class SortByBirthday extends JFrame{
	
	private ContactMainForm contactMainForm;
	private ContactListMenu contactlistmenu;
	
	private JTable contactsTable;
	private DefaultTableModel dtm;
	
	private JLabel titleLabel;
	private JButton btnlbname;
	private JButton btnlbsalary;
	private JButton btnlbbirthday;
	private JButton btnBacktoHome;
	private JButton btnBacktoListMenu;
	private JButton btnReload;
	
	SortByBirthday(){
		setSize(700,520);
		setTitle("Sort By Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	    
	    JPanel panel1=new JPanel();
	    panel1.setLayout(null);
	    panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(37,67,54));
	    
	    titleLabel = new JLabel("SORT BY BIRTHDAY");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(220,10,700,35);
        titleLabel.setForeground(new Color(183,181,151));
        panel1.add(titleLabel);

		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(107,138,122));
        
        add(panel1);
        add(panel2);
        
        btnBacktoHome = new JButton("Back To HomePage");
		btnBacktoHome.setFont(new Font("", 1, 20));
		btnBacktoHome.setBounds(280, 400, 390, 25);
		btnBacktoHome.setBackground(new Color(218, 211, 190));
		btnBacktoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					SortByBirthday.this.dispose();
					contactMainForm=new ContactMainForm();
				}
				contactMainForm.setVisible(true);
			}
		});
		panel2.add(btnBacktoHome);
		
		btnBacktoListMenu = new JButton("Back to list menu");
		btnBacktoListMenu.setFont(new Font("", 1, 20));
		btnBacktoListMenu.setBounds(370, 360, 200, 25);
		btnBacktoListMenu.setBackground(new Color(218, 211, 190));
		btnBacktoListMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contactMainForm==null){
					SortByBirthday.this.dispose();
					contactlistmenu=new ContactListMenu();
				}
				contactlistmenu.setVisible(true);
			}
		});
		panel2.add(btnBacktoListMenu);
		
		String [] columnNames={"Id","Name","Phone Number","Company Name","Salary","Birthday"};
        dtm=new DefaultTableModel(columnNames,0);
        contactsTable=new JTable(dtm);
        
        JScrollPane tablePane=new JScrollPane(contactsTable);
        tablePane.setBounds(0,30,700,300);
        tablePane.setBackground(new Color(248,205,248));
        panel2.add(tablePane);
        
        btnReload=new JButton("Reload");
        btnReload.setFont(new Font("",1,20));
		btnReload.setBounds(50,360, 200, 25);
		btnReload.setBackground(new Color(218, 211, 190));
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactMainForm.contactList.sortingByBirthday();
				dtm.setRowCount(0);
				for(int i=0;i<ContactMainForm.contactList.getSize();i++){
					Contact contact = ContactMainForm.contactList.get(i);
					Object[] rowData={contact.getId(),contact.getName(),contact.getphoneNumber(),contact.getcompanyName(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData);
					}
				}
			});
        panel2.add(btnReload);
		
		}
	}

//===========================================================================================================================================================
    class Contact{
	private String id;
	private String name;
	private String phoneNumber;
	private String companyName;
	private double salary;
	private String birthday;
	
	public Contact(String id,String name,String phoneNumber,String companyName,double salary,String birthday){
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.companyName=companyName;
		this.salary=salary;
		this.birthday=birthday;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setphoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	public void setcompanyName(String companyName){
		this.companyName=companyName;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public void setBirthday(String birthday){
		this.birthday=birthday;
	}
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getphoneNumber(){
		return phoneNumber;
	}
	public String getcompanyName(){
		return companyName;
	}
	public double getSalary(){
		return salary;
	}
	public String getBirthday(){
		return birthday;
	}
}
class ContactList{
    private Node start;
    private boolean isEmpty(){
		return start==null;
    }
    //-------------------GET SIZE-----------------------------------------------------------------
     public int getSize(){
        Node temp=start;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    private boolean isValidIndex(int index){
        return index>=0 && index<=getSize();
    }
    //-------------------GENERATE ID--------------------------------------------------------------
    public  String generateId(){
		if(getSize()==0){
			return "C0001";
		}else{
			return String.format("C%04d",(getSize()+1));
		}
	}
    //----------------------------------ADD CONTACT-------------------------------------------------
    public void add(Contact contact){
        Node n1=new Node(contact);
        Node lastNode=start;
        if(isEmpty()){
            start=n1;
        }else{
            while(lastNode.next!=null){
                lastNode=lastNode.next;
            }
            lastNode.next=n1;
        }
    }
     public Contact get(int index){
        if(isValidIndex(index)){
            if(index==0){
                return start.contact;
            }else{
                Node temp=start;
                for(int i=0; i<index; i++){
                    temp=temp.next;
                }
                return temp.contact;
            }
        }
        return null;
	}
    //-----------------------------------SEARCH CONTACT---------------------------------------------
   public int searchByNameOrPhoneNumber(String nameOrPhone){
       Node temp=start;
       int index=0;
       while(temp!=null){
        if(temp.contact.getName().equals(nameOrPhone)||temp.contact.getphoneNumber().equals(nameOrPhone)){
            return index;
        }
        temp=temp.next;
        index++;
       }
       return -1;
    }
		 
    //-----------------------------------UPDATE NAME-------------------------------------------------
    public void updateName(int index,String name){
		if (isValidIndex(index)) {
        Node temp=start;
        for (int i=0; i<index; i++) {
            temp=temp.next;
        }
        temp.contact.setName(name);
    }
	}
	//-----------------------------------UPDATE PHONENUMBER------------------------------------------
	public void updatePhoneNumber(int index,String phoneNumber){
		 if (isValidIndex(index)) {
        Node temp=start;
        for (int i=0; i<index;i++) {
            temp=temp.next;
        }
        temp.contact.setphoneNumber(phoneNumber);
    }
	}
	//-----------------------------------UPDATE COMPANYNAME------------------------------------------
	public void updateCompanyName(int index,String companyName){
		 if (isValidIndex(index)) {
        Node temp=start;
        for (int i=0;i<index;i++) {
            temp=temp.next;
        }
        temp.contact.setcompanyName(companyName);
    }
	}
	//-----------------------------------UPDATE SALARY------------------------------------------------
	public void updateSalary(int index,double salary){
		 if (isValidIndex(index)) {
        Node temp=start;
        for (int i=0; i<index;i++) {
            temp=temp.next;
        }
        temp.contact.setSalary(salary);
    }
	}
	//-----------------------------------DELETE CONTACT----------------------------------------------
	public void delete(int index){
		if(index>=0 && index<getSize()){
			if(index==0){
				start=start.next;
			}else{
				int count=0;
				Node temp=start;
				while(count<index-1){
					temp=temp.next;
					count++;
				}
				temp.next=temp.next.next;
			}
		}
    }
    //------------------------------------BIRTHDAY SORT-----------------------------------------------------
     public void sortingByBirthday(){
        Node temp=start, index=null;
        if(start==null){
            return;
        }else{
            while(temp!=null){
                index=temp.next;

                while(index!=null){
                    if(temp.contact.getBirthday().compareTo(index.contact.getBirthday())>0){
                        Contact tempContacts=temp.contact;
                        temp.contact=index.contact;
                        index.contact=tempContacts;
                    }
                    index=index.next;
                }
                temp=temp.next;
            }
        }

        for(int i=0; i<getSize(); i++) {
            System.out.printf("|%-14s|%-15s|%-19s|%-15s|%-15.2f|%-16s|",get(i).getId(),get(i).getName(),get(i).getphoneNumber(),get(i).getcompanyName(),get(i).getSalary(),get(i).getBirthday());
			System.out.println();
        }
        
        }
    //-----------------------------------SALARY SORT----------------------------------------------------
    public void sortingBySalary(){
        Node temp=start, index=null;
        if(start==null){
            return;
        }else{
            while(temp!=null){
                index=temp.next;

                while(index!=null){
                    if(temp.contact.getSalary()>index.contact.getSalary()){
                        Contact tempContacts=temp.contact;
                        temp.contact=index.contact;
                        index.contact=tempContacts;
                    }
                    index=index.next;
                }
                temp=temp.next;
            }
        }

        for(int i=0; i<getSize(); i++) {
            System.out.printf("|%-14s|%-15s|%-19s|%-15s|%-15.2f|%-16s|",get(i).getId(),get(i).getName(),get(i).getphoneNumber(),get(i).getcompanyName(),get(i).getSalary(),get(i).getBirthday());
        System.out.println();
        }
	}
	//-------------------------------------NAME SORT-----------------------------------------------------
	public void sortingByName(){
        Node temp=start, index=null;
        if(start==null){
            return;
        }else{
            while(temp!=null){
                index=temp.next;

                while(index!=null){
                    if(temp.contact.getName().compareTo(index.contact.getName())>0){
                        Contact tempContacts=temp.contact;
                        temp.contact=index.contact;
                        index.contact=tempContacts;
                    }
                    index=index.next;
                }
                temp=temp.next;
            }
        }
	}

    
	class Node{
	private Contact contact;
	private Node next;
	Node(Contact contact){
		this.contact=contact;
		}
	}
}



